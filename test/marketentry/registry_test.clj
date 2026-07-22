(ns marketentry.registry-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.registry :as registry]))

(deftest engagement-fee-recompute
  (let [e {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12 :claimed-fee 860000.0}]
    (is (== 860000.0 (registry/compute-engagement-fee e)))
    (is (true? (registry/engagement-fee-matches-claim? e))))
  (let [bad {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12 :claimed-fee 999000.0}]
    (is (false? (registry/engagement-fee-matches-claim? bad)))))

(deftest register-draft-and-submit
  (let [d (registry/register-draft "eng-1" "PLW" 0)
        s (registry/register-submit "eng-1" "PLW" 0)]
    (is (= "PLW-DFT-000000" (get d "draft_number")))
    (is (= "PLW-SUB-000000" (get s "submit_number")))
    (is (nil? (get-in d ["certificate" "proof"])))
    (is (= "draft-unsigned" (get-in s ["certificate" "status"])))))

(deftest register-requires-ids
  (is (thrown? Exception (registry/register-draft "" "PLW" 0)))
  (is (thrown? Exception (registry/register-submit "eng-1" "" 0))))

(deftest reserved-sector-tier-lookup
  (testing "§105(a) partial-reservation sectors"
    (is (= :partial-reservation (registry/reserved-sector-tier :handicraft-or-gift-shop)))
    (is (= :partial-reservation (registry/reserved-sector-tier :bakery)))
    (is (= :partial-reservation (registry/reserved-sector-tier :standalone-bar-service)))
    (is (= :partial-reservation (registry/reserved-sector-tier :competing-domestic-manufacturing)))
    (is (= :partial-reservation (registry/reserved-sector-tier :tourism-equipment-rental)))
    (is (= :partial-reservation (registry/reserved-sector-tier :farm-raised-fish-or-mariculture))))
  (testing "§105(b) full-reservation sectors"
    (is (= :full-reservation (registry/reserved-sector-tier :wholesale-or-retail-sale-of-goods)))
    (is (= :full-reservation (registry/reserved-sector-tier :land-transportation-services)))
    (is (= :full-reservation (registry/reserved-sector-tier :water-transportation-services)))
    (is (= :full-reservation (registry/reserved-sector-tier :travel-or-tour-agency)))
    (is (= :full-reservation (registry/reserved-sector-tier :non-highly-migratory-commercial-fishing))))
  (testing "a sector named in neither list is honestly nil, not a fabricated third tier"
    (is (nil? (registry/reserved-sector-tier :unrestricted-services)))
    (is (nil? (registry/reserved-sector-tier :software-development)))))

(deftest reserved-sector-eligible-partial-tier
  (testing "§105(a): at least one citizen owner is sufficient, ALL-owners not required"
    (is (true? (registry/reserved-sector-eligible? :bakery true false)))
    (is (false? (registry/reserved-sector-eligible? :bakery false false)))))

(deftest reserved-sector-eligible-full-tier
  (testing "§105(b): only an ALL-citizen-owned enterprise is eligible"
    (is (true? (registry/reserved-sector-eligible? :wholesale-or-retail-sale-of-goods true true)))
    (is (false? (registry/reserved-sector-eligible? :wholesale-or-retail-sale-of-goods true false)))
    (is (false? (registry/reserved-sector-eligible? :wholesale-or-retail-sale-of-goods false false)))))

(deftest reserved-sector-eligible-unrestricted-sector
  (testing "a sector outside both tiers is always eligible under §105 (no ownership gate here)"
    (is (true? (registry/reserved-sector-eligible? :unrestricted-services false false)))))

(deftest reserved-sector-violation-is-entity-scope-gated
  (testing "an engagement NOT seeking a FIAC is never flagged, even in a reserved sector with no citizen owner"
    (is (false? (registry/reserved-sector-violation?
                 {:seeks-fiac? false :business-sector :wholesale-or-retail-sale-of-goods
                  :has-citizen-owner? false :all-owners-citizens? false}))))
  (testing "a FIAC-seeking engagement in a full-reservation sector without all-citizen ownership -> violation"
    (is (true? (registry/reserved-sector-violation?
                {:seeks-fiac? true :business-sector :wholesale-or-retail-sale-of-goods
                 :has-citizen-owner? true :all-owners-citizens? false}))))
  (testing "a FIAC-seeking engagement in a partial-reservation sector WITH a citizen owner -> no violation"
    (is (false? (registry/reserved-sector-violation?
                 {:seeks-fiac? true :business-sector :bakery
                  :has-citizen-owner? true :all-owners-citizens? false}))))
  (testing "a FIAC-seeking engagement in a partial-reservation sector with NO citizen owner -> violation"
    (is (true? (registry/reserved-sector-violation?
                {:seeks-fiac? true :business-sector :bakery
                 :has-citizen-owner? false :all-owners-citizens? false}))))
  (testing "a FIAC-seeking engagement in an unrestricted sector is never flagged by §105"
    (is (false? (registry/reserved-sector-violation?
                 {:seeks-fiac? true :business-sector :unrestricted-services
                  :has-citizen-owner? false :all-owners-citizens? false})))))

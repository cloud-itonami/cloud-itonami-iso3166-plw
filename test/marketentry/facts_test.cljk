(ns marketentry.facts-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.facts :as facts]))

(deftest plw-has-spec-basis
  (let [sb (facts/spec-basis "PLW")]
    (is (some? sb))
    (is (string? (:provenance sb)))
    (is (seq (:required-evidence sb)))
    (is (some? (facts/corporate-number-spec-basis "PLW")))
    (is (some? (facts/reserved-sector-spec-basis "PLW")))
    (is (some? (facts/pgst-spec-basis "PLW")))))

(deftest plw-rep-spec-basis-is-populated
  (testing "Title 40 PNCA §663's own procurement-debarment authority grounds rep-spec-basis"
    (is (some? (facts/rep-spec-basis "PLW")))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest required-evidence-satisfied
  (let [sb (facts/spec-basis "PLW")
        all (:required-evidence sb)]
    (is (true? (facts/required-evidence-satisfied? "PLW" all)))
    (is (not (facts/required-evidence-satisfied? "PLW" (take 1 all))))
    (is (nil? (facts/required-evidence-satisfied? "ATL" all)))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["PLW" "USA" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 2 (:covered c)))
    (is (= ["ATL"] (:missing-jurisdictions c)))))

(deftest reserved-sector-spec-basis-categories
  (let [rs (facts/reserved-sector-spec-basis "PLW")]
    (is (contains? (get-in rs [:reserved-sector-categories :partial-reservation]) :bakery))
    (is (contains? (get-in rs [:reserved-sector-categories :partial-reservation]) :handicraft-or-gift-shop))
    (is (contains? (get-in rs [:reserved-sector-categories :full-reservation]) :wholesale-or-retail-sale-of-goods))
    (is (contains? (get-in rs [:reserved-sector-categories :full-reservation]) :land-transportation-services))
    (is (= 6 (count (get-in rs [:reserved-sector-categories :partial-reservation]))))
    (is (= 5 (count (get-in rs [:reserved-sector-categories :full-reservation]))))))

(deftest pgst-spec-basis-cites-reform
  (let [pgst (facts/pgst-spec-basis "PLW")]
    (is (string? (:pgst-legal-basis pgst)))
    (is (re-find #"RPPL 11-11" (:pgst-legal-basis pgst)))))

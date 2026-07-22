(ns marketentry.registry
  "Pure-function market-entry filing-draft + filing-submit record
  construction -- an append-only market-entry book-of-record draft.

  Like every sibling actor's registry, there is no single international
  reference-number standard for a public-procurement market-entry
  filing -- every jurisdiction assigns its own format. This namespace
  does NOT invent one; it builds a jurisdiction-scoped sequence number
  and validates the record's required fields, the same honest,
  non-fabricating discipline `marketentry.facts` uses.

  `engagement-fee-matches-claim?` is an HONEST reapplication of the SAME
  ground-truth-recompute DISCIPLINE sibling actors use (verify a claimed
  monetary total against the entity's own recorded quantity x unit
  fields), reapplied to a market-entry engagement fee line.

  `reserved-sector-tier` / `reserved-sector-eligible?` /
  `reserved-sector-violation?` are THIS vertical's own new ground-truth
  recompute, grounding PLW's flagship governor check
  (`marketentry.governor`'s `reserved-sector-violations`): the Foreign
  Investment Act's own two-tier reserved-sectors gate (Palau National
  Code Annotated (PNCA) Title 28, §105 -- see `marketentry.facts` for
  the full research trail, cross-checked against the Foreign Investment
  Board's own 2021 Regulations).

  This is a check SHAPE genuinely different from every prior sibling in
  this family: not a turnover-scaled formula (Bulgaria), not a flat
  statutory threshold (Albania), not a boolean single-list sector-
  exclusion gate (Bhutan's FDI Negative List), not an inclusion-
  eligibility OR-of-thresholds test (CAF's Marché réservé), not an
  ordered-tier CLASSIFICATION (Botswana's citizen/resident-preference
  check), not a numeric lookup-table percentage recompute (FSM's
  citizen-bidder preference), and not a date-arithmetic window (GRD's
  director-conviction lookback, Barbados's registration-validity
  window). Palau's §105 mechanism is a TWO-TIER CATEGORICAL OWNERSHIP-
  COMPOSITION gate KEYED BY BUSINESS-ACTIVITY SECTOR: §105(a) reserves
  SIX named sectors for enterprises with AT LEAST ONE citizen owner (a
  >=1-owner gate); §105(b) reserves FIVE DIFFERENT named sectors
  EXCLUSIVELY for enterprises with NO non-citizen owner at all (a
  stricter, ALL-owners gate). The check independently recomputes, from
  the engagement's OWN declared business sector and ownership-
  composition facts (`:has-citizen-owner?` / `:all-owners-citizens?`),
  whether that sector's own tier is actually satisfied -- it does not
  trust a claimed compliance label.

  `reserved-sector-tier` also HONESTLY preserves the statute's own open
  scope rather than over-fitting it: §105(a)(7)/(b)(6) each let the
  Foreign Investment Board designate ADDITIONAL reserved sectors by
  regulation, and this catalog does not attempt to enumerate a Board
  discretion it did not find evidence of being exercised (see
  `marketentry.facts` namespace docstring) -- an unlisted sector simply
  returns nil (no §105 tier applies), NOT a fabricated third tier.

  This namespace is pure data + pure functions -- no I/O, no network
  call to any real Foreign Investment Board or procurement system. It
  builds the RECORD an operator would keep, not the act of submitting a
  filing itself (that is `marketentry.operation`'s `:filing/submit`,
  always human-gated -- see README Actuation)."
  (:require [clojure.string :as str]))

(defn- unsigned-certificate
  "Every certificate this actor produces is UNSIGNED -- signature is
  the market-entry operator's act, not this actor's."
  [kind subject record-id]
  {"@context" ["https://www.w3.org/ns/credentials/v2"]
   "type" ["VerifiableCredential" kind]
   "credentialSubject" {"id" subject "record" record-id}
   "proof" nil
   "issued_by_registry" false
   "status" "draft-unsigned"})

(defn- zero-pad [n w]
  (let [s (str n)]
    (str (apply str (repeat (max 0 (- w (count s))) "0")) s)))

(defn compute-engagement-fee
  "The ground-truth engagement fee for `engagement`'s own `:base-fee`
  and `:monitoring-months` x `:monthly-rate` -- a single flat
  base + months x rate calculation, not a full pricing engine."
  [{:keys [base-fee monthly-rate monitoring-months]}]
  (+ (double base-fee)
     (* (double monthly-rate) (double monitoring-months))))

(defn engagement-fee-matches-claim?
  "Does `engagement`'s own `:claimed-fee` equal the independently
  recomputed `compute-engagement-fee`?"
  [{:keys [claimed-fee] :as engagement}]
  (== (double claimed-fee) (compute-engagement-fee engagement)))

(def reserved-sectors
  "Foreign Investment Act, PNCA Title 28 §105(a)/(b), own primary text
  (independently cross-checked against the Foreign Investment Board's
  own 2021 Regulations, Section 8, which restate the identical lists).
  `:partial-reservation` (§105(a)(1)-(6)): a non-citizen may engage in
  these ONLY if a citizen holds some ownership interest. `:full-
  reservation` (§105(b)(1)-(5)): reserved exclusively for enterprises
  with NO non-citizen owner at all."
  {:partial-reservation #{:handicraft-or-gift-shop :bakery :standalone-bar-service
                          :competing-domestic-manufacturing :tourism-equipment-rental
                          :farm-raised-fish-or-mariculture}
   :full-reservation #{:wholesale-or-retail-sale-of-goods :land-transportation-services
                       :water-transportation-services :travel-or-tour-agency
                       :non-highly-migratory-commercial-fishing}})

(defn reserved-sector-tier
  "Which §105 reservation tier (if any) governs `business-sector`:
  `:partial-reservation`, `:full-reservation`, or nil if the sector is
  not named in either list. §105(a)(7)/(b)(6) leave an open Board-
  discretion catch-all this catalog does NOT attempt to enumerate (see
  namespace docstring) -- an unlisted sector is simply nil, not a
  fabricated third tier."
  [business-sector]
  (cond
    (contains? (:partial-reservation reserved-sectors) business-sector) :partial-reservation
    (contains? (:full-reservation reserved-sectors) business-sector) :full-reservation
    :else nil))

(defn reserved-sector-eligible?
  "Is a business enterprise with the declared ownership-composition
  facts eligible to include non-citizen ownership while operating in
  `business-sector` under §105? A sector outside either reservation
  tier is always eligible (no §105 ownership gate applies here -- a
  Foreign Investment Approval Certificate may still be independently
  required under §103, unrelated to this specific check)."
  [business-sector has-citizen-owner? all-owners-citizens?]
  (case (reserved-sector-tier business-sector)
    :partial-reservation (boolean has-citizen-owner?)
    :full-reservation (boolean all-owners-citizens?)
    true))

(defn reserved-sector-violation?
  "Does `engagement` declare a foreign-investment engagement
  (`:seeks-fiac?` true, i.e. it has non-citizen ownership at stake and
  is relying on a Foreign Investment Approval Certificate) proposing to
  operate in a `:business-sector` that §105 reserves, WITHOUT the
  ownership composition that sector's own tier requires? Entity-scope-
  gated: an engagement that does not itself seek a FIAC is never
  flagged by this check (the same discipline FSM's citizen-bidder check
  and CAF's reserved-market check use) -- this check is about whether a
  NON-CITIZEN-INVESTED enterprise may lawfully enter a reserved sector
  at all, not a general citizenship audit of every engagement."
  [{:keys [seeks-fiac? business-sector has-citizen-owner? all-owners-citizens?]}]
  (boolean
   (and seeks-fiac?
        (not (reserved-sector-eligible? business-sector has-citizen-owner? all-owners-citizens?)))))

(defn register-draft
  "Validate + construct the FILING-DRAFT registration DRAFT -- the
  market-entry operator's own act of preparing a portal registration
  package. Pure function -- does not touch any real procurement
  system."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "draft: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "draft: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "draft: sequence must be >= 0" {})))
  (let [draft-number (str (str/upper-case jurisdiction) "-DFT-" (zero-pad sequence 6))
        record {"record_id" draft-number
                "kind" "filing-draft"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "draft_number" draft-number
     "certificate" (unsigned-certificate "FilingDraft" draft-number draft-number)}))

(defn register-submit
  "Validate + construct the FILING-SUBMIT registration DRAFT -- the
  market-entry operator's own act of actually submitting a filing
  (always human-gated upstream)."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "submit: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "submit: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "submit: sequence must be >= 0" {})))
  (let [submit-number (str (str/upper-case jurisdiction) "-SUB-" (zero-pad sequence 6))
        record {"record_id" submit-number
                "kind" "filing-submit"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "submit_number" submit-number
     "certificate" (unsigned-certificate "FilingSubmit" submit-number submit-number)}))

(defn append [history result]
  (conj (vec history) (get result "record")))

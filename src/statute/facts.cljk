(ns statute.facts
  "General-law compliance catalog for Palau (PLW) -- extends this repo's
  existing `marketentry.facts` (public-procurement market-entry only,
  narrow scope) with a second, orthogonal catalog of statutes a company
  operating in this jurisdiction must generally track for compliance.
  Mirrors cloud-itonami-iso3166-jpn/-deu/-bgr/-fsm/-grd's `statute.facts`
  (ADR-2607141700, cloud-itonami-compliance-fact-federation).

  Every entry cites an official government-hosted URL, or (for the
  Palau National Code Annotated (PNCA) itself) a Pacific Islands Legal
  Information Institute (`paclii.org`) page fetched via an Internet
  Archive Wayback Machine snapshot -- direct `paclii.org` fetches this
  session all returned a Cloudflare bot-detection challenge, disclosed
  rather than bypassed (see `marketentry.facts` namespace docstring for
  the full research trail). Never fabricated.

  - Companies/business-associations law: this iteration specifically
    investigated, rather than assumed by analogy to a sibling, whether
    Palau has its own domestic corporate-law title. It does: PNCA Title
    12 (BUSINESS ASSOCIATIONS), Division 1, is the 'Corporations Act'
    (own short title at §101, RPPL 11-10 §2, as amended by RPPL 11-24),
    §§101-112, administered by a Registrar of Corporations designated by
    the President (§109). This iteration found and preserves an HONEST
    TRANSITION-PERIOD NUANCE in the Act's own text rather than smoothing
    it over: RPPL 11-24 §28 (amending RPPL 11-10 §3, own text, quoted
    directly) provides 'Section 2 of this Act shall enter into effect
    upon the promulgation of regulations by the Registrar. Until such
    time as regulations are promulgated, Title 12, Chapter 1 of the
    Palau National Code shall continue to remain in effect and be
    controlling upon applicable entities' -- i.e. the NEW Corporations
    Act's own effectiveness is conditional on the Registrar (who must
    themselves first be designated within 14 months of RPPL 11-10's
    effective date, per RPPL 11-24 §28) promulgating implementing
    regulations. This iteration did NOT independently confirm whether
    those regulations have in fact been promulgated as of today, or
    whether the PRIOR Title 12 Chapter 1 text is still the one
    controlling -- an honest gap, not resolved by guessing which version
    currently governs a given filing.
  - Labor law: this iteration specifically searched for, and found, a
    citation that is NOT the title PacLII's own index names 'Labor'
    (Title 30) -- Title 30's own primary text (fetched directly) states
    on its own first page: 'Title 30 is repealed pursuant to RPPL 9-14 §
    25 which reads: Repeal. Title 30 of the Palau National Code shall
    hereby be repealed in its entirety upon the complete transition of
    the Bureau of Labor and Human Resources to the Ministry of Justice
    and the Ministry of Finance in accordance with this Act.' This
    iteration traced the recodification through TWO successive moves
    (own text at each step, not inferred): first to PNCA Title 13
    (Citizenship, Immigration & Labor) §§1020-1077 (RPPL 9-14 §14), then
    a SECOND recodification by RPPL 11-7 §11 into Title 13's own new
    Division 3 ('Labor'), Chapter 13, Subchapter I ('Preference and
    Wages'), §§1301-1306 -- the CURRENT, live citation this catalog
    uses. §1301's own text (ultimately derived from 49 TTC §2, the
    pre-PNCA Trust Territory Code) states the Olbiil Era Kelulau's
    policy finding that citizen workers 'be given preference in
    employment ... and that the public interest requires that the
    employment of noncitizen workers not impair the wages, employment
    opportunities, and working conditions of citizen workers.' §1306
    sets a minimum wage that rose in $0.25/hour annual steps from $2.75
    (October 2013) to a ceiling of $3.50/hour, with named exemptions (up
    to 2 farmers and up to 2 domestic helpers/caretakers/babysitters/
    house-boys per employer, students, probationary employees 20 or
    younger for up to 90 days, and employees of non-profit
    organizations). Administered by the Bureau of Labor and Human
    Resources (renamed from the former 'Division of Labor,' RPPL 9-14
    §3(b), own text) under the Ministry of Human Resources, Culture,
    Tourism and Development -- independently corroborated by that
    Ministry's own live page. This iteration did NOT locate a separate
    occupational-safety/hazardous-jobs or anti-discrimination title
    distinct from this Preference-and-Wages subchapter in the primary
    text it read (Title 30's own repeal notice shows the 'Hazardous
    Jobs' and 'Disabled Person's Anti-discrimination Act' chapters were
    recodified instead into PNCA Title 33, Public Employment, Division 4
    -- a genuinely separate title this iteration did NOT fetch this
    session, an honest scope limit rather than a claim those provisions
    do not exist).
  - CURRENCY CAVEAT (applies to every entry below): the PNCA pages this
    iteration fetched each print their own 'Supp. NN' supplement-number
    footer (e.g. 'Supp. 17', 'Supp. 18') rather than a single
    as-of-date; this iteration did not independently confirm whether any
    Olbiil Era Kelulau public law enacted after the printed supplement
    has further amended Title 12 or Title 13 Division 3.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries. `:statute/url` + `:statute/law-number`
  are the citation the governor requires before any compliance-fact
  proposal referencing this law can commit. PLW's catalog is smaller
  than some siblings' -- this reflects an honest scope limit (a separate
  occupational-safety/anti-discrimination title (PNCA Title 33 Division
  4) was identified but not fetched this iteration, and whether the new
  Corporations Act's own regulations have been promulgated -- and so
  which version of Title 12 Chapter 1 currently controls -- could not be
  independently confirmed, see namespace docstring), not a design choice
  to omit them."
  {"PLW"
   [{:statute/id "plw.title12-corporations-act"
     :statute/title "Corporations Act, Palau National Code Annotated (PNCA) Title 12 (Business Associations), Division 1, Chapter 1"
     :statute/jurisdiction "PLW"
     :statute/kind :law
     :statute/law-number "RPPL 11-10 § 2 (own short title at §101), as amended by RPPL 11-24 §§28-29. Own text read directly via an Internet Archive Wayback Machine snapshot of paclii.org (direct paclii.org fetch returned a Cloudflare bot-detection challenge this session). RPPL 11-24 §28's own transition clause conditions this Act's effectiveness on the Registrar first promulgating implementing regulations -- until then, the PRIOR Title 12 Chapter 1 text remains controlling (own text); this iteration did not independently confirm whether those regulations have been promulgated as of today."
     :statute/url "https://web.archive.org/web/20260310000521/https://www.paclii.org/pw/legis/consol_act/bat12293/"
     :statute/url-provenance :paclii-via-wayback-machine
     :statute/enacted-date nil
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "plw.title13-div3-preference-and-wages"
     :statute/title "Preference and Wages, Palau National Code Annotated (PNCA) Title 13 (Citizenship, Immigration & Labor), Division 3 (Labor), Chapter 13, Subchapter I"
     :statute/jurisdiction "PLW"
     :statute/kind :law
     :statute/law-number "Ultimately derived from 49 TTC § 2 (Trust Territory Code); recodified from the now-fully-repealed PNCA Title 30 §102 to Title 13 §1020 by RPPL 9-14 § 14, then recodified again to Title 13 §1301 by RPPL 11-7 § 11 (own text at each step). Own text read directly via an Internet Archive Wayback Machine snapshot of paclii.org (direct paclii.org fetch returned a Cloudflare bot-detection challenge this session)."
     :statute/url "https://web.archive.org/web/20250130143859/http://www.paclii.org/pw/legis/consol_act/cialt13364/"
     :statute/url-provenance :paclii-via-wayback-machine
     :statute/enacted-date nil
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor}}]})

(defn spec-basis
  "The jurisdiction's statute vector, or nil -- nil means NO spec-basis
  for that jurisdiction yet."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report, same shape/discipline as `marketentry.facts/coverage`:
  never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-plw statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "PLW")) " PLW statute(s) seeded with an "
                 "official citation (a separate occupational-safety/anti-"
                 "discrimination title (PNCA Title 33 Division 4) was identified "
                 "but not fetched this iteration -- an honest gap, not an "
                 "omission by design). Extend `statute.facts/catalog`, never "
                 "fabricate a law-id or URL.")})))

(defn by-topic
  "Statutes for `iso3` tagged with `topic` (e.g. :labor, :data-protection)."
  [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))

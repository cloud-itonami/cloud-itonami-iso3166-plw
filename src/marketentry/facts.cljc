(ns marketentry.facts
  "Per-jurisdiction public-procurement market-entry regulatory catalog
  -- the G2-style spec-basis table the Market-Entry Compliance Governor
  checks every `:jurisdiction/assess` proposal against ('did the advisor
  cite an OFFICIAL public source for this jurisdiction's requirements,
  or did it invent one?').

  Palau's real market-entry surface (curl/WebFetch-verified 2026-07-23;
  where a page could not be reached, or a mechanism could not be
  independently confirmed, that is stated explicitly rather than
  silently assumed):

  - **Sourcing discipline for this iteration**: this session's WebSearch
    budget was already exhausted before this task began (same
    constraint the CAF/GRD siblings in this family record), so discovery
    used direct navigation from `palaugov.pw` (the Republic of Palau's
    own official government site, reachable and HTTP 200 on every fetch
    this session) plus the Palau National Code's own title index. Where
    the government's own PDFs (hosted directly on `palaugov.pw`) were
    available, those were fetched and read as PRIMARY sources. Where the
    Palau National Code Annotated (PNCA) itself was needed and not
    separately hosted by the government, the Pacific Islands Legal
    Information Institute (`paclii.org`) was the target -- but every
    direct fetch of `paclii.org` this session returned a Cloudflare
    'Just a moment...' bot-detection challenge page (HTTP 403, `<title>
    Just a moment...</title>`, a `challenges.cloudflare.com` CSP
    directive), which this iteration did NOT attempt to bypass (a hard
    prohibition, not merely a preference). The Internet Archive Wayback
    Machine (`archive.org/wayback/available`) was used as the disclosed
    fallback for every PacLII page cited below; the PDF/HTML content at
    each Wayback URL was fetched and read directly, not paraphrased from
    a search snippet.
  - **Public procurement -- investigated, not assumed to be a
    free-standing 'Public Procurement Act' the way several Caribbean/
    OECS siblings in this family have.** This iteration fetched
    PacLII's own Palau consolidated-legislation title index (all 12
    lettered index pages that exist, covering every one of Palau's 42
    non-reserved PNCA titles) via Wayback Machine snapshots and
    confirmed NO title is named 'Procurement,' 'Public Procurement,' or
    'Financial Management.' Procurement instead lives as its OWN
    CHAPTER inside Title 40 (REVENUE AND TAXATION): Chapter 6,
    'Statutory Framework for National Government Procurement,' §§601-664
    (own primary text, RPPL 3-54, amended by RPPL 5-7 §§64-65, RPPL 7-25
    §2, and RPPL 10-26 §§4-8, modified) -- sitting in the SAME title as
    National Budget (Chapter 3), Government Funding (Chapter 4), Debt
    Management (Chapter 5), and Government Property (Chapter 7). This
    confirms, for Palau specifically, exactly the pattern this task
    asked to verify rather than assume: procurement routed through
    general public-finance legislation, not a dedicated procurement
    statute. §613/§614 make competitive sealed bidding the default
    source-selection method; §625 sets small-purchase thresholds ($20,000
    ceiling for non-bid small purchases; 3 written price quotes required
    for $5,000-$20,000; 2 quotes for $2,500-$5,000; 1 quote below
    $2,500; state-government purchases of $10,000 or more require
    competitive bidding); §663 authorizes the Procurement Officer(s),
    after consulting the Attorney General, to debar a person for cause
    (own text: criminal conviction incident to obtaining or performing a
    public or private contract; conviction for cheating, embezzlement,
    theft, forgery, bribery, or any other offense indicating a lack of
    business integrity or honesty; a serious contract-performance
    violation; or violation of the chapter's own ethical standards) for
    up to 3 years, or suspend for up to 3 months, pending debarment. No
    dedicated e-procurement portal distinct from the government's own
    `palaugov.pw/rfp` (Request for Proposal notices) and `palaugov.pw/ifb`
    (Invitation for Bid notices) pages was found this session.
  - **The flagship check this vertical adds** (see `marketentry.governor`
    / `marketentry.registry`) is grounded in a mechanism this iteration
    fetched and read TWICE independently -- once in the Foreign
    Investment Act's own primary statutory text, and again in the
    Foreign Investment Board's own 2021 Regulations, which restate the
    identical lists verbatim while adding interpretive detail neither
    document states alone: the RESERVED-SECTORS mechanism. The Foreign
    Investment Act (Palau National Code Annotated (PNCA) Title 28
    (FOREIGN RELATIONS AND TRADE), Chapter 1, §§101-127; RPPL 3-34, as
    amended by RPPL 9-56, RPPL 9-64 (entire chapter re-enacted), and
    RPPL 10-20; own primary text fetched directly from
    `palaugov.pw/wp-content/uploads/2021/10/Foreign-Investment-Act.pdf`,
    the Republic of Palau's own official government hosting, an even
    more direct source than the PacLII secondary aggregator) requires
    (§103) any non-citizen owner or part-owner of a business enterprise
    in the Republic to first obtain a Foreign Investment Approval
    Certificate (FIAC) from the Foreign Investment Board (an independent
    7-member statutory body within the executive branch, §104,
    appointed by the President with Senate consent). §105 then names a
    TWO-TIER reserved-sectors gate -- a check SHAPE this iteration
    confirmed is genuinely different from every prior sibling in this
    family (not a single boolean sector-exclusion list like Bhutan's FDI
    Negative List; not an inclusion-eligibility OR-of-thresholds test
    like CAF's Marché réservé; not an ordered-tier classification like
    Botswana's citizen/resident-preference check): §105(a)(1)-(6) names
    SIX activities (handicraft/gift shops except at hotels or the
    international airport; bakeries; standalone bar service outside a
    50+-room hotel/restaurant complex; manufacturing that duplicates an
    existing wholly-Palauan-owned manufacturer's products; land/water
    equipment rental for tourism, excluding transport-vehicle rentals;
    farm-raised fish/mariculture) a non-citizen may engage in ONLY if a
    citizen holds SOME ownership interest (a >=1-citizen-owner gate);
    §105(b)(1)-(5) names FIVE DIFFERENT activities (wholesale/retail
    sale of goods; land transportation including bus/taxi/car-rental
    services; water transportation including vehicle rentals; travel/
    tour agencies and tour service providers including dive shops and
    chartered fishing; commercial fishing for other than highly
    migratory species) reserved EXCLUSIVELY for enterprises with NO
    non-citizen owner at all (an ALL-citizen-owned gate) -- a materially
    stricter tier than §105(a)'s. Both subsections end in an open
    Board-discretion catch-all ('any such other businesses as the Board
    may determine,' §105(a)(7)/(b)(6)); this iteration's independent
    re-read of the Board's own 2021 Regulations (Section 8, own text)
    found the Regulations restate the identical statutory categories
    verbatim and add only interpretive detail (e.g. the §105(b)(3) water-
    transportation reservation has a 'bareboat charter' carve-out stated
    ONLY in the Regulations, not the bare statute text) -- this iteration
    did NOT find evidence the Board has exercised either catch-all to
    designate an ADDITIONAL reserved sector beyond the statute's own
    named categories, an honest scope limit (not an exhaustive search of
    every subsequent Board regulation or meeting minutes) rather than a
    claim that no such designation could ever exist. `marketentry.registry`
    models ONLY the statutorily-named categories for exactly this reason.
  - **Business licensing -- confirmed at the NATIONAL level, and its own
    text cross-references the Foreign Investment Act directly (own
    primary text, not inferred).** PNCA Title 40 (Revenue and Taxation),
    Chapter 15 (Business Licenses), §§1501-1506 (RPPL 1-63 as amended,
    most recently by RPPL 9-64 and, for the PGST-era additional fee in
    §1506, RPPL 11-11 §15) requires (§1501) any person engaging in
    business in the Republic to obtain an annual license from 'the
    Director' (the Bureau of Revenue and Taxation's own director, per
    the Ministry of Finance's own site structure, independently
    confirmed via `palaugov.pw/executive-branch/ministries/finance/`) --
    and §1501(e)(2)'s own text conditions license issuance on the
    Director confirming the business either does not require, or has
    already obtained, a valid Foreign Investment Approval Certificate
    'in accordance with chapter 1 of Title 28,' i.e. the SAME Foreign
    Investment Act this catalog's flagship check is grounded in. §1504
    additionally requires business registration with the 'Revenue and
    Tax Office' for an identification number -- this catalog's
    `corporate-number-spec-basis`.
  - **Tax -- Palau's regime is NOT simply 'historically a gross revenue
    tax,' and this iteration verified the CURRENT mechanism directly
    rather than assuming the older shape still controls.** The Bureau of
    Revenue and Taxation's own live tax-forms page
    (`palaugov.pw/executive-branch/ministries/finance/brt/tax-forms/`,
    fetched directly) lists a 'Tax-200 Gross Revenue Quarterly Tax
    Return Form' ALONGSIDE a 'Tax-500 Palau Goods and Services Tax
    Return Form' and a 'Tax-502 Business Profits Tax Return' -- so this
    iteration fetched Title 40's own text to resolve which currently
    controls. PNCA Title 40 Chapter 12's own §1201 Source note (own
    primary text) states plainly: 'Former Chapter 12 entitled \"Gross
    Revenue and Net Income Tax\" repealed by RPPL 11-11 § 2' -- Chapter
    12 is NOW the 'Palau Goods and Services Tax Act' (RPPL 11-11 §2,
    own short title at §1201), 'effective on January 1, 2023' (RPPL
    11-11 §21 note). RPPL 11-11 is a single tax-reform Act that ALSO
    enacted a 'Business Profits Tax Act' as Chapter 14 Subchapter II
    (§§1411 et seq., own short title at §1411, RPPL 11-11 §14) and
    amended the pre-existing Wages and Salary Tax (Chapter 11, §1101 --
    a progressive 6%/10%/12% withholding on wages, amended by RPPL 11-11
    §5). The historical Gross Revenue Tax return form's continued
    presence on the BRT's own current forms page is consistent with a
    transition period for pre-2023 liabilities (Chapter 19's own §1901
    Transition provision preserves liability for pre-repeal tax periods)
    rather than the old regime still being the CURRENT mechanism for new
    business -- this iteration did NOT find primary text stating gross
    revenue tax remains available as an ongoing election for any current
    taxpayer class, an honest gap left open rather than resolved by
    guessing. All of Chapters 11/12/14-Subchapter-II are administered by
    'the Director' of the Bureau of Revenue and Taxation, Ministry of
    Finance (own text throughout).
  - **Labor -- confirmed as a CURRENT citation, not the REPEALED title a
    naive search would find.** PNCA Title 30 was itself named 'Labor' in
    PacLII's own title index, but fetching Title 30's own text (own
    primary source, via Wayback) shows it is ENTIRELY REPEALED: its own
    header states 'Title 30 is repealed pursuant to RPPL 9-14 § 25,'
    with every substantive chapter's sections marked '[Codified at ...]'
    elsewhere. This iteration traced the recodification rather than
    citing a dead title: the 'Protection of Resident Workers' chapter
    moved first to Title 13 (Citizenship, Immigration & Labor) §§1020-
    1077 (RPPL 9-14 §14), and was recodified AGAIN by RPPL 11-7 §11 into
    Title 13's own new Division 3 ('Labor'), Chapter 13, Subchapter I
    ('Preference and Wages'), §§1301-1306 -- fetched and read directly
    at this final, current location. §1301 (own text, ultimately
    derived from 49 TTC §2, the pre-PNCA Trust Territory Code) states
    the Olbiil Era Kelulau's policy finding that citizen workers 'be
    given preference in employment ... and that the public interest
    requires that the employment of noncitizen workers not impair the
    wages, employment opportunities, and working conditions of citizen
    workers'; §1302 requires resident-worker preference; §1306 sets a
    minimum wage that rose in $0.25/hour steps from $2.75 (Oct 2013) to
    a ceiling of $3.50/hour, with named exemptions (up to 2 farmers, up
    to 2 domestic helpers/caretakers/babysitters/house-boys per
    employer, students, probationary employees <=20 years old for up to
    90 days, and non-profit-organization employees). Administered by the
    Bureau of Labor and Human Resources (renamed from the former
    'Division of Labor,' RPPL 9-14 §3(b), own text) under the Ministry
    of Human Resources, Culture, Tourism and Development -- independently
    corroborated by that Ministry's own live page at
    `palaugov.pw/executive-branch/ministries/hrctd/`.
  - This iteration also looked for a representative/conflict-of-interest
    bidder-exclusion provision distinct from the general procurement-
    debarment mechanism (the shape GRD's s.17(1)(e)-(f)/Part VIII
    documents for its own law). Title 40 PNCA §663 (own primary text,
    quoted above) grounds this catalog's `rep-spec-basis` -- the
    Procurement Officer(s)' own debarment-for-cause authority, which
    reaches a person's own criminal conviction or business-dishonesty
    record, the same substantive ground GRD's own finding covers, even
    though Palau's text does not use the word 'representative.'

  Coverage is reported HONESTLY (see `coverage`): a jurisdiction not in
  this table has NO spec-basis, full stop -- the advisor must not
  fabricate one, and the governor holds if it tries.")

(def catalog
  "iso3 -> requirement map. `:required-evidence` mirrors the generic
  intake/portal-registration/filing evidence set; `:legal-basis` /
  `:owner-authority` / `:provenance` are the G2 citation the governor
  requires before any `:jurisdiction/assess` proposal can commit.
  `:reserved-sector-owner-authority` / `:reserved-sector-legal-basis` /
  `:reserved-sector-categories` / `:reserved-sector-provenance` ground
  this vertical's flagship governor check (`reserved-sector-violation?`
  in `marketentry.registry`) -- the Foreign Investment Act's own
  two-tier §105 reserved-sectors gate. `:corporate-number-*` grounds the
  Title 40 PNCA §1504 business-identification-number requirement.
  `:rep-owner-authority` etc. ground the Title 40 PNCA §663 procurement-
  debarment mechanism."
  {"PLW" {:name "Palau"
          :owner-authority "Ministry of Finance, Republic of Palau -- the Bureau of Revenue and Taxation (business licenses, PGST/business-profits/wage taxes) and the Procurement Officer(s) designated under Title 40 PNCA Chapter 6; the Foreign Investment Board (an independent 7-member statutory body within the executive branch, 28 PNCA §104) separately administers Foreign Investment Approval Certificates and the §105 reserved-sectors gate"
          :legal-basis "Statutory Framework for National Government Procurement, Palau National Code Annotated (PNCA) Title 40 (Revenue and Taxation), Chapter 6, §§601-664 (RPPL 3-54, as amended by RPPL 5-7 §§64-65, RPPL 7-25 §2, and RPPL 10-26 §§4-8, modified) -- own primary text, fetched via an Internet Archive Wayback Machine snapshot of PacLII (paclii.org itself returned a Cloudflare bot-detection challenge on every direct fetch this session, disclosed rather than bypassed). §613/§614 require competitive sealed bidding as the default method; §625 sets small-purchase thresholds ($20,000 non-bid ceiling; 3 quotes $5,000-$20,000; 2 quotes $2,500-$5,000; 1 quote below $2,500; state purchases >= $10,000 require competitive bidding); §663 authorizes debarment (up to 3 years) or suspension (up to 3 months) by the Procurement Officer(s), after Attorney General consultation, for cause including criminal conviction incident to a public/private contract or an offense indicating a lack of business integrity/honesty."
          :national-spec "Procurement is routed through a dedicated CHAPTER of the general Revenue-and-Taxation title (PNCA Title 40 Chapter 6), not a free-standing Public Procurement Act -- this iteration fetched PacLII's own complete Palau title index (all 42 non-reserved PNCA titles) and confirmed no title is named 'Procurement' or 'Financial Management'. No dedicated e-procurement portal distinct from the government's own bid-notice pages was found; opportunities are published directly on `palaugov.pw/rfp` (Request for Proposals) and `palaugov.pw/ifb` (Invitation for Bids)."
          :provenance "https://web.archive.org/web/20260207224051/https://www.paclii.org/pw/legis/consol_act/ratt40256/ ; https://www.palaugov.pw/rfp ; https://www.palaugov.pw/ifb"
          :required-evidence ["Foreign Investment Approval Certificate (FIAC) record (Foreign Investment Act, 28 PNCA §§103-108, Foreign Investment Board), when the engagement declares :seeks-fiac? true"
                              "Business License record (Title 40 PNCA §1501, Bureau of Revenue and Taxation, Ministry of Finance)"
                              "Business identification-number record (Title 40 PNCA §1504, Revenue and Tax Office)"
                              "Palau Goods and Services Tax (PGST) registration record (Palau Goods and Services Tax Act, Title 40 PNCA §1201 et seq., RPPL 11-11), when the engagement declares :requires-pgst-registration? true"
                              "Reserved-sector ownership-composition confirmation record (Foreign Investment Act, 28 PNCA §105), when the engagement's declared :business-sector falls within either §105 reservation tier"
                              "Authorized-representative confirmation record"]
          :corporate-number-owner-authority "Revenue and Tax Office, Bureau of Revenue and Taxation, Ministry of Finance"
          :corporate-number-legal-basis "Title 40 PNCA §1504 (own primary text): 'Any person engaging in business in the Republic shall register his business with the Revenue and Tax Office and shall obtain an identification number.' Every state government issuing a retail or other state business license must submit a list of those businesses to the Director within 30 days of issuance (own text)."
          :corporate-number-provenance "https://web.archive.org/web/20260207224051/https://www.paclii.org/pw/legis/consol_act/ratt40256/"
          :reserved-sector-owner-authority "Foreign Investment Board, Republic of Palau (28 PNCA §104 -- 7 appointed members, residents of the Republic, appointed by the President with Senate advice and consent)"
          :reserved-sector-legal-basis "Foreign Investment Act, 28 PNCA §105 (RPPL 3-34, amended by RPPL 9-56, RPPL 9-64, RPPL 10-20), own primary text, independently cross-checked against the Foreign Investment Board's own 2021 Regulations (Section 8, own text, restates the identical lists). §105(a)(1)-(6) (handicraft/gift shops except hotel/airport premises; bakeries; standalone bar service outside a 50+-room hotel/restaurant complex; manufacturing duplicating an existing wholly-Palauan-owned manufacturer's products; land/water equipment rental for tourism excluding transport-vehicle rentals; farm-raised fish/mariculture) require AT LEAST ONE citizen owner for any non-citizen to participate. §105(b)(1)-(5) (wholesale/retail sale of goods; land transportation including bus/taxi/car-rental; water transportation including vehicle rentals; travel/tour agencies and tour service providers; commercial fishing for other than highly migratory species) are reserved EXCLUSIVELY for enterprises with NO non-citizen owner at all. Both subsections end in an open Board-discretion catch-all (§105(a)(7)/(b)(6)) this catalog does not attempt to enumerate beyond the statute's own named categories (see namespace docstring)."
          :reserved-sector-categories {:partial-reservation #{:handicraft-or-gift-shop :bakery :standalone-bar-service
                                                              :competing-domestic-manufacturing :tourism-equipment-rental
                                                              :farm-raised-fish-or-mariculture}
                                      :full-reservation #{:wholesale-or-retail-sale-of-goods :land-transportation-services
                                                          :water-transportation-services :travel-or-tour-agency
                                                          :non-highly-migratory-commercial-fishing}}
          :reserved-sector-provenance "https://www.palaugov.pw/wp-content/uploads/2021/10/Foreign-Investment-Act.pdf ; https://www.palaugov.pw/wp-content/uploads/2021/09/Foreign_Investment_Act_Regulations.pdf"
          :pgst-owner-authority "Bureau of Revenue and Taxation, Ministry of Finance"
          :pgst-legal-basis "Palau Goods and Services Tax Act, Title 40 PNCA Chapter 12, §1201 et seq. (RPPL 11-11 §2, own short title at §1201; effective January 1, 2023 per RPPL 11-11 §21). RPPL 11-11 repealed the former Chapter 12 'Gross Revenue and Net Income Tax' (own text: 'Former Chapter 12 entitled \"Gross Revenue and Net Income Tax\" repealed by RPPL 11-11 § 2') and, in the same Act, also enacted the Business Profits Tax Act (Chapter 14 Subchapter II, §1411 et seq., RPPL 11-11 §14) and amended the pre-existing Wages and Salary Tax (Chapter 11 §1101, a progressive 6%/10%/12% withholding, RPPL 11-11 §5). Title 40 PNCA §1506 imposes an additional $100/year business-license fee on non-PGST-registered persons with annual gross income of $50,000 or less."
          :pgst-provenance "https://web.archive.org/web/20260207224051/https://www.paclii.org/pw/legis/consol_act/ratt40256/ ; https://www.palaugov.pw/executive-branch/ministries/finance/brt/tax-forms/"
          :rep-owner-authority "Procurement Officer(s), Republic of Palau, after consultation with the Attorney General (Title 40 PNCA §663)"
          :rep-legal-basis "Title 40 PNCA §663 (own primary text): after reasonable notice and opportunity to be heard, a Procurement Officer, after consulting the Attorney General, may debar a person for cause (for up to 3 years) or suspend a person on probable cause for debarment (for up to 3 months) from consideration for contract awards. Causes include conviction for a criminal offense incident to obtaining/performing a public or private contract; conviction under statutes prohibiting cheating, embezzlement, theft, forgery, or bribery, or any other offense indicating a lack of business integrity or honesty; a serious contract-performance violation; or violation of the chapter's own ethical standards (§§652-662)."
          :rep-provenance "https://web.archive.org/web/20260207224051/https://www.paclii.org/pw/legis/consol_act/ratt40256/"}
   "USA" {:name "United States"
          :owner-authority "U.S. General Services Administration (GSA) / SAM.gov"
          :legal-basis "Federal Acquisition Regulation (FAR); System for Award Management"
          :national-spec "SAM.gov entity registration + NAICS self-certification"
          :provenance "https://sam.gov/"
          :required-evidence ["EIN record"
                              "SAM.gov registration record"
                              "State business registration record"
                              "Authorized-representative record"]}
   "DEU" {:name "Germany"
          :owner-authority "Beschaffungsamt des BMI / e-Vergabe platforms"
          :legal-basis "Gesetz gegen Wettbewerbsbeschränkungen (GWB) / VgV"
          :national-spec "e-Vergabe supplier registration under EU procurement directives"
          :provenance "https://www.evergabe-online.de/"
          :required-evidence ["Handelsregister extract"
                              "e-Vergabe registration record"
                              "USt-IdNr record"
                              "Authorized-representative record"]}})

(defn spec-basis
  "The jurisdiction's requirement map, or nil -- nil means NO spec-basis,
  and the governor must hold any proposal that tries to assess or file
  on it."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report: how many of the requested jurisdictions actually
  have a spec-basis entry. Never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-plw R0: " (count catalog)
                 " jurisdictions seeded with an official spec-basis. "
                 "This is a starting catalog for market-entry navigation, "
                 "not a survey of all ~194 jurisdictions -- extend "
                 "`marketentry.facts/catalog`, never fabricate a "
                 "jurisdiction's requirements.")})))

(defn required-evidence-satisfied?
  "Does `submitted` (a set/coll of evidence keywords or strings) satisfy
  every evidence item listed for `iso3`? Missing spec-basis -> never
  satisfied."
  [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (let [need (count required-evidence)
          have (count (filter (set submitted) required-evidence))]
      (= need have))))

(defn evidence-checklist [iso3]
  (:required-evidence (spec-basis iso3) []))

(defn rep-spec-basis
  "The jurisdiction's representative-related requirement map, or nil when
  this catalog has no such regime. For PLW this is POPULATED, grounded
  in Title 40 PNCA §663's own procurement-debarment authority (see
  namespace docstring and `catalog`)."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))

(defn corporate-number-spec-basis
  "The jurisdiction's corporate-number / business-identification regime,
  or nil. For PLW this is Title 40 PNCA §1504's business identification
  number, issued by the Revenue and Tax Office."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority
                       :corporate-number-legal-basis
                       :corporate-number-provenance]))))

(defn reserved-sector-spec-basis
  "The jurisdiction's reserved-sectors regime, or nil. For PLW this is
  the flagship check's own ground: the Foreign Investment Act's 28 PNCA
  §105 two-tier reserved-sectors gate (see namespace docstring and
  `catalog`)."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:reserved-sector-owner-authority sb)
      (select-keys sb [:reserved-sector-owner-authority
                       :reserved-sector-legal-basis
                       :reserved-sector-categories
                       :reserved-sector-provenance]))))

(defn pgst-spec-basis
  "The jurisdiction's Palau Goods and Services Tax (or equivalent)
  regime, or nil. For PLW this documents the 2023 tax reform (RPPL
  11-11) that replaced the historical Gross Revenue and Net Income Tax
  (see namespace docstring)."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:pgst-owner-authority sb)
      (select-keys sb [:pgst-owner-authority :pgst-legal-basis :pgst-provenance]))))

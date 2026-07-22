# cloud-itonami-iso3166-plw

Open ISO 3166 Blueprint for **PLW**: Palau -- **`:implemented`**.

This repository designs **and implements** a forkable OSS business for
an independent public-sector market-entry consultant: an already-
incorporated operator (e.g. a `cloud-itonami-cofog-{code}`,
`cloud-itonami-isco-{code}`, `cloud-itonami-unspsc-{segment}` or
`cloud-itonami-{ISIC}` blueprint fork) gets a Compliance Advisor +
independent **Market-Entry Compliance Governor** to navigate public-
procurement registration, business licensing, and foreign-investment
compliance rules in Palau, so the operator can win and service a
government contract without hiring a full in-house compliance
department.

## Official surface (curl/WebFetch-verified 2026-07-23 -- `palaugov.pw` fetched cleanly on every attempt; `paclii.org` returned a Cloudflare bot-detection challenge on every direct attempt, so PacLII pages below were read via disclosed Internet Archive Wayback Machine snapshots instead)

- Foreign investment: the **Foreign Investment Act** (Palau National
  Code Annotated (PNCA) Title 28, Chapter 1, §§101-127; RPPL 3-34, as
  amended by RPPL 9-56, RPPL 9-64, RPPL 10-20) -- own primary text
  fetched directly from `palaugov.pw` (the government's own hosting,
  `palaugov.pw/wp-content/uploads/2021/10/Foreign-Investment-Act.pdf`).
  A non-citizen owner/part-owner of a Palau business enterprise must
  first obtain a Foreign Investment Approval Certificate (FIAC) from
  the **Foreign Investment Board** (`palaugov.pw/fib/`, an independent
  7-member statutory body, §104). §105 names a TWO-TIER reserved-
  sectors gate: six activities reserved for enterprises with AT LEAST
  ONE citizen owner (§105(a)), and five DIFFERENT activities reserved
  EXCLUSIVELY for ALL-citizen-owned enterprises (§105(b)) -- cross-
  checked against the Board's own 2021 Regulations.
- Business licensing: PNCA Title 40 (Revenue and Taxation), Chapter 15,
  §§1501-1506 -- an annual license from the Bureau of Revenue and
  Taxation's Director, cross-referencing Foreign Investment Act
  compliance directly in its own text (§1501(e)(2)).
- Public procurement: PNCA Title 40, Chapter 6, "Statutory Framework
  for National Government Procurement," §§601-664 (RPPL 3-54, as
  amended) -- **routed through the general Revenue-and-Taxation title,
  not a free-standing Public Procurement Act** (this iteration fetched
  PacLII's own complete Palau title index, all 42 non-reserved titles,
  and confirmed no title is named "Procurement" or "Financial
  Management"). Opportunities are published on `palaugov.pw/rfp` and
  `palaugov.pw/ifb`.
- Tax: the **Palau Goods and Services Tax Act** (PNCA Title 40 Chapter
  12, RPPL 11-11, effective January 1, 2023) plus a **Business Profits
  Tax Act** (Chapter 14 Subchapter II, same RPPL 11-11) REPLACED the
  historical Gross Revenue and Net Income Tax (former Chapter 12,
  repealed) -- verified directly from Title 40's own text, not assumed
  to still be "historically a gross revenue tax."
- Labor: PNCA Title 30 ("Labor" in PacLII's own index) is **entirely
  repealed** (RPPL 9-14 §25); the current, live citation is Title 13
  (Citizenship, Immigration & Labor), Division 3, Chapter 13,
  Subchapter I ("Preference and Wages"), §§1301-1306 -- traced through
  two successive recodifications rather than cited from the dead
  title.

## Implementation (R0)

| Piece | Location |
|---|---|
| Actor namespaces | `src/marketentry/*` |
| Governor | `:market-entry-compliance-governor` |
| Ops | `:engagement/intake` · `:jurisdiction/assess` · `:filing/draft` · `:filing/submit` |
| Flagship HARD check | `reserved-sector-violation?` (Foreign Investment Act, PNCA Title 28 §105: a foreign-invested engagement's own declared business sector and ownership composition are independently recomputed against the Act's two-tier reserved-sectors gate -- see the namespace docstrings in `src/marketentry/{facts,registry,governor}.cljc`) |
| Compliance catalog | `src/statute/facts.cljc` -- Corporations Act (PNCA Title 12 Division 1), Preference and Wages (PNCA Title 13 Division 3 Chapter 13) |
| Tests | `clojure -M:dev:test` |
| Demo | `clojure -M:dev:run` |

`:filing/submit` is never in any phase's `:auto` set -- human sign-off
is structural, not a rollout milestone.

## Market-entry / statute catalogs

Governed public-sector market-entry compliance actor, same architecture
as `cloud-itonami-iso3166-fsm`/`-grd`/`-caf`/`-btn`/`-bwa`/`-est`:

- `src/marketentry/{facts,governor,phase,sim,operation,registry,store,
  marketentryllm}.cljc` -- the actor. `facts.cljc` cites the Foreign
  Investment Act (28 PNCA §§101-127), Title 40 PNCA's own Procurement
  chapter (§§601-664), Business Licenses chapter (§§1501-1506), and the
  Palau Goods and Services Tax Act (RPPL 11-11). `governor.cljc`'s
  flagship check independently recomputes the Foreign Investment Act's
  own §105 reserved-sectors gate -- a two-tier CATEGORICAL OWNERSHIP-
  COMPOSITION test keyed by business-activity sector, a check shape
  genuinely different from every other iso3166 sibling this repo
  mirrors (see the namespace docstrings for the full research trail,
  including the honestly preserved open Board-discretion catch-all in
  §105(a)(7)/(b)(6) this catalog does not attempt to enumerate beyond
  the statute's own named categories).
- `src/statute/facts.cljc` -- general-law catalog: the Corporations Act
  (PNCA Title 12 Division 1, §§101-112, RPPL 11-10 as amended RPPL
  11-24) and Preference and Wages (PNCA Title 13 Division 3 Chapter 13,
  §§1301-1306). Smaller than some siblings' catalogs -- a separate
  occupational-safety/anti-discrimination title (PNCA Title 33 Division
  4) was identified but not fetched this iteration (an honest gap, not
  an omission by design; see the namespace docstring).

Every citation is curl/WebFetch-verified against an official source
(`palaugov.pw` directly, or PacLII via a disclosed Internet Archive
Wayback Machine snapshot when `paclii.org` itself returned a Cloudflare
bot-detection challenge this session -- never bypassed).

## No robotics premise -- digital/data service exemption

Market-entry and procurement-compliance navigation is a pure data/
software service with no physical-domain work (portal registration,
document checklists, regulatory-change monitoring) -- the same
exemption class as `cloud-itonami-6310` (HR SaaS replacement) and
`cloud-itonami-gtin-*`. `blueprint.edn` sets
`:itonami.blueprint/robotics false` and `:required-technologies` lists
only real capabilities (`:identity`, `:forms`, `:dmn`, `:bpmn`,
`:audit-ledger`), no `:robotics`.

## Core Contract

```text
operator intake + prior filing history
        |
        v
Compliance Advisor -> Market-Entry Compliance Governor -> filing draft, or human sign-off
        |
        v
gated portal registration / filing submission + audit ledger
```

No automated proposal can submit a portal registration or filing the
governor refuses, suppress a compliance record, or claim a legal/tax
conclusion the governor has not cleared. `:filing/submit` is never in
any phase's `:auto` set -- it always requires human sign-off.

## What this is NOT

- **Not the government of Palau.** This blueprint is an independent
  operator the government contracts with or that bids into its
  procurement -- never the government itself, and never an official
  channel.
- **Not legal or tax advice.** Every regulatory claim must cite the
  official source and route final filings to Palau-licensed counsel or
  a registered agent where the law requires licensed representation.

## Capability layer

Required capabilities (`blueprint.edn`):

- :identity
- :forms
- :dmn
- :bpmn
- :audit-ledger

See [`docs/business-model.md`](docs/business-model.md) and
[`docs/operator-guide.md`](docs/operator-guide.md).

## License

AGPL-3.0-or-later.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Palau:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.

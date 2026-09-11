(ns culture.facts
  "Country-level regional-culture catalog for Palau (PLW) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.

  Palau is thinly documented on English Wikipedia: no dedicated articles
  were found for a Palauan festival, traditional money (udoud/beads), or
  storyboard-carving craft (search queries returned no results), so those
  candidate kinds were dropped rather than padded with an unverified guess.
  The 5 entries below are everything that verified on 2026-07-17; the
  :dish entries are sourced from the \"Cuisine\" subsection of the main
  `Palau` article (the `Palauan cuisine` article title is itself only a
  #REDIRECT to that section, confirmed via the MediaWiki API).")

(def catalog
  "iso3 -> vector of culture entries."
  {"PLW"
   [{:culture/id "plw.dish.fruit-bat-soup"
     :culture/name "Fruit bat soup"
     :culture/country "PLW"
     :culture/kind :dish
     :culture/summary "Described as a Palauan culinary delicacy in the \"Cuisine\" section of the Palau country article."
     :culture/url "https://en.wikipedia.org/wiki/Palau"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "plw.dish.tama"
     :culture/name "Tama"
     :culture/country "PLW"
     :culture/kind :dish
     :culture/summary "A dessert developed in Palau, per the \"Cuisine\" section of the Palau country article."
     :culture/url "https://en.wikipedia.org/wiki/Palau"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "plw.beverage.coconut-toddy"
     :culture/name "Coconut toddy"
     :culture/country "PLW"
     :culture/kind :beverage
     :culture/summary "A traditional alcoholic drink made from a coconut on the tree, listed among local Palauan drinks in the \"Cuisine\" section of the Palau country article, alongside a drink made from kava root and the chewing of betel nuts."
     :culture/url "https://en.wikipedia.org/wiki/Palau"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "plw.craft.bai"
     :culture/name "Bai"
     :culture/country "PLW"
     :culture/kind :craft
     :culture/summary "Traditional Palauan meeting houses called bai served as the most important buildings in villages, featuring no dividing walls and decorated with depictions of Palauan legends, with seating for governing elders arranged by rank."
     :culture/url "https://en.wikipedia.org/wiki/Bai_(Palau)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "plw.heritage.rock-islands-southern-lagoon"
     :culture/name "Rock Islands Southern Lagoon"
     :culture/name-local "Chelbacheb"
     :culture/country "PLW"
     :culture/kind :heritage
     :culture/summary "The Rock Islands of Palau (Chelbacheb), a collection of several hundred small limestone or coral uprises, were declared a UNESCO World Heritage Site in 2012 as the Rock Islands Southern Lagoon."
     :culture/url "https://en.wikipedia.org/wiki/Rock_Islands_(Palau)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-plw culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "PLW"))
                 " PLW entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))

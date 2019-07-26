(ns ^:figwheel-hooks workation.core
  (:require [goog.dom :as gdom]
            [reagent.core :as reagent]))

(def destinations [{:city "Toronto"
                    :average-price 120
                    :property-count 76
                    :img-url "img/toronto.jpg"
                    :img-alt "Toronto"}
                   {:city "Malibu"
                    :average-price 215
                    :property-count 43
                    :img-url "img/malibu.jpg"
                    :img-alt "Malibu"}
                   {:city "Chicago"
                    :average-price 130
                    :property-count 115
                    :img-url "img/chicago.jpg"
                    :img-alt "Chicago"}
                   {:city "Kansas City"
                    :average-price 140
                    :property-count 45
                    :img-url "img/kc.jpg"
                    :img-alt "Kansas City"}])

(defn destination-card [{:keys [city average-price property-count img-url img-alt]}]
  [:div.mt-6.w-full.px-4 {:class "lg:w-1/2 xl:w-1/3"}
   [:div.flex.items-center.rounded-lg.bg-white.shadow-lg.overflow-hidden
    [:img.h-40.w-32.flex-shrink-0.object-cover.object-center {:src img-url :alt img-alt}]
    [:div.px-4.py-4
     [:h3.text-lg.font-semibold.text-gray-800.city]
     [:p.text-gray-600 (str "$" average-price " / night average")]
     [:div.mt-4
      [:a.text-indigo-500.hover:text-indigo-400 {:href "#"} (str "Explore " property-count " properties")]]]]])

(defn destination-cards []
  [:div.flex.flex-wrap.-mx-4
   (for [d destinations]
     ^{:key d}
     [destination-card d])])

(defn mount-destination-cards []
  (let [el (gdom/getElement "city-cards")]
    (reagent/render-component [destination-cards] el)))

(mount-destination-cards)


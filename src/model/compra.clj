(ns model.compra
  (:require [schema.core :as s])
  (:use [java-time :only [local-date local-date?]]))

(def Compra
  {
   :compra/id              java.util.UUID
   ;:data            s/Str
   :compra/valor           BigDecimal
   :compra/estabelecimento s/Str
   :compra/categoria       s/Str
   })



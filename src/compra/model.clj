(ns compra.model
  (:require [schema.core :as s]))

(s/set-fn-validation! true)

(def Compra
  {:compra-id       s/Uuid
   :data            s/Str
   :valor           s/Num
   :estabelecimento s/Str
   :categoria       s/Str
   :cartao-id       s/Uuid})



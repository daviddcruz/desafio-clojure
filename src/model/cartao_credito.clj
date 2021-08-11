(ns model.cartao_credito
  (:require [schema.core :as s]))

(def Cartao {
             :cartao/id       java.util.UUID
             :cartao/numero   s/Num
             :cartao/cvv      s/Num
             :cartao/validade s/Str
             :cartao/limite   s/Num
             })


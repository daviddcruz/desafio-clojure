(ns cartao_credito.model
  (:require [schema.core :as s]))


(s/set-fn-validation! true)

(def Cartao {:id         s/Uuid
             :numero     s/Num
             :cvv        s/Num
             :validade   s/Str
             :limite     s/Num
             :cliente-id s/Uuid
             })


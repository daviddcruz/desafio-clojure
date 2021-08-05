(ns compra.logic
  (:require [schema.core :as s]
            [compra.model :as c.model])
  (:use [java-time :only [local-date local-date?]]))

(def LocalDate (s/pred local-date? 'data-valida))

(s/defn cria-nova-compra :- c.model/Compra
  [
   id :- s/Uuid
   data :- LocalDate
   valor :- s/Num
   estabelecimento :- s/Str
   categoria :- s/Str
   cartao-id :- s/Uuid]
  {
   ;:id        (java.util.UUID/randomUUID)
   :id              id
   :data            (str data)
   :valor           valor
   :estabelecimento estabelecimento
   :categoria       categoria
   :cartao-id       cartao-id})


(defn total-das-compras
  [compras]
  (->> compras
       (map :valor compras)
       (reduce +)))

(defn gastos-compras-por-categoria
  [[categoria compras]]
  {:categoria   categoria
   :gasto-total (total-das-compras compras)})


(defn total-compras-por-categoria
  [compras]
  (->> compras
       (group-by :categoria)
       (map gastos-compras-por-categoria)))


(defn compras-por-estabelecimento
  [estabelecimento compras]
  (->> compras
       (filter #(= (:estabelecimento %) estabelecimento))))


(defn obtem-o-mes [compra] (subs (:data compra) 5 7))

(defn comprou-no-mes?
  [compra mes]
  (= (obtem-o-mes compra) mes))

(defn total-das-compras
  [compras]
  (->> compras
       (map :valor compras)
       (reduce +)))

(defn retorna-dados-cartao
  [cartao-id cartoes]
  (filter (fn [cartao] (= (:cartao-id cartao) cartao-id))) cartoes)

(defn gastos-compras-por-cartao
  [[cartao-id compras] cartoes]
  {:cartao      (:numero (retorna-dados-cartao cartao-id cartoes))
   :gasto-total (total-das-compras compras)
   })

(defn fatura-por-mes
  [mes compras cartoes]
  (let [compra (->>
                 compras
                 (filter #(comprou-no-mes? % mes))
                 (group-by :cartao-id))]
    (map gastos-compras-por-cartao compra cartoes)))

(defn listar-compras [compras] compras)



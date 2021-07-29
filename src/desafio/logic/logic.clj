(ns desafio.logic.logic
  (:require [desafio.db.db :as d.db]))

(use '[java-time :only (format)])

(defn retorna-todas-compras [] (d.db/retorna-todas-compras))

(defn retorna-clientes [] (d.db/retorna-clientes))

(defn retorna-cartoes [] (d.db/retorna-cartoes))

(defn total-das-compras
  [compras]
  (->> compras
       (map :valor compras)
       (reduce +)))

(defn gastos-compras-por-categoria
  [[categoria compras]]
  {:categoria   categoria
   :gasto-total (total-das-compras compras)
   }
  )

(defn retorna-dados-cartao
  [cartao-id]
  (filter #(= (:cartao-id %) cartao-id) (retorna-cartoes)))

(defn gastos-compras-por-cartao
  [[cartao compras]]
  {:cartao      (:numero (first (retorna-dados-cartao cartao)))
   :gasto-total (total-das-compras compras)
   }
  )

(defn comprou-no-mes?
  [compra mes]
  (= (format "MM" (:data compra)) mes))

(defn fatura-por-mes [mes] (->>
                             (d.db/retorna-todas-compras)
                             (filter #(comprou-no-mes? % mes))
                             (group-by :cartao-id)
                             (map gastos-compras-por-cartao)))




(defn total-compras-por-categoria [] (map
                                       gastos-compras-por-categoria
                                       (group-by :categoria (d.db/retorna-todas-compras))))


(defn compras-por-estabelecimento
  [estabelecimento] (filter (fn
                              [compra]
                              (identical? (:estabelecimento compra) estabelecimento))
                            (d.db/retorna-todas-compras)))



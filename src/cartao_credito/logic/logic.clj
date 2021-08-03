(ns cartao_credito.logic.logic
  (:require [cartao_credito.db.db :as d.db]))

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
  (filter (fn
            [cartao]
            (= (:cartao-id cartao) cartao-id)
            ))
  (retorna-cartoes))

(defn gastos-compras-por-cartao
  [[cartao-id compras]]
  {:cartao      (:numero (first (retorna-dados-cartao cartao-id)))
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



(defn total-compras-por-categoria
  []
  (->> (d.db/retorna-todas-compras)
       (group-by :categoria)
       (map gastos-compras-por-categoria)
       )
  )

(defn compras-por-estabelecimento
  [estabelecimento]
  (->> (d.db/retorna-todas-compras)
       (filter (fn
                 [compra]
                 (= (:estabelecimento compra) estabelecimento)))
       ))
(ns desafio.core
  (:use [desafio.cliente :as cliente])
  (:use [desafio.cartao :as cartao])
  (:use [desafio.db :as d.db])
  )

(println "Dados do Cliente:")
(println cliente)

(println "Dados do Cartão:")
(println (class cartao))
(println cartao)

(println "Compras realizadas:")
(println d.db/compra)

(println "Gastos por categoria:")


(
  defn total-das-compras
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

(println (map
           gastos-compras-por-categoria
           (group-by :categoria d.db/compra)))



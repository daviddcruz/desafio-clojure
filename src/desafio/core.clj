(ns desafio.core
  (:use [desafio.cliente :as d.cliente])
  (:use [desafio.cartao :as d.cartao])
  (:use [desafio.db :as d.db])
  )

(use '[java-time :only (format)])


(println "Dados do Cliente:")
(println d.cliente/cliente)

(println "Dados do Cartão:")
(println d.cartao/cartao)

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

(defn gastos-compras-por-cartao
  [[cartao compras]]
  {:cartao   cartao
   :gasto-total (total-das-compras compras)
   }
  )

(println (map
           gastos-compras-por-categoria
           (group-by :categoria d.db/compra)))

(println "Compras por estabelecimento:")

(println (filter (fn [compra] (identical?
                                (:estabelecimento compra) "Renner")) d.db/compra))

(println "Gasto por mês:")

(defn comprou-no-mes?
  [compra mes]
  (= (format "MM" (:data compra)) mes))


 (->>
  d.db/compra
  (filter #(comprou-no-mes? % "02"))
  (group-by :cartao-numero)
  (map gastos-compras-por-cartao)
  println
  )
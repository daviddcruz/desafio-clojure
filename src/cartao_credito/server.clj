(ns cartao_credito.server
  (:require [cartao_credito.logic.logic :as d.logic])
  (:use [clojure.pprint]))


(println "\n\n Clientes:")
(pprint (d.logic/retorna-clientes))

(println "\n\n Cartões:")
(pprint (d.logic/retorna-cartoes))

(println "\n\nTodas compras realizadas:")
(pprint (d.logic/retorna-todas-compras))

(println "\n\n Gastos por categoria:")
(pprint (d.logic/total-compras-por-categoria))

(println "\n\n Compras por estabelecimento:")
(pprint (d.logic/compras-por-estabelecimento "Atacadão"))

(println "\n\n Gasto por mês:")
(pprint (d.logic/fatura-por-mes "02"))



(ns desafio.core
  (:require [desafio.logic.logic :as d.logic]))


(println "Clientes:")
(println (d.logic/retorna-clientes))

(println "Cartões:")
(println (d.logic/retorna-cartoes))

(println "Compras realizadas:")
(println (d.logic/retorna-todas-compras))

(println "Gastos por categoria:")
(println (d.logic/total-compras-por-categoria))

(println "Compras por estabelecimento:")
(println (d.logic/compras-por-estabelecimento "Renner"))

(println "Gasto por mês:")
(println (d.logic/fatura-por-mes "02"))


(ns desafio.core
  (:require [desafio.logic.logic :as d.logic]))


(println "Dados do Cliente:")
(println (d.logic/retorna-cliente))

(println "Dados do Cartão:")
(println (d.logic/retorna-cartao))

(println "Compras realizadas:")
(println (d.logic/retorna-todas-compras))

(println "Gastos por categoria:")
(println (d.logic/total-compras-por-categoria))

(println "Compras por estabelecimento:")
(println (d.logic/compras-por-estabelecimento "Renner"))

(println "Gasto por mês:")
(println (d.logic/fatura-por-mes "02"))
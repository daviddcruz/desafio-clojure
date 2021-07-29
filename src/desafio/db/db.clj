(ns desafio.db.db
  (:require [desafio.model.compra :as d.compra])
  (:require [desafio.model.cliente :as d.cliente])
  (:require [desafio.model.cartao :as d.cartao]))

(use '[java-time :only (local-date)])


(def cliente (d.cliente/cria-novo-cliente
               "Gabriel Lima"
               "123456789"
               "gabriel.lima@email.com"))

(def cartao (d.cartao/cria-novo-cartao
              2555
              155
              "07/28"
              5000
              (:cliente-id cliente)))

(def compra [
             (d.compra/cria-nova-compra
               (local-date 2021 07 29)
               1000
               "Inova Imobiliaria"
               "Despesas"
               (:cartao-id cartao))
             (d.compra/cria-nova-compra
               (local-date 2021 07 29)
               2000
               "Frango Frito"
               "Comida"
               (:cartao-id cartao))
             (d.compra/cria-nova-compra
               (local-date 2021 06 29)
               20
               "Atacadão"
               "Comida"
               (:cartao-id cartao))
             (d.compra/cria-nova-compra
               (local-date 2021 06 29)
               40
               "Riachuelo"
               "Roupa"
               (:cartao-id cartao))
             (d.compra/cria-nova-compra
               (local-date 2021 05 29)
               100
               "Renner"
               "Roupa"
               (:cartao-id cartao))
             (d.compra/cria-nova-compra
               (local-date 2021 02 28)
               200
               "Renner"
               "Roupa"
               (:cartao-id cartao))
             ])

(defn retorna-todas-compras [] compra)

(defn retorna-cliente [] cliente)

(defn retorna-cartao [] cartao)







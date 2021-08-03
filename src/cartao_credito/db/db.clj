(ns cartao_credito.db.db
  (:require [cartao_credito.model.compra :as d.compra])
  (:require [cartao_credito.model.cliente :as d.cliente])
  (:require [cartao_credito.model.cartao :as d.cartao]))

(use '[java-time :only (local-date)])


(def cliente1 (d.cliente/cria-novo-cliente
                "Gabriel Lima"
                "123456789"
                "gabriel.lima@email.com"))

(def cliente2 (d.cliente/cria-novo-cliente
                "Jose Silva"
                "44444444444"
                "jose.silva@email.com"))

(def clientes [cliente1 cliente2])

(def cartao1 (d.cartao/cria-novo-cartao
               2555
               155
               "07/28"
               5000
               (:cliente-id cliente1)))

(def cartao2 (d.cartao/cria-novo-cartao
               2444
               144
               "08/29"
               6000
               (:cliente-id cliente2)))

(def cartoes [cartao1 cartao2])

(def compras [
              (d.compra/cria-nova-compra
                (local-date 2021 07 29)
                1000
                "Inova Imobiliaria"
                "Despesas"
                (:cartao-id cartao2))

              (d.compra/cria-nova-compra
                (local-date 2021 07 29)
                2000
                "Frango Frito"
                "Comida"
                (:cartao-id cartao1))

              (d.compra/cria-nova-compra
                (local-date 2021 06 29)
                20
                "Atacadão"
                "Comida"
                (:cartao-id cartao1))

              (d.compra/cria-nova-compra
                (local-date 2021 06 29)
                40
                "Riachuelo"
                "Roupa"
                (:cartao-id cartao2))

              (d.compra/cria-nova-compra
                (local-date 2021 05 29)
                100
                "Renner"
                "Roupa"
                (:cartao-id cartao1))

              (d.compra/cria-nova-compra
                (local-date 2021 02 28)
                200
                "Renner"
                "Roupa"
                (:cartao-id cartao2))
              ])

(defn retorna-todas-compras [] compras)

(defn retorna-clientes [] clientes)

(defn retorna-cartoes [] cartoes)







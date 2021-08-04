(ns compra.db
  (:require [compra.logic :as compra.logic]
            [cartao_credito.db :as cartao.db]
            [java-time :refer :all]))

(def compras [
              (compra.logic/cria-nova-compra
                (format "dd/MM/yyyy" (zoned-date-time 2021 07 29))
                1000
                "Inova Imobiliaria"
                "Despesas"
                (:id cartao.db/cartao2))

              (compra.logic/cria-nova-compra
                (format "dd/MM/yyyy" (zoned-date-time 2021 07 29))
                2000
                "Frango Frito"
                "Comida"
                (:id cartao.db/cartao1))

              (compra.logic/cria-nova-compra
                (format "dd/MM/yyyy" (zoned-date-time 2021 06 29))
                20
                "Roldao"
                "Comida"
                (:id cartao.db/cartao1))

              (compra.logic/cria-nova-compra
                (format "dd/MM/yyyy" (zoned-date-time 2021 06 29))
                40
                "Riachuelo"
                "Roupa"
                (:id cartao.db/cartao2))

              (compra.logic/cria-nova-compra
                (format "dd/MM/yyyy" (zoned-date-time 2021 05 29))
                100
                "Renner"
                "Roupa"
                (:id cartao.db/cartao1))

              (compra.logic/cria-nova-compra
                (format "dd/MM/yyyy" (zoned-date-time 2021 02 28))
                200
                "Renner"
                "Roupa"
                (:id cartao.db/cartao2))
              ])

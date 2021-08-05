(ns compra.db
  (:require [schema.core :as s]
            [compra.logic :as compra.logic]
            [cartao_credito.db :as cartao.db])
  (:use [java-time :only [local-date]]))

(def compras [
              (compra.logic/cria-nova-compra
                #uuid "1b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (local-date 2021 02 28)
                1000
                "Inova Imobiliaria"
                "Despesas"
                #uuid "1c88c421-a818-4a8d-bb3e-6dad8dabb4ae")

              (compra.logic/cria-nova-compra
                #uuid "1b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (local-date 2021 02 28)
                2000
                "Frango Frito"
                "Comida"
                #uuid "2c88c421-a818-4a8d-bb3e-6dad8dabb4ae")

              (compra.logic/cria-nova-compra
                #uuid "2b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (local-date 2021 05 29)
                20
                "Roldao"
                "Comida"
                #uuid "2c88c421-a818-4a8d-bb3e-6dad8dabb4ae")

              (compra.logic/cria-nova-compra
                #uuid "3b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (local-date 2021 05 29)
                40
                "Riachuelo"
                "Roupa"
                #uuid "1c88c421-a818-4a8d-bb3e-6dad8dabb4ae")

              (compra.logic/cria-nova-compra
                #uuid "5b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (local-date 2021 03 29)
                100
                "Renner"
                "Roupa"
                #uuid "1c88c421-a818-4a8d-bb3e-6dad8dabb4ae")

              (compra.logic/cria-nova-compra
                #uuid "4b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (local-date 2021 01 29)
                200
                "Renner"
                "Roupa"
                #uuid "1c88c421-a818-4a8d-bb3e-6dad8dabb4ae")
              ])

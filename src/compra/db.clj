(ns compra.db
  (:require [compra.logic :as compra.logic]
            [cartao_credito.db :as cartao.db]
            [java-time :refer :all]))

(def compras [
              (compra.logic/cria-nova-compra
                #uuid "1b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (format "dd/MM/yyyy" (zoned-date-time 2021 07 29))
                1000
                "Inova Imobiliaria"
                "Despesas"
                #uuid "1c88c421-a818-4a8d-bb3e-6dad8dabb4ae")

              (compra.logic/cria-nova-compra
                #uuid "1b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (format "dd/MM/yyyy" (zoned-date-time 2021 07 29))
                2000
                "Frango Frito"
                "Comida"
                #uuid "2c88c421-a818-4a8d-bb3e-6dad8dabb4ae")

              (compra.logic/cria-nova-compra
                #uuid "2b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (format "dd/MM/yyyy" (zoned-date-time 2021 06 29))
                20
                "Roldao"
                "Comida"
                #uuid "2c88c421-a818-4a8d-bb3e-6dad8dabb4ae")

              (compra.logic/cria-nova-compra
                #uuid "3b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (format "dd/MM/yyyy" (zoned-date-time 2021 06 29))
                40
                "Riachuelo"
                "Roupa"
                #uuid "1c88c421-a818-4a8d-bb3e-6dad8dabb4ae")

              (compra.logic/cria-nova-compra
                #uuid "5b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (format "dd/MM/yyyy" (zoned-date-time 2021 05 29))
                100
                "Renner"
                "Roupa"
                #uuid "1c88c421-a818-4a8d-bb3e-6dad8dabb4ae")

              (compra.logic/cria-nova-compra
                #uuid "4b88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                (format "dd/MM/yyyy" (zoned-date-time 2021 02 28))
                200
                "Renner"
                "Roupa"
                #uuid "1c88c421-a818-4a8d-bb3e-6dad8dabb4ae")
              ])

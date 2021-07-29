(ns desafio.db
  (:require [desafio.compra :refer [map->Compra]]))

(use '[java-time :only (local-date)])

(def compra [
             (map->Compra
               {:data            (local-date 2021 07 29)
                :valor           1000
                :estabelecimento "Inova Imobiliaria"
                :categoria       "Despesas"
                :cartao-numero   1234})
             (map->Compra
               {:data            (local-date 2021 07 29)
                :valor           2000
                :estabelecimento "Frango Frito"
                :categoria       "Comida"
                :cartao-numero   1234})
             (map->Compra
               {:data            (local-date 2021 06 29)
                :valor           20
                :estabelecimento "Atacadão"
                :categoria       "Comida"
                :cartao-numero   4567})
             (map->Compra
               {:data            (local-date 2021 06 29)
                :valor           40
                :estabelecimento "Riachuelo"
                :categoria       "Roupa"
                :cartao-numero   4567})
             (map->Compra
               {:data            (local-date 2021 05 29)
                :valor           100
                :estabelecimento "Renner"
                :categoria       "Roupa"
                :cartao-numero   8888})
             (map->Compra
               {:data            (local-date 2021 02 28)
                :valor           200
                :estabelecimento "Renner"
                :categoria       "Roupa"
                :cartao-numero   2222})
             ])







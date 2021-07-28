(ns desafio.db
  (:require [desafio.compra :refer [->Compra]]))

(def compra [
             (map->Compra
               {:data            27072021
                :valor           1000
                :estabelecimento "Inova Imobiliaria"
                :categoria       "Despesas"
                :cartao-numero   1234})
             (map->Compra
               {:data            29072021
                :valor           2000
                :estabelecimento "Frango Frito"
                :categoria       "Comida"
                :cartao-numero   1234})
             (map->Compra
               {:data            29072021
                :valor           20
                :estabelecimento "Atacadão"
                :categoria       "Comida"
                :cartao-numero   1234})
             (map->Compra
               {:data            01072021
                :valor           40
                :estabelecimento "Riachuelo"
                :categoria       "Roupa"
                :cartao-numero   1234})
             (map->Compra
               {:data            02072021
                :valor           100
                :estabelecimento "Renner"
                :categoria       "Roupa"
                :cartao-numero   1234})
             ])







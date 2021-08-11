(ns server
  (:require
    [datomic.api :as d]
    ;[logic.cliente :as cliente.logic]
    [db.datomic :as db]
    ;[logic.compra :as compra.logic]
    )
  (:use [clojure.pprint]))

(defn uuid [] (java.util.UUID/randomUUID))

(db/apaga-banco)

(def conn (db/abre-conexao))

(db/cria-schema conn)

(def cliente1 {
               :cliente/id    (uuid)
               :cliente/nome  "Jose Silva"
               :cliente/cpf   44444444444
               :cliente/email "jose.silva@email.com"})

(def cliente2 {
               :cliente/id    (uuid)
               :cliente/nome  "David Silva"
               :cliente/cpf   999999999999
               :cliente/email "david.silva@email.com"})

(def cartao1 {
              :cartao/id       (uuid)
              :cartao/numero   88884444
              :cartao/cvv      123
              :cartao/validade "07/28"
              :cartao/limite   50000M})

(def cartao2 {
              :cartao/id       (uuid)
              :cartao/numero   52152151
              :cartao/cvv      545
              :cartao/validade "07/29"
              :cartao/limite   50000M})

(def compra1 {:compra/id              (uuid)
              :compra/valor           15.52M
              :compra/estabelecimento "Nike"
              :compra/categoria       "Roupa"})

(def compra2 {:compra/id              (uuid)
              :compra/valor           25.52M
              :compra/estabelecimento "Dicila"
              :compra/categoria       "Comida"})

(def compra3 {:compra/id              (uuid)
              :compra/valor           25.52M
              :compra/estabelecimento "BK"
              :compra/categoria       "Comida"})


(db/adiciona-ou-altera-cliente conn [cliente1])

(println "\nCompras realizadas:")
(db/adiciona-ou-altera-compra conn [compra1 compra2])
(pprint (db/todas-as-compras (d/db conn)))

(println "\nCartoes cadastrados:")
(db/adiciona-ou-altera-cartao conn [cartao1 cartao2])
(pprint (db/todos-os-cartoes (d/db conn)))

(db/atribui-compras conn [compra1, compra2] cliente1)
(db/atribui-cartoes conn [cartao1, cartao2] cliente1)

(println "\nClientes cadastrados:")
(pprint (db/todos-os-clientes (d/db conn)))

(println "\nCliente com maior numero de compras")
(pprint (db/cliente-com-maior-numero-de-compras (d/db conn)))

(println "\nCliente maior valor de compras")
(pprint (db/cliente-com-maior-valor-de-compra (d/db conn)))

(println "\nCliente que nao realizou nenhuma compras")
(pprint (db/clientes-que-nao-realizaram-compra (d/db conn)))



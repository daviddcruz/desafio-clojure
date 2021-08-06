(ns server
  (:require [cliente.db :as cliente.db]
            [cartao_credito.logic :as cartao.logic]
            [cartao_credito.db :as cartao.db]
            [cliente.logic :as cliente.logic]
            [compra.db :as compra.db]
            [clojure.test.check.generators :as gen]
            [compra.logic :as compra.logic]
            [cliente.model :as c.model]
            )
  (:use [clojure.pprint]))


(println "\n\n Clientes listados:")
(pprint (cliente.logic/listar-clientes cliente.db/clientes))

(println "\n\n Cartões listados:")
(pprint (cartao.logic/listar-cartoes cartao.db/cartoes))
;
(println "\n\n Compras listadas:")
(pprint (compra.logic/listar-compras compra.db/compras))
;
(println "\n\n Gastos por categoria:")
(pprint (compra.logic/total-compras-por-categoria compra.db/compras))
;
(println "\n\n Compra por estabelecimento:")
(pprint (compra.logic/compras-por-estabelecimento "Renner" compra.db/compras))

(println "\n\n Gasto por mês:")
(pprint (compra.logic/fatura-por-mes "03" compra.db/compras cartao.db/cartoes))




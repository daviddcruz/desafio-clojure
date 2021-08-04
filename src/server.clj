(ns server
  (:require [cliente.db :as cliente.db]
            [cartao_credito.db :as cartao.db]
            [compra.db :as compra.db]
            [compra.logic :as compra.logic])
  (:use [clojure.pprint]))


(println "\n\n Clientes listados:")
(pprint cliente.db/clientes)

(println "\n\n Cartões listados:")
(pprint cartao.db/cartoes)
;
(println "\n\n Compras listadas:")
(pprint (compra.logic/listar-compras compra.db/compras))
;
(println "\n\n Gastos por categoria:")
(pprint (compra.logic/total-compras-por-categoria compra.db/compras))
;
(println "\n\n Compra por estabelecimento:")
(pprint (compra.logic/compras-por-estabelecimento "Renner" compra.db/compras))

;(println "\n\n Gasto por mês:")
;(pprint (compra.logic/fatura-por-mes "07" compra.db/compras cartao.db/cartoes))





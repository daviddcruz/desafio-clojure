(ns desafio.compra.logic-test
  (:require [clojure.test :refer :all]
            [compra.logic :as c.logic]
            [compra.db :as c.db]
            [schema.test :as schema.test]
            [matcher-combinators.test :refer [match?]]
            [clojure.test.check.clojure-test :refer [defspec]])
  (:use [java-time :only [local-date]])
  (:use [clojure.pprint]))

(use-fixtures :once schema.test/validate-schemas)

(deftest retornar-id-da-compra
  (testing "deve retorna o id da compra ao criar um compra"
    (is (match? {:cartao-id #uuid "61fb3ac8-b7dd-45cf-a954-c4d0dabe73f7"}
                (c.logic/cria-nova-compra
                  #uuid "Ab88c421-a818-4a8d-bb3e-6dad8dabb4ae"
                  (local-date 2021 07 29)
                  2000
                  "Frango Frito"
                  "Comida"
                  #uuid "61fb3ac8-b7dd-45cf-a954-c4d0dabe73f7"
                  )))))

(deftest cria-nova-compra-test
  (testing "valida retorno de um nova compra"
    (is (match?
          {:valor           2000,
           :estabelecimento "Frango Frito",
           :categoria       "Comida",
           }
          (c.logic/cria-nova-compra
            #uuid "Ab88c421-a818-4a8d-bb3e-6dad8dabb4ae"
            (local-date 2021 07 29)
            2000
            "Frango Frito"
            "Comida"
            #uuid "5b88c421-a818-4a8d-bb3e-6dad8dabb4ae")
          ))))

(deftest listar-compras-test
  (testing "validar retorno da primeira compra"
    (is (match?
          {:valor           1000,
           :estabelecimento "Inova Imobiliaria",
           :categoria       "Despesas",
           }
          (first (c.logic/listar-compras c.db/compras))
          ))))

(deftest gastos-por-categoria-test
  (testing "valida retorno dos gastos por categoria"
    (is (match?
          [{:categoria "Despesas", :gasto-total 1000}
           {:categoria "Comida", :gasto-total 2020}
           {:categoria "Roupa", :gasto-total 340}]
          (c.logic/total-compras-por-categoria c.db/compras)
          ))))



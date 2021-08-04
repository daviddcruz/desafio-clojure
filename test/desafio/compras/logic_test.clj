(ns desafio.compras.logic-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.generators :as gen]
            [compra.logic :as c.logic]
            [compra.db :as c.db]
            [java-time :refer :all]))

(deftest cria-nova-compra-test
  (testing "Valida retorno de um nova compra"
    (is (= (c.logic/cria-nova-compra
             #uuid "Ab88c421-a818-4a8d-bb3e-6dad8dabb4ae"
             (format "dd/MM/yyyy" (zoned-date-time 2021 07 29))
             2000
             "Frango Frito"
             "Comida"
             #uuid "5b88c421-a818-4a8d-bb3e-6dad8dabb4ae")
           {:id              #uuid "Ab88c421-a818-4a8d-bb3e-6dad8dabb4ae",
            :data            "29/07/2021", :valor 2000,
            :estabelecimento "Frango Frito",
            :categoria       "Comida",
            :cartao-id       #uuid "5b88c421-a818-4a8d-bb3e-6dad8dabb4ae"}
           ))))

(deftest listar-compras-test
  (testing "Validar retorno da primeira compra"
    (is (= (first (c.logic/listar-compras c.db/compras))
           {:id              #uuid "1b88c421-a818-4a8d-bb3e-6dad8dabb4ae",
            :data            "29/07/2021",
            :valor           1000,
            :estabelecimento "Inova Imobiliaria",
            :categoria       "Despesas",
            :cartao-id       #uuid "1c88c421-a818-4a8d-bb3e-6dad8dabb4ae"}))))



(deftest gastos-por-categoria-test
  (testing "Valida retorno dos gastos por categoria"
    (is (= (c.logic/total-compras-por-categoria c.db/compras)
           [{:categoria "Despesas", :gasto-total 1000}
                 {:categoria "Comida", :gasto-total 2020}
                 {:categoria "Roupa", :gasto-total 340}]))))







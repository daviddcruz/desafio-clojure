(ns desafio.compra.logic-test
  (:require [clojure.test :refer :all]
            [compra.compra :as c.logic]
            [compra.db :as c.db]
            [schema.test :as schema.test]
            [clojure.test.check.properties :as p]
            [compra.compra :as c.model]
            [schema-generators.generators :as g]
            [matcher-combinators.test :refer [match?]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.clojure-test :refer [defspec]])
  (:use [java-time :only [local-date]])
  (:use [clojure.pprint])
  (:use [java-time :only [local-date]]))

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


;(defspec realiza-compras 50
;         (prop/for-all
;           [compras (gen/vector compra-gen 0 10)]
;           (let [compras-final (reduce adiciona-compra {} compras)]
;             (is (= (count compras) (count compras-final))))))

;(gen/fmap (fn [x] (time/+d #nu/date "2015-10-01" x)) gen/small-integer)
(def data-gen
  (gen/fmap (fn [[dia mes]]
              (str dia "/" mes "/2021"))
            (gen/tuple (gen/choose 1 28)
                       (gen/choose 1 12))))



(defspec teste-de-baseado-em-propriedade 3
         (p/for-all [compra (g/generator  c.model/Compra)]

                    (println "**************")
                    (pprint compra)
                    (println "**************\n")
                    (= 1 1)))

;(defspec addition-is-commutative
;         (p/for-all [ints (gen/vector gen/small-integer)]
;                    (println "\n**************")
;                    (println ints)
;                    (print "**************")
;                    (= (apply count ints)
;                       (apply count (reverse ints)))))


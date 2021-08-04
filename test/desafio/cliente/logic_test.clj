(ns desafio.cliente.logic-test
  (:require [clojure.test :refer :all]
            [cliente.logic :as c.logic]
            [clojure.test.check.generators :as gen]))

(deftest nome (apply str (gen/sample gen/string-alphanumeric 5)))
(deftest email (apply str (gen/sample gen/string-alphanumeric 20)))
(deftest cpf (gen/sample gen/nat 11))

(deftest adicionarcria-novo-cliente?-test
  (testing "aceita um cliente"
     (is (c.logic/cria-novo-cliente
           "Gabriel Lima"
           123456789
           "gabriel.lima@email.com"))))

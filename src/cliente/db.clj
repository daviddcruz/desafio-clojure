(ns cliente.db
  (:require [cliente.logic :as c.logic]))

(def cliente1 (c.logic/cria-novo-cliente
                "Gabriel Lima"
                123456789
                "gabriel.lima@email.com"))

(def cliente2 (c.logic/cria-novo-cliente
                "Jose Silva"
                44444444444
                "jose.silva@email.com"))

(def clientes [cliente1 cliente2])



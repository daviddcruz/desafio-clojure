(ns cliente.logic
  (:require [schema.core :as s]
            [cliente.model :as c.model]))


(s/defn cria-novo-cliente :- c.model/Cliente
  [
   nome :- s/Str
   cpf :- s/Num
   email :- s/Str
   ]
  {:id    (java.util.UUID/randomUUID),
   :nome  nome,
   :cpf   cpf,
   :email email
   })


(defn listar-clientes [clientes] clientes)
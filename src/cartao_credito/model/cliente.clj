(ns cartao_credito.model.cliente
  (:use [schema.core :as s]))

(s/defrecord Cliente [
                    cliente-id :- Long
                    nome :- s/Str
                    cpf :- Long
                    email :- s/Str
                    ])

(defn cria-novo-cliente
  [nome
   cpf
   email]
  (->Cliente (str (java.util.UUID/randomUUID))
             nome
             cpf
             email))


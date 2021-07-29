(ns desafio.model.cliente)

(defrecord Cliente [cliente-id nome cpf email])

(defn cria-novo-cliente
  [nome cpf email]
  (->Cliente (str (java.util.UUID/randomUUID)) nome cpf email))


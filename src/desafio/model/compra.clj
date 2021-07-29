(ns desafio.model.compra)

(defrecord Compra [
                   compra-id
                   data
                   valor
                   estabelecimento
                   categoria
                   cartao-id])


(defn cria-nova-compra
  [data
   valor
   estabelecimento
   categoria
   cartao-id]
  (->Compra (str (java.util.UUID/randomUUID))
             data
             valor
             estabelecimento
             categoria
             cartao-id))



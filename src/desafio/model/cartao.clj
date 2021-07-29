(ns desafio.model.cartao)

(defrecord Cartao [
                   cartao-id
                   numero
                   cvv
                   validade
                   limite
                   cliente-id])

(defn cria-novo-cartao
  [
   numero
   cvv
   validade
   limite
   cliente-id]
  (->Cartao (str (java.util.UUID/randomUUID))
            numero
            cvv
            validade
            limite
            cliente-id))






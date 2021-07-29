(ns desafio.cartao)

(defrecord Cartao [numero
                   cvv
                   validade
                   limite
                   cliente-cpf])

(def cartao (map->Cartao {:numero      1234
                          :cvv         155
                          :validade    "07/28"
                          :limite      2500
                          :cliente-cpf 0}))



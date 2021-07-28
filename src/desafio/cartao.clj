(ns desafio.cartao)

(defrecord Cartao [numero cvv validade limite cliente-cpf])

(def cartao (map->Cartao {:numero      1234
                          :cvv         155
                          :validade    2028
                          :limite      2500
                          :cliente-cpf 0}))


; (def cartao {:numero      1234
;             :cvv         155
;            :validade    2028
;            :limite      2500
;           :cliente-cpf 0})


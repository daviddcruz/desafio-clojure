(ns desafio.cliente)

(defrecord Cliente [nome cpf email])

(def cliente (map->Cliente {:nome  "David Cruz"
                            :cpf   12345678910
                            :email "teste@teste.com"}))


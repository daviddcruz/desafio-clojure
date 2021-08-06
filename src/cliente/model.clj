(ns cliente.model
  (:require [schema.core :as s]))

;(def PostInt (s/pred pos-int? 'numero-inteiro))
;(def NotEmpty (s/pred string? 'nao-vazio))

(s/set-fn-validation! true)

(def Cliente {
              :cliente-id s/Uuid
              :nome       s/Str
              :cpf        s/Num
              :email      s/Str})


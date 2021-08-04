(ns cliente.model
  (:require [schema.core :as s]))


(s/set-fn-validation! true)

(def Cliente {
              :id s/Uuid,
              :nome       s/Str,
              :cpf        s/Num,
              :email      s/Str})


(ns desafio.estacionamento)
(use 'java-time)

(def taxa-entrada 5)
(def taxa-por-hora 2)
(def hora-entrada (local-date-time 2021 05 18 8 34))
(def hora-saida (month))


(def duracao (time-between hora-entrada hora-saida :minutes))
(def total-a-pagar (+ taxa-entrada (* duracao (float (/ taxa-por-hora 60)))))
(def total-a-pagar-com-threading(->>
                      (float (/ taxa-por-hora 60))
                      (* duracao)
                      (+ taxa-entrada)
                      ))

(println "Horário entrada" hora-entrada)
(println "Horário saída" hora-saida)
(println "Duração" duracao)


(def total-com-duas-casas-decimais (clojure.core/format "%.2f" total-a-pagar-com-threading))
(println "Total a pagar R$" total-com-duas-casas-decimais)

(def lista-teste '(1 "dois" 3 "quatorze"))
(def vetor-teste [1 "dois" 3 "quatorze"])

(println "lista" (conj lista-teste 2048))
(println "vetor" (conj vetor-teste 2048))
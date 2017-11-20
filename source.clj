;; Loose spec: A _function_ (not macro) such that (infix-arithmetic 1 + 2 * 3 - 4) => (- (+ 1 (* 2 3)) 4)

;; Will use railway terminology for functions, so the arguments is a train consist, 
;; with each symbol, operator or parenthesised expression being like a wagon. Each wagon is taken from the train
;; and inspected. If it is an integer, or operator in the current precedence level, it is
;; pushed into the siding for marshalling. When an operator from a lower-than-current
;; precedence is encountered, the wagons in the siding are marshalled, then appended
;; to the mainline.
;;
;; When all wagons have been considered, then the process repeats at the next lower
;; precedence level. This continue until all precedence levels have been considered.

(def operators [[^* ^/] [^+ ^-]])

;; This is part of the logic, but doesn't work as Clojure doesn't seem to be able to
;; use quoted symbols in predicates

(take-while #(or (= ^+ %) (= ^- %) (number? %)) ^(1 + 2 - 3 * 4))

(defn to-marshall
  [operators wagon]
  (if (apply or (flatten

;; here the train is the infix expression that is to be marshalled
(take-while to-marshal train)

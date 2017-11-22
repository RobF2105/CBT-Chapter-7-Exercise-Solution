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

(def operators [['* '/] ['+ '-]])

;; This works - now need to create a function builder so that current-precedence operators can be passed in
(take-while #(or (= '+ %) (= '- %) (number? %)) '(1 + 2 - 3 * 4))

;; This works:
(defn num-or-given-op?
  "(operators) -> bool"
  [operators]
  (fn [arg] (some identity (conj (map (fn [x] (= x arg)) operators) (number? arg)))))

(take-while (num-or-given-op? ['+ '-]) '(1 + 2 - 3 * 4))

;; ignore below for now

(defn to-marshall
  [operators wagon]
  (if (apply or (flatten

;; here the train is the infix expression that is to be marshalled
(take-while to-marshal train)

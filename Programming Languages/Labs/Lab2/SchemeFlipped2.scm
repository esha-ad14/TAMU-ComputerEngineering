(define (even-odd x)
(if (not (number? x)) "not a number" 
(if (= (remainder x 2) 0 ) "even"  "odd"
)))

(define(main) 
(display (even-odd "A"))
(newline) 
(display (even-odd 1))
(newline)
(display (even-odd 2))
)

(main)

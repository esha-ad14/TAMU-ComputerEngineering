(define (typeID x)
  (cond
   ((boolean? x) "Boolean")
   ((integer? x) "Integer")
   ((rational? x) "Float")
   ((number? x) "Number")
   ((string? x) "String")
 )
)

(define (main)
  (display (typeID #t))
  (newline)
  (display (typeID .3))
  (newline)
  (display (typeID "Hi"))
  (newline)
  (display (typeID 4))
)
(main)
; File: SchemeRecursion3.scm
; Written by: Ethan Sexton, Esha Adhawade, Nadxhieli Juarez
; Date: 6/18/22
; TAMU email: ethansexton@tamu.edu, esha.adhawade@tamu.edu  nadxhieli@tamu.edu
; Class: CSCE 314
; Description: returns min and max values
(define (max-list-value list1)
  (cond
   ((null? list1) '())
   ((null? (cdr list1)) (car list1))
   ((> (car list1) (max-list-value (cdr list1))) (car list1))
   (else (max-list-value (cdr list1)))
  )
)

(define (min-list-value list1)
  (cond
   ((null? list1) '())
   ((null? (cdr list1)) (car list1))
   ((< (car list1) (min-list-value (cdr list1))) (car list1))
   (else (min-list-value (cdr list1)))
  )
)

(define (main)
  (display (max-list-value '(1 2 4 5 7 49 13 1)))
  (newline)
  (display (max-list-value '(5 2 8 9 10)))
  (newline)
  (display (min-list-value '(15 2 4 9 11)))
  (newline)
  (display (min-list-value '(1 2 3 4)))

)
(main)

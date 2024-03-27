; File: SchemeRecursion1.scm
; Written by: Ethan Sexton, Esha Adhawade, Nadxhieli Juarez
; Date: 6/18/22
; TAMU email: ethansexton@tamu.edu, esha.adhawade@tamu.edu  nadxhieli@tamu.edu
; Class: CSCE 314
; Description: returns values ranging from 0 to n-1
(define (flatten list)
  (cond ((null? list) '())
          ((list? (car list)) (append (flatten (car list)) (flatten (cdr list))))
        (else (cons (car list) (flatten (cdr list))))
  )
  )
(define (listmaker n)
  (cond
   ((= n 1) 0)
   (else (flatten (cons (listmaker(- n 1))(list(- n 1))))) 
  )
)
(define (main)
  (display (listmaker 5))
)
(main)

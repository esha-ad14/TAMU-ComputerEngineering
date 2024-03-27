; File: SchemeRecursion2.scm
; Written by: Ethan Sexton, Esha Adhawade, Nadxhieli Juarez
; Date: 6/18/22
; TAMU email: ethansexton@tamu.edu, esha.adhawade@tamu.edu  nadxhieli@tamu.edu
; Class: CSCE 314
; Description: returns triple values of list
(define (triple-everything list1)
  (cond
   ((null? list1) '())
   (else (cons (* (car list1) 3) (triple-everything (cdr list1))))
  )
)
(define (main)
  (display (triple-everything '(8 33.5 4/5 5-2i)))
)
(main)

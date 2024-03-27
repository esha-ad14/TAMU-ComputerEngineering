; File: SchemeRecursion5.scm
; Written by: Ethan Sexton, Esha Adhawade, Nadxhieli Juarez
; Date: 6/18/22
; TAMU email: ethansexton@tamu.edu, esha.adhawade@tamu.edu  nadxhieli@tamu.edu
; Class: CSCE 314
; Description: removing items from list
(define (remove-item atom list1)
  (cond
    ((null? list1) '())
    ((list? (car list1)) (cons (remove-item atom (car list1)) (remove-item atom (cdr list1))))
    ((= atom (car list1)) (remove-item atom (cdr list1)))
    (else (cons (car list1) (remove-item atom (cdr list1))))
    )
  )

(define (main)
  (display (remove-item 2 '(1 3 2 4 5 6)))
  (newline)
  (display (remove-item 2 (cons '(1 2 (1 2 (1))) '(1 2 (2 3)))))
)
(main)

#lang scheme
; File: tree2
; Written by: Ethan Sexton, Esha Adhawade, Nadxhieli Juarez
; Date: 6/25/22
; TAMU email: ethansexton@tamu.edu, esha.adhawade@tamu.edu nadxhieli@tamu.edu
; Class: CSCE 314
;Description: locate city

(define (first-node country tree)
  (cond
    ((null? (children tree)) null)
    ((equal? (datum(car (children tree))) country) (datum(children(car(children tree)))))
    (else (first-node country (cdr tree)))
  )
)
(define (main)
  (display (first-node 'china world-tree2))
  (newline)
  (display (first-node 'italy world-tree2))
  (newline)
  (display (first-node 'fakecity world-tree2))  
)
(main)
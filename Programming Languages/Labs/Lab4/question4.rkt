#lang scheme
; File: tree2
; Written by: Ethan Sexton, Esha Adhawade, Nadxhieli Juarez
; Date: 6/25/22
; TAMU email: ethansexton@tamu.edu, esha.adhawade@tamu.edu nadxhieli@tamu.edu
; Class: CSCE 314
;Description: count nodes

(define (count-nodes tree)
  (if (leaf? tree) 1 (count-nodes-in-forest (children tree)))
)

(define (count-nodes-in-forest forest)
  (if (null? forest) 1 (+ (count-nodes (car forest)) (count-nodes-in-forest (cdr forest))))
)

(define (main)
  (display (count-nodes world-tree2))
)
(main)
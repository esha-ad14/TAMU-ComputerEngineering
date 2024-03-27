#lang scheme
; File: tree2
; Written by: Ethan Sexton, Esha Adhawade, Nadxhieli Juarez
; Date: 6/25/22
; TAMU email: ethansexton@tamu.edu, esha.adhawade@tamu.edu nadxhieli@tamu.edu
; Class: CSCE 314
;Description: return farthest right element

(define (right-node tree)
  (cond
    ((null? tree) null?)
    ((null? (children tree)
  )
    (cond
      ((null? (children (car tree))) tree)
      (right-node(children(car tree)))
    ))
   ((right-node (children tree)))
  )
)
(define (main)
  (display (right-node world-tree2))
)
(main)
#lang scheme
; File: tree2
; Written by: Ethan Sexton, Esha Adhawade, Nadxhieli Juarez
; Date: 6/25/22
; TAMU email: ethansexton@tamu.edu, esha.adhawade@tamu.edu nadxhieli@tamu.edu
; Class: CSCE 314
;Description: locate city

(define (main)
  (display (in-tree? 'venezia world-tree2))
  (newline)
  (display (in-tree? 'shanghai world-tree2))
  (newline)
  (display (in-tree? 'california world-tree2))
  (newline)
  (display (in-tree? 'xyzcity world-tree2))
)
(main)
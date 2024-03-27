#lang scheme
; File: tree2
; Written by: Ethan Sexton, Esha Adhawade, Nadxhieli Juarez
; Date: 6/25/22
; TAMU email: ethansexton@tamu.edu, esha.adhawade@tamu.edu nadxhieli@tamu.edu
; Class: CSCE 314
; Description: Display "wales"
(display (datum (caddr (children (cadddr (cdr(children world-tree2)))))))
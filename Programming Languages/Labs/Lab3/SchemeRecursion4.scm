; File: SchemeRecursion4.scm
; Written by: Ethan Sexton, Esha Adhawade, Nadxhieli Juarez
; Date: 6/18/22
; TAMU email: ethansexton@tamu.edu, esha.adhawade@tamu.edu  nadxhieli@tamu.edu
; Class: CSCE 314
; Description: merging lists and removing duplicates
(define(contains list1 num1)
  (cond
   ([null? list1] #f)
   ((= (car list1) num1)#t)
  (else (contains (cdr list1) num1))
))

(define (union list1 list2)
(cond
 ((and (null? list1)(null? list2))'())
 ((null? list1) list2 )
((null? list2) list1)
((contains list2  (car list1)) (union (cdr list1) list2))
 (else  (cons (car list1) (union (cdr list1) list2) ))))



(define (main)
(display (union '(1 2 3 4) '(1 2 -1 5 ))))

(main)

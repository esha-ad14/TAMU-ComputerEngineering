(define CurvedGrade
  (lambda (f x y)
    (f x y)
  )
)
(define (main)
  (display (CurvedGrade * 1.2 80))
  (newline)
  (display (CurvedGrade + 5 90))
)
(main)
.section .text

.globl lab02d

lab02d:
ADD X0, X0, #1000
ADRP X5, myvalue
ADD X5, X5, :lo12: myvalue
STUR X0, [X5, #0]
BR X30
.section .data
myvalue: .byte 16

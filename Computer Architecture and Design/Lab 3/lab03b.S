.section .text
.globl lab03b

lab03b:
      ADRP X3, uin 
      ADD X3, X3, :lo12:uin  //load uin address from memory
      LDR W4, [X3, 0]  //load uin
      MOVZ X5, #10 //move cosntant 10 to reg
loop:
     CBZ X5, finish //if it loops 10 times finish
     SUB X4, X4, #1 //sub uin by 1
     SUB X5, X5, #1 //sub count by 1
     B loop //unconditional branch

finish:
     ADD X0, XZR, X4
     BR X30 //return 

.section .data

uin:
   .word 24

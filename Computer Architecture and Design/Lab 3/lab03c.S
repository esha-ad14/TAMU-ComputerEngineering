.section .text
.globl lab03c

lab03c:          
ADRP X3, my_array
ADD X3,X3, :lo12:my_array //load my_array address from memory
MOVZ X5, #10 //move constant 10 into register for counter
ADD X6, XZR,XZR
MOVZ X9, #5
loop:
SUBS X7,X6,X5
B.EQ finish //if 10 iterations complete, finish
//SUB X4,X4,#1 //subtract uin by 1
LSL X8,X6,#2 //multiply counter by 4, put in x8
ADD X10, X3,X8 //add offset to address of myarray
STUR W9, [X10,0]//store 'j' in X9 in the ith word (i*4 byte)
ADD X9,X9,#1 //increment initial value j
ADD X6,X6,#1 //increment counter
 B loop //unconditional branch to loop



finish:
ADD X0,XZR,X3 //make x0 what the edited uin is
BR X30 //return x0


.section .data

my_array:

  .space 40,0
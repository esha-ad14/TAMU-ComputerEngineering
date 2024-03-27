.section .text
.globl lab04b

lab04b:
	SUB SP,SP,0x10 //push stack pointer
	STUR LR,[SP,0x8] //store linker address
	STUR X0,[SP,0x0] //store n variable
	SUBS XZR,X0,0x1 
	B.GE L1 //check if x0 > 1, if it is, go to L1
	ORR X0,XZR,0x1 //return 1
	ADD SP,SP,0x10 //delete LR and x0 from last iteration off the stack
	BR LR // go to bk_f
L1: SUB X0,X0,0x1 //subtract 1 from X0
	BL lab04b // recursive call
bk_f:	LDUR X1,[SP,0x0] //load last   
	LDUR LR,[SP,0x8]//load most recent n on the stack
	ADD SP,SP,0x10 //pop most recent LR and n from stack
	SUB SP,SP,0x10 
	STUR LR, [SP,0x8] //push current LR onto the stack
	BL my_mul //call my_mul (makes new LR) 
	LDUR LR, [SP,0x8] //load original LR  back
	ADD SP,SP,0x10 //pop original LR from stack
	BR LR // return to main function

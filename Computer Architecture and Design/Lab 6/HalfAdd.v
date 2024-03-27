module NAND(Y,A,B);
    output wire Y;
    input wire A,B;
    wire Yd;
    and and1(Yd,A,B);
    not not1(Y,Yd);
endmodule
module HalfAdd ( Cout , Sum , A, B ) ;
  input A, B ;
  output Cout , Sum ;
   
    /*declare internal nets */
    wire ABnot;
    wire ABnotB;
    wire ABnotA; 
    /*instantiate gate level modules*/
    NAND nand0(ABnot,A,B); //1st level nand for S and C
    NAND  nand11S(ABnotA,A,ABnot); //2nd level nand for S
    NAND nand12S (ABnotB,B,ABnot); //2nd level nand for S
    NAND nand2S (Sum, ABnotB,ABnotA); //3rd level nand for S
    NAND nand1C(Cout,ABnot,ABnot); // 2nd level nand for C


endmodule //designate end of module

module Mux21 ( out , in , sel ) ;
    input wire [ 1 : 0 ] in ;
    input wire sel ;
    output wire out ;
    //output wire Y; //declare output of type wire
    //input wire A, B, S; //declare inputs of type wire
    
    /*declare internal nets */
    wire notS; //inverse of S
    wire andA; //output of andO gate
    wire andB; //output of and1 gate
    
    /*instantiate gate level modules*/
    not notO(notS, sel);
    and andO(andA, notS, in[0]);
    and and1(andB, sel, in[1]);
    or orO(out, andA, andB);
endmodule //designate end of module 

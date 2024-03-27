module Decode24 ( out , in ) ;
  input wire [ 1 : 0 ] in ;
  output reg [ 3 : 0 ] out ;

    always@ (in)
        begin //good for structure
                case(in) //selection based on in
                    2'b00: out = 4'b0001; //4'b signifies 4 bit binary value
                    2'b01: out = 4'b0010; //light up out[1]
                    2'b10: out = 4'b0100; //light up out[2]
                    2'b11: out = 4'b1000; //light up out[3]
                endcase
        end
    
endmodule

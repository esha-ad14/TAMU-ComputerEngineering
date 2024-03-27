

module SignExtender(out, inst, Ctrl); 
  output reg signed  [63:0] out; 
  input wire [31:0] inst; 
  input wire [2:0] Ctrl; 
  //reg 

  always @* begin
      case ( Ctrl )
        0 : begin
          out = {52'b0,inst[21:10]}; //I
        end
        1 : begin
          out = {{55{inst[20]}},inst[20:12]}; //D
        end
        2 : begin
           out = {{36{inst[25]}},inst[25:0],2'b0}; //B
        end
        3 : begin
          out = {{43{inst[23]}},inst[23:5],2'b0}; //CBZ
        end
        
        4: begin
          case(inst[22:21])
            0: begin
                out = {48'b0,inst[20:5]};
            end
            1:begin
                out = {32'b0,inst[20:5],16'b0};
            end
            
            2: begin
                out = {16'b0,inst[20:5],32'b0};
            end
            
            3: begin
                out = {inst[20:5],48'b0};
            end
            endcase
            end
        
        
          
          //,inst[20:5],{{16*{inst[22:21]}}{1'b0}}};
  endcase
  
  
  end
  
    //assign out = {36{inst[25]},inst[25:0],2'b0};
  
    
        
  
    //assign #1 extBit = (Ctrl ? 1'b0 : Imm16[15]); 
    //assign BusImm = {{16{extBit}}, Imm16}; 
  //initial
    //begin
        //$monitor("out=%b, outd = %d, b = %b",out,out, inst);
   // end

endmodule

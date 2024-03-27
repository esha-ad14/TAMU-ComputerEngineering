
module NextPClogic(NextPC, CurrentPC, SignExtImm64, Branch, ALUZero, Uncondbranch);
       input wire [63:0] CurrentPC, SignExtImm64;
       input wire Branch, ALUZero, Uncondbranch;
       output reg [63:0] NextPC;
       reg [63:0] ALUResult ;
       reg [63:0] AddFour;
       //reg PostMux;
       reg AndBranchZero;
       reg selector;
       always @(*) begin //everthing in the always loop runs when anything changes
        ALUResult <= #2 SignExtImm64 + CurrentPC; //adds offset to PC
        AddFour <= #1 CurrentPC + 4; //increment pc by 4
        
        AndBranchZero <= Branch & ALUZero; //for CBZ
        selector <= AndBranchZero | Uncondbranch; //if B, then add offset to pc no matter what
        if (selector) //mux logic
            NextPC <= #1 ALUResult;
        else
            NextPC <= #1 AddFour;
      end
      
       /*initial
    begin
        $monitor("currentPC=%d, NextPC = %d, AndBranchZero = %d, ALUResult = %d, AddFour = %d, ALUZero = %d",CurrentPC,NextPC,AndBranchZero,ALUResult, AddFour, ALUZero);
    end*/

endmodule

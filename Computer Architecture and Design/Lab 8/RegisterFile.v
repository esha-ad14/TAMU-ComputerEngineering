
module RegisterFile(BusA, BusB, BusW,RA, RB, RW, RegWr, Clk);
    output wire [63:0] BusA;
    output wire  [63:0] BusB;
    input wire [63:0] BusW;
    input wire [4:0] RA;
    input wire [4:0] RB;
    input wire [4:0] RW;
    input wire RegWr;
    input wire Clk;
    reg [63:0] registers [31:0];
    
    //assign
    //X31 always needs to be XZR so it sets itself to zero at Clk (for the
    //beginning) and whenever it is changed. 
    always @ (Clk or registers[31]) begin 
        registers[31] <= 64'd0; 
    end
    //BusA and BusB assigned immediately
       assign  #2 BusA = registers[RA];
       assign  #2 BusB = registers[RB];
    //end
     
    //register write only happens on negedge when RegWr is 1
    always @ (negedge Clk) begin
        if(RegWr)
            registers[RW] <= #3 BusW;
    end
    
    /*initial
        begin
            $monitor("x9=%h, x10 = %h, x11 = %d, x12 = %d, x13 = %d",registers[9],registers[10],registers[11],registers[12], registers[13]);
        end*/
endmodule

`timescale 1ns / 1ps
////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   10:13:28 03/03/2009
// Design Name:   RegisterFile
// Module Name:   E:/350/Lab7/RegisterFile/RegisterFileTest.v
// Project Name:  RegisterFile
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: RegisterFile
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

`define STRLEN 32
module MyRegisterFileTest_v;


	task passTest;
		input [63:0] actualOut, expectedOut;
		input [`STRLEN*8:0] testType;
		inout [7:0] passed;
	
		if(actualOut == expectedOut) begin $display ("%s %d passed", testType, actualOut); passed = passed + 1; end
		else $display ("%s failed: %d should be %d", testType, actualOut, expectedOut);
	endtask
	
	task allPassed;
		input [7:0] passed;
		input [7:0] numTests;
		
		if(passed == numTests) $display ("All tests passed");
		else $display("Some tests failed");
	endtask

	// Inputs
	reg [63:0] BusW;
	reg [4:0] RA;
	reg [4:0] RB;
	reg [4:0] RW;
	reg RegWr;
	reg Clk;
	reg [7:0] passed;
	reg [4:0] i;
	reg [4:0] a;
	reg [63:0] i64;

	// Outputs
	wire [63:0] BusA;
	wire [63:0] BusB;

	// Instantiate the Unit Under Test (UUT)
	RegisterFile uut (
		.BusA(BusA), 
		.BusB(BusB), 
		.BusW(BusW), 
		.RA(RA), 
		.RB(RB), 
		.RW(RW), 
		.RegWr(RegWr), 
		.Clk(Clk)
	);
	
	initial //This initial block used to dump all wire/reg values to dump file
         begin
           $dumpfile("MyRegisterFileTest.vcd");
           $dumpvars(0,MyRegisterFileTest_v);
         end

	initial begin
		// Initialize Inputs
		BusW = 0;
		RA = 0;
		RB = 0;
		RW = 0;
		RegWr = 0;
		Clk = 1;
		passed = 0;
		i = 0;
		a = 5;
		i64 = 0;
		
		
		#10;
		//for loop to change every value in registerfile to its
		//register address/index
		for (i = 0; i < 31; i = i +1) begin
            a <= a + 1; // executes this code 16 times
           
            i64 = {59'b0,i}; //needed to change 5 bit i to 64 bit i so it can be used as BusW
             //$display("%d",i64);
            {RA, RB, RW, BusW, RegWr} = {i, 5'd0, i, i64, 1'b1};
            Clk = 0;
            #10;
            Clk = 1;
            //passTest(BusA, i, "Initial Check", passed);
            
        end
        Clk = 1;
        {RA, RB, RW, RegWr, BusW} = {5'h0, 5'h1, 5'h0, 1'b0,64'h0};
		#4;
		passTest(BusA, 64'h0, "0 Initial Value Check A, Currently", passed);
		passTest(BusB, 64'h1, "Initial Value Check B, Currently", passed);
		#6; Clk = 0; #10; Clk = 1; //negedge happens when Clk goes from 1 to 0
		passTest(BusA, 64'h0, "After Write A, Currently", passed);
		passTest(BusB, 64'h1, "After Write B, Currently", passed);
		
		{RA, RB, RW, RegWr, BusW} = {5'h2, 5'h3, 5'h1, 1'b0,64'h1000};
		#4;
		passTest(BusA, 64'h2, " 1 Initial Value Check A, Currently", passed);
		passTest(BusB, 64'h3, "Initial Value Check B, Currently", passed);
		#6; Clk = 0; #10; Clk = 1;
		passTest(BusA, 64'h2, "After Write A, Currently", passed);
		passTest(BusB, 64'h3, "After Write B, Currently", passed);
		
		{RA, RB, RW, RegWr, BusW} = {5'h4, 5'h5, 5'h0, 1'b1,64'h1000};
		#4;
		passTest(BusA, 64'h4, "2 Initial Value Check A, Currently", passed);
		passTest(BusB, 64'h5, "Initial Value Check B, Currently", passed);
		#6; Clk = 0; #10; Clk = 1;
		passTest(BusA, 64'h4, "After Write A, Currently", passed);
		passTest(BusB, 64'h5, "After Write B, Currently", passed);
		
		
		{RA, RB, RW, RegWr, BusW} = {5'h6, 5'h7, 5'hA, 1'b1,64'h1010};
		#4;
		passTest(BusA, 64'h6, "3 Initial Value Check A, Currently", passed);
		passTest(BusB, 64'h7, "Initial Value Check B, Currently", passed);
		#6; Clk = 0; #10; Clk = 1;
		passTest(BusA, 64'h6, "After Write A, Currently", passed);
		passTest(BusB, 64'h7, "After Write B, Currently", passed);
		
		{RA, RB, RW, RegWr, BusW} = {5'h8, 5'h9, 5'hB, 1'b1,64'h103000};
		#4;
		passTest(BusA, 64'h8, "4 Initial Value Check A, Currently", passed);
		passTest(BusB, 64'h9, "Initial Value Check B, Currently", passed);
		#6; Clk = 0; #10; Clk = 1;
		passTest(BusA, 64'h8, "After Write A, Currently", passed);
		passTest(BusB, 64'h9, "After Write B, Currently", passed);
		
		{RA, RB, RW, RegWr, BusW} = {5'hA, 5'hB, 5'hC, 1'b0,64'h0};
		#4;
		passTest(BusA, 64'h1010, "5 Initial Value Check A, Currently", passed);
		passTest(BusB, 64'h103000, "Initial Value Check B, Currently", passed);
		#6; Clk = 0; #10; Clk = 1;
		passTest(BusA, 64'h1010, "After Write A, Currently", passed);
		passTest(BusB, 64'h103000, "After Write B, Currently", passed);
		
		{RA, RB, RW, RegWr, BusW} = {5'hC, 5'hD, 5'hD, 1'b1,64'hABCD};
		#4;
		passTest(BusA, 64'hC, "6 Initial Value Check A, Currently", passed);
		passTest(BusB, 64'hD, "Initial Value Check B, Currently", passed);
		#6; Clk = 0; #10; Clk = 1;
		passTest(BusA, 64'hC, "After Write A, Currently", passed);
		passTest(BusB, 64'hABCD, "After Write B, Currently", passed);
		
		{RA, RB, RW, RegWr, BusW} = {5'hE, 5'hF, 5'hE, 1'b0,64'h9080009};
		#4;
		passTest(BusA, 64'hE, "7 Initial Value Check A, Currently", passed);
		passTest(BusB, 64'hF, "Initial Value Check B, Currently", passed);
		#6; Clk = 0; #10; Clk = 1;
		passTest(BusA, 64'hE, "After Write A, Currently", passed);
		passTest(BusB, 64'hF, "After Write B, Currently", passed);
        
        
		end
endmodule

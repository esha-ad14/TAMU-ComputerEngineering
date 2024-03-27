

`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   10:02:47 03/05/2009
// Design Name:   ALU
// Module Name:   E:/350/Lab8/ALU/ALUTest.v
// Project Name:  ALU
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: ALU
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

`define STRLEN 32
module ALUTest_v;

	task passTest;
		input [64:0] actualOut, expectedOut;
		input [`STRLEN*8:0] testType;
		inout [7:0] passed;
	
		if(actualOut == expectedOut) begin $display ("%s passed", testType); passed = passed + 1; end
		else $display ("%s failed: %x should be %x", testType, actualOut, expectedOut);
	endtask
	
	task allPassed;
		input [7:0] passed;
		input [7:0] numTests;
		
		if(passed == numTests) $display ("All tests passed");
		else $display("Some tests failed");
	endtask

	// Inputs
	reg [63:0] BusA;
	reg [63:0] BusB;
	reg [3:0] ALUCtrl;
	reg [7:0] passed;

	// Outputs
	wire [63:0] BusW;
	wire Zero;
   initial //This initial block used to dump all wire/reg values to dump file
     begin
       $dumpfile("ALUTest.vcd");
       $dumpvars(0,ALUTest_v);
     end

	// Instantiate the Unit Under Test (UUT)
	ALU uut (
		.BusW(BusW), 
		.Zero(Zero), 
		.BusA(BusA), 
		.BusB(BusB), 
		.ALUCtrl(ALUCtrl)
	);

	initial begin
		// Initialize Inputs
		BusA = 0;
		BusB = 0;
		ALUCtrl = 0;
		passed = 0;

	      // Here is one example test vector, testing the ADD instruction:
		{BusA, BusB, ALUCtrl} = {64'h1234, 64'hABCD0000, 4'h2}; #40; passTest({Zero, BusW}, 65'h0ABCD1234, "ADD 0x1234,0xABCD0000", passed);
		//Reformate and add your test vectors from the prelab here following the example of the testvector above.	
	   {BusA, BusB, ALUCtrl} = {64'h100, 64'h200, 4'h2}; #40; passTest({Zero, BusW}, {1'b0, 64'h300}, "ADD 0x100, 0x200 = 0x300", passed); //ADD1,2, 100, 200, 0, 300

{BusA, BusB, ALUCtrl} = {64'h20, 64'h4600, 4'h2}; #40; passTest({Zero, BusW}, {1'b0, 64'h4620}, "ADD 0x20, 0x4600 = 0x4620", passed);//ADD2, 2, 20, 4600, 0, 4620  
{BusA, BusB, ALUCtrl} = {64'h0, 64'h0, 4'h2}; #40; passTest({Zero, BusW}, {1'b1, 64'h0}, "ADD 0x0, 0x0 = 0x0", passed);//ADD3, 2, 0, 0, 1, 0

{BusA, BusB, ALUCtrl} = {64'h0, 64'h0, 4'h0}; #40; passTest({Zero, BusW}, {1'b1, 64'h0}, "AND 0x0, 0x0 = 0x0", passed);//AND1, 0,0,0,1,0
{BusA, BusB, ALUCtrl} = {64'h6, 64'h7, 4'h0}; #40; passTest({Zero, BusW}, {1'b0, 64'h6}, "AND 0x6, 0x7 = 0x6", passed);//AND2, 0, 6,7,0,6
{BusA, BusB, ALUCtrl} = {64'h1011, 64'h2345, 4'h0}; #40; passTest({Zero, BusW}, {1'b0, 64'h1}, "AND 0x1011, 0x2345 = 0x1", passed);//AND3, 0, 1011,2345,0,1

{BusA, BusB, ALUCtrl} = {64'h0, 64'h0, 4'h1}; #40; passTest({Zero, BusW}, {1'b1, 64'h0}, "OR 0x0, 0x0 = 0x0", passed); //OR1, 1,0,0,1,0
{BusA, BusB, ALUCtrl} = {64'h8, 64'h9, 4'h1}; #40; passTest({Zero, BusW}, {1'b0, 64'h9}, "OR 0x8, 0x9 = 0x9", passed); //R2, 1,8,9,0,9
{BusA, BusB, ALUCtrl} = {64'h1021, 64'h3254, 4'h1}; #40; passTest({Zero, BusW}, {1'b0, 64'h3275}, "OR 0x1021, 0x3254 = 0x3275", passed); //OR2, 1,1021, 3254,0, 4095

{BusA, BusB, ALUCtrl} = {64'h0, 64'h0, 4'h6}; #40; passTest({Zero, BusW}, {1'b1, 64'h0}, "SUB 0x0, 0x0 = 0x0", passed); //SUB1, 6, 0, 0, 1, 0
{BusA, BusB, ALUCtrl} = {64'h11, 64'h10, 4'h6}; #40; passTest({Zero, BusW}, {1'b0, 64'h1}, "SUB 0x11, 0x10 = 0x1", passed); //SUB2, 6, 11, 10, 0, 1
{BusA, BusB, ALUCtrl} = {64'h6784, 64'h6754, 4'h6}; #40; passTest({Zero, BusW}, {1'b0, 64'h30}, "SUB 0x6784, 0x6754 = 0x30", passed); //SUB3, 6, 6784, 6754, 0, 48

{BusA, BusB, ALUCtrl} = {64'h0, 64'h0, 4'h7}; #40; passTest({Zero, BusW}, {1'b1, 64'h0}, "PASSB 0x0, 0x0 = 0x0", passed); //PassB1, 7,0,0,1,0
{BusA, BusB, ALUCtrl} = {64'h13, 64'h66, 4'h7}; #40; passTest({Zero, BusW}, {1'b0, 64'h66}, "PASSB 0x13, 0x66 = 0x66", passed); //PassB2, 7, 13, 66, 0, 66
{BusA, BusB, ALUCtrl} = {64'h1544, 64'h7654, 4'h7}; #40; passTest({Zero, BusW}, {1'b0, 64'h7654}, "PASSB 0x1544, 0x7654 = 0x7654", passed); //PassB3, 7, 1544, 7654, 0, 7654
		allPassed(passed, 16);
	end
      
endmodule


`define STRLEN 32
module NextPClogic_v;
    task passTest;
		input [64:0] actualOut, expectedOut;
		input [`STRLEN*16:0] testType;
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
	
	reg [63:0]  CurrentPC;
        reg [63:0] SignExtImm64;
        reg Branch;
        reg ALUZero;
        reg Uncondbranch;
        wire [63:0] NextPC;
        reg [7:0] passed;
        
    initial //This initial block used to dump all wire/reg values to dump file
         begin
           $dumpfile("NextPClogic.vcd");
           $dumpvars(0,NextPClogic_v);
         end


     NextPClogic p(NextPC, CurrentPC, SignExtImm64, Branch, ALUZero, Uncondbranch);


    initial begin
        /*a = 1;
        b = 10;
        c = 1;
        d = 1;
        e = 1;
        //f = 1;*/
    
    
    
   
    
    {CurrentPC, SignExtImm64, Branch, ALUZero, Uncondbranch} = {64'd1,64'd10,1'd1,1'd1,1'd1};     #40;     passTest(NextPC, 64'd11, "Test 1 (PC = 1, SE = 10, B = 1, ALUzero = 1, Uncondbranch = 1)", passed);
    {CurrentPC, SignExtImm64, Branch, ALUZero, Uncondbranch} = {64'd1,64'd10,1'd0,1'd1,1'd1};     #40;     passTest(NextPC, 64'd11, " Test 2 (PC = 1, SE = 10, B = 0, ALUzero = 1, Uncondbranch = 1)", passed);
    {CurrentPC, SignExtImm64, Branch, ALUZero, Uncondbranch} = {64'd1,64'd10,1'd0,1'd1,1'd0};     #40;     passTest(NextPC, 64'd5, " Test 3 (PC = 1, SE = 10, B = 0, ALUzero = 1, Uncondbranch = 0)", passed);
    {CurrentPC, SignExtImm64, Branch, ALUZero, Uncondbranch} = {64'd1,64'd10,1'd1,1'd0,1'd0};     #40;     passTest(NextPC, 64'd5, "Test 4 (PC = 1, SE = 10, B = 1, ALUzero = 0, Uncondbranch = 0)", passed);
    {CurrentPC, SignExtImm64, Branch, ALUZero, Uncondbranch} = {64'd1,64'd10,1'd1,1'd0,1'd1};     #40;     passTest(NextPC, 64'd11, "Test 5 (PC = 1, SE = 10, B = 1, ALUzero = 0, Uncondbranch = 1)", passed);
    {CurrentPC, SignExtImm64, Branch, ALUZero, Uncondbranch} = {64'd1,64'd10,1'd0,1'd0,1'd0};     #40;     passTest(NextPC, 64'd5, "Test 6 (PC = 1, SE = 10, B = 0, ALUzero = 0, Uncondbranch = 0)", passed);
    {CurrentPC, SignExtImm64, Branch, ALUZero, Uncondbranch} = {64'd1,64'd10,1'd0,1'd0,1'd1};     #40;     passTest(NextPC, 64'd11, "Test 7 (PC = 1, SE = 10, B = 0, ALUzero = 0, Uncondbranch = 1)", passed);
    {CurrentPC, SignExtImm64, Branch, ALUZero, Uncondbranch} = {64'd1,64'd10,1'd1,1'd1,1'd0};     #40;     passTest(NextPC, 64'd11, "Test 8 (PC = 1, SE = 10, B = 1, ALUzero = 1, Uncondbranch = 0)", passed);
    
    end

     
    
endmodule




module InstructionMemory(Data, Address);
   parameter T_rd = 20;
   parameter MemSize = 40;
   
   output [31:0] Data;
   input [63:0]  Address;
   reg [31:0] 	 Data;
   
   /*
    * ECEN 350 Processor Test Functions
    * Texas A&M University
    */
   
   always @ (Address) begin
      #4;
      case(Address)

	/* Test Program 1:
	 * Program loads constants from the data memory. Uses these constants to test
	 * the following instructions: LDUR, ORR, AND, CBZ, ADD, SUB, STUR and B.
	 * 
	 * Assembly code for test:
	 * 
	 * 0: LDUR X9, [XZR, 0x0]    //Load 1 into x9
	 * 4: LDUR X10, [XZR, 0x8]   //Load a into x10
	 * 8: LDUR X11, [XZR, 0x10]  //Load 5 into x11
	 * C: LDUR X12, [XZR, 0x18]  //Load big constant into x12
	 * 10: LDUR X13, [XZR, 0x20]  //load a 0 into X13
	 * 
	 * 14: ORR X10, X10, X11  //Create mask of 0xf
	 * 18: AND X12, X12, X10  //Mask off low order bits of big constant
	 * 
	 * loop:
	 * 1C: CBZ X12, end  //while X12 is not 0
	 * 20: ADD X13, X13, X9  //Increment counter in X13
	 * 24: SUB X12, X12, X9  //Decrement remainder of big constant in X12
	 * 28: B loop  //Repeat till X12 is 0
	 * 2C: STUR X13, [XZR, 0x20]  //store back the counter value into the memory location 0x20
	 */
	

	63'h000: Data = 32'hF84003E9;
	63'h004: Data = 32'hF84083EA;
	63'h008: Data = 32'hF84103EB;
	63'h00c: Data = 32'hF84183EC;
	63'h010: Data = 32'hF84203ED;
	63'h014: Data = 32'hAA0B014A;
	63'h018: Data = 32'h8A0A018C;
	63'h01c: Data = 32'hB400008C;
	63'h020: Data = 32'h8B0901AD;
	63'h024: Data = 32'hCB09018C;
	63'h028: Data = 32'h17FFFFFD;
	63'h02c: Data = 32'hF80203ED;
	63'h030: Data = 32'hF84203ED;  //One last load to place stored value on memdbus for test checking.

	/* Add code for your tests here */
	
	//movz first quadrant to x10, add that with xzr to x9
	//movz second quadrant to x10, add that with x9 to x9
	// do same as previous step for next two quadrants
	
	63'h034: Data = {9'b110100101,2'd0,16'hdef0,5'd10};
	63'h038: Data = {11'b10001011000,5'd31,6'd0,5'd10,5'd9};
	63'h03c: Data = {9'b110100101,2'd1,16'h9abc,5'd10};
	63'h040: Data = {11'b10001011000,5'd9,6'd0,5'd10,5'd9};
	63'h044: Data = {9'b110100101,2'd2,16'h5678,5'd10};
	63'h048: Data = {11'b10001011000,5'd9,6'd0,5'd10,5'd9};
	63'h04c: Data = {9'b110100101,2'd3,16'h1234,5'd10};
	63'h050: Data = {11'b10001011000,5'd9,6'd0,5'd10,5'd9};
	
	//store
	63'h054: Data = {11'b11111000000,9'h28,2'd0,5'd31,5'd9};
	
	//load
	63'h058: Data = {11'b11111000010,9'h28,2'd0,5'd31,5'd10};
	


			
	default: Data = 32'hXXXXXXXX;
      endcase
   end
endmodule

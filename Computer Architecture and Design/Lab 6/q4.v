module gates(input      [3:0] a, b,
  output reg [3:0] y1, y2, y3, y4, y5);
  always @(b)
    begin
    y1 = a & b;
    y2 = a | b;
    y3 = a ^ b;
    y4 = ~(a & b);
    y5 = ~(a | b);
  end
endmodule

module main;
  initial 
    begin
        reg [3:0] a, b;
	    reg [3:0]  y1, y2, y3, y4, y5;
	    {a,b} = 8'b0;
	    gates(a,b,y1,y2,y3,y4,y5);
    
      $display("Hello, World");
      $finish ;
    end
endmodule

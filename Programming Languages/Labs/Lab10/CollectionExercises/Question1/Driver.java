package last_lab;

class Driver{
	  public static void main(String[] args) {
	   //Q1: Create/Instance 1 each of Animal & Vehicle Objects
	   Address Addr1 = new Address("CA", "Blanket St.", 79340, "Cupertino");
	   Address Addr2 = new Address("TX", "Osage St.", 78877, "Austin");
	  
	  
	   Animal testAni = new Animal(0, 4, 15, Addr1, "chicken");
	   
	   System.out.println(testAni);
	  
	 
	   testAni.setType(2);
	   testAni.setAge(3);
	   testAni.setWeight(2);
	   testAni.setAddress(Addr2);
	  
	   Vehicle testVe = new Vehicle(0, 17, 600, Addr1, "5455KJFV");
	 
	   testVe.setType(2);
	   testVe.setlicensePlate("HHY284J");
	   testVe.setAge(7);
	   testVe.setWeight(450);
	   testVe.setAddress(Addr2);
	   
	   System.out.println(testVe);
}
}

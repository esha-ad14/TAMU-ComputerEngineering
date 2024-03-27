
public class Driver {
    public static void main(String[] args){
        //Question 1
        System.out.println("Question 1");
        //Vehicle mycar = new Vehicle();
		//mycar.setSpeed(30);
        //System.out.println(" The speed is set to: " + mycar.getSpeed());
        System.out.println();

        //Question 2
        System.out.println("Question 2");
        Car honda = new Car();
        honda.setLicense("123422");
        System.out.println("The honda liscence plate is: " + honda.getLicense());
        honda.left();
        honda.right();
        honda.forward();
        honda.reverse();
        System.out.println("Question 4");
        honda.setMotor();
        System.out.println(honda.getMotor());

        System.out.println();
        Airplane bat = new Airplane();
        bat.setFlightNumber("2342432");
        bat.setCompany("United");
        System.out.println("The bat is from " + bat.getCompany() + " and the flight number is " + bat.getCompany());
        bat.setCompany("United");
        bat.left();
        bat.right();
        bat.forward();
        bat.reverse();
        System.out.println("Question 4");
        bat.setMotor();
        System.out.println(bat.getMotor());
        System.out.println("Question 5");
        bat.setCountry("USA");
        System.out.println(bat.getCountry());
        bat.fireWeapon();
        System.out.println();
        System.out.println();

        //Question 3
        System.out.println("Question 3");

        Vehicle [] vehicles;
	       Boolean flag = true; 
	       
	       if(flag) {
               vehicles = new Car[3];
               vehicles[0] = new Car("1");
               vehicles[0].setSpeed(0);

               vehicles[1] = new Car("2");
               vehicles[1].setSpeed(1);

               vehicles[2] = new Car("2");
               vehicles[2].setSpeed(4);
           }
           else{
            vehicles = new Airplane[2];
            vehicles[0] = new Airplane();
            vehicles[0].setSpeed(6);

            vehicles[1] = new Airplane();
            vehicles[1].setSpeed(2);
           }
        for(int i=0; i<vehicles.length; i++) {
            System.out.println("The vehicle at index " + i + " has speed: " + vehicles[i].getSpeed());
	    }

    }
}

import java.util.*;
public class Car extends Vehicle{
    private String licensePlate;

    public Car(){
        super();
    }
    public Car(String licensePlate){
        super();
        this.licensePlate = licensePlate;
    }
    public String getLicense(){
        return this.licensePlate;
   }
	public void setLicense(String lPlate){ 
        this.licensePlate = lPlate;
    }

    public String getMotor(){
        return motor;
    }
    public void setMotor(){
        motor = "combustion";
    }

    public void left(){
        super.left();
    }
    public void right(){
        super.right();
    }
    public void forward(){
        super.forward();
    }
    public void reverse(){
        super.reverse();
    }

}


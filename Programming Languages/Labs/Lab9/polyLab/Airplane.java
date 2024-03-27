
public class Airplane extends Vehicle implements Warplane{    
    private String flightNumber;
    private String company; 
    private String country; 

    public void setCountry(String con){
         country = con;
    }
    public String getCountry(){
        return country;
    }
    public void fireWeapon(){
        System.out.print("shoots");
    }

    public Airplane(){
        super();
    }
    public Airplane(String flightNumber, String company){
        super();
        this.flightNumber = flightNumber;
        this.company = company;
    }
    public String getFlightNumber(){
        return flightNumber;
    }
    public void setFlightNumber(String fNum){
        this.flightNumber = fNum;
    }
    public String getCompany(){
        return company;
    }
    public void setCompany(String comp){
        this.company = comp;
    } 
    public String getMotor(){
        return motor;
    }
    public void setMotor(){
        motor = "jet";
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

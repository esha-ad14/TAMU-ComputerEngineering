package collectionExercises;
import java.util.Collections;

public class Vehicle{
    private int type;
    private int age;
    private float weight;
    private Address address;
    private String licensePlate;
    
   Vehicle()
    {
        type = -1;
        age = -1;
        weight = -1;
        address = null;
        licensePlate = "000000";
    }
    
    Vehicle(int tp, int age, float wgt, Address addr, String license)
    {
        this.type = tp;
        this.age = age;
        this.weight = wgt;
        this.address = addr;
        this.licensePlate = license;
    }
    
    public String toString()
    {
        return "Type: " + type + "\n Age: " + age + "\n Weight: " + weight + "\n License plate: " + licensePlate + "\n" +  address.toString();
    }
    
    public int getType() { return type; }
    public int getAge() { return age; }
    public float getWeight() { return weight; }
    public Address getAddress() { return address; }
    public String licensePlate() { return licensePlate; }
    
    public void setType(int type) { this.type = type; }
    public void setAge(int age) { this.age = age; }
    public void setWeight(float weight) { this.weight = weight; }
    public void setAddress(Address addr) { this.address = addr; }
    public void setlicensePlate(String license) { this.licensePlate = license; }

    public int compareTo(Comp comps)
    {   
        return (int) (this.weight.getWeight().compareTo(comps.getWeight()));
    }
}
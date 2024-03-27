package last_lab;

public class Vehicle{
	
	private Integer type;
	
	public String licensePlate;
	public Integer age;
	public float weight;
	public Address address; 
	
	   Vehicle(int tp, int age, float wgt, Address addr, String license)
	   {
	       this.type = tp;
	       this.age = age;
	       this.weight = wgt;
	       this.address = addr;
	       this.licensePlate = license;
	   }

	
	 public void setlicensePlate(String lP) {
		this.licensePlate = lP;
	 }
	 public void setAge(int age)
	   {
	        this.age = age;
	   }
	   public void setWeight(float weight)
	   {
	        this.weight = weight;
	   }
	   public void setAddress(Address address)
	   {
	        this.address = address;
	   }
	   
	   public void setType(Integer t)
	   {
	        this.type = t;
	   }
	   
	   public int getAge()
	   {
	        return age;
	   }
	   public float getWeight()
	   {
	        return weight;
	   }
	   public Address getAddress()
	   {
	        return address;
	   }
	   
	   public String getLicensePlate() {
				return this.licensePlate;
		}
	   public int getType()
	   {
	        return type;
	   }
	   public String toString() {
		   String carType = "";
		   
		   switch(this.type) {
		   case 0:
			   carType = "car";
			   break;
		   case 1:
			   carType = "truck";
			   break;
		   case 2:
			   carType = "motocycle";
		   case 3:
			   carType = "boat";
			   
		   }
			   
			return "Vehicle [type=" + carType + ", licensePlate=" + this.licensePlate + ", age=" + this.age + ", weight=" + this.weight + ", Address= "+ this.address + "]";
		}

	
	
	

}

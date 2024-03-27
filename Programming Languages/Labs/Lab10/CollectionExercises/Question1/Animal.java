package last_lab;

public class Animal {
	public int type;
	   public int age;
	   public float weight;
	   public Address address;   
	   public String foodRequired;
	  
	   Animal(int tp, int age, float wgt, Address addr, String food)
	   {
	       this.type = tp;
	       this.age = age;
	       this.weight = wgt;
	       this.address = addr;
	       this.foodRequired = food;
	   }
	 
	   public String toString()
	   {
	       return "Type: " + type + "\n Age: " + age + "\n Weight: " + weight + "\n Food required: " + foodRequired + "\n" + address.toString();
	   }
	  
	   public int getType() { return type; }
	   public int getAge() { return age; }
	   public float getWeight() { return weight; }
	   public Address getAddress() { return address; }
	   public String getFoodRequired() { return foodRequired; }
	 
	  
	   public void setType(int type) { this.type = type; }
	   public void setAge(int age) { this.age = age; }
	   public void setWeight(float weight) { this.weight = weight; }
	   public void setAddress(Address addr) { this.address = addr; }
	   public void setFoodRequired(String food) { this.foodRequired = food; }


}

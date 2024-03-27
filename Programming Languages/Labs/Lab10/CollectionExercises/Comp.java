public abstract class Comp implements Comparable<Comp> {
    private int type;
    private int age;
    private float weight;
    private Address address;
    

    public int getType() { return type; }
    public int getAge() { return age; }
    public float getWeight() { return weight; }
    public Address getAddress() { return address; }

    
    public void setType(int type) { this.type = type; }
    public void setAge(int age) { this.age = age; }
    public void setWeight(float weight) { this.weight = weight; }
    public void setAddress(Address addr) { this.address = addr; }
}
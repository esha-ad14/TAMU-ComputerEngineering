package collectionExercises;
import java.util.Collections;
import java.util.ArrayList;
class Driver{
  
  public static void main(String[] args) {
    //Question 1
    System.out.println("Question 1");
    Address Addr1 = new Address("CA", "Blanket St.", 79340, "Cupertino");
    Address Addr2 = new Address("TX", "Osage St.", 78877, "Austin");
    
    Animal testAnimal = new Animal(0, 4, 15, Addr1, "chicken");

    testAnimal.setType(2); 
    testAnimal.setAge(3);
    testAnimal.setWeight(2); 
    testAnimal.setAddress(Addr2); 
    
    Vehicle testVehicle = new Vehicle(0, 17, 600, Addr1, "5455KJFV");

    testVehicle.setType(2);
    testVehicle.setlicensePlate("HHY284J");
    testVehicle.setAge(7);
    testVehicle.setWeight(450); 
    testVehicle.setAddress(Addr2); 



       //Question 2
       System.out.println("Question 2");
       ArrayList<Animal> animals = new ArrayList<Animal>();
       ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
       
       
       Animal dog = new Animal(0, 3, 15, Addr1, "bones");
       Animal cat = new Animal(1, 5, 7, Addr1, "chicken");
       Animal fish = new Animal(2, 2, 3, Addr1, "fish");
       Animal squirrel = new Animal(3, 7, 6, Addr1, "accorns");
       
       animals.add(dog);
       animals.add(cat);
       animals.add(fish);
       animals.add(squirrel);
            
        System.out.println("Presorted animals:");
        for (Animal ani: animals){System.out.println(ani.toString());} 
        System.out.println();
        Collections.sort(animals);
        System.out.println("Sorted animals:");
        for (Animal ani: animals){System.out.println(ani.toString());}
       
       
       
       Vehicle car = new Vehicle(0, 2, 150, Addr2, "AWEFF11");
       Vehicle truck = new Vehicle(1, 7, 130, Addr2, "BERI22");
       Vehicle motorcycle = new Vehicle(2, 1, 90, Addr2, "ERFEN33");
       Vehicle boat = new Vehicle(3, 2, 230, Addr2, "DFNJDK4");
       
       vehicles.add(car);
       vehicles.add(truck);
       vehicles.add(motorcycle);
       vehicles.add(boat);
       
   System.out.println("Berfore sort vehicles:");
   for (Vehicle ve: vehicles){
       System.out.println(ve.toString());
    } 
   System.out.println();
   Collections.sort(vehicles);
   System.out.println("Sorted vehicles:");
   for (Vehicle ve: vehicles){
       System.out.println(ve.toString());
    } 


    // Question 3
    System.out.println("Question 3");
    Address testAddr3 = new Address("AK", "Pink St.", 23168, "Newstate");
    Address testAddr4 = new Address("AL", "New St.", 23073, "Plan");
    Address testAddr5 = new Address("VT", "Some St.", 23843, "SomeArea");
    Address testAddr6 = new Address("FL", "Barely St.", 23022, "Metro");
    Address testAddr7 = new Address("WV", "Rainbow St.", 23740, "VillPl");
    Address testAddr8 = new Address("RI", "Chart St.", 82323, "Field");
    
    dog.setAddress(Addr1);
    cat.setAddress(Addr2);
    fish.setAddress(testAddr3);
    squirrel.setAddress(testAddr4);
    car.setAddress(testAddr5);
    truck.setAddress(testAddr6);
    motorcycle.setAddress(testAddr7);
    boat.setAddress(testAddr8);

    
    
    ArrayList<Comp> stuff = new ArrayList <Comp>();
    stuff.add(dog);
    stuff.add(cat);
    stuff.add(fish);
    stuff.add(squirrel);
    stuff.add(car);
    stuff.add(truck);
    stuff.add(motorcycle);
    stuff.add(boat);
    
    System.out.println("list of objects:");
    for (Object obj: stuff)
    {
      System.out.println(obj.toString());
    }

    //Question 4
    Collections.sort(stuff);
    System.out.println();
     System.out.println("Sorted alphabetically by state:");
     for (Object obj: stuff)
     {
       System.out.println(obj.toString());
     }
 
  }
}
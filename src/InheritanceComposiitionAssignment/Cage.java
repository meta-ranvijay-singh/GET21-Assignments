package InheritanceComposiitionAssignment;

import java.util.*;

public class Cage {
	private String type;
	private final int limit;
	private List<Animal> animal;
	public Cage(String t, int n){
		type=t;
		limit=n;
		animal=new ArrayList<Animal>();
	}
	public String getType(){
		return type;
	}
	public int getCapacity(){
		return limit;
	}
	
	public int addAnimalToCage(Animal a){
		if(animal.size() < limit){
			animal.add(a);
			return 1;
		}
		else{
			return 0;
		}
	}
	public void display(){
		System.out.println();
		System.out.println("Type : "+type);
		System.out.println("Cage limit : "+limit);
		for(Animal a:animal){
			a.display();
		}
	}
	public int searchAnimal(int id){
		
		for(Animal a:animal){
			if(a.getID() == id){
				return animal.indexOf(a);
			}
		}
		return -1;
	}
	public void removeAnimal(int id){
		 animal.remove(id);
	}
	
}

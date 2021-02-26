package InheritanceComposiitionAssignment;

import java.util.*;

public class Zone {
	private String category;
	private List<Cage> cage;
	private final int limit;
	
	boolean hasPark, hasCanteen;
	
	public Zone(String c, int n){
		category=c;
		limit=n;
		cage=new ArrayList<Cage>();
	}
	
	public String getCategory(){
		return category;
	}
	
	public int addCage(Cage c){
		if(cage.size() < limit){
			cage.add(c);
			return 1;
		}
		else{
			return 0;
		}

	}
	
	public int addAnimalToZone(Animal animal, String type){
		int res;
		for(Cage c:cage){
			if(c.getType() == type){
				res= c.addAnimalToCage(animal);
				if(res == 1){
					return res;
				}
			}
		}
		if(cage.size() < limit){
			Cage tempCage = new Cage(type, 5);
			tempCage.addAnimalToCage(animal);
			cage.add(tempCage);
			return 1;
		}
		return 0;
		
	}
	public int removeAnimalToZone(int id, String type){
		
		for(Cage c:cage){
			if(c.getType() == type){
				int index= c.searchAnimal(id);
				if(index >= 0){
					c.removeAnimal(index);
					return 1;
				}
			}
		}
		
		return 0;
		
	}
	public void display(){
		System.out.println("Category : "+category);
		System.out.println("Limit : "+limit);
		System.out.println("No. of Cage : "+cage.size());
		for(Cage c:cage){
			c.display();
		}
	}
}

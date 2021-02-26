package InheritanceComposiitionAssignment;

public class Mammal extends Animal{
	int no_of_legs;
	public Mammal(int id,String name, int age, int weight,String voice, int n){
		super(id,name,age,weight,voice);
		no_of_legs=n;
	}

}

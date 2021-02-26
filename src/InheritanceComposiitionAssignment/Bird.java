package InheritanceComposiitionAssignment;

public class Bird extends Animal{
	int height_of_fly;
	public Bird(int id,String name, int age, int weight, String voice, int h){
		super(id,name,age,weight,voice);
		height_of_fly=h;
	}
}

package InheritanceComposiitionAssignment;

public class Reptile extends Animal{
	int temp;
	public Reptile(int id,String name, int age, int weight, String voice, int n){
		super(id,name,age,weight,voice);
		temp=n;
	}
}

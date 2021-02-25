package InheritanceComposiitionAssignment;

public class Animal {
	int ID;
	String name,voice;
	int age,weight;
	Animal(int id,String n, int a, int w,String v){
		ID=id;
		name=n;
		age=a;
		weight=w;
		voice=v;
	}
	public String getSound(){
		return voice;
	}
	
	public String getName(){
		return name;
	}
	public int getID(){
		return ID;
	}
	public void display(){
		System.out.println();
		System.out.println("ID : "+ID);
		System.out.println("Name : "+name);
		System.out.println("Voice : "+voice);
		System.out.println("Age : "+age);
	}

}

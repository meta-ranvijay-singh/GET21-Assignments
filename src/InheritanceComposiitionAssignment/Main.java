package InheritanceComposiitionAssignment;

import java.util.Scanner;

public class Main {
	static Scanner in=new Scanner(System.in);
	static int ID;
	static enum category{
		Mammal, Reptile, Bird;
	}
	static enum mammalType{
		Lion;
	}
	public static void mainMenu(){
		System.out.println();
		System.out.println("---------MENU------------");
		System.out.println("1. Add animal.");
		System.out.println("2. Remove animal.");
		System.out.println("3. Add cage.");
		System.out.println("0. Exit.");
		System.out.print("Enter Choice :");
	}
	public static void categoryMenu(){
		System.out.println();
		System.out.println("---------CATEGORY MENU------------");
		System.out.println("1. Mammal");
		System.out.println("2. Reptile");
		System.out.println("3. Bird");
		System.out.print("Choose category of animal :");
	}
	public static void main(String[] args) {
		int ch,choiceCat,choiceType,limit;
		
		Zone mammalZone=new Zone("Mammal",10);
		Zone reptileZone=new Zone("Reptile",10);
		Zone birdZone=new Zone("Bird",10);
		Animal animal;
		Cage cage;
		
		String name,voice;
		int age,weight,num;
		
		do{
			mainMenu();
			ch=in.nextInt();
			
			switch(ch){
			case 1:
				categoryMenu();
				choiceCat=in.nextInt();
				switch(choiceCat){
				case 1:
					System.out.println("1. Lion");
					System.out.print("Choose the type of mammal :");
					choiceType=in.nextInt();
					switch(choiceType){
					case 1:
						System.out.print("Enter Name :");
						name=in.next();
						System.out.print("Enter Age :");
						age=in.nextInt();
						System.out.print("Enter Weight :");
						weight=in.nextInt();
						System.out.print("Enter Voice :");
						voice=in.next();
						System.out.print("Enter No. of legs :");
						num=in.nextInt();
						
						animal=new Lion(++ID,name,age,weight,voice,num);
						System.out.println(mammalZone.addAnimalToZone(animal, "Lion"));
						//mammalZone.display();
						break;
					default:
						System.out.println("INVALID choice.");
						break;
					}
					
					break;
				case 2:
					System.out.println("1. Crocodile");
					System.out.print("Choose the type of reptile :");
					choiceType=in.nextInt();
					switch(choiceType){
					case 1:
						System.out.print("Enter Name :");
						name=in.next();
						System.out.print("Enter Age :");
						age=in.nextInt();
						System.out.print("Enter Weight :");
						weight=in.nextInt();
						System.out.print("Enter Voice :");
						voice=in.next();
						System.out.print("Enter body temp. :");
						num=in.nextInt();
						
						animal=new Crocodile(++ID,name,age,weight,voice,num);
						System.out.println(reptileZone.addAnimalToZone(animal, "Crocodile"));
						//reptileZone.display();
						break;
					default:
						System.out.println("INVALID choice.");
						break;
					}
					break;
				case 3:
					System.out.println("1. Peacock");
					System.out.print("Choose the type of bird :");
					choiceType=in.nextInt();
					switch(choiceType){
					case 1:
						System.out.print("Enter Name :");
						name=in.next();
						System.out.print("Enter Age :");
						age=in.nextInt();
						System.out.print("Enter Weight :");
						weight=in.nextInt();
						System.out.print("Enter Voice :");
						voice=in.next();
						System.out.print("Enter height of fly :");
						num=in.nextInt();
						
						animal=new Peacock(++ID,name,age,weight,voice,num);
						System.out.println(birdZone.addAnimalToZone(animal, "Peacock"));
						//birdZone.display();
						break;
					default:
						System.out.println("INVALID choice.");
						break;
					}
					break;
				default:
					System.out.println("INVALID choice.");
					break;
				}
				
				break;
			case 2:
				categoryMenu();
				choiceCat=in.nextInt();
				switch(choiceCat){
				case 1:
					System.out.println("1. Lion");
					System.out.print("Choose type of mammal :");
					choiceType=in.nextInt();
					switch(choiceType){
					case 1:
						System.out.print("Enter ID :");
						int id=in.nextInt();
						
						System.out.println(mammalZone.removeAnimalToZone(id, "Lion"));
						//mammalZone.display();
						break;
					default:
						System.out.println("INVALID choice.");
						break;
					}
					
					break;
				case 2:
					System.out.println("1. Crocodile");
					System.out.print("Choose type of reptile :");
					choiceType=in.nextInt();
					switch(choiceType){
					case 1:
						System.out.print("Enter ID :");
						int id=in.nextInt();
						
						System.out.println(reptileZone.removeAnimalToZone(id, "Crocodile"));
						//reptileZone.display();
						break;
					default:
						System.out.println("INVALID choice.");
						break;
					}
					break;
				case 3:
					System.out.println("1. Peacock");
					System.out.print("Choose type of bird :");
					choiceType=in.nextInt();
					switch(choiceType){
					case 1:
						System.out.print("Enter ID :");
						int id=in.nextInt();
						
						System.out.println(birdZone.removeAnimalToZone(id, "Peacock"));
						//birdZone.display();
						break;
					default:
						System.out.println("INVALID choice.");
						break;
					}
					break;
				default:
					System.out.println("INVALID choice.");
					break;
				}
				break;
			case 3:
				
				categoryMenu();
				choiceCat=in.nextInt();
				switch(choiceCat){
				case 1:
					System.out.println("1. Lion");
					System.out.print("Choose type of mammal :");
					choiceType=in.nextInt();
					switch(choiceType){
					case 1:
						System.out.print("Enter Limit of the Cage :");
						limit=in.nextInt();
						cage=new Cage("Lion",limit);
						
						System.out.println(mammalZone.addCage(cage));
						//mammalZone.display();
						break;
					default:
						System.out.println("INVALID choice.");
						break;
					}
					
					break;
				case 2:
					System.out.println("1. Crocodile");
					System.out.print("Choose type of reptile :");
					choiceType=in.nextInt();
					switch(choiceType){
					case 1:
						System.out.print("Enter Limit of the Cage :");
						limit=in.nextInt();
						cage=new Cage("Crocodile",limit);
						
						System.out.println(reptileZone.addCage(cage));
						//reptileZone.display();
						break;
					default:
						System.out.println("INVALID choice.");
						break;
					}
					break;
				case 3:
					System.out.println("1. Peacock");
					System.out.print("Choose type of bird :");
					choiceType=in.nextInt();
					switch(choiceType){
					case 1:
						System.out.print("Enter Limit of the Cage :");
						limit=in.nextInt();
						cage=new Cage("Peacock",limit);
						
						System.out.println(birdZone.addCage(cage));
						//birdZone.display();
						break;
					default:
						System.out.println("INVALID choice.");
						break;
					}
					break;
				default:
					System.out.println("INVALID choice.");
					break;
				}
				
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("INVALID choice.");
				break;
			}
			
		}while(ch != 0);

	}

}

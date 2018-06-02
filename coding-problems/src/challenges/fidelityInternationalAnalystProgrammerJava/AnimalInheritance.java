/**
 * In this challenge, you will be asked to build on an abstract class and initialize an instance
 * of each class with a variable. The program will then test your implementation by retrieving the
 * data you stored.
 * 
 * Complete the code in the editor below to implement the following:
 * 1. Three classes named Dog, Cow, and Duck that inherit from the Animal class.
 * 2. No argument constructors for each class that initialize the instance variables 
 *    inherited from the superclass.
 * 3. Each class must implement the getGreeting() method:
 *    a. For a Dog object, this must return the String ruff
 *    b. For a Cow object, this must return the String moo
 *    c. For a Duck object, this must return the String quack.
 */

package challenges.fidelityInternationalAnalystProgrammerJava;

abstract class Animal {
	protected boolean isMammal;
	protected boolean isCarnivorous;
	
	public Animal(boolean isMammal, boolean isCarnivorous) {
		this.isMammal = isMammal;
		this.isCarnivorous = isCarnivorous;
	}
	
	public boolean getIsMammal() {
		return this.isMammal;
	}
	
	public boolean getIsCarnivorous() {
		return this.isCarnivorous;
	}
	
	abstract public String getGreeting();
	
	public void printAnimal(String name) {
		System.out.println("A " + name + " says '" + this.getGreeting() + "', is " + (this.getIsCarnivorous() ? "" : "not ")
				+ "carnivorous, and is " + (this.getIsMammal() ? "" : "not ") + "a mammal.");
	}
}

class Dog extends Animal{
	public Dog() {
		super(true, true);
	}
	
	public String getGreeting() {
		return "ruff";
	}
}

class Cow extends Animal{
	public Cow() {
		super(true, false);
	}
	
	public String getGreeting() {
		return "moo";
	}
}

class Duck extends Animal{
	public Duck() {
		super(false, false);
	}
	
	public String getGreeting() {
		return "quack";
	}
}

public class AnimalInheritance{
	public static void main(String[] args) {
		Animal dog = new Dog();
		dog.printAnimal("dog");
		
		Animal cow = new Cow();
		cow.printAnimal("cow");
		
		Animal duck = new Duck();
		duck.printAnimal("duck");
	}
}

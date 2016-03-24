package Kwon.Min.Learn;

public class Animal
{
	public int varPublic;
	protected int varProtected;
	int varNone;
	private int varPrivate;
	
	public int weight;
	public String name;
	
	public Animal()
	{
		System.out.println("Animal constructor");
	}
	
	public Animal(int weight)
	{
		this.weight = weight;
	}
	
	public void roar()
	{
		System.out.println("Animal roars");
	}
	
	private void sleep()
	{
		System.out.println("Animal sleeps");
	}
	
	public static void main(String[]args)
	{
		Animal a = new Animal();
		a.sleep();
	}
}

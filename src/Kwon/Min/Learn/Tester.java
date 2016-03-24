package Kwon.Min.Learn;

import java.lang.reflect.Constructor;

public class Tester
{

	public static void main(String[] args)
	{
		Animal cat = new Cat();
		cat.roar();
		Cat cat2 = new Cat();
		Class c = cat.getClass();
		Constructor[] a = c.getConstructors();
		for (Constructor temp : a)
		{
			System.out.println(temp.toString());
		}
		
		System.out.println(cat2 instanceof Animal);
		System.out.println(cat.getClass().getConstructors());
		System.out.println(cat2.getClass());
	}

}

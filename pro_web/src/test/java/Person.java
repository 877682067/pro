

/**
 * ��
 * @author lijianan
 *
 */ 
public class Person implements Biology {

	private String name;
	private String age;
	
	
	public Person(String name , String age)
	{
		this.age = age;
		this.name = name;
	}
	
	public boolean eat(Food food)
	{
		if(food.isOverdue())
		{
			System.out.println("it is overdue,cant not eat!");
			return false;
		}
		System.out.println("it is good!");
		return true;
	}
	
	public String  getName()
	{
		return this.name;
	}
	public String getAge()
	{
		return age;
	}
}

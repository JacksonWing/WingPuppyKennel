 // Jackson Wing
// Java Capstone Programming Final (Class)
// 4/8/2024
// Class has eight fields that are passed through user input, each having getters and setters.
//	Zero args constructor is not used in the program and does not count towards the static puppy
//	count variable. DetermineLifeStage() and DetermineSize() determine the size and life stage
//  of a puppy with the weight and age fields. Depending on the lifestage and size of the puppy, the
//	price is determined through the PriceForDay() method. PriceForDay() is an overloaded method,
//  the other PriceForDay() gets the supplyFood boolean in order to determine if the user will be
//	charged an additional fee of $5, depending on whether or not they brought their own food.
//	The amount of puppy objects are determined by the static int variable puppyCount.

public class WingPuppy
{
	private static int puppyCount = 0;

	private String name;
	private String ownerName;
	private String ownerPhone;
	private int age;
	private String breed;
	private double weight;
	private boolean supplyFood;
	private String color;

	private String size;
	private String lifeStage;
	private double sizePrice;

	public WingPuppy(String _name, String _ownerName, String _ownerPhone, int _age, String _breed, double _weight, boolean _supplyFood, String _color)
	{
		puppyCount++;

		name = _name;
		ownerName = _ownerName;
		ownerPhone = _ownerPhone;
		age = _age;
		breed = _breed;
		weight = _weight;
		supplyFood = _supplyFood;
		color = _color;
	}

	public WingPuppy()
	{
		puppyCount++;

		name = "";
		ownerName = "";
		ownerPhone = "";
		age = 0;
		breed = "";
		weight = 0;
		supplyFood = false;
		color = "";
	}

	public static void minusPuppy()
	{
		puppyCount--;
	}

	public static int getPuppyCount()
	{
		return puppyCount;
	}

	public void setName(String _name)
	{
		name = _name;
	}

	public String getName()
	{
		return name;
	}

	public void setOwnerName(String _ownerName)
	{
		ownerName = _ownerName;
	}

	public String getOwnerName()
	{
		return ownerName;
	}

	public void setOwnerPhone(String _ownerPhone)
	{
		ownerPhone = _ownerPhone;
	}

	public String getOwnerPhone()
	{
		return ownerPhone;
	}

	public void setAge(int _age)
	{
		age = _age;
	}

	public int getAge()
	{
		return age;
	}

	public void setBreed(String _breed)
	{
		breed = _breed;
	}

	public String getBreed()
	{
		return breed;
	}

	public void setWeight(double _weight)
	{
		weight = _weight;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setSupplyFood(boolean _supplyFood)
	{
		supplyFood = _supplyFood;
	}

	public boolean getSupplyFood()
	{
		return supplyFood;
	}

	public void setColor(String _color)
	{
		color = _color;
	}

	public String getColor()
	{
		return color;
	}

	public String DetermineSize()
	{
		size = "";
		if(weight >= 0 && weight <= 10)
		{
			size = "Small";
		}
		if(weight >= 11 && weight <= 30)
		{
			size = "Medium";
		}
		if(weight >= 31 && weight <= 100)
		{
			size = "Large";
		}
		if(weight > 100)
		{
			size = "XLarge";
		}

		return size;
	}

	public String DetermineLifeStage()
	{
		lifeStage = "";
		if(age < 1)
		{
			lifeStage = "Puppy";
		}
		if(age >= 1 && age <= 3)
		{
			lifeStage = "Adolescent";
		}
		if(age >= 4 && age <= 8)
		{
			lifeStage = "Adult";
		}
		if(age > 8)
		{
			lifeStage = "Senior";
		}

		return lifeStage;
	}

	public double PriceForDay(String size, String lifeStage, double weight)
	{
		sizePrice = 0.0;
		if(size.equals("Small") || size.equals("Medium"))
		{
			sizePrice = 45.0;
		}

		if(size.equals("Large") || size.equals("XLarge"))
		{
			sizePrice = 45 + (0.1 * (weight - 30));
		}

		if(lifeStage.equals("Puppy"))
		{
			sizePrice += 10.0;
		}

		return sizePrice;
	}

	public double PriceForDay(boolean supplyFood)
	{
		double foodPrice = 0.0;
		if(!supplyFood)
		{
			foodPrice += 5.0;
		}
		else
		{
			foodPrice = 0.0;
		}

		return foodPrice;
	}

}
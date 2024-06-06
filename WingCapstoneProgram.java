// Jackson Wing
// Capstone Project
// 4/11/2024
// User is initially prompted to enter 1, 2, or 3. When user enters 1, the program gets user input
//	to get details about the puppy being registered into the kennel. These details are used to
//  calculate the price of the puppy and to determine whether or not there are duplicate puppies.
//	The maximum amount of puppies that can be held is 30. When user enters 2, the user is asked for a
//  phonenumber that is used to clean out the array of elements sharing that same phonenumber.
//	When user enters 3, all puppies and their information is written into the array.

import java.io.*;
import java.util.Scanner;

public class WingCapstoneProgram
{
	public static void main(String [] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);

		int optionSelect = 0; // Determines if the main program loop should continue or not.
		int SIZE = 30;
		int count;

		WingPuppy[] puppies = new WingPuppy[SIZE]; // Puppy array

		String name = "";
		String ownerName = "";
		String ownerPhone = "";
		int age;
		String breed = "";
		double weight;
		boolean supplyFood = false;
		String color = "";

		while(optionSelect != 1 && optionSelect != 2 && optionSelect != 3 && !Character.isDigit(optionSelect)) // Loop is triggered when menu input is invalid.
		{
			count = WingPuppy.getPuppyCount(); // Reference for the static puppyCount variable in the WingPuppy class. Updates variable upon menu reset.
			boolean duplicate = false; // Used to determine if duplicate info exists in puppy array.

			while(optionSelect != 1 && optionSelect != 2 && optionSelect != 3) // Checks for valid input and loops if criteria is not met.
			{
				System.out.println("Make a Selection: ");
				System.out.println("1. Check in Dog");
				System.out.println("2. Check out Dog");
				System.out.println("3. Exit");
				System.out.println();
				System.out.print("Enter here: ");
				while (!keyboard.hasNextInt() && optionSelect != 1 && optionSelect != 2 && optionSelect != 3)
				{
					System.out.println("Invalid input! Please enter 1, 2, or 3.");
					System.out.println("Make a Selection: ");
					System.out.println("1. Check in Dog");
					System.out.println("2. Check out Dog");
					System.out.println("3. Exit");
					System.out.println();
					System.out.print("Enter here: ");
					keyboard.next();
				}
				optionSelect = keyboard.nextInt();
				System.out.println();
				if(optionSelect != 1 && optionSelect != 2 && optionSelect != 3)
				{
					System.out.println("Invalid input! Please enter 1, 2, or 3.");
				}
			}

			if(optionSelect == 1) // If user enters 1.
			{
				if(count >= 30) // Checks if kennel is maxed out.
				{
					System.out.println("The kennel is currently at maximum capacity!");
					System.out.println();
					optionSelect = 0; // Resets the loop.
				}
				else // Executes if kennel isn't full
				{
					keyboard.nextLine();
					name = ""; // Initializes invalid input to trigger the loop.
					boolean validName = false;
					while(validName == false)
					{
						System.out.print("Enter the dog\'s name: ");
						name = keyboard.nextLine();
						char nameLetter;
						int letterNameCount = 0; // Sets count to see if all characters are letters.
						for(int i = 0; i < name.length(); i++)
						{
							nameLetter = name.charAt(i);
							if(Character.isLetter(nameLetter))
							{
								letterNameCount++;
							}
							else
							{
								// Makes the count and name length different. Therefore deteremining the input to be invalid.
							}
						}
						if(name.length() == letterNameCount && letterNameCount != 0)
						{
							validName = true;
						}
						else
						{
							System.out.println("Invalid characters were entered. Try again.");
							validName = false; // Resets the loop
							
							System.out.println();
						}
					}

					ownerName = "";
					boolean validOwnerName = false;
					while(validOwnerName == false)
					{
						System.out.print("Enter the owner\'s name: ");
						ownerName = keyboard.nextLine();
						char nameLetter;
						int letterOwnerCount = 0;
						for(int i = 0; i < ownerName.length(); i++)
						{
							nameLetter = ownerName.charAt(i);
							if(Character.isLetter(nameLetter))
							{
								letterOwnerCount++;
							}
							else
							{

							}
						}
						if(ownerName.length() == letterOwnerCount && letterOwnerCount != 0)
						{
							validOwnerName = true;
						}
						else
						{
							System.out.println("Invalid characters were entered. Try again.");
							validOwnerName = false;
							System.out.println();
						}
					}

					int phoneLength = 0; // Checks to see if phone number string has 10 characters
					while(phoneLength != 10)
					{
						System.out.print("Enter the owner\'s phone number: ");
						ownerPhone = keyboard.nextLine();
						phoneLength = ownerPhone.length();
						char letter;
						int digitCount = 0;
						for(int i = 0; i < phoneLength; i++)
						{
							letter = ownerPhone.charAt(i);
							if(Character.isDigit(letter))
							{
								digitCount++;
							}
							else
							{

							}
						}
						if(digitCount != 10)
						{
							System.out.println("Invalid input! Please enter a valid phone number in xxxxxxxxxx format!");
							System.out.println();
							phoneLength = 0;
						}
					}

					age = -1;
					while(age < 0)
					{
						System.out.print("Enter the dog\'s age (in whole years): ");
						while (!keyboard.hasNextInt() )
						{
							System.out.println("Invalid input! Please enter a positive integer.");
							System.out.print("Enter the dog\'s age (in whole years): ");
							keyboard.next();
					    }
					    age = keyboard.nextInt();
					    if(age < 0)
					    {
							System.out.println("Invalid input! Please enter a positive integer.");
						}
					}


					weight = 0.0;
					while(weight <= 0.0)
					{
						System.out.print("Enter the dog\'s weight: ");
						while(!keyboard.hasNextDouble())
						{
							System.out.println("Invalid input! Please enter a positive number.");
							System.out.print("Enter the dog\'s weight as a positive number: ");
							keyboard.next();
						}
						weight = keyboard.nextDouble();
						if(weight <= 0.0)
						{
							System.out.println("Invalid input! Please enter a positive number: ");
						}
						keyboard.nextLine();
					}

					breed = "";
					boolean validBreed = false;
					while(validBreed == false)
					{
						System.out.print("Enter the dog\'s breed: ");
						breed = keyboard.nextLine();
						char nameLetter;
						int letterBreedCount = 0;
						for(int i = 0; i < breed.length(); i++)
						{
							nameLetter = breed.charAt(i);
							if(Character.isLetter(nameLetter))
							{
								letterBreedCount++;
							}
							else
							{

							}
						}
						if(breed.length() == letterBreedCount && letterBreedCount != 0)
						{
							validBreed = true;
						}
						else
						{
							System.out.println("Invalid characters were entered. Try again.");
							validBreed = false;
							breed = "";
							System.out.println();
						}
					}

					color = "";
					boolean validColor = false;
					while(validColor == false)
					{
						System.out.print("Enter the dog\'s color: ");
						color = keyboard.nextLine();
						char nameLetter;
						int letterColorCount = 0;
						for(int i = 0; i < color.length(); i++)
						{
							nameLetter = color.charAt(i);
							if(Character.isLetter(nameLetter))
							{
								letterColorCount++;
							}
							else
							{

							}
						}
						if(color.length() == letterColorCount && letterColorCount != 0)
						{
							validColor = true;
						}
						else
						{
							System.out.println("Invalid characters were entered. Try again.");
							validColor = false;
							color = "";
							System.out.println();
						}
					}

					char supplies = 'x';
					while(supplies != 'Y' && supplies != 'N')
					{
						System.out.print("Did the owner bring their own dog supplies?(Y/N): ");
						supplies = keyboard.next().charAt(0);
						if(Character.isDigit(supplies))
						{
							System.out.println("Invalid input! Please select Y/N: ");
						}
						else
						{
							supplies = Character.toUpperCase(supplies);
							if(supplies != 'Y' && supplies != 'N')
							{
								System.out.println("Invalid input! Please select Y/N: ");
							}
						}
					}

					if(supplies == 'Y') // Determines if boolean is true or false based on Y/N input.
					{
						supplyFood = true;
					}
					if(supplies == 'N')
					{
						supplyFood = false;
					}

					for(int i = 0; i < count; i++) // Checks for duplicate info.
					{
						if(puppies[i] != null)
						{
							String puppyName = puppies[i].getName();
							String puppyOwner = puppies[i].getOwnerName();
							String puppyPhone = puppies[i].getOwnerPhone();
							int puppyAge = puppies[i].getAge();
							double puppyWeight = puppies[i].getWeight();
							String puppyBreed = puppies[i].getBreed();
							String puppyColor = puppies[i].getColor();
							boolean puppyFood = puppies[i].getSupplyFood();

							if(name.equals(puppyName) && ownerName.equals(puppyOwner) && ownerPhone.equals(puppyPhone) && age == puppyAge && weight == puppyWeight && breed.equals(puppyBreed) && color.equals(puppyColor) && supplyFood == puppyFood)
							{
								System.out.println("Error! Duplicate information has been entered.");
								System.out.println();
								duplicate = true;
							}
						}
					}

					if(!duplicate) // If the info is not a duplicate, prints cost related information.
					{
						puppies[count] = new WingPuppy(name, ownerName, ownerPhone, age, breed, weight, supplyFood, color);

						String size = puppies[count].DetermineSize(); // Methods to calculate price
						String lifeStage = puppies[count].DetermineLifeStage();
						double puppyPrice = puppies[count].PriceForDay(size, lifeStage, weight);
						double foodPrice = puppies[count].PriceForDay(supplyFood);

						double puppyTotal = puppyPrice + foodPrice;

						System.out.println();
						System.out.println("This dog classifies as " + size + " and as a(n) " + lifeStage + ".");
						System.out.printf("The dog brought in will cost $%.2f", puppyPrice);
						System.out.println();
						if(!supplyFood)
						{
							System.out.printf("The dog food will be an additional fee of $%.2f", foodPrice);
							System.out.println();
						}
						System.out.printf("The total cost is: $%.2f", puppyTotal);
						System.out.println();
						System.out.println();
					}

					if(duplicate)
					{
						System.out.println("Duplicate information was entered. Please enter unique information");
					}

					optionSelect = 0;
				}
			}

			if(optionSelect == 2)
			{
				if(count == 0) // Checks if there are no dogs in the kennel.
				{
					System.out.println("There are currently no dogs in the kennel.");
					System.out.println();

					optionSelect = 0;
				}
				else
				{
					String ownerNum = "";  // Checks for phone number in array.
					int phoneLength1 = 0;
					keyboard.nextLine();
					while(phoneLength1 != 10)
					{
						System.out.print("Enter the owner\'s phone number: ");
						ownerNum = keyboard.nextLine();
						phoneLength1 = ownerNum.length();
						char letter1;
						int digitCount1 = 0;
						for(int i = 0; i < phoneLength1; i++)
						{
							letter1 = ownerNum.charAt(i);
							if(Character.isDigit(letter1))
							{
								digitCount1++;
							}
							else
							{

							}
						}
						if(digitCount1 != 10)
						{
							System.out.println("Invalid input! Please enter a valid phone number in xxxxxxxxxx format!");
							System.out.println();
							phoneLength1 = 0;
						}
					}

					int phoneCount = 0; // Checks how many phones equal the input number.
					String phoneCheck;

					for(int i = 0; i < count; i++) // Sets puppy information to null values for later purposes.
					{
						phoneCheck = puppies[i].getOwnerPhone();
						if(phoneCheck.equals(ownerNum))
						{
							puppies[i].setName("");
							puppies[i].setOwnerName("");
							puppies[i].setOwnerPhone("");
							puppies[i].setAge(0);
							puppies[i].setWeight(0.0);
							puppies[i].setBreed("");
							puppies[i].setColor("");
							puppies[i].setSupplyFood(false);

							phoneCount++;
						}
					}

					int newCount = count - phoneCount; // Stores the value of the new amount of puppies in the array.

					WingPuppy[] placeholder = new WingPuppy[newCount]; // Placeholder array.
					int i2 = 0; // Place holder array count iterator.

					for(int i = 0; i < count; i++)
					{
						String puppyName = puppies[i].getName();
						String puppyOwner = puppies[i].getOwnerName();
						String puppyPhone = puppies[i].getOwnerPhone();
						int puppyAge = puppies[i].getAge();
						double puppyWeight = puppies[i].getWeight();
						String puppyBreed = puppies[i].getBreed();
						String puppyColor = puppies[i].getColor();
						boolean puppyFood = puppies[i].getSupplyFood();

						if(puppyName.equals("") && puppyOwner.equals("") && puppyPhone.equals("") && puppyAge == 0 && puppyWeight == 0.0 && puppyBreed.equals("") && puppyColor.equals("") && puppyFood == false)
						{
							// Puppies with phone number matching the previous input at line 379 will not be counted for the new amount of puppies.
						}
						else
						{
							placeholder[i2] = puppies[i]; // Assigns the puppies to a placeholder to change their index.
							i2++;
						}
					}

					System.out.println();

					for(int i = 0; i < newCount; i++)
					{
						puppies[i] = placeholder[i]; // Reassigns position to placeholder
					}

					int count2 = count;

					for(int i = newCount; i < count2; i++) // Calls minus puppy method to subtract from puppyCount variable from the WingPuppy class.
					{
						WingPuppy.minusPuppy();
					}

					optionSelect = 0; // Resets main loop
				}
			}

			if(optionSelect == 3) // Writes puppies into the file
			{
				PrintWriter writer = new PrintWriter("YesterdaysLatePickups.txt");
				for(int i = 0; i < count; i++)
				{
					writer.println(puppies[i].getName());
					writer.println(puppies[i].getOwnerName());
					writer.println(puppies[i].getOwnerPhone());
					writer.println(puppies[i].getAge());
					writer.println(puppies[i].getWeight());
					writer.println(puppies[i].getBreed());
					writer.println(puppies[i].getColor());
					if(puppies[i].getSupplyFood() == true)
					{
						writer.println("The owner brought their own food.");
					}
					else
					{
						writer.println("The owner did not bring their own food.");
					}
					writer.println();

					String size = puppies[i].DetermineSize();
					String lifeStage = puppies[i].DetermineLifeStage();
					double weightPrint = puppies[i].getWeight();
					double puppyPrice = puppies[i].PriceForDay(size, lifeStage, weightPrint);
					double foodPrice = puppies[i].PriceForDay(supplyFood);
					double puppyTotal = puppyPrice + foodPrice;

					writer.printf("The total cost is: $%.2f", puppyTotal);
					writer.println();
					writer.println("---------------------------------------");
					writer.println();
				}
				writer.close();
				keyboard.close();
			}

		}


	}
}
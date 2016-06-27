//Alex Dao

import java.util.Scanner;


//This class takes care of user interaction with the calendar by reading input and carrying out appropriate tasks
public class AppointmentMenu
{
		private AppointmentCalendar myCalendar;

		//constructs a default menu and initializes a calendar
		public AppointmentMenu()
		{
 			myCalendar = new AppointmentCalendar();
		}

		//reads user input and determines which operation to carry out
		public void run()
		{
			Scanner input = new Scanner(System.in);
			String response = "";

			while(!response.equalsIgnoreCase("Q"))
			{
				System.out.println("A)dd  C)ancel  S)how  Q)uit");

				response = input.nextLine();

				if(response.equalsIgnoreCase("A"))
				{
					add();
				}

				if(response.equalsIgnoreCase("S"))
				{
					show();
				}

				if(response.equalsIgnoreCase("C"))
				{
					cancel();
				}
			}
		}

		//adds a new appointment by reading user input, making new object with the description, and adding it
		//if adding fails because the appointment is already there, the method notifies the user
		public void add()
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Appointment (Description Date From To)");
			String tempDescription = input.nextLine();
			String tempDate1 = input.nextLine();
			String tempStart = input.nextLine();
			String tempEnd = input.nextLine();

			Appointments tempAppointment = new Appointments(tempDescription,tempDate1,tempStart,tempEnd);

			if (myCalendar.search(tempAppointment))
			{
				System.out.println("This appointment already exists.");
			}

			else
			{
				myCalendar.add(tempAppointment);
			}

			System.out.println();
		}

		//shows appointments for a specific user inputed date
		public void show()
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Show appointments for which date?");
			String tempDate2 = input.nextLine();
			String tempString = myCalendar.showDay(tempDate2);
			if (tempString.length() > 0)
			{
				System.out.println("Appointments:");
				System.out.println(myCalendar.showDay(tempDate2));
			}

			else
				System.out.println("There are no appointments on this day.");

			System.out.println();
		}

		//cancels a specific appointment based on user selection
		public void cancel()
		{
			Scanner input = new Scanner(System.in);
			
			System.out.println("Cancel appointments on which date?");
			String tempDate3 = input.nextLine();
			if(myCalendar.showForCancel(tempDate3).length() > 0)
			{
				System.out.println(myCalendar.showForCancel(tempDate3));
				System.out.println("Which would you like to cancel?");
				int removeWhich = Integer.parseInt(input.nextLine());
				int tempNum = removeWhich;

				int currentIndex = myCalendar.findIndex(tempDate3);
				
				while(tempNum > 1)
				{
					currentIndex = myCalendar.findNextIndex(tempDate3, currentIndex);
					tempNum--;
				}

				myCalendar.cancel(currentIndex);
			}

			else
				System.out.println("There are no appointments on this day.");

			System.out.println();
		}

		//returns the calendar object
		public AppointmentCalendar getCalendar()
		{
			return myCalendar;
		}
}

//Alex Dao

import java.util.ArrayList;

//This class keeps track of different appointments in a list and allows for related operations
public class AppointmentCalendar
{
	private ArrayList<Appointments> appointmentList;

	//constructs an default calendar and initializes the list to hold appointments
	public AppointmentCalendar()
	{
		appointmentList = new ArrayList<Appointments>();
	}

	//adds an appointment to the list
	public void add(Appointments newAppointment)
	{
		appointmentList.add(newAppointment);
	}

	//if there is an exact match of appointments, the method returns true
	public boolean search(Appointments tempAppointment)
	{
		for(int i = 0; i < appointmentList.size(); i++)
		{
			if(tempAppointment.equals(appointmentList.get(i)))
			{
				return true;
			}
		}

		return false;
	}

	//removes an appointment from the list
	public void cancel(int removeIndex)
	{
		appointmentList.remove(removeIndex);
	}

	//custom String output for a cancel method call
	public String showForCancel(String newDate)
	{
		String resultString = "";
		int matchCount = 0;
		int counter = 1;

		for(int i = 0; i < appointmentList.size(); i ++)
		{
			if (appointmentList.get(i).checkDate(newDate).length() > 0)
				matchCount++;
		}

		for(int i = 0; i < appointmentList.size(); i ++)
		{
			if (appointmentList.get(i).checkDate(newDate).length() > 0)
			{
				resultString += counter + ")" + appointmentList.get(i).checkDate(newDate);
				counter++;
				
				if (matchCount > 1)
				{
					resultString += "\n";
					matchCount--;
				}
			}
		}
		return resultString;
	}

	//string output for show method call
	public String showDay(String newDate)
	{
		String resultString = "";
		int matchCount = 0;

		for(int i = 0; i < appointmentList.size(); i ++)
		{
			if (appointmentList.get(i).checkDate(newDate).length() > 0)
				matchCount++;
		}

		for(int i = 0; i < appointmentList.size(); i ++)
		{
			if (appointmentList.get(i).checkDate(newDate).length() > 0)
			{
				resultString += appointmentList.get(i).checkDate(newDate);
				
				if (matchCount > 1)
				{
					resultString += "\n";
					matchCount--;
				}
			}
		}
		return resultString;
	}

	//finds the index of the first occurence of a given date
	public int findIndex(String newDate)
	{
		int index = -1;

		for(int i = 0; i < appointmentList.size(); i++)
		{
			if (appointmentList.get(i).checkDate(newDate).length() > 0)
			{
				index = i;				
				i = appointmentList.size() + 1;
			}
		}

		return index;
	}

	//find the index of a matching appointment given a starting point
	public int findNextIndex(String newDate, int startIndex)
	{
		int index = -1;

		for(int i = startIndex + 1; i < appointmentList.size(); i++)
		{
			if (appointmentList.get(i).checkDate(newDate).length() > 0)
			{
				index = i;				
				i = appointmentList.size() + 1;
			}
		}

		return index;
	}


	//returns the appointment list
	public ArrayList<Appointments> getAppointmentList()
	{
		return appointmentList;
	}
}

//Alex Dao

//this class holds information about each appointment and aspects of the appointment
public class Appointments
{
	private String description, date, startTime, endTime;

	//constructs an appointment object and initializes its properties
	public Appointments(String newDescription, String newDate, String newStart, String newEnd)
	{
		description = newDescription;
		date = newDate;
		startTime = newStart;
		endTime = newEnd;
	}

	//compares twho appointment objects and determines whether they are the same or not
	public boolean equals(Appointments tempApp)
	{
		boolean isEqual = description.equalsIgnoreCase(tempApp.description) && date.equals(tempApp.date) && startTime.equals(tempApp.startTime) && endTime.equals(tempApp.endTime);
		return isEqual;
	}

	//converts the appintment into a string format
	public String toString()
	{
		String resultString = description + "\n" + date + "\n" + startTime + "\n" + endTime + "\n";
		return resultString;
	}

	//if the date matches input, then it returns the appointment
	public String checkDate(String tempDate)
	{
		String resultString = "";
		if (tempDate.equals(date))
		{
			resultString = description + " " + date + " " + startTime + " " + endTime + " ";
		}
		return resultString;
	}

	//returns the description
	public String getDescription()
	{
		return description;
	}

	//returns the date
	public String getDate()
	{
		return date;
	}

	//returns the starting time of the appointment
	public String getStartTime()
	{
		return startTime;
	}

	//returns the ending time of the appointment
	public String getEndTime()
	{
		return endTime;
	}
}

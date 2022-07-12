package lightpole.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datetime 
{
	public String GetTodayDateAndTime() 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ss");
		Date date = new Date();
		String todaydate = dateFormat.format(date);
		return todaydate;
	}
}

package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
  public int getRandomNumber() {
	  Random ran=new Random();
	  int randomnumber =ran.nextInt(5000);
	  return randomnumber;
  }
  public String getSystemDateYYYYDDMM() {
	  Date dateobj=new Date();
	  SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	  String actdate=sim.format(dateobj);
	  return actdate;
  }
  public String getRequriedDateYYYYDDMM(int days){
	  Date dateobj=new Date();
	  SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	  sim.format(dateobj);
	 Calendar cal = sim.getCalendar();
	 cal.add(Calendar.DAY_OF_MONTH,days);
	 String reqdate = sim.format(cal.getTime());
	 return reqdate;
	
  }
}

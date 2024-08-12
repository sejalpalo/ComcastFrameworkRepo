package pratice;

import java.util.Date;

public class CaptureTimeStamp {
  public static void main(String[] args) {
	String time=new Date().toString().replace(" ","_").replace(":","_");
	System.out.println(time);//but i donot want space and colon bcz classname doesnot contain space or colon
}
}

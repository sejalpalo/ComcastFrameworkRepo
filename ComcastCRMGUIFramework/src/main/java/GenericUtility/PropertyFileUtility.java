package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
  public String getDataFromPropertiesFile(String key) throws IOException {
	  FileInputStream fis =new FileInputStream("./conFigAppData/commondata.properties.txt");
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
  }
}

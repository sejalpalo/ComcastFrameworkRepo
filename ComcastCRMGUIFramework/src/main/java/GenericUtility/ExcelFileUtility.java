   package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
  public String getDataFromExcel(String sheetName,int row,int cel) throws IOException {
	  FileInputStream efis=new FileInputStream("./testdata/testdata.xlsx");
	 Workbook wb = WorkbookFactory.create(efis);
	String data=wb.getSheet(sheetName).getRow(row).getCell(cel).toString();
	wb.close();
	 return data;
  }
   
  
  public int getRowCount(String sheetname) throws IOException {
	  FileInputStream fis=new FileInputStream("./testdata/testdata.xlsx");
	  Workbook wb = WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		 return rowcount;
	  
	  
  }
  public void setDataIntoExcel(String sheetName,int row,int cel,String data) throws IOException {
	  FileInputStream fis=new FileInputStream("./testdata/testdata.xlsx");
	  Workbook wb = WorkbookFactory.create(fis);
	  wb.getSheet(sheetName).getRow(row).createCell(cel);
	  FileOutputStream fos=new FileOutputStream("./testdata/testdata.xlsx");
	  wb.write(fos);
	  wb.close();
  }
  
  
  
  
}

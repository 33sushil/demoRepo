package task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static List<LoginDetails> readData() throws IOException{

		File file = new File("C:\\Users\\Sushil\\eclipse-workspace\\GmailLogin\\excel\\TestData.xlsx");
		FileInputStream input=new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		XSSFRow row = null;
		XSSFCell cell = null;
		String username = null;
		String password = null;
		List<LoginDetails> loginDetails = new ArrayList<LoginDetails>();
		for(int i=1;i<sheet.getLastRowNum();i++) {
			LoginDetails ld = new LoginDetails();
			row = sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++) {

				cell=row.getCell(j);

				if(j==0) {
					ld.setUsername(cell.getStringCellValue());
				}
				if(j==1) {
					ld.setPassword(cell.getStringCellValue());
				}
				
			}
			loginDetails.add(ld);
		}
		return  loginDetails;
	}

}

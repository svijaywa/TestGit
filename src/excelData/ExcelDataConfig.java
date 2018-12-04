package excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelDataConfig {

		
		XSSFWorkbook wb;
		XSSFSheet sh1;
		
		public ExcelDataConfig(String excelpath)
		{
		try {
			File src=new File(excelpath);
			 
			   // load file
			   FileInputStream fis=new FileInputStream(src);
			 
			   // Load workbook
			   wb=new XSSFWorkbook(fis);
			   
			   
			      
		} catch (Exception e) {
		
			e.printStackTrace();
		
		}
		}
		
		
		public String getData(int sheetNumber, int row, int column)
		{
			sh1= wb.getSheetAt(0);
			String data = sh1.getRow(row).getCell(column).getStringCellValue();
			return data;
			
		}
		public int getRowCount(int sheetIndex){
			
			int row = wb.getSheetAt(sheetIndex).getLastRowNum();
			row = row+1;
			return row;
		}
		
		
	}









	
	


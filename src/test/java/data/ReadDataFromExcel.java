package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel
{
	private XSSFWorkbook wb;
	
	public ReadDataFromExcel(String path) throws IOException
	{
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src); 
		wb = new XSSFWorkbook(fis);
	}
	
	public String getData(int sheetnumber, int rows, int columns)
	{
		XSSFSheet sheet = wb.getSheetAt(sheetnumber);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(sheet.getRow(rows).getCell(columns));
		return data;
	}
	
	public int getRowCount(int sheetnumber)
	{
		int row = wb.getSheetAt(sheetnumber).getLastRowNum();
		row = row+1;
		return row;
	}
}
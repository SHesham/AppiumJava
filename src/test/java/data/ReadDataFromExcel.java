package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ReadDataFromExcel
{
	private XSSFWorkbook wb;
	
	ReadDataFromExcel(String path) throws IOException
	{
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src); 
		wb = new XSSFWorkbook(fis);
	}

	@SuppressWarnings("UnnecessaryLocalVariable")
	String getData(int sheetNumber, int rows, int columns)
	{
		XSSFSheet sheet = wb.getSheetAt(sheetNumber);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(sheet.getRow(rows).getCell(columns));
		return data;
	}
	
	int getRowCount(int sheetNumber)
	{
		int row = wb.getSheetAt(sheetNumber).getPhysicalNumberOfRows();
		row = row+1;
		return row;
	}
}
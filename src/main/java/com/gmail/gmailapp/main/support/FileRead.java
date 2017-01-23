//package com.siebel.mcrmapp.main.support;

package com.gmail.gmailapp.main.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.poi.ss.usermodel.DataFormatter;

public class FileRead {
	public static String Country;
	String File1Location=null;
	String File2Location=null;
	String Browser=null;
	String AppUrl=null;
	File OpenFile1=null;
	File OpenFile2=null;
	public FileInputStream ReadFile1=null;
	public FileInputStream ReadFile2=null;
	public Properties FileProperty1=null;
	Workbook book=null;
	Sheet sheet1=null;
	Sheet sheet2=null;
	Sheet sheet3=null;
	Sheet sheet4=null;
	Sheet sheet5=null;
	int TotalRowsInSheet1=0;
	int TotalRowsInSheet2=0;
	int TotalRowsInSheet3=0;
	int TotalRowsInSheet4=0;
	int TotalRowsInSheet5=0;
	DataFormatter dataformat = null;
	Cell cell=null;
	String CellData=null;
	String ColumnName=null;
	String TestColumnName=null;
	Boolean SetFlag;
	JsonParser parser = null;
	Object obj=null;
	JsonObject jsonObject= null;

	public FileRead() throws IOException{
		File1Location="src/test/resources/ExcelSheet.xlsx";
		File2Location="src/test/resources/UIObjects.properties";
		OpenFile1=new File(File1Location);
		OpenFile2=new File(File2Location);
		ReadFile1=new FileInputStream(OpenFile1);
		ReadFile2=new FileInputStream(OpenFile2);
		FileProperty1=new Properties();
		book=new XSSFWorkbook(ReadFile1);
		dataformat=new DataFormatter();
		sheet1=book.getSheet("Browser");
		sheet2=book.getSheet("TestData");
		sheet3=book.getSheet("Country");
		//sheet4=book.getSheet("NewUsers");
		//sheet5=book.getSheet("Country");
		TotalRowsInSheet1=sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		TotalRowsInSheet2=sheet2.getLastRowNum()-sheet2.getFirstRowNum();
		TotalRowsInSheet3=sheet3.getLastRowNum()-sheet3.getFirstRowNum();
		//TotalRowsInSheet4=sheet4.getLastRowNum()-sheet4.getFirstRowNum();
		//TotalRowsInSheet5=sheet5.getLastRowNum()-sheet5.getFirstRowNum();
		FileProperty1.load(ReadFile2);

		parser = new JsonParser();
		obj=parser.parse(new FileReader("src/test/resources/config.json"));
		jsonObject= (JsonObject) obj;
	}
	public String GetSheet1Data(String DataRow,String Field) throws IOException{
		for(int i=0; i<=TotalRowsInSheet1; i++){
			Row row=sheet1.getRow(i);
			Row row1=sheet1.getRow(0);
			TestColumnName=row.getCell(0).getStringCellValue();
			if(TestColumnName.equals(DataRow)){
				for(int j=1; j<=row.getLastCellNum(); j++){
					ColumnName=row1.getCell(j).getStringCellValue();
					if(ColumnName.equals(Field)){
						cell= row.getCell(j);
						CellData=dataformat.formatCellValue(cell);
						break;
					}
				}
			}
		}
		return CellData;
	}

//	public String GetSheet4Data(String DataRow,String Field) throws IOException{
//		for(int i=0; i<=TotalRowsInSheet4; i++){
//			Row row=sheet4.getRow(i);
//			Row row1=sheet4.getRow(0);
//			TestColumnName=row.getCell(0).getStringCellValue();
//			if(TestColumnName.equals(DataRow)){
//				for(int j=1; j<=row.getLastCellNum(); j++){
//					ColumnName=row1.getCell(j).getStringCellValue();
//					if(ColumnName.equals(Field)){
//						cell= row.getCell(j);
//						CellData=dataformat.formatCellValue(cell);
//						break;
//					}
//				}
//			}
//		}
//		return CellData;
//	}


	public String GetSheet2Data(String DataRow,String Field) throws IOException{
		for(int i=0; i<=TotalRowsInSheet2; i++){
			Row row=sheet2.getRow(i);
			Row row1=sheet2.getRow(0);
			TestColumnName=row.getCell(0).getStringCellValue();
			if(TestColumnName.equals(DataRow)){
				for(int j=1; j<=row.getLastCellNum(); j++){
					ColumnName=row1.getCell(j).getStringCellValue();
					if(ColumnName.equals(Field)){
						cell= row.getCell(j);
						CellData=dataformat.formatCellValue(cell);
						break;
					}
				}
			}
		}
		return CellData;
	}

//	public String GetSheet3Data(String DataRow,String Field) throws IOException{
//		for(int i=0; i<=TotalRowsInSheet3; i++){
//			Row row=sheet3.getRow(i);
//			Row row1=sheet3.getRow(0);
//			TestColumnName=row.getCell(0).getStringCellValue();
//			if(TestColumnName.equals(DataRow)){
//				for(int j=1; j<=row.getLastCellNum(); j++){
//					ColumnName=row1.getCell(j).getStringCellValue();
//					if(ColumnName.equals(Field)){
//						cell= row.getCell(j);
//						CellData=dataformat.formatCellValue(cell);
//						break;
//					}
//				}
//			}
//		}
//		return CellData;
//	}

	public String getUIElement(String Locator) throws IOException
	{
		return FileProperty1.getProperty(Locator);
	}

	public String GetCountryData(String DataRow,String Field) throws IOException{
		for(int i=0; i<=TotalRowsInSheet3; i++){
			Row row=sheet3.getRow(i);
			Row row1=sheet3.getRow(0);
			cell=row.getCell(0);
			TestColumnName=dataformat.formatCellValue(cell);
			if(TestColumnName.equalsIgnoreCase(DataRow)){
				for(int j=1; j<=row.getLastCellNum(); j++){
					ColumnName=row1.getCell(j).getStringCellValue();
					if(ColumnName.equals(Field)){
						cell= row.getCell(j);
						CellData=dataformat.formatCellValue(cell);
						Country=CellData;
						break;
					}
				}
			}
		}
		return Country;
	}

	public String getCountrySpecificValue(String attribute){
		return (jsonObject.getAsJsonObject(FileRead.Country).get(attribute)).getAsString();
	}
}

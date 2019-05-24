package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	
	
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	
	public ExcelReader(String path) {
		
		this.path=path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}
	
	
	// returns the row count in a sheet
	public int getRowCount(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else{
		sheet = workbook.getSheetAt(index);
		int number=sheet.getLastRowNum()+1;
		return number;
		}
		
	}
	
	
	
	// returns the data from a cell
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName,String colName,int rowNum){
		try{
			if(rowNum <=0)
				return "";
		
		int index = workbook.getSheetIndex(sheetName);
		int col_Num=-1;
		if(index==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				col_Num=i;
		}
		if(col_Num==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(col_Num);
		
		if(cell==null)
			return "";
		
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			  return cell.getStringCellValue();
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
			  
			  String cellText  = String.valueOf(cell.getNumericCellValue());
			  if (HSSFDateUtil.isCellDateFormatted(cell)) {
		           
				  double d = cell.getNumericCellValue();

				  Calendar cal =Calendar.getInstance();
				  cal.setTime(HSSFDateUtil.getJavaDate(d));
		            cellText =
		             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
		           cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
		                      cal.get(Calendar.MONTH)+1 + "/" + 
		                      cellText;
		           
		          

		         }

			  
			  
			  return cellText;
		  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
		      return ""; 
		  else 
			  return String.valueOf(cell.getBooleanCellValue());
		
		}
		catch(Exception e){
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}
	
	
	
	// returns the data from a cell
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			if(rowNum <=0)
				return "";
		
		int index = workbook.getSheetIndex(sheetName);

		if(index==-1)
			return "";
		
	
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(colNum);
		if(cell==null)
			return "";
		
	  if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		  return cell.getStringCellValue();
	  else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
		  
		  String cellText  = String.valueOf(cell.getNumericCellValue());
		  if (HSSFDateUtil.isCellDateFormatted(cell)) {
	           // format in form of M/D/YY
			  double d = cell.getNumericCellValue();

			  Calendar cal =Calendar.getInstance();
			  cal.setTime(HSSFDateUtil.getJavaDate(d));
	            cellText =
	             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
	           cellText = cal.get(Calendar.MONTH)+1 + "/" +
	                      cal.get(Calendar.DAY_OF_MONTH) + "/" +
	                      cellText;
	           
	         

	         }

		  
		  
		  return cellText;
	  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
	      return "";
	  else 
		  return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}
	
	
	
	
	// returns true if data is set successfully else false
	public boolean setCellData(String sheetName,String colName,int rowNum, String data){
		try{
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);

		if(rowNum<=0)
			return false;
		
		int index = workbook.getSheetIndex(sheetName);
		int colNum=-1;
		if(index==-1)
			return false;
		
		
		sheet = workbook.getSheetAt(index);
		

		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(row.getCell(i).getStringCellValue().trim().equals(colName))
				colNum=i;
		}
		if(colNum==-1)
			return false;

		sheet.autoSizeColumn(colNum); 
		row = sheet.getRow(rowNum-1);
		if (row == null)
			row = sheet.createRow(rowNum-1);
		
		cell = row.getCell(colNum);	
		if (cell == null)
	        cell = row.createCell(colNum);

	    
	    cell.setCellValue(data);

	    fileOut = new FileOutputStream(path);

		workbook.write(fileOut);

	    fileOut.close();	

		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	// returns true if data is set successfully else false
	
	
	
	
	// returns true if sheet is created successfully else false
	public boolean addSheet(String  sheetname){		
		
		FileOutputStream fileOut;
		try {
			 workbook.createSheet(sheetname);	
			 fileOut = new FileOutputStream(path);
			 workbook.write(fileOut);
		     fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// returns true if sheet is removed successfully else false if sheet does not exist
	public boolean removeSheet(String sheetName){		
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return false;
		
		FileOutputStream fileOut;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
		    fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	// returns true if column is created successfully

		
	
  // find whether sheets exists	
	public boolean isSheetExist(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1){
			index=workbook.getSheetIndex(sheetName.toUpperCase());
				if(index==-1)
					return false;
				else
					return true;
		}
		else
			return true;
	}
	
	
	// returns number of columns in a sheet	
	public int getColumnCount(String sheetName){
		// check if sheet exists
		if(!isSheetExist(sheetName))
		 return -1;
		
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		
		if(row==null)
			return -1;
		
		return row.getLastCellNum();
		
		
		
	}
	
	
	//String sheetName, String testCaseName,String keyword ,String URL,String message

	public int getCellRowNum(String sheetName,String colName,String cellValue){
		
		for(int i=2;i<=getRowCount(sheetName);i++){
	    	if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
	    		return i;
	    	}
	    }
		return -1;
		
	}
		
	
	
	//==================================================================================================
	//================================================================================================
	
//	public String  excellocation =null;
//	public XSSFWorkbook workbook;
//	public XSSFSheet sheet;
//		
//	public ExcelReader(String excellocation) {
//		
//		this.excellocation = excellocation;
//		
//	}
//	
//	
//	@SuppressWarnings("deprecation")
//	public String[][] getExcelData(String sheetName) {
//
//		try {
//
//			String dataSets[][] = null;
//
//			FileInputStream file = new FileInputStream(new File(excellocation));
//
//			// Create Workbook instance holding reference to .xlsx file
//
//			workbook = new XSSFWorkbook(file);
//
//			// Get first/desired sheet from the workbook
//
//			sheet = workbook.getSheet(sheetName);
//
//			// count number of active rows
//
//			int totalRow = sheet.getLastRowNum();
//
//			// count number of active columns in row
//
//			int totalColumn = sheet.getRow(0).getLastCellNum();
//
//			// Create array of rows and column
//
//			dataSets = new String[totalRow][totalColumn];
//
//			// Iterate through each rows one by one
//
//			Iterator<Row> rowIterator = sheet.iterator();
//
//			int i = 0;
//
//			while (rowIterator.hasNext()) {
//
//				System.out.println(i);
//
//				Row row = rowIterator.next();
//
//				// For each row, iterate through all the columns
//
//				Iterator<Cell> cellIterator = row.cellIterator();
//
//				int j = 0;
//
//				while (cellIterator.hasNext()) {
//
//					Cell cell = cellIterator.next();
//
//					if (cell.getStringCellValue().contains("firstName")||cell.getStringCellValue().contains("customer") ) {
//
//						break;
//
//					}
//
//					// Check the cell type and format accordingly
//
//					switch (cell.getCellType()) {
//
//					case Cell.CELL_TYPE_NUMERIC:
//
//						dataSets[i - 1][j++] = cell.getStringCellValue();
//
//						System.out.println(cell.getNumericCellValue());
//
//						break;
//
//					case Cell.CELL_TYPE_STRING:
//
//						dataSets[i - 1][j++] = cell.getStringCellValue();
//
//						System.out.println(cell.getStringCellValue());
//
//						break;
//
//					case Cell.CELL_TYPE_BOOLEAN:
//
//						dataSets[i - 1][j++] = cell.getStringCellValue();
//
//						System.out.println(cell.getStringCellValue());
//
//						break;
//
//					case Cell.CELL_TYPE_FORMULA:
//
//						dataSets[i - 1][j++] = cell.getStringCellValue();
//
//						System.out.println(cell.getStringCellValue());
//
//						break;
//
//					}
//
//				}
//
//				System.out.println("");
//
//				i++;
//
//			}
//
//			file.close();
//
//			return dataSets;
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
//
//		return null;
//
//	}
//	
//	public int getRowCount(String sheetName){
//		int index = workbook.getSheetIndex(sheetName);
//		if(index==-1)
//			return 0;
//		else{
//		sheet = workbook.getSheetAt(index);
//		int number=sheet.getLastRowNum()+1;
//		return number;
//		}
//		
//	}
//	
////	public static void main(String[] args) {
////		
////		String excellocation = "C:\\Users\\ASHISH\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\excel\\testdata.xlsx";
////		
////		String sheetname = "AddCustomerTest";
////		ExcelReader excel = new ExcelReader();
////		String[][] data = excel.getExcelData(excellocation, sheetname);
////		
////		System.out.println(data);
////	}
//	
//	public String getCellData(String sheetName, String colName, int rowNum) {
//
//		try {
//
//			int col_Num = 0;
//
//			int index = workbook.getSheetIndex(sheetName);
//
//			sheet = workbook.getSheetAt(index);
//
//			XSSFRow row = sheet.getRow(0);
//
//			for (int i = 0; i < row.getLastCellNum(); i++) {
//
//				if (row.getCell(i).getStringCellValue().equals(colName)) {
//
//					col_Num = i;
//
//					break;
//
//				}
//
//			}
//
//			row = sheet.getRow(rowNum - 1);
//
//			
//
//			XSSFCell cell = row.getCell(col_Num);
//
//			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
//
//				return cell.getStringCellValue();
//
//			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
//
//				return "";
//
//			}
//
//
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
//
//
//
//		return null;
//
//	}

}

package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		Step 1) create the java rep object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		
//		Step 2) get the access of WorkBook by using WorkBookFactory <<C>>
		Workbook wb = WorkbookFactory.create(fis);
		
//		Step 3) get the access of Sheet by using getSheet() and pass the sheetname
		Sheet sh = wb.getSheet("org");
		
//		Step 4) get the access of Row by using getRow() and pass the row index
		Row row =  sh.getRow(3);
		
//		Step 5) get the access of Cell by using getCell() and pass the cell index
		Cell cell = row.getCell(0);
		
//		Ṣtep 6) get the value by using getStringCellValue()
		String value = cell.getStringCellValue();
		System.out.println(value);
		
//		dont forget to close the file
		fis.close();
		wb.close();
	}
}

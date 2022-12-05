package com.example.demo.helper;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.Entity.Product;



public class Helper {
	
	public static boolean checkExelFormat(MultipartFile file) {
		String contentType = file.getContentType();
		if(contentType=="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") {
			return true;
		}
		else
			return true;
	}
		
	//Converts excel to list of products
	 public static List<Product> convertExcelToListOfProducts(InputStream is){
		 List<Product> list = new ArrayList<Product>();
		 try {
			 
			@SuppressWarnings("resource")
			XSSFWorkbook workbook= new XSSFWorkbook(is);
			XSSFSheet sheet= workbook.getSheet("Sheet1");
			
			int rowNumber=0;
			Iterator<Row> iterator = sheet.iterator();
			while(iterator.hasNext()) {
				Row row = iterator.next();
				if(rowNumber==0)
				{
					rowNumber++;
					continue;
				}
				
				Iterator<Cell> cells = row.iterator();
				int cid=0;
				Product pdt =new Product();
				
				while(cells.hasNext()) {
					Cell cell = cells.next();
					
					switch(cid)
					{
					case 0:
						pdt.setPname(cell.getStringCellValue());
						break;
					case 1:
						pdt.setCname(cell.getStringCellValue());
						break;
					
					case 2:
						pdt.setPrize((int) cell.getNumericCellValue());
						break;
					
					case 3:
						pdt.setQuantity((int)cell.getNumericCellValue());
						break;
					case 4:
						pdt.setUrl(cell.getStringCellValue());
						break;
					
					default :
						break;
					}
					cid++;
				}
				list.add(pdt);
			}
				
			
			
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return list;
	 }

}




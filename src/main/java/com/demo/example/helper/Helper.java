package com.demo.example.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demo.example.address.entities.Address;



public class Helper {
	
	public static String[] HEADERS= {
			 "id",
			 "state",
			  "city",
			  "housenumber",
			 
		};
		

	 
		public static String SHEET_NAME="address_data";
		 public static ByteArrayInputStream dataToExcel(List<Address> list) {
			 
			 //create work book
			 
			 Workbook workbook = new XSSFWorkbook();
			 ByteArrayOutputStream out= new ByteArrayOutputStream();
			 
			 try {
			
				 
				 //create sheet
				 Sheet sheet=workbook.createSheet(SHEET_NAME);
				 
				 //create rows:header row
				 Row row = sheet.createRow(0);
				 for(int i=0; i<HEADERS.length;i++) {
					Cell cell = row.createCell(i);
					cell.setCellValue(HEADERS[i]);
				 }
				 //value rows
				 int rowindex=1;
				 for(Address p:list) {
					 
					 Row dataRow = sheet.createRow(rowindex);
					 rowindex++;
					 
					 dataRow.createCell(0).setCellValue(p.getId());
					 dataRow.createCell(1).setCellValue(p.getState());
					 dataRow.createCell(2).setCellValue(p.getCity());
					 dataRow.createCell(3).setCellValue(p.getHousenumber());
					 
				 }
				 workbook.write(out);
				 return new ByteArrayInputStream(out.toByteArray());
				 
			 }catch(IOException e) {
		     e.printStackTrace();
		     System.out.println("fail to import data");
			 }
			finally {
				try {
					
					workbook.close();
				    out.close();
				}catch(IOException e) {
					e.printStackTrace();
				}

			}

			 
			 return null;
		 }
		

}

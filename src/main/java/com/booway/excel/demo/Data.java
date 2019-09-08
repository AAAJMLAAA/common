package com.booway.excel.demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 主要思想使用内存的对象，理解内存对象的含义
 * @author jinmingliang
 *
 */
public class Data 
{
	public static void main(String[] args) 
	{
		File file = new File("D:\\user.xls");
		List<DataSet> dataSets = new ArrayList<>();
		try
		{
			Workbook workbook = new HSSFWorkbook(new FileInputStream(file));
			
			Sheet sheet = workbook.getSheet("user");
			List<DataSet> lists = new ArrayList<>();
			Row row = sheet.getRow(0);
			int cells = row.getPhysicalNumberOfCells();
			List<String> list = new ArrayList<>();
	//		List<DataSet> dataSets = new ArrayList<>();
			for (int x = 0 ; x < cells ; x++)
			{
				String value = row.getCell(x).getStringCellValue();
				list.add(value);
			}
			
			int rowNum = sheet.getLastRowNum() + 1;
			
			for (int x = 1 ; x < rowNum ; x++)
			{
				Row r = sheet.getRow(x);
				int cells2 = r.getPhysicalNumberOfCells();
				Map<String,String> map = new HashMap<>();
				DataSet dataSet = new DataSet();
				for (int y = 0 ; y < cells2 ; y++)
				{
					map.put(list.get(y), r.getCell(y).getStringCellValue());
					dataSet.setMap(map);
				}
				
				dataSets.add(dataSet);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		for (DataSet dataSet : dataSets)
		{
			System.out.println(dataSet.getMap().get("name"));
		}
	}
}

package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.collect.Table.Cell;

public class GenericUtils {

	public static JSONObject jsonReader(String Path) {
		String path = System.getProperty("user.dir") + Path;
		FileReader reader = null;
		try {
			reader = new FileReader(path);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		JSONParser jsonParser = new JSONParser();
		Object object = null;
		try {
			object = jsonParser.parse(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject jsonObject = (JSONObject) object;
		return jsonObject;
	}

	public static void ExcelReader(String Path) throws Throwable {
		FileInputStream fs = new FileInputStream(Path);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = (Cell) row.getCell(0);
	}

	public static Properties PropertiesFileReader(String Path) {
		String path = System.getProperty("user.dir") + Path;
		FileReader reader = null;
		try {
			reader = new FileReader(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public static String CsvFileReader(String Path) {
		String path = System.getProperty("user.dir") + Path;
		FileReader reader = null;
		String csvData = null;
		try {
			reader = new FileReader(path);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader bfReader = new BufferedReader(reader);
		String line;
		try {
			while ((line = bfReader.readLine()) != null) {
				String[] data = line.split(" ");
				for (String detail : data) {
					csvData += detail + "\t";
				}
				csvData += "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return csvData;
	}

}

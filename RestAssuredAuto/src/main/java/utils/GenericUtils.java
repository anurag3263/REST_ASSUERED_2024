package utils;

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

	public void ExcelReader(String Path) throws Throwable {
		FileInputStream fs = new FileInputStream(Path);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = (Cell) row.getCell(0);
	}

	public void PropertiesFileReader(String Path) throws IOException {
		FileReader reader = new FileReader(Path);
		Properties prop = new Properties();
		prop.load(reader);
		return;
	}

}

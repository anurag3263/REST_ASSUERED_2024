package crudOperaion;

import org.testng.annotations.Test;

import utils.GenericUtils;

public class CsvReader {

	String data = GenericUtils.CsvFileReader("//src/test/resources//TestData//CsvFileExample.csv");

	@Test
	public void readCsv() {
		//either use print() / println() both work fine here
		System.out.println(data);
	}
}

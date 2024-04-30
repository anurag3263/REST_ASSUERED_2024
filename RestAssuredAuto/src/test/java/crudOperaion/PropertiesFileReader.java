package crudOperaion;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import utils.GenericUtils;

public class PropertiesFileReader {

	Properties properties = GenericUtils.PropertiesFileReader("//src/test/resources//TestData//propExample.properties");

	@Test
	public void ReadpropertiesFile() throws IOException {

		System.out.println(properties.getProperty("db.name"));
		;

	}

}

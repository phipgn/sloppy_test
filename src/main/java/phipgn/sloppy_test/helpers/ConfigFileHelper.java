package phipgn.sloppy_test.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileHelper {
	private Properties properties;
	private final String propertyFilePath = "configs/testsettings.properties";
	
	public static final String KEY_URL = "url";
	public static final String KEY_BROWSER = "browser";

	public ConfigFileHelper() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("File not found at " + propertyFilePath);
		}
	}
	
	public String getProperty(String key) {
		String property = properties.getProperty(key);
		if (property == null)
			throw new RuntimeException("'" + key + "' not specified in the " + propertyFilePath + " file.");
		return property;
	}
}

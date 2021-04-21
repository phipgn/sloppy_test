package phipgn.sloppy_test.helpers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

public class FileHelper {
	public static String getTxtFileAsString(String filePath) {
        String txt = "";
		File file = new File(filePath);
		try {
			txt = FileUtils.readFileToString(file, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return txt;
    }
	
	@SuppressWarnings("rawtypes")
	private static Method findMethod(Class clazz, String testcaseId) {
		Method[] methods = clazz.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (testcaseId.equals(method.getName()))
				return method;
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public static Object[][] getDataProvider(String testcaseId, String testDataDir, Class clazz) {
		Method method = findMethod(clazz, testcaseId);
		Assert.assertTrue(method != null, "Could not find any methods mapped with '" + testcaseId + "'.");

		String jsonString = FileHelper.getTxtFileAsString(testDataDir + "/" + clazz.getSimpleName() + ".json");		
		JSONObject json = new JSONObject(jsonString);
		Object[][] data = null;
		
		JSONArray scenarios = null;
		try {
			scenarios = json.getJSONArray(testcaseId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(scenarios != null, "No test data mapped with '" + testcaseId + "'.");
		
		data = new Object[scenarios.length()][method.getParameterCount()];
		for (int i = 0; i < scenarios.length(); i++) {
			JSONObject scenario = (JSONObject)scenarios.get(i);
			
			data[i] = new Object[method.getParameterCount()];
			for (int j = 0; j < method.getParameterCount(); j++) {
				Parameter p = method.getParameters()[j];
				data[i][j] = scenario.getString(p.getName());
			}
		}	
		
		return data;
	}
}

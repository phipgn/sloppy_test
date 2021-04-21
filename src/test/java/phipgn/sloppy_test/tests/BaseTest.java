package phipgn.sloppy_test.tests;

import phipgn.sloppy_test.drivers.BrowserFactory;
import phipgn.sloppy_test.helpers.ConfigFileHelper;

public abstract class BaseTest {
	private ConfigFileHelper config;
	protected String testDataDir;
	protected BrowserFactory ui = null;
	
	protected BaseTest() {
		config = new ConfigFileHelper();
		testDataDir = config.getProperty(ConfigFileHelper.KEY_DATA);
	}
	
	protected void setUp() {
		ui = new BrowserFactory();
		ui.initBrowser(config.getProperty(ConfigFileHelper.KEY_BROWSER));
		ui.loadApplication(config.getProperty(ConfigFileHelper.KEY_URL));
	}
}

package com.auction.init;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.swing.text.Document;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.auction.admin.pages.AddUsers;
import com.auction.admin.pages.AdminAbstractPage;
import com.auction.admin.pages.AdminDashboardPage;
import com.auction.admin.pages.AdminUsers;
import com.auction.admin.pages.AuctionSettings;
import com.auction.admin.pages.LiveSaleAuction;
import com.auction.admin.pages.LotVerificationPage;
import com.auction.admin.pages.RunLiveAuction;
import com.auction.admin.pages.TimedSaleAuction;
import com.auction.pages.DashboardPage;
import com.auction.pages.LandingPage;
import com.auction.pages.LoginPage;
import com.auction.pages.SignupPage;
import com.auction.pages.auctionregistration.AbstractPage;
import com.auction.pages.index.IndexPage;
import com.auction.verifications.Brokenlinks;
import com.auction.verifications.Coupons;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import com.google.j2objc.annotations.Property;

import JSON.ReadDatafromJSONFile;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

/**
 * Selenium class Initialization
 * 
 */
// @Listeners({ atu.testng.reports.listeners.ATUReportsListener.class,
// ConfigurationListener.class, MethodListener.class })
public class SeleniumInit implements ILoggerStatus {
	/* Minimum requirement for test configuration */
	protected String testEnvironment;
	protected String testUrl; // Test url
	protected String admintestUrl; // Test Admin URL
	protected String hybridtestUrl; // Hybrid Test url
	protected String frontsignupUrl; // Front Signup URL
	protected String seleniumHub; // Selenium hub IP
	protected String seleniumHubPort; // Selenium hub port
	protected String targetBrowser; // Target browser
	protected static String test_data_folder_path = null;

	// screen-shot folder
	protected static String screenshot_folder_path = null;
	public static String currentTest; // current running test
	public static final String USERNAME = "haydensanders";
	public static final String AUTOMATE_KEY = "t4bhMUbEjUqLUQ6Ls6ys";
	public static String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	protected static Logger logger = Logger.getLogger("testing");
	protected static WebDriver driver;

	ConfigFileReader configFileReader = new ConfigFileReader();
	String uname = "bid";
	String password = "path";

//	public static ExtentReports extent = null;
	// public static ExtentTest test;

	private Common common = new Common(driver);

	{
		// System.setProperty("atu.reporter.config", "atu.properties");
	}

	/* Page's declaration */

	protected IndexPage indexPage;
	protected AbstractPage abstractPage;
	protected LoginPage loginPage;
	protected SignupPage signupPage;
	protected DashboardPage dashboardPage;
	protected LandingPage landingPage;
	protected AdminAbstractPage adminabstractPage;
	protected LiveSaleAuction livesale;
	protected TimedSaleAuction timesale;
	protected LotVerificationPage lotVerificationPage;
	protected RunLiveAuction runLiveAuctionPage;
	protected AdminUsers adminUsersPage;
	protected AddUsers addUsersPage;
	protected AuctionSettings auctionsettings;
	protected Brokenlinks brokenlink;
	protected Coupons coupon;
	protected AdminDashboardPage adminDashboardPage;
	protected ReadDatafromJSONFile readJson;

	private Object PropertyConfigurator;

	// And many more ...

	/**
	 * Fetches suite-configuration from XML suite file.
	 * 
	 * @param testContext
	 */
	@BeforeTest(alwaysRun = true)
	public void fetchSuiteConfiguration(ITestContext testContext) {

//		seleniumHub = testContext.getCurrentXmlTest().getParameter("selenium.host");
//		seleniumHubPort = testContext.getCurrentXmlTest().getParameter("selenium.port");
//		targetBrowser = testContext.getCurrentXmlTest().getParameter("selenium.browser");
//		testUrl = testContext.getCurrentXmlTest().getParameter("selenium.url");
//		admintestUrl = testContext.getCurrentXmlTest().getParameter("selenium.adminurl");

	}

	/**
	 * WebDriver initialization
	 * 
	 * @return WebDriver object
	 * @throws Exception
	 * @throws InterruptedException
	 */
	@SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun = true)
	// @Parameters("browser")
	public void setUp(Method method) throws Exception {

		seleniumHub = common.readJson("selenium.host");
		seleniumHubPort = common.readJson("selenium.port");
		targetBrowser = common.readJson("selenium.browser");
		
		// extent = new
		// ExtentReports("C:\\Users\\baps\\Desktop\\a3-6-auto\\qa3-6-auto\\STMExtentReport.html",
		// false);

		// extent.loadConfig(new
		// File("C:\\Users\\baps\\Desktop\\a3-6-auto\\qa3-6-auto\\extent-config.xml"));

		// test = extent.startTest((this.getClass().getSimpleName() + "::" +
		// method.getName()), method.getName());
		// test = extent.startTest("SWB Automation Report ", "SAM");
		// extent.addSystemInfo("Host Name", "PerfectQA Automation
		// Env").addSystemInfo("Environment", "Automation Testing")
		// .addSystemInfo("Environment URL", configFileReader.getFrontUrl())
		// .addSystemInfo("Browser", "Firefox (76.0.1)").addSystemInfo("User Name",
		// "Rahul Sharma");

//		String FILE = "D:/sampleiText.pdf";
//		Document document = new Document();
//		PdfWriter.getInstance(document, 
//			new FileOutputStream(FILE));
		currentTest = method.getName(); // get Name of current test.

		URL remote_grid = new URL("https://" + seleniumHub + ":" + seleniumHubPort + "/wd/hub");

		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";

		test_data_folder_path = new File(TESTDATA_FOLDER_NAME).getAbsolutePath();
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();

		DesiredCapabilities capability = null;
		// Check if parameter passed from TestNG is 'firefox'
		if (targetBrowser.equalsIgnoreCase("firefox")) {
			FirefoxProfile profile = new FirefoxProfile();
			// ATUReports.setWebDriver(driver);
			// ATUReports.indexPageDescription = "Test Project";
//			profile.setPreference("dom.max_chrome_script_run_time", "999");
//			profile.setPreference("dom.max_script_run_time", "999");
//			profile.setPreference("browser.download.folderList", 2);
//			profile.setPreference("browser.download.useDownloadDir", true);
//			profile.setPreference("browser.download.manager.showWhenStarting", false);
//			// profile.setEnableNativeEvents(true);
//			profile.setPreference("network.http.use-cache", false);
			// capability = DesiredCapabilities.firefox();
			// capability.setJavascriptEnabled(true);
			// capability.setCapability(FirefoxDriver.PROFILE, profile);
			driver = (FirefoxDriver) new RemoteWebDriver(remote_grid, capability);
		}

		else if (targetBrowser.equalsIgnoreCase("edge")) {

			// Setting system properties of EdgeDriver
			// System.setProperty("webdriver.edge.driver",
			// "C:\\Users\\user\\Desktop\\qa3-6-auto\\qa_dev_auto\\msedgeDriver.exe");

			// Creating an object of EdgeDriver
			// DesiredCapabilities capabilities = DesiredCapabilities.edge();
			EdgeOptions options = new EdgeOptions();

			// options.setCapability(capabilityName, value);("start-maximized");
//			capabilities.setJavascriptEnabled(true);
			// driver = new EdgeDriver(capabilities);
		}

		// Check if parameter passed as 'chrome private browser'
		else if (targetBrowser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe

			/**
			 * System Property For CircleCI
			 * 
			 */

//			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

			/**
			 * Enable when run on local Machine
			 * 
			 */
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/drivers/chromedriver2");
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

//			Properties prop = new Properties();
//			prop.load(new FileInputStream("C:\\Users\\hp\\Desktop\\Rahul_0507\\Rahul_0507_latest\\sam-qa\\src\\test\\java\\LogDemo\\Log4j.java"));
//			PropertyConfigurator.configure(prop);
//		

			// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			// DesiredCapabilities cap = DesiredCapabilities.chrome();
			LogManager.getLogger("Log4j");
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			options.setAcceptInsecureCerts(true);
			// options.addArguments("--incognito");
			// options.setAcceptInsecureCerts(true);

			options.merge(capabilities);

			driver = new ChromeDriver(options);
//					WebDriver driver;
//					WebDriverManager.chromedriver().setup();
			// ChromeOptions chromeOptions = new ChromeOptions();
			// chromeOptions.addArguments("--headless");
			// driver = new ChromeDriver(chromeOptions);

			// options.setHeadless(true);
			// options.addArguments("--headless");
			// WebDriver driver = new ChromeDriver(options);
//					//options.addArguments("start-maximized");
			// options.addArguments("headless");
			// options.addArguments(options);
			// driver = new ChromeDriver(options);

			// cap.setJavascriptEnabled(true);
			// driver = new ChromeDriver(options); // private browser

		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}

		driver.manage().window().maximize();
		System.out.println("Test started");
		indexPage = new IndexPage(driver);

	}

	private ChromeOptions Options() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testNewLogs() throws AWTException, IOException {

	}

	/**
	 * After Method {TearDown}
	 * 
	 * @param testResult
	 * @throws AWTException
	 * @throws IOException
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) throws IOException, AWTException {
		Reporter.setCurrentTestResult(testResult);
		try {
			String testName = testResult.getName();
			Reporter.setCurrentTestResult(testResult);
	        File img = new File("target" + File.separator + "failsafe-reports" + File.separator + testName + ".png");

			if (testResult.isSuccess()) {
				// test.log(LogStatus.PASS, "PASS : " + testResult.getName() + "\n");
				System.out.println("PASS : " + testResult.getName() + "\n");
				common.log("<br></br> <font color=#0B610B> PASS : " + testResult.getName() + "</font> <br></br>");
				// test.log(LogStatus.PASS, "PASS : " +
				// testResult.getThrowable());
				driver.manage().deleteAllCookies();
				driver.quit();

			} else if (!testResult.isSuccess()) {
				// test.log(LogStatus.FAIL, "FAIL : " + testResult.getName() + "\n");
				System.out.println("FAIL : " + testResult.getName() + "\n");
				common.log("FAIL : " + testResult.getName() + "\n");
				common.makeScreenshot(driver, testName);
				common.makeScreenshotForReport(driver, testName);
				
				FileOutputStream screenshotStream = new FileOutputStream(img);
			    screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			    Reporter.log("<a target='blank' href='" + testName +".png'> <img  src='"+ testName +".png' height='250' width='500'></img> </a>");

				
				// test.log(LogStatus.FAIL, "FAIL : " +
				// testResult.getThrowable());
				driver.manage().deleteAllCookies();
				driver.quit();
				// System.exit(1);
			}

			else {

				System.out.println("TEST SKIPPED - " + testName + "\n");
				driver.manage().deleteAllCookies();

				driver.quit();
				// System.exit(2);
			}

			// driver.close();

		} catch (Throwable throwable) {
			// TODO: handle exception
		}

		// driver.close();
		// extent.endTest(test);
		// extent.flush();
		// extent.close();
	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg Message/Log to be reported.
	 */
	public static void logMessage(String msg) {
		Reporter.log("<br>" + msg + "</br>");
	}

	/**
	 * Log
	 * 
	 * @param msg
	 * @param logger_status
	 */
	public static void log(String msg, final int logger_status) {

		switch (logger_status) {

		case ILoggerStatus.NORMAL:
			Reporter.log("<br>" + msg + "</br>");
			break;

		case ILoggerStatus.ITALIC:
			log("<i>" + msg + "</i>");
			break;

		case ILoggerStatus.STRONG:
			Reporter.log("<strong>" + msg + "</br>");
			break;
		}
	}

	public void waitUntillElementPresent(String str) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
	}

	/**
	 * Log Status
	 * 
	 * @param test_status
	 */
	public static void logStatus(final int test_status) {

		switch (test_status) {

		case ITestStatus.PASSED:
			log("<font color=238E23>--Passed</font>");
			break;

		case ITestStatus.FAILED:
			log("<font color=#FF0000>--Failed</font>");
			break;

		case ITestStatus.SKIPPED:
			log("<font color=#FFFF00>--Skipped</font>");
			break;

		default:
			break;
		}

	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg Message/Log to be reported.
	 */
	protected static void log(String msg) {
		//Reporter.log(msg);
	}

	/**
	 * Csv Logic with Two Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parseCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "login.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][2];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with Eight Tokens
	 * 
	 * For Signup Feature
	 * 
	 * @return
	 */
	public Object[][] parseSignUpCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "signup.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][8];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with Two Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parseRegularSignupCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "regularsignuplogin.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][2];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with Three Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parsemissedliveauctionCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "missedliveaution.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][3];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with four Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parsecreateauctionCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "createauction.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][4];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with four Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parseTwoLoginUsersCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "twouserlogin.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][6];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with Two Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parseliveauctionCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "liveauction.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][5];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Csv Logic with Four Tokens
	 * 
	 * For Login Feature
	 * 
	 * @return
	 */
	public Object[][] parseAdminUserCsv() {

		String[][] csvParsingData = null;

		try {

			String strFile = "test_data" + File.separator + "adminusers.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int lineNumber = 0, tokenNumber = 0;

			int numberOfLines = 0;
			while ((strLine = br.readLine()) != null)
				lineNumber++;

			numberOfLines = lineNumber;
			System.out.println("numberOfLines: " + numberOfLines);
			csvParsingData = new String[lineNumber][5];

			br.close();
			br = new BufferedReader(new FileReader(strFile));
			lineNumber = 0;

			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				st = new StringTokenizer(strLine, "|");

				while (st.hasMoreTokens()) {

					tokenNumber++;
					String token = st.nextToken();
					System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : " + token);
					csvParsingData[lineNumber - 1][tokenNumber - 1] = token;
				}

				// reset token number
				tokenNumber = 0;

			}

		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		return csvParsingData;

	}

	/**
	 * Generate Random Chars
	 * 
	 * @param length
	 * @return
	 */
	public static String generateRandomChars(int length) {
		String total = "qwertyuioplkjhgfdsazxcvbnm";
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			char _char = total.charAt((int) (Math.random() * 100) % total.length());
			buf.append(_char);
		}
		return buf.toString();
	}

	public void setCommon(Common common) {
		this.common = common;
	}
}

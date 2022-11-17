package Config;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;
import java.io.*;
import java.util.Properties;
import java.util.Random;

public class Common{

    public MobileDriver driver;

    public MobileElement findElement(String elementName) {

        String locator;

        locator = elementName;

        int count = 0;
        while (count < 4) {
            try {
                if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
                    locator = locator.substring(5); // remove "link=" from
                    // locator
                    try {
                        if (locator.contains(" "))
                            return (MobileElement) driver.findElement(By.partialLinkText(locator));

                        return (MobileElement) driver.findElement(By.linkText(locator));
                    } catch (Exception e) {
                        return null;
                    }
                }
                if (locator.startsWith("id=")) {
                    locator = locator.substring(3); // remove "id=" from locator
                    try {
                        return (MobileElement) driver.findElement(By.id(locator));
                    } catch (Exception e) {
                        return null;
                    }
                } else if (locator.startsWith("//")) {
                    try {
                        return (MobileElement) driver.findElement(By.xpath(locator));
                    } catch (Exception e) {
                        return null;
                    }
                }
                 else if (locator.startsWith("name=")) {

                    locator = locator.substring(5); // remove "name=" from
                    // locator
                    try {
                        return (MobileElement) driver.findElement(By.name(locator));
                    } catch (Exception e) {
                        return null;
                    }
                } else {
                    try {
                        return (MobileElement) driver.findElement(By.id(locator));
                    } catch (Exception e) {
                        return null;
                    }

                }
            } catch (StaleElementReferenceException e) {
                e.toString();

                count = count + 1;
                // System.out.println("Trying["+
                // count+"] to recover from a stale element :" +
                // e.getMessage());
            }
            count = count + 4;
        }
        return null;

    }

    public void pause(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void log(String log) {
        System.out.println(log);
        Reporter.log(log + "<br>");
    }

    public void logStepResult(String result) {
        System.out.println("Result : " + result);
        if (result.equals("passed")) {
            Reporter.log("<h4 style=\"color:green;\">Passed</h4>");

        } else if (result.equals("failed"))
            Reporter.log("<h4 style=\"color:red;\">Failed</h4>");
        {

        }
    }

    public boolean isElementDisplayed(String elementLocator) {
        try {
            return driver.findElement(By.xpath(elementLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForElementIsNotDisplayed(String by) throws InterruptedException {

        for (int second = 0;; second++) {
            if (second >= 60) {

                break;
            }
            try {
                if (!isElementDisplayed(by))
                    break;
            } catch (Exception e) {
            }
            pause(1000);
        }
        return false;
    }

    public boolean isElementPresent(String locator) {

        WebElement webElement = this.findElement(locator);
        if (webElement != null) {
            return true;
        } else {

            return false;
        }
    }

    public static String generateRandomChars(int length) {
        String total = "iokijfmnbxcvfrpqsdfgvcxzdferiuytjndifur";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char _char = total.charAt((int) (Math.random() * 100) % total.length());
            buf.append(_char);
        }
        return buf.toString();
    }

    public static int GenerateRandomNumber(int length) {
        Random rand = new Random();
        int num = rand.nextInt(length);
        int numNoRange = rand.nextInt();
        return numNoRange;
    }

    public Properties readConfigFile(String configFile) {
        Properties prop = null;
        try (InputStream input = new FileInputStream(new File("src/test/resources/" + configFile + ".properties").getAbsolutePath())) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public void makeScreenshot(MobileDriver driver, String screenshotName) {
        MobileDriver augmentedDriver = (MobileDriver) new Augmenter().augment(driver);
        /* Take a screenshot */
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtention = screenshotName + ".png";
        /* Copy screenshot to specific folder */
        try {
            String reportFolder = "target" + File.separator + "surefire-reports" + File.separator+ "html" + File.separator;
            File screenshotFolder = new File(reportFolder);
            if (!screenshotFolder.getAbsoluteFile().exists()) {
                screenshotFolder.mkdir();
            }
            FileUtils.copyFile(screenshot,
                    new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
            Reporter.log("<a href='" + nameWithExtention +"'> <img src='"+ nameWithExtention +"' height='500' width='250'></img> </a>"+ "<br>"+ "<br>");
        } catch (IOException e) {
            this.log("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public String readJson(String key) throws IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/test/resources/Static_Parameters.json");
        Object obj = jsonParser.parse(reader);
        JSONArray usersList = (JSONArray) obj;
        JSONObject parameters = (JSONObject) usersList.get(0);
        String Value = (String)parameters.get(key);
        return Value;
    }
}
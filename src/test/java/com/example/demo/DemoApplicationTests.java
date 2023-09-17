package com.example.demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {

	RemoteWebDriver driver = null;
	String status = "failed";

	@Test
	void contextLoads() {
		String username = "jyoti.yadaveduthrill";
		String accessKey = "h8eWMTK75thwffFhMyCvw7Ogd2Ma4xRQKvpKwsQUhdX8Hl78I0";
		// Set the browser and OS configurations
		String browser = "chrome";
		String version = "latest";
		String os = "Windows";
		// Set the URL of the LambdaTest hub
		String hubURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
		// Set the URL of the website you want to test
		String websiteURL = "https://dev-pwa.eduthrill.com/login";
		// Configure Chrome options
		ChromeOptions options = new ChromeOptions();
		//chromeOptions.setCapability("platform", os);
		//chromeOptions.setCapability("browserName", browser);
		//chromeOptions.setCapability("version", version);
		// Configure Chrome options
		options.setPlatformName("Windows 10");
		options.setBrowserVersion("114.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "jyoti.yadaveduthrill");
		ltOptions.put("accessKey", "h8eWMTK75thwffFhMyCvw7Ogd2Ma4xRQKvpKwsQUhdX8Hl78I0");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("project", "Webapp Login");
		ltOptions.put("networkThrottling", "Regular 4G");
		ltOptions.put("selenium_version", "4.4.0");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");
		options.setCapability("LT:Options", ltOptions);
		//ChromeDriver driver = new ChromeDriver(options);

		// Create a WebDriver instance

		try {
			driver = new RemoteWebDriver(new URL(hubURL), options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Navigate to the website
			driver.get(websiteURL);
			// Perform login
			driver.findElement(By.id("username")).sendKeys("jyoti.yadav@mailinator.com");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.id("login_button")).click();
			System.out.println(driver.getCurrentUrl());
			if(driver.getCurrentUrl().equalsIgnoreCase("https://dev-pwa.eduthrill.com/app/programs")) {
				status = "passed";
			}
//	            Assert.assertEquals("Get Taste of Lambda and Stick to It", "string");
			//WebElement usernameField = driver.findElement(By.id("username"));
			//WebElement passwordField = driver.findElement(By.id("password"));
			//WebElement loginButton = driver.findElement(By.id("login-button"));
			//usernameField.sendKeys("jyoti.yadav@mailinator.com");
			//passwordField.sendKeys("password");
			//loginButton.click();
			// Take a screenshot after successful login
			if (driver instanceof ChromeDriver) {
				ChromeDriver chromeDriver = (ChromeDriver) driver;
				chromeDriver.getScreenshotAs(OutputType.FILE);
				// Save the screenshot to a desired location
				//Files.copy(screenshotFile, new File("screenshot.png"));
				//Files.copy(screenshotFile, new File("screenshot.png"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//	        finally {
//	            if (driver != null) {
//	                driver.quit();
//	            }
//	        }String username = "jyoti.yadaveduthrill";
//        String accessKey = "h8eWMTK75thwffFhMyCvw7Ogd2Ma4xRQKvpKwsQUhdX8Hl78I0";
//        // Set the browser and OS configurations
//        String browser = "chrome";
//        String version = "latest";
//        String os = "Windows";
//        // Set the URL of the LambdaTest hub
//        String hubURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
//        // Set the URL of the website you want to test
//        String websiteURL = "https://dev-pwa.eduthrill.com/login";
//        // Configure Chrome options
//        ChromeOptions options = new ChromeOptions();
//        //chromeOptions.setCapability("platform", os);
//        //chromeOptions.setCapability("browserName", browser);
//        //chromeOptions.setCapability("version", version);
//        // Configure Chrome options
//        options.setPlatformName("Windows 10");
//        options.setBrowserVersion("114.0");
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("username", "jyoti.yadaveduthrill");
//        ltOptions.put("accessKey", "h8eWMTK75thwffFhMyCvw7Ogd2Ma4xRQKvpKwsQUhdX8Hl78I0");
//        ltOptions.put("visual", true);
//        ltOptions.put("video", true);
//        ltOptions.put("project", "Webapp Login");
//        ltOptions.put("networkThrottling", "Regular 4G");
//        ltOptions.put("selenium_version", "4.4.0");
//        ltOptions.put("w3c", true);
//        ltOptions.put("plugin", "java-testNG");
//        options.setCapability("LT:Options", ltOptions);
//        //ChromeDriver driver = new ChromeDriver(options);
//
//        // Create a WebDriver instance
//
//        try {
//            driver = new RemoteWebDriver(new URL(hubURL), options);
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            // Navigate to the website
//            driver.get(websiteURL);
//            // Perform login
//            driver.findElement(By.id("username")).sendKeys("jyoti.yadav@mailinator.com");
//            driver.findElement(By.id("password")).sendKeys("password");
//            driver.findElement(By.id("login_button")).click();
//            System.out.println(driver.getCurrentUrl());
//            if(driver.getCurrentUrl().equalsIgnoreCase("https://dev-pwa.eduthrill.com/app/programs")) {
//                status = "passed";
//            }
////	            Assert.assertEquals("Get Taste of Lambda and Stick to It", "string");
//            //WebElement usernameField = driver.findElement(By.id("username"));
//            //WebElement passwordField = driver.findElement(By.id("password"));
//            //WebElement loginButton = driver.findElement(By.id("login-button"));
//            //usernameField.sendKeys("jyoti.yadav@mailinator.com");
//            //passwordField.sendKeys("password");
//            //loginButton.click();
//            // Take a screenshot after successful login
//            if (driver instanceof ChromeDriver) {
//                ChromeDriver chromeDriver = (ChromeDriver) driver;
//                chromeDriver.getScreenshotAs(OutputType.FILE);
//                // Save the screenshot to a desired location
//                //Files.copy(screenshotFile, new File("screenshot.png"));
//                //Files.copy(screenshotFile, new File("screenshot.png"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////	        finally {
////	            if (driver != null) {
////	                driver.quit();
////	            }
////	        }

		driver.executeScript("lambda-status=" + status);
		driver.quit();

	}

}

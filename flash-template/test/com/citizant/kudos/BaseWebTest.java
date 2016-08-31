package com.citizant.kudos;

import java.io.IOException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Ignore;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


@Ignore
public class BaseWebTest {

	protected static final String seleniumHub = "http://ec2-54-174-151-21.compute-1.amazonaws.com:4444/wd/hub";

	protected static final String baseURL = "http://54.196.239.109:8090/kudos/";

	protected static WebDriver driver;

	public static void setUpRemoteWebDriver() throws IOException
	{
	    Capabilities cap = DesiredCapabilities.firefox();
	    driver = new RemoteWebDriver(new URL(seleniumHub),cap);
	}

    public static void tearDownDriverIfNeeded() {
        if (driver != null)
            driver.quit();
    }

    public void assertTitleEquals(String expectedTitle) {
	    Assert.assertEquals(expectedTitle ,driver.getTitle());
    }

    public void fillOutForm(String[] ps, String submitId) {
        int len = ps.length;
        for (int i=0; i < len; i += 2)
            driver.findElement(By.id(ps[i])).sendKeys(ps[i+1]);
	    driver.findElement(By.id(submitId)).click();
    }

    public int indexInPage(String s) {
        return driver.getPageSource().indexOf(s);
    }

    public boolean occursInPage(String s) {
        return indexInPage(s) != -1;
    }

}

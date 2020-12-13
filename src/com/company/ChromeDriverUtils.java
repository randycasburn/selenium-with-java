package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@SuppressWarnings("unused")
public class ChromeDriverUtils {
    private boolean session;
    public WebDriver driver;

    public void openPage(String url) {
        this.openPage(url, false);
    }

    public void openPage(String url, Boolean headless) {
        if (!this.session) {
            this.startWebDriver(url, headless);
            this.session = true;
        } else {
            this.driver.get(url);
        }
    }

    public void closePage() {
        this.quitWebDriver();
        this.session = false;
    }

    private void startWebDriver(String url, Boolean headless) {
        this.buildDriver(headless);
        System.out.println("WebDriver started!\n######################################");
        try {
            this.driver.get(url);
        } catch (Exception ex) {
            this.quitWebDriver();
            throw ex;
        }
    }

    private void quitWebDriver() {
        this.driver.quit();
        System.out.println("######################################\nWebDriver shutdown!\n");
    }

    private void buildDriver(Boolean headless) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        if (headless) {
            options.addArguments("headless");
        }
        try {
            this.driver = new ChromeDriver(options);
        } catch (org.openqa.selenium.WebDriverException ex) {
            if (ex.getMessage().contains("unknown error: cannot find Chrome binary")) {
                options.setBinary("/Applications/WebDevelopmentTools/Google Chrome.app/Contents/MacOS/Google Chrome");
                this.driver = new ChromeDriver(options);
            } else {
                throw ex;
            }
        }
    }
}

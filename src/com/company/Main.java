package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        PageObject page = new PageObject();
        page.openPage("https://oliveai.com", true);
        String url = page.driver.getCurrentUrl();
        System.out.println("Current URL: " + url);
        String title = page.driver.getTitle();
        System.out.println("Title: " + title);
        System.out.println("################");

        System.out.println(page.getOrgAddress());
        System.out.println("################");
        page.getLinks().stream().forEach(entry->{
            System.out.println(entry);
        });
        page.closePage();
    }

}

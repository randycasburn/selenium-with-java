package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageObject extends ChromeDriverUtils {

    public String getOrgAddress() {
        return this.driver.findElement(By.xpath("//address")).getText();
    }

    public List<HashMap<String,String>> getLinks() {
        List<HashMap<String,String>> menuItems = new ArrayList<>();
        try {
            List<WebElement> aboutMenuListItems = this.driver.findElements(By.xpath("//ul[@id=\"menu-about\"]//li"));
            List<WebElement> resourceMenuListItems = this.driver.findElements(By.xpath("//ul[@id=\"menu-resources\"]//li"));
            for(int i = 1; i <= aboutMenuListItems.size(); i++) {
                HashMap<String,String> temp = new HashMap<>();
                WebElement anchor = this.driver.findElement(By.xpath("//ul[@id=\"menu-about\"]//li["+ i +"]//span[1]//a[1]"));
                String anchorText = anchor.getText();
                String anchorLink = anchor.getAttribute("href");

                temp.put("text", anchorText);
                temp.put("link", anchorLink);
                menuItems.add(temp);
            }
            for(int i = 1; i <= resourceMenuListItems.size(); i++) {
                HashMap<String,String> temp = new HashMap<>();
                WebElement anchor = this.driver.findElement(By.xpath("//ul[@id=\"menu-resources\"]//li["+ i +"]//span[1]//a[1]"));
                String anchorText = anchor.getText();
                String anchorLink = anchor.getAttribute("href");
                temp.put("text", anchorText);
                temp.put("link", anchorLink);
                menuItems.add(temp);
            }
        } catch (Exception ex) {
            this.closePage();
            throw ex;
        }
        return menuItems;
    }

}

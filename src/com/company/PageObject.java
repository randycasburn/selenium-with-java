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
        List<HashMap<String,String>> menuItems;
        try {
            menuItems = findAndCreateHashMap("menu-about");
            menuItems.addAll(findAndCreateHashMap("menu-resources"));
        } catch (Exception ex) {
            this.closePage();
            throw ex;
        }
        return menuItems;
    }

    private List<HashMap<String,String>> findAndCreateHashMap(String menuName){
        List<HashMap<String,String>> menuItems = new ArrayList<>();
        List<WebElement> menuItemsList = this.driver.findElements(By.xpath("//ul[@id=\""+menuName+"\"]//li"));
        HashMap<String,String> details = new HashMap<>();
        for(int i = 1; i <= menuItemsList.size(); i++) {
            WebElement anchor = this.driver.findElement(By.xpath("//ul[@id=\""+menuName+"\"]//li["+ i +"]//span[1]//a[1]"));
            String anchorText = anchor.getText();
            String anchorLink = anchor.getAttribute("href");
            details.put("text", anchorText);
            details.put("link", anchorLink);
            menuItems.add(details);
        }
        return menuItems;
    }

}

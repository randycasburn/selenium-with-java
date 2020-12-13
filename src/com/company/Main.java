package com.company;

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
        page.getLinks().forEach(System.out::println);
        page.closePage();
    }

}

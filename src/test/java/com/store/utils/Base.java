package com.store.utils;


import org.openqa.selenium.*;

import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;



import java.util.List;

public class Base {

    protected static WebDriver driver;


    public static String url = "https://juice-shop.herokuapp.com/#/";

    private int timeOutSec = 10;

    public void click(WebElement element)
    {

        element.click();


    }

    public void type(WebElement element, String text)
    {
        element.sendKeys(text);
    }

    public List<WebElement> list(WebElement element, String tagName)
    {
        return element.findElements(By.tagName(tagName));
    }
    public void clickListElement(WebElement element, String tagName, int index)
    {
        webElementClick(list(element, tagName).get(index));
    }
    public void typeListElement(WebElement element, String tagName, int index, String message)
    {
        webElementType(list(element, tagName).get(index),message);
    }
    public void selectListElement(WebElement element, String tagName, int index, String message)
    {
        selectDropDown(list(element, tagName).get(index),message);
    }
    public void webElementClick(WebElement element)
    {
        element.click();
    }
    public void webElementType(WebElement element, String message)
    {
        element.sendKeys(message);
    }
    public void selectDropDown(WebElement element, String message)
    {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(message);
    }

    public void SelectdropdownByValue(WebElement element, String Value)
    {
        Select dropdown = new Select(element);
        dropdown.selectByValue(Value);
    }

    public void visit(String url)
    {
        driver.get(url);
    }
    public void clickBelow(By element, By ref)
    {
        driver.findElement(RelativeLocator.with(element).below(ref));
    }

    public void submit(WebElement element){element.submit();}



}

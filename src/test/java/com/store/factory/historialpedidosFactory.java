package com.store.factory;

import com.store.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class historialpedidosFactory extends Base {

    public historialpedidosFactory(WebDriver driver){
        PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//button[@aria-label='Go to order history page']")
    WebElement orderHistoryPage;

    @FindBy(id = "navbarAccount")
    protected WebElement Cuenta;

    @FindBy(xpath = "//button[@aria-label='Show Orders and Payment Menu' and @role='menuitem']")
    WebElement botonOrder;



    public void Historialpedidos() throws InterruptedException {

        click(Cuenta);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(botonOrder).perform();
        Thread.sleep(1000);
        click(orderHistoryPage);




    }
    public void HistoryAssertion()
    {
        WebElement result = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='mat-card-cvr'] mat-card-title")));

        Assert.assertEquals(result.getText(), "Order History", "Order History was not Loaded");
    }



}

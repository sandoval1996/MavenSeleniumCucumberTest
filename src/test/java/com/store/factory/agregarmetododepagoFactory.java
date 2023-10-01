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

public class agregarmetododepagoFactory extends Base {


    public agregarmetododepagoFactory(WebDriver driver){
        PageFactory.initElements(driver, this);}



    @FindBy(id = "navbarAccount")
    protected WebElement Cuenta;

    @FindBy(xpath = "//button[@aria-label='Show Orders and Payment Menu' and @role='menuitem']")
    WebElement botonOrder;


    @FindBy(xpath = "//button[@aria-label='Go to saved payment methods page']")
    WebElement botonmetodopago;


    @FindBy(xpath = "//mat-expansion-panel-header[@id='mat-expansion-panel-header-0']")
    WebElement botonagregartarjeta;


    @FindBy(xpath = "//input[@type='text' and @aria-required='true']")
    WebElement nombretarjeta;

    @FindBy(xpath = "//input[@type='number' and @aria-required='true']")
    WebElement numerotarjeta;

    @FindBy(css = "div[class^='mat-expansion-panel-body']")
    WebElement div;

    String selectTagName = "select";





    @FindBy(xpath = "//button[@id='submitButton']")
    WebElement buttonsubmit;








    public void OpcionAgregarpago() throws InterruptedException {

        click(Cuenta);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(botonOrder).perform();
        Thread.sleep(1000);
        click(botonmetodopago);
        click(botonagregartarjeta);

    }




    public void IngresarInformacionDePago(String Nombretarjeta, String Numerotarjeta, String mestarjeta, String anotarjeta)
    {
        type(nombretarjeta,Nombretarjeta);
        type(numerotarjeta,Numerotarjeta);
        selectListElement(div, selectTagName,0,mestarjeta);
        selectListElement(div, selectTagName,1,anotarjeta);
        click(buttonsubmit);


    }

    public void paymentAssertion()
    {
        WebElement result = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("mat-cell[style^='flex: 1 1 100%; box-sizing: " +
                        "border-box; max-width: 30%;']")));

        Assert.assertNotEquals(result.getText(), "Card", "Payment Option was not completed");
    }

















}

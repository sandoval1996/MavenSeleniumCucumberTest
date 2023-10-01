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

public class agregardireccionFactory extends Base {

    public agregardireccionFactory(WebDriver driver){
        PageFactory.initElements(driver, this);}

    @FindBy(css = "button[color='primary']")
    WebElement btn;
    @FindBy(css = "input[data-placeholder='Please provide a country.']")
    WebElement pais;
    @FindBy(css = "input[data-placeholder='Please provide a name.']")
    WebElement nombre;
    @FindBy(css = "input[data-placeholder='Please provide a mobile number.']")
    WebElement celular;
    @FindBy(css = "input[data-placeholder='Please provide a ZIP code.']")
    WebElement zip;
    @FindBy(css = "textarea[data-placeholder='Please provide an address.']")
    WebElement direccion;
    @FindBy(css = "input[data-placeholder='Please provide a city.']")
    WebElement ciudad;
    @FindBy(css = "input[data-placeholder='Please provide a state.']")
    WebElement estado;
    @FindBy(id = "submitButton")
    WebElement submit;

    @FindBy(xpath = "//button[@aria-label='Show Orders and Payment Menu' and @role='menuitem']")
    WebElement botonOrder;


    @FindBy(xpath = "//button[@aria-label='Go to saved address page']")
    WebElement botonguardardireccion;

    @FindBy(xpath = "//button[@aria-label='Add a new address']")
    WebElement botonagregardirecciondireccion;

    @FindBy(id = "navbarAccount")
    protected WebElement Cuenta;


    public void OpcionAgregarDireccion() throws InterruptedException {

        click(Cuenta);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(botonOrder).perform();
        Thread.sleep(1000);
        click(botonguardardireccion);
        click(botonagregardirecciondireccion);

    }



    public void IngresarDireccion(String Country, String Name, String Mobile, String Zip, String Address, String City, String State) throws InterruptedException
    {


        type(pais, Country);
        type(nombre, Name);
        type(celular, Mobile);
        type(zip, Zip);
        type(direccion, Address);
        type(ciudad, City);
        type(estado, State);
        Thread.sleep(7000);
        click(submit);
    }

    public void AddressAssertion() throws InterruptedException
    {
        Thread.sleep(500);
        WebElement result = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("mat-card > h1")));

        Assert.assertEquals(result.getText(), "My saved addresses");
    }



}

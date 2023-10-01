package com.store.factory;

import com.store.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class agregarproductosFactory extends Base {

    public agregarproductosFactory(WebDriver driver){
        PageFactory.initElements(driver, this);}


    @FindBy(xpath = "//input[@id='mat-input-0' and @type='text']")
    WebElement buscador;

    @FindBy(xpath = "//button[@aria-label='Add to Basket' and @color='primary']")
    WebElement agregarproducto;


    @FindBy(xpath = "//button[@aria-label='Show the shopping cart']")
    WebElement cesta;

    @FindBy(xpath = "//button[@id='checkoutButton']")
    WebElement checkout;


    @FindBy(xpath = "//mat-cell[contains(text(),'Test2 ')]")
    WebElement direccion;


    @FindBy(xpath = "//button[@aria-label='Proceed to payment selection']")
    WebElement continuadireccion;


    @FindBy(xpath = "//mat-cell[@role='cell' and @class='mat-cell cdk-cell cdk-column-Name mat-column-Name ng-star-inserted']")
    WebElement radioenvio;


    @FindBy(xpath = "//button[@aria-label='Proceed to delivery method selection']")
    WebElement continuarenvio;

    @FindBy(xpath = "//span[@class='mat-radio-outer-circle']")
    WebElement radiobotonpago;

    @FindBy(xpath = "//button[@aria-label='Proceed to review']")
    WebElement continuarbotonpago;


    @FindBy(xpath = "//button[@aria-label='Complete your purchase']")
    WebElement completarpago;

    @FindBy(xpath = "//*[@id='searchQuery']/span/mat-icon[2]")
    WebElement lupa;


    public void Buscarproducto(String itemName) throws InterruptedException
    {
        Thread.sleep(500);
        click(lupa);
        type(buscador, itemName);
        buscador.sendKeys(Keys.ENTER);
        click(agregarproducto);
        Thread.sleep(2000);
    }
    public void Buscarproductos(String itemName) throws InterruptedException
    {
        Thread.sleep(500);
        buscador.clear();
        Thread.sleep(200);
        click(lupa);
        type(buscador, itemName);
        buscador.sendKeys(Keys.ENTER);
        click(agregarproducto);
        Thread.sleep(2000);
    }

   public void GestionarCompra() throws InterruptedException {
       click(cesta);
       click(checkout);
       click(direccion);
       click(continuadireccion);
       click(radioenvio);
       click(continuarenvio);
       Thread.sleep(200);
       click(radiobotonpago);
       click(continuarbotonpago);
       click(completarpago);

   }


   public void AgregarproductoAleatorio() throws InterruptedException {

       List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Add to Basket')]"));

       // Selecciona el elemento deseado por índice (por ejemplo, el tercer elemento)
       int indexToSelect = 2;
       int indexToSelect1 = 1;// El índice comienza en 0
       WebElement selectedElement = elements.get(indexToSelect);
       WebElement selectedElement2 = elements.get(indexToSelect1);

       // Realiza acciones en el elemento seleccionado, por ejemplo, hacer clic en él
       selectedElement.click();
       Thread.sleep(600);
       selectedElement2.click();



   }




    public void OrderAssertion()
    {
        WebElement result = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1[class='confirmation']")));

        Assert.assertEquals(result.getText(), "Thank you for your purchase!", "Order was not palced");
    }





}

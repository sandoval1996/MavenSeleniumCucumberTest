package com.store.factory;

import com.store.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class iniciarsesionFactory extends Base {

    public iniciarsesionFactory(WebDriver driver){
        PageFactory.initElements(driver, this);}
    @FindBy(id = "email")
    WebElement email;
    @FindBy (id ="password")
    WebElement pass;
    @FindBy (id ="loginButton")
    WebElement btn;
    @FindBy(css = "div[class='error ng-star-inserted']")
    WebElement errorMng;

    @FindBy(id = "navbarAccount")
    protected WebElement Cuenta;

    @FindBy(id = "navbarLoginButton")
    protected WebElement LoginButton;


    public void AccederLogin()
    {
        click(Cuenta);
        click(LoginButton);
    }


    public void Login(String Email, String password)
    {

        type(email, Email);
        type(pass, password);
        click(btn);
    }

    public void ValidarInicioSesionExitoso()
    {
        WebElement result = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        cssSelector("button[routerlink='/basket'] > span[class='mat-button-wrapper'] > span[fxshow]")));

        Assert.assertEquals(result.getText(), "Your Basket", "Login was not completed");
    }

    public void ValidarInicioSesionFallido()
    {
        WebElement result = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(errorMng));

        Assert.assertEquals(result.getText(), "Invalid email or password.", "Error with invalid credentials");
    }



}

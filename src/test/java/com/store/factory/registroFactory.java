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

public class registroFactory extends Base {


    public registroFactory(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "navbarAccount")
    protected WebElement Cuenta;

    @FindBy(id = "navbarLoginButton")
    protected WebElement LoginButton;

    @FindBy(xpath = "//a[@href='#/register']")
    protected WebElement registrar;

    @FindBy(id = "emailControl")
    protected WebElement Email;

    @FindBy(id = "passwordControl")
    protected WebElement Contrasena;

    @FindBy(id = "repeatPasswordControl")
    protected WebElement repetirContrasena;

    @FindBy(xpath = "//mat-select[@role='combobox']")
    protected WebElement preguntaSeguridad;

    @FindBy (css = "mat-option[id='mat-option-7'] > span")
    protected WebElement dropd;


    @FindBy(id = "securityAnswerControl")
    protected WebElement repuesta;


    @FindBy(id = "registerButton")
    protected WebElement botonregistro;


    @FindBy(xpath = "//span[contains(text(),'Dismiss')]")
    protected WebElement Alerta;



    public void Alerta()throws InterruptedException
    {
        click(Alerta);
    }



    public void realizarRegistro()throws InterruptedException
    {

    click(Cuenta);
    click(LoginButton);
    click(registrar);


    }


    public void IngresarInformacionUsuario(String email, String contraseñas, String repetircontra, String respues)throws InterruptedException
    {

        type(Email, email);
        type(Contrasena, contraseñas);
        type(repetirContrasena, repetircontra);
        click(preguntaSeguridad);
        click(dropd);
        type(repuesta,respues);
        Thread.sleep(7000);
        click(botonregistro);
        Thread.sleep(2000);




    }

    public void RegisterAssertion()
    {
        WebElement result = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));

        Assert.assertEquals(result.getText(), "Login", "Registration was not completed");
    }





}

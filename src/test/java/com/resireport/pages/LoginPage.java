package com.resireport.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Localizadores
    private By txtEmail =
            By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/input");

    private By txtPassword =
            By.xpath("//*[@id=\"root\"]/div/div/form/div[2]/input");

    private By btnIniciarSesion =
            By.xpath("//*[@id=\"root\"]/div/div/form/button");

    private By mensajeError =
            By.xpath("//*[@id=\"root\"]/div/div/form/p");

    // Métodos
    public void ingresarCorreo(String correo) {
        driver.findElement(txtEmail).sendKeys(correo);
    }

    public void ingresarPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clicIniciarSesion() {
        driver.findElement(btnIniciarSesion).click();
    }

    public String obtenerMensajeError() {

        return driver.findElement(mensajeError).getText();
    }

    public boolean mensajeErrorVisible() {

        return driver.findElement(mensajeError).isDisplayed();
    }
}
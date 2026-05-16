package com.resireport.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DenunciaPage {

    private WebDriver driver;

    public DenunciaPage(WebDriver driver) {

        this.driver = driver;
    }

    // Botón crear denuncia
    private By btnCrearDenuncia =
            By.xpath("//*[@id=\"root\"]/div/main/div/div[1]/div/button");

    // Modal
    private By modalDenuncia =
            By.xpath("//*[@id=\"radix-_r_0_\"]");

    // Campos
    private By txtTitulo =
            By.xpath("//*[@id=\"radix-_r_0_\"]/div[2]/div[1]/input");

    private By txtDescripcion =
            By.xpath("//*[@id=\"radix-_r_0_\"]/div[2]/div[2]/textarea");

    private By txtUbicacion =
            By.xpath("//*[@id=\"radix-_r_0_\"]/div[2]/div[3]/input");

    // Select tipo
    private By selectTipo =
            By.xpath("//*[@id=\"radix-_r_0_\"]/div[2]/div[4]/select");

    // Botón crear
    private By btnCrear =
            By.xpath("//*[@id=\"radix-_r_0_\"]/div[3]/button[1]");

    // Estado denuncia
    private By estadoDenuncia =
            By.xpath("//*[@id=\"root\"]/div/main/div/div[3]/table/tbody/tr/td[3]/span");

    // Abrir modal
    public void abrirModalDenuncia() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        WebElement boton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        btnCrearDenuncia
                )
        );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView(true);",
                        boton
                );

        boton.click();
    }

    // Validar modal
    public boolean modalVisible() {

        return driver.findElement(modalDenuncia)
                .isDisplayed();
    }

    // Formulario
    public void ingresarTitulo(String titulo) {

        driver.findElement(txtTitulo)
                .sendKeys(titulo);
    }

    public void ingresarDescripcion(String descripcion) {

        driver.findElement(txtDescripcion)
                .sendKeys(descripcion);
    }

    public void ingresarUbicacion(String ubicacion) {

        driver.findElement(txtUbicacion)
                .sendKeys(ubicacion);
    }

    // Select
    public void seleccionarTipo() {

        Select select = new Select(
                driver.findElement(selectTipo)
        );

        select.selectByIndex(1);
    }

    // Crear denuncia
    public void clicCrearDenuncia() {

        driver.findElement(btnCrear)
                .click();
    }

    // Obtener estado
    public String obtenerEstadoDenuncia() {

        return driver.findElement(estadoDenuncia)
                .getText();
    }
}
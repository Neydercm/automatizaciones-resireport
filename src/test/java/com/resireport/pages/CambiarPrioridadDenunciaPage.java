package com.resireport.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CambiarPrioridadDenunciaPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By prioridadTabla =
            By.xpath("//table//tbody//tr[1]//td[5]");

    private final By botonVerDetalles =
            By.xpath("//*[@id='root']/div/main/div/div[3]/table/tbody/tr[1]/td[7]/button");

    private final By prioridadDetalle =
            By.xpath("//div//span[contains(text(), 'Sin asignar') or contains(text(), 'Baja') or contains(text(), 'Media') or contains(text(), 'Alta')]");

    private final By opcionPrioridadBaja =
            By.xpath("//button[contains(., 'Baja') or .//span[contains(., 'Baja')]]");

    public CambiarPrioridadDenunciaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String obtenerPrioridadTabla() {
        WebElement celda = wait.until(
                ExpectedConditions.presenceOfElementLocated(prioridadTabla)
        );

        String texto = celda.getText().trim();
        if (texto.isEmpty()) {
            try {
                texto = celda.findElement(By.tagName("span")).getText().trim();
            } catch (Exception e) {
                System.out.println("No se encontro texto para la prioridad en la tabla");
            }
        }
        return texto;
    }

    public void clickVerDetalles() {
        WebElement boton = wait.until(
                ExpectedConditions.elementToBeClickable(botonVerDetalles)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                boton
        );

        boton.click();
    }

    public String obtenerPrioridadDetalle() {
        WebElement elemento = wait.until(
                ExpectedConditions.presenceOfElementLocated(prioridadDetalle)
        );
        return elemento.getText().trim();
    }

    public void clickPrioridadBaja() {
        WebElement boton = wait.until(
                ExpectedConditions.elementToBeClickable(opcionPrioridadBaja)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                boton
        );

        try {
            boton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    boton
            );
        }
    }
}

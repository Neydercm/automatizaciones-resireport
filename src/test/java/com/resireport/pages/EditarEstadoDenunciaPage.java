package com.resireport.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.time.Duration;

import java.time.Duration;

public class EditarEstadoDenunciaPage {

    private WebDriver driver;

    public EditarEstadoDenunciaPage(WebDriver driver) {
        this.driver = driver;
    }

    // Localizadores
    private By estadoTabla = 
            By.xpath("//table//tbody//tr[1]//td[4]");

    private By btnVerDetalles = 
            By.xpath("//*[@id=\"root\"]/div/main/div/div[3]/table/tbody/tr[1]/td[7]");

    private By estadoDetalle = 
            By.xpath("//div//span[contains(text(), 'Registrada') or contains(text(), 'Rechazada') or contains(text(), 'Analizando')]");

    private By selectEstado = 
            By.xpath("//select");

    private By btnCambiarEstado = 
            By.xpath("//button[contains(text(), 'Guardar') or contains(text(), 'Actualizar') or contains(text(), 'Cambiar')]");

    private By btnConfirmar = 
            By.xpath("//div[contains(@class, 'modal') or contains(@class, 'dialog')]//button[contains(text(), 'Confirmar') or contains(text(), 'Aceptar')]");

    // Métodos
    public String obtenerEstadoTabla() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement celda = wait.until(ExpectedConditions.presenceOfElementLocated(estadoTabla));
        // Obtiene el texto de la celda que contiene el estado
        String texto = celda.getText().trim();
        if (texto.isEmpty()) {
            // Si no hay texto directo, intenta obtener del span
            try {
                WebElement span = celda.findElement(By.tagName("span"));
                texto = span.getText().trim();
            } catch (Exception e) {
                System.out.println("No se encontró span en la celda de estado");
            }
        }
        System.out.println("Estado obtenido de la tabla: " + texto);
        return texto;
    }

    public void clickVerDetalles() throws InterruptedException {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    By botonDetalles = By.xpath(
        "//*[@id='root']/div/main/div/div[3]/table/tbody/tr[1]/td[7]/button"
    );

    WebElement boton = wait.until(
        ExpectedConditions.elementToBeClickable(botonDetalles)
    );

    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView(true);",
        boton
    );

    Thread.sleep(2000);

    boton.click();
}

    public String obtenerEstadoDetalle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(estadoDetalle));
        String texto = elemento.getText().trim();
        System.out.println("Estado obtenido del detalle: " + texto);
        return texto;
    }

    public void seleccionarEstado(String estado) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement selectElement = wait.until(ExpectedConditions.presenceOfElementLocated(selectEstado));
        Select select = new Select(selectElement);
        try {
            select.selectByVisibleText(estado);
            System.out.println("Estado seleccionado: " + estado);
        } catch (Exception e) {
            System.out.println("Error al seleccionar estado. Intentando por valor...");
            select.selectByValue(estado.toLowerCase());
        }
    }

    public void clickCambiarEstado() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement boton = wait.until(
                ExpectedConditions.elementToBeClickable(btnCambiarEstado)
        );
        System.out.println("Haciendo clic en botón cambiar estado...");
        boton.click();
    }

    public void confirmarCambioEstado() throws InterruptedException {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    System.out.println("Esperando modal de confirmación...");

    By botonSiCambiar = By.xpath(
        "//button[contains(., 'Sí, cambiar')]"
    );

    WebElement boton = wait.until(
        ExpectedConditions.visibilityOfElementLocated(botonSiCambiar)
    );

    Thread.sleep(2000);

    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        boton
    );

    Thread.sleep(1000);

    wait.until(
        ExpectedConditions.elementToBeClickable(boton)
    );

    try {

        boton.click();

    } catch (Exception e) {

        System.out.println("Click normal falló. Ejecutando JS click...");

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();",
            boton
        );
    }

    System.out.println("Botón 'Sí, cambiar' presionado");

    Thread.sleep(5000);
}

    }

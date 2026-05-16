package com.resireport.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EstadoDenunciaPage {

    WebDriver driver;

    public EstadoDenunciaPage(WebDriver driver) {
        this.driver = driver;
    }

    // Estado en tabla
    By estadoRegistrado = By.xpath(
        "//*[@id='root']/div/main/div/div[3]/table/tbody/tr[1]/td[4]/span"
    );

    // Botón ver detalles
    By botonVerDetalles = By.xpath(
        "//*[@id='root']/div/main/div/div[3]/table/tbody/tr[1]/td[7]/button"
    );

    // Estado actual dentro del detalle
    By estadoDetalle = By.xpath(
        "//*[@id='root']/div/main/div/div[1]/span/font/font"
    );

    // Select cambiar estado
    By selectEstado = By.xpath(
        "//*[@id='root']/div/main/div/div[3]/div[1]/select"
    );

    // Botón cambiar estado
    By botonCambiarEstado = By.xpath(
        "//*[@id='root']/div/main/div/div[3]/div[1]/button"
    );

    // Modal confirmación
    By modalConfirmacion = By.xpath(
        "//*[@id='radix-_r_6_']"
    );

    // Botón sí cambiar
    By botonSiCambiar = By.xpath(
        "//*[@id='radix-_r_6_']/div[2]/button[2]"
    );

    public String obtenerEstadoTabla() {
        return driver.findElement(estadoRegistrado).getText();
    }

    public void clicVerDetalles() {
        driver.findElement(botonVerDetalles).click();
    }

    public String obtenerEstadoDetalle() {
        return driver.findElement(estadoDetalle).getText();
    }

    public void seleccionarEstadoAnalizando() {

        Select select = new Select(driver.findElement(selectEstado));

        select.selectByVisibleText("Analizando");
    }

    public void clicCambiarEstado() {
        driver.findElement(botonCambiarEstado).click();
    }

    public boolean modalVisible() {
        return driver.findElement(modalConfirmacion).isDisplayed();
    }

    public void confirmarCambioEstado() {
        driver.findElement(botonSiCambiar).click();
    }
}
package com.resireport.tests;

import com.resireport.pages.LoginPage;
import com.resireport.pages.EditarEstadoDenunciaPage;
import com.resireport.utils.ExcelUtil;
import com.resireport.utils.ScreenshotUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EditarEstadoDenunciaTest extends BaseTest {

    @Test
    public void editarEstadoDenunciaRegistrada() throws Exception {

        // ==============================
        // DATOS DESDE EXCEL
        // ==============================
        String correo = ExcelUtil.getCellData(1, 1);
        String password = ExcelUtil.getCellData(1, 2);

        // ==============================
        // LOGIN ADMIN
        // ==============================
        LoginPage loginPage = new LoginPage(driver);

        loginPage.ingresarCorreo(correo);
        loginPage.ingresarPassword(password);

        ScreenshotUtil.tomarCaptura(driver, "01_login_admin");

        loginPage.clicIniciarSesion();

        // ==============================
        // ESPERA DE CARGA
        // ==============================
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        Thread.sleep(10000);

        ScreenshotUtil.tomarCaptura(driver, "02_dashboard_admin");

        // ==============================
        // PAGE OBJECT
        // ==============================
        EditarEstadoDenunciaPage denunciaPage =
                new EditarEstadoDenunciaPage(driver);

        // ==============================
        // VALIDAR ESTADO REGISTRADA
        // ==============================
        String estadoActual = denunciaPage.obtenerEstadoTabla();

        System.out.println("Estado encontrado: " + estadoActual);

        Assert.assertTrue(
                estadoActual.toLowerCase().contains("registrada"),
                "La denuncia no está en estado REGISTRADA"
        );

        ScreenshotUtil.tomarCaptura(driver, "03_estado_registrada");

        // ==============================
        // VER DETALLES
        // ==============================
        denunciaPage.clickVerDetalles();

        Thread.sleep(4000);

        ScreenshotUtil.tomarCaptura(driver, "04_detalles_denuncia");

        // ==============================
        // VALIDAR ESTADO DETALLE
        // ==============================
        String estadoDetalle = denunciaPage.obtenerEstadoDetalle();

        System.out.println("Estado detalle: " + estadoDetalle);

        ScreenshotUtil.tomarCaptura(driver, "05_estado_detalle");

        // ==============================
        // CAMBIAR ESTADO
        // ==============================
        denunciaPage.seleccionarEstado("Analizando");

        Thread.sleep(2000);

        ScreenshotUtil.tomarCaptura(driver, "06_estado_analizando");

        denunciaPage.clickCambiarEstado();

        Thread.sleep(3000);

        // ==============================
        // CONFIRMAR CAMBIO
        // ==============================
        denunciaPage.confirmarCambioEstado();

        Thread.sleep(5000);

        ScreenshotUtil.tomarCaptura(driver, "07_estado_actualizado");

        // ==============================
        // VALIDAR CAMBIO FINAL
        // ==============================
        String nuevoEstado = denunciaPage.obtenerEstadoDetalle();

        System.out.println("Nuevo estado: " + nuevoEstado);

        Assert.assertTrue(
                nuevoEstado.toLowerCase().contains("analizando"),
                "El estado no fue actualizado correctamente"
        );

        ScreenshotUtil.tomarCaptura(driver, "08_validacion_final");

        System.out.println("Flujo completado correctamente.");
    }
}
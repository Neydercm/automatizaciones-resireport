package com.resireport.tests;

import com.resireport.pages.DenunciaPage;
import com.resireport.pages.LoginPage;
import com.resireport.utils.ExcelUtil;
import com.resireport.utils.ScreenshotUtil;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CrearDenunciaTest extends BaseTest {

    @Test
    public void crearDenunciaResidente()
            throws InterruptedException {

        // Login residente
        String email = ExcelUtil.getCellData(2, 1);

        String password = ExcelUtil.getCellData(2, 2);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.ingresarCorreo(email);

        Thread.sleep(1000);

        loginPage.ingresarPassword(password);

        Thread.sleep(2000);

        ScreenshotUtil.tomarCaptura(
                driver,
                "05_login_residente"
        );

        loginPage.clicIniciarSesion();

        Thread.sleep(8000);

        WebDriverWait wait = new WebDriverWait(
        driver,
        Duration.ofSeconds(20)
);

wait.until(ExpectedConditions.urlContains(
        "mis-denuncias"
));

        // Esperar a que el botón crear denuncia sea visible
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id=\"root\"]/div/main/div/div[1]/div/button")
                )
        );

        ScreenshotUtil.tomarCaptura(
                driver,
                "06_dashboard_residente"
        );
        ScreenshotUtil.tomarCaptura(
        driver,
        "06_dashboard_antes_denuncia"
);

        // Flujo denuncia
        DenunciaPage denunciaPage =
                new DenunciaPage(driver);

        // Abrir modal
        denunciaPage.abrirModalDenuncia();

        Thread.sleep(3000);

        ScreenshotUtil.tomarCaptura(
                driver,
                "07_modal_denuncia"
        );

        // Validar modal
        if (denunciaPage.modalVisible()) {

            System.out.println(
                    "Modal visible correctamente"
            );
        }

        // Diligenciar formulario
        denunciaPage.ingresarTitulo(
                "Ruido excesivo en zona comun"
        );

        Thread.sleep(1000);

        denunciaPage.ingresarDescripcion(
                "Se reporta ruido excesivo durante la noche"
        );

        Thread.sleep(1000);

        denunciaPage.ingresarUbicacion(
                "Torre B - Piso 3"
        );

        Thread.sleep(1000);

        denunciaPage.seleccionarTipo();

        Thread.sleep(2000);

        ScreenshotUtil.tomarCaptura(
                driver,
                "08_formulario_denuncia"
        );

        // Crear denuncia
        denunciaPage.clicCrearDenuncia();

        Thread.sleep(5000);

        ScreenshotUtil.tomarCaptura(
                driver,
                "09_denuncia_creada"
        );

        // Validar estado
        String estado =
                denunciaPage.obtenerEstadoDenuncia();

        System.out.println(
                "Estado denuncia: " + estado
        );

        Thread.sleep(3000);
    }
}
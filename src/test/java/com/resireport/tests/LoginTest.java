package com.resireport.tests;

import com.resireport.pages.LoginPage;
import com.resireport.utils.ExcelUtil;
import com.resireport.utils.ScreenshotUtil;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginAdmin() throws InterruptedException {

        // Leer datos Excel
        String email = ExcelUtil.getCellData(1, 1);
        String password = ExcelUtil.getCellData(1, 2);

        // Instancia página
        LoginPage loginPage = new LoginPage(driver);

        // Ingresar credenciales
        loginPage.ingresarCorreo(email);

        Thread.sleep(1000);

        loginPage.ingresarPassword(password);

        Thread.sleep(2000);

        // Captura antes del login
        ScreenshotUtil.tomarCaptura(driver,
                "01_datos_ingresados");

        Thread.sleep(2000);

        // Clic login
        loginPage.clicIniciarSesion();

        // Esperar carga
        Thread.sleep(5000);

        // Captura sesión iniciada
        ScreenshotUtil.tomarCaptura(driver,
                "02_sesion_iniciada");

        Thread.sleep(3000);
    }
    @Test
public void loginFallido() throws InterruptedException {

    // Leer credenciales inválidas
    String email = ExcelUtil.getCellData(3, 1);
    String password = ExcelUtil.getCellData(3, 2);

    // Instanciar página
    LoginPage loginPage = new LoginPage(driver);

    // Ingresar datos
    loginPage.ingresarCorreo(email);

    Thread.sleep(1000);

    loginPage.ingresarPassword(password);

    Thread.sleep(2000);

    // Captura antes login
    ScreenshotUtil.tomarCaptura(driver,
            "03_login_fallido_datos");

    Thread.sleep(2000);

    // Login
    loginPage.clicIniciarSesion();

    Thread.sleep(4000);

    // Validar mensaje error
    if (loginPage.mensajeErrorVisible()) {

        System.out.println("Mensaje error encontrado:");

        System.out.println(
                loginPage.obtenerMensajeError()
        );

        // Captura error
        ScreenshotUtil.tomarCaptura(driver,
                "04_login_fallido_error");

    } else {

        System.out.println(
                "No apareció mensaje de error"
        );
    }

    Thread.sleep(3000);
}
}
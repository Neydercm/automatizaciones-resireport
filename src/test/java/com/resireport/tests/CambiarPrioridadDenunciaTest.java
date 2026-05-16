package com.resireport.tests;

import com.resireport.pages.LoginPage;
import com.resireport.pages.CambiarPrioridadDenunciaPage;
import com.resireport.utils.ExcelUtil;
import com.resireport.utils.ScreenshotUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CambiarPrioridadDenunciaTest extends BaseTest {

        @Test
        public void cambiarPrioridadDenuncia() throws Exception {

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
                Thread.sleep(10000);

                ScreenshotUtil.tomarCaptura(driver, "02_dashboard_admin");

                // ==============================
                // PAGE OBJECT
                // ==============================
                CambiarPrioridadDenunciaPage prioridadPage = new CambiarPrioridadDenunciaPage(driver);

                // ==============================
                // VALIDAR PRIORIDAD SIN ASIGNAR
                // ==============================
                String prioridadActual = prioridadPage.obtenerPrioridadTabla();

                System.out.println("Prioridad encontrada: " + prioridadActual);

                Assert.assertTrue(
                                prioridadActual.toLowerCase().contains("sin asignar"),
                                "La denuncia no tiene prioridad SIN ASIGNAR");

                ScreenshotUtil.tomarCaptura(driver, "03_prioridad_sin_asignar");

                // ==============================
                // VER DETALLES
                // ==============================
                prioridadPage.clickVerDetalles();

                Thread.sleep(4000);

                ScreenshotUtil.tomarCaptura(driver, "04_detalles_denuncia");

                // ==============================
                // VALIDAR PRIORIDAD DETALLE
                // ==============================
                String prioridadDetalle = prioridadPage.obtenerPrioridadDetalle();

                System.out.println("Prioridad actual detalle: " + prioridadDetalle);

                ScreenshotUtil.tomarCaptura(driver, "05_prioridad_detalle");

                // ==============================
                // CAMBIAR PRIORIDAD A BAJA
                // ==============================
                prioridadPage.clickPrioridadBaja();

                Thread.sleep(3000);

                ScreenshotUtil.tomarCaptura(driver, "06_prioridad_baja_seleccionada");

                // ==============================
                // REFRESCAR PAGINA
                // ==============================
                driver.navigate().refresh();

                Thread.sleep(5000);

                ScreenshotUtil.tomarCaptura(driver, "07_pagina_refrescada");

                // ==============================
                // VALIDAR PRIORIDAD ACTUALIZADA
                // ==============================
                String prioridadActualizada = prioridadPage.obtenerPrioridadDetalle();

                System.out.println("Prioridad actualizada: " + prioridadActualizada);

                Assert.assertTrue(
                                prioridadActualizada.toLowerCase().contains("baja"),
                                "La prioridad no fue actualizada a BAJA");

                ScreenshotUtil.tomarCaptura(driver, "08_prioridad_actualizada");
        }
}
package com.resireport.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void tomarCaptura(WebDriver driver, String nombreArchivo) {

        // Fecha dinámica
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        // Captura
        File srcFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        // Ruta destino
        File destino = new File(
                "screenshots/" + nombreArchivo + "_" + timestamp + ".png"
        );

        try {

            FileUtils.copyFile(srcFile, destino);

            System.out.println("Captura guardada: "
                    + destino.getAbsolutePath());

        } catch (IOException e) {

            System.out.println("Error al guardar captura");

            e.printStackTrace();
        }
    }
}
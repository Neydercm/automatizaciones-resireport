package com.resireport.tests;

import java.nio.file.Files;
import java.nio.file.Path;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        try {
            WebDriverManager.chromedriver().setup();
            Path chromeProfile = createTempProfileDir("selenium-chrome-profile-");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--remote-debugging-port=9222");
            options.addArguments("--user-data-dir=" + chromeProfile.toAbsolutePath());

            driver = new ChromeDriver(options);
        } catch (WebDriverException e) {
            System.out.println("Chrome no pudo iniciar. Se intentara con Edge.");

            WebDriverManager.edgedriver().setup();
            Path edgeProfile = createTempProfileDir("selenium-edge-profile-");

            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--headless=new");
            edgeOptions.addArguments("--window-size=1920,1080");
            edgeOptions.addArguments("--disable-gpu");
            edgeOptions.addArguments("--no-sandbox");
            edgeOptions.addArguments("--disable-dev-shm-usage");
            edgeOptions.addArguments("--user-data-dir=" + edgeProfile.toAbsolutePath());

            driver = new EdgeDriver(edgeOptions);
        } catch (Exception e) {
            throw new RuntimeException("No fue posible inicializar el navegador para las pruebas", e);
        }

        driver.manage().window().maximize();

        driver.get("https://resi-report.vercel.app/");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    private Path createTempProfileDir(String prefix) {
        try {
            return Files.createTempDirectory(prefix);
        } catch (Exception e) {
            throw new RuntimeException("No fue posible crear el perfil temporal del navegador", e);
        }
    }
}

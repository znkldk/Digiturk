package com.baris.hook;

import com.baris.reportTools.GoogleExel;
import com.baris.reportTools.Rapor;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class hook {
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;
    public Rapor rapor=new Rapor();

    Logger logger = Logger.getLogger(hook.class);

    @BeforeScenario
    public void setUp(ExecutionContext executionContext){
        //Rapor için senaryo ismi hazırlama
        String currentScenarioName=executionContext.getCurrentScenario().getName();
        rapor.setCurrentScenarioName(currentScenarioName);
        rapor.setDate(getDate());


        logger.info("Senaryo başlıyor");
        String baseUrl = "https://www.beinconnect.com.tr/hosgeldiniz";
        System.setProperty("webdriver.chrome.driver", "webDriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        int timeOutInSeconds =10; //Bir elementin sayfada yüklenmesi için beklenicek maksimum saniye
        webDriverWait = new WebDriverWait(driver, timeOutInSeconds);

    }


    @AfterScenario
    public void afterSenario(ExecutionContext exexutionContext) throws IOException, GeneralSecurityException {
        GoogleExel googleExel=new GoogleExel();
        String errorMessage;
        String time;
        if(exexutionContext.getCurrentScenario().getIsFailing()){

            rapor.setResult("Fail");

        }else {
            rapor.setResult("Pass");

        }
        googleExel.doReport();

        driver.quit();

    }

    public String getDate(){
        logger.info("Tarih ve saat belirleniyor...");
        SimpleDateFormat bicim2=new SimpleDateFormat("dd-M-yyyy hh.mm.ss");
        String date;
        Date tarihSaat=new Date();
        date=String.valueOf(bicim2.format(tarihSaat)).replaceAll(" ","\n");
        return date;
    }

}



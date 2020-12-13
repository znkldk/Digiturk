package com.baris.Pages;

import com.baris.methods.methods;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SatinAl extends methods {
    Logger logger = Logger.getLogger(SatinAl.class);

    private By webCepTablet=By.xpath("//*[@data-name=\"30 Gün Ücretsiz Eğlence Paketi!\"]//*[.='Web, Cep, Tablet']");
    private By name=By.name("FirstName");
    private By lastName=By.name("LastName");
    private By email=By.name("Email");
    private By phoneNumber=By.name("PhoneNumber");


    @Step("Web Cap Tablet Butonuna Tıkla")
    public void clickWebCepTablet(){
        findElementByby(webCepTablet).click();
        logger.info("Web Cap Tablet Butonuna Tıklandı");
    }

    @Step("İsmi Gir <text>")
    public void enterNamevoid (String text){
        findElementByby(name).sendKeys(text);
        logger.info("İsim Alanına"+text+" yazıldı");
    }
    @Step("Soy ismi Gir <text>")
    public void enterSurnamevoid (String text){
        findElementByby(lastName).sendKeys(text);
        logger.info("Soy İsism Alanına "+text+" Yazıldı");
    }
    @Step("Email Adresini Gir <text>")
    public void enterEmail(String text){
        findElementByby(email).sendKeys(text);
        logger.info("Email Alanına "+text+" Yazıldı");
    }
    @Step("Cep Telefonu numarasını Gir <text>")
    public void enterPhoneNumber(String text){
        findElementByby(phoneNumber).sendKeys(text);
        logger.info("Cep Numarası Alanına "+text+" Yazıldı");
    }
}

package com.baris.Pages;

import com.baris.methods.methods;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Film extends methods {
    Logger logger = Logger.getLogger(Film.class);

    private By ucretsizIzleBtn=By.xpath("//*[.='30 GÜN ÜCRETSİZ İZLE']");
    private By fragmanIzle=By.xpath("//*[@data-item-title=\"FRAGMAN İZLE\"]");

    @Step("30 Gün Ücretsiz İzle Butonuna Tıkla")
    public void clickFreeBtn(){
        findElementByby(ucretsizIzleBtn).click();
        logger.info("30 Gün Ücretsiz İzle Butonuna Tıklandı");
    }

    @Step("Fragman Butonuna Tıkla")
    public void playFragman(){

        findElementByby(fragmanIzle).click();
        logger.info("Fragman Butonuna Tıklandı");
    }
}

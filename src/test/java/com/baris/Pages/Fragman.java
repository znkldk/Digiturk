package com.baris.Pages;

import com.baris.methods.methods;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Fragman extends methods {
    Logger logger = Logger.getLogger(Fragman.class);

    private By sure=By.xpath("//*[@class=\"bmpui-ui-playbacktimelabel\"]");
    private By player=By.xpath("//*[@id=\"bmpui-id-214\"]");

    @Step("Fragmanın Oynadıgını Kontrol Et")
    public void checkİfPlayerWorking(){
        Actions action = new Actions(driver);
        WebElement videoPlayer=findElementByby(player);

        String firstReadedTime;
        String secontReadedTime;

        firstReadedTime=findElementByby(sure).getText();

        waitForSec(2);

        action.moveToElement(videoPlayer).build().perform();

        secontReadedTime=findElementByby(sure).getText();
        System.out.println(firstReadedTime+" "+secontReadedTime);

        compareTwoStringFailIfEquals(firstReadedTime,secontReadedTime,"Fragman Oynamamaktadır!!!");
        logger.info("Fragmanın Oynadıgını Kontrol Edildi");
    }

    @Step("Fragman Sayfasından Filmler Sayfasına Tekrar Geri Gel")
    public void backToFilmListPage(){
        goBackPage();

    }

}

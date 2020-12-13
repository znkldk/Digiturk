package com.baris.Pages;

import com.baris.methods.methods;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends methods {
    Logger logger = Logger.getLogger(MainPage.class);

    private By icerigiKesfet=By.xpath("//*[@class=\"arrow mega-menu-btn\"]//*[.='İçerikleri Keşfet']");
    private By yabanciFilmBtn=By.xpath("//*[@data-id=\"film\"]//*[.='Yabancı Film'and @data-search=\"Yabancı Film\"]");

    @Step("İçerigi Keşfet Butonunun Üzerinde Dur")
    public void hOverIcerigiKesfet(){
      //  findElementByby(dahaSonra).click();
        Actions action = new Actions(driver);
        WebElement element=findElementByby(icerigiKesfet);
        action.moveToElement(element).build().perform();
        logger.info("İçerigi Keşfet Butonunun Üzerinde Dururldu");
    }

    @Step("Yabancı Filmler ButonunaTıkla")
    public void clickYabancıFilmlerBtn(){
        findElementByby(yabanciFilmBtn).click();
        logger.info("Yabancı Filmler Butonuna Tıklandı");
    }

}

package com.baris.Pages;
import com.baris.hook.hook;
import com.baris.methods.methods;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class YabanciFilm extends methods {
    Logger logger = Logger.getLogger(YabanciFilm.class);

    private By tumu= By.xpath("//*[@class=\"slider-favourite-header\" and .='Tümü']");
    private By logo=By.xpath("//*[@title=\"beIN CONNECT\"]");
    private By enYeniFilmler=By.xpath("//*[@class=\"swiper-slide swiper-slide-favourite\"]//*[@data-component-info=\"sushi/En Yeniler\"]");
    private By sirala=By.id("link-order");
    private By yapımYilinaGöre=By.xpath("//*[@class=\"sort-of-match-content\"]//*[.='Yapım Yılı' and @data-action=\"7\"]");
    private By patronGibiFilm=By.xpath("//*[@data-item-title=\"Patron Gibi\"]");

    @Step("Yabancı Filmler Sayfasından Tumu Butonuna Tıkla")
    public void clickTumuBtn(){
        findElementByby(tumu).click();
        logger.info("Tumu Butonuna Tıklandı");
    }
    @Step("Yabancı Filmler Sayfası Elementlerini Kontrol et")
    public void checkYabanciFilmİtems(){
        findElementByby(logo);
        findElementByby(enYeniFilmler);
        logger.info("Yabancı Filmler Sayfasındaki Elementler Kontrol Edildi");
    }

    @Step("Sirala Butonuna Tıkla")
    public void clickSiralaBtn(){
        findElementByby(sirala).click();
        logger.info("Sirala Butonuna Tıklandı");
    }

    @Step("Yapım Yılına Butonuna Tıkla")
    public void clickYapımYılınaGoreBtn(){
        findElementByby(yapımYilinaGöre).click();
        logger.info("Yapım Yılına Butonuna Tıklandı");
    }
    @Step("Patron Gibi Filme Tıkla")
    public void selecktPatronGibi(){
        findElementByby(patronGibiFilm).click();
        waitForSec(3);
        logger.info("Patron Gibi Filmine Tıklandı");
    }


}

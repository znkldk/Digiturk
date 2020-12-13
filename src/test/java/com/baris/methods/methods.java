package com.baris.methods;
import com.baris.Pages.SatinAl;
import com.baris.hook.hook;
import com.baris.reportTools.Rapor;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class methods extends hook{
    Logger logger = Logger.getLogger(methods.class);


    public WebElement findElementByby(By by){
        WebElement element=null;

        try{
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            element=driver.findElement(by);

        }catch (Exception e){
            rapor.setErrorMessage(by+" Elementi sayfada bulunamadı!!!");
            Assert.fail(by+" Elementi sayfada bulunamadı!!!");

        }

        return element;
    }
    public void waitForSec(int sure) {

        try {
            Thread.sleep(sure * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(sure+" saniye beklendi");
    }
    public void compareTwoStringFailIfEquals(String str1,String str2,String message){
        if (str1.equals(str2)){
            rapor.setErrorMessage(message);
            Assert.fail(message);
        }
    }

    public void goBackPage(){
        driver.navigate().back();
    }

}

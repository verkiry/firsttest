package ru.mail.zhenyokvlad;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class KETest {
    int amountOfKeToSet=3;
    private static WebDriver driver;
    @Before
    public void before() {

        System.setProperty("webdriver.chrome.driver", "/work/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.4.222/login");
    }

    @After
    public void after() {
        List<WebElement> yellowKE= driver.findElements(By.xpath("//div[@class='app-mailBox-item-link-favourit-icon active']"));
        for (int i=0; i<amountOfKeToSet; i++){
            yellowKE.get(i).click();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
        driver.quit();
    }
    @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Epic(value = "Проверка КЕ")
    @Test
    public void lookingInCategories() {
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        // try {
        //     Thread.sleep(3000);
        // } catch (InterruptedException ie) {
        //  }

        int t = 0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                t++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {
            }
            // WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
            workspace.click();
            break;
        } catch (Exception ex) {
        }
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement nextButton=driver.findElement(By.xpath("//a[@class='app-pagination-arrow-next']"));
        List<WebElement> grayKE= driver.findElements(By.xpath("//div[@class='app-mailBox-item-link-favourit-icon ']"));
        List<WebElement> yellowKE= driver.findElements(By.xpath("//div[@class='app-mailBox-item-link-favourit-icon active']"));
       String KECounter=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[5]/div[1]/span")).getText();
       int KEAmount=Integer.parseInt(KECounter);
       int amountOfGrayKE=grayKE.size();
       int amountOfYellowKE=yellowKE.size();
       System.out.println(amountOfGrayKE);
       System.out.println(amountOfYellowKE);
       System.out.println(KEAmount);

        for (int i=0; i<amountOfKeToSet; i++){
            grayKE.get(i).click();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
        driver.navigate().refresh();
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }

        List<WebElement> yellowKEAfter= driver.findElements(By.xpath("//div[@class='app-mailBox-item-link-favourit-icon active']"));
        List<WebElement> grayKEAfter= driver.findElements(By.xpath("//div[@class='app-mailBox-item-link-favourit-icon ']"));
        String KECounterAfter=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[5]/div[1]/span")).getText();
        int KEAmountAfter=Integer.parseInt(KECounterAfter);
        int amountOfGrayKEAfter=grayKEAfter.size();
        int amountOfYellowKEAfter=yellowKEAfter.size();
        System.out.println(amountOfGrayKEAfter);
        System.out.println(amountOfYellowKEAfter);
        System.out.println(KEAmountAfter);
        int checkPassed=0;
        if (amountOfGrayKE==amountOfGrayKEAfter+amountOfKeToSet){
            checkPassed++;
        }
        if (amountOfYellowKE==amountOfYellowKEAfter-amountOfKeToSet){
            checkPassed++;
        }
        if (KEAmount==KEAmountAfter-amountOfKeToSet){
            checkPassed++;
        }
        System.out.println(checkPassed);

        Assert.assertEquals(3,checkPassed);
    }
}

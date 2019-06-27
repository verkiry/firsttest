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
    int amountOfKeToSet=3; //количество КЕ, которые будем ставить в тесте
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
            yellowKE.get(i).click(); //после теста убираем звездочки, которые поставили
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
    public void KETest() {
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        //Залогинились
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
        //Перешли в воркспейс и ждем, пока он пропадет, чтобы продолжить рбаоту
        //WebElement nextButton=driver.findElement(By.xpath("//a[@class='app-pagination-arrow-next']")); //задел на будущее
        List<WebElement> grayKE= driver.findElements(By.xpath("//div[@class='app-mailBox-item-link-favourit-icon ']"));
        //получили список серых (не активных) звездочек
        List<WebElement> yellowKE= driver.findElements(By.xpath("//div[@class='app-mailBox-item-link-favourit-icon active']"));
        //получили список желтых (активных) звездочек
       String KECounter=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[5]/div[1]/span")).getText();
       int KEAmount=Integer.parseInt(KECounter); //получили количество КЕ из счетчика на сайдбаре
       int amountOfGrayKE=grayKE.size(); //количество неактивных звездочек
       int amountOfYellowKE=yellowKE.size(); //количество активных звездочек
       //System.out.println(amountOfGrayKE);
       //System.out.println(amountOfYellowKE);
       //System.out.println(KEAmount);

        for (int i=0; i<amountOfKeToSet; i++){ //ставим несколько КЕ
            grayKE.get(i).click();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        driver.navigate().refresh(); //обновляем страницу
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        //ждем исчезновение прелоадера, чтобы продолжить работу
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }

        List<WebElement> yellowKEAfter= driver.findElements(By.xpath("//div[@class='app-mailBox-item-link-favourit-icon active']"));
        List<WebElement> grayKEAfter= driver.findElements(By.xpath("//div[@class='app-mailBox-item-link-favourit-icon ']"));
        String KECounterAfter=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[5]/div[1]/span")).getText();
        int KEAmountAfter=Integer.parseInt(KECounterAfter); //количество КЕ на сайдбаре после добавления новых
        int amountOfGrayKEAfter=grayKEAfter.size(); //количество неактивных КЕ после добавления новых
        int amountOfYellowKEAfter=yellowKEAfter.size(); //количество активных КЕ после добавления новых
        //System.out.println(amountOfGrayKEAfter);
        //System.out.println(amountOfYellowKEAfter);
        //System.out.println(KEAmountAfter);
        int checkPassed=0; //счетчик количества пройденных проверок в рамках данного теста
        if (amountOfGrayKE==amountOfGrayKEAfter+amountOfKeToSet){
            checkPassed++; //если количество неактивных КЕ уменьшилось на amountOfKeToSet, то Passed
        }
        if (amountOfYellowKE==amountOfYellowKEAfter-amountOfKeToSet){
            checkPassed++; //если количество активных КЕ увеличилось на amountOfKeToSet, то Passed
        }
        if (KEAmount==KEAmountAfter-amountOfKeToSet){
            checkPassed++; //если количество КЕ на сайдбаре увеличиилось на amountOfKeToSet, то Passed
        }
        //System.out.println(checkPassed);
        Allure.addAttachment("Установили " + amountOfKeToSet + " КЕ", " ");
        attachScreenshot(); //скрин в отчет
        Assert.assertEquals(3,checkPassed); //если все 3 проверки прошли успешно, то тест пройден, если хоть один провалился- Failed
    }
}

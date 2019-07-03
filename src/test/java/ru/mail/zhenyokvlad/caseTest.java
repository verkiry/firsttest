package ru.mail.zhenyokvlad;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import javafx.scene.layout.Priority;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.security.Key;
import java.util.concurrent.TimeUnit;

public class caseTest {
    private static WebDriver driver;
    @Before
    public void before()
    {
        System.setProperty("webdriver.chrome.driver", "/work/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.4.222/login");
    }
    @After
    public void after(){
//System.out.print ("Login success");
        driver.quit();
    }
    @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    @Epic(value = "Работа с делами")
    @Test
    @Description("Добавление дела")
    public void ACaseEdit() {

        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement addCase= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/div/div[1]/div/div/div[2]/div[1]/div"));
        addCase.click();
        WebElement numberField= driver.findElement(By.id("editableNumber"));
        numberField.sendKeys("Difficultstring12/.,';][}{Text");
        WebElement nameFiled= driver.findElement(By.id("editableName"));
        nameFiled.sendKeys("!@#$%^&*()_+:");
        WebElement addButton= driver.findElement(By.id("btn-case"));
        addButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String firstCaseName= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/div/div[1]/div/wa-data-table/div/div/div/div[2]/div[1]/div/div[3]/div/div")).getText();
        attachScreenshot();
        Assert.assertEquals(firstCaseName, "Difficultstring12/.,';][}{Text");
  }

 @Epic(value = "Работа с делами")
 @Test
 @Description("Удаление дела")
  public void CaseDelete() {

  WebElement loginField = driver.findElement(By.name("UID"));
  loginField.sendKeys("maxim");
  WebElement passwordField = driver.findElement(By.name("PWD"));
  passwordField.sendKeys("12345");
  passwordField.sendKeys(Keys.ENTER);
      try {
        Thread.sleep(500);
       } catch (InterruptedException ex) {
        }
     WebDriverWait wait = new WebDriverWait(driver, 40);
     wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
     attachScreenshot();
        WebElement firstCaseName= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/div/div[1]/div/wa-data-table/div/div/div/div[2]/div[1]/div/div[3]/div/div"));
        String CaseName1=firstCaseName.getText();
        WebElement threeDots= driver.findElement(By.xpath("//div[@class='barMenu-trigger']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(threeDots).build().perform();
     int t = 0;
     while (t < 80) try {
         try {
             //ДЕЛАЕМ
             Thread.sleep(500);
             t++;
             //500 - 0.5 сек
         } catch (InterruptedException ex) {

         }
         threeDots.click();
         break;
     } catch (Exception ex) {
     }
        WebElement deleteCase= driver.findElement(By.xpath("//*[@id=\"barMenuWindow\"]/button[2]"));
        deleteCase.click();
        Alert alert= (new WebDriverWait(driver,10)).until(ExpectedConditions.alertIsPresent());
        alert.accept();

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }

        WebDriverWait wait2 = new WebDriverWait(driver, 40);
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement firstCaseName1= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/div/div[1]/div/wa-data-table/div/div/div/div[2]/div[1]/div/div[3]/div/div"));
        String CaseName2=firstCaseName1.getText();
        attachScreenshot();
        Assert.assertNotEquals(CaseName1, CaseName2);
    }

}

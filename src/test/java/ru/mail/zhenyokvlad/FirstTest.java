package ru.mail.zhenyokvlad;
import io.qameta.allure.Description;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class FirstTest {
    private static WebDriver driver;
@BeforeClass
@Description("Подключаем вебдрайвер, подключаемся к http://192.168.4.222/login")

public static void setup()
{

    System.setProperty("webdriver.chrome.driver", "/work/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.get("http://192.168.4.222/login");
}

    @Test
    public void Search(){
        WebElement loginField=driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField=driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException ie){
        }
        WebElement userName=driver.findElement(By.className("app-header-content-userDropdown-label"));
        //String nameUser=userName.getText();
       // Assert.assertThat(nameUser, CoreMatchers.containsString("maxim"));
        userName.click();
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }
        WebElement exitButton=driver.findElement(By.id("userMenuWindow"));
        exitButton.click();
tearDown();
    }
    @Test
    public void CountCheckerApplication() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        // try {
        //     Thread.sleep(3000);
        // } catch (InterruptedException ie) {
        //  }
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.elementToBeClickable (By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]")));
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<20) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                t++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {
                break;
            }
           // WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
            workspace.click();
        } catch (Exception ex) {
        }


        //WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        //String nameUser=userName.getText();
        // Assert.assertThat(nameUser, CoreMatchers.containsString("maxim"));
        //workspace.click();
        try {
           Thread.sleep(12000);
       } catch (InterruptedException ie) {
       }
        WebElement applications = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div[2]/span[1]"));
        applications.click();

        WebElement telegramCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div/input"));
        telegramCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
        }
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        System.out.print(gridCouner);
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    @Test
    public void CountCheckerProchee() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
       // WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated (By.cssSelector("div[class=preloader open]")));
       try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        //String nameUser=userName.getText();
        // Assert.assertThat(nameUser, CoreMatchers.containsString("maxim"));
        workspace.click();
        try {
            Thread.sleep(12000);
        } catch (InterruptedException ie) {
        }
        WebElement applications = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div[2]/span[1]"));
        applications.click();

        WebElement procheeCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        procheeCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
        }
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        System.out.print(gridCouner);
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    @Test
    public void CountCheckerDelo() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        //String nameUser=userName.getText();
        // Assert.assertThat(nameUser, CoreMatchers.containsString("maxim"));
        workspace.click();
        try {
            Thread.sleep(12000);
        } catch (InterruptedException ie) {
        }
        WebElement Dela = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[1]/div[2]/span[1]"));
        Dela.click();

        WebElement deloCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        deloCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
        }
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        System.out.print(gridCouner);
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    @Test
    public void CountCheckerPerson() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ie) {
        }
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        //String nameUser=userName.getText();
        // Assert.assertThat(nameUser, CoreMatchers.containsString("maxim"));
        workspace.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
        }
        WebElement Persons = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[2]/span[1]"));
        Persons.click();

        WebElement personCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
       personCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            Thread.sleep(12000);
        } catch (InterruptedException ie) {
        }
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        System.out.print(gridCouner);
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    @Test
    public void CountCheckerDevice() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        //String nameUser=userName.getText();
        // Assert.assertThat(nameUser, CoreMatchers.containsString("maxim"));
        workspace.click();
        try {
            Thread.sleep(12000);
        } catch (InterruptedException ie) {
        }
        WebElement devices = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[1]/div[2]/span[1]"));
        devices.click();

        WebElement deviceCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        deviceCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
        }
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        System.out.print(gridCouner);
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }
    @AfterClass
    public static void tearDown(){

//System.out.print ("Login success");
    driver.quit();
    }
}


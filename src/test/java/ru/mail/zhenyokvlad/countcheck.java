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


public class countcheck {
    private static WebDriver driver;

    @BeforeClass
    @Description("Подключаем вебдрайвер, подключаемся к http://192.168.4.222/login")


    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/work/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        long startTime = System.currentTimeMillis();
        driver.get("http://192.168.4.222/login");
    }
    @Test
    public void CountChecker() {

        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
        }
        WebElement workspace = driver.findElement(By.linkText("Рабочее пространство"));
        //String nameUser=userName.getText();
        // Assert.assertThat(nameUser, CoreMatchers.containsString("maxim"));
        workspace.click();
        try {
            Thread.sleep(10000);
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
    }
        @AfterClass
        public static void tearDown () {


            //driver.quit();
        }
    }

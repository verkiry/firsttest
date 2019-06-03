package ru.mail.zhenyokvlad;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import javafx.application.Application;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TakesScreenshot;



public class FirstTest {
    private static WebDriver driver;
    @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


public static void setup()
{
    System.setProperty("webdriver.chrome.driver", "/work/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://192.168.4.222/login");
}

    @Test
    @Description("Check log in/log out")
    @Attachment
    public void Search() {
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        //try{
        //   Thread.sleep(3000);
        // }
        // catch(InterruptedException ie){
        // }
        // WebElement userName=driver.findElement(By.className("app-header-content-userDropdown-label"));
        //String nameUser=userName.getText();
        // Assert.assertThat(nameUser, CoreMatchers.containsString("maxim"));
        int t = 0;
        WebElement userName = driver.findElement(By.className("app-header-content-userDropdown-label"));
        while (t < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                t++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            userName.click();
            break;
        } catch (Exception ex) {
        }
            WebElement exitButton = driver.findElement(By.id("userMenuWindow"));
            exitButton.click();
            tearDown();
    }



    @Test
    @Description("Check applications filter")
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

        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
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

        //WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        //String nameUser=userName.getText();
        // Assert.assertThat(nameUser, CoreMatchers.containsString("maxim"));
        //workspace.click();
        /*int n = 0;
        WebElement applicaitons = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div[2]/span[1]"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            applicaitons.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
       WebElement applications = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div[2]/span[1]"));
       applications.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement telegramCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div/input"));
        telegramCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }

        /*int m = 0;
        while (m < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
kostil.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
       String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    @Test
    @Description("Check applications filter (prochee)")
    public void CountCheckerProchee() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);

        /*WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        workspace.click(); */
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
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




       /* int n = 0;
        WebElement applicaitons = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div[2]/span[1]"));
        while (n< 160) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            applicaitons.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        WebElement applicaitons = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div[2]/span[1]"));
        applicaitons.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement procheeCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        procheeCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }
        /*int m = 0;
        while (m < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            kostil.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    @Test
    @Description("Check cases filter")
    public void CountCheckerDelo() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
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


        /*int n = 0;
        WebElement Dela = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[1]/div[2]/span[1]"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            Dela.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        WebElement Dela = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[1]/div[2]/span[1]"));
        Dela.click();
        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement deloCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        deloCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }
        /*int m = 0;
        while (m < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            kostil.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        System.out.print(gridCouner);
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }


    @Test
    @Description("Check persons filter")
    public void CountCheckerPerson() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
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
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));

        /*int n = 0;
        WebElement persons = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[2]/span[1]"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            persons.click();
            break;
        } catch (Exception ex) {
        }
*/

        WebElement Persons = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[2]/span[1]"));
        Persons.click();
        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement personCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        personCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }
        /*int m = 0;
        while (m < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            kostil.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    @Test
    @Description("Check devices filter")
    public void CountCheckerDevice() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
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

        /*int n = 0;
        WebElement devices = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[1]/div[2]/span[1]"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            devices.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
       WebElement devices = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[1]/div[2]/span[1]"));
       devices.click();
        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement deviceCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        deviceCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }
        /*int m = 0;
        while (m < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            kostil.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }


    @Test
    @Description("Check category filter")
    public void CountCheckerCategory() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
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

        /*int n = 0;
        WebElement categories = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[2]/span[1]"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            categories.click();
            break;
        } catch (Exception ex) {
        }
        */

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));

        WebElement categories = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[2]/span[1]"));
        categories.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement categoryCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        categoryCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }
        /*int m = 0;
        while (m < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            kostil.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }
    @Test
    @Description("Check direction filter")
    public void CountCheckerDirection() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
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

        /*int n = 0;
        WebElement directions = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/div[2]/span[1]"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            directions.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        WebElement directions = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/div[2]/span[1]"));
        directions.click();
        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement directionCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        directionCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }
        /*int m = 0;
        while (m < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            kostil.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    @Test
    @Description("Check language filter")
    public void CountCheckerLanguages() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
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

        /*int n = 0;
        WebElement languages = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/span[1]"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            languages.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
       WebElement languages = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/span[1]"));
      languages.click();

       // WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement languageCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        languageCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }
       /* int m = 0;
        while (m < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            kostil.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    @Test
    @Description("Check information in text filter")
    public void CountCheckerInformation() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
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
/*
        int n = 0;
        WebElement info = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[1]/div[2]/span[1]"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            info.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        WebElement info = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[1]/div[2]/span[1]"));
        info.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement infoCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        infoCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }
        /*int m = 0;
        while (m < 40) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            kostil.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    @Test
    @Description("Check abonents and groups filter")
    public void CountCheckerAbonents() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
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

        /*int n = 0;
        WebElement abonent = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[1]/div[2]/span[1]"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            abonent.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        WebElement abonent = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[1]/div[2]/span[1]"));
        abonent.click();

       // WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement abonentCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        abonentCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }
        /*int m = 0;
        while (m < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            kostil.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    @Test
    @Description("Check extra properties filter")
    public void CountCheckerExtraProperties() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
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

        /*int n = 0;
        WebElement extra = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[1]/div[2]/span[1]"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            extra.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        WebElement extra = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[1]/div[2]/span[1]"));
        extra.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement extraCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[2]/div[2]/div[1]/div/div[1]/div/input"));
        extraCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[2]/div[2]/div[1]/div/div[4]")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }
        /*int m = 0;
        while (m < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            kostil.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }



    @Test
    @Description("Check deleted filter")
    public void CountCheckerDeleted() {
        setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");

        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        int t=0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t<80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                t++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {
            }
            workspace.click();
            break;
        } catch (Exception ex) {
        }

        /*int n = 0;
        WebElement deletedCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[7]/div[1]/div[1]/div/input"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            deletedCheckbox.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        WebElement deletedCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[7]/div[1]/div[1]/div/input"));
        deletedCheckbox.click();
        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[7]/div[1]/span")).getText();
        WebElement applyFilter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[2]/button"));
        applyFilter.click();
        try {
            //ДЕЛАЕМ
            Thread.sleep(1000);
            //1000 - 1 сек
        } catch (InterruptedException ex) {

        }
       /*int m = 0;
        while (m < 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                m++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            kostil.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"), "Идет загрузка. Пожалуйста, подождите..." ));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        tearDown();
    }

    public static void tearDown(){
//System.out.print ("Login success");
        driver.quit();
    }
}


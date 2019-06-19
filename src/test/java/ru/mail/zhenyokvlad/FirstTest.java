package ru.mail.zhenyokvlad;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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

    @Epic(value = "Проверка фасетных фильтров")

    @Test
    @Description("Проверка log in/log out")
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
            //tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по приложениям")
    @Test
    @Description("По 2му приложению")
    public void CountCheckerApplication2() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
       String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }
    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по приложениям")
    @Test
    @Description("По 1му приложению")
    public void CountCheckerApplication3() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement applications = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div[2]/span[1]"));
        applications.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement applicationCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div/input"));
       applicationCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[3]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }
    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по приложениям")
    @Test
    @Description("Прочее")
    public void CountCheckerProchee() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
       // tearDown();
    }

    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по делам")
    @Test
    @Description("По 1му делу")
    public void CountCheckerDelo1() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        System.out.print(gridCouner);
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }

    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по делам")
    @Test
    @Description("По 2му делу")
    public void CountCheckerDelo2() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement Dela = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[1]/div[2]/span[1]"));
        Dela.click();
        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement deloCheckbox2 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/input"));
        deloCheckbox2.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[2]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        System.out.print(gridCouner);
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по делам")
    @Test
    @Description("По 3му делу")
    public void CountCheckerDelo3() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement Dela = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[1]/div[2]/span[1]"));
        Dela.click();
        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement deloCheckbox3 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[3]/div/div[1]/div/input"));
        deloCheckbox3.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[3]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        System.out.print(gridCouner);
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по персонам")
    @Test
    @Description("По 1ой персоне")
    public void CountCheckerPerson1() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));

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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
       // tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по персонам")
    @Test
    @Description("По 2ой персоне")
    public void CountCheckerPerson2() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));

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
        WebElement personCheckbox2 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/input"));
        personCheckbox2.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        // tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по персонам")
    @Test
    @Description("По 3ей персоне")
    public void CountCheckerPerson3() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));

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
        WebElement personCheckbox3=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[1]/div/input"));
        personCheckbox3.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        // tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по устройствам")
    @Test
    @Description("По 1му устройству")
    public void CountCheckerDevice1() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
       //tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по устройствам")
    @Test
    @Description("По 2му устройству")
    public void CountCheckerDevice2() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement devices = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[1]/div[2]/span[1]"));
        devices.click();
        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement deviceCheckbox2 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div/input"));
        deviceCheckbox2.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по устройствам")
    @Test
    @Description("По 3му устройству")
    public void CountCheckerDevice3() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement devices = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[1]/div[2]/span[1]"));
        devices.click();
        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement deviceCheckbox3 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div/input"));
        deviceCheckbox3.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }

    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по категориям")
    @Test
    @Description("По 1ой категории")
    public void CountCheckerCategory1() {
      //  setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));

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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
      //  tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по категориям")
    @Test
    @Description("По 2ой категории")
    public void CountCheckerCategory2() {
        //  setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));

        WebElement categories = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[2]/span[1]"));
        categories.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement categoryCheckbox2 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[1]/div/input"));
        categoryCheckbox2.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //  tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по категориям")
    @Test
    @Description("По 3ей категории")
    public void CountCheckerCategory3() {
        //  setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));

        WebElement categories = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[2]/span[1]"));
        categories.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement categoryCheckbox3 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[2]/div[3]/div/div[1]/div/input"));
        categoryCheckbox3.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[2]/div[3]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //  tearDown();
    }

    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по направлениям")
    @Test
    @Description("По 1му направлению")
    public void CountCheckerDirection1() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по направлениям")
    @Test
    @Description("По 2му направлению")
    public void CountCheckerDirection2() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement directions = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/div[2]/span[1]"));
        directions.click();
        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement directionCheckbox2 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/input"));
        directionCheckbox2.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[2]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по направлениям")
    @Test
    @Description("По 3му направлению")
    public void CountCheckerDirection3() {
        //setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement directions = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/div[2]/span[1]"));
        directions.click();
        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement directionCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[3]/div/div[1]/div/input"));
        directionCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[3]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по языкам")
    @Test
    @Description("По 1му языку")
    public void CountCheckerLanguages1() {
       // setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
       // tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по языкам")
    @Test
    @Description("По 2му языку")
    public void CountCheckerLanguages2() {
        // setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement languages = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/span[1]"));
        languages.click();

        // WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement languageCheckbox2 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/input"));
        languageCheckbox2.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        // tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="Фильтр по языкам")
    @Test
    @Description("По 3му языку")
    public void CountCheckerLanguages3() {
        // setup();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement languages = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/span[1]"));
        languages.click();

        // WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement languageCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[1]/div/input"));
        languageCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[4]")).getText();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        // tearDown();
    }

    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="По информации в тексте")
    @Test
    @Description("По 1ому пункту")
    public void CountCheckerInformation1() {
       // setup();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="По информации в тексте")
    @Test
    @Description("По 2ому пункту")
    public void CountCheckerInformation2() {
        // setup();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement info = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[1]/div[2]/span[1]"));
        info.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement infoCheckbox2 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[2]/div[2]/div[2]/div/div[1]/div/input"));
        infoCheckbox2.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[2]/div[2]/div[2]/div/div[4]")).getText();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="По информации в тексте")
    @Test
    @Description("По 3му пункту")
    public void CountCheckerInformation3() {
        // setup();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement info = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[1]/div[2]/span[1]"));
        info.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement infoCheckbox3 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[2]/div[2]/div[3]/div/div[1]/div/input"));
        infoCheckbox3.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[2]/div[2]/div[3]/div/div[4]")).getText();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //tearDown();
    }

    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="По фильтру Абоненты и группы")
    @Test
    @Description("По 1му абоненту")
    public void CountCheckerAbonents1() {
        //setup();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
      //  tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="По фильтру Абоненты и группы")
    @Test
    @Description("По 2му абоненту")
    public void CountCheckerAbonents2() {
        //setup();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement abonent = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[1]/div[2]/span[1]"));
        abonent.click();

        // WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement abonentCheckbox2 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[2]/div[2]/div[2]/div/div[1]/div/input"));
        abonentCheckbox2.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[2]/div[2]/div[2]/div/div[4]")).getText();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //  tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="По фильтру Абоненты и группы")
    @Test
    @Description("По 3му абоненту")
    public void CountCheckerAbonents3() {
        //setup();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement abonent = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[1]/div[2]/span[1]"));
        abonent.click();

        // WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement abonentCheckbox3 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[2]/div[2]/div[3]/div/div[1]/div/input"));
        abonentCheckbox3.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[2]/div[2]/div[3]/div/div[4]")).getText();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //  tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="По фильтру дополнительные свойства")
    @Test
    @Description("По 1му дополнительному свойству")
    public void CountCheckerExtraProperties1() {
      //  setup();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
      //  tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="По фильтру дополнительные свойства")
    @Test
    @Description("По 2му дополнительному свойству")
    public void CountCheckerExtraProperties2() {
        //  setup();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement extra = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[1]/div[2]/span[1]"));
        extra.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement extraCheckbox = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[2]/div[2]/div[2]/div/div[1]/div/input"));
        extraCheckbox.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[2]/div[2]/div[2]/div/div[4]")).getText();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //  tearDown();
    }


    @Epic(value = "Проверка фасетных фильтров")
    @Feature(value="По фильтру дополнительные свойства")
    @Test
    @Description("По 3му дополнительному свойству")
    public void CountCheckerExtraProperties3() {
        //  setup();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement extra = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[1]/div[2]/span[1]"));
        extra.click();

        //WebElement kostil= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[1]/div/nav/li[1]/span"));
        WebElement extraCheckbox3 = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[2]/div[2]/div[3]/div/div[1]/div/input"));
        extraCheckbox3.click();
        String sidebarCounter = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[2]/div[2]/div[3]/div/div[4]")).getText();
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
        //  tearDown();
    }

    @Epic(value = "Проверка фасетных фильтров")
    @Test
    @Description("Фильтр по удаленным")
    public void CountCheckerDeleted() {
       // setup();
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String gridCouner = driver.findElement(By.className("app-content-title-count")).getText();
        attachScreenshot();
        Assert.assertEquals(sidebarCounter, gridCouner);
       // tearDown();
    }


    @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}


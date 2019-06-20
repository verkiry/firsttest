package ru.mail.zhenyokvlad;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class quickfilterTest {
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


    @Epic(value = "Проверка квикфильтров")
    @Test
    @Description("Квикфильтр в Дела")
    public void QuickfilterCases() {

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
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement Cases = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[1]/div[2]/span[1]"));
        Cases.click();
        String thirdcasename= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[3]/div/div[2]/span[2]")).getText();
        WebElement intert=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[1]/div/div/input"));
        intert.sendKeys(thirdcasename);
        String firstcasename= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[1]/div/div[2]/span[2]")).getText();
        attachScreenshot();
        Assert.assertThat(firstcasename, CoreMatchers.containsString(thirdcasename));

    }

    @Epic(value = "Проверка квикфильтров")
    @Test
    @Description("Квикфильтр в Персоны")
    public void QuickfilterPersons() {

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
        WebElement Persons = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[2]/span[1]"));
        while (n< 40) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            Persons.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement Persons = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[2]/span[1]"));
        Persons.click();
        String thirdpersonname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[2]/span[2]")).getText();
        WebElement intert=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/input"));
        intert.sendKeys(thirdpersonname);
        String firstpersonname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[2]/span[2]")).getText();
        attachScreenshot();
        Assert.assertThat(firstpersonname, CoreMatchers.containsString(thirdpersonname));

    }


    @Epic(value = "Проверка квикфильтров")
    @Test
    @Description("Квикфильтр в Устройства")
    public void QuickfilterDevices() {

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
        WebElement Devices = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[1]/div[2]/span[1]"));
        while (n< 40) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            Devices.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement Devices = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[1]/div[2]/span[1]"));
        Devices.click();
        String thirddevicename= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[2]/span[2]")).getText();
        WebElement intert=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[1]/div[1]/div/div/input"));
        intert.sendKeys(thirddevicename);
        String firstdevicename= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div/div[2]/span[2]")).getText();
        attachScreenshot();
        Assert.assertThat(firstdevicename, CoreMatchers.containsString(thirddevicename));

    }


    @Epic(value = "Проверка квикфильтров")
    @Test
    @Description("Квикфильтр в Категории")
    public void QuickfilterCategory() {

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
        WebElement Categories = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[2]/span[1]"));
        while (n< 40) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            Categories.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement Categories = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[2]/span[1]"));
        Categories.click();
        String thirdcategoryname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[2]/div[3]/div/div[2]/span[3]")).getText();
        WebElement intert=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[1]/div[1]/div/div/input"));
        intert.sendKeys(thirdcategoryname);
        String firstcategoryname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[2]/div[1]/div/div[2]/span[3]")).getText();
        attachScreenshot();
        Assert.assertThat(firstcategoryname, CoreMatchers.containsString(thirdcategoryname));

    }

    @Epic(value = "Проверка квикфильтров")
    @Test
    @Description("Квикфильтре в Направления")
    public void QuickfilterDirection() {

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
        WebElement Directions = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/div[2]/span[1]"));
        while (n< 40) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            Directions.click();
            break;
        } catch (Exception ex) {
        }
        */
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement Directions = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/div[2]/span[1]"));
        Directions.click();
        String thirddirectionname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[3]/div/div[2]/span[2]")).getText();
        WebElement intert=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/input"));
        intert.sendKeys(thirddirectionname);
        String firstdirectionname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div/div[2]/span[2]")).getText();
        attachScreenshot();
        Assert.assertThat(firstdirectionname, CoreMatchers.containsString(thirddirectionname));

    }

    @Epic(value = "Проверка квикфильтров")
    @Test
    @Description("Квикфильтр в Языки")
    public void QuickfilterLanguages() {

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
        WebElement Languages = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/span[1]"));
        while (n< 40) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            Languages.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement Languages = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/span[1]"));
        Languages.click();
        String thirdlanguagename= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[2]/span[2]")).getText();
        WebElement intert=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[1]/div/div/input"));
        intert.sendKeys(thirdlanguagename);
        String firstlanguagename= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[1]/div/div[2]/span[2]")).getText();
        attachScreenshot();
        Assert.assertThat(firstlanguagename, CoreMatchers.containsString(thirdlanguagename));

    }

    @Epic(value = "Проверка квикфильтров")
    @Test
    @Description("Квикфильтр в Приложения")
    public void QuickfilterApplications() {

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
        WebElement Applications = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div[2]/span[1]"));
        while (n< 40) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            Applications.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement Applications = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div[2]/span[1]"));
        Applications.click();
        String thirdapplicationname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[3]/div/div[2]/span[2]")).getText();
        WebElement intert=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[1]/div[1]/div/div/input"));
        intert.sendKeys(thirdapplicationname);
        String firstapplicationname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[1]/div/div[2]/span[2]")).getText();
        attachScreenshot();
        Assert.assertThat(firstapplicationname, CoreMatchers.containsString(thirdapplicationname));

    }

    @Epic(value = "Проверка квикфильтров")
    @Test
    @Description("Квикфильтр в Информация в тексте")
    public void QuickfilterInformation() {

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
        WebElement Information = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[1]/div[2]/span[1]"));
        while (n< 40) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            Information.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement Information = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[1]/div[2]/span[1]"));
        Information.click();
        String thirdinformationname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[2]/div[2]/div[3]/div/div[2]/span[2]")).getText();
        WebElement intert=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[2]/div[1]/div[1]/div/div/input"));
        intert.sendKeys(thirdinformationname);
        String firstinformationname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[2]/div[2]/div[1]/div/div[2]/span[2]")).getText();
        attachScreenshot();
        Assert.assertThat(firstinformationname, CoreMatchers.containsString(thirdinformationname));

    }

    @Epic(value = "Проверка квикфильтров")
    @Test
    @Description("Квикфильтр в Абоненты и группы")
    public void QuickfilterAbonent() {

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
        String thirdabonentname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[2]/div[2]/div[3]/div/div[2]/span[2]")).getText();
        WebElement intert=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[2]/div[1]/div[1]/div/div/input"));
        intert.sendKeys(thirdabonentname);
        String firstabonentname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[2]/div[2]/div[1]/div/div[2]/span[2]")).getText();
        attachScreenshot();
        Assert.assertThat(firstabonentname, CoreMatchers.containsString(thirdabonentname));

    }

    @Epic(value = "Проверка квикфильтров")
    @Test
    @Description("Квикфильтр в Дополнительные свойства")
    public void QuickfilterProperty() {

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
        WebElement properties = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[1]/div[2]/span[1]"));
        while (n< 80) try {
            try {
                //ДЕЛАЕМ
                Thread.sleep(500);
                n++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {

            }
            properties.click();
            break;
        } catch (Exception ex) {
        }
*/
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement properties = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[1]/div[2]/span[1]"));
        properties.click();
        String thirdpropertyname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[2]/div[2]/div[3]/div/div[2]/span[2]")).getText();
        WebElement intert=driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[2]/div[1]/div[1]/div/div/input"));
        intert.sendKeys(thirdpropertyname);
        String firstpropertyname= driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[2]/div[2]/div[1]/div/div[2]/span[2]")).getText();
        attachScreenshot();
        Assert.assertThat(firstpropertyname, CoreMatchers.containsString(thirdpropertyname));

    }


}

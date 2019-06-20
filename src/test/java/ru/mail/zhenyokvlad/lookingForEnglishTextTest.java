package ru.mail.zhenyokvlad;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class lookingForEnglishTextTest {
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
//System.out.print ("Login success");
        driver.quit();
    }
    @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Epic(value = "Поиск непереведенных фильтров")
    @Feature(value = "Категории")
    @Test
    public void lookingInCategories() {
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

        WebElement categories = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[2]/span[1]"));
        categories.click();
        List<WebElement> Texts = driver.findElements(By.xpath("//html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[2]//span[@class='text-overflow']"));
        int amountofelements = Texts.size();
        for (int i = 0; i < amountofelements; i++) {
            String text = Texts.get(i).getText();
            Boolean isenglish = checkLanguage.checker(Texts.get(i).getText());
            if (isenglish == true)
                Allure.addAttachment("Непереведенный фильтр Категории -> "+text, text);
        }

    }

    @Epic(value = "Поиск непереведенных фильтров")
    @Feature(value = "Направления")
    @Test
    public void lookingInDirections() {
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

        WebElement directions = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/div[2]/span[1]"));
        directions.click();
        List<WebElement> Texts = driver.findElements(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]//span[@class='text-overflow']"));
        int amountofelements = Texts.size();
        for (int i = 0; i < amountofelements; i++) {
            String text = Texts.get(i).getText();
            Boolean isenglish = checkLanguage.checker(Texts.get(i).getText());
            if (isenglish == true)
                Allure.addAttachment("Непереведенный фильтр Направления -> " + text, text);
        }

    }

    @Epic(value = "Поиск непереведенных строк в фильтре Категории")
    @Test
    public void lookingInSubCategories() {
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

        WebElement categories = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[2]/span[1]"));
        categories.click();
        List<WebElement> categoriesWithCombobox = driver.findElements(By.xpath("//div[@class='b-filterItem_head']//span[@class='b-filterItem_arrow f_chO']"));
        List<WebElement> categoriesWithComboboxNames = driver.findElements(By.xpath("//div[@class='b-filterItem_head']//span[@class='b-filterItem_arrow f_chO']/../span[@class='text-overflow']"));
        int amountOfCategories = categoriesWithCombobox.size();
        for (int i = 0; i < amountOfCategories; i++) {
            String categoryName = categoriesWithComboboxNames.get(i).getText();
            categoriesWithCombobox.get(i).click();
            List<WebElement> categoriesInsideCombobox = driver.findElements(By.xpath("//div[@class='b-filterItem_head']//span[@class='b-filterItem_arrow f_chO']/../../../..//div[@class='bvar_dropdown f_chB']//span[@class='text-overflow']"));
            int amountOfCategoriesInsideCombobox = categoriesInsideCombobox.size();
            for (int j = 0; j < amountOfCategoriesInsideCombobox; j++) {
                String categoryText = categoriesInsideCombobox.get(j).getText();
                Boolean isenglish = checkLanguage.checker(categoryText);
                if (isenglish == true) {
                    Allure.addAttachment("Непереведенный фильтрв в Категории ->" + categoryName + " -> " + categoryText, "непереведенная подкатегория " + categoryName + " в категории " + categoryText);
                    attachScreenshot();
                }
            }

        }



    }
}
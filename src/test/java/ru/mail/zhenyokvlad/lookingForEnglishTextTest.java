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
        driver.get("http://192.168.4.222//login");
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
        int amountOfMistakes=0;
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
      //залогинились

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
            workspace.click();
            break;
        } catch (Exception ex) {
        }

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        //ждем, пока пропадет прелоадер и можно будет продолжать работу

        WebElement categories = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[2]/span[1]"));
        categories.click();
        //нашли и кликнули на стрелочку у фильтра Категории
        List<WebElement> Texts = driver.findElements(By.xpath("//html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[2]//span[@class='text-overflow']"));
        //получили список пунктов внутри фильтра Категории
        int amountofelements = Texts.size();
        //проверяем все пункты
        for (int i = 0; i < amountofelements; i++) {
            String text = Texts.get(i).getText(); //получаем текст внутри пункта
            Boolean isenglish = checkLanguage.checker(Texts.get(i).getText()); //проверяем, полностью ли текст на английском
            if (isenglish == true)
                Allure.addAttachment("Непереведенный фильтр Категории -> "+text, text); //если поностью на английском, заносим это в отчет
            amountOfMistakes++;
        }
        Assert.assertEquals(amountOfMistakes,0);
    }

    @Epic(value = "Поиск непереведенных фильтров")
    @Feature(value = "Направления")
    @Test
    public void lookingInDirections() {
        int amountOfMistakes=0;
        //данный тест работает аналогично тесту по категориям
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
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
            amountOfMistakes++;
        }
        Assert.assertEquals(amountOfMistakes,0);
    }

    @Epic(value = "Поиск непереведенных фильтров")
    @Feature(value = "Подфильтры в Категории")
    @Test
    public void lookingInSubCategories() {
        int amountOfMistakes=0;
        //тут проверяем подкатегории в фильтре Категории
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        //залогинились
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
            //
            workspace.click();
            break;
        } catch (Exception ex) {
        }
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        //зашли в воркспейс и ждем, пока пропадет прелоадер, чтобы продолжить работу
        WebElement categories = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[2]/span[1]"));
        categories.click();
        //нашли и кликнули по стрелочке у фильтра Категории
        List<WebElement> categoriesWithCombobox = driver.findElements(By.xpath("//div[@class='b-filterItem_head']//span[@class='b-filterItem_arrow f_chO']"));
        //получаем список пунктов с комбобоксами (стрелочками)
        List<WebElement> categoriesWithComboboxNames = driver.findElements(By.xpath("//div[@class='b-filterItem_head']//span[@class='b-filterItem_arrow f_chO']/../span[@class='text-overflow']"));
        //список имен пунктов с комбобоксами
        int amountOfCategories = categoriesWithCombobox.size();
        for (int i = 0; i < amountOfCategories; i++) { //для всех пунтов с комбобоксами (для всех имеющих выпадающие списки)
            String categoryName = categoriesWithComboboxNames.get(i).getText(); //записали имя текущего пункта
            categoriesWithCombobox.get(i).click(); //кликнули на комбобокс, раскрыли выпадающий список
            List<WebElement> categoriesInsideCombobox = driver.findElements(By.xpath("//div[@class='b-filterItem_head']//span[@class='b-filterItem_arrow f_chO']/../../../..//div[@class='bvar_dropdown f_chB']//span[@class='text-overflow']"));
            //получили список пунктов из выпадающего списка
            int amountOfCategoriesInsideCombobox = categoriesInsideCombobox.size();
            for (int j = 0; j < amountOfCategoriesInsideCombobox; j++) { //все пункты из выпадающего списка проверили на наличие перевода
                String categoryText = categoriesInsideCombobox.get(j).getText();
                Boolean isenglish = checkLanguage.checker(categoryText);
                if (isenglish == true) {
                    Allure.addAttachment("Непереведенный фильтрв в Категории ->" + categoryName + " -> " + categoryText, "непереведенная подкатегория " + categoryName + " в категории " + categoryText);
                    attachScreenshot();
                    amountOfMistakes++;
                }
            }

        }

        Assert.assertEquals(amountOfMistakes,0);

    }
}
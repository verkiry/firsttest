package ru.mail.zhenyokvlad;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class searchTest {
    private static WebDriver driver;

    @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

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

    @Epic(value = "Проверка поиска по описанию")
    @Test
    public void SearchCheck() {
        //setup();
        int amountOfMistakes=0;
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
            // WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
            workspace.click();
            break;
        } catch (Exception ex) {
        }
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        WebElement selectElem = driver.findElement(By.xpath("//select[@name='sizePage']"));
        Select select = new Select(selectElem);
        selectElem.click();
        select.selectByVisibleText("100 на странице");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        String [] wordsToCheck={"вечер", "утро", "деньги", "лом", "компьютер", "байт", "бит", "высок", "река", "фонд", "валюта", "банк", "12345", "8916", "8910", "8922", "1999", "1991", "777", "776", "3351", "0000001", "1111111", "0@gmail.com", "@@", "///", "**", "0$", "€", "?!", "!!!", "{}", "[]", "2+2", "Anna", "Jim", "Ben", "room", "mate", "police", "fire", "male", "female", "zoo", "DRUGS", "RUSSIA", "Rome", "lil", "meme", "food", "cage", "lord", "of the b", "have no", "Nexus", "mail.ru", "none", "calm"};
        //тестовая выборка слов для поиска
        int randNumber=(int) (Math.random() * wordsToCheck.length);
        String checkword = wordsToCheck[randNumber]; //берем случайное слово из тестовой выборки
        WebElement searchfield = driver.findElement(By.id("searchInput"));
        searchfield.sendKeys(checkword);
        searchfield.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait2 = new WebDriverWait(driver, 80);
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"))); //ждем закрытия прелоадера
        String amountOfPagesString = driver.findElement(By.xpath("//*[@id=\"ws-grid-pg\"]/div/div[2]/span[2]")).getText();
        int amountOfPages = Integer.parseInt(amountOfPagesString);

        for (int r = 0; r < amountOfPages; r++) {
            List<WebElement> strings = driver.findElements(By.xpath("//div[@class='app-mailBox-item-link']"));
            for (int j = 0; j < strings.size(); j++) {
                ArrayList<String> fromtodescription = new ArrayList<String>();
                try {
                    fromtodescription.add(strings.get(j).findElement(By.xpath("./div[@class='app-mailBox-item-link-desc app-mailBox-desc']/div[@class='app-mailBox-item-link-desc-item'][1]//div[@class='app-mailBox-item-link-desc-item-info-text']")).getAttribute("innerText"));
                } catch (NoSuchElementException e) {
                }
                if (fromtodescription.get(0).toLowerCase().contains(checkword.toLowerCase()) == false) {
                    try {
                        List<WebElement> fromto = strings.get(j).findElements(By.xpath("./div[@class='app-mailBox-item-link-info app-mailBox-type']//div[@class='app-mailBox-item-link-info-user-name-text']"));
                        System.out.println(fromto.size());
                        ArrayList<String> fromToString = new ArrayList<String>();
                        for (int m = 0; m < fromto.size(); m++) {
                            fromToString.add(fromto.get(m).getAttribute("innerText"));
                        }
                        fromtodescription.addAll(fromToString);
                    } catch (NoSuchElementException e) {
                    }
                    // }
                }
                int counter = 0;
                for (int l = 0; l < fromtodescription.size(); l++) {
                    if (fromtodescription.get(l).toLowerCase().contains(checkword.toLowerCase()) == false) {
                        counter++;
                    }
                }
                if (counter == fromtodescription.size()) {
                    amountOfMistakes++;
                    strings.get(j).click();
                    Allure.addAttachment("Неверный результат поиска по слову " + checkword, "строка номер "+ j);
                    attachScreenshot();
                }
            }
            WebElement nextButton= driver.findElement(By.xpath("//a[@class='app-pagination-arrow-next']"));
            nextButton.click();
            try {
                Thread.sleep(700);
                t++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {
            }
        }
        Assert.assertEquals(amountOfMistakes,0);
    }
}

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
import org.openqa.selenium.support.ui.Select;
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
        int amountOfKeToSet=3; //количество КЕ, которое будем устанавливать в рамках теста
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER); //залогинились
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
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        //ждем закрытия прелоадера
        WebElement selectElem = driver.findElement(By.xpath("//select[@name='sizePage']"));
        Select select = new Select(selectElem);
        selectElem.click();
        select.selectByVisibleText("100 на странице"); //отображаем 100 записей на странице
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        String KECounter=driver.findElement(By.xpath("//span[@title='Ключевые доказательства']/../..//span[@class='b-filterItem_count f_count']")).getAttribute("innerText");
        int KEAmountBeforeRefresh=Integer.parseInt(KECounter); //получили количество КЕ из счетчика на сайдбаре
        List<WebElement> strings = driver.findElements(By.xpath("//div[@class='app-mailBox-item-link']")); //записи на текущей странице
        int counterOfSetKe=0;
        List<Integer> numberOfKeString = new ArrayList<Integer>();
        for (int i=0; i<strings.size(); i++){
            if (counterOfSetKe<amountOfKeToSet) {
                System.out.println(i);
                try {
                    strings.get(i).findElement(By.xpath(".//div[@class='app-mailBox-item-link-favourit-icon ']")).click(); //ищем серую звездочку, если находим-кликаем
                    counterOfSetKe++;
                    numberOfKeString.add(i); //запоминаем номер строки, где кликнули
                } catch (NoSuchElementException e) {
                }
            }
        }
        driver.navigate().refresh(); //обновляем страницу
        WebDriverWait wait2 = new WebDriverWait(driver, 40);
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        //ждем исчезновение прелоадера, чтобы продолжить работу
        List<WebElement> stringsAfterRefresh = driver.findElements(By.xpath("//div[@class='app-mailBox-item-link']")); //записи на текущей странице
        String KECounterAfter=driver.findElement(By.xpath("//span[@title='Ключевые доказательства']/../..//span[@class='b-filterItem_count f_count']")).getAttribute("innerText"); //счетчик КЕ после перезагрузки
        int KEAmountAfterRefresh=Integer.parseInt(KECounterAfter); //получили количество КЕ из счетчика на сайдбаре после перезагрузки
        int errorCounter=0;
        for (int l=0; l<numberOfKeString.size(); l++){
            try {
                stringsAfterRefresh.get(numberOfKeString.get(l)).findElement(By.xpath(".//div[@class='app-mailBox-item-link-favourit-icon active']")).click(); //проверяем, есть ли активная звездочка у строк, номера которых записали. Если есть- снимаем, чтобы после теста ничего за собой не оставить
            } catch (NoSuchElementException e){
                errorCounter++; //если активной звездочки нет- ошибка
            }
        }
        int amountOfFailedTests=0;
        if (KEAmountAfterRefresh!=KEAmountBeforeRefresh+amountOfKeToSet){ //если счетчик на сайдбаре после обновления не равен счетчик до обновления + количество установленных в рамках теста КЕ- ошибка
            Allure.addAttachment("Врет счетчик КЕ на сайдбаре", "Было "+KEAmountBeforeRefresh+ " KE, " + "установили " + amountOfKeToSet + ", а счетчик на сайдбаре указывает "+KEAmountAfterRefresh);
            attachScreenshot();
            amountOfFailedTests++;
        }
        if (errorCounter!=0){ //если хоть у одной из записей, куда ставили КЕ, после обновления страницы КЕ не активно- ошибка
            Allure.addAttachment("КЕ пропали или съехали после обновления страницы", " ");
            attachScreenshot();
            amountOfFailedTests++;
        }
        Assert.assertEquals(0,amountOfFailedTests); //если не прошла хотя бы одна из двух проверок- Test Failed
    }
}

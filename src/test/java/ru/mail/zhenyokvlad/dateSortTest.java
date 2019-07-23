package ru.mail.zhenyokvlad;
import io.qameta.allure.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class dateSortTest {
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

    @Epic(value = "Проверка сортировки по дате")
    @Feature(value = "Проверка сортировки в Дела по возрастанию")
    @Test
    public void SortAscending() {
        //setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
//        int t = 0;
//        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
//        while (t < 80) try { //входим в воркспейс
//            try {
//                Thread.sleep(500);
//                t++;
//            } catch (InterruptedException ex) {
//            }
//            workspace.click();
//            break;
//        } catch (Exception ex) {
//        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"))); //ждем закрытия прелоадера
        DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        WebElement selectElem= driver.findElement(By.xpath("//select[@name='sizePage']"));
        Select select=new Select(selectElem);
        selectElem.click();
        select.selectByVisibleText("100 на странице");
        WebElement sortingButton=driver.findElement(By.xpath("//div[contains(text(), 'Дата создания')]"));
        sortingButton.click();
        List<WebElement> strings=driver.findElements(By.xpath("//div[@class='eventsContent-link']"));
        List<WebElement> texts=driver.findElements(By.xpath("//div[@class='text-overflow']"));
        int amountOfLines= texts.size()/4;
        String [] dates=new String[amountOfLines];
        List<WebElement> elementswithtext= driver.findElements(By.xpath("//div[@class='text-overflow']"));
        System.out.println(elementswithtext.size());
        int start=3;
        for (int i=0; i<amountOfLines; i++){
            dates[i]=elementswithtext.get(start).getAttribute("innerText");
            start=start+4;
        }
        for (int j=0; j<amountOfLines-1; j++) {
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = dateFormat.parse(dates[j]);
            } catch (ParseException e) {
            }
            try {
                date2 = dateFormat.parse(dates[j + 1]);
            } catch (ParseException e) {
            }
            if (date1.before(date2) == false && dates[j].equals(dates[j+1])==false) {
                Allure.addAttachment("Неверная сортировка по возрастанию", "Дата"+ " "+ dates[j]+ " перед " + dates[j+1]);
                strings.get(j).click();
                attachScreenshot();
                System.out.println(dates[j+1]);
                Assert.assertEquals(date1.before(date2), true);
            }
        }
    }
    @Test
    @Epic(value = "Проверка сортировки по дате")
    @Feature(value = "Проверка сортировки в Дела по убыванию")
    public void SortDescending() {
        //setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
//        int t = 0;
//        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
//        while (t < 80) try { //входим в воркспейс
//            try {
//                Thread.sleep(500);
//                t++;
//            } catch (InterruptedException ex) {
//            }
//            workspace.click();
//            break;
//        } catch (Exception ex) {
//        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"))); //ждем закрытия прелоадера
        DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        WebElement selectElem= driver.findElement(By.xpath("//select[@name='sizePage']"));
        Select select=new Select(selectElem);
        selectElem.click();
        select.selectByVisibleText("100 на странице");
        WebElement sortingButton=driver.findElement(By.xpath("//div[contains(text(), 'Дата создания')]"));
        sortingButton.click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        sortingButton.click();
        List<WebElement> strings=driver.findElements(By.xpath("//div[@class='eventsContent-link']"));
        List<WebElement> texts=driver.findElements(By.xpath("//div[@class='text-overflow']"));
        int amountOfLines= texts.size()/4;
        String [] dates=new String[amountOfLines];
        List<WebElement> elementswithtext= driver.findElements(By.xpath("//div[@class='text-overflow']"));
        System.out.println(elementswithtext.size());
        int start=3;
        for (int i=0; i<amountOfLines; i++){
            dates[i]=elementswithtext.get(start).getAttribute("innerText");
            start=start+4;
        }
        for (int j=0; j<amountOfLines-1; j++) {
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = dateFormat.parse(dates[j]);
            } catch (ParseException e) {
            }
            try {
                date2 = dateFormat.parse(dates[j + 1]);
            } catch (ParseException e) {
            }
            if (date1.after(date2) == false && dates[j].equals(dates[j+1])==false) {
                Allure.addAttachment("Неверная сортировка по убыванию", "Дата"+ " "+ dates[j]+ " перед " + dates[j+1]);
                strings.get(j).click();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                }
                attachScreenshot();
                System.out.println(dates[j+1]);
                Assert.assertEquals(date1.after(date2), true);
            }
        }
    }

    @Test
    @Epic(value = "Проверка сортировки по дате")
    @Feature(value = "Проверка сортировки в Устройства Даты создания по убыванию")
    public void SortDevicesCreationDateDescending() {
        //setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
//        int t = 0;
//        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
//        while (t < 80) try { //входим в воркспейс
//            try {
//                Thread.sleep(500);
//                t++;
//            } catch (InterruptedException ex) {
//            }
//            workspace.click();
//            break;
//        } catch (Exception ex) {
//        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        //ждем закрытия прелоадера
        driver.get("http://192.168.4.222/devices");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        WebElement selectElem= driver.findElement(By.xpath("//select[@name='sizePage']"));
        Select select=new Select(selectElem);
        selectElem.click();
        select.selectByVisibleText("100 на странице");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        WebElement sortingButton=driver.findElement(By.xpath("//div[contains(text(), 'Дата создания') and @class='eventsHeader-label']"));
        sortingButton.click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        sortingButton.click();
        List<WebElement> strings=driver.findElements(By.xpath("//div[@class='eventsContent-link']"));
        List<WebElement> texts=driver.findElements(By.xpath("//div[@class='text-overflow']"));
        int amountOfLines= texts.size()/5;
        String [] dates=new String[amountOfLines];
        List<WebElement> elementswithtext= driver.findElements(By.xpath("//div[@class='text-overflow']"));
        System.out.println(elementswithtext.size());
        int start=3;
        for (int i=0; i<amountOfLines; i++){
            dates[i]=elementswithtext.get(start).getAttribute("innerText");
            start=start+5;
        }
        for (int j=0; j<amountOfLines-1; j++) {
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = dateFormat.parse(dates[j]);
            } catch (ParseException e) {
            }
            try {
                date2 = dateFormat.parse(dates[j + 1]);
            } catch (ParseException e) {
            }
            if (date1.after(date2) == false && dates[j].equals(dates[j+1])==false) {
                Allure.addAttachment("Неверная сортировка по убыванию", "Дата"+ " "+ dates[j]+ " перед " + dates[j+1]);
                strings.get(j).click();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                }
                attachScreenshot();
                System.out.println(date1);
                System.out.println(dates[j]);
                Assert.assertEquals(date1.after(date2), true);
            }
        }
    }

    @Test
    @Epic(value = "Проверка сортировки по дате")
    @Feature(value = "Проверка сортировки в Устройства Даты создания по возрастанию")
    public void SortDevicesCreationDateAscending() {
        //setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
//        int t = 0;
//        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
//        while (t < 80) try { //входим в воркспейс
//            try {
//                Thread.sleep(500);
//                t++;
//            } catch (InterruptedException ex) {
//            }
//            workspace.click();
//            break;
//        } catch (Exception ex) {
//        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        //ждем закрытия прелоадера
        driver.get("http://192.168.4.222/devices");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        WebElement selectElem= driver.findElement(By.xpath("//select[@name='sizePage']"));
        Select select=new Select(selectElem);
        selectElem.click();
        select.selectByVisibleText("100 на странице");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        WebElement sortingButton=driver.findElement(By.xpath("//div[contains(text(), 'Дата создания') and @class='eventsHeader-label']"));
        sortingButton.click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        List<WebElement> strings=driver.findElements(By.xpath("//div[@class='eventsContent-link']"));
        List<WebElement> texts=driver.findElements(By.xpath("//div[@class='text-overflow']"));
        int amountOfLines= texts.size()/5;
        String [] dates=new String[amountOfLines];
        List<WebElement> elementswithtext= driver.findElements(By.xpath("//div[@class='text-overflow']"));
        System.out.println(elementswithtext.size());
        int start=3;
        for (int i=0; i<amountOfLines; i++){
            dates[i]=elementswithtext.get(start).getAttribute("innerText");
            start=start+5;
        }
        for (int j=0; j<amountOfLines-1; j++) {
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = dateFormat.parse(dates[j]);
            } catch (ParseException e) {
            }
            try {
                date2 = dateFormat.parse(dates[j + 1]);
            } catch (ParseException e) {
            }
            if (date1.before(date2) == false && dates[j].equals(dates[j+1])==false) {
                Allure.addAttachment("Неверная сортировка по возрастанию", "Дата"+ " "+ dates[j]+ " перед " + dates[j+1]);
                strings.get(j).click();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                }
                attachScreenshot();
                System.out.println(date1);
                System.out.println(dates[j]);
                Assert.assertEquals(date1.before(date2), true);
            }
        }
    }

    @Test
    @Epic(value = "Проверка сортировки по дате")
    @Feature(value = "Проверка сортировки в Устройства Даты загрузки по убыванию")
    public void SortDevicesDownloadDateDescending() {
        //setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
//        int t = 0;
//        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
//        while (t < 80) try { //входим в воркспейс
//            try {
//                Thread.sleep(500);
//                t++;
//            } catch (InterruptedException ex) {
//            }
//            workspace.click();
//            break;
//        } catch (Exception ex) {
//        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        //ждем закрытия прелоадера
        driver.get("http://192.168.4.222/devices");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        WebElement selectElem= driver.findElement(By.xpath("//select[@name='sizePage']"));
        Select select=new Select(selectElem);
        selectElem.click();
        select.selectByVisibleText("100 на странице");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        WebElement sortingButton=driver.findElement(By.xpath("//div[contains(text(), 'Дата загрузки') and @class='eventsHeader-label']"));
        sortingButton.click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        sortingButton.click();
        List<WebElement> strings=driver.findElements(By.xpath("//div[@class='eventsContent-link']"));
        List<WebElement> texts=driver.findElements(By.xpath("//div[@class='text-overflow']"));
        int amountOfLines= texts.size()/5;
        String [] dates=new String[amountOfLines];
        List<WebElement> elementswithtext= driver.findElements(By.xpath("//div[@class='text-overflow']"));
        System.out.println(elementswithtext.size());
        int start=4;
        for (int i=0; i<amountOfLines; i++){
            dates[i]=elementswithtext.get(start).getAttribute("innerText");
            start=start+5;
        }
        for (int j=0; j<amountOfLines-1; j++) {
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = dateFormat.parse(dates[j]);
            } catch (ParseException e) {
            }
            try {
                date2 = dateFormat.parse(dates[j + 1]);
            } catch (ParseException e) {
            }
            if (date1.after(date2) == false && dates[j].equals(dates[j+1])==false) {
                Allure.addAttachment("Неверная сортировка по убыванию", "Дата"+ " "+ dates[j]+ " перед " + dates[j+1]);
                strings.get(j).click();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                }
                attachScreenshot();
                System.out.println(date1);
                System.out.println(dates[j]);
                Assert.assertEquals(date1.after(date2), true);
            }
        }
    }

    @Test
    @Epic(value = "Проверка сортировки по дате")
    @Feature(value = "Проверка сортировки в Устройства Даты загрузки по возрастанию")
    public void SortDevicesDownloadDateAscending() {
        //setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
//        int t = 0;
//        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
//        while (t < 80) try { //входим в воркспейс
//            try {
//                Thread.sleep(500);
//                t++;
//            } catch (InterruptedException ex) {
//            }
//            workspace.click();
//            break;
//        } catch (Exception ex) {
//        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        //ждем закрытия прелоадера
        driver.get("http://192.168.4.222/devices");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        WebElement selectElem= driver.findElement(By.xpath("//select[@name='sizePage']"));
        Select select=new Select(selectElem);
        selectElem.click();
        select.selectByVisibleText("100 на странице");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        WebElement sortingButton=driver.findElement(By.xpath("//div[contains(text(), 'Дата загрузки') and @class='eventsHeader-label']"));
        sortingButton.click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        List<WebElement> strings=driver.findElements(By.xpath("//div[@class='eventsContent-link']"));
        List<WebElement> texts=driver.findElements(By.xpath("//div[@class='text-overflow']"));
        int amountOfLines= texts.size()/5;
        String [] dates=new String[amountOfLines];
        List<WebElement> elementswithtext= driver.findElements(By.xpath("//div[@class='text-overflow']"));
        System.out.println(elementswithtext.size());
        int start=4;
        for (int i=0; i<amountOfLines; i++){
            dates[i]=elementswithtext.get(start).getAttribute("innerText");
            start=start+5;
        }
        for (int j=0; j<amountOfLines-1; j++) {
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = dateFormat.parse(dates[j]);
            } catch (ParseException e) {
            }
            try {
                date2 = dateFormat.parse(dates[j + 1]);
            } catch (ParseException e) {
            }
            if (date1.before(date2) == false && dates[j].equals(dates[j+1])==false) {
                Allure.addAttachment("Неверная сортировка по возрастанию", "Дата"+ " "+ dates[j]+ " перед " + dates[j+1]);
                strings.get(j).click();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                }
                attachScreenshot();
                System.out.println(date1);
                System.out.println(dates[j]);
                Assert.assertEquals(date1.before(date2), true);
            }
        }
    }
}

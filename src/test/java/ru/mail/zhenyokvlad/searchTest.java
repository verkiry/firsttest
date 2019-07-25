package ru.mail.zhenyokvlad;

import io.qameta.allure.*;
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

    @Epic(value = "Проверка поиска")
    @Feature(value="Проверка поиска по описанию в Рабочем пространстве")
    @Test
    public void WorkspaceSearchCheck() {
        //setup();
        int amountOfMistakes=0;
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
            // WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
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
        String [] wordsToCheck={"вечер", "утро", "деньги", "лом", "компьютер", "байт", "бит", "высок", "река", "фонд", "валюта", "банк", "12345", "8916", "8910", "8922", "1999", "1991", "777", "776", "3351", "0000001", "1111111", "0@gmail.com", "@@", "///", "**", "0$", "€", "?!", "!!!", "{}", "[]", "2+2", "Anna", "Jim", "Ben", "room", "mate", "police", "fire", "male", "female", "zoo", "DRUGS", "RUSSIA", "Rome", "lil", "meme", "food", "cage", "lord", "of the b", "have no", "Nexus", "mail.ru", "none", "calm"};
        //тестовая выборка слов для поиска
        int randNumber=(int) (Math.random() * wordsToCheck.length);
        String checkword = wordsToCheck[randNumber]; //берем случайное слово из тестовой выборки
        WebElement searchfield = driver.findElement(By.id("searchInput"));
        searchfield.sendKeys(checkword);
        searchfield.sendKeys(Keys.ENTER); //ввели полученное слово в строку поиска и нажали Enter
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait2 = new WebDriverWait(driver, 80);
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"))); //ждем закрытия прелоадера
        String amountOfPagesString = driver.findElement(By.xpath("//*[@id=\"ws-grid-pg\"]/div/div[2]/span[2]")).getText();
        int amountOfPages = Integer.parseInt(amountOfPagesString); //количество страниц

        for (int r = 0; r < amountOfPages; r++) {
            List<WebElement> strings = driver.findElements(By.xpath("//div[@class='app-mailBox-item-link']")); //количество записей на текущей странице
            for (int j = 0; j < strings.size(); j++) {
                ArrayList<String> fromtodescription = new ArrayList<String>();
                try {
                    fromtodescription.add(strings.get(j).findElement(By.xpath("./div[@class='app-mailBox-item-link-desc app-mailBox-desc']/div[@class='app-mailBox-item-link-desc-item'][1]//div[@class='app-mailBox-item-link-desc-item-info-text']")).getAttribute("innerText"));
                    //пробуем получить текст из поля Описание
                } catch (NoSuchElementException e) {
                }
                if (fromtodescription.get(0).toLowerCase().contains(checkword.toLowerCase()) == false) { //если в поле Описание не нашлось слова, которое искали
                    try {
                        //пробуем получить тексты из полей От и До
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
                    if (fromtodescription.get(l).toLowerCase().contains(checkword.toLowerCase()) == false) {// проверяем, есть ли в полях Описание, От и До искомая строка
                        counter++;//если нет, наращиваем счетчик
                    }
                }
                if (counter == fromtodescription.size()) { //если нет ни в одном из полей- ошибка
                    amountOfMistakes++;
                    strings.get(j).click();
                    Allure.addAttachment("Неверный результат поиска по слову " + checkword, "строка номер "+ j);
                    attachScreenshot();
                }
            }
            WebElement nextButton= driver.findElement(By.xpath("//a[@class='app-pagination-arrow-next']"));
            nextButton.click(); //переходим на следующую страницу
            try {
                Thread.sleep(700);
                t++;
                //500 - 0.5 сек
            } catch (InterruptedException ex) {
            }
        }
        Assert.assertEquals(amountOfMistakes,0);
    }
    @Epic(value = "Проверка поиска")
    @Feature(value="Проверка поиска по имени дела в Дела")
    @Test
    public void CaseSearchTest() {
        int counter=0;
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER); //залогинились
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"))); //ждем закрытия прелоадера
        WebElement selectElem= driver.findElement(By.xpath("//select[@name='sizePage']"));
        Select select=new Select(selectElem);
        selectElem.click();
        select.selectByVisibleText("100 на странице"); //отображаем 100 событий на странице
        List<WebElement> cases=driver.findElements(By.xpath("//div[@class='eventsContent-link']")); //список всех дел
        int randNumber=(int) (Math.random() * cases.size());
        String caseNameToSearch=cases.get(randNumber).findElement(By.xpath("./div[@class='eventsItemChild itemEvent itemEventData'][1]//div[@class='text-overflow']")).getAttribute("innerText"); //берем имя случайного дела
        WebElement searchField=driver.findElement(By.id("flt"));
        searchField.sendKeys(caseNameToSearch);//ввели имя случайного дела в строку поиска
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        List<WebElement> resultCases=driver.findElements(By.xpath("//div[@class='eventsContent-link']")); //список дел после ввода имени в строку поиска
        String [] resultCasesNames=new String[resultCases.size()];
        for (int i=0; i<resultCases.size(); i++){
            resultCasesNames[i]=resultCases.get(i).findElement(By.xpath("./div[@class='eventsItemChild itemEvent itemEventData'][1]//div[@class='text-overflow']")).getAttribute("innerText"); //записали имена всех дел в массив
        }
        for (int j=0; j<resultCasesNames.length; j++){
            if (resultCasesNames[j].toLowerCase().contains(caseNameToSearch.toLowerCase()) == false) { //проверяем, есть ли в именах дел строка, которую вводили, если нет, наращиваем счетчик
                counter++;
            }
        }
        if (counter!=0) { //если счетчик не нулевой, значит, хотя бы в одном из имен кейсов нет строки, которую вводили в поле поиска, значит- Test Failed
            System.out.println("!!!!!!!!!!!!");
            attachScreenshot();
            Allure.addAttachment("Неверный результат поиска по имени кейса " + caseNameToSearch, " ");
            Assert.assertEquals(0, counter);
        }
    }
    @Epic(value = "Проверка поиска")
    @Feature(value="Проверка поиска по имени устройства в Управление устройствами")
    @Test
    public void DevicesSearchTest() {
        int counter=0;
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER); //залогинились
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"))); //ждем закрытия прелоадера
        driver.get("http://192.168.4.222/devices");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        WebElement selectElem= driver.findElement(By.xpath("//select[@name='sizePage']"));
        Select select=new Select(selectElem);
        selectElem.click();
        select.selectByVisibleText("100 на странице"); //отображаем 100 событий на странице
        List<WebElement> devices=driver.findElements(By.xpath("//div[@class='eventsContent-link']")); //список всех дел
        int randNumber=(int) (Math.random() * devices.size());
        String deviceNameToSearch=devices.get(randNumber).findElement(By.xpath("./div[@class='eventsItemChild itemEvent itemEventData'][1]//div[@class='text-overflow']")).getAttribute("innerText"); //берем имя случайного устройства
        WebElement searchField=driver.findElement(By.id("flt"));
        searchField.sendKeys(deviceNameToSearch);//ввели имя случайного устройства в строку поиска
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        List<WebElement> resultCases=driver.findElements(By.xpath("//div[@class='eventsContent-link']")); //список устройств после ввода имени в строку поиска
        String [] resultCasesNames=new String[resultCases.size()];
        for (int i=0; i<resultCases.size(); i++){
            resultCasesNames[i]=resultCases.get(i).findElement(By.xpath("./div[@class='eventsItemChild itemEvent itemEventData'][1]//div[@class='text-overflow']")).getAttribute("innerText"); //записали имена всех устройств в массив
        }
        for (int j=0; j<resultCasesNames.length; j++){
            if (resultCasesNames[j].toLowerCase().contains(deviceNameToSearch.toLowerCase()) == false) { //проверяем, есть ли в именах устройств строка, которую вводили, если нет, наращиваем счетчик
                counter++;
            }
        }
        if (counter!=0) { //если счетчик не нулевой, значит, хотя бы в одном из имен устройств нет строки, которую вводили в поле поиска, значит- Test Failed
            System.out.println("!!!!!!!!!!!!");
            attachScreenshot();
            Allure.addAttachment("Неверный результат поиска по имени устройства " + deviceNameToSearch, " ");
            Assert.assertEquals(0, counter);
        }
    }
}

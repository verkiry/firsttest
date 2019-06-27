package ru.mail.zhenyokvlad;
import io.qameta.allure.Allure;
import io.qameta.allure.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FasetFilterTest {
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

    @Epic(value = "Проверка фасетных фильтров")
    @Test
    public void FasetFilterCheck() {
        //setup();
        WebElement loginField = driver.findElement(By.name("UID"));
        loginField.sendKeys("maxim");
        WebElement passwordField = driver.findElement(By.name("PWD"));
        passwordField.sendKeys("12345");
        passwordField.sendKeys(Keys.ENTER);
        int max = 4; //тут указываем, какую часть скрытых фильтров будем проверять (проверка в случайном порядке), вероятность проверки каждого равно 1/max, т.е. если max=3, то проверяем где-то 1/3, если 4, то 1/4, max=1- проверяем все
        int t = 0;
        WebElement workspace = driver.findElement(By.xpath("/html/body/div[1]/wa-root/wa-cases/div[1]/wa-header/div/div/div/div[2]/ul/li[2]/a/span[2]"));
        while (t < 80) try { //входим в воркспейс
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

        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"))); //ждем закрытия прелоадера

        String menuElementsXpath = "//div[@class='b-filterItem_head checkGroup']"; //локатор фильтров
        List<WebElement> arrows1 = driver.findElements(By.xpath(menuElementsXpath + "/div[@class='b-filterItem_title']/span[@class='b-filterItem_arrow f_chO']")); //список закрытых выпадающих списков в фильтрах
        String hiddenElementXpath = "//div[@class='b-filterItem_head checkGroup']/..//div[@class='b-filterItem_head']/div[@class='cbx']"; //локатор стрелок у фильтров
        List<WebElement> hiddenElements1 = driver.findElements(By.xpath(hiddenElementXpath)); //список закрытых стрелок
        String[] namesOfFilters = new String[hiddenElements1.size()]; //массив с именами фильторв, нужен для вывода в отчет
        List<WebElement> hiddenElementsNames=driver.findElements(By.xpath("//span[@class='b-filterItem_name text-overflow']/.././../..//span[@class='text-overflow']")); //список имен скрытых пунктов
        List<WebElement> filtersNames=driver.findElements(By.xpath("//span[@class='b-filterItem_name text-overflow']"));

        for (int q = 0; q < arrows1.size(); q++) { //заполняем массив имен фильтров
            String nameOfFilter = filtersNames.get(q).getAttribute("innerText");
            namesOfFilters[q] = nameOfFilter;
            System.out.println(namesOfFilters[q]);
        }
        String [] namesOfSubFilters=new String[hiddenElementsNames.size()]; //массив имен подфильтров (внутри выпадающих списков)
        for (int w = 0; w < hiddenElements1.size(); w++) { //заполняем его
            String nameOFSubfilter=hiddenElementsNames.get(w).getAttribute("innerText");
            namesOfSubFilters[w]=nameOFSubfilter;
            System.out.println(namesOfSubFilters[w]);
        }
        int start = 0; //start и finish используются для верного нахождения текущих видимых подфильтров, от 0 до 40 (дела), от 41 до 70 (персоны) и т.д.
        int finish = 0;
        //int numberOfHiddenFilter = 0; //порядковый номер подфильтра, не обнуляется, нужен для отчетов
        for (int i = 0; i < arrows1.size(); i++) {
            List<WebElement> arrows = driver.findElements(By.xpath(menuElementsXpath + "/div[@class='b-filterItem_title']/span[@class='b-filterItem_arrow f_chO']")); //при каждой итерации теста необходимо переопределять список стрелок и подфильторв
            List<WebElement> hiddenElements = driver.findElements(By.xpath(hiddenElementXpath));
            if (arrows.get(i).isDisplayed()) { //если стрелка видна, то... (у фильтров без выпадающих списков стрелка есть, но скрыта)
                arrows.get(i).click(); //раскрываем список
                int amount = 0; //обнуляем количество видимых подфильтров
                for (int j = 0; j < hiddenElements.size(); j++) {
                    if (hiddenElements.get(j).isDisplayed()) {
                        amount++; //читаем видимые на данный момент подфильтры
                        //numberOfHiddenFilter++; //считаем порядковый номер подфильтра в общем списке
                    }
                }
                finish = finish + amount; //смещаем правую границу рассматриваемых подфильторв
                int counter = 0;
                for (int k = start; k < finish; k++) { //для текущих видимых подфильтров
                    int rand = (int) (Math.random() * max); //выбираем случайное целое число от 0 до max не включительно. если число равно 0, проверяем данный подфильтр
                    if (rand == 0) {
                        try {
                            //ДЕЛАЕМ
                            Thread.sleep(500);
                            //500 - 0.5 сек
                        } catch (InterruptedException ex) {
                        }
                        WebDriverWait wait5 = new WebDriverWait(driver, 80);
                        wait5.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
                        try {
                            //ДЕЛАЕМ
                            Thread.sleep(500);
                            //500 - 0.5 сек
                        } catch (InterruptedException ex) {
                        }
                        List<WebElement> hiddenElements2 = driver.findElements(By.xpath(hiddenElementXpath));
                        hiddenElements2.get(k).click();
                        WebElement acceptButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
                        acceptButton.click();
                        try {
                            //ДЕЛАЕМ
                            Thread.sleep(1000);
                            t++;
                            //500 - 0.5 сек
                        } catch (InterruptedException ex) {
                        }
                        WebDriverWait wait1 = new WebDriverWait(driver, 80);
                        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));

                        //List<WebElement> hiddenSideBarCounters=driver.findElements(By.xpath(hiddenElementXpath + "/../div[@class='b-filterItem_bvar-count f_count']")); //определяем лист счетчиков скрытых фильтров
                        int sidebarCounter = Integer.parseInt(driver.findElement(By.xpath("//input[@class='cbx-input Checked']/../../../div[@class='b-filterItem_bvar-count f_count']")).getText());//получаем показатели счетчика на сайдбаре
                        int gridCounter = Integer.parseInt(driver.findElement(By.xpath("//span[@class='app-content-title-count']")).getText()); //получаем показатели счетчика в гриде
                        if (sidebarCounter != gridCounter) { //сравниваем счетчики на сайдбаре и в гриде, если не равны, заносим в отчет
                            Allure.addAttachment("Не сошлись числа на сайдбаре и в гриде в " + namesOfFilters[i] + " -> " + namesOfSubFilters[k], "Не сошлись числа на сайдбаре и в гриде");
                            attachScreenshot();
                            System.out.println("Error");
                            try {
                                //ДЕЛАЕМ
                                Thread.sleep(1000);
                                //500 - 0.5 сек
                            } catch (InterruptedException ex) {
                            } //небольшая задержка, чтобы успеть сделать скрин
                        }
                        WebElement clearButton = driver.findElement(By.xpath("//button[@class='filter-reset']"));
                        t=0;
                        while (t < 80) try {
                            try {
                                //ДЕЛАЕМ
                                Thread.sleep(500);
                                t++;
                                //500 - 0.5 сек
                            } catch (InterruptedException ex) {
                            }
                            clearButton.click();
                            break;
                        } catch (Exception ex) {
                        }
                        //жмем кнопку Сбросить
                        WebDriverWait wait2 = new WebDriverWait(driver, 80);
                        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
                    }
                }
                WebDriverWait wait6 = new WebDriverWait(driver, 80);
                wait6.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));

                WebElement closeArrow = driver.findElement(By.xpath("//div[@class='b-filterItem_head checkGroup']/div[@class='b-filterItem_title']/span[@class='b-filterItem_arrow f_chO open']"));
                closeArrow.click(); //сворачиваем текущий фильтр, чтобы не ломать логику (раскрытая стрелка отличается от свернутой)
                counter++;
                System.out.println(counter);
                start = start + amount; //смещаем левый интервал рассматриваемых подфильторв




                // System.out.println(amount);
            } else { //если нет выпадающего списка (КЕ, Deleted например) просто ставим чекбокс, сравниваем счетчики
                List<WebElement> menuElementCbx=driver.findElements(By.xpath(menuElementsXpath+"/div[@class='cbx']"));
                menuElementCbx.get(i).click();
                WebElement acceptButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
                acceptButton.click();
                try {
                    //ДЕЛАЕМ
                    Thread.sleep(1000);
                    t++;
                    //500 - 0.5 сек
                } catch (InterruptedException ex) {
                }
                WebDriverWait wait3 = new WebDriverWait(driver, 80);
                wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
                List<WebElement> sidebarCounters=driver.findElements(By.xpath(menuElementsXpath+"/span[@class='b-filterItem_count f_count']"));
                int sidebarCounter = Integer.parseInt(sidebarCounters.get(i).getText());//получаем показатели счетчика на сайдбаре
                int gridCounter = Integer.parseInt(driver.findElement(By.xpath("//span[@class='app-content-title-count']")).getText()); //получаем показатели счетчика в гриде
                if (sidebarCounter != gridCounter) { //заносим в отчет, если ошибка
                    Allure.addAttachment("Не сошлись числа на сайдбаре и в гриде в " + namesOfFilters[i], "Не сошлись числа на сайдбаре и в гриде");
                    attachScreenshot();
                    System.out.println("Error");
                    try {
                        //ДЕЛАЕМ
                        Thread.sleep(1000);
                        //500 - 0.5 сек
                    } catch (InterruptedException ex) {
                    } //небольшая задержка, чтобы успеть сделать скрин
                }
                WebElement clearButton = driver.findElement(By.xpath("//button[@class='filter-reset']"));
                while (t < 80) try {
                    try {
                        //ДЕЛАЕМ
                        Thread.sleep(500);
                        t++;
                        //500 - 0.5 сек
                    } catch (InterruptedException ex) {
                    }
                    clearButton.click();
                    break;
                } catch (Exception ex) {
                }
                //жмем кнопку Сбросить
                WebDriverWait wait2 = new WebDriverWait(driver, 80);
                wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
            }
        }


    }
}

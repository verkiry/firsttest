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

import java.util.List;
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
        passwordField.sendKeys(Keys.ENTER); //залогинились
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
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div"))); //зашли в воркспейс, ждем, пока пропадет прелоадер чтобы продолжить работу
        String CasesXpath="/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[1]";
        WebElement CasesArrow = driver.findElement(By.xpath(CasesXpath+"//span[@class='b-filterItem_arrow f_chO']")); //стрелка у пункта Дела
        CasesArrow.click(); //жмем стрелку
        List<WebElement> cases= driver.findElements(By.xpath(CasesXpath+"/..//span[@class='text-overflow']")); //получаем список Дел
        int rand=(int) (Math.random()*cases.size()); //случайно выбираем одно дело из списка
        System.out.println(rand);
        String caseNameToCheck=cases.get(rand).getText(); //записываем имя случайно выбранного дела
        System.out.println(caseNameToCheck);
        WebElement intert=driver.findElement(By.xpath(CasesXpath+"/..//input[@class='filterSearch-input ng-untouched ng-pristine ng-valid']")); //нашли поле квикфильтра
        intert.sendKeys(caseNameToCheck);//в квикфильтр вставляем имя случайно выбранного дела
        List<WebElement> casesAfter= driver.findElements(By.xpath(CasesXpath+"/..//span[@class='text-overflow']")); //получаем список дел после применения квикфильтра
        String firstcasename= casesAfter.get(0).getText(); //записываем имя первого дела из нового списка
        attachScreenshot(); //скриншот в отчет
        Assert.assertThat(firstcasename, CoreMatchers.containsString(caseNameToCheck)); //проверяем, содержит ли имя первого дела из нового списка имя случайно выбранного дела. Если содержит, то квикфильтр работает верно, тест пройден
//остальные тесты в данном тестовом классе работают аналогично
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
            workspace.click();
            break;
        } catch (Exception ex) {
        }

        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String PersonsXpath="/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[1]";
        WebElement PersonsArrow = driver.findElement(By.xpath(PersonsXpath+"//span[@class='b-filterItem_arrow f_chO']"));
        PersonsArrow.click();
        List<WebElement> persons= driver.findElements(By.xpath(PersonsXpath+"/..//span[@class='text-overflow']"));
        int rand=(int) (Math.random()*persons.size());
        String personNameToCheck=persons.get(rand).getText();
        WebElement intert=driver.findElement(By.xpath(PersonsXpath+"/..//input[@class='filterSearch-input ng-untouched ng-pristine ng-valid']"));
        intert.sendKeys(personNameToCheck);
        List<WebElement> personsAfter= driver.findElements(By.xpath(PersonsXpath+"/..//span[@class='text-overflow']"));
        String firstPersonName= personsAfter.get(0).getText();
        attachScreenshot();
        Assert.assertThat(firstPersonName, CoreMatchers.containsString(personNameToCheck));

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
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String DevicesXpath="/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[1]";
        WebElement DevicesArrow = driver.findElement(By.xpath(DevicesXpath+"//span[@class='b-filterItem_arrow f_chO']"));
        DevicesArrow.click();
        List<WebElement> devices= driver.findElements(By.xpath(DevicesXpath+"/..//span[@class='text-overflow']"));
        int rand=(int) (Math.random()*devices.size());
        String deviceNameToCheck=devices.get(rand).getText();
        WebElement intert=driver.findElement(By.xpath(DevicesXpath+"/..//input[@class='filterSearch-input ng-untouched ng-pristine ng-valid']"));
        intert.sendKeys(deviceNameToCheck);
        List<WebElement> devicesAfter= driver.findElements(By.xpath(DevicesXpath+"/..//span[@class='text-overflow']"));
        String firstDeviceName= devicesAfter.get(0).getText();
        attachScreenshot();
        Assert.assertThat(firstDeviceName, CoreMatchers.containsString(deviceNameToCheck));

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
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String CategoriesXpath="/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[1]/div[4]/div[1]";
        WebElement CategoriesArrow = driver.findElement(By.xpath(CategoriesXpath+"//span[@class='b-filterItem_arrow f_chO']"));
        CategoriesArrow.click();
        List<WebElement> categories= driver.findElements(By.xpath(CategoriesXpath+"/..//span[@class='text-overflow']"));
        int rand=(int) (Math.random()*categories.size());
        String categoryNameToCheck=categories.get(rand).getText();
        WebElement intert=driver.findElement(By.xpath(CategoriesXpath+"/..//input[@class='filterSearch-input ng-untouched ng-pristine ng-valid']"));
        intert.sendKeys(categoryNameToCheck);
        List<WebElement> categoriesAfter= driver.findElements(By.xpath(CategoriesXpath+"/..//span[@class='text-overflow']"));
        String firstCategoryName= categoriesAfter.get(0).getText();
        attachScreenshot();
        Assert.assertThat(firstCategoryName, CoreMatchers.containsString(categoryNameToCheck));

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
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String DirectionsXpath="/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]";
        WebElement DirectionsArrow = driver.findElement(By.xpath(DirectionsXpath+"//span[@class='b-filterItem_arrow f_chO']"));
        DirectionsArrow.click();
        List<WebElement> directions= driver.findElements(By.xpath(DirectionsXpath+"/..//span[@class='text-overflow']"));
        int rand=(int) (Math.random()*directions.size());
        String directionNameToCheck=directions.get(rand).getText();
        WebElement intert=driver.findElement(By.xpath(DirectionsXpath+"/..//input[@class='filterSearch-input ng-untouched ng-pristine ng-valid']"));
        intert.sendKeys(directionNameToCheck);
        List<WebElement> directionsAfter= driver.findElements(By.xpath(DirectionsXpath+"/..//span[@class='text-overflow']"));
        String firstDirectionName= directionsAfter.get(0).getText();
        attachScreenshot();
        Assert.assertThat(firstDirectionName, CoreMatchers.containsString(directionNameToCheck));

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
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String LanguagesXpath="/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]";
        WebElement LanguagesArrow = driver.findElement(By.xpath(LanguagesXpath+"//span[@class='b-filterItem_arrow f_chO']"));
        LanguagesArrow.click();
        List<WebElement> languages= driver.findElements(By.xpath(LanguagesXpath+"/..//span[@class='text-overflow']"));
        int rand=(int) (Math.random()*languages.size());
        String languageNameToCheck=languages.get(rand).getText();
        WebElement intert=driver.findElement(By.xpath(LanguagesXpath+"/..//input[@class='filterSearch-input ng-untouched ng-pristine ng-valid']"));
        intert.sendKeys(languageNameToCheck);
        List<WebElement> languagesAfter= driver.findElements(By.xpath(LanguagesXpath+"/..//span[@class='text-overflow']"));
        String firstLanguageName= languagesAfter.get(0).getText();
        attachScreenshot();
        Assert.assertThat(firstLanguageName, CoreMatchers.containsString(languageNameToCheck));
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
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String ApplicationsXpath="/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]";
        WebElement ApplicationsArrow = driver.findElement(By.xpath(ApplicationsXpath+"//span[@class='b-filterItem_arrow f_chO']"));
        ApplicationsArrow.click();
        List<WebElement> applications= driver.findElements(By.xpath(ApplicationsXpath+"/..//span[@class='text-overflow']"));
        int rand=(int) (Math.random()*applications.size());
        String applicationNameToCheck=applications.get(rand).getText();
        WebElement intert=driver.findElement(By.xpath(ApplicationsXpath+"/..//input[@class='filterSearch-input ng-untouched ng-pristine ng-valid']"));
        intert.sendKeys(applicationNameToCheck);
        List<WebElement> applicationsAfter= driver.findElements(By.xpath(ApplicationsXpath+"/..//span[@class='text-overflow']"));
        String firstApplicationName= applicationsAfter.get(0).getText();
        attachScreenshot();
        Assert.assertThat(firstApplicationName, CoreMatchers.containsString(applicationNameToCheck));

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

        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String InfoXpath="/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[1]";
        WebElement InfoArrow = driver.findElement(By.xpath(InfoXpath+"//span[@class='b-filterItem_arrow f_chO']"));
       InfoArrow.click();
        List<WebElement> infos= driver.findElements(By.xpath(InfoXpath+"/..//span[@class='text-overflow']"));
        int rand=(int) (Math.random()*infos.size());
        String infoNameToCheck=infos.get(rand).getText();
        WebElement intert=driver.findElement(By.xpath(InfoXpath+"/..//input[@class='filterSearch-input ng-untouched ng-pristine ng-valid']"));
        intert.sendKeys(infoNameToCheck);
        List<WebElement> infosAfter= driver.findElements(By.xpath(InfoXpath+"/..//span[@class='text-overflow']"));
        String firstInfoName= infosAfter.get(0).getText();
        attachScreenshot();
        Assert.assertThat(firstInfoName, CoreMatchers.containsString(infoNameToCheck));

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

        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String AbonentsXpath="/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[5]/div[1]";
        WebElement AbonentsArrow = driver.findElement(By.xpath(AbonentsXpath+"//span[@class='b-filterItem_arrow f_chO']"));
        AbonentsArrow.click();
        List<WebElement> abonents= driver.findElements(By.xpath(AbonentsXpath+"/..//span[@class='text-overflow']"));
        int rand=(int) (Math.random()*abonents.size());
        String abonentNameToCheck=abonents.get(rand).getText();
        WebElement intert=driver.findElement(By.xpath(AbonentsXpath+"/..//input[@class='filterSearch-input ng-untouched ng-pristine ng-valid']"));
        intert.sendKeys(abonentNameToCheck);
        List<WebElement> abonentsAfter= driver.findElements(By.xpath(AbonentsXpath+"/..//span[@class='text-overflow']"));
        String firstAbonentName= abonentsAfter.get(0).getText();
        attachScreenshot();
        Assert.assertThat(firstAbonentName, CoreMatchers.containsString(abonentNameToCheck));

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
        WebDriverWait wait1 = new WebDriverWait(driver, 40);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/wa-root/wa-wait/div/div/div")));
        String ExtraXpath="/html/body/div[1]/wa-root/wa-workspace/div/div[2]/ws-tab/div/div[1]/div[1]/div[2]/div/div[3]/div[6]/div[1]";
        WebElement ExtraArrow = driver.findElement(By.xpath(ExtraXpath+"//span[@class='b-filterItem_arrow f_chO']"));
        ExtraArrow.click();
        List<WebElement> extraProperties= driver.findElements(By.xpath(ExtraXpath+"/..//span[@class='text-overflow']"));
        int rand=(int) (Math.random()*extraProperties.size());
        String extrapropertyNameToCheck=extraProperties.get(rand).getText();
        WebElement intert=driver.findElement(By.xpath(ExtraXpath+"/..//input[@class='filterSearch-input ng-untouched ng-pristine ng-valid']"));
        intert.sendKeys(extrapropertyNameToCheck);
        List<WebElement> extrapropertiesAfter= driver.findElements(By.xpath(ExtraXpath+"/..//span[@class='text-overflow']"));
        String firstPropertyName= extrapropertiesAfter.get(0).getText();
        attachScreenshot();
        Assert.assertThat(firstPropertyName, CoreMatchers.containsString(extrapropertyNameToCheck));

    }


}

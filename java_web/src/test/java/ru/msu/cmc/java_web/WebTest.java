package ru.msu.cmc.java_web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;;import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebTest {
    @Test
    void registerTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1100, 900));
        driver.get("http://localhost:8080/");

        WebElement registrateButton = driver.findElement(By.id("registrateLink"));
        registrateButton.click();

        driver.findElement(By.id("login")).sendKeys("test_login");
        driver.findElement(By.id("surname")).sendKeys("test_surname");
        driver.findElement(By.id("name")).sendKeys("test_name");
        driver.findElement(By.id("patr")).sendKeys("test_patr");
        driver.findElement(By.id("address")).sendKeys("test_address");
        driver.findElement(By.id("password")).sendKeys("test_password");
        driver.findElement(By.id("submitButton")).click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/reg-main");

        driver.findElement(By.id("logOutLink")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/index");
    }

    @Test
    void loginCheckProfileHistory() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1100, 900));
        driver.get("http://localhost:8080/");

        driver.findElement(By.id("signInLink")).click();
        driver.findElement(By.id("login")).sendKeys("kireev");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("submitButton")).click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/reg-main");

        driver.findElement(By.id("profileLink")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/profile");

        driver.findElement(By.id("regRootLink")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/reg-main");

        driver.findElement(By.id("historyLink")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/history");

        driver.findElement(By.id("logOutLink")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/index");
    }

    @Test
    void adminAddRemoveUser() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1100, 900));
        driver.get("http://localhost:8080/");

        driver.findElement(By.id("signInLink")).click();
        driver.findElement(By.id("login")).sendKeys("admin1");
        driver.findElement(By.id("password")).sendKeys("admin1");
        driver.findElement(By.id("submitButton")).click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/admin-main");

        driver.findElement(By.id("readersLink")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/readers");

        driver.get("http://localhost:8080/remove_reader?readerId=4");

        driver.findElement(By.id("addReaderLink")).click();
        driver.findElement(By.id("login")).sendKeys("test_login");
        driver.findElement(By.id("surname")).sendKeys("test_surname");
        driver.findElement(By.id("name")).sendKeys("test_name");
        driver.findElement(By.id("patr")).sendKeys("test_patr");
        driver.findElement(By.id("address")).sendKeys("test_address");
        driver.findElement(By.id("password")).sendKeys("test_password");
        driver.findElement(By.id("submitButton")).click();

        driver.findElement(By.id("readersLink")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/readers");
        driver.get("http://localhost:8080/remove_reader?readerId=4");

        driver.findElement(By.id("adminLogOutLink")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/index");
    }

    @Test
    void adminAddRemoveBook() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1100, 900));
        driver.get("http://localhost:8080/");

        driver.findElement(By.id("signInLink")).click();
        driver.findElement(By.id("login")).sendKeys("admin1");
        driver.findElement(By.id("password")).sendKeys("admin1");
        driver.findElement(By.id("submitButton")).click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/admin-main");

        driver.findElement(By.id("addBookLink")).click();
        driver.findElement(By.id("name")).sendKeys("test_name");
        driver.findElement(By.id("authors")).sendKeys("test_authors");
        driver.findElement(By.id("publisher")).sendKeys("test_publisher");
        driver.findElement(By.id("year")).sendKeys("2222");
        driver.findElement(By.id("isbn")).sendKeys("2222");
        driver.findElement(By.id("total")).sendKeys("2222");
        driver.findElement(By.id("submitButton")).click();

        driver.findElement(By.id("adminRootLink")).click();
        driver.get("http://localhost:8080/remove_book?bookId=4");

        driver.findElement(By.id("adminLogOutLink")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/index");
    }

    @Test
    void adminAddRecord() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1100, 900));
        driver.get("http://localhost:8080/");

        driver.findElement(By.id("signInLink")).click();
        driver.findElement(By.id("login")).sendKeys("admin1");
        driver.findElement(By.id("password")).sendKeys("admin1");
        driver.findElement(By.id("submitButton")).click();

        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/admin-main");

        driver.findElement(By.id("addRecordLink")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/add-record");
        driver.findElement(By.id("login")).sendKeys("kireev");
        driver.findElement(By.id("book_name")).sendKeys("1984");
        driver.findElement(By.id("issue_date")).sendKeys("2022-06-15");
        driver.findElement(By.id("return_date")).sendKeys("2022-06-25");

        driver.findElement(By.id("adminLogOutLink")).click();
        assertEquals(driver.getCurrentUrl(), "http://localhost:8080/index");
    }
}

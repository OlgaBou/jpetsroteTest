package jpetstore;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstJpetsroreTest {
	@Test
    public void mainTest() {
        System.setProperty("webdriver.chrome.driver","C://Users//formation//Desktop//jpetstore-6/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/jpetstore/");
        driver.findElement(By.xpath("//a[@href='actions/Catalog.action']")).click();
        driver.findElement(By.xpath("//div[@id='MenuContent']/a[contains(@href, 'signonForm')]")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("ACID");
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ACID");
        driver.findElement(By.xpath("//input[@name='signon']")).click();
        
        driver.findElement(By.xpath("//div[@id='SidebarContent']/a[contains(@href, 'categoryId=REPTILES')]")).click();
        driver.findElement(By.xpath("//a[@href='/jpetstore/actions/Catalog.action?viewProduct=&productId=RP-LI-02']")).click();
        driver.findElement(By.xpath("//a[@href='/jpetstore/actions/Catalog.action?viewItem=&itemId=EST-13']")).click();
        driver.findElement(By.xpath("//a[@href='/jpetstore/actions/Cart.action?addItemToCart=&workingItemId=EST-13']")).click();
        driver.findElement(By.xpath("//div[@id='Cart']/a[contains(@href, 'newOrderForm')]")).click();
        driver.findElement(By.xpath("//input[@name='newOrder']")).click();
        driver.findElement(By.xpath("//div[@id='Catalog']/a[contains(@href, 'confirmed=true')]")).click();   
        
        String actualString = driver.findElement(By.xpath("//div[@id='Content']/ul/li/text()")).getText();
        Assert.assertTrue(actualString.contains("Thank you, your order has been submitted."));
        System.out.println("coucou");
        
        driver.quit();

    /*    driver.findElement(By.xpath("//input[@aria-label=\"Rechercher\"]")).sendKeys("cat");
        driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
                driver.findElement(By.xpath("//a[@href='actions/Catalog.action']")).click();*/
    }

}
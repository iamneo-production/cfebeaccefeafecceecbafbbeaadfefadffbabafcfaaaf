package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import uistore.Locators;
import utils.Screenshot;

public class Homepage {

    Screenshot screenshotHandler = new Screenshot();

    public void hoverToProducts(WebDriver driver, ExtentTest test) {
        try {
            
            WebElement productsMenu = driver.findElement(By.xpath(Locators.productsMenu));
            Actions actions = new Actions(driver);
            actions.moveToElement(productsMenu).perform();
            String base64Screenshot = screenshotHandler.captureScreenshotAsBase64(driver, "hover_products");
            test.log(Status.PASS, "Hovered Products", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            
        } catch (Exception e) {
            e.printStackTrace();
            String base64Screenshot = screenshotHandler.captureScreenshotAsBase64(driver, "hover_products");
            test.fail("Unable to hover products", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }

    public void clickBrands(WebDriver driver, ExtentTest test) {
        try {
            WebElement optionElement = driver.findElement(By.xpath(Locators.optionElement));
            optionElement.click();
            test.log(Status.PASS, "Clicked MACH3");
        } catch (Exception e) {
            e.printStackTrace();
            String base64Screenshot = screenshotHandler.captureScreenshotAsBase64(driver, "click_MACH3");
            test.fail("Unable to click MACH3", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }

    public void findRazorTurbo(WebDriver driver, ExtentTest test) {
        try {
            WebElement productList = driver.findElement(By.xpath(Locators.productList));
            String productListText = productList.getText();
            String base64Screenshot = screenshotHandler.captureScreenshotAsBase64(driver, "find_Razor_Turbo");
            test.log(Status.PASS, "Found Razor Turbo", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (Exception e) {
            e.printStackTrace();
            String base64Screenshot = screenshotHandler.captureScreenshotAsBase64(driver, "find_Razor_Turbo");
            test.fail("Unable to find Razor Turbo", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }
}

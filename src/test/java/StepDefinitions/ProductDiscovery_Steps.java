package StepDefinitions;

import Pages.DialogContent;
import Utilities.PageDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.sl.draw.geom.PresetGeometries;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ProductDiscovery_Steps {

    DialogContent dc=new DialogContent();
    WebDriverWait wait =new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(30));



    @Given("Go to the website")
    public void goToTheWebsite() {
        PageDriver.getDriver().get("https://best.aliexpress.com/");
        PageDriver.getDriver().manage().window().maximize();
        dc.clickFunc(dc.alert);


        }

        @When("Verify you are on the homepage")
        public void verifyYouAreOnTheHomepage() {
        String currentUrl=PageDriver.getDriver().getCurrentUrl();
        String expectedUrl="https://best.aliexpress.com/";

            Assert.assertEquals(currentUrl,expectedUrl,"URL doğrulama başarısız: Sayfa beklenen URL'de değil.");

        }

        @And("Set country and currency settings to Turkey")
       public void setCountryAndCurrencySettingsToTurkey() {
        dc.clickFunc(dc.infoLink);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='address-select-trigger']")));
        dc.clickFunc(dc.countryLink);
        dc.clickFunc(dc.country);
        dc.clickFunc(dc.languageLink);
        dc.clickFunc(dc.language);
        dc.clickFunc(dc.currencyLink);
        dc.clickFunc(dc.currency);
        dc.clickFunc(dc.saveBtn);

    }

    @And("Click on the Computers & Office category")
    public void clickOnTheComputersOfficeCategory() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class^='cl-item'], [class^='cl item']:nth-child(4)")));
       Actions actions=new Actions(PageDriver.getDriver());
       Thread.sleep(5000);
       actions.moveToElement(dc.computer).click().build().perform();


    }

    @And("Select seller country as China")
    public void selectSellerCountryAsChina() {
        dc.clickFunc(dc.slrContry);
        dc.clickFunc(dc.china);
    }

    @Then("Print the name and price of the cheapest product on the page")
    public void printTheNameAndPriceOfTheCheapestProductOnThePage() throws InterruptedException {

        WebElement elementToClick = PageDriver.getDriver().findElement(By.cssSelector(".comet-icon-arrowtriangleup"));
        JavascriptExecutor executor = (JavascriptExecutor)PageDriver.getDriver();
        executor.executeScript("arguments[0].click();", elementToClick);


        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='card-list']>a:nth-child(1)")));
        System.out.println("FİYATI EN DÜŞÜK OLAN ÜRÜN BİLGİLERİ:"+ dc.lowestFirstItem.getText());

    }
    @And("Print the name and price of the most expensive product on the page")
    public void printTheNameAndPriceOfTheMostExpensiveProductOnThePage() throws InterruptedException {

        WebElement elementToClick = PageDriver.getDriver().findElement(By.cssSelector(".comet-icon-arrowtriangledown"));
        JavascriptExecutor executor = (JavascriptExecutor)PageDriver.getDriver();
        executor.executeScript("arguments[0].click();", elementToClick);


        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='card-list']>a:nth-child(1)")));
        System.out.println("FİYATI EN YÜKSEK OLAN ÜRÜN BİLGİLERİ:"+ dc.highestFirstItem.getText());

    }

    @And("Choose a random sponsored product by scrolling to the end of the page")
    public void chooseARandomSponsoredProductByScrollingToTheEndOfThePage() {

        String mainWindowHandle = PageDriver.getDriver().getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) PageDriver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        List<WebElement> sponsoredItems =PageDriver.getDriver().findElements(By.cssSelector("[class='p4p--p4pList--2B-vc3X']>div"));

         if(!sponsoredItems.isEmpty()){
             Random random=new Random();
             int randomIndex=random.nextInt(sponsoredItems.size());


             WebElement randomProduct =sponsoredItems.get(randomIndex);

             randomProduct.click();

         }else {
             System.out.println("Seçilecek bir ürün bulunamadı");
         }

        Set<String> allWindowHandles = PageDriver.getDriver().getWindowHandles();

     // Yeni pencereyi bulmak için bir döngü
        String newWindowHandle = null;
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }
        PageDriver.getDriver().switchTo().window(newWindowHandle);

    }

    @Then("Print the product's name")
    public void printTheProductsName() {
        System.out.println("ÜRÜN ADI :"+ dc.productName.getText());


    }
    @And("Print the product's star, review and sales count")
    public void printTheProductsStarReviewAndSalesCount() {
        System.out.println("Ürün bilgileri :"+dc.productInfo.getText());
    }


    @And("Slowly scroll through all the product images")
    public void slowlyScrollThroughAllTheProductImages() throws InterruptedException {


        JavascriptExecutor js = (JavascriptExecutor) PageDriver.getDriver();

        for (WebElement image :dc.images) {

            image.click();

            Thread.sleep(1000); // her tıklamadan sonra 1 saniye


        }
    }
    @And("Add product to car")
    public void addProductToCar() {

        dc.clickFunc(dc.addToCart);


    }

    @And("Remove it from car")
    public void removeItFromCar() {
        dc.clickFunc(dc.viewCart);
        dc.clickFunc(dc.delete);
        dc.clickFunc(dc.remove);

    }

    @Then("Verify that you have successfully logged out")
    public void verifyThatYouHaveSuccessfullyLoggedOut() {
        dc.verifyContainsTextFunction(dc.logoutVerify,"Giriş yap");

    }



}

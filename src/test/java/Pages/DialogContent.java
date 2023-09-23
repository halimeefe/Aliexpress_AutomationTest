package Pages;

import Utilities.PageDriver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Parameters;

import java.util.List;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(PageDriver.getDriver(), this);

    }


    @FindBy (xpath = "//*[text()='İzin verme']")
    public WebElement alert;

    @FindBy(css = "[class='ng-item-wrap ng-item ng-switcher']")
    public WebElement infoLink;

    @FindBy(css = "[class='address-select-trigger']")
    public WebElement countryLink;

    @FindBy(xpath = "(//*[@class='address-select-content'])[1]//li[219]")
    public WebElement country;

    @FindBy(css = "[class='switcher-currency-c language-selector']")
    public WebElement languageLink;

    @FindBy(css = "[data-role='language-list']>li:nth-child(9)")
    public WebElement language;

    @FindBy(xpath = "(//*[@class='select-item'])[2]")
    public WebElement currencyLink;

    @FindBy(css = "[class='switcher-currency-c']>ul>li:nth-child(16)")
    public WebElement currency;

    @FindBy(css = "button[data-role='save']")
    public WebElement saveBtn;

    @FindBy(xpath = "//*[text()='Bilgisayar']")
    public WebElement computer;

    @FindBy(className = "comet-input-suffix")
    public WebElement slrContry;

    @FindBy(css = "ul[class='comet-menu']>li:nth-child(9)")
    public WebElement china;

    @FindBy(css = "[id='card-list']>a:nth-child(1)")
    public WebElement lowestFirstItem;

    @FindBy(css = "div[id='card-list']>a:nth-child(1)")
    public WebElement highestFirstItem;

    @FindBy(css = "[data-pl='product-title']")
    public WebElement productName;

    @FindBy (css = "[class='product-reviewer']")
    public WebElement productInfo;

    @FindBy(css = "[class='images-view-list']>li")
    public List<WebElement> images;

    @FindBy (xpath = "//*[text()='Sepete Ekle']")
    public WebElement addToCart;

    @FindBy (css = "[class='comet-btn comet-btn-primary comet-btn-important']")
    public WebElement viewCart;

    @FindBy (css = "[class='comet-icon comet-icon-trashcan ']")
    public WebElement delete;

    @FindBy (css = "[class='comet-btn comet-btn-primary comet-btn-important']")
    public WebElement remove;

    @FindBy (xpath = "(//*[text()='Giriş yap'])[2]")
    public WebElement logoutVerify;


















































}
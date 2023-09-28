import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CheckTitle {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test //1
    public void checking() {
        System.out.println(driver.getTitle());
    }

    @Test //2
    public void checkInformation() {
        driver.get("https://demoqa.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> cards = driver.findElements(By.cssSelector(".category-cards>div"));
        WebElement card = cards.get(0);
        js.executeScript("arguments[0].scrollIntoView();", card);
        card.click();
        List<WebElement> items = driver.findElements(By.cssSelector("ul>#item-0"));
        WebElement item = items.get(0);
        item.click();
        WebElement userName = driver.findElement(By.cssSelector("#userName"));
        userName.sendKeys("Elcan");
        WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
        userEmail.sendKeys("elcanrza1905@gmail.com");
        WebElement currentAddress = driver.findElement(By.cssSelector("#currentAddress"));
        currentAddress.sendKeys("Baku, Azerbaijan");
        WebElement permanentAddress = driver.findElement(By.cssSelector("#permanentAddress"));
        permanentAddress.sendKeys("Baku, Azerbaijan");
        WebElement submit = driver.findElement(By.cssSelector("#submit"));
        js.executeScript("arguments[0].scrollIntoView();", submit);
        submit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement outputName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        WebElement outputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement outputCurrentAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#currentAddress")));
        WebElement outputPermanentAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#permanentAddress")));
        Assert.assertEquals(outputName.getText(), "Name:Elcan");
        Assert.assertEquals(outputEmail.getText(), "Email:elcanrza1905@gmail.com");
        Assert.assertEquals(outputCurrentAddress.getText(), "Current Address :Baku, Azerbaijan");
        Assert.assertEquals(outputPermanentAddress.getText(), "Permananet Address :Baku, Azerbaijan");
    }

    @Test //3
    public void QATest() {
        driver.get("https://demoqa.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> cards = driver.findElements(By.cssSelector(".category-cards>div"));
        WebElement card = cards.get(0);
        js.executeScript("arguments[0].scrollIntoView();", card);
        card.click();
        List<WebElement> checkBoxs = driver.findElements(By.cssSelector("ul>#item-1"));
        WebElement checkBox = checkBoxs.get(0);
        checkBox.click();
        WebElement expandBtn = driver.findElement(By.cssSelector("button[title=\"Expand all\"]"));
        expandBtn.click();
        WebElement notesIcon = driver.findElement(By.cssSelector("label[for=\"tree-node-notes\"]>.rct-checkbox>svg"));
        notesIcon.click();
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".text-success")));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test  //4
    public void ClickMe() {
        driver.get("https://demoqa.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> cards = driver.findElements(By.cssSelector(".category-cards>div"));
        WebElement card = cards.get(0);
        js.executeScript("arguments[0].scrollIntoView();", card);
        card.click();
        List<WebElement> Buttons = driver.findElements(By.cssSelector("ul>#item-4"));
        WebElement Button = Buttons.get(0);
        Button.click();
        WebElement rightClickBtn = driver.findElement(By.cssSelector("#rightClickBtn"));
        Actions action = new Actions(driver);
        action.contextClick(rightClickBtn).build().perform();
        WebElement rightClickMessage = driver.findElement(By.cssSelector("#rightClickMessage"));
        Assert.assertTrue(rightClickMessage.isDisplayed());
    }

    @Test //5
    public void FileisUploaded() {
        driver.get("https://demoqa.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> cards = driver.findElements(By.cssSelector(".category-cards>div"));
        WebElement card = cards.get(0);
        js.executeScript("arguments[0].scrollIntoView();", card);
        card.click();
        List<WebElement> listItems = driver.findElements(By.cssSelector("ul>#item-7"));
        WebElement uploadAndDownload = listItems.get(0);
        js.executeScript("arguments[0].scrollIntoView();", uploadAndDownload);
        uploadAndDownload.click();
        WebElement uploadFile = driver.findElement(By.cssSelector("#uploadFile"));
        String path = "C:\\Workspace\\evtapsiriqlari\\Automationtest\\src\\main\\resources\\test.txt";
        uploadFile.sendKeys(path);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#uploadedFilePath")));
        Assert.assertTrue(uploadFile.isDisplayed());
    }

    @Test//6
    public void CheckButton() {
        driver.get("https://demoqa.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> cards = driver.findElements(By.cssSelector(".category-cards>div"));
        WebElement card = cards.get(0);
        js.executeScript("arguments[0].scrollIntoView();", card);
        card.click();
        List<WebElement> listItems = driver.findElements(By.cssSelector("ul>#item-8"));
        WebElement DynamicProperties = listItems.get(0);
        DynamicProperties.click();
        WebElement VisibleAfterButton = driver.findElement(By.cssSelector("#visibleAfter"));
        wait.until(ExpectedConditions.visibilityOf(VisibleAfterButton));
        Assert.assertTrue(VisibleAfterButton.isDisplayed());
    }

    @Test  //7
    public void ChecekOpened() {
        driver.get("https://demoqa.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> listOfCards = driver.findElements(By.cssSelector(".category-cards>div"));
        WebElement card = listOfCards.get(2);
        js.executeScript("arguments[0].scrollIntoView();", card);
        card.click();
        List<WebElement> listOfItems = driver.findElements(By.cssSelector("ul>#item-0"));
        WebElement BrowserWindows = listOfItems.get(2);
        BrowserWindows.click();
        WebElement newTabBtn = driver.findElement(By.cssSelector("#tabButton"));
        newTabBtn.click();
        String mainWindow = driver.getWindowHandle();
        Set<String> windowsId = driver.getWindowHandles();
        Iterator<String> iterator = windowsId.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                WebElement h1 = driver.findElement(By.cssSelector("#sampleHeading"));
                System.out.println(h1.getText());
                driver.close();
            }
        }
    }

    @Test  //8
    public void CheckInformationTests() {
        driver.get("https://demoqa.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> AlertsFramesWindowsOptions = driver.findElements(By.cssSelector(".category-cards>div"));
        WebElement card = AlertsFramesWindowsOptions.get(2);
        js.executeScript("arguments[0].scrollIntoView();", card);
        card.click();
        List<WebElement> Alerts = driver.findElements(By.cssSelector("ul>#item-1"));
        WebElement alert = Alerts.get(1);
        alert.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement PromptButtons = driver.findElement(By.cssSelector("#promtButton"));
        PromptButtons.click();
        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();
        WebElement promptResult = driver.findElement(By.cssSelector("#promptResult"));
        Assert.assertTrue(promptResult.getText().contains("hello"), "The information does not match");
    }

    @Test  //9
    public void CheckAlertCanceled() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> AlertCards = driver.findElements(By.cssSelector(".category-cards>div"));
        WebElement cardAlertsFrameWindows = AlertCards.get(2);
        js.executeScript("arguments[0].scrollIntoView();", cardAlertsFrameWindows);
        cardAlertsFrameWindows.click();
        List<WebElement> listItems = driver.findElements(By.cssSelector(".menu-list>#item-1"));
        WebElement alerts = listItems.get(1);
        alerts.click();
        WebElement confirmBtn = driver.findElement(By.cssSelector("#confirmButton"));
        confirmBtn.click();
        driver.switchTo().alert().dismiss();
        WebElement confirmResult = driver.findElement(By.cssSelector("#confirmResult"));
        Assert.assertTrue(confirmResult.getText().contains("Cancel"));
    }

    @Test//10
    public void checkFrame() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> FrameCards = driver.findElements(By.cssSelector(".category-cards>div"));
        WebElement cardAlertsFrameWindows = FrameCards.get(2);
        js.executeScript("arguments[0].scrollIntoView();", cardAlertsFrameWindows);
        cardAlertsFrameWindows.click();
        List<WebElement> listItems = driver.findElements(By.cssSelector(".menu-list>#item-2"));
        WebElement frames = listItems.get(1);
        frames.click();
        WebElement iframe = driver.findElement(By.cssSelector("iframe#frame1"));
        driver.switchTo().frame(iframe);
        WebElement h1 = driver.findElement(By.cssSelector("#sampleHeading"));
        Assert.assertTrue(h1.isDisplayed());
    }

    @Test //11
    public void checkFive() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> FiveCards = driver.findElements(By.cssSelector(".category-cards>div"));
        WebElement cardInteractions = FiveCards.get(4);
        js.executeScript("arguments[0].scrollIntoView();", cardInteractions);
        cardInteractions.click();
        List<WebElement> listItems = driver.findElements(By.cssSelector(".menu-list>#item-1"));
        WebElement selectable = listItems.get(3);
        js.executeScript("arguments[0].scrollIntoView();", selectable);
        selectable.click();
        WebElement grid = driver.findElement(By.cssSelector("a[id=\"demo-tab-grid\"]"));
        grid.click();
        List<WebElement> gridListFive = driver.findElements(By.cssSelector("#row2>li"));
        WebElement five = gridListFive.get(1);
        five.click();
        wait.until(ExpectedConditions.attributeToBe(five, "class", "list-group-item active list-group-item-action"));
        Assert.assertEquals(five.getAttribute("class"), "list-group-item active list-group-item-action", "Five is not chosen");
    }

    @Test //12
    public void checkDropped() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> DroppedCards = driver.findElements(By.cssSelector(".category-cards>div"));
        WebElement cardInteractions = DroppedCards.get(4);
        js.executeScript("arguments[0].scrollIntoView();", cardInteractions);
        cardInteractions.click();
        List<WebElement> listItems = driver.findElements(By.cssSelector(".menu-list>#item-3"));
        WebElement droppable = listItems.get(3);
        droppable.click();
        WebElement dragMe = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropHere = driver.findElement(By.cssSelector("#droppable"));
        Actions action = new Actions(driver);
        action.dragAndDrop(dragMe, dropHere).build().perform();
        List<WebElement> texts = driver.findElements(By.cssSelector("div[id=\"droppable\"]>p"));
        WebElement textDropped = texts.get(0);
        Assert.assertEquals(textDropped.getText(), "Dropped!", "Drop here");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    //Инициализация
    static {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {

        //Настройка
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Заходим на главную
        driver.get("https://www.avito.ru/");
        Select categorySelector = new Select(driver.findElement(By.xpath("//select[@id='category']")));
        categorySelector.selectByVisibleText("Оргтехника и расходники");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Принтер");
        driver.findElement(By.xpath("//div[contains(@data-marker, 'region')]")).click();

        //Работаем с POPUP
        WebElement popup = driver.findElement(By.xpath("//div[contains(@class, 'popup')]"));
        popup.findElement(By.xpath(".//input")).sendKeys("Владивосток");
        Thread.sleep(1000); //Дефолтный город (напр., Москва) иногда не успевает пропасть из списка предложений
        popup.findElement(By.xpath(".//ul/li[@data-marker='suggest(0)']")).click();
        popup.findElement(By.xpath(".//button[contains(@data-marker, 'save-button')]")).click();

        //Подтверждаем опцию доставки
        WebElement deliveryCheckbox =
                driver.findElement(By.xpath(
                        "//div[contains(@data-marker, 'delivery-filter')]//input[@type='checkbox']"));
        if (!deliveryCheckbox.isSelected()) {
            driver.findElement(By.xpath("//div[contains(@data-marker, 'delivery-filter')]/label/span")).click();
        }
        driver.findElement(By.xpath("//div[contains(@class, 'applyButton')]/button")).click();

        //Сортировка от дорогих к дешевым
        Select sortingSelector = new Select(driver.findElement(By.xpath("//div[contains(@class, 'sort-select')]/select")));
        sortingSelector.selectByVisibleText("Дороже");

        //Печатаем принтеры :)
        WebElement index = driver.findElement(By.xpath("//div[contains(@class, 'snippet-list')]"));
        List<WebElement> topSnippets = index.findElements(By.xpath("./div[contains(@class, 'ads')][1]/following-sibling::div[position()<4]"));
        System.out.println();
        List<Good> topGoods = new ArrayList<>();
        int li = 0;
        for (WebElement snippet: topSnippets) {
            topGoods.add(digEntry(snippet));
            System.out.println((li + 1) + ". Наименование: " + topGoods.get(li).getTitle() +
                    " | Цена: " + topGoods.get(li).getPrice() + " руб.");
            li++;
        }
        Thread.sleep(5000);

        //Закрываем WebDriver
        driver.close();

    }

    static Good digEntry (WebElement snippet) {
        Good goodFound = new Good();
        String title = snippet.findElement(By.xpath(".//h3/a/span")).getText();
        int price = Integer.parseInt(snippet.findElement(By.xpath(".//meta[@itemprop='price']")).getAttribute("content"));
        goodFound.setTitle(title);
        goodFound.setPrice(price);
        return goodFound;
    }

}

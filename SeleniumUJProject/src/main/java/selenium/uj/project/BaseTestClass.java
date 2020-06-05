package selenium.uj.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTestClass {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {

        setSystemProperties();

        createDriver();
    }



    @AfterClass
    public void tearDown() {
        driver.quit(); // zabicie drivera i zamknięcie przeglądarki
    }


    private void setSystemProperties() {
        // Zdefiniowanie ścieżki dla zewnętrznego drivera przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver", "...");
    }

    private void createDriver() {
        driver = new ChromeDriver(); // utworzenie obiektu i inicjalizacja przeglądarką Chrome
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // ustawienie czasu oczekiwania na elementy
        driver.manage().window().maximize(); // maksymalizacja okna

        driver.get("https://testerzy.pl/"); // wejście na stronę testerzy.pl
    }
}

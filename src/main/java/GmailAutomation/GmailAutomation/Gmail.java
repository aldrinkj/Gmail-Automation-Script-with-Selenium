import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Gmail {
public static void main(String[] args) {
// Initialize WebDriver
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
// Step 1: Login to Gmail
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
driver.get("https://mail.google.com/");
String email = "testmail4assngmnt@gmail.com";
String password = "#a2kj1080p";
driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]")).click();
WebElement passwordField =
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
passwordField.sendKeys(password);
driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]")).click();
// Step 2: Compose an Email
wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".T-I.T-IKE.L3"))).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'a
gP')]"))).sendKeys(email);
driver.findElement(By.name("subjectbox")).sendKeys("Test Mail");
driver.findElement(By.cssSelector("div[aria-label='Message Body']")).sendKeys("Test Email
Body");
// Step 3: Label the Email
driver.findElement(By.xpath("(//div[contains(@class,'J-JN-M-I-JG')])[5]")).click(); // Click more
options
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'JN-Jz')])[11]"))).click(); // Click label option
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Social']"))).click()
;
driver.findElement(By.xpath("//div[text()='Apply']")).click();
// Step 4: Send the Email
driver.findElement(By.xpath("(//div[@role='button'])[49]")).click();
// Step 5: Wait for the Email to Arrive
driver.get("https://mail.google.com/mail/u/0/#inbox");
WebElement receivedEmail =
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Test
Mail']")));
// Step 6: Mark the Email as Starred
WebElement starButton =
receivedEmail.findElement(By.xpath("ancestor::tr//div[@role='checkbox']"));
starButton.click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("ancestor::tr//div[@arialabel='Starred']"))).click();
// Step 7: Open the Received Email
receivedEmail.click();
// Step 8: Verify the Email
WebElement emailLabel =
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='aKw']")));
assert emailLabel.getText().equals("Social");
WebElement emailSubject =
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'hP')
]")));
assert emailSubject.getText().equals("Test Mail");
WebElement emailBody=
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a3saiL']")))
;
assert emailBody.getText().equals("Test Email Body");
}
}

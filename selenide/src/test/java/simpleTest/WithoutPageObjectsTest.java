package simpleTest;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageObjects.AuthorisePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WithoutPageObjectsTest {

	@Test
	void authorization() {
		AuthorisePage authorisePage = new AuthorisePage();

		open("http://77.50.236.203:4881/#");

		$(By.name("email"))
				.shouldBe(visible)
				.sendKeys("user@pflb.ru");

		$(By.name("password"))
				.shouldBe(visible)
				.sendKeys("user");

		authorisePage.getUsersButton().click();

		$(".Nav-btn.btn.btn-primary").click();

		confirm();

		$(By.partialLinkText("Users")).click();

		$(By.partialLinkText("Create new")).click();

		$(".tableButton.btn.btn-primary").shouldBe(visible);
	}
}

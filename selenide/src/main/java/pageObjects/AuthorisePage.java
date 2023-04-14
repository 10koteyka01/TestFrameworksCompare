package pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthorisePage {

	public SelenideElement getUsersButton() {
		return $(".Nav-btn.btn.btn-primary");
	}
}

package NiceTry;

import mmarquee.automation.AutomationException;
import mmarquee.automation.UIAutomation;
import mmarquee.automation.controls.Application;
import mmarquee.automation.controls.ElementBuilder;
import mmarquee.automation.controls.Window;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculatorTest {

	@Test
	void sumTest() throws AutomationException {
		UIAutomation automation = UIAutomation.getInstance();

		Application application =
				new Application(
						new ElementBuilder()
								.automation(automation)
								.applicationPath("calc.exe"));

		try {
			application.launchOrAttach();
		} catch (Throwable ex) {
			System.err.println(ex);
		}

		assertNotNull(application);
		application.waitForInputIdle(Application.SHORT_TIMEOUT);

		Window window = automation.getDesktopWindow(
				Pattern.compile("Calculator"));

		assertNotNull(window);

		window.getButtonByAutomationId("clearButton").click();
		window.getButtonByAutomationId("num2Button").click();
		window.getButtonByAutomationId("plusButton").click();
		window.getButtonByAutomationId("num3Button").click();
		window.getButtonByAutomationId("equalButton").click();

		String text = window.getTextBoxByAutomationId("CalculatorResults").getName();

		assertEquals(text, "Display is 5", "Там не пятёрка");
	}
}

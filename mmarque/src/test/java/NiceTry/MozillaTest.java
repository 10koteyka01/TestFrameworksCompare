package NiceTry;

import mmarquee.automation.AutomationException;
import mmarquee.automation.UIAutomation;
import mmarquee.automation.controls.Application;
import mmarquee.automation.controls.ElementBuilder;
import mmarquee.automation.controls.TabItem;
import mmarquee.automation.controls.Window;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MozillaTest {
	@Test
	void openGoogle() throws AutomationException, AWTException {
		UIAutomation automation = UIAutomation.getInstance();

		Application application =
				new Application(
						new ElementBuilder()
								.automation(automation)
								.applicationPath("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));

		try {
			application.launchOrAttach();
		} catch (Throwable ex) {
			System.err.println(ex);
		}

		assertNotNull(application);
		application.waitForInputIdle(Application.SHORT_TIMEOUT);

		Window window = automation.getDesktopWindow(Pattern.compile("Mozilla Firefox"));

		assertNotNull(window);

		TabItem tabItem1 = window.getTabByAutomationId("tabbrowser-tabs").getTabItems().stream().filter(tabItem -> {
			try {
				return tabItem.getName().equals("Новая вкладка");
			} catch (AutomationException e) {
				throw new RuntimeException(e);
			}
		}).findFirst().get();

		assertNotNull(tabItem1);

		tabItem1.selectItem();

		window.getEditBoxByAutomationId("urlbar-input").setValue("google.com");
		window.getEditBoxByAutomationId("urlbar-input").invoke();

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);

		Window window1 = automation.getDesktopWindow(Pattern.compile("Google — Mozilla Firefox"));

		assertNotNull(window1);
	}
}

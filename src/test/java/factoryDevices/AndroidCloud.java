package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidCloud implements IDevice {
    @Override
    public AppiumDriver create() {
        DesiredCapabilities caps = new DesiredCapabilities();
        // Set your access credentials
        caps.setCapability("browserstack.user", "ximenasoto_HLM9FC");
        caps.setCapability("browserstack.key", "ZUCPUKyu7CoLREsk6kkR");
        // Set URL of the application under test
        caps.setCapability("app", "bs://5a998875000e78cbed5bc07722dc25f090769efb");
        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");
        // Set other BrowserStack capabilities
        caps.setCapability("project", "AUTOMATIZACION MOVILE XSOTO(EJERICIO_1)");
        caps.setCapability("build", "1.1");
        caps.setCapability("name", "whenDo");
        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = null;
        try {
             driver = new AndroidDriver<AndroidElement>(
                    new URL("http://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }


}
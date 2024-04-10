package Runners;

import Utilities.GWD;
import io.cucumber.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/transfer.feature"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class ParallelTransferRunnerTest extends AbstractTestNGCucumberTests {
    @BeforeClass // for parallel test
    @Parameters("browserType")
    public void beforeClass(String browserName) {
        GWD.threadBrowserName.set(browserName);
    }
}
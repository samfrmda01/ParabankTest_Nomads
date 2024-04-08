package Runners;

import Utilities.GWD;
import io.cucumber.testng.*;
import org.testng.annotations.*;

@CucumberOptions(
        tags = "@Payment and @Regression",
        features = {"src/test/java/FeatureFiles/transfer.feature"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class ParallelTransferRunnerTest extends AbstractTestNGCucumberTests {
//    @BeforeClass // for parallel test
//    @Parameters("browserType")
//    public void beforeClass(String browserName) {
//        GWD.threadBrowserName.set(browserName);
//    }
}
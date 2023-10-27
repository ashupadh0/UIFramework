package cucmber.Options;


import utils.CucumberHTMLReportGenerator;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"@target/rerun.txt"},
        plugin = {"html:target/cucumber/html", "json:target/cucumber.json"},
        monochrome = true,
        glue = {"stepdefinitions"})

public class TestRunnerRerun {

    @AfterClass
    public static void generateHTMLReport() {
        // Specify the paths to the JSON report directory and output directory
        String jsonReportDirectory = "target";
        String outputDirectory = "target/cucumber-report";

        // Generate the HTML report using the utility class
        CucumberHTMLReportGenerator.generateReport(jsonReportDirectory, outputDirectory);
    }


}

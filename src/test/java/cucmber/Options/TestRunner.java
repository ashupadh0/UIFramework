package cucmber.Options;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utils.CucumberHTMLReportGenerator;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/features"},
        plugin = {"html:target/cucumber/html", "json:target/cucumber.json","rerun:target/rerun"},
        monochrome = true,
        tags ="@TC01",
        glue = {"stepdefinitions"})

public class TestRunner {

    @AfterClass
    public static void generateHTMLReport() {
        String jsonReportDirectory = "target";
        String outputDirectory = "target/cucumber-report";
        CucumberHTMLReportGenerator.generateReport(jsonReportDirectory, outputDirectory);
    }


}

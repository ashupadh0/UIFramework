package utils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CucumberHTMLReportGenerator {

        public static void generateReport(String jsonReportDirectory, String outputDirectory) {
            // Create a list of JSON report files (usually just one)
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add(jsonReportDirectory + "/cucumber.json");

            // Configure the HTML report
            Configuration configuration = new Configuration(new File(outputDirectory) , "RestAssured_MyTesco");
            configuration.setBuildNumber("1.0.0");
            configuration.addClassifications("Environment", "PPE");
            configuration.addClassifications("Browser", "Chrome");
            configuration.addClassifications("Platform", "Windows 11");

            // Generate the HTML report
            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            reportBuilder.generateReports();
        }
    }

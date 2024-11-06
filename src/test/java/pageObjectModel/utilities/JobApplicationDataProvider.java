package pageObjectModel.utilities;

import org.testng.annotations.DataProvider;

public class JobApplicationDataProvider {
    @DataProvider(name = "jobApplicationData")
    public Object[][] getData() {
        return new Object[][]{
                {"John", "Doe", "john.doe@example.com", "1234567890"},
                {"Jane", "Smith", "jane.smith@example.com", "9876543253"}
        };
    }
}
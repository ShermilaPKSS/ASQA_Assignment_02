package pageObjectModel.utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class RequestDataProvider {

    @DataProvider(name = "requestData")
    public Object[][] getRequestData() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getDataFromExcel("C:/Users/Sachini/4th Year/support requests tests.xlsx");

    }
}


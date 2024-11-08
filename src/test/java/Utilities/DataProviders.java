package Utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProviders {
    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        String path = "./test-data/login-data.xlsx";

        ExcelUtility xlUtil = new ExcelUtility(path);

        int rows = xlUtil.getRowCount("LoginDetails");
        int cols = xlUtil.getCellCount("LoginDetails", 1);

        return xlUtil.getData("LoginDetails", rows, cols);
    }
}

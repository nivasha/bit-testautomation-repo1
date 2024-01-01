package Utils;


import Tests.TestBase;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataManager {

   @DataProvider(name = "loginCredentials")
    public Object[][] getData() throws IOException {
       //String path= System.getProperty("user.dir")+"/TestData/Data.xlsx";
      String path = "./"+TestBase.resource.getString("testDataSource");
       ExcelUtility excelUtility = new ExcelUtility(path);
       return excelUtility.readDate("Login");
   }
}

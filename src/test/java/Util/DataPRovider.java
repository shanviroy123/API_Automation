package Util;

import org.testng.annotations.DataProvider;

import java.io.File;

public class DataPRovider {
    @DataProvider(name= "API_TestData")
    public Object[][] getUserData() throws Exception{
        try{
            String path = System.getProperty("user.dir")+"\\src\\test\\resources\\API_TestData.xlsm";
            System.out.println(path);
            File file = new File(path);
            System.out.println("Exists : " + file.exists());
            System.out.println("Is File : " + file.isFile());
            return ExcelUtil.getData(path, "Users");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

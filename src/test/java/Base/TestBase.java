package Base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBase {
    protected RequestSpecification request;
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI= "https://reqres.in/api";
        request= RestAssured.given()
                .contentType("application/json")
                .header("x-api-key",
                        "pub_d1681a0a3dcacb9671635058b0e007c0c0ddca9df684f9c70996cd1b8327e430")
                .header("Accept", "application/json");
        System.out.println("Base URL Initiated");
    }
    @AfterMethod
    public void teardown(){
        System.out.println("Execution End");
    }
}

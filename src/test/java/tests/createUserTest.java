package tests;

import Base.TestBase;
import endpoints.Routes;
import Util.DataPRovider;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import payloads.User;

import javax.xml.crypto.Data;

import static io.restassured.RestAssured.given;

public class createUserTest extends TestBase {
    @Test(dataProvider = "API_TestData", dataProviderClass = DataPRovider.class)
    @Description("Verify User Creation API")
    @Owner("Shanvi Roy")
    public void createUSer(String name, String job){
        User user = new User();
        user.setname(name);
        user.setjob(job);
            request.body(user)
                    .when()
                    .post(Routes.Create_User)
                    .then().log().all();
    }
//        @Test
        public void testReqRes() {

            given()
                    .header("x-api-key",
                            "pub_d1681a0a3dcacb9671635058b0e007c0c0ddca9df684f9c70996cd1b8327e430")
                    .when()
                    .get("https://reqres.in/api/users/2")
                    .then()
                    .log().all();
    }
}

package tests;

import Base.TestBase;
import endpoints.Routes;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserTest extends TestBase {
    @Test
    public void verifyGetUser() {
        request.when()
                .get(Routes.Get_User)
                .then()
                .log().all()
                .statusCode(200);
        System.out.println("Helllo API");
    }
}

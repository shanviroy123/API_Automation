package tests;

import Base.TestBase;
import endpoints.Routes;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteuserTest extends TestBase {
    @Test
    public void DeleteMethod(){
        Response response= request.when().delete(Routes.Delete_User);
        response.then().log().all().statusCode(204);
        System.out.println("User Deleted");
    }

}

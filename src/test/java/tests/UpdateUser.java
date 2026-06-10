package tests;

import Base.TestBase;
import endpoints.Routes;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.User;

public class UpdateUser extends TestBase {
//    @Test
    public void Putmethod(){
        User user = new User();
        user.setname("Shanvi Roy");
        user.setjob("Senior QA Engineer");
        Response response= request.body(user).when().put(Routes.Update_User);
        response.then().log().all().statusCode(200);
        String name = response.jsonPath().getString("name");
        String job = response.jsonPath().getString("job");
        Assert.assertEquals(name, "Shanvi Roy");
        System.out.println(response.asPrettyString());
    }
    @Test
    public void PatchMEthod() {
        User user = new User();
        user.setjob("Automation Lead");
        String patchBody = """
        {
           "job":"Automation Lead"
        }
        """;
        Response response = request.body(patchBody).when().patch(Routes.Patch_User);
        response.then().log().all().statusCode(200);
        String Job= response.jsonPath().getString("job");
        Assert.assertEquals(Job, "Automation Lead");
        System.out.println(response.asPrettyString());
    }
}

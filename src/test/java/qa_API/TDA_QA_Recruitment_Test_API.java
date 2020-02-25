package qa_API;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TDA_QA_Recruitment_Test_API {
    @Test
    public void healthCheck() { // Working
        System.out.println("Health Check");
        Response response = given().when()
                .header("app-locale", "en_GB", "de_DE")
                .header("x-api-key", "1b34X9pNjg5lMvRAXLNTS85TQgrzoYLEa3LUQ6Wh")
                .get("https://4s9rh46bpe.execute-api.eu-central-1.amazonaws.com/test/healthcheck");
        response.prettyPrint();
//        response.then().assertThat().statusCode(200).and();
    }

    @Test
    public void availableBookings() { // Working
        System.out.println("Available Booking");
        Response response = given().when()
                .header("device-os", "android", "ios")
                .header("app-locale", "en_GB", "de_DE")
                .header("x-api-key", "1b34X9pNjg5lMvRAXLNTS85TQgrzoYLEa3LUQ6Wh")
                .header("login-token", "1581888331779")
                .get("https://4s9rh46bpe.execute-api.eu-central-1.amazonaws.com/test/v1/bookings");
        response.prettyPrint();
    }

    @Test
    public void bookingInfo() { // Working
        System.out.println("Booking Info");
        Response response = given()
                .header("device-os", "android", "ios")
                .header("app-locale", "en_GB", "de_DE")
                .header("x-api-key", "1b34X9pNjg5lMvRAXLNTS85TQgrzoYLEa3LUQ6Wh")
                .header("login-token", "1581888331779")
                .header("id", "AC45934")
                .get("https://4s9rh46bpe.execute-api.eu-central-1.amazonaws.com/test/v1/bookings/ADE9452");
        response.prettyPrint();
    }

    @Test
    public void weather() { // Working
        System.out.println("Weather");
        Response response = given()
                .header("device-os", "android", "ios")
                .header("app-locale", "en_GB", "de_DE")
                .header("x-api-key", "1b34X9pNjg5lMvRAXLNTS85TQgrzoYLEa3LUQ6Wh")
                .header("login-token", "1581888331779")
                .header("id", "AC45934")
                .get("https://4s9rh46bpe.execute-api.eu-central-1.amazonaws.com/test/v1/bookings/ADE9452/weather");
        response.prettyPrint();

    }

    @Test
    public void loginDE() { // Working
        System.out.println("Login DE");
        String payload = "{\n" +
                "    \"username\": \"test\",\n" +
                "    \"password\": \"test\"\n" +
                "}";
        Response response = given()
                .header("device-os", "android", "ios")
                .header("app-locale", "en_GB", "de_DE")
                .header("x-api-key", "1b34X9pNjg5lMvRAXLNTS85TQgrzoYLEa3LUQ6Wh")
                .contentType("application/json").when().body(payload)
                .post("https://4s9rh46bpe.execute-api.eu-central-1.amazonaws.com/test/auth/login");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void loginUK() { // Working
        System.out.println("Login UK");
        Response response = given().when()
                .param("bookingRef", "AR58930")
                .param("surname", "Smith")
                .and()
                .header("device-os", "ios")
                .header("app-locale", "en_GB")
                .header("x-api-key", "1b34X9pNjg5lMvRAXLNTS85TQgrzoYLEa3LUQ6Wh")
                .get("https://4s9rh46bpe.execute-api.eu-central-1.amazonaws.com/test/auth/login");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }
}

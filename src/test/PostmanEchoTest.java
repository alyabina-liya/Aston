import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    @Test
    public void testGetMethodPostmanEcho() {
        given()
                .baseUri("https://postman-echo.com")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().all()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostMethodEchoRawText() {
        String requestBody = "{\"text\":\"value\"}";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.text", equalTo("value"));
    }

    @Test
    public void testPostMethodEchoFormData() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPutMethodEchoRequest() {
        String requestBody = "{\"text\": \"This is expected to be sent back as part of response body.\"}";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json; charset=utf-8")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.text", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void testPatchMethodEchoRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=utf-8")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/patch"));

    }

    @Test
    public void testDeleteMethodEchoRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=utf-8")
                .body(requestBody)
                .when()
                .delete("delete")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("json", is(nullValue()))
                .body("url", equalTo("https://postman-echo.com/delete"));

    }
}




package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class ApiSpecs {
    public static RequestSpecification requestSpec = with()
            .log().uri()
            .log().headers()
            .log().method()
            .contentType(JSON)
            .log().body();

    public static ResponseSpecification responseSpecReference = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();
}

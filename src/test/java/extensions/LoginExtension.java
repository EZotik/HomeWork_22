package extensions;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;
import models.ApiTestModel;
import models.ApiTestesResponseModel;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.ApiSpecs.requestSpec;
import static specs.ApiSpecs.responseSpecReference;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
    ApiTestModel authData = new ApiTestModel();
        authData.setUserName("IvanZero");
        authData.setPassword("wb3R2J4Pty@fZFx");

    ApiTestesResponseModel response = step("Добавить cookies в браузер", ()->given(requestSpec)
            .body(authData)
            .when()
            .post("/Account/v1/Login")
            .then()
            .spec(responseSpecReference)
            .extract().as(ApiTestesResponseModel.class));

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", response.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", response.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", response.getExpires()));

}
}

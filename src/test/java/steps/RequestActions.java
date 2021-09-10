package steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.experimental.UtilityClass;

import static io.restassured.RestAssured.given;

@UtilityClass
public final class RequestActions {

    @Step("Request PUT to endpoint - {endpoint}")
    public static ValidatableResponse put(String endpoint, RequestSpecification reqSpec, ResponseSpecification respSpec) {
        return given()
                .spec(reqSpec)
                .when().log().all()
                .put(endpoint)
                .then().log().all()
                .spec(respSpec);
    }

    @Step("Request POST to endpoint - {endpoint}")
    public static ValidatableResponse post(String endpoint, RequestSpecification reqSpec, ResponseSpecification respSpec) {
        return given()
                .spec(reqSpec)
                .when().log().all()
                .post(endpoint).then().log().all()
                .spec(respSpec);
    }

    @Step("Request DELETE to endpoint - {endpoint}")
    public static ValidatableResponse delete(String endpoint, RequestSpecification reqSpec, ResponseSpecification respSpec) {
        return given()
                .spec(reqSpec)
                .when().log().all()
                .delete(endpoint)
                .then().log().all()
                .spec(respSpec);
    }

    @Step("Request GET to endpoint - {endpoint}")
    public static ValidatableResponse get(String endpoint, RequestSpecification reqSpec, ResponseSpecification respSpec) {
        return given()
                .spec(reqSpec)
                .when().log().all()
                .get(endpoint)
                .then().log().all()
                .spec(respSpec);
    }
}

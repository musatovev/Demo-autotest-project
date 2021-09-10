package autotest;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import org.apache.http.entity.mime.HttpMultipartMode;
import utils.CustomProperties;

import java.nio.charset.StandardCharsets;

import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.config.MultiPartConfig.multiPartConfig;

public abstract class BaseTestClass {
    public static final String BASE_URL = CustomProperties.getProperty("baseURL");
    public static final String TOKEN = CustomProperties.getProperty("token");

    @Getter
    protected static RequestSpecification specification;


    protected RequestSpecBuilder getInitialBuilder() {
        return new RequestSpecBuilder()
                .setUrlEncodingEnabled(false)
                .setContentType(ContentType.JSON)
                .setConfig(RestAssuredConfig.config()
                        .httpClient(HttpClientConfig.httpClientConfig().httpMultipartMode(HttpMultipartMode.BROWSER_COMPATIBLE))
                        .multiPartConfig(multiPartConfig().defaultCharset(StandardCharsets.UTF_8))
                        .encoderConfig(encoderConfig().defaultCharsetForContentType(StandardCharsets.UTF_8, "multipart/form-data")))
                .addFilter(new AllureRestAssured());
    }

    /**
     * Create a default specification for REST Assured
     */
    protected void changeDefaultSpecification() {
        specification = getInitialBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Authorization", TOKEN)
                .build();
    }

    protected RequestSpecification specWithPath(String path) {
        return getInitialBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Authorization", TOKEN)
                .addParam("path", path)
                .build();
    }
}

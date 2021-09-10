package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import lib.Responses.Folder.EmbeddedItem;
import lombok.experimental.UtilityClass;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.*;

@UtilityClass
public final class ResponseSpecifications {

    public static ResponseSpecification SIMPLE_OK() {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_OK)
                .build();
    }

    public static ResponseSpecification SIMPLE_CREATED() {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_CREATED)
                .build();
    }

    public static ResponseSpecification ITEM_CREATED_OR_EXISTED() {
        return new ResponseSpecBuilder()
                .expectStatusCode(anyOf(equalTo(SC_CREATED), equalTo(SC_CONFLICT)))
                .build();
    }

    public static ResponseSpecification CHECK_SHA256(EmbeddedItem file) {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_OK)
                .expectBody("_embedded.items.sha256", containsInAnyOrder(file.getAdditionalProperties().get("sha256")))
                .build();
    }

    public static ResponseSpecification SIMPLE_ACCEPTED_OR_NOT_FOUND() {
        return new ResponseSpecBuilder()
                .expectStatusCode(anyOf(
                        equalTo(SC_ACCEPTED), equalTo(SC_NOT_FOUND)))
                .build();
    }

    public static ResponseSpecification SIMPLE_ACCEPTED_OR_NO_CONTENT() {
        return new ResponseSpecBuilder()
                .expectStatusCode(anyOf(
                        equalTo(SC_ACCEPTED), equalTo(SC_NO_CONTENT)))
                .build();
    }

    public static ResponseSpecification BAD_REQUEST() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(SC_BAD_REQUEST)
                .build();
    }

    public static ResponseSpecification NOT_FOUND() {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_NOT_FOUND)
                .build();
    }

    public static ResponseSpecification UNAUTHORIZED() {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_UNAUTHORIZED)
                .build();
    }

    public static ResponseSpecification FORBIDDEN() {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_FORBIDDEN)
                .build();
    }
}
package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class TestSchema {

    @Test
    void testSchema() {
        given()
            .baseUri("http://localhost:9999/api/v1")
                .get("/demo/accounts")
                .then()
                    .statusCode(200)
                    .body(matchesJsonSchemaInClasspath("accounts.schema.json"));

    }

}

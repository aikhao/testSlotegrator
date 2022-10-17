package com.testslotegrator.api.helper;

import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.module.jsv.JsonSchemaValidatorSettings;

public class CheckHelper {
    /**
     * Возвращает настроенный поиск по указанной схеме
     * @param pathSchema - путь относительно папки test/resources
     * @return Matcher
     */
    @Step("Настроить схему для проверки по пути '{pathSchema}'")
    public static Matcher<?> setJsonSchema(String pathSchema) {
        return JsonSchemaValidator.matchesJsonSchemaInClasspath(pathSchema)
                .using(JsonSchemaValidatorSettings.settings().with().checkedValidation(true));
    }
}

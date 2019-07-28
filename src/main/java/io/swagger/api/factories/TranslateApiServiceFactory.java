package io.swagger.api.factories;

import io.swagger.api.TranslateApiService;
import io.swagger.api.impl.TranslateApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-07-28T00:28:40.311Z")
public class TranslateApiServiceFactory {
    private final static TranslateApiService service = new TranslateApiServiceImpl();

    public static TranslateApiService getTranslateApi() {
        return service;
    }
}

package io.swagger.api;

import io.swagger.model.Data;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-07-28T00:28:40.311Z")
public abstract class TranslateApiService {
    public abstract Response securityAuth(Data data, SecurityContext securityContext) throws NotFoundException;
}

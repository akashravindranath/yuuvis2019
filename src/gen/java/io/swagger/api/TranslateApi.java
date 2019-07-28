package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.api.factories.TranslateApiServiceFactory;
import io.swagger.model.Data;

import javax.servlet.ServletConfig;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/translate")


@io.swagger.annotations.Api(description = "the translate API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-07-28T00:28:40.311Z")
public class TranslateApi  {
   private final TranslateApiService delegate;

   public TranslateApi(@Context ServletConfig servletContext) {
      TranslateApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("TranslateApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (TranslateApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = TranslateApiServiceFactory.getTranslateApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "---", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "SUCCESS", response = Void.class),
        @io.swagger.annotations.ApiResponse(code = 202, message = "ACCEPTED", response = Void.class),

        @io.swagger.annotations.ApiResponse(code = 401, message = "FAILURE", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected Error", response = Void.class) })
    public Response securityAuth(@ApiParam(value = "" ,required=true) Data data
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.securityAuth(data,securityContext);
    }
}

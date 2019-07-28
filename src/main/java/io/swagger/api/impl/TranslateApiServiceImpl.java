package io.swagger.api.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.api.TranslateApiService;
import io.swagger.model.Data;
import io.swagger.model.DataInner;
import okhttp3.*;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-07-28T00:28:40.311Z")
public class TranslateApiServiceImpl extends TranslateApiService {

    @Override
    public Response securityAuth(Data data, SecurityContext securityContext) throws NotFoundException {

        ObjectMapper objectMapper = new ObjectMapper();
        TranslateText translateText = new TranslateText();
        for (DataInner dataInner : data){
            String tr = translateText.translateText(dataInner.getText());
            if(tr != null){
                dataInner.setText(tr);
            }

        }

        JsonNode jsonNode = objectMapper.convertValue(data, JsonNode.class);
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode objectNode = factory.objectNode();
        objectNode.put("data", jsonNode);

        // call ML
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://a001e8be.ngrok.io/api/yuuvis_sentiment_analysis")
                .post(RequestBody.create(MediaType.parse("application/json"), String.valueOf(objectNode)))
                .build();

        Call call = client.newCall(request);
        try {
            okhttp3.Response response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.ok().entity(objectNode).build();
    }

}

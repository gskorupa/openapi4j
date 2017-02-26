/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen;

import com.cedarsoftware.util.io.JsonWriter;
import java.util.HashMap;
import java.util.Map;
import org.cricketmsf.apigen.openapi.Info;
import org.cricketmsf.apigen.openapi.OpenApi;
import org.cricketmsf.apigen.openapi.OpenApiException;
import org.cricketmsf.apigen.openapi.PathItem;
import org.cricketmsf.apigen.openapi.Server;
import org.cricketmsf.apigen.openapi.path.OperationObject;
import org.cricketmsf.apigen.openapi.path.ParameterObject;
import org.cricketmsf.apigen.openapi.path.RequestBodyObject;
import org.cricketmsf.apigen.openapi.path.Response;
import org.cricketmsf.apigen.openapi.path.Schema;

/**
 *
 * @author greg
 */
public class CricketApiGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        CricketApiGen me = new CricketApiGen();
        me.test();
    }

    public void test() {
        OpenApi api = new OpenApi();
        try {
            api.setVersion("1", "0", "0");
            api.info = getInfo("Cricket API", "Sample API definition");
            api.addServer(
                getServer("http://localhost:8080/api", "Production server")
            );
            api.addServer(
                getServer("http://localhost:9090/api", "Development server")
            );
            api.addPath("/", getPathItem("/", "echoAdapter", "accessing main object resource"));
        } catch (OpenApiException e) {
            e.printStackTrace();
        }

        // print the API
        if (!api.isValid()) {
            System.out.println("API is not valid!");
        }
        Map args = new HashMap();
        args.put(JsonWriter.PRETTY_PRINT, true);
        args.put(JsonWriter.TYPE, false);
        args.put(JsonWriter.SKIP_NULL_FIELDS, true);
        System.out.println(JsonWriter.objectToJson(api, args));

    }

    // adapterName & description from cricket.json
    PathItem getPathItem(String path, String adapterName, String description) throws OpenApiException{
        PathItem pathItem = new PathItem();
        pathItem.description = description;

        // GET 
        pathItem.addOperation("get", getOperation(path, adapterName, "GET"));
        //end GET

        // POST
        // PUT
        // DELETE
        return pathItem;
    }

    private OperationObject getOperation(String path, String adapterName, String method) throws OpenApiException{
        OperationObject operation = new OperationObject();
        operation.description = "this is operation verbose description";
        operation.summary = "this is short summary";
        operation.operationId = "methodName"; // service method
        
        operation.addParameter(
                new ParameterObject()
                        .setIn("path")
                        .setName("objId")
                        .setRequired(true)
                        .setStyleDefault()
                        .setSchema(new Schema("string", null))
                        .validate(path)
        );
        
        // optional
        // operation.requestBody = new RequestBodyObject();
        // description, required, contentType
        
        //TODO: responses
        operation.addResponse(
                "200",
                new Response().
                        setDescription("An object to be returned")
                        .addContent("text/plain", "string", "binary")
                        .addContent("application/json", "#/definitions/MyObject")
                
        );
        operation.addResponse(
                "405",
                new Response().
                        setDescription("invalid input")
                
        );
        return operation;
    }

    private Info getInfo(String title, String description) {
        Info info = new Info();
        info.title = title;
        info.description = description;
        return info;
    }
    
    private Server getServer(String url, String description){
        Server server = new Server();
        server.url = url;
        server.description = description;
        server.templates = null; //TODO: templates not supported
        return server;
    }

}

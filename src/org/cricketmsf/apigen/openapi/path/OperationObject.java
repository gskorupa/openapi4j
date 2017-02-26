/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi.path;

import java.util.ArrayList;
import java.util.HashMap;
import org.cricketmsf.apigen.openapi.ExternalDocumentation;
import org.cricketmsf.apigen.openapi.SecurityRequirement;
import org.cricketmsf.apigen.openapi.Server;

/**
 *
 * @author greg
 */
public class OperationObject {
    
    public ArrayList<String> tags = null;
    public String summary = null;
    public String description = null;
    public HashMap<String,ExternalDocumentation> externalDocs = null;
    public String operationId = null;
    public ArrayList<Parameter> parameters = null;
    public RequestBody requestBody = null;
    public HashMap<String,Response> responses = null;
    //public HashMap callbackResponses
    public boolean deprecated = false;
    public ArrayList<SecurityRequirement> security = null;
    public ArrayList<Server> servers = null;
    
    public void addResponse(String code, Response response){
        if(responses == null){
            responses = new HashMap<>();
        }
        responses.put(code, response);
    }
    
    public void addParameter(ParameterObject parameter){
        if(parameters == null){
            parameters = new ArrayList<>();
        }
        parameters.add(parameter);
    }
}

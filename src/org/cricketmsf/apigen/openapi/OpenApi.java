/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * https://github.com/OAI/OpenAPI-Specification/blob/OpenAPI.next/versions/3.0.md
 * 
 * @author greg
 */
public class OpenApi {
    
    public String version = null;
    public Info info = null;
    public ArrayList<Server> servers = null;
    public HashMap<String,PathItem> paths = null;
    public HashMap<String,Component> components = null;
    public ArrayList<SecurityRequirement> securityRequirements = null;
    public ArrayList<Tag> tags = null;
    public ExternalDocumentation externalDocs = null;
 
    /**
     * Validates OpenAPI specification
     * 
     * @return 
     */
    public boolean isValid(){
        boolean valid = true;
        valid = valid &&
                (version != null && info != null && paths != null);
        return valid;
    }
    
    public void addPath(String pathName, PathItem item) throws OpenApiException{
        if(paths == null){
            paths = new HashMap<>();
        }
        if(pathName==null ||pathName.isEmpty()){
            throw new OpenApiException("pathName value error");
        }
        if(item==null){
            throw new OpenApiException("item is  null");
        }
        paths.put(pathName, item);
    }
    
    public void addServer(Server server) throws OpenApiException{
        if(servers ==null ){
            servers = new ArrayList<>();
        }
        if(server==null){
            throw new OpenApiException("server is  null");
        }
        servers.add(server);
    }
    
    public void addSecurityRequirement(SecurityRequirement requirement) throws OpenApiException{
        if(securityRequirements == null ){
            securityRequirements = new ArrayList<>();
        }
        if(requirement==null){
            throw new OpenApiException("requirement is  null");
        }
        securityRequirements.add(requirement);
    }
    
    public void addTag(Tag tag) throws OpenApiException{
        if(tags ==null ){
            tags = new ArrayList<>();
        }
        if(tag==null){
            throw new OpenApiException("tag is  null");
        }
        tags.add(tag);
    }
    
    public void setVersion(String major, String minor, String patch) throws OpenApiException {
        // TODO: check format instead
        if((major != null && minor != null && patch != null) && (!major.isEmpty() && !minor.isEmpty() && !patch.isEmpty())){
            //
        }else{
            throw new OpenApiException("wrong version format");
        }
        version = major+"."+minor+"."+patch;
    }
}
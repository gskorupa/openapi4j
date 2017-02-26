/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi.path;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author greg
 */
public class Response {

    String description = null;
    ArrayList headers = null;
    HashMap<String, ContentType> content = null;
    Object links = null;

    //TODO: content, links
    //TODO: change isValid to validate throwing exception?
    public boolean isValid() {
        return description != null;
    }
    
    public Response(){
        
    }

    public Response setDescription(String description) {
        this.description = description;
        return this;
    }
    
    public Response addContent(String name, String type, String format) {
        if(content==null){
            content = new HashMap<>();
        }
        content.put(name, new ContentType().setSchema(type, format));
        return this;
    }
    
    public Response addContent(String name, String reference) {
        if(content==null){
            content = new HashMap<>();
        }
        content.put(name, new ContentType().setSchema(reference));
        return this;
    }
}


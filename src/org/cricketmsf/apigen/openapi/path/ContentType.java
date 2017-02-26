/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi.path;

import java.util.ArrayList;

/**
 *
 * @author greg
 */
public class ContentType {
    
    public Schema schema = null;
    public ArrayList<ExampleObject> examples = null;
    public ExampleObject example = null;
    
    public ContentType setSchema(String type, String format){
        schema = new Schema(type,format);
        return this;
    }
    
    public ContentType setSchema(String reference){
        schema = new Schema().setReference(reference);
        return this;
    }
    
    public void addExample(ExampleObject example){
        if(examples == null){
            examples = new ArrayList<>();
        }
        examples.add(example);
    }
    
    public void setExample(ExampleObject example){
        this.example = example;
    }
    
}

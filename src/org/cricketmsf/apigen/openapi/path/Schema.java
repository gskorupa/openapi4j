/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi.path;

/**
 *
 * @author greg
 */
public class Schema {
    
    public String type;
    public String format;
    public String $ref;
    
    public Schema(){
        
    }
    public Schema(String type, String format){
        this.type=type;
        this.format=format;
    }
    
    public Schema setReference(String reference){
        $ref=reference;
        return this;
    }
    
}

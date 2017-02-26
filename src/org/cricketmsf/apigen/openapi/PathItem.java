/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi;

import java.util.ArrayList;
import java.util.HashMap;
import org.cricketmsf.apigen.openapi.path.OperationObject;
import org.cricketmsf.apigen.openapi.path.Parameter;

/**
 *
 * @author greg
 */
public class PathItem {
    
    public String ref = null;
    public String summary = null;
    public String description;
    public HashMap<String,OperationObject> operations = null;
    public ArrayList<Server> servers = null;
    public ArrayList<Parameter> parameter = null;
    
    public void addOperation(String name, OperationObject operation){
        if(operations == null){
            operations = new HashMap<>();
        }
        operations.put(name, operation);
    }
    
    public void addDefault(OperationObject operation){
        if(operations == null){
            operations = new HashMap<>();
        }
        operations.put("default", operation);
    }
    
}

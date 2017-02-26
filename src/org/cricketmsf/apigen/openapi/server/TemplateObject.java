/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi.server;

import java.util.ArrayList;

/**
 *
 * @author greg
 */
public class TemplateObject {
    
    public ArrayList enumList = null;
    public String defaultValue = null;
    public String description = null;
    
    public boolean isValid(){
        boolean valid = defaultValue != null;
        //TODO: validate 
        return valid;
    } 
}

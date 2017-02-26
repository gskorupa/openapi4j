/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi.info;

/**
 *
 * @author greg
 */
public class License {
    
    public String name = null;
    public String url = null;
    
    public boolean isValid(){
        boolean valid = true;
        //TODO: validate url and name!=null
        return valid;
    }
    
}

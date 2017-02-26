/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi.path;

import java.util.HashMap;

/**
 *
 * @author greg
 */
public class RequestBodyObject extends RequestBody{
    //TODO:
    String description = null;
    HashMap<String,ContentType> content = null;
    Boolean required = null;
    
}

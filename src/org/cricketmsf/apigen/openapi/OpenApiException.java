/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi;

/**
 *
 * @author greg
 */
public class OpenApiException extends Exception{
    
    public OpenApiException(String message) {
        super(message);
    }

    public OpenApiException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
}

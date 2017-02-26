/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi;

import org.cricketmsf.apigen.openapi.info.Contact;
import org.cricketmsf.apigen.openapi.info.License;

/**
 *
 * @author greg
 */
public class Info {

    public String title = null;
    public String description = null;
    public String termsOfService = null;
    public Contact contact = null;
    public License license = null;
    public String version = null;

    public boolean isValid() {
        return title != null && version != null;
    }

}

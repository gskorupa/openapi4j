/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cricketmsf.apigen.openapi.path;

import java.util.Arrays;
import org.cricketmsf.apigen.openapi.OpenApiException;

/**
 *
 * @author greg
 */
public class ParameterObject extends Parameter {

    //TODO:
    String name = null;
    String in = null;
    String description = null;
    public Boolean required = false;
    public Boolean deprecated = null;
    public Boolean allowEmptyValue = null;
    public Schema schema;
    String style = null;
    //TODO: other properties

    public ParameterObject setIn(String in) {
        this.in = in;
        return this;
    }

    public ParameterObject setName(String name) {
        this.name = name;
        return this;
    }

    public ParameterObject setRequired(boolean required) {
        this.required = required;
        return this;
    }

    public ParameterObject setStyleForm() {
        style = "form";
        return this;
    }

    public ParameterObject setStyleSimple() {
        style = "simple";
        return this;
    }

    public ParameterObject setStyle(String style) {
        this.style = style;
        return this;
    }

    public ParameterObject setStyleDefault() {
        switch (in) {
            case "path":
            case "header":
                style = "simple";
                break;
            case "query":
            case "cookie":
                style = "form";
        }
        return this;
    }

    public ParameterObject setSchema(Schema schema) {
        this.schema = schema;
        return this;
    }

    public ParameterObject validate(String path) throws OpenApiException {
        String[] allowed = {"query", "header", "path", "formData", "cookie"};
        if (!Arrays.asList(allowed).contains(in)) {
            throw new OpenApiException(in + " value is not allowed");
        }
        if (!(name != null || name.isEmpty())) {
            throw new OpenApiException("empty parameter name");
        }
        if (in.equals("path") && !required) {
            throw new OpenApiException("parameter must be required");
        }
        /*
        if(in.equals("path") && path.indexOf("{"+name+"}")<0){
            throw new OpenApiException("parameter name not found in path");
        }
         */
        return this;
    }
}

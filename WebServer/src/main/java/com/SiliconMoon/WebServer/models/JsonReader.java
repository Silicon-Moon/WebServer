package com.SiliconMoon.WebServer.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public JsonReader
{
    //Fields
    private JSONObject json;
    
    //Constructor
    Public JsonReader(String url)
    {
        json = readJsonFromUrl(url);
    }
    
    //Methods
    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          JSONObject json = new JSONObject(jsonText);
          return json;
        } finally {
          is.close();
        }
    }
    
    public boolean isResponse()
    {
        return json.get("response").equals("True");
    }
    
    public String getField(String field)
    {
        return json.get(field);
    }
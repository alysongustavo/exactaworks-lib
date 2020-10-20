package br.com.alyson.clientexactaworks.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EndPoint {

    public static String obterEndPoint(){

        try{
            Properties properties = new Properties();
            properties.load(EndPoint.class.getResourceAsStream("/enviroment.properties"));
            return properties.getProperty("endpoint");
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return "";
    }
}

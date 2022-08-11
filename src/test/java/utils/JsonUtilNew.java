package utils;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtilNew {

    private static ObjectMapper mapper;

    static {

        mapper = new ObjectMapper();
    }

    //convert jason the java object

          public static  <T> T convertJsonToJavaObject(String json,Class<T> cls){

       T NewJava =  null;
              try {
                  NewJava =  mapper.readValue(json,cls);
              } catch (IOException e) {
                  System.out.println("json couldn t be converted to java "+e.getMessage());
              }
                return NewJava;
          }

          //convert java to json

    public  static String convertJavaObjectToJson(Object obj){
        String newJson = null;
        try {
            newJson = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            System.out.println("java couldnt be converted to json "+e.getMessage());
        }
        return newJson;
    }


}
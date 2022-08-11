package exercise11Aug;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil01 {

    private static ObjectMapper mapper;

    static {

        mapper = new ObjectMapper();
    }

    //convert json to java object
    public static <T> T convertJsonToJavaObject(String json,Class<T> cls){
        T javaResult = null;
        try {
            javaResult = mapper.readValue(json,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return javaResult;
    }

    //convert java object to json
    public static String convertJavaObjectToJson(Object obj){
        String jsonResult = null;

        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
           e.printStackTrace();
        }
        return jsonResult;
    }


}

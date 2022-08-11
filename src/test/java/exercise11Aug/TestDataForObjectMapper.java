package exercise11Aug;

public class TestDataForObjectMapper {
/*
    {
                "userId": 10,
                "title": "quis eius est sint explicabo",
                "completed": true
    }

 */
    public String expectedDataInString(Integer userId,String title,Boolean completed){

        String expected =   "{\n" +
                "                \"userId\": "+userId+",\n" +
                "                \"title\": \""+title+"\",\n" +
                "                \"completed\": "+completed+"\n" +
                "    }"   ;
        return expected;
    }
}

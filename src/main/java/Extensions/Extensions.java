package Extensions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.response.Response;
import java.io.FileWriter;
import java.io.IOException;

public class Extensions {
    String filePath = "C:\\Snowden\\Programing_School\\JobHunt\\ApiTesting\\src\\test\\java\\Result\\";

    public void JsonToFileFromTest(String fileName, Response json) throws JsonProcessingException {
        String text = PrettyJsonFormatter(json);
        WriteFile(fileName, text);
    }

    private String PrettyJsonFormatter(Response json) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Object[] objects = mapper.readValue(json.getBody().asString(), Object[].class);

        String prettyJson = mapper.writeValueAsString(objects);

        return prettyJson;
    }

    private void WriteFile(String fileName, String text) {
        try {
            FileWriter myFile = new FileWriter(filePath+fileName);
            myFile.write(text);
            myFile.close();
        } catch (IOException e){
            System.out.println("An error accured.");
            e.printStackTrace();
        }
    }
}

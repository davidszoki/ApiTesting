package Extensions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Extensions {
    public String PretyJsonFormatter(String json) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Object[] objects = mapper.readValue(json, Object[].class);

        String prettyJson = mapper.writeValueAsString(objects);

        return prettyJson;
    }
    // Maybe connect to each other that call one
    //TODO: make finish file writer function
    public void WriteFile(String filePath, String string){

    }
}

package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "[{\"name\": \"Middlesbrough College\", \"state-province\": null, \"domains\": [\"middlesbro.ac.uk\", \"mbro.ac.uk\"], \"web_pages\": [\"https://www.mbro.ac.uk/\"], \"alpha_two_code\": \"GB\", \"country\": \"United Kingdom\"}, {\"name\": \"Middlesex Community College\", \"state-province\": null, \"domains\": [\"middlesex.mass.edu\"], \"web_pages\": [\"http://www.middlesex.mass.edu\"], \"alpha_two_code\": \"US\", \"country\": \"United States\"}, {\"name\": \"Middlesex County College\", \"state-province\": null, \"domains\": [\"middlesexcc.edu\"], \"web_pages\": [\"http://www.middlesexcc.edu\"], \"alpha_two_code\": \"US\", \"country\": \"United States\"}, {\"name\": \"Middlesex University - London\", \"state-province\": null, \"domains\": [\"mdx.ac.uk\"], \"web_pages\": [\"https://www.mdx.ac.uk/\"], \"alpha_two_code\": \"GB\", \"country\": \"United Kingdom\"}, {\"name\": \"Middle Georgia State College\", \"state-province\": null, \"domains\": [\"mga.edu\"], \"web_pages\": [\"http://www.mga.edu/\"], \"alpha_two_code\": \"US\", \"country\": \"United States\"}, {\"name\": \"Middle Tennessee State University\", \"state-province\": null, \"domains\": [\"mtsu.edu\"], \"web_pages\": [\"http://www.mtsu.edu/\"], \"alpha_two_code\": \"US\", \"country\": \"United States\"}, {\"name\": \"Middle East University\", \"state-province\": null, \"domains\": [\"meu.edu.jo\"], \"web_pages\": [\"http://www.meu.edu.jo/\"], \"alpha_two_code\": \"JO\", \"country\": \"Jordan\"}, {\"name\": \"Middle East Technical University\", \"state-province\": null, \"domains\": [\"metu.edu.tr\"], \"web_pages\": [\"http://www.metu.edu.tr/\"], \"alpha_two_code\": \"TR\", \"country\": \"Turkey\"}, {\"name\": \"American University of Middle East\", \"state-province\": null, \"domains\": [\"aum.edu.kw\"], \"web_pages\": [\"http://www.aum.edu.kw/\"], \"alpha_two_code\": \"KW\", \"country\": \"Kuwait\"}, {\"name\": \"Middlebury College\", \"state-province\": null, \"domains\": [\"middlebury.edu\"], \"web_pages\": [\"http://www.middlebury.edu/\"], \"alpha_two_code\": \"US\", \"country\": \"United States\"}]";

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Object[] objects = mapper.readValue(json, Object[].class);

        String prettyJson = mapper.writeValueAsString(objects);
        System.out.println(prettyJson);
    }
}
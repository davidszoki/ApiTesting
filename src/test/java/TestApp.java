import Extensions.Extensions;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestApp {
    ArrayList<String> parametersList = new ArrayList<>();
    Extensions extensions = new Extensions();
    String BaseUrl = "http://universities.hipolabs.com";
    String SearchBarForName = "/search?name=";
    String FilePath = "C:\\Snowden\\Programing_School\\JobHunt\\ApiTesting\\src\\test\\java\\resources\\SearchParameters.csv";


    @Test
    void pingUniversity(){
        Response responsePing = RestAssured.get(BaseUrl);
        responsePing.print();

        Assertions.assertEquals(responsePing.getStatusCode(), 200);
    }

    @Test
    void searchByName() throws FileNotFoundException, JsonProcessingException {
        Scanner sc = new Scanner(new File(FilePath));
        sc.useDelimiter(";");

        while (sc.hasNext()) {
            String parameter = sc.next().trim();
            String[] subParameters = parameter.split("\\s+");
            for (String subParameter : subParameters) {
                parametersList.add(subParameter);
            }
        }

        for (String parameter : parametersList) {
            Response searchDetails = RestAssured.get(BaseUrl + SearchBarForName + parameter);
            Assertions.assertEquals(searchDetails.getStatusCode(), 200);
            extensions.JsonToFileFromTest(parameter, searchDetails);
        }
    }
}

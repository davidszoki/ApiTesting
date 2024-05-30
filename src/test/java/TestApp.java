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
    ArrayList<String> NameList = new ArrayList<>();
    ArrayList<String> CountryList = new ArrayList<>();
    Extensions extensions = new Extensions();
    String BaseUrl = System.getenv("BASE_URL");
    String FileName = System.getenv("FILE_NAME");
    String SearchBarForName = System.getenv("SEARCH_NAME");
    String FileCountry = System.getenv("FILE_COUNTRY");
    String SearchBarForCountry = System.getenv("SEARCH_COUNTRY");

    @Test
    void pingUniversity(){
        Response responsePing = RestAssured.get(BaseUrl);
        responsePing.print();

        Assertions.assertEquals(responsePing.getStatusCode(), 200);
    }

    @Test
    void searchByName() throws FileNotFoundException, JsonProcessingException {
        Scanner sc = new Scanner(new File(FileName));
        sc.useDelimiter(";");

        while (sc.hasNext()) {
            String parameter = sc.next().trim();
            String[] subParameters = parameter.split("\\s+");
            NameList.clear();
            for (String subParameter : subParameters) {
                NameList.add(subParameter);
            }
        }

        for (String parameter : NameList) {
            Response searchDetails = RestAssured.get(BaseUrl + SearchBarForName + parameter);
            Assertions.assertEquals(searchDetails.getStatusCode(), 200);
            System.out.println("The respons code is: " + searchDetails.getStatusCode() + ", for search: " + parameter);
            extensions.JsonToFileFromTest(parameter, searchDetails);
        }
    }

    @Test
    void searchByCountry() throws FileNotFoundException, JsonProcessingException {
        Scanner sc = new Scanner(new File(FileCountry));
        sc.useDelimiter(";");

        while (sc.hasNext()) {
            String parameter = sc.next().trim();
            String[] subParameters = parameter.split("\\s+");
            CountryList.clear();
            for (String subParameter : subParameters) {
                CountryList.add(subParameter);
            }
        }

        for (String parameter : CountryList) {
            Response searchDetails = RestAssured.get(BaseUrl + SearchBarForCountry + parameter);
            Assertions.assertEquals(searchDetails.getStatusCode(), 200);
            System.out.println("The respons code is: " + searchDetails.getStatusCode() + ", for search: " + parameter);
            extensions.JsonToFileFromTest(parameter, searchDetails);
        }
    }
}

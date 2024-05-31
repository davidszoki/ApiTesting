import Extensions.Extensions;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileReader;
import java.io.IOException;

public class TestApp {
    String BaseUrl = System.getenv("BASE_URL");
    String FileName = System.getenv("FILE_NAME");
    String SearchBarForName = System.getenv("SEARCH_NAME");
    String FileCountry = System.getenv("FILE_COUNTRY");
    String SearchBarForCountry = System.getenv("SEARCH_COUNTRY");
    String FilePath = System.getenv("FILE_PATH");
    Extensions extensions;

    @Test
    void pingUniversity(){
        Response responsePing = RestAssured.get(BaseUrl);
        responsePing.print();

        Assertions.assertEquals(responsePing.getStatusCode(), 200);
    }

    @Test
    void searchByName() throws IOException, CsvValidationException {
        FileReader fileReader = new FileReader(FileName);
        CSVReader csvReader = new CSVReader(fileReader);
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null){
            for (String parameter : nextRecord) {
                Response searchDetails = RestAssured.get(BaseUrl + SearchBarForName + parameter);
                Assertions.assertEquals(searchDetails.getStatusCode(), 200);
                System.out.println("The respons code is: " + searchDetails.getStatusCode() + ", for search: " + parameter);
                extensions.JsonToFileFromTest(FilePath+parameter, searchDetails);
            }
        }
    }

    @Test
    void searchByCountry() throws IOException, CsvValidationException {
        FileReader fileReader = new FileReader(FileCountry);
        CSVReader csvReader = new CSVReader(fileReader);
        String[] nextRecord;

        while ((nextRecord = csvReader.readNext()) != null){
            for (String parameter : nextRecord) {
                Response searchDetails = RestAssured.get(BaseUrl + SearchBarForCountry + parameter);
                Assertions.assertEquals(searchDetails.getStatusCode(), 200);
                System.out.println("The respons code is: " + searchDetails.getStatusCode() + ", for search: " + parameter);
                extensions.JsonToFileFromTest(FilePath+parameter, searchDetails);
            }
        }
    }
}
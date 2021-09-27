import com.google.gson.JsonArray;
import com.qa.pages.cityPage;
import com.qa.pages.cityTempPage;
import com.qa.pages.searchPage;
import com.qa.testbase.testBase;
import static io.restassured.RestAssured. *;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.baseURI;

public class UIvsApiTest extends testBase {


    Response response;
    cityPage cp;
    searchPage sp;
    cityTempPage ctp;

    @BeforeMethod
    public void setup(){
        initialisation();
        cp = new cityPage();
        sp = new searchPage();
        ctp = new cityTempPage();

        baseURI = prop.getProperty("URI");
        RequestSpecification response = given().
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                queryParam("q", "Bengaluru").
                queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").
                queryParam("units", "metric");

    }

    @Test
    public void testFlow(){
      cp = sp.searchPlace();
      ctp = cp.selectingCurrentWeather();
      String temp = ctp.fetchingTemperature();
      String tempfromApi = given().get(prop.getProperty("endpoint")).then().extract().path("main.temp");
        System.out.println(temp);
        System.out.println(tempfromApi);

    }

    @BeforeMethod
    public void teardown(){

    }

}

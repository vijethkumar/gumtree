package vijethgumtree;

import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class apitest_validate {
	
	@Test
	void getdetails() {
		
		
		//Base URI
		RestAssured.baseURI="https://ecg-api.gumtree.com.au";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response Object
		Response response=httprequest.request(Method.GET,"api/papi/ads/search?categoryId=0&categoryRedirected=1&includeTopAds=1&keyword=Table&locationId=3003435&page=1&size=20&sortType=DATE_DESCENDING");
		
		//Validation
		Assert.assertEquals(response.header("Content-Type"), "application/json;charset=UTF-8");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertNotNull(response.header("Date"));
		Assert.assertNotNull(response.body());
		Assert.assertNotNull(response.jsonPath().get("ads"));
	    Assert.assertNotNull(response.jsonPath().get("adSearchOptions"));
	    Assert.assertNotNull(response.jsonPath().get("paging"));
	    
	}

}


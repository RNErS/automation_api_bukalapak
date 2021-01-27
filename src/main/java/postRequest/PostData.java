package postRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostData {
	
	@Test
	public void requestData() {
		 
		 RequestSpecification request = RestAssured.given();
		 
		 request.header("Content-Type", "application/json");
		 		 
		 String title = "recommendation";
		 String body = "motorcycle";
		 int userId = 12;
		 JSONObject params = new JSONObject();
		 params.put("title", title);
		 params.put("body", body);
		 params.put("userId", userId);
		 
		 request.body(params.toJSONString());
		 
		 Response response = request.post("https://jsonplaceholder.typicode.com/posts");
		 
		 String data = response.asString();
		 		
		 System.out.println("Response: " + data);
		 
		 JsonPath jsonPath = new JsonPath(data);
		 
		 String titleResp = jsonPath.get("title");
		 String bodyResp = jsonPath.get("body");
		 int userIdResp = jsonPath.get("userId");
		 
		 if(title.equals(titleResp)) {
			 System.out.println("Title is matching");
		 }
		 
		 if(body.equals(bodyResp)) {
			 System.out.println("Body is matching");
		 }
		 
		 if(userId == userIdResp) {
			 System.out.println("User Id is matching");
		 }
		 
		 int statusCode = response.getStatusCode();
		 System.out.println("Status code : " + statusCode);
		 Assert.assertEquals(statusCode, 201);
		 
	}

}

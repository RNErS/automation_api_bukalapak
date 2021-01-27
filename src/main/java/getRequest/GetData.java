package getRequest;



import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetData {
	
	@Test
	public void responseData() {
		Response resp = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
		int code = resp.getStatusCode();
		String data = resp.getBody().asString();	
		JsonPath jsonPath = new JsonPath(data);
		
		ArrayList<Integer> listUserId = new ArrayList<Integer>();
		ArrayList<Integer> listId = new ArrayList<Integer>();
		ArrayList<String> listTitle = new ArrayList<String>();
		ArrayList<String> listBody = new ArrayList<String>();
		listUserId = jsonPath.get("userId");
		listId = jsonPath.get("id");
		listTitle = jsonPath.get("title");
		listBody = jsonPath.get("body");
		
		for (int i=0; i<listUserId.size();i++) {
			int userId = listUserId.get(i);
			int id = listId.get(i);
			String title = listTitle.get(i);
			String body = listBody.get(i);
			
			if (listUserId.get(i) == (int)userId)
			{
			   System.out.println("User Id : " +  listUserId.get(i) + " is Integer");
			}
			
			if (listId.get(i) == (int)id)
			{
			   System.out.println("Id : " +  listId.get(i) + " is Integer");
			}
			
			if (listTitle.get(i) == (String)title)
			{
			   System.out.println("Title : " +  listTitle.get(i) + " is String");
			}
			
			if (listBody.get(i) == (String)body)
			{
			   System.out.println("Body : " +  listBody.get(i) + " is String");
			}
			System.out.println();
		}
		
		System.out.println("Status code : " + code);
		Assert.assertEquals(code, 200);
	}
}

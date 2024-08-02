package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RouteConfig_UserEndPoint2 {

	public static ResourceBundle getURL() {

		ResourceBundle rb = ResourceBundle.getBundle("route.properties");

		return rb;
	}

	public static Response createUser(User payload) {

		String postURL = getURL().getString("postURL");

		Response res = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)

				.when().post(postURL);

		return res;

	}

	public static Response readUser(String username) {
		String getURL = getURL().getString("getURL");

		Response res = given().pathParam("username", username)

				.when().get(getURL);

		return res;

	}

	public static Response updateUser(User payload, String username) {

		String updateURL = getURL().getString("updateURL");
		Response res = given().accept(ContentType.JSON).contentType(ContentType.JSON).pathParam("username", username)
				.body(payload)

				.when().put(updateURL);

		return res;

	}

	public static Response deleteUser(String username) {

		String deleteURL = getURL().getString("deleteURL");
		Response res = given().pathParam("username", username).when().delete(deleteURL);
		return res;

	}

}

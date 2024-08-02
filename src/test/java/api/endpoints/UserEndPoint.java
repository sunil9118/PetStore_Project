package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoint {

	public static Response createUser(User payload) {

		Response res = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)

				.when().post(API_Route.postURL);

		return res;

	}

	public static Response readUser(String username) {

		Response res = given().pathParam("username", username)

				.when().get(API_Route.getURL);

		return res;

	}

	public static Response updateUser(User payload, String username) {

		Response res = given().accept(ContentType.JSON).contentType(ContentType.JSON).pathParam("username", username)
				.body(payload)

				.when().put(API_Route.updateURL);

		return res;

	}

	public static Response deleteUser(String username) {

		Response res = given().pathParam("username", username).when().delete(API_Route.deleteURL);
		return res;

	}

}

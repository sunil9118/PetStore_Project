package api.test;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class TestUser2_routeConfig {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = api.utilities.DataProviders.class)
	public void userData_setup(String userID, String userName, String firstName, String lastName, String email,
			String password, String phone) {
		// faker = new Faker();
		User payload = new User();

		payload.setId(Integer.parseInt(userID));
		payload.setFirstName(firstName);
		payload.setUsername(userName);
		payload.setLastName(lastName);
		payload.setEmail(email);
		payload.setPassword(password);
		payload.setPhone(phone);
		payload.setUserStatus(0);

		Response res = UserEndPoint.createUser(payload);

		res.then().log().all();
		System.out.println("Header ----->" + res.headers());
	}

	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = api.utilities.DataProviders.class)
	public void testReadUser(String username) {

		Response res = UserEndPoint.readUser(username);

		res.then().log().all();

	}

	// @Test(priority = 4)
	public void testUpdateUser() {

		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());

		Response res = UserEndPoint.updateUser(payload, payload.getUsername());

		res.then().log().all();

	}

	@Test(priority = 5, dataProvider = "UserNames", dataProviderClass = api.utilities.DataProviders.class)
	public void testDeleteUser(String username) {

		Response res = UserEndPoint.deleteUser(username);

		res.then().log().all();

	}

}
package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class TestUser {

	Faker faker;
	User payload;

	@BeforeClass
	public void userData_setup() {
		faker = new Faker();
		payload = new User();

		payload.setId(faker.idNumber().hashCode());
		payload.setFirstName(faker.name().firstName());
		payload.setUsername(faker.name().username());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(10, 12));
		payload.setPhone((faker.phoneNumber().cellPhone()));
		payload.setUserStatus(0);
	}

	@Test(priority = 1)
	public void testPostUser() {

		Response res = UserEndPoint.createUser(payload);

		res.then().log().all();
		System.out.println("Header ----->" + res.headers());

	}

	@Test(priority = 2)
	public void testReadUser() {

		Response res = UserEndPoint.readUser(payload.getUsername());

		res.then().log().all();

	}

	@Test(priority = 3)
	public void testUpdateUser() {

		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());

		Response res = UserEndPoint.updateUser(payload, payload.getUsername());

		res.then().log().all();

	}

	@Test(priority = 4)
	public void testDeleteUser() {

		Response res = UserEndPoint.deleteUser(payload.getUsername());

		res.then().log().all();

	}

}
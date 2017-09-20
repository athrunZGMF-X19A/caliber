package com.revature.caliber.test.api;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.caliber.beans.Trainee;
import com.revature.caliber.beans.Trainer;
import com.revature.caliber.beans.TrainerRole;
import com.revature.caliber.data.BatchDAO;

import io.restassured.http.ContentType;

/**
 * API testing at the RESTful service message layer using REST Assured. All API
 * tests must be ignored in the initial build until the app is deployed into the
 * test environment.
 * 
 * @author Patrick Walsh
 *
 */
public class TrainingAPITest extends AbstractAPITest{

	private static final Logger log = Logger.getLogger(TrainingAPITest.class);
	
	/*
	 * Trainer API endpoints
	 */
	private String findByEmail = "training/trainer/byemail/patrick.walsh@revature.com/";

	private String createTrainee ="/all/trainee/create";
	private String updateTrainee = "/all/trainee/update";
	private String deleteTrainee = "/all/trainee/delete/5468";
	private String retreiveTraineeByEmail = "/all/trainee/getByEmail/starrv2011@gmail.com";
	private String createTrainer = "vp/trainer/create";
	
	@Autowired
	BatchDAO batchDao;


	@Test
	public void findByEmail() throws Exception {
		Trainer expected = new Trainer("Patrick Walsh", "Lead Trainer", "patrick.walsh@revature.com",
				TrainerRole.ROLE_VP);
		expected.setTrainerId(1);
		log.info("API Testing findTrainerByEmail at " + baseUrl + findByEmail);
		given().spec(requestSpec).header(authHeader, accessToken).contentType(ContentType.JSON).when()
				.get(baseUrl + findByEmail).then().assertThat().statusCode(200)
				.body(matchesJsonSchema(new ObjectMapper().writeValueAsString(expected)));
	}

	@Test
	@Ignore
	public void createTrainer() throws Exception {
		Trainer expected = new Trainer("Randolph Scott", "Senior Trainer", "randolph.scott@revature.com",
				TrainerRole.ROLE_TRAINER);
		log.info("API Testing createTrainer at " + baseUrl + createTrainer);
		given().spec(requestSpec).header(authHeader, accessToken)
				.contentType(ContentType.JSON).body(new ObjectMapper().writeValueAsString(expected)).when()
				.post(baseUrl + createTrainer).then().assertThat().statusCode(201);
	}
	@Test
	
	public void createTraineeTest() throws Exception {
		log.info("API Testing createTrainee at " + baseUrl + createTrainee);
		Trainee expexted = new Trainee("Test McTest", "", "mctest@gmail.com", batchDao.findOne(2050));
		given().spec(requestSpec).header(authHeader, accessToken)
		.contentType(ContentType.JSON).body(new ObjectMapper().writeValueAsString(expexted)).when()
			.post(baseUrl +createTrainee).then().assertThat().statusCode(201);
	}
	
	@Test
	@Ignore
	public void updateTraineeTest() throws Exception {
		log.info("API Testing updateTrainee at " + baseUrl + updateTrainee);
		BatchDAO batchDao = new BatchDAO();
		Trainee expexted = new Trainee("Test McTest", "", "mctest@gmail.com", batchDao.findOne(2050));
		given().spec(requestSpec).header(authHeader, accessToken)
		.contentType(ContentType.JSON);
	}
	@Test
	@Ignore
	public void deleteTraineeTest() throws Exception {
		log.info("API Testing deleteTrainee at " + baseUrl + deleteTrainee);
		BatchDAO batchDao = new BatchDAO();
		Trainee expexted = new Trainee("Test McTest", "", "mctest@gmail.com", batchDao.findOne(2050));
		given().spec(requestSpec).header(authHeader, accessToken)
		.contentType(ContentType.JSON);
	}
	@Test
	@Ignore
	public void retreiveTraineeByEmailTest(){
		log.info("API Testing retreiveTraineeByEmail at " + baseUrl + retreiveTraineeByEmail);
		BatchDAO batchDao = new BatchDAO();
		Trainee expexted = new Trainee("Test McTest", "", "mctest@gmail.com", batchDao.findOne(2050));
		given().spec(requestSpec).header(authHeader, accessToken)
		.contentType(ContentType.JSON);
	}	
	
}

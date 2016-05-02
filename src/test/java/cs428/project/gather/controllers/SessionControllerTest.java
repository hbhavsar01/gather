package cs428.project.gather.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;

import cs428.project.gather.GatherApplication;
import cs428.project.gather.data.model.Registrant;
import cs428.project.gather.data.repo.EventRepository;
import cs428.project.gather.data.repo.RegistrantRepository;
import cs428.project.gather.data.response.RESTResponseData;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(GatherApplication.class)
@WebIntegrationTest
public class SessionControllerTest extends ControllerTest {

	@Autowired
	RegistrantRepository registrantRepo;

	@Autowired
	EventRepository eventRepo;

	@Before
	public void setUp() {
		eventRepo.deleteAll();
		assertEquals(this.eventRepo.count(), 0);
		registrantRepo.deleteAll();
		assertEquals(this.registrantRepo.count(), 0);
		Registrant aUser = new Registrant("existed@email.com", "password", "existedName", 3, 10000);
		this.registrantRepo.save(aUser);
		assertEquals(this.registrantRepo.count(), 1);
	}

	@Test
	public void testSessionFound() throws JsonProcessingException {

		ResponseEntity<RESTResponseData> signInResponse = authenticateUser("existed@email.com", "password", null);
		List<String> cookies = signInResponse.getHeaders().get("Set-Cookie");

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("Cookie", StringUtils.join(cookies, ';'));
		HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);

		// Invoking the API

		ResponseEntity<RESTResponseData> response = checkSession(requestEntity);
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));

		RESTResponseData responseData = response.getBody();
		assertTrue(responseData.getMessage().equals("Session Found"));

	}

	@Test
	public void testSignOutUserFail() throws IOException {
		HttpHeaders requestHeaders = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
		ResponseEntity<RESTResponseData> response = checkSession(requestEntity);
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));

		RESTResponseData responseData = response.getBody();
		assertTrue(responseData.getMessage().equals("Session Not Found"));

	}

}

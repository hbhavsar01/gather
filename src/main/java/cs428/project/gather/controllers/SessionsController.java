package cs428.project.gather.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cs428.project.gather.data.form.SignInData;
import cs428.project.gather.data.model.Registrant;
import cs428.project.gather.data.response.RESTResponseData;
import cs428.project.gather.data.response.RESTSessionResponseData;
import cs428.project.gather.utilities.ActorStateUtility;

/**
 * 
 * @author Team Gather This class is the session controller in charge of session
 *         related rest call such as sign in, sign out, and get session
 * 
 */

@Controller("SessionsController")
public class SessionsController extends AbstractGatherController {
	protected boolean authenticate(SignInData signInData, Errors errors) {
		Registrant user = registrantRepo.findOneByEmail(signInData.getEmail());
		boolean passwordMatches = StringUtils.equals(signInData.getPassword(), user.getPassword());
		if (!passwordMatches)
			errors.reject("-6", "The password is incorrect.  Please enter the correct password.");
		return passwordMatches;
	}

	protected Registrant createSession(SignInData signInData, HttpServletRequest request) {
		String email = signInData.getEmail();
		System.out.println("\n" + email + " authenticated. \n");
		Registrant registrant = this.registrantRepo.findOneByEmail(email);
		ActorStateUtility.storeActorInSession(request, registrant);
		return registrant;
	}

	/**
	 * 
	 * This method gets a request from the frontend to return user session
	 * status which it does.
	 * 
	 * @param request:
	 *            This variable is the request from the front end to get the
	 *            user session status to chose the UI accordingly
	 * @return: This method returns the session status of the user
	 * 
	 */
	@RequestMapping(value = "/rest/session")
	public ResponseEntity<RESTSessionResponseData> getSession(HttpServletRequest request,
			HttpServletResponse response) {
		if (isSessionAuthenticated(request))
			return RESTSessionResponseData.sessionResponse(5, "Session Found", getUser(request).getDisplayName(),
					HttpStatus.OK);
		return RESTSessionResponseData.sessionResponse(-5, "Session Not Found", HttpStatus.OK);
	}

	/**
	 * 
	 * This method takes user credentials and based on it and if authentication
	 * passes logs in the user
	 * 
	 * @param request:
	 *            This variable is the request received from the frontend
	 *            through the rest call to login the user
	 * @param rawData:
	 *            This variable is the data field of the request received from
	 *            the frontend containing email and password.
	 * @param bindingResult:
	 *            The controller makes this variable available any time an
	 *            object is posted/put from the frontend. It will contain errors
	 *            if there was an error in binding the object. The app continues
	 *            to use its Error interface to report on validation or other
	 *            errors as we continue to process things. Those errors then get
	 *            reported back via the HTTPStatus or Status in our response
	 *            data.
	 * @return: This method returns successful or unsuccessful login response
	 * 
	 */
	@RequestMapping(value = "/rest/registrants/signin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<RESTResponseData> signIn(HttpServletRequest request, @RequestBody String rawData,
			BindingResult bindingResult) {
		if (!nonAuthenticatedRequest(request, bindingResult))
			return RESTResponseData.buildResponse(bindingResult);

		SignInData signInData = SignInData.parseIn(rawData, signInDataValidator, bindingResult);
		if (bindingResult.hasErrors())
			return RESTResponseData.buildResponse(bindingResult);
		if (!authenticate(signInData, bindingResult))
			return RESTResponseData.buildResponse(bindingResult);

		Registrant registrant = createSession(signInData, request);
		return new ResponseEntity<RESTResponseData>(
				new RESTSessionResponseData(0, "success", registrant.getDisplayName()), HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * This method takes user request to get loggedout and logs
	 * 
	 * @param request:
	 *            This variable is the request received from the frontend
	 *            through the rest call to login the user
	 * @param rawData:
	 *            This variable is the data field of the request received from
	 *            the frontend containing email and password.
	 * @param bindingResult:
	 *            The controller makes this variable available any time an
	 *            object is posted/put from the frontend. It will contain errors
	 *            if there was an error in binding the object. The app continues
	 *            to use its Error interface to report on validation or other
	 *            errors as we continue to process things. Those errors then get
	 *            reported back via the HTTPStatus or Status in our response
	 *            data.
	 * @return: This method returns successful or unsuccessful login response
	 * 
	 */

	/**
	 * This method logs the user out using the user id passed in the sign out
	 * request
	 * 
	 * @param request:
	 *            This variable is the request received from the frontend
	 *            through the rest call to log the user out
	 * @param response
	 * @return if user is logged out successful a success response will be
	 *         returned
	 */
	@RequestMapping(value = "/rest/registrants/signout", method = RequestMethod.POST)
	public ResponseEntity<RESTResponseData> signOut(HttpServletRequest request, HttpServletResponse response) {
		boolean isAuthed = isSessionAuthenticated(request);
		invalidateSession(request, response);
		if (!isAuthed)
			return RESTResponseData.response(-7, "User is not in authenticated state", HttpStatus.BAD_REQUEST);
		return RESTResponseData.OKResponse("success");
	}
}

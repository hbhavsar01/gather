package cs428.project.gather.data.form;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;

import com.google.gson.Gson;

import cs428.project.gather.validator.AbstractValidator;

/**
 * 
 * @author Team Gather This class represents the data object to create new
 *         registrants
 * 
 */
public class RegistrationData {
	/**
	 * Public static names for validator getting the field names
	 */
	public static final String EMAIL_FIELD_NAME = "email";
	public static final String PASSWORD_FIELD_NAME = "password";
	public static final String OLD_PASSWORD_FIELD_NAME = "oldPassword";
	public static final String DISPLAY_NAME_FIELD_NAME = "displayName";
	public static final String RADIUS_MI_FIELD_NAME = "radiusMi";
	public static final float MAX_RADIUS = 50f;

	private String email;
	private String password;
	private String oldPassword;
	private String displayName;
	private int defaultTimeWindow = 1;
	private int defaultZip = -1;
	private int defaultRadiusMi = 5;
	private Set<String> preferences;
	private Boolean showEventsAroundZipCode;

	/**
	 * Parse the raw JSON data in String and validate the data, then set the
	 * Error code accordingly.
	 * 
	 * @param rawData:
	 *            The raw JSON data in String
	 * @param validator:
	 *            The validator object to validate the input data
	 * @param errors:
	 *            The error object to pass to the validator for different error
	 *            code
	 * @return: A paginated bad request response based on the binding result.
	 * 
	 */
	public static RegistrationData parseIn(String rawData, AbstractValidator validator, Errors errors) {
		System.out.println("rawData: " + rawData);
		RegistrationData registrationData = (new Gson()).fromJson(rawData, RegistrationData.class);
		registrationData.validate(validator, errors);
		return registrationData;
	}

	/**
	 * Validate this object and save the Error status
	 * 
	 * @param validator:
	 *            The validator object to validate the input data
	 * @param errors:
	 *            The error object to pass to the validator for different error
	 *            code
	 * 
	 */
	public void validate(AbstractValidator validator, Errors errors) {
		validator.validate(this, errors);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = StringUtils.trimToNull(password);
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = StringUtils.trimToNull(displayName);
	}

	public int getDefaultTimeWindow() {
		return defaultTimeWindow;
	}

	public void setDefaultTimeWindow(int defaultTimeWindow) {
		this.defaultTimeWindow = defaultTimeWindow;
	}

	public int getDefaultZip() {
		return defaultZip;
	}

	public void setDefaultZip(int defaultZip) {
		this.defaultZip = defaultZip;
	}

	public int getDefaultRadiusMi() {
		return defaultRadiusMi;
	}

	public void setDefaultRadiusMi(int defaultRadiusMi) {
		this.defaultRadiusMi = defaultRadiusMi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = StringUtils.trimToNull(email);
	}

	public Set<String> getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<String> preferences) {
		this.preferences = preferences;
	}

	public Boolean getShowEventsAroundZipCode() {
		return showEventsAroundZipCode;
	}

	public void setShowEventsAroundZipCode(Boolean showEventsAroundZipCode) {
		this.showEventsAroundZipCode = showEventsAroundZipCode;
	}
}

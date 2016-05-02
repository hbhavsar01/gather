package cs428.project.gather.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import cs428.project.gather.data.form.EventsQueryData;

/***
 * 
 * @author Team Gather
 * 
 *         This class validates that event ID queries do not use a null or
 *         negative ID.
 *
 */
@Component
public class EventIdDataValidator extends AbstractValidator {
	@Override
	public boolean supports(Class<?> targetClass) {
		return EventsQueryData.class.equals(targetClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EventsQueryData queryData = (EventsQueryData) target;
		if (queryData == null) {
			throw new IllegalArgumentException("The events query cannot be null.");
		} else {
			validateEventId(queryData, errors);
		}
	}

	private void validateEventId(EventsQueryData joinData, Errors errors) {
		Long id = joinData.getEventId();
		if (id == null || id < 0) {
			String message = "Field invalid-" + "id";
			errors.reject("-3", message + ":The id must be number greater than 0.");
		}
	}
}

package cs428.project.gather.validator;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import cs428.project.gather.data.Coordinates;
import cs428.project.gather.data.form.NewEventData;
import cs428.project.gather.data.model.Event;
import cs428.project.gather.data.repo.CategoryRepository;
import cs428.project.gather.data.repo.EventRepository;

@Component
public class NewEventDataValidator extends AbstractEventDataValidator {
	@Autowired
	EventRepository eventRepo;

	@Autowired
	CategoryRepository categoryRepo;

	@Override
	public boolean supports(Class<?> targetClass) {
		return NewEventData.class.equals(targetClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NewEventData newEventData = (NewEventData) target;

		if (newEventData == null) {
			throw new IllegalArgumentException("The new event data cannot be null.");
		} else {
			validateEventName(newEventData, errors);
			validateEventCoords(newEventData, errors);
			validateEventDescription(newEventData, errors);
			validateEventCategory(newEventData, errors);
			validateEventOccurrences(newEventData, errors);
			validateCallerCoordinates(newEventData, errors);
			validateNotDuplicateEvent(newEventData, errors);
		}

	}

	private void validateNotDuplicateEvent(NewEventData newEventData, Errors errors) {
		if (!errors.hasErrors()) {
			String name = newEventData.getEventName();
			double latitude = newEventData.getEventCoodinates().getLatitude();
			double longitude = newEventData.getEventCoodinates().getLongitude();
			Timestamp time = new Timestamp(newEventData.getOccurrences().get(0));

			List<Event> foundEvents = this.eventRepo.findByNameAndLocationAndTime(name, latitude, longitude, time);
			if (!foundEvents.isEmpty()) {
				String message = "Cannot create event. An existing event with the same name, location, and time already exists!";
				errors.reject("-4", message);
			}
		}
	}

	@Override
	boolean nullNameCheck(String eventName, Errors errors) {
		if (eventName == null) {
			String message = "Field required-" + NewEventData.EVENT_NAME_FIELD_NAME;
			errors.reject("-1", message + ":Event name is a required field.");
			return true;
		}
		return false;
	}

	@Override
	boolean nullOccurrencesCheck(List<Long> eventOccurrences, Errors errors) {
		if (eventOccurrences == null) {
			String message = "Cannot update event. Occurrence list is not defined in JSON";
			errors.reject("-7", message);
			return true;
		}
		return false;
	}

	@Override
	boolean nullCategoryCheck(String category, Errors errors) {
		if (category == null) {
			String message = "Field required-" + NewEventData.EVENT_CATEGORY_FIELD_NAME;
			errors.reject("-1", message + ":Event category is a required field.");
			return true;
		}
		return false;
	}

	@Override
	boolean nullDescriptionCheck(String description, Errors errors) {
		if (description == null) {
			String message = "Field required-" + NewEventData.EVENT_DESCRIPTION_FIELD_NAME;
			errors.reject("-1", message + ":Event description is a required field.");
			return true;
		}
		return false;
	}

	@Override
	boolean nullEventCoordinatesCheck(Coordinates eventCoords, Errors errors) {
		if (eventCoords == null) {
			String message = "Field required-" + NewEventData.EVENT_COORDS_FIELD_NAME;
			errors.reject("-1", message + ":Event coordinates is a required field.");
			return true;
		}
		return false;
	}

	@Override
	boolean nullCallerCoordinatesCheck(Coordinates callerCoords, Errors errors) {
		if (callerCoords == null) {
			String message = "Field required-" + NewEventData.CALLER_COORDS_FIELD_NAME;
			errors.reject("-1", message + ":User coordinates is a required field.");
			return true;
		}
		return false;
	}
}

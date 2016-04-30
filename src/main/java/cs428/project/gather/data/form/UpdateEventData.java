package cs428.project.gather.data.form;

import java.util.List;

import org.springframework.validation.Errors;

import com.google.gson.Gson;

import cs428.project.gather.utilities.GsonHelper;
import cs428.project.gather.validator.AbstractValidator;

public class UpdateEventData extends NewEventData {
	private Long eventId;
	private List<String> owners = null;
	private List<String> participants = null;

	public static UpdateEventData parseIn(String rawData, AbstractValidator validator, Errors errors) {
		System.out.println("rawData: " + rawData);
		Gson gson = GsonHelper.getGson();
		UpdateEventData updateEventData = gson.fromJson(rawData, UpdateEventData.class);
		updateEventData.validate(validator, errors);
		return updateEventData;
	}

	public void validate(AbstractValidator validator, Errors errors) {
		validator.validate(this, errors);
	}

	public List<String> getOwners() {
		return owners;
	}

	public List<String> getParticipants() {
		return participants;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long id) {
		this.eventId = id;
	}
}

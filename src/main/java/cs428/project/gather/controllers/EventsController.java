package cs428.project.gather.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cs428.project.gather.data.form.EventsQueryData;
import cs428.project.gather.data.form.NewEventData;
import cs428.project.gather.data.form.UpdateEventData;
import cs428.project.gather.data.model.Event;
import cs428.project.gather.data.response.RESTPaginatedResourcesResponseData;
import cs428.project.gather.data.response.RESTResourceResponseData;

@Controller("EventsController")
public class EventsController extends AbstractGatherController {
	@RequestMapping(value = "/rest/events", method = RequestMethod.PUT)
	public ResponseEntity<RESTPaginatedResourcesResponseData<Event>> getNearbyEvents(HttpServletRequest request,
			@RequestBody String rawData, BindingResult bindingResult) {
		EventsQueryData queryParams = EventsQueryData.parseIn(rawData, eventsQueryDataValidator, bindingResult);
		if (bindingResult.hasErrors())
			return RESTPaginatedResourcesResponseData.badResponse(bindingResult);

		List<Event> events = Event.queryForEvents(queryParams, eventRepo, getUserAsOption(request), bindingResult);
		if (bindingResult.hasErrors())
			return RESTPaginatedResourcesResponseData.badResponse(bindingResult);

		return RESTPaginatedResourcesResponseData.createResponse(request, events);
	}

	@RequestMapping(value = "/rest/events", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<RESTResourceResponseData<Event>> addEvent(HttpServletRequest request,
			@RequestBody String rawData, BindingResult bindingResult) {
		if (!authenticatedRequest(request, bindingResult))
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		NewEventData newEventData = NewEventData.parseIn(rawData, newEventDataValidator, bindingResult);
		if (bindingResult.hasErrors())
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		Event newEvent = Event.buildEventFrom(newEventData, getUser(request), categoryRepo, bindingResult);
		if (bindingResult.hasErrors())
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		Event savedEventResult = this.eventRepo.save(newEvent);
		System.out.println("DistanceFromCaller: " + newEventData.distanceFromCaller());
		return RESTResourceResponseData.createResponse(savedEventResult, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/rest/events/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<RESTResourceResponseData<Event>> updateEvent(HttpServletRequest request,
			@RequestBody String rawData, BindingResult bindingResult) {
		if (!authenticatedRequest(request, bindingResult))
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		UpdateEventData updateEventData = UpdateEventData.parseIn(rawData, updateEventDataValidator, bindingResult);
		if (bindingResult.hasErrors())
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		Event targetEvent = eventRepo.findOne(updateEventData.getEventId());

		Event updatedResult = targetEvent.updateEventUsing(updateEventData, getUser(request), registrantRepo,
				categoryRepo, bindingResult);
		if (bindingResult.hasErrors())
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		Event savedEventResult = this.eventRepo.save(updatedResult);

		return RESTResourceResponseData.createResponse(savedEventResult, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/rest/events/userJoined")
	public ResponseEntity<RESTPaginatedResourcesResponseData<Event>> getJoinedEventsList(HttpServletRequest request) {
		BindingResult errors = new BindException(this, "errors");
		if (!authenticatedRequest(request, errors))
			return RESTPaginatedResourcesResponseData.<Event> badResponse(errors);
		List<Event> events = new ArrayList<Event>(getUser(request).getJoinedEvents());
		return RESTPaginatedResourcesResponseData.createResponse(request, events);
	}

	@RequestMapping(value = "/rest/events/userOwned")
	public ResponseEntity<RESTPaginatedResourcesResponseData<Event>> getOwnedEventsList(HttpServletRequest request) {
		BindingResult errors = new BindException(this, "errors");
		if (!authenticatedRequest(request, errors))
			return RESTPaginatedResourcesResponseData.<Event> badResponse(errors);
		List<Event> events = new ArrayList<Event>(getUser(request).getOwnedEvents());
		return RESTPaginatedResourcesResponseData.createResponse(request, events);
	}

	@RequestMapping(value = "/rest/events/join", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<RESTResourceResponseData<Event>> joinEvent(HttpServletRequest request,
			@RequestBody String rawData, BindingResult bindingResult) {
		if (!authenticatedRequest(request, bindingResult))
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		EventsQueryData joinEventData = EventsQueryData.parseIn(rawData, eventIdDataValidator, bindingResult);
		if (bindingResult.hasErrors())
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		Event eventToJoin = getUser(request).joinEvent(joinEventData, eventRepo, bindingResult);
		if (bindingResult.hasErrors())
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		return RESTResourceResponseData.createResponse(eventToJoin, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/rest/events/leave", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<RESTResourceResponseData<Event>> leaveEvent(HttpServletRequest request,
			@RequestBody String rawData, BindingResult bindingResult) {
		if (!authenticatedRequest(request, bindingResult))
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		EventsQueryData leaveEventData = EventsQueryData.parseIn(rawData, eventIdDataValidator, bindingResult);
		if (bindingResult.hasErrors())
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		Event eventToLeave = getUser(request).leaveEvent(leaveEventData, eventRepo, bindingResult);
		if (bindingResult.hasErrors())
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		return RESTResourceResponseData.createResponse(eventToLeave, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/events/remove", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<RESTResourceResponseData<Event>> removeEvent(HttpServletRequest request,
			@RequestBody String rawData, BindingResult bindingResult) {
		if (!authenticatedRequest(request, bindingResult))
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		EventsQueryData removeEventData = EventsQueryData.parseIn(rawData, eventIdDataValidator, bindingResult);
		if (bindingResult.hasErrors())
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		Event removedEvent = getUser(request).removeEvent(removeEventData, eventRepo, bindingResult);
		if (bindingResult.hasErrors())
			return RESTResourceResponseData.<Event> badResponse(bindingResult);

		return RESTResourceResponseData.createResponse(removedEvent, HttpStatus.OK);
	}
}

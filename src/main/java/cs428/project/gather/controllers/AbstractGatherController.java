package cs428.project.gather.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import cs428.project.gather.data.model.Actor;
import cs428.project.gather.data.model.Registrant;
import cs428.project.gather.data.repo.CategoryRepository;
import cs428.project.gather.data.repo.EventRepository;
import cs428.project.gather.data.repo.RegistrantRepository;
import cs428.project.gather.utilities.ActorStateUtility;
import cs428.project.gather.utilities.ActorTypeHelper;
import cs428.project.gather.utilities.SignOutHelper;
import cs428.project.gather.validator.EventIdDataValidator;
import cs428.project.gather.validator.EventsQueryDataValidator;
import cs428.project.gather.validator.NewEventDataValidator;
import cs428.project.gather.validator.RegistrationDataValidator;
import cs428.project.gather.validator.RegistrationUpdateDataValidator;
import cs428.project.gather.validator.SignInDataValidator;
import cs428.project.gather.validator.UpdateEventDataValidator;

public abstract class AbstractGatherController {
	@Autowired
	protected RegistrantRepository registrantRepo;

	@Autowired
	protected EventRepository eventRepo;

	@Autowired
	protected CategoryRepository categoryRepo;

	@Autowired
	protected RegistrationDataValidator registrationDataValidator;

	@Autowired
	protected RegistrationUpdateDataValidator registrationUpdateDataValidator;

	@Autowired
	protected EventsQueryDataValidator eventsQueryDataValidator;

	@Autowired
	protected NewEventDataValidator newEventDataValidator;

	@Autowired
	protected UpdateEventDataValidator updateEventDataValidator;

	@Autowired
	protected EventIdDataValidator eventIdDataValidator;

	@Autowired
	protected SignInDataValidator signInDataValidator;

	protected boolean authenticatedRequest(HttpServletRequest request, Errors errors) {
		if (!ActorTypeHelper.isRegisteredUser(request)) {
			System.out.println("An anonymous user tried to access " + request.getServletPath());
			errors.reject("-7", "Incorrect User State. Only registered users can access " + request.getServletPath());
			return false;
		}
		return true;
	}

	protected boolean nonAuthenticatedRequest(HttpServletRequest request, Errors errors) {
		if (!ActorTypeHelper.isAnonymousUser(request)) {
			System.out.println("A non-anonymous user tried to access " + request.getServletPath());
			errors.reject("-7",
					"Incorrect User State. Only non-registered users can access " + request.getServletPath());
			return false;
		}
		return true;
	}

	protected Registrant getUser(HttpServletRequest request) {
		Actor actor = ActorStateUtility.retrieveActorFromRequest(request);
		return this.registrantRepo.findOne(actor.getActorID());
	}

	protected Registrant getUserAsOption(HttpServletRequest request) {
		Actor actor = ActorStateUtility.retrieveActorFromRequest(request);
		return (actor == null) ? null : this.registrantRepo.findOne(actor.getActorID());
	}

	protected boolean isSessionAuthenticated(HttpServletRequest request) {
		return ActorStateUtility.retrieveAuthenticatedStateInRequest(request);
	}

	protected void invalidateSession(HttpServletRequest request, HttpServletResponse response) {
		SignOutHelper.invalidateSession(request);
		SignOutHelper.deleteSessionCookie(request, response);
	}
}

package cs428.project.gather.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs428.project.gather.data.model.Category;
import cs428.project.gather.data.response.RESTPaginatedResourcesResponseData;

/**
 * 
 * @author Team Gather This class is the event category controller in charge of
 *         category related rest call from the frontend
 * 
 */

@Controller("CategoriesController")
public class CategoriesController extends AbstractGatherController {

	/**
	 * This method returns a list of default categories
	 * 
	 * @param request:
	 *            This is the request received from the front-end through the
	 *            rest call
	 * @return: A list of default categories is returned to the front end
	 * 
	 */

	@RequestMapping(value = "/rest/categories", method = RequestMethod.GET)
	public ResponseEntity<RESTPaginatedResourcesResponseData<Category>> getCategories(HttpServletRequest request) {
		List<Category> categories = categoryRepo.findAll();
		return RESTPaginatedResourcesResponseData.createResponse(request, categories);
	}
}

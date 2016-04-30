package cs428.project.gather.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs428.project.gather.data.model.Category;
import cs428.project.gather.data.response.RESTPaginatedResourcesResponseData;

@Controller("CategoriesController")
public class CategoriesController extends AbstractGatherController {
	@RequestMapping(value = "/rest/categories", method = RequestMethod.GET)
	public ResponseEntity<RESTPaginatedResourcesResponseData<Category>> getCategories(HttpServletRequest request) {
		List<Category> categories = categoryRepo.findAll();
		return RESTPaginatedResourcesResponseData.createResponse(request, categories);
	}
}

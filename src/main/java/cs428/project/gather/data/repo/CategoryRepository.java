package cs428.project.gather.data.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cs428.project.gather.data.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	/**
	 * Returns the {@link Category} with the given identifier.
	 *
	 * @param id
	 *            the id to search for.
	 * @return
	 */
	Category findOne(Long id);

	List<Category> findByName(String name);

	Category findOneByName(String name);

	List<Category> findAll();
}

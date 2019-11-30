package controller;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import model.Beer;

@RepositoryRestResource
public interface RestRepository extends PagingAndSortingRepository<Beer, Long> {

	List<Beer> findByName(@Param("name") String name);
	
	List<Beer> findByAbv(@Param("abv") double abv);

}

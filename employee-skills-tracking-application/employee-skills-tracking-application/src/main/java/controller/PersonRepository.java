package controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import model.Person;

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Integer>{

	List<Person> findByName(@Param("name") String name);
}

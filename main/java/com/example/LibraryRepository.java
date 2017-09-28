package com.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "library", path = "library")
public interface LibraryRepository extends CrudRepository<Library,Long>{
	List<Library> findBybookName(@Param("book") String book);
	List<Library> findByauthorName(@Param("author") String author );
	List<Library> findBypublishDate(@Param("date") int publishDate );
	List<Library> findByquantity(@Param("quantity") int quantity );
	List<Library> findByprice(@Param("price") int price );
	List<Library> findByid(@Param("id")long id,@Param("book")String book);	
}

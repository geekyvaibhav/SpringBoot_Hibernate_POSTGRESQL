package com.example;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	@Autowired
	LibraryRepository repository;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
    public Library process(@RequestParam(value="bookName") String book,@RequestParam(value="authorName") String author,@RequestParam(value="date") int date,@RequestParam(value="quantity") int quantity,@RequestParam(value="price") int price ){
		return repository.save(new Library(book, author, date, quantity, price));
    }
	
//	CrudRepository interface---> predefined methods to perform the crud op: create
//	public int run(){
//		return 0;
//	}
	
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	public Iterable<Library> getAllBooks()
	{
		return repository.findAll();
		
	}
	
	@RequestMapping(value="/getone",method=RequestMethod.GET)
	public Library getBook(@RequestParam(value="id") long id)
	{
		return repository.findOne(id);
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public String deleteBook(@RequestParam(value="id") long id)
	{
		 repository.delete(id);
		 return "Record Deleted!!!";	
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void deleteAllBooks()
	{
		 repository.deleteAll();
		 	
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public Library updateBook(@RequestParam(value="id") long id,@RequestBody Library library)
	{
		Library lib = (Library) repository.findOne(id);
		lib.setBookName(library.getBookName());
		lib.setAuthorName(library.getAuthorName());
		lib.setPublishDate(library.getPublishDate());
		lib.setQuantity(library.getQuantity());
		lib.setPrice(library.getPrice());
		return repository.save(lib);
	}
	

}

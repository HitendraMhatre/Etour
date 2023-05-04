package com.etour.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etour.entities.Booking_Master;
import com.etour.entities.Category_Master;
import com.etour.services.Category_MasterManager;


@RestController  
@CrossOrigin("http://localhost:3000")
public class Category_MasterController {
	@Autowired
	private Category_MasterManager  category_manager;
	
	 @GetMapping(value = "api/categories")
	public List<Category_Master> getCategories(){
		return category_manager.getAllcat();
	}
	 @GetMapping(value = "api/Hello")
	public String Hello(){
		return "Hello";
	}
	 @GetMapping(value = "api/categories/{pid}")
	 public Optional<Category_Master> getCategory(@PathVariable int pid)
	 {
		Optional<Category_Master> p=category_manager.getCategory(pid);
		return p;
	 }
	 @DeleteMapping(value = "api/categories/{pid}")
	 public void removeCategory(@PathVariable int pid)
	 {
		 category_manager.delete(pid);
	 }
	 @PutMapping(value = "api/categories/{pid}")
	 public void updateCategory(@RequestBody Category_Master product,@PathVariable int pid)
	 {
		System.out.println("inside updatecategory of controller");
		category_manager.update(product,pid);
	 }
	 @PostMapping(value = "api/categories")
	public void addCategory(@RequestBody Category_Master category){
		System.out.println("add category called");
		category_manager.save(category);
	}
	 
	 @GetMapping("/api/categoriesall")
		public List<Category_Master> getAllCategories()
		{
			return category_manager.getAll();
		}
		
		
		@GetMapping("/api/categoriessub/{categoryid}")
		public List<Category_Master>GetData(@PathVariable String categoryid)
		{
		    return category_manager.getSubcat(categoryid);	
		}


	 
	 
}

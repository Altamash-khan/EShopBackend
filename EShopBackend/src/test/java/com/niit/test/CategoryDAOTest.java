package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTest {
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	//@Ignore          
	@Test            
	public void addCategoryTest() {
		Category category = new Category();
		category.setCategoryName("Xiomi mobile");
		category.setCategoryDesc("All Xiomi smart mobile");
		assertTrue("Problem in adding category:", categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest() 
	{
		Category category = categoryDAO.getCategory(1);
		category.setCategoryDesc("All Xiomi mobile with smart features");
		assertTrue("Problem in updating category:", categoryDAO.updateCategory(category));
	}

	@Ignore
	@Test
	public void deleteCategoryTest() 
	{
		Category category = categoryDAO.getCategory(7);
		assertTrue("Problem in deleting category:", categoryDAO.deleteCategory(category));
	}

	@Ignore
	@Test
	public void listCategoriesTest() 
	{
		List<Category> listCategories = categoryDAO.listCategories();
		assertNotNull("Problem in listing category:", listCategories);
		for (Category category : listCategories) 
		{
			System.out.println(category.getCategoryId() + ": "+category.getCategoryName()+": "+category.getCategoryDesc());
		}
	}
}
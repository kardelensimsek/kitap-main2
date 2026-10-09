package com.example.kitapapi.service;
import com.example.kitapapi.entity.Category;
import com.example.kitapapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CategoryService {
private final CategoryRepository categoryRepository;
public CategoryService(CategoryRepository categoryRepository)
{
 this.categoryRepository=categoryRepository;
}

public List<Category>getAllCategories(){//kategorileri getirir
    return categoryRepository.findAll();
}
public Category addCategory(Category category) {//yeni kategori ekler
   return categoryRepository.save(category);
}






}

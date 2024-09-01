package com.cidadao.conectado.modules.category;

import com.cidadao.conectado.modules.category.payload.request.CreateCategoryRequest;
import com.cidadao.conectado.modules.category.payload.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void addCategory(List<CreateCategoryRequest> categoryRequests) {
        List<Category> categories = categoryMapper.toDto(categoryRequests);
        List<Category> categoriesToSave = new ArrayList<>();

        for (Category category : categories) {
            if (!categoryRepository.existsByName(category.getName())) {
                categoriesToSave.add(category);
            }
        }

        categoryRepository.saveAll(categoriesToSave);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        Page<Category> categories = categoryRepository.findAll(
                PageRequest.of(0, 20, Sort.by("id"))
        );
        return categories
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }
}

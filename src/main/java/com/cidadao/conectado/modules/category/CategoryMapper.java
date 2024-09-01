package com.cidadao.conectado.modules.category;

import com.cidadao.conectado.modules.category.payload.request.CreateCategoryRequest;
import com.cidadao.conectado.modules.category.payload.response.CategoryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CreateCategoryRequest categoryRequest);
    CategoryResponse toDto(Category category);
    List<Category> toDto(List<CreateCategoryRequest> categoryList);
}

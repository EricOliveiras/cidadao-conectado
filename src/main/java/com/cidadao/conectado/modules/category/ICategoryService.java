package com.cidadao.conectado.modules.category;

import com.cidadao.conectado.modules.category.payload.request.CreateCategoryRequest;
import com.cidadao.conectado.modules.category.payload.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    void addCategory(List<CreateCategoryRequest> categoryRequests);
    List<CategoryResponse> getAllCategories();
}

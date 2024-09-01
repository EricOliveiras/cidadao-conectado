package com.cidadao.conectado.modules.category.factory;

import com.cidadao.conectado.modules.category.CategoryServiceImpl;
import com.cidadao.conectado.modules.category.payload.request.CreateCategoryRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AddCategory implements CommandLineRunner {
    private final CategoryServiceImpl categoryServiceImpl;

    public AddCategory(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @Override
    public void run(String... args) throws Exception {
        List<CreateCategoryRequest> categoriesRequests = Arrays.asList(
                new CreateCategoryRequest("Transporte e Mobilidade Urbana"),
                new CreateCategoryRequest("Segurança Pública"),
                new CreateCategoryRequest("Meio Ambiente e Sustentabilidade"),
                new CreateCategoryRequest("Saúde e Bem-Estar"),
                new CreateCategoryRequest("Educação e Cultura"),
                new CreateCategoryRequest("Infraestrutura Urbana"),
                new CreateCategoryRequest("Inclusão Social"),
                new CreateCategoryRequest("Economia e Emprego"),
                new CreateCategoryRequest("Tecnologia e Inovação"),
                new CreateCategoryRequest("Lazer e Entretenimento"),
                new CreateCategoryRequest("Habitação e Desenvolvimento Urbano"),
                new CreateCategoryRequest("Turismo e Patrimônio Cultural"),
                new CreateCategoryRequest("Agricultura Urbana e Alimentação"),
                new CreateCategoryRequest("Gestão e Participação Cidadã")
        );

        categoryServiceImpl.addCategory(categoriesRequests);
    }
}

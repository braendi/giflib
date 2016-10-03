package com.teamtreehous.giflib.data;

import com.teamtreehous.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author braendi
 */
@Component
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Technology"),
            new Category(2, "People"),
            new Category(3, "Destruction"));

    public List<Category> findAll() {
        return ALL_CATEGORIES;
    }

    public Category findById(int id) {
        return ALL_CATEGORIES.stream().filter(cat -> cat.getId() == id).findFirst().orElse(null);
    }

}

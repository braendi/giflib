package com.teamtreehous.giflib.controller;

import com.teamtreehous.giflib.data.CategoryRepository;
import com.teamtreehous.giflib.data.GifRepository;
import com.teamtreehous.giflib.model.Category;
import com.teamtreehous.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GifRepository gifRepository;

    @RequestMapping(path = "/categories")
    public String listCategories(ModelMap modelMap) {
        modelMap.put("categories", categoryRepository.findAll());
        return "categories";
    }

    @RequestMapping(path = "/category/{id}")
    public String gifDetails(@PathVariable int id, ModelMap modelMap) {
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);
        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);
        return "category";
    }
}

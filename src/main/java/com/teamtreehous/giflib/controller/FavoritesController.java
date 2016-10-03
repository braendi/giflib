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
public class FavoritesController {

    @Autowired
    GifRepository gifRepository;

    @RequestMapping(path = "/favorites")
    public String listCategories(ModelMap modelMap) {
        modelMap.put("gifs", gifRepository.findFavorites());
        return "favorites";
    }

}

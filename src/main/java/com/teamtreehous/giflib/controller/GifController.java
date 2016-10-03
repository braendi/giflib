package com.teamtreehous.giflib.controller;

import com.teamtreehous.giflib.data.GifRepository;
import com.teamtreehous.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GifController {

    @Autowired
    GifRepository gifRepository;

    @RequestMapping(path = "/")
    public String listGifs(ModelMap modelMap) {
        modelMap.put("gifList", gifRepository.findAll());
        return "home";
    }

    @RequestMapping(path = "/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping(path = "/", params = "q")
    public String search(@RequestParam("q") String searchFor, ModelMap modelMap) {
        modelMap.put("gifList", gifRepository.searchByName(searchFor));
        return "home";
    }
}

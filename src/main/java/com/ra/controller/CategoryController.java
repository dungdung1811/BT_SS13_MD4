package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private  CategoryService categoryService;

    @RequestMapping("")
    public String index(Model model){
        List<Category> category = categoryService.findAll();
        model.addAttribute("category",category);
        return "category/index";
    }
    @RequestMapping("/add")
    public String add(Model model){
      Category category = new Category();
        model.addAttribute("category",category);

        return "category/add";
    }
    @RequestMapping("/create")
    public String create(@ModelAttribute("category")Category category ){
        categoryService.create(category);
        return "redirect:/category";


    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        categoryService.delete(id);
        return "redirect:/category";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute(category);
        return "category/edit";
    }
    @RequestMapping("/save/{id}")
    public String save(@ModelAttribute("category") Category category,@PathVariable("id") int id){
        categoryService.update(category,id);
        return "redirect:/category";
    }


}

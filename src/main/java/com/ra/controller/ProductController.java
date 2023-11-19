package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.CategoryService;
import com.ra.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @RequestMapping("")
    public String index(Model model){
        List<Product> list = productService.findAll();
       model.addAttribute("products",list);
        return "product/index";
    }

    @RequestMapping("/add")
    public String add(Model model){
        Product product = new Product();
        model.addAttribute("category",categoryService.findAll());
        model.addAttribute("product",product);

        return "product/add";
    }
    @RequestMapping ("/create")
    public  String create (@ModelAttribute("product")Product product, @RequestParam("file_upload")MultipartFile file, HttpServletRequest request){

        String path = request.getServletContext().getRealPath("uploads/images");
        String fileName = file.getOriginalFilename();
        File destination = new File(path+"/"+fileName);
        try {

            Files.write(destination.toPath(),file.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        product.setImage(fileName);
        productService.create(product);
        return "redirect:/product";
    }

    @RequestMapping("edit/{id}")
    public String edit (@PathVariable("id") int id, Model model){
        List<Category> category = categoryService.findAll();
        model.addAttribute("category",category);


        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product/edit";
    }
    @RequestMapping("/update/{id}")
    public String save (@ModelAttribute("product") Product product,@PathVariable ("id") int id){
        productService.update(product,id);
        return "redirect:/product";
    }
    @RequestMapping ("delete/{id}")
    public String delete (@PathVariable("id")int id){
        productService.delete(id);
        return "redirect:/product";
    }
}

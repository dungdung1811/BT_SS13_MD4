package com.ra.model.service;

import com.ra.model.dao.CategoryDao;
import com.ra.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private  CategoryDao categoryDao;
    @Override
    public List<Category> findAll() {

        return categoryDao.findAll();
    }

    @Override
    public Boolean create(Category category) {
        return categoryDao.create(category);
    }

    @Override
    public Boolean update(Category category, Integer id) {
        return categoryDao.update(category,id);
    }

    @Override
    public Category findById(Integer id) {
        return categoryDao.findById(id);
    }

    @Override
    public void delete(Integer id) {
        categoryDao.delete(id);
    }
}

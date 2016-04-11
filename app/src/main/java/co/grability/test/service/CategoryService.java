package co.grability.test.service;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

import co.grability.test.bo.Category;
import co.grability.test.core.AbstractDao;
import co.grability.test.core.Service;
import co.grability.test.dao.CategoryDao;

public class CategoryService extends Service{

    private AbstractDao categoryDao;
    public CategoryService(Context context){
        categoryDao=new CategoryDao(context);
    }

    public List<Category> find(){
        return categoryDao.list();
    }

}

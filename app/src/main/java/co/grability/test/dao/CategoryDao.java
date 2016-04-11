package co.grability.test.dao;

import android.content.Context;
import android.database.Cursor;

import java.sql.ResultSet;
import java.util.ArrayList;

import co.grability.test.bo.Category;
import co.grability.test.core.AbstractDao;

public class CategoryDao extends AbstractDao<Category,Integer>{

    public static final String METADATA_TABLE="CATEGORIES";
    public static final String[] METADATA_COLUMNS={"ID TEXT PRIMARY KEY","LABEL TEXT"};

    public CategoryDao(Context context) {
        super(context, METADATA_TABLE, METADATA_COLUMNS);
    }

    @Override
    public void save(Category e) {
        exec("INSERT INTO " + METADATA_TABLE + "(ID,LABEL) VALUES('" + e.getId() + "','" + e.getLabel() + "');");
    }

    @Override
    public ArrayList<Category> list() {
        ArrayList<Category> list = new ArrayList<>();
        try {
            System.out.println("Consultando las categorias");
            Cursor cursor = rawQuery("SELECT * FROM " + METADATA_TABLE);
            System.out.println(cursor.getCount());
            System.out.println(cursor.getColumnCount());
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                list.add(new Category(cursor.getString(0), "", "", cursor.getString(1)));
                cursor.moveToNext();
            }
        }catch(Exception e){
            e.printStackTrace();

        }
        return list;
    }
    @Override
    public Category findByPk(Integer integer) {
        return null;
    }
}

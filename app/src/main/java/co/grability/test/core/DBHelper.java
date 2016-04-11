package co.grability.test.core;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.grability.test.bo.Category;
import co.grability.test.dao.AppDao;
import co.grability.test.dao.CategoryDao;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    public DBHelper(Context context){
        super(context,"APPSIOS3.db",null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            AbstractDao appDao = new AppDao(this.context);
            appDao.setDatabase(db);
            db.execSQL(appDao.createTable());

            AbstractDao categoryDao = new CategoryDao(this.context);
            categoryDao.setDatabase(db);
            db.execSQL(categoryDao.createTable());

            Cursor rs = db.rawQuery("SELECT COUNT(1) as n_categories FROM " + CategoryDao.METADATA_TABLE, null);
            rs.moveToFirst();
            Integer nCategories = rs.getInt(rs.getColumnIndex("n_categories"));
            if (nCategories == 0) {
                List<Category> categoryList = Arrays.asList(
                        new Category("newapplications", "", "", "New Applications"),
                        new Category("newfreeapplications", "", "", "New Free Applications"),
                        new Category("newpaidapplications", "", "", "New Paid Applications"),
                        new Category("topfreeapplications", "", "", "Top Free Applications"),
                        new Category("topfreeipadapplications", "", "", "Top Free iPad Applications"),
                        new Category("topgrossingapplications", "", "", "Top Grossing Applications"),
                        new Category("topgrossingipadapplications", "", "", "Top Grossing iPad Applications"),
                        new Category("toppaidapplications", "", "", "Top Paid Applications"),
                        new Category("toppaidipadapplications", "", "", "Top Paid iPad Applications")
                );
                categoryDao.save(categoryList);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

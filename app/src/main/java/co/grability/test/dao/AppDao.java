package co.grability.test.dao;

import android.content.Context;
import android.database.Cursor;

import co.grability.test.bo.App;
import co.grability.test.bo.Category;
import co.grability.test.core.AbstractDao;
import java.util.ArrayList;


public class AppDao extends AbstractDao<App,Integer>{

    public static final String METADATA_TABLE="APPS";
    public static final String[] METADATA_COLUMNS={"APP_ID TEXT PRIMARY KEY","LABEL TEXT",
            "PRICE TEXT","SUMMARY TEXT","ARTIST_LABEL TEXT","ARTIST_HREF TEXT",
            "CATEGORY_ID TEXT","CATEGORY_LABEL TEXT"};

    public AppDao(Context context) {
        super(context,METADATA_TABLE,METADATA_COLUMNS);
    }

    @Override
    public void save(App e) {
        try {


            //exec("DROP TABLE IF EXISTS "+METADATA_TABLE);
            exec(createTable());
            Cursor cursor = rawQuery("SELECT count(1) FROM " + METADATA_TABLE + " WHERE APP_ID='" + e.getId().getId() + "'");
            cursor.moveToFirst();
            Integer res = cursor.getInt(0);
            if (res == 0) {
                String sql = "INSERT INTO " + METADATA_TABLE + "(APP_ID,LABEL,PRICE,SUMMARY,ARTIST_LABEL,ARTIST_HREF,CATEGORY_ID,CATEGORY_LABEL) " +
                        "VALUES('" + e.getId().getId() + "','" + e.getTitle().replaceAll("'", "-") + "','" + e.getPrice().getLabel() + " " + e.getPrice().getAmount() + "','" + (e.getSummary()!=null?e.getSummary().replaceAll("'", "-"):"") + "','" + e.getArtist().getLabel().replaceAll("'", "-") + "','" + e.getArtist().getHref().replaceAll("'", "-") + "','" + e.getCategory().getId() + "','" + e.getCategory().getLabel().replaceAll("'", "-") + "');";
                exec(sql);
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    @Override
    public ArrayList<App> list() {
        return list(new Category("topfreeapplications","","","Top Free Applications"));
    }
    public ArrayList<App> list(Category category) {
        Cursor cursor=rawQuery("SELECT * FROM "+METADATA_TABLE+" WHERE CATEGORY_ID='"+category.getId()+"'");
        cursor.moveToFirst();
        ArrayList<App> apps=new ArrayList<>();
        while(!cursor.isAfterLast()){
            cursor.getString(0);
            App app=new App();
            app.setId(cursor.getString(0),cursor.getString(0),cursor.getString(0));
            app.setTitle(cursor.getString(1));
            app.setPrice(cursor.getString(2), 0.0, "");
            app.setSummary(cursor.getString(3));
            app.setArtist(cursor.getString(4), cursor.getString(5));
            app.setCategory(new Category(cursor.getString(6), "", "", cursor.getString(7)));
            apps.add(app);
            cursor.moveToNext();
        }
        return apps;
    }

    @Override
    public App findByPk(Integer pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


    
}

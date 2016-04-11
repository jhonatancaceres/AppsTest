package co.grability.test.core;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.grability.test.bo.App;
import co.grability.test.config.ApplicationManager;

public abstract class AbstractDao<BO,PK>{

    private Context context;
    private String table;
    private String []columns;
    private DBHelper openHelper;
    private SQLiteDatabase database;

    public AbstractDao(Context context,String table,String[] columns ){
        this.context=context;
        this.table=table;
        this.columns=columns;

    }
    public void setDatabase(SQLiteDatabase database){
        this.database=database;
    }
    private SQLiteDatabase getDatabase(){
        if(this.database==null){
            return ApplicationManager.getDBInstance(this.context);
        }else{
            return database;
        }
    }

    public abstract void save(BO e);
    public void save(List<BO> all){
        for(BO e:all){
            save(e);
        }
    }
    public abstract ArrayList<BO> list();
    public abstract BO findByPk(PK pk);

    public String createTable(){
        String sql="CREATE TABLE IF NOT EXISTS "+this.table+"(";
        int t=columns.length;
        for(int i=0;i<t;i++){
            sql+=columns[i];
            if(i<(t-1)){
                sql+=",";
            }
        }
        sql+=");";
        return sql;
    }
    public void exec(String sql){
        getDatabase().execSQL(sql);
    }
    public Cursor rawQuery(String query){
        return getDatabase().rawQuery(query,null);
    }
    

}

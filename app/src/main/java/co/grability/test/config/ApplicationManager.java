package co.grability.test.config;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

import java.io.File;

import co.grability.test.bo.Category;
import co.grability.test.core.DBHelper;

public class ApplicationManager {

    public static final String itunesHost = "https://itunes.apple.com/us/rss/";

    private static DBHelper dbHelper;

    public static boolean checkInternet(Context ctx) {
        ConnectivityManager conMgr = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null)
            return false;
        if (!i.isConnected())
            return false;
        if (!i.isAvailable())
            return false;
        return true;
    }
    public static boolean isTablet(Context ctx){
        return (ctx.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


    private static SQLiteDatabase database;
    public static SQLiteDatabase getDBInstance(Context context){
        if(ApplicationManager.database==null){
            DBHelper dbHelper=new DBHelper(context);
            ApplicationManager.database=dbHelper.getWritableDatabase();
        }
        return ApplicationManager.database;
    }

    public static void setup(Activity context){
        setup(context,null);
    }
    public static void setup(Activity context,String title){
        String strTitle=context.getTitle()+(title!=null?" - "+title:"");
        if(!checkInternet(context)){
            strTitle+=" (Offline)";
        }
        context.setTitle(strTitle);
        if(isTablet(context)){
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else{
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

}

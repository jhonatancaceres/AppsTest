package co.grability.test.config;

import android.os.Environment;

import java.io.File;

public class CacheManager {

    public static final String dir_cache="appscache";

    public static void createCache(){
        File f=new File(getFilePath(null));
        if(!f.exists()){
            f.mkdir();
        }
    }
    public static File getAppImageFile(String appId,Integer size){
        return new File(getFilePath("im_"+appId+"_"+size+".dat"));
    }
    private static String getFilePath(String fileName){
        String path= Environment.getExternalStorageDirectory()+"/"+dir_cache;
        if(fileName!=null){
            path+="/"+fileName;
        }
        return path;
    }
}

package co.grability.test.front.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import co.grability.test.bo.App;
import co.grability.test.config.ApplicationManager;
import co.grability.test.config.CacheManager;

public class DownloadImageTask extends AsyncTask<Void, Void, Bitmap> {

    private ImageView bmImage;
    private String appId;
    private Integer imageSize;
    private String url;

    public DownloadImageTask(ImageView bmImage,String appId,Integer imageSize,String url) {
        this.bmImage = bmImage;
        this.appId=appId;
        this.imageSize=imageSize;
        this.url=url;
    }
    protected Bitmap doInBackground(Void... p) {
        Bitmap mIcon11 = null;
        try {
            File f= CacheManager.getAppImageFile(appId, imageSize);
            if(f.exists()){
                InputStream in = new FileInputStream(f);
                mIcon11 = BitmapFactory.decodeStream(in);
            }else{
                if(url!=null) {
                    InputStream in = new java.net.URL(url).openStream();
                    mIcon11 = BitmapFactory.decodeStream(in);
                    in.close();
                    FileOutputStream out = new FileOutputStream(f);
                    mIcon11.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}
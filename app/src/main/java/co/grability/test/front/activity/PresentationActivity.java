package co.grability.test.front.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Timer;
import java.util.TimerTask;

import co.grability.test.R;
import co.grability.test.config.ApplicationManager;
import co.grability.test.config.CacheManager;
import co.grability.test.core.DBHelper;
import co.grability.test.dao.AppDao;
import co.grability.test.dao.CategoryDao;

public class PresentationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        ApplicationManager.setup(this);

        ImageView myImageView= (ImageView)findViewById(R.id.imageView);
        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        myImageView.startAnimation(myFadeInAnimation);

        CacheManager.createCache();
        //ApplicationManager.getDBInstance(this).execSQL("DROP TABLE IF EXISTS "+ CategoryDao.METADATA_TABLE);
        new Timer().schedule(new TimerTask() {
            public void run() {
                startActivity(new Intent(PresentationActivity.this, CategoryListActivity.class));
            }
        }, 3500);

    }

    @Override
    public void onConfigurationChanged (Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        return;
    }
}

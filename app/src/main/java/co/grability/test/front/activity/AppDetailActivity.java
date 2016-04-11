package co.grability.test.front.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import co.grability.test.R;
import co.grability.test.bo.App;
import co.grability.test.config.ApplicationManager;
import co.grability.test.front.task.DownloadImageTask;

public class AppDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_detail);

        Intent i=getIntent();
        App app=(App)i.getSerializableExtra(App.class.getName());
        ApplicationManager.setup(this,app.getTitle());
        setupViewDetail(app);

    }
    private void setupViewDetail(App app){
        if(app!=null){
            TextView labelApp=(TextView)findViewById(R.id.tvAppDetailLabel);
            TextView labelPrice=(TextView)findViewById(R.id.tvAppDetailPrice);
            TextView labelSummary=(TextView)findViewById(R.id.tvAppDetailSummary);
            TextView labelArtist=(TextView)findViewById(R.id.tvAppDetailArtistLabel);
            ImageView imageView=(ImageView)findViewById(R.id.ivAppDetailImage);

            labelApp.setText(app.getTitle());
            labelPrice.setText(app.getPrice().getCurrency()+" "+app.getPrice().getAmount());
            labelSummary.setText(app.getSummary());
            labelArtist.setText(app.getArtist().getLabel());

            new DownloadImageTask(imageView,app.getId().getId(),100,app.getUrlImage(1)).execute();

        }
    }
}

package co.grability.test.front.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.grability.test.R;
import co.grability.test.bo.App;
import co.grability.test.bo.Category;
import co.grability.test.config.ApplicationManager;
import co.grability.test.front.grid.AppGridAdapter;
import co.grability.test.front.task.SearchAppTask;
import co.grability.test.service.AppService;

public class AppListActivity extends AppCompatActivity {

    private List<App> appList;
    private GridView gridView;
    private AppService service;
    private AppGridAdapter gridAdapter;
    private Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);

        Intent i=getIntent();
        category=(Category)i.getSerializableExtra(Category.class.getName());

        ApplicationManager.setup(this,category.getLabel());

        TextView internetStatus=(TextView)findViewById(R.id.tvAppListStatus);
        internetStatus.setText(ApplicationManager.checkInternet(this)?"Online":"Offline");

        gridView=(GridView)findViewById(R.id.grid_view_app);
        gridView.setNumColumns(ApplicationManager.isTablet(this)?4:3);
        setupGridView();

    }
    private void setupGridView(){
        try{
            gridAdapter=new AppGridAdapter(this,new ArrayList<App>());
            service=new AppService(this);
            gridView.setAdapter(gridAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(AppListActivity.this, AppDetailActivity.class);
                    App app=(App)parent.getItemAtPosition(position);
                    i.putExtra(App.class.getName(),app);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                }
            });
            new SearchAppTask(this,category,gridAdapter,service).execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        service=new AppService(this);
    }

    @Override
    public void onBackPressed(){
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}

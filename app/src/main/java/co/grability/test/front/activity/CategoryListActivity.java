package co.grability.test.front.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import co.grability.test.R;
import co.grability.test.bo.App;
import co.grability.test.bo.Category;
import co.grability.test.config.ApplicationManager;
import co.grability.test.front.grid.AppGridAdapter;
import co.grability.test.front.grid.CategoryListAdapter;
import co.grability.test.service.AppService;
import co.grability.test.service.CategoryService;

public class CategoryListActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Category> categoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ApplicationManager.setup(this);
        setupListView();
        TextView internetStatus=(TextView)findViewById(R.id.tvGeneralStatus);
        internetStatus.setText(ApplicationManager.checkInternet(this)?"Online":"Offline");
    }
    @Override
    public void onClick(View v){
        startActivity(new Intent(this, AppListActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
    private void setupListView(){
        if(categoryList==null){
            CategoryService service=new CategoryService(this);
            categoryList=service.find();
        }
        ListView listView=(ListView)findViewById(R.id.list_view_category);
        BaseAdapter adapter = new CategoryListAdapter(this,categoryList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(CategoryListActivity.this,AppListActivity.class);
                i.putExtra(Category.class.getName(),categoryList.get(position));
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
    }


}

package co.grability.test.front.task;

import android.os.AsyncTask;
import android.widget.Adapter;

import java.util.ArrayList;

import co.grability.test.bo.App;
import co.grability.test.bo.Category;
import co.grability.test.front.grid.AppGridAdapter;
import co.grability.test.service.AppService;

public class SearchAppTask extends AsyncTask<Void, Void, ArrayList<App>> {

    private Category category;
    private AppGridAdapter adapter;
    private AppService service;

    public SearchAppTask(Category category, AppGridAdapter adapter,AppService service) {
        this.category = category;
        this.adapter = adapter;
        this.service=service;
    }
    @Override
    protected ArrayList<App> doInBackground(Void... params) {
        return service.find(this.category);
    }
    @Override
    protected void onPostExecute(ArrayList<App> appList) {
        // Download complete. Let us update UI
        if (appList!=null && appList.size()>0) {
            adapter.setGridData(appList);
        } else {
            //Toast.makeText(GridViewActivity.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
        }
        //mProgressBar.setVisibility(View.GONE);
    }
}
package co.grability.test.front.task;

import android.app.ProgressDialog;
import android.content.Context;
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
	private Context context;
	private ProgressDialog progressDialog;

    public SearchAppTask(Context context,Category category, AppGridAdapter adapter,AppService service) {
        this.category = category;
        this.adapter = adapter;
        this.service=service;
		this.context=context;
    }
	
	@Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(context, "Searching apps...", "Please wait");
        super.onPreExecute();
    }
    
    @Override
    protected ArrayList<App> doInBackground(Void... params) {
        return service.find(this.category);
    }
    @Override
    protected void onPostExecute(ArrayList<App> appList) {
        if (appList!=null && appList.size()>0) {
            adapter.setGridData(appList);
        }
        progressDialog.dismiss();
    }
}
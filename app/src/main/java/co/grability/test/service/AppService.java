package co.grability.test.service;
import android.content.Context;

import co.grability.test.bo.Category;
import co.grability.test.dao.AppDao;
import co.grability.test.service.bean.Itunes;
import co.grability.test.bo.App;
import co.grability.test.config.ApplicationManager;
import co.grability.test.core.Service;
import co.grability.test.service.mapper.AppMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class AppService extends Service {

    private Context context;
    private AppDao dao;
    public AppService(Context context){
        this.context=context;
        this.dao=new AppDao(context);

    }

    public ArrayList<App> find(Category category) {
        ArrayList<App> apps = null;
        if (ApplicationManager.checkInternet(context)) {
            try {
                System.out.println(prepareUrl(category));
                String json = readJson(prepareUrl(category));
                json=json.replaceAll("im:","");

                Gson gson = new GsonBuilder().create();

                Itunes itunes = gson.fromJson(json, Itunes.class);
                AppMapper mapper=new AppMapper();
                apps = mapper.mapAll(itunes.getFeed().getEntry());
                for(App app:apps){
                    app.setCategory(category);
                    dao.save(app);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            apps=dao.list(category);
        }
        return apps;
    }

    private String prepareUrl(Category category) {
        return ApplicationManager.itunesHost +category.getId()+ "/limit=20/json";
    }

}

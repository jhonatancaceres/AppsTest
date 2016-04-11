/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.grability.test.service.mapper;

import co.grability.test.service.bean.Entry;
import co.grability.test.service.bean.Image;
import co.grability.test.bo.App;
import co.grability.test.bo.Category;
import co.grability.test.core.JsonMapper;
import java.util.ArrayList;

public class AppMapper implements JsonMapper<App,Entry>{
    
    public App map(Entry entry){
        App app=new App();        
        app.setArtist(entry.getArtist().getLabel(),entry.getArtist().getAttributes().getHref());
        app.setCategory(new Category(entry.getCategory().getAttributes().getId(),entry.getCategory().getAttributes().getTerm(),entry.getCategory().getAttributes().getScheme(),entry.getCategory().getAttributes().getLabel()));
        app.setContentType(entry.getContentType().getAttributes().getTerm(),entry.getContentType().getAttributes().getLabel());
        app.setId(entry.getId().getLabel(),entry.getId().getAttributes().getId(),entry.getId().getAttributes().getBundleId());        
        for(Image img:entry.getImage()){
            app.addImage(img.getLabel(),new Integer(img.getAttributes().getHeight()));
        }
        app.setLink(entry.getLink().getAttributes().getRel(),entry.getLink().getAttributes().getType(),entry.getLink().getAttributes().getHref());
        app.setName(entry.getName().getLabel());
        app.setPrice(entry.getPrice().getLabel(),new Double(entry.getPrice().getAttributes().getAmount()),entry.getPrice().getAttributes().getCurrency());
        app.setReleaseDate(entry.getReleaseDate().getLabel(),entry.getReleaseDate().getAttributes().getLabel());
        app.setRights(entry.getRights().getLabel());
        if(entry.getSummary()!=null)
            app.setSummary(entry.getSummary().getLabel());
        app.setTitle(entry.getTitle().getLabel());
        return app;
    }
    public ArrayList<App> mapAll(Entry[] entries){
        ArrayList<App> apps=new ArrayList<>();
        for(Entry entry:entries){
            apps.add(map(entry));
        }
        return apps;
    }
}

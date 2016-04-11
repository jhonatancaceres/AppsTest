package co.grability.test.front.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.grability.test.R;
import co.grability.test.bo.App;
import co.grability.test.front.task.DownloadImageTask;

public class AppGridAdapter extends BaseAdapter {

    private Context context;
    private List<App> items;
    public AppGridAdapter(Context context,List items){
        this.context=context;
        this.items=items;
    }
    public void setGridData(List<App> items) {
        this.items=items;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_view_app, viewGroup, false);
        }
        final App item = (App)getItem(position);
        ImageView img = (ImageView) view.findViewById(R.id.ivItemAppImage);
        new DownloadImageTask(img,item.getId().getId(),53,item.getUrlImage(0)).execute();

        TextView price = (TextView) view.findViewById(R.id.tvItemAppPrice);
        price.setText(""+item.getPrice().getAmount());
        return view;
    }
}

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
import co.grability.test.bo.Category;

public class CategoryListAdapter extends BaseAdapter {
    private List<Category> items;
    private Context context;
    public CategoryListAdapter(Context context, List<Category> items) {
        this.items = items;
        this.context=context;
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
            view = inflater.inflate(R.layout.item_view_category, viewGroup, false);
        }

        //ImageView img = (ImageView) view.findViewById(R.id.app_grid_item_img);
        TextView label = (TextView) view.findViewById(R.id.tvCategoryLabel);

        Category item=(Category)getItem(position);

        label.setText(item.getLabel());
        //final App item = (App)getItem(position);
        return view;
    }
}

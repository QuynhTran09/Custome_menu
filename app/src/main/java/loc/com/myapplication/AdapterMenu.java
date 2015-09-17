package loc.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import loc.com.myapplication.Model.ItemMenu;

/**
 * Created by loc on 17/09/2015.
 */
public class AdapterMenu extends BaseAdapter {
    ArrayList<ItemMenu> list;
    Context context;

    public AdapterMenu(Context context, ArrayList<ItemMenu> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    View v;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        v = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_menu, parent, false);
        TextView txt = (TextView) v.findViewById(R.id.textView2);
        txt.setText(list.get(position).getTitle());
        ImageView img = (ImageView) v.findViewById(R.id.imageView2);
        img.setImageResource(list.get(position).getImage());
        RelativeLayout item = (RelativeLayout) v.findViewById(R.id.item);
        /*-------------------------------------*/
        for (int i = 0; i < list.size(); i++) {


        }
        return v;
    }
}

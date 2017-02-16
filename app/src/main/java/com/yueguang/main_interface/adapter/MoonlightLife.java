package com.yueguang.main_interface.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yueguang.main_interface.Bean.MoonlightBean;

import java.util.List;

import fengjie.baway.com.yueguangcharen.R;

import static android.content.ContentValues.TAG;

/**
 * Created by FengJIe on 2017/2/14.
 */

public class MoonlightLife extends BaseAdapter {

    private Context context;
    private List<MoonlightBean.DataBean.CategoriesBean> list;
    private ListView listViewRight;


    public MoonlightLife(Context context, List<MoonlightBean.DataBean.CategoriesBean> list,
            ListView listViewRight) {
        this.context = context;
        this.listViewRight = listViewRight;
        this.list = list;
        List<MoonlightBean.DataBean.CategoriesBean.ProductsBean> products = list.get(0).getProducts();
        MoonlightRight moonlightRight=new MoonlightRight(context,products);
        listViewRight.setAdapter(moonlightRight);



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

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.item_moonlight_lift,null);
            holder=new ViewHolder();
            holder.textView= (TextView) convertView.findViewById(R.id.list_item_moonlight_lift);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).getName());
        Log.d(TAG, "MoonlightLife: "+list.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MoonlightBean.DataBean.CategoriesBean.ProductsBean> products = list.get(position).getProducts();
                MoonlightRight moonlightRight=new MoonlightRight(context,products);
                listViewRight.setAdapter(moonlightRight);
            }
        });
        return convertView;
    }
    public final class ViewHolder{
        public TextView textView;
    }
}

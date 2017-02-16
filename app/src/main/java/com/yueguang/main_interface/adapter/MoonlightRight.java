package com.yueguang.main_interface.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.BitmapUtils;
import com.yueguang.main_interface.Bean.MoonlightBean;

import java.util.List;

import fengjie.baway.com.yueguangcharen.R;

import static android.R.attr.y;
import static android.content.ContentValues.TAG;

/**
 * Created by FengJIe on 2017/2/14.
 */

public class MoonlightRight extends BaseAdapter {
    private Context context;
    private List<MoonlightBean.DataBean.CategoriesBean.ProductsBean> list;



    public MoonlightRight(Context context, List<MoonlightBean.DataBean.CategoriesBean.ProductsBean> list) {
        this.context = context;
        this.list = list;





        Log.d(TAG, "getCount: "+list.size()+"");
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.item_moolight_right,null);
            viewHolder =new ViewHolder();
            viewHolder.imageView= (ImageView) convertView.
                    findViewById(R.id.list_item_moonlight_right_iv);
            viewHolder.textViewName= (TextView) convertView.findViewById(R.id.
                    list_item_moonlight_right_name);
            viewHolder.textViewPrice= (TextView) convertView.findViewById
                    (R.id.list_item_moonlight_right_price);
            convertView.setTag(viewHolder);
            viewHolder.discount= (TextView) convertView.findViewById
                    (R.id.list_item_moonlight_right_discount);
            viewHolder.featuredPrice= (TextView) convertView.
                    findViewById(R.id.featured_price);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        BitmapUtils bitmapUtils=new BitmapUtils(context);
        bitmapUtils.display(viewHolder.imageView,list.get(position).getImage_small());
        //viewHolder.imageView.setImageBitmap(bitmap);
        viewHolder.textViewName.setText(list.get(position).getName());

        viewHolder.textViewPrice.setText("￥"+list.get(position).getFeatured_price());
        String featured=list.get(position).getFeatured_price();
        String price=list.get(position).getPrice();
        Log.d(TAG, "getView: "+featured+price);


        if (featured!=null){
            double x= Double.parseDouble(featured);

            viewHolder.featuredPrice.setText("￥"+list.get(position).getPrice());
            double  y= Double.parseDouble((price));


            double z=y-x;

            viewHolder.discount.setText("立减￥"+z);

        }else {
            viewHolder.textViewPrice.setText("￥"+list.get(position).getPrice());
        }


        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了",Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }


    public final class ViewHolder{
        TextView featuredPrice;
        TextView discount;
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
    }
}

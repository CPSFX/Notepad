package com.example.notepad;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

class VieHolder{
    public TextView title;
    public TextView name;
    public  TextView context;
    public TextView date;
    View itemView;
    public VieHolder(View itemView)
    {
        if (itemView==null)
        {
            throw new IllegalArgumentException("itemView 不能为空");
        }
        this.itemView=itemView;
        //使用findViewByTd方法获取textview实例
        title=itemView.findViewById(R.id.Text_Title);
        name=itemView.findViewById(R.id.Text_Name);
        context=itemView.findViewById(R.id.Context);
        date=itemView.findViewById(R.id.Date);

    }
}


//记事本适配器
public class TextAdapter extends BaseAdapter {
    private Context context;
    private List<textBean> textBeanList;
    private LayoutInflater layoutInflater;
    private VieHolder vieHolder;


    public TextAdapter(Context context, List<textBean> textBeanList) {
        this.context=context;
        this.textBeanList=textBeanList;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return textBeanList.size();
    }

    @Override
    public Object getItem(int i) {

        return textBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            //调用layoutInflater来加载每一项的布局
            view=layoutInflater.inflate(R.layout.list_item,null);
            //包装list_item中的项
            vieHolder=new VieHolder(view);
            view.setTag(vieHolder);//将vieHolder存储在view中
        }
        else {
            vieHolder= (VieHolder) view.getTag();//重新获取vieHolder
        }
        //textBeanList.get(i) 数据库返回的每一项
        //调用setText方法来设置显示的图片和文字
        vieHolder.title.setText(textBeanList.get(i).getTitle());
        vieHolder.name.setText(textBeanList.get(i).getName());
        vieHolder.context.setText(textBeanList.get(i).getContext());
        vieHolder.date.setText(textBeanList.get(i).getDate());
        //测试
        if(view==null)
        {
            Log.e(null,"适配器返回视图错误");
        }
        if(view!=null)
        {
            Log.e(null,"适配器返回视图成功");
        }
        return view;
    }
}


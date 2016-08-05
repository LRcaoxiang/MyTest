package com.example.admin.recycleviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by che on 2016/7/30
 * Description:.加载RecyclerView的Adapter，一定要继承RecyclerView.Adapter
 * 并且需要一个泛型，此泛型来自内部类的ViewHodler
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHodler> {
    private Context context;

    //Activity 的回调参数
    private CallBackNew callBackNew;

    public void setCallBackNew(CallBackNew callBackNew) {
        this.callBackNew = callBackNew;
    }

    //构造方法，传递Context参数
    public MyAdapter(Context context) {
        this.context = context;
    }
    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载布局
        View view = View.inflate(context,R.layout.item_recycletest,null);
        //实例化ViewHodler
        ViewHodler viewHodler =new ViewHodler(view);
        //加载TextView
        viewHodler.text_test = (TextView) view.findViewById(R.id.text_test);
        return viewHodler;
    }
    //View的逻辑处理方法
    //此方法中的holder对象为onCreateViewHolder方法中返回的对象，直接使用
    @Override
    public void onBindViewHolder(ViewHodler holder, final int position) {
        holder.text_test.setText("文字内容改变了！！");

        //RecycleView的Item点击监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callBackNew != null){
                    //回调Activity中的方法
                    callBackNew.callTest(position);
                }
            }
        });
    }

    //返回条数
    @Override
    public int getItemCount() {//如果是集合，一定要判空
        return 10;
    }
    //viewHodler内部类，需继承RecyclerView.ViewHolder
    public class ViewHodler extends RecyclerView.ViewHolder{
        private TextView text_test;
        public ViewHodler(View itemView) {
            super(itemView);
        }
    }

    //在Adapter中的回调接口
    public interface CallBackNew{
        void callTest(int position);//将点击的位置传递给Activity
    }


}

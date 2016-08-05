package com.example.admin.recycleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

/**
 * 这是RecycleView 的测试工程
 */
public class MainActivity extends AppCompatActivity implements MyAdapter.CallBackNew{
    private RecyclerView recycleView_test;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//封装的方法
    }

    public void initView(){
        recycleView_test = (RecyclerView) findViewById(R.id.recycleView_test);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        //RecycleView也支持表格布局（第二个参数表示一行要显示的个数）
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        recycleView_test.setLayoutManager(gridLayoutManager);

        //addItemDecoration自定义画线加载（DividerItemDecoration（自定义画线的类））
//        recycleView_test.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.HORIZONTAL));

        //加载数据
        myAdapter=new MyAdapter(this);
        //通过set方法传递
        myAdapter.setCallBackNew(this);
        recycleView_test.setAdapter(myAdapter);
    }

    @Override
    public void callTest(int position) {
        Toast.makeText(this,"哈哈，"+"我点击的位置是："+""+position,Toast.LENGTH_SHORT).show();
    }
}

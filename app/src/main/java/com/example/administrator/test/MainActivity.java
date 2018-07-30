package com.example.administrator.test;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.test.fragment.Fragment1;
import com.example.administrator.test.fragment.Fragment2;
import com.example.administrator.test.utils.StaticClass;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;


public class MainActivity extends AppCompatActivity {

    //TabLayout
    private TabLayout mTabLayout;
    //viewPager
    private ViewPager mViewPager;
    //Title
    private List<String> mTitle;
    //Fragment
    private List<Fragment> mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, StaticClass.BMOB_APP_ID);

        //去掉阴影
        getSupportActionBar().setElevation(0);
        initData();
        initView();
    }

    //初始化数据
    private void initData() {
        String mTitle1=(String) this.getResources().getString(R.string.mTitle1);
        String mTitle2=(String) this.getResources().getString(R.string.mTitle2);
        mTitle=new ArrayList<>();
        mTitle.add(mTitle1);
        mTitle.add(mTitle2);

        mFragment=new ArrayList<>();
        mFragment.add(new Fragment1());
        mFragment.add(new Fragment2());
    }

    //初始化View
    private void initView() {
        mTabLayout=findViewById(R.id.mTabLayout);
        mViewPager=findViewById(R.id.mViewPager);

        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());//有几个fragment加载几个

        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的item
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            //返回item的个数
            @Override
            public int getCount() {
                return mFragment.size();
            }

            //设置标题

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });

        //绑定（传ViewPager）
        mTabLayout.setupWithViewPager(mViewPager);
    }


}

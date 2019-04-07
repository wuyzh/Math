package com.wuyazhou.learn.math;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wuyazhou.learn.logview.LogShowView;
import com.wuyazhou.learn.math.ListNode.ListNodePagerView;
import com.wuyazhou.learn.math.StackAndQueue.StackAndQueuePagerView;
import com.wuyazhou.learn.math.sync.SyncNumAndCharPagerView;
import com.wuyazhou.learn.sort.SortPagerView;
import com.wuyazhou.pagerview.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager = null;

    private List<View> mViews = new ArrayList<View>();
    private List<String> mViewTitle = new ArrayList<String>();
    private ViewPagerAdapter mViewPagerAdapter = null;

    private LogShowView mShowLogView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPager();
        initShowLogView();
    }

    private void initPager(){
        mViewPager = findViewById(R.id.view_pager);
        mViewPagerAdapter = new ViewPagerAdapter(mViews,mViewTitle, this);
        mViewPager.setAdapter(mViewPagerAdapter);
        addViewPagerView("反转链表",new ListNodePagerView(this));
        addViewPagerView("栈与队列的相互实现",new StackAndQueuePagerView(this));
        addViewPagerView("数字和字母组合，同步",new SyncNumAndCharPagerView(this));
        addViewPagerView("排序",new SortPagerView(this));
        mViewPagerAdapter.notifyDataSetChanged();

        mViewPager.setCurrentItem(3);
    }

    private void addViewPagerView(String title, View view){
        mViewTitle.add(title);
        mViews.add(view);
    }

    private void initShowLogView(){
        mShowLogView = findViewById(R.id.show_log_view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViews.clear();
        mViews = null;
        mShowLogView.release();
    }
}

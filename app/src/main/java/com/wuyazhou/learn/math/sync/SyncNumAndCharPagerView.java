package com.wuyazhou.learn.math.sync;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wuyazhou.learn.logview.LogShowUtil;
import com.wuyazhou.learn.math.R;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class SyncNumAndCharPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private RelativeLayout mLayout;
    private int i = 0;
    private char mChar = 'A';
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            synchronized (this){
                int threadId = Integer.parseInt(Thread.currentThread().getName());
                try {
                    while (i<26){
                        if (i%3 == threadId-1){
                            LogShowUtil.addLog("三个线程同步问题","结果："+threadId+(char)mChar++,true);
                            i++;
                            notifyAll();
                        }else {
                            wait();
                        }
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public SyncNumAndCharPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
        initData();
    }

    public SyncNumAndCharPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
        initData();
    }

    public SyncNumAndCharPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initData();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_sync_num_char_layout, null);

        addView(mLayout);

        View modelFirst  = mLayout.findViewById(R.id.model_button_1);
        modelFirst.setOnClickListener(this);
    }

    private void initData(){

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.model_button_1) {
            Thread thread1 = new Thread(mRunnable,"1");
            Thread thread2 = new Thread(mRunnable,"2");
            Thread thread3 = new Thread(mRunnable,"3");
            thread1.start();
            thread2.start();
            thread3.start();
        }
    }
}

package com.wuyazhou.learn.math.StackAndQueue;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.wuyazhou.learn.logview.LogShowUtil;
import com.wuyazhou.learn.math.R;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class StackAndQueuePagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private LinearLayout mLayout;
    private StackRealizeQueue mStackRealizeQueue;
    private QueueRealizeStack mQueueRealizeStack;

    public StackAndQueuePagerView(Context context) {
        super(context);
        mContext = context;
        initView();
        initData();
    }

    public StackAndQueuePagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
        initData();
    }

    public StackAndQueuePagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initData();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (LinearLayout) inflater.inflate(R.layout.pager_stack_and_queue_layout, null);

        addView(mLayout);

        View modelFirst  = mLayout.findViewById(R.id.model_button_1);
        modelFirst.setOnClickListener(this);
        View modelSecond  = mLayout.findViewById(R.id.model_button_2);
        modelSecond.setOnClickListener(this);

        View modelThird  = mLayout.findViewById(R.id.model_button_3);
        modelThird.setOnClickListener(this);
        View modelForth  = mLayout.findViewById(R.id.model_button_4);
        modelForth.setOnClickListener(this);
    }

    private void initData(){
        mStackRealizeQueue = new StackRealizeQueue();
        mQueueRealizeStack = new QueueRealizeStack();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.model_button_1) {
            for (int j = 0;j<3;j++){
                mStackRealizeQueue.add(j);
            }

        } else if (i == R.id.model_button_2) {
            LogShowUtil.addLog("栈与队列的相互实现","结果："+mStackRealizeQueue.poll(),true);
        } else if (i == R.id.model_button_3) {
            for (int j = 0;j<3;j++){
                mQueueRealizeStack.push(j);
            }
        } else if (i == R.id.model_button_4) {
            LogShowUtil.addLog("栈与队列的相互实现","结果："+mQueueRealizeStack.pop(),true);
        }
    }

}

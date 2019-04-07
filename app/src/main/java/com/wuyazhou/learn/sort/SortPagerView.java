package com.wuyazhou.learn.sort;

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
public class SortPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private RelativeLayout mLayout;
    private int[] mArray = {1,8,2,7,9,5,4,3,0,13,15,12,11};
    public SortPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
        initData();
    }

    public SortPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
        initData();
    }

    public SortPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initData();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_sort_layout, null);

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
            //Sort.sort(mArray);
            //Sort.bubbleSort(mArray);

            //Sort.shellSort(mArray);

            //Sort.quickSort(mArray,0,mArray.length-1);

            Sort.mergeSort(mArray,0,mArray.length-1);
            for (int j = 0; j<mArray.length;j++){
                LogShowUtil.addLog("排序","结果："+mArray[j],true);
            }


        }
    }
}

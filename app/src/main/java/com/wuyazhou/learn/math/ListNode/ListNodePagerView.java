package com.wuyazhou.learn.math.ListNode;

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
public class ListNodePagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private RelativeLayout mLayout;
    private ListNode mListNode;

    public ListNodePagerView(Context context) {
        super(context);
        mContext = context;
        initView();
        initData();
    }

    public ListNodePagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
        initData();
    }

    public ListNodePagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initData();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_list_node_layout, null);

        addView(mLayout);

        View modelFirst  = mLayout.findViewById(R.id.model_button_1);
        modelFirst.setOnClickListener(this);
        View modelSecond  = mLayout.findViewById(R.id.model_button_2);
        modelSecond.setOnClickListener(this);

        View modelThird  = mLayout.findViewById(R.id.model_button_3);
        modelThird.setOnClickListener(this);
    }

    private void initData(){
        mListNode = new ListNode(1);
        mListNode.next = new ListNode(2);
        mListNode.next.next = new ListNode(3);
        mListNode.next.next.next = new ListNode(4);
        mListNode.next.next.next.next = new ListNode(5);
        mListNode.next.next.next.next.next = new ListNode(6);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.model_button_1) {
            printListNode(mListNode);
        } else if (i == R.id.model_button_2) {
            mListNode = reserveListNode(mListNode);
            printListNode(mListNode);
        } else if (i == R.id.model_button_3){
            mListNode = reverseListNode2(mListNode);
            printListNode(mListNode);
        }
    }

    private ListNode reserveListNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode nextNode = head.next;
        while (nextNode != null){
            head.next = nextNode.next;
            nextNode.next = p.next;
            p.next = nextNode;
            nextNode = head.next;
        }
        return p.next;
    }

    public ListNode reverseListNode2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pNode = reverseListNode2(head.next);
        head.next.next = head;
        head.next = null;
        return pNode;
    }

    private void printListNode(ListNode listNode){
        while (listNode != null){
            LogShowUtil.addLog("反转链表", "节点: "+listNode.node,true);
            listNode = listNode.next;
        }
    }
}

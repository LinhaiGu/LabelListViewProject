package com.example.labellistproject.view.base;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.labellistproject.inface.ILabelInfo;
import com.example.labellistproject.inface.IOnItemClickListener;

/**
 * 瀑布流标签的基类，所有业务类的标签样式继承BaseLabelListView
 * 
 * @author Administrator
 * 
 * @param <T>
 *            业务数据
 */
public abstract class BaseLabelListView<T> extends LinearLayout implements
		ILabelInfo<T> {

	private Context mContext;

	/**
	 * 接口监听
	 */
	private IOnItemClickListener mIOnItemClickListener;

	/**
	 * 数据源
	 */
	private List<T> mDatas = new ArrayList<T>();

	/**
	 * 标签间的横向间距
	 */
	private int itemMargins = 10;

	/**
	 * 标签间的纵向间距
	 */
	private int itemTopMargins = 10;

	/**
	 * 文字大小
	 */
	private int textSize = 30;

	/**
	 * 圆角度数
	 */
	private int radius = 2;

	private boolean isFirst = true;

	public BaseLabelListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.mContext = context;
		init();
	}

	public BaseLabelListView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public BaseLabelListView(Context context) {
		this(context, null);
	}

	private void init() {
		this.setOrientation(LinearLayout.VERTICAL);
	}

	/**
	 * 添加数据
	 * 
	 * @param data
	 */
	public void setData(List<T> _datas) {

		mDatas.clear();

		mDatas.addAll(_datas);
		
		removeAllViews();

		addLabelList(mDatas);
	}

	int groupWidth;
	int remainWidth;

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// 获取容器宽度
		groupWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
		if (groupWidth > 0 && isFirst) {
			isFirst = false;
			removeAllViews();
			addLabelList(mDatas);
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	/**
	 * 添加标签列表
	 */
	private void addLabelList(final List<T> datas) {
		// 一行剩下的空间
		remainWidth = groupWidth;
		if (groupWidth > 0) {
			Paint paint = new Paint();
			removeAllViews();
			LinearLayout layout = new LinearLayout(mContext);
			TextView labelText;
			LayoutParams params;
			layout.setOrientation(LinearLayout.HORIZONTAL);

			addView(layout);

			for (int i = 0, length = datas.size(); i < length; i++) {
				final T data = datas.get(i);
				// 创建标签
				labelText = createLabel(data, i);
				paint.setTextSize(labelText.getTextSize());
				final int itemPadding = labelText.getCompoundPaddingLeft()
						+ labelText.getCompoundPaddingRight();
				// 获取标签宽度
				final float itemWidth = paint.measureText(getLabelName(data))
						+ itemPadding;
				labelText.setText(getLabelName(data));

				if (remainWidth > itemWidth) {
					/**
					 * 一行剩余空间大于添加标签的宽度，说明可以继续往一行添加
					 */
					layout.addView(labelText);
				} else {
					/**
					 * 如果一行已经添加不了，就另起一行继续添加标签
					 */
					layout = new LinearLayout(mContext);
					layout.addView(labelText);
					addView(layout);
					params = (LayoutParams) layout.getLayoutParams();
					params.setMargins(0, itemTopMargins, 0, 0);
					remainWidth = groupWidth;
				}
				params = (LayoutParams) labelText.getLayoutParams();

				params.setMargins(itemMargins, 0, itemMargins, 0);
				remainWidth = (int) ((remainWidth - itemWidth + 0.5f) - itemMargins * 2);
			}
		}

	}

	/**
	 * 创建标签
	 * 
	 * @param data
	 * @param position
	 * @return
	 */
	private TextView createLabel(final T data, final int position) {
		TextView labelText = new GradientTextView(mContext)
				.setTextColor(getTextColor(data))
				.setBackgroundColor(getBackgroundColor(data))
				.setStrokeColor(getStrokeColor(data)).setStrokeRadius(radius)
				.setTextSize(textSize).build();
		labelText.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mIOnItemClickListener.onClick(getLabelName(data), position);
			}
		});
		return labelText;
	}

	/**
	 * 设置字体大小
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.textSize = size;
	}

	/**
	 * 设置标签圆角
	 * 
	 * @param radius
	 */
	public void setStrokeRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * 设置监听事件
	 * 
	 * @param listener
	 */
	public void setOnClickListener(IOnItemClickListener listener) {
		this.mIOnItemClickListener = listener;
	}

}

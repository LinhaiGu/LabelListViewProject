package com.example.labellistproject;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.labellistproject.entity.GameLabel;
import com.example.labellistproject.inface.IOnItemClickListener;
import com.example.labellistproject.view.LabelListView;
import com.example.labellistproject.view.base.BaseLabelListView;

public class MainActivity extends Activity {

	private LabelListView mLabelListView;
	private ArrayList<GameLabel> labelList = new ArrayList<GameLabel>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initDatas();
		initViews();
		initEvent();
	}

	private void initDatas() {
		GameLabel label = new GameLabel();
		label.name = "火影忍者";
		label.textColor = "663300";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "土豆";
		label.textColor = "009933";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "优酷";
		label.textColor = "0033FF";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "爱奇艺";
		label.textColor = "CC66FF";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "电影";
		label.textColor = "339966";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "综艺";
		label.textColor = "99CCFF";
		label.backgroudColor = "FFCCCC";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "娱乐";
		label.textColor = "FF3366";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "直播游戏";
		label.textColor = "FF3333";
		label.backgroudColor = "";
		label.strokeColor = "00FFFF";
		labelList.add(label);
		label = new GameLabel();
		label.name = "LOL英雄联盟";
		label.textColor = "FF9933";
		label.backgroudColor = "FFCCFF";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "顾林海";
		label.textColor = "9966FF";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "生化危机";
		label.textColor = "CC33FF";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "阿凡达";
		label.textColor = "99CCFF";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "酷狗";
		label.textColor = "0033CC";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "QQ音乐";
		label.textColor = "FFCCCC";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "android教程";
		label.textColor = "CC33FF";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "PHP教程";
		label.textColor = "CC33FF";
		label.backgroudColor = "FFCCCC";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "酷炫标签";
		label.textColor = "";
		label.backgroudColor = "339966";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "一只苹果";
		label.textColor = "FF3399";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);
		label = new GameLabel();
		label.name = "刘德华";
		label.textColor = "339966";
		label.backgroudColor = "";
		label.strokeColor = "";
		labelList.add(label);

	}

	private void initViews() {
		mLabelListView = (LabelListView) findViewById(R.id.label_list_view);
		mLabelListView.setSize(25);
		mLabelListView.setData(labelList);
	}

	private void initEvent() {
		mLabelListView.setOnClickListener(new IOnItemClickListener() {

			@Override
			public void onClick(String name, int position) {
				Toast.makeText(MainActivity.this,
						"标签内容：" + name + "   位置:" + position,
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}

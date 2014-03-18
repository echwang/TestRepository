package com.example.echwang.detail;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.echwang.R;
import com.example.echwang.main.DataListView;
import com.example.echwang.main.IconTextItem;
import com.example.echwang.main.IconTextListAdapter;
import com.example.echwang.main.OnDataSelectionListener;

public class DetailActivity extends Activity {

	private int mPosition;
	private ImageView mIcon;
	
	private TextView mText01;
	private TextView mText02;
	private TextView mText03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Intent intent = getIntent();
        mPosition = intent.getIntExtra("selectedIndex", 0);
        
        IconTextItem curItem = (IconTextItem) FamilyApplication.getInstance().getAdapter().getItem(mPosition);
        
		mIcon = (ImageView) findViewById(R.id.photoItem);
		mIcon.setImageDrawable(curItem.getIcon());
		
		mText01 = (TextView) findViewById(R.id.dataItem01_detail);
		mText01.setText(curItem.getData(0));
		
		mText02 = (TextView) findViewById(R.id.dataItem02_detail);
		mText02.setText(curItem.getData(1));
		
		mText03 = (TextView) findViewById(R.id.dataItem03_detail);
		mText03.setText(curItem.getData(2));

        
       
        
        setContentView(R.layout.detail);
        
//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
//        list = new DataListView(this);
//        
//        adapter = new IconTextListAdapter(this);
//        
//        Resources res = getResources();
//        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.echwang_03), "황소연", "2007년 05월 09일생", "엄마말 잘 듣자"));
//        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.echwang_01), "이경화", "1977년 11월 11일생", "꼴통"));
//        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.echwang_02), "황성연", "2005년 04월 13일생", "스스로 잘하자"));
//        
//        list.setAdapter(adapter);
//        
//        list.setOnDataSelectionListener(new OnDataSelectionListener(){
//        	public void onDataSelected(AdapterView parent, View v, int position, long id){
//        		IconTextItem curItem = (IconTextItem) adapter.getItem(position);
//        		String[] curData = curItem.getData();
//        		
//        		Toast.makeText(getApplicationContext(), "selected : " + curData[0], 2000).show();
//        	}
//        });
//        
//        setContentView(list, params);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
  
}

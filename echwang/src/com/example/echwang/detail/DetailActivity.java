package com.example.echwang.detail;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.echwang.R;
import com.example.echwang.main.IconTextItem;

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
        
      //  IconTextItem curItem = (IconTextItem) FamilyApplication.getInstance().getAdapter().getItem(mPosition);
        Resources res = getResources();
        IconTextItem curItem = new IconTextItem(res.getDrawable(R.drawable.echwang_01), "이경화", "1977년 11월 11일생", "꼴통");
        String data[] = new String[3];
        Drawable icon;
        switch(mPosition){
        case 0: icon = res.getDrawable(R.drawable.echwang_01); data[0] = "이경화"; data[1] = "1977년 11월 11일생"; data[2] = "꼴통";	break;
        case 1: icon = res.getDrawable(R.drawable.echwang_02); data[0] = "황성연"; data[1] = "2005년 04월 13일생"; data[2] = "스스로 잘하자";	break;
        case 2: icon = res.getDrawable(R.drawable.echwang_03); data[0] = "황소연"; data[1] = "2007년 05월 09일생"; data[2] = "엄마말 잘 듣자";	break;
        default: icon = res.getDrawable(R.drawable.echwang_01); data[0] = "이경화"; data[1] = "1977년 11월 11일생"; data[2] = "꼴통";	break;
        }
        
        curItem.setData(data);
        curItem.setIcon(icon);
         
        setContentView(R.layout.detail);
       
		mIcon = (ImageView) findViewById(R.id.photoItem);
		mIcon.setImageDrawable(curItem.getIcon());
		
		mText01 = (TextView) findViewById(R.id.dataItem01_detail);
		mText01.setText(curItem.getData(0));
		
		mText02 = (TextView) findViewById(R.id.dataItem02_detail);
		mText02.setText(curItem.getData(1));
		
		mText03 = (TextView) findViewById(R.id.dataItem03_detail);
		mText03.setText(curItem.getData(2));

        
       
        
        
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

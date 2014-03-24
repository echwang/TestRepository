package com.example.echwang.main;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.echwang.R;
import com.example.echwang.adddata.AddDataActivity;
import com.example.echwang.detail.DetailActivity;

public class MainActivity extends Activity {
	
	DataListView list;
	
	IconTextListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        list = new DataListView(this);
        
        adapter = new IconTextListAdapter(this);
        
        Resources res = getResources();
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.echwang_01), "�̰�ȭ", "1977�� 11�� 11�ϻ�", "����"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.echwang_02), "Ȳ����", "2005�� 04�� 13�ϻ�", "������ ������"));
        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.echwang_03), "Ȳ�ҿ�", "2007�� 05�� 09�ϻ�", "������ �� ����"));
        
        list.setAdapter(adapter);
        
        list.setOnDataSelectionListener(new OnDataSelectionListener(){
        	public void onDataSelected(AdapterView parent, View v, int position, long id){
        		IconTextItem curItem = (IconTextItem) adapter.getItem(position);
        		String[] curData = curItem.getData();
        		
        		Toast.makeText(getApplicationContext(), "selected : " + curData[0], 2000).show();
        		
        		Intent intent = new Intent(getBaseContext(), DetailActivity.class);        		   		
        		
        		intent.putExtra("selectedIndex", position);
        		
        		//((FamilyApplication)this.getApplication()).setmAdapter(adapter);
        		
        		startActivity(intent);
        		
        		// command add
        	}
        });
        
        setContentView(list, params);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        Log.i("echwang", "[MainActivity::onCreateOptionsMenu] 1");
        return true;
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) { 
		// TODO Auto-generated method stub
		Log.i("echwang", "[MainActivity::onOptionsItemSelected] 1");
		int curId = item.getItemId();
		Log.i("echwang", "[MainActivity::onOptionsItemSelected] 2 curId=" + curId);
		switch(curId){
		case R.id.action_settings: nextActivity(); return true;
		case R.id.action_add: nextActivity(); return true;
		case R.id.action_edit: nextActivity(); return true;
		default: return super.onOptionsItemSelected(item);
		}
		
	}
	
	private void nextActivity(){
		Log.i("echwang", "[MainActivity::nextActivity] 1");
		Intent intent = new Intent(getApplicationContext(), AddDataActivity.class);        		   		
		Log.i("echwang", "[MainActivity::nextActivity] 2");
		startActivity(intent);
		Log.i("echwang", "[MainActivity::nextActivity] 3");
		return;
	}
    
}

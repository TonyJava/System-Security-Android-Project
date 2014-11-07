package com.example.myfirstapp;


import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		
		ListView list_View = (ListView)findViewById(R.id.listView);
	//Intent intent2 = getIntent();
		
		/*Getting the list of installed apps*/
		ArrayList<String> result = new ArrayList<String>();
		
		
		PackageManager pm = getPackageManager();
		
		List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
		
		Intent intent = new Intent(Intent.ACTION_MAIN,null);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		
		List<ResolveInfo> lists = pm.queryIntentActivities(intent, PackageManager.PERMISSION_GRANTED);
		for (ResolveInfo rInfo: lists){
			result.add(rInfo.activityInfo.applicationInfo.loadLabel(pm).toString());
		}
		/*for ( ApplicationInfo rinfo: packages){
			Log.i("Harshul",""+rinfo.packageName.getClass().getName());
			result.add(rinfo.packageName.getClass().getName().toString());
		}*/
		
		
		String[] values = new String[]{"First element","Second Element","Third Element"};
		
		final ArrayList<String> list = new ArrayList<String>();
		//list = packages;
		for (int i =0;i<values.length;i++)
		{
			list.add(values[i]);
		}
		
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
		//list_View.setAdapter(adapter);
		list_View.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,android.R.id.text1,result));
		
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

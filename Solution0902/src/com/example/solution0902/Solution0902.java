package com.example.solution0902;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Solution0902 extends Activity {

private class myObject
{
	int myInt = 1;
	String myString = "One";
	
}
	
private myObject myobject = new myObject();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v("log","onCreate");
		setContentView(R.layout.screen001);
		
		/* TODO: use getLastNonConfigurationInstance to get the saved copy of the object
		 * If the object exists (was saved previously)
		 * Set myobject to the saved version
		 */
		final myObject previousObject = (myObject) getLastNonConfigurationInstance();
		if (previousObject != null) {
			myobject = previousObject;
		} 
		
		final Button myButton = (Button) findViewById(R.id.button);
		myButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				myobject = new myObject();
				myobject.myInt = 2;
				myobject.myString = "Two";
				Log.v("log","integer value = " + myobject.myInt);
				Log.v("log","string value = " + myobject.myString);
			}
		});
		
		Log.v("log","integer value = " + myobject.myInt);
		Log.v("log","string value = " + myobject.myString);
	}

	/* TODO: use onRetainNonConfigurationInstance to point to myobject
	 * Return the savedObject to save myobject
	 */
	@Override
	public Object onRetainNonConfigurationInstance() {
		final myObject savedObject = myobject;
		return savedObject;
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.v("log","onStart");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.v("log","onResume");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v("log","onDestoy");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.v("log","onStop");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.v("log","onPause");
	}



}

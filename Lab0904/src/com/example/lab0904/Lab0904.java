package com.example.lab0904;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Lab0904 extends Activity {

	private Integer myValue = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v("log","onCreate");
		setContentView(R.layout.screen001);
		
		// using depreciated call (latest API uses fragments)
		// pulling latest integer value
		final Integer previousValue = (Integer) getLastNonConfigurationInstance();
		if (previousValue != null) {
			myValue = previousValue;
		} 
		
		final Button myButton = (Button) findViewById(R.id.button);
		myButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				myValue = 2;
				Log.v("log","value=" + myValue);
			}
		});
		
		Log.v("log","value=" + myValue);
	}

	// set savedValue to the current value
	// return the savedValue as an object to the method
	@Override
	public Object onRetainNonConfigurationInstance() {
		final Integer savedValue = myValue;
		return savedValue;
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

package com.android.example.spinner.test;

import com.android.example.spinner.SpinnerActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class SpinnerActivityTest extends
		ActivityInstrumentationTestCase2<SpinnerActivity> {

	private SpinnerActivity mActivity;
	private Spinner mSpinner;
	private SpinnerAdapter mPlanetData;
	public static final int ADAPTER_COUNT = 9;
	public static final int INITIAL_POSITION = 0;
	public static final int TEST_POSITION = 5;
	private String mSelection;
	private int mPos;

	public SpinnerActivityTest() {
		super("com.android.example.spinner", SpinnerActivity.class);
	} // end of SpinnerActivityTest constructor definition

	// Set up is run EVERY time you run a test case
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// turn off touch mode so test can drive touch events
		setActivityInitialTouchMode(false);

		// get a reference to the activity under test
		mActivity = getActivity();

		// use the activity reference to pull in the spinner definition
		mSpinner = (Spinner) mActivity
				.findViewById(com.android.example.spinner.R.id.Spinner01);

		// get a reference to the spinner adapter
		mPlanetData = mSpinner.getAdapter();

	} // end of setUp() method definition

	// run ONCE per test suite
	// If this test case fails, then all other other test case status' are
	// suspect
	public void testPreConditions() {

		// make sure the listener is attached
		assertTrue(mSpinner.getOnItemSelectedListener() != null);

		// make sure the array of data is not empty
		assertTrue(mPlanetData != null);

		// make sure the number of elements in the array is correct
		assertEquals(mPlanetData.getCount(), ADAPTER_COUNT);
	} // end of testPreConditions() method definition

	// a test case to test the spinner value at a position
	public void testSpinnerUI() {

		// set spinner to first item in the list
		mActivity.runOnUiThread(new Runnable() {
			public void run() {
				mSpinner.requestFocus();
				mSpinner.setSelection(INITIAL_POSITION);
			} // end of run() method definition
		} // end of anonymous Runnable object instantiation
				); // end of invocation of runOnUiThread

		// set focus to the center key to activate the dpad control
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);

		// send a series of "down" key events to set spinner to "Saturn"
		for (int i = 1; i <= TEST_POSITION; i++) {
			this.sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
		} // end of for loop

		// return focus to the dpad center key
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);

		// get the new position of the spinner (should be five)
		mPos = mSpinner.getSelectedItemPosition();

		// get the string value of the selection (should be "Saturn"
		mSelection = (String) mSpinner.getItemAtPosition(mPos);

		// link to the textview in the activity under test
		TextView resultView = (TextView) mActivity
				.findViewById(com.android.example.spinner.R.id.SpinnerResult);

		// get the string value of the textview
		String resultText = (String) resultView.getText();

		// compare the string values returned from the text view and the spinner
		// they should be the same, so this implictly tests the logic that
		// updates
		// the text view
		assertEquals(resultText, mSelection);

	} // end of testSpinnerUI() method definition

}

package pg.eti.biomed.kalendarzinr;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

public class SettingsActivity extends Activity implements OnClickListener{
	
	private Button changeINRButton;
	private View layout;
	private PopupWindow pop;
	private final static String MY_PREF = "DanePacjenta";
	private final static String MIN_INR_RANGE = "min_INR";
	private final static String MAX_INR_RANGE = "max_INR";
	private final static String AGE = "age";
	private final static String WEIGHT = "weight";
	private TextView minINRRangeText;
	private TextView maxINRRangeText;
	private Button returnBtn;
	private EditText ageInput;
	private EditText weightInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		this.minINRRangeText = (TextView) findViewById(R.id.minINR);
		this.maxINRRangeText = (TextView) findViewById(R.id.maxINR);
		this.ageInput = (EditText) findViewById(R.id.age_input);
		this.weightInput = (EditText) findViewById(R.id.weight_input);
		this.returnBtn = (Button) findViewById(R.id.returnToMainActivity);
		this.changeINRButton = (Button)findViewById(R.id.changeINR);
		changeINRButton.setOnClickListener(this);
		returnBtn.setOnClickListener(this);
		updateRange();
		updateData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch(id){
		case R.id.changeINR:
			LayoutInflater inflater = (LayoutInflater) SettingsActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = inflater.inflate(R.layout.inr_popup,(ViewGroup)findViewById(R.id.popup_element)); 
			pop = new PopupWindow(layout, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
			pop.showAtLocation(layout, Gravity.CENTER, 0, 0);
			Button saveBtn = (Button) layout.findViewById(R.id.saveButton);
			saveBtn.setOnClickListener(this);
			break;
			
		case R.id.saveButton:
			double max = getMaxINR();
			double min = getMinINR();
			if(min>=0.0 && max>=0.0 && max>min){
				SharedPreferences sp = getSharedPreferences(MY_PREF, 0);
				SharedPreferences.Editor edit = sp.edit();
				edit.putString(MIN_INR_RANGE, String.valueOf(min));
				edit.putString(MAX_INR_RANGE, String.valueOf(max));
				edit.commit();
			}
			updateRange();
			pop.dismiss();
			break;
		case R.id.returnToMainActivity:
			double age = getAge();
			if(age==0) break;
			double weight = getWeight();
			if(weight==0) break;
			SharedPreferences sp = getSharedPreferences(MY_PREF, 0);
			SharedPreferences.Editor edit = sp.edit();
			edit.putString(AGE, String.valueOf(age));
			edit.putString(WEIGHT, String.valueOf(weight));
			edit.commit();
			Intent i = new Intent(this, MainActivity.class);
			startActivity(i);
			break;
		}
	}
	
	public void updateData(){
		SharedPreferences sp = getSharedPreferences(MY_PREF, 0);
		String age = sp.getString(AGE, "0");
		String weight = sp.getString(WEIGHT, "0");
		if(age.equals("0") || weight.equals("0")){
			return;
		}else{
			ageInput.setText(age);
			weightInput.setText(weight);
		}
	}
	
	private double getWeight(){
		try{
			double weight = Double.parseDouble(weightInput.getText().toString());
			return weight;
		}catch(NumberFormatException e){
			weightInput.setTextColor(Color.RED);
			weightInput.setText("Wprowadzono nieprawid³owe dane!");
		}
		return 0;
	}
	
	private double getAge(){
		try{
			double age = Double.parseDouble(ageInput.getText().toString());
			return age;
		}catch(NumberFormatException e){
			ageInput.setTextColor(Color.RED);
			ageInput.setText("Wprowadzono nieprawid³owe znaki!");
		}
		return 0;
		
	}
	
	private void updateRange(){
		SharedPreferences sp = getSharedPreferences(MY_PREF, 0);
		String min = sp.getString(MIN_INR_RANGE, "");
		String max = sp.getString(MAX_INR_RANGE, "");
		minINRRangeText.setText(min);
		maxINRRangeText.setText(max);
	}
	
	
	private double getMinINR(){
		EditText minINR = (EditText) layout.findViewById(R.id.minINR_input);
		String str = minINR.getText().toString();
		try{
			Double d = Double.valueOf(str);
			return d;
		}catch(NumberFormatException ne){
			minINR.setTextColor(Color.RED);
			minINR.setText("Wprowadzono nieprawid³ow¹ wartoœæ!");
			return -2.0;
		}
	}
	
	private double getMaxINR(){
		EditText maxINR = (EditText) layout.findViewById(R.id.maxINR_input);
		String str = maxINR.getText().toString();
		try{
			Double d = Double.valueOf(str);
			return d;
		}catch(NumberFormatException ne){
			maxINR.setTextColor(Color.RED);
			maxINR.setText("Wprowadzono nieprawid³ow¹ wartoœæ!");
			return -2.0;
		}
	}

}

package pg.eti.biomed.kalendarzinr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Choice extends Activity implements OnClickListener {
	private static final int REQUEST_CODE = 10;

	
	private Button but;
	private ToggleButton toggleButton1, toggleButton2;
	private SeekBar bar1,bar2;
	int suma,iter2,iter1=0;
	TextView value,text1,text2,text3,tabs3,tabs5,text4,text5;
	EditText entrie;
	
	 
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);
		addListenerOnButton();
		this.but = (Button) findViewById(R.id.button1);
		but.setOnClickListener(this);
		text1 = (TextView) findViewById(R.id.textView1);
		text2 = (TextView) findViewById(R.id.textView2);
		text3 = (TextView) findViewById(R.id.textView4);
		text4 = (TextView) findViewById(R.id.textView6);
		text5 = (TextView) findViewById(R.id.textView7);
		tabs3 = (TextView) findViewById(R.id.textab3);
		tabs5 = (TextView) findViewById(R.id.textab5);
		value = (TextView) findViewById(R.id.textView3);
		entrie = (EditText) findViewById(R.id.editText1);
		bar1 = (SeekBar)findViewById(R.id.seekBar1); // make seekbar object
		bar1.setProgress(0);
        bar1.incrementProgressBy(1);
        bar1.setMax(10);
        bar1.setOnSeekBarChangeListener( new OnSeekBarChangeListener()  
        {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
        	iter1=progress*3;
        	suma=iter1+iter2;
        	tabs3.setText(Integer.toString(progress));
            value.setText(Integer.toString(suma));
         }

        public void onStartTrackingTouch(SeekBar seekBar)
        {
         }

        public void onStopTrackingTouch(SeekBar seekBar)
        {
        } });
        
    	bar2 = (SeekBar)findViewById(R.id.seekBar2); // make seekbar object
		bar2.setProgress(0);
        bar2.incrementProgressBy(1);
        bar2.setMax(10);
        bar2.setOnSeekBarChangeListener( new OnSeekBarChangeListener()  
        {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
        	iter2=progress*5;
        	suma=iter1+iter2;
        	tabs5.setText(Integer.toString(progress));
            value.setText(Integer.toString(suma));
         }

        public void onStartTrackingTouch(SeekBar seekBar)
        {
         }

        public void onStopTrackingTouch(SeekBar seekBar)
        {
        } });
        bar1.setVisibility(View.GONE);
    	bar2.setVisibility(View.GONE);
    	value.setVisibility(View.GONE);
    	text1.setVisibility(View.GONE);
    	text2.setVisibility(View.GONE);
    	text3.setVisibility(View.GONE);
    	entrie.setVisibility(View.GONE);
    	text4.setVisibility(View.GONE);
    	text5.setVisibility(View.GONE);
    	tabs3.setVisibility(View.GONE);
    	tabs5.setVisibility(View.GONE);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choice, menu);
		return true;
	}
	
	public void addListenerOnButton() {
		 
		toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
		toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
		 toggleButton1.setOnClickListener(new OnClickListener() {
			 
	            @Override
	            public void onClick(View v) {
	                // TODO Auto-generated method stub
	                 if (toggleButton1.isChecked()) {
	               	 toggleButton2.setChecked(false);
	                	 bar1.setVisibility(View.VISIBLE);
	                    	bar2.setVisibility(View.VISIBLE);
	                    	value.setVisibility(View.VISIBLE);
	                    	text1.setVisibility(View.VISIBLE);
	                    	text2.setVisibility(View.VISIBLE);
	                    	text4.setVisibility(View.VISIBLE);
	                    	text5.setVisibility(View.VISIBLE);
	                    	tabs3.setVisibility(View.VISIBLE);
	                    	tabs5.setVisibility(View.VISIBLE);
	                    	//text3.setVisibility(View.GONE);
	                    //	entrie.setVisibility(View.GONE);
	                    	entrie.setVisibility(View.GONE);
	                    	text3.setVisibility(View.GONE);
	                	 
	                	 
	                    } else {
	 
	                    	bar1.setVisibility(View.GONE);
	                    	bar2.setVisibility(View.GONE);
	                    	value.setVisibility(View.GONE);
	                    	text1.setVisibility(View.GONE);
	                    	text2.setVisibility(View.GONE);
	                    	text4.setVisibility(View.GONE);
	                    	text5.setVisibility(View.GONE);
	                    	tabs3.setVisibility(View.GONE);
	                    	tabs5.setVisibility(View.GONE);
	                    }
	            }
	        });
		 toggleButton2.setOnClickListener(new OnClickListener() {
			 
	            @Override
	            public void onClick(View v) {
	                // TODO Auto-generated method stub
	                 if (toggleButton2.isChecked()) {
	 
	                	 toggleButton1.setChecked(false);
	                    	
	                    	//bar1.setVisibility(View.GONE);
	                    //	bar2.setVisibility(View.GONE);
	                    	//value.setVisibility(View.GONE);
	                    	//text1.setVisibility(View.GONE);
	                    	//text2.setVisibility(View.GONE);
	                    	text3.setVisibility(View.VISIBLE);
	                    	//text4.setVisibility(View.GONE);
	                    	//text5.setVisibility(View.GONE);
	                    	//tabs3.setVisibility(View.GONE);
	                    	//tabs5.setVisibility(View.GONE);
	                    	entrie.setVisibility(View.VISIBLE);
	                    	bar1.setVisibility(View.GONE);
	                    	bar2.setVisibility(View.GONE);
	                    	value.setVisibility(View.GONE);
	                    	text1.setVisibility(View.GONE);
	                    	text2.setVisibility(View.GONE);
	                    	text4.setVisibility(View.GONE);
	                    	text5.setVisibility(View.GONE);
	                    	tabs3.setVisibility(View.GONE);
	                    	tabs5.setVisibility(View.GONE);
	                	 
	                	 
	                    } else {
	 
	                    	
	                    	entrie.setVisibility(View.GONE);
	                    	text3.setVisibility(View.GONE);
	                    }
	            }
	        });
	}
	
		 @Override
			public void onClick(View v) {
			 Intent i = new Intent(this, GridCalendar.class);
			         i.putExtra("Value1", Integer.toString(suma));
			 	        i.putExtra("Value2", entrie.getText().toString());
			 	        // Set the request code to any code you like, you can identify the
			 	        // callback via this code
			 	        startActivityForResult(i, REQUEST_CODE);
			       }
			
				
			

}

	

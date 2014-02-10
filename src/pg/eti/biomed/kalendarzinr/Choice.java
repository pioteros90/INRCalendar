package pg.eti.biomed.kalendarzinr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Choice extends Activity implements OnClickListener {
	private static final int REQUEST_CODE = 10;

	/** Deklaracja kontrolek **/
	private Button but;
	private ToggleButton toggleButton1, toggleButton2;
	private SeekBar bar1,bar2;
	double suma,iter2,iter1=0;
	TextView value,text1,text2,text3,tabs3,tabs5,text4,text5;
	EditText entrie;
	private boolean isINRClicked=false;
	
	 
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/** Ustawienie aktywnoœci w trybie FullScreen **/
		
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER);
        
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice); //Wywo³anie layoutu z widokiem klasy Choice
		addListenerOnButton(); // Dodanie obs³ugi przyciœniêcia dla przycisku
		/** Przypisanie zadeklarowanym kontrolkom ich w³aœciwych reprezentatów  z widoku xml **/
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
		
		/** Deklaracja pierwszego SeekBaru, dla tabletek 3mg **/
		bar1 = (SeekBar)findViewById(R.id.seekBar1);
		
        bar1.incrementProgressBy(1);
        bar1.setMax(5);
        bar1.setProgress(0); 
        bar1.setOnSeekBarChangeListener( new OnSeekBarChangeListener() 
        
        {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
        	iter1=(double)(progress)*3*(0.5);
        	suma=iter1+iter2;
        	tabs3.setText(Double.toString((double)(progress)*0.5));
            value.setText(Double.toString(suma));
         }

        public void onStartTrackingTouch(SeekBar seekBar)
        {
         }

        public void onStopTrackingTouch(SeekBar seekBar)
        {
        } });
        
    	bar2 = (SeekBar)findViewById(R.id.seekBar2);
		
        bar2.incrementProgressBy(1);
        bar2.setMax(5);
        bar2.setProgress(0);
        bar2.setOnSeekBarChangeListener( new OnSeekBarChangeListener()  
        {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
        	iter2=(double)(progress)*5*(0.5);
        	suma=iter1+iter2;
        	tabs5.setText(Double.toString((double)(progress)*0.5));
            value.setText(Double.toString(suma));
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
		getMenuInflater().inflate(R.menu.choice, menu);
		return true;
	}
	
	public void addListenerOnButton() {
		 
		toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
		toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
		 toggleButton1.setOnClickListener(new OnClickListener() {
			 
	            @Override
	            public void onClick(View v) {
	            	isINRClicked=false;
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
	            	isINRClicked=true;
	                 if (toggleButton2.isChecked()) {
	 
	                	 toggleButton1.setChecked(false);
	                    	text3.setVisibility(View.VISIBLE);	                    
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
			 finish();
			}
		 
		 
		 @Override
		public void finish() {
			 Intent i = new Intent();
			 if(isINRClicked){
				 i.putExtra("type", 1);
				 i.putExtra("result", entrie.getText().toString());
			 }else{
				 i.putExtra("type", 0);
				 i.putExtra("result", String.valueOf(suma));
			 }
			 
	 	     setResult(RESULT_OK, i);
	 	     
			super.finish();
		}
			
				
			

}

	

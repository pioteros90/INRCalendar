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
	private Button but,but3Up,but3Down,but5Up,but5Down;
	private ToggleButton toggleButton1, toggleButton2;
	//private SeekBar bar1,bar2;
	double suma,iter2,iter1=0;
	TextView value,text1,text2,text3;
	EditText entrie, edit2,edit3;
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
		this.but3Up = (Button) findViewById(R.id.pill3Up);
		this.but3Down = (Button) findViewById(R.id.pill3Down);
		this.but5Up = (Button) findViewById(R.id.pill5Up);
		this.but5Down = (Button) findViewById(R.id.pill5Down);
		but.setOnClickListener(this);
		but3Up.setOnClickListener(this);
		but3Down.setOnClickListener(this);
		but5Up.setOnClickListener(this);
		but5Down.setOnClickListener(this);
		
		text1 = (TextView) findViewById(R.id.textView1);
		text2 = (TextView) findViewById(R.id.textView2);
		text3 = (TextView) findViewById(R.id.textView4);
	//	text4 = (TextView) findViewById(R.id.textView6);
	//	text5 = (TextView) findViewById(R.id.textView7);
	//	tabs3 = (TextView) findViewById(R.id.textab3);
	//	tabs5 = (TextView) findViewById(R.id.textab5);
		value = (TextView) findViewById(R.id.textView3);
		entrie = (EditText) findViewById(R.id.editText1);
		edit2 = (EditText) findViewById(R.id.editText2);
		edit3 = (EditText) findViewById(R.id.editText3);
		
		/** Deklaracja pierwszego SeekBaru, dla tabletek 3mg **/
	//	bar1 = (SeekBar)findViewById(R.id.seekBar1);
		
   //     bar1.incrementProgressBy(1);
    //    bar1.setMax(5);
    //    bar1.setProgress(0); 
      /*  bar1.setOnSeekBarChangeListener( new OnSeekBarChangeListener() 
        
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
        } });*/
        
    //	bar2 = (SeekBar)findViewById(R.id.seekBar2);
		
      //  bar2.incrementProgressBy(1);
     //   bar2.setMax(5);
     //   bar2.setProgress(0);
    /*    bar2.setOnSeekBarChangeListener( new OnSeekBarChangeListener()  
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
        } });*/
   //     bar1.setVisibility(View.GONE);
   // 	bar2.setVisibility(View.GONE);
    	value.setVisibility(View.GONE);
    	text1.setVisibility(View.GONE);
    	text2.setVisibility(View.GONE);
    	text3.setVisibility(View.GONE);
    	entrie.setVisibility(View.GONE);
    	edit2.setVisibility(View.GONE);
    	edit3.setVisibility(View.GONE);
   // 	text4.setVisibility(View.GONE);
  //  	text5.setVisibility(View.GONE);
  //  	tabs3.setVisibility(View.GONE);
  //  	tabs5.setVisibility(View.GONE);
    	
    	but3Down.setVisibility(View.GONE);
    	but3Up.setVisibility(View.GONE);
    	but5Down.setVisibility(View.GONE);
    	but5Up.setVisibility(View.GONE);
    	
        
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
	            //    	 bar1.setVisibility(View.VISIBLE);
	            //        	bar2.setVisibility(View.VISIBLE);
	                    	value.setVisibility(View.VISIBLE);
	                    	text1.setVisibility(View.VISIBLE);
	                    	text2.setVisibility(View.VISIBLE);
	         //           	text4.setVisibility(View.VISIBLE);
	        //            	text5.setVisibility(View.VISIBLE);
	        //            	tabs3.setVisibility(View.VISIBLE);
	        //            	tabs5.setVisibility(View.VISIBLE);
	                    	edit2.setVisibility(View.VISIBLE);
	                    	edit3.setVisibility(View.VISIBLE);
	                    	but3Down.setVisibility(View.VISIBLE);
	                    	but3Up.setVisibility(View.VISIBLE);
	                    	but5Down.setVisibility(View.VISIBLE);
	                    	but5Up.setVisibility(View.VISIBLE);
	                       	entrie.setVisibility(View.GONE);
	                    	text3.setVisibility(View.GONE);
	                	 
	                	 
	                    } else {
	 
	            //        	bar1.setVisibility(View.GONE);
	            //        	bar2.setVisibility(View.GONE);
	                    	value.setVisibility(View.GONE);
	                    	text1.setVisibility(View.GONE);
	                    	text2.setVisibility(View.GONE);
	        //            	text4.setVisibility(View.GONE);
	        //            	text5.setVisibility(View.GONE);
	        //            	tabs3.setVisibility(View.GONE);
	        //            	tabs5.setVisibility(View.GONE);
	                    	edit2.setVisibility(View.GONE);
	                    	edit3.setVisibility(View.GONE);
	                    	but3Down.setVisibility(View.GONE);
	                    	but3Up.setVisibility(View.GONE);
	                    	but5Down.setVisibility(View.GONE);
	                    	but5Up.setVisibility(View.GONE);
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
	           //         	bar1.setVisibility(View.GONE);
	           //         	bar2.setVisibility(View.GONE);
	                    	value.setVisibility(View.GONE);
	                    	text1.setVisibility(View.GONE);
	                    	text2.setVisibility(View.GONE);
	           //         	text4.setVisibility(View.GONE);
	          //          	text5.setVisibility(View.GONE);
	          //          	tabs3.setVisibility(View.GONE);
	          //          	tabs5.setVisibility(View.GONE);  
	                    	edit2.setVisibility(View.GONE);
	                    	edit3.setVisibility(View.GONE);
	                    	but3Down.setVisibility(View.GONE);
	                    	but3Up.setVisibility(View.GONE);
	                    	but5Down.setVisibility(View.GONE);
	                    	but5Up.setVisibility(View.GONE);
	                    } else {
	                    	entrie.setVisibility(View.GONE);
	                    	text3.setVisibility(View.GONE);
	                    }
	            }
	        });
	}
	
		 @Override
			public void onClick(View v) {
			 
			 int id = v.getId();
			 
			 String wart1z=edit2.getText().toString();
				String wart1bz=edit3.getText().toString();
				double ww1z = Double.parseDouble(wart1z);
				double ww1bz = Double.parseDouble(wart1bz);
				suma=ww1z*3+ww1bz*5;
							switch(id){
							
							case R.id.button1:

			 Intent i = new Intent();
			 if(isINRClicked && isINRDataCorrect()){
				 i.putExtra("type", 1);
				 i.putExtra("result", entrie.getText().toString());
				 setResult(RESULT_OK, i);
			 }
			 else if(!isINRClicked && suma>0){
				 i.putExtra("type", 0);
				 i.putExtra("result", String.valueOf(suma));
				 setResult(RESULT_OK, i);
			 }else{
				 setResult(RESULT_CANCELED, i);
			 }
			 finish();
			 break;
			 
							case R.id.pill3Up:
								String wart1=edit2.getText().toString();
								String wart1b=edit3.getText().toString();
								double ww1 = Double.parseDouble(wart1);
								double ww1b = Double.parseDouble(wart1b);
								ww1=ww1+0.5;
								suma=ww1*3+ww1b*5;
								value.setText(Double.toString(suma));
								edit2.setText(Double.toString(ww1));
								break;
							case R.id.pill3Down:
								String wart2=edit2.getText().toString();
								String wart2b=edit3.getText().toString();
								double ww2 = Double.parseDouble(wart2);
								double ww2b = Double.parseDouble(wart2b);
								if(ww2>0){
									ww2=ww2-0.5;
								}
								suma=ww2*3+ww2b*5;
								value.setText(Double.toString(suma));
								edit2.setText(Double.toString(ww2));
								break;
								
							case R.id.pill5Up:
								String wart3=edit3.getText().toString();
								String wart3a=edit2.getText().toString();
								double ww3 = Double.parseDouble(wart3);
								double ww3a = Double.parseDouble(wart3);
								ww3=ww3+0.5;
								suma=ww3*5+ww3a*3;
								value.setText(Double.toString(suma));
								edit3.setText(Double.toString(ww3));
								break;
								
							case R.id.pill5Down:
								String wart4=edit3.getText().toString();
								String wart4a=edit2.getText().toString();
								double ww4 = Double.parseDouble(wart4);
								double ww4a = Double.parseDouble(wart4);
								if(ww4>0){
									ww4=ww4-0.5;
								}
								suma=ww4*5+ww4a*3;
								value.setText(Double.toString(suma));
								edit3.setText(Double.toString(ww4));
								break;
								
								
			 
			}
			 
		 }
		 
		 
		 private boolean isINRDataCorrect(){
			 double d;
			 try{
		     String INRResult = entrie.getText().toString();
			 d = Double.parseDouble(INRResult);
			 if(!INRResult.equals("") && INRResult!=null){
				 return true;
			 }else{
				 return false;
			 }
			 }catch(NumberFormatException e){
				 return false;
			 }
		 }
		 
		 
		 
		 @Override
		public void finish() {
			super.finish();
		}
			
				
			

}

	

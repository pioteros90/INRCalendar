package pg.eti.biomed.kalendarzinr;


import android.os.Bundle;
import android.app.Activity;

import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;


public class MainActivity extends Activity implements OnClickListener{
	
	private ImageButton helpButton;
	private ImageButton calendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	  setTheme(android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
          getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.helpButton = (ImageButton) findViewById(R.id.helpButton);
        this.calendarButton = (ImageButton) findViewById(R.id.calendarButton);
        calendarButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);
      

      
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	public void onClick(View arg0) {
		int id = arg0.getId();
		Intent intention=null;
		if(id==R.id.helpButton){
			intention = new Intent(this, Guide.class);
		}if(id==R.id.calendarButton){
			intention = new Intent(this, GridCalendar.class);
		}		
		
		startActivity(intention);

		
	}
    
}

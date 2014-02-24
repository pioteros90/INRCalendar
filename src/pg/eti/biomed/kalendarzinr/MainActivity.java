package pg.eti.biomed.kalendarzinr;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import pg.eti.biomed.kalendarzinr.Sql.SQLiteAdapter;
import android.os.Bundle;
import android.app.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener{
	
	private ImageButton helpButton;
	private ImageButton calendarButton;
	private ImageButton settingsButton;
	private TextView alertsText;
	private final static int TIME_TO_EXPIRE = 14;
	private final static String MY_PREF = "DanePacjenta";
	private final static String MIN_INR_RANGE = "min_INR";
	private final static String MAX_INR_RANGE = "max_INR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	  setTheme(android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
          getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.helpButton = (ImageButton) findViewById(R.id.helpButton);
        this.calendarButton = (ImageButton) findViewById(R.id.calendarButton);
        this.settingsButton = (ImageButton) findViewById(R.id.settingsButton);
        this.alertsText = (TextView) findViewById(R.id.mainAlerts);
        calendarButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
        displayAlertsIfPresent();

      
    }
    
    @Override
    protected void onResume() {
    	displayAlertsIfPresent();
    	super.onResume();
    }
    
    private void displayAlertsIfPresent(){
    	SQLiteAdapter sql = new SQLiteAdapter(getApplicationContext()) ;
    	sql.open();
    	ArrayList<String> result = sql.getLastINRResult();
    	sql.close();
    	if(result.size()==0){
    		alertsText.setText("Brak zarejestrowanego badania INR.\nAby wprowadziæ wynik badania przejdŸ do zak³adki Kalendarz, a nastêpnie wybierz dzieñ badania i naciœnij przycisk '+'");
    		alertsText.setTextColor(Color.BLACK);
    		alertsText.setBackgroundResource(R.drawable.gradient);
    	}else{
    		Double inrResult = Double.parseDouble(result.get(1));
    		SharedPreferences sp = getSharedPreferences(MY_PREF, 0);
    		String min = sp.getString(MIN_INR_RANGE, "0");
    		String max = sp.getString(MAX_INR_RANGE, "0");
    		double dmin,dmax;
    		dmin = Double.parseDouble(min);
    		dmax = Double.parseDouble(max);
    		if(dmin<0.5) dmin=2.0;
    		if(dmax<0.5) dmax=3.5;
    		
    		if(inrResult<dmin|| inrResult>dmax){
	    		alertsText.setText("Ostatni wynik badania "+result.get(1)+" jest nieprawid³owy\nPilnie skontaktuj siê z lekarzem.");
	    		alertsText.setTextColor(Color.RED);
	    		alertsText.setBackgroundResource(R.drawable.gradient);
	    		return;
    		}
    		
    		
    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Calendar cal = Calendar.getInstance();
    		Date d = cal.getTime();
    		try {
				Date lastTestDate = dateFormat.parse(result.get(0));
				if(isTestExpired(d, lastTestDate)){
		    		alertsText.setText("Czas od ostatniego badania wynosi ponad "+TIME_TO_EXPIRE+" dni\nZg³oœ siê do najbli¿szej placówki w celu przeprowadzenia badania");
		    		alertsText.setTextColor(Color.RED);
		    		alertsText.setBackgroundResource(R.drawable.gradient);
				}else{
					alertsText.setText("");
					alertsText.setTextColor(Color.TRANSPARENT);
					alertsText.setBackgroundColor(Color.TRANSPARENT);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
    		
    	}
    	
    }
    
    private static boolean isTestExpired(Date actual, Date test){
    	long act = actual.getTime();
    	long t = test.getTime();
    	Log.d("act", String.valueOf(act));
    	Log.d("t", String.valueOf(t));
    	long diff = act-t;
    	if(diff<0) return false;
    	else{
    		long seconds = diff/1000;
    		long minutes = seconds/60;
    		long hours = minutes/60;
    		int days = (int) hours/24;
    		if(days>TIME_TO_EXPIRE) {
    			return true;
    		}else{
    			return false;
    		}
    	}
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
		
		switch(id){
		case R.id.helpButton:
			intention = new Intent(this, Guide.class);
			break;
		case R.id.calendarButton:
			intention = new Intent(this, GridCalendar.class);
			break;
		case R.id.settingsButton:
			intention = new Intent(this, SettingsActivity.class);
			break;
		}

		if(intention!=null)	startActivity(intention);
	}
    
}

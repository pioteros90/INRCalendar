package pg.eti.biomed.kalendarzinr;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.WindowManager;

public class Calendar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		  setTheme(android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
          getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar, menu);
		return true;
	}

}

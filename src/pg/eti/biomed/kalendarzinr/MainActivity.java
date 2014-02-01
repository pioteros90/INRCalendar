package pg.eti.biomed.kalendarzinr;


import android.os.Bundle;
import android.app.Activity;

import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class MainActivity extends Activity implements OnClickListener{
	
	private ImageButton helpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.helpButton = (ImageButton) findViewById(R.id.helpButton);
        helpButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	public void onClick(View arg0) {
		Intent intencja = new Intent(this, Guide.class);
		startActivity(intencja);
		
	}
    
}

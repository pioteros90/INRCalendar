package pg.eti.biomed.kalendarzinr;

import java.util.Calendar;
import java.util.Locale;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;



public class GridCalendar extends Activity  implements OnClickListener{
	
	private Calendar javaCalendar;
	private int monthCalendar;
	private int yearCalendar;
	private GridView gridCalendar;
	private GridCalendarAdapter adapter;
	private Button gotoPrevMonthBtn;
	private Button gotoNextMonthBtn;
	private TextView monthHeader;
	private Button addEventBtn;
	private TextView eventsMonitor;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {	  	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_calendar);
		
		this.javaCalendar = Calendar.getInstance(Locale.getDefault());
		this.monthCalendar = javaCalendar.get(Calendar.MONTH); //Miesiace od 0 do 11
		this.yearCalendar = javaCalendar.get(Calendar.YEAR);
		this.gotoPrevMonthBtn = (Button) findViewById(R.id.goto_prev_month);
		this.gotoNextMonthBtn = (Button) findViewById(R.id.goto_next_month);
		this.monthHeader = (TextView) findViewById(R.id.month_header);
		this.addEventBtn = (Button) findViewById(R.id.add_event);
		this.eventsMonitor = (TextView) findViewById(R.id.day_events);
		addEventBtn.setOnClickListener(this);
		gotoNextMonthBtn.setOnClickListener(this);
		gotoPrevMonthBtn.setOnClickListener(this);
		this.gridCalendar = (GridView) findViewById(R.id.calendarview);
		setAdapterForNewData();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.grid_calendar, menu);
		return true;
	}
	
	private void setAdapterForNewData(){
		this.adapter = new GridCalendarAdapter(this, monthCalendar, yearCalendar, eventsMonitor);
		adapter.notifyDataSetChanged();
		gridCalendar.setAdapter(adapter);
		monthHeader.setText(adapter.getMonthHeader());
	}
	
	private void gotoNextMonth(){
		this.monthCalendar++;
		if(monthCalendar==12){
			monthCalendar=0;
			this.yearCalendar++;
		}
	}
	
	private void gotoPrevMonth(){
		this.monthCalendar--;
		if(monthCalendar==-1){
			monthCalendar=11;
			this.yearCalendar--;
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if(requestCode==1){
			if(resultCode==RESULT_OK){
				Bundle extras = data.getExtras();
				if(extras==null){
					return;
				}else{
	                int type = extras.getInt("type");
	                String result = extras.getString("result");
	                adapter.addEventToCurrentlySelectedDay(type, result);
	                adapter.refreshDayEvent();
				}
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch(id){
			case R.id.goto_next_month:
				gotoNextMonth();
				setAdapterForNewData();
				break;
			case R.id.goto_prev_month:
				gotoPrevMonth();
				setAdapterForNewData();
				break;
			case R.id.add_event:
				Intent i = new Intent(this, Choice.class);
				startActivityForResult(i, 1);
				break;
		}
	}
}

package pg.eti.biomed.kalendarzinr;




import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import pg.eti.biomed.kalendarzinr.Sql.SQLiteAdapter;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;



public class GridCalendarAdapter extends BaseAdapter implements OnClickListener{
	
	private Context mContext;
	private int month;
	private int year;
	private static final int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final String[] namesOfMonths = {"Styczeñ", "Luty", "Marzec", "Kwiecieñ", "Maj", "Czerwiec", "Lipiec", "Sierpieñ", "Wrzesieñ", "PaŸdziernik", "Listopad", "Grudzieñ"};
	private int[] daysList;
	private int[] daysTypes;
	private View selectedDay;
	private Drawable selectedDayBg=null;
	private final DateFormat dtwrite = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final DateFormat dtread = new SimpleDateFormat("yyyy-MM-dd");
	private TextView outputDayEvents;
	private SQLiteAdapter sqlAdapter;
	private final static String NO_EVENTS_FOUNDED = "Brak zdarzeñ";

	
	
	public GridCalendarAdapter(Context c, int aMonth, int aYear, TextView tv){
		mContext=c;
		this.month = aMonth;
		this.year = aYear;
		this.outputDayEvents = tv;
		this.sqlAdapter = new SQLiteAdapter(c);
		prepareMonth();
		
	}
	
	public void gotoNextMonth(){
		if(month==11){
			month=0;
			year++;
		}else{
			month++;
		}
		prepareMonth();
	}
	
	public String getMonthHeader(){
		String str = namesOfMonths[month];
		str+=" "+year;
		return str;
	}
	/**
	 * Return date with format 2014-01-01
	 * @return
	 */
	private String getProperDateOfDay(int day){
		int mMonth = month + 1;
		String str="";
		str+=year;
		str+="-";
		if(mMonth<10){
			str+="0";
		}
		str+=mMonth;
		str+="-";
		if(day<10){
			str+="0";
		}
		str+=day;
		return str;
	}
	
	private boolean hasEvent(int day){
		String tdate = getProperDateOfDay(day);
		sqlAdapter.open();
		ArrayList<String> eventList = sqlAdapter.getDayEvents(tdate);
		sqlAdapter.close();
		if(eventList.size()==0){
			return false;
		}else{
			return true;
		}
	}
    
	private void prepareMonth(){
		
		
		daysList = new int[42];
		daysTypes = new int[42];		
		
        Calendar calendar = new GregorianCalendar();
        calendar.set(year, month, 0); // 0 = January
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek==0){
        	dayOfWeek=6;//przeniesienie niedzieli na ostatnie miejsce
        }else{
        	dayOfWeek-=1;
        }
		
	    
	    int prevMonthDayCount;
	    
    	if(month==0){
    		prevMonthDayCount=daysOfMonth[11];
    	}else{
    		prevMonthDayCount=daysOfMonth[month-1];
    	}
    	
	    
    	int dayNr=dayOfWeek;
    	if(dayNr==0) dayNr=1;
	    for(int i=0; i<daysList.length; i++){
	    	if(i<dayOfWeek){
		    	daysList[i] = prevMonthDayCount-dayNr+1;
		    	daysTypes[i] = 1;
		    	dayNr--;
		    	if(i==(dayOfWeek-1)){
		    		dayNr = 1;
		    	}
	    	}
	    	if(i>=dayOfWeek && i<(dayOfWeek+daysOfMonth[month])){
	    		daysList[i] = dayNr;
	    		if(hasEvent(dayNr)){
	    			daysTypes[i] = 2;
	    		}else{
	    			daysTypes[i] = 0;
	    		}
	    		dayNr++;
	    		if(dayNr==daysOfMonth[month]+1){
	    			dayNr=1;
	    		}
	    	}
	    	if(i>=(dayOfWeek+daysOfMonth[month])){
	    		daysList[i] = dayNr;
	    		daysTypes[i] = 1;
	    		dayNr++;
	    	}

	    } 
	}
    
	@Override
	public int getCount() {
		return 42;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}
	


	public View getView(int position, View convertView, ViewGroup parent) {    
		View row = convertView;
		if (row == null)
			{
				LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				row = inflater.inflate(R.layout.cal_grid_cell, parent, false);
			}

		// Get a reference to the Day gridcell
		Button gridcell = (Button) row.findViewById(R.id.calendar_day_gridcell);
		gridcell.setOnClickListener(this);
		gridcell.setText(""+daysList[position]);

        Calendar calendar = new GregorianCalendar();
        calendar.set(year, month, daysList[position], 12, 00);
        String dayFormated = dtread.format(calendar.getTime());
        gridcell.setTag(dayFormated);
        
		
		gridcell.setBackgroundResource(getIdOfCellType(daysTypes[position]));
		return row;
        
	}
	
	private int getIdOfCellType(int index){
		switch(index){
		case 0:
			return R.drawable.day_gray;
		case 1:
			return R.drawable.day_white;
		case 2:
			return R.drawable.day_event;
		default:
				return 0;
		}
	}
	
	private void highlightSelectedDay(View dayView){
		clearHighLight();
		selectedDayBg = dayView.getBackground();
		selectedDay = dayView;
		dayView.setBackgroundResource(R.drawable.day_selected);
	}
	
	private void monitorEvents(View dayView){
		sqlAdapter.open();
		ArrayList<String> eventsList = sqlAdapter.getDayEvents(String.valueOf(dayView.getTag()));
		sqlAdapter.close();
		String output="";
		if(eventsList.size()==0){
			this.outputDayEvents.setText(NO_EVENTS_FOUNDED);
		}else{
			ArrayList<String> records;
			for(String str:eventsList){
				records = new ArrayList<String>(Arrays.asList(str.split("/")));
				if(records.get(0).equals("0")){
					output += "Przyjêto dawkê leku w wielkoœci "+records.get(1)+" mg warfaryny\n\n";
				}else{
					output += "Wynik badania INR to "+records.get(1)+"\n\n";
				}
			}
			this.outputDayEvents.setText(output);
		}
		
		
	}
	
	@SuppressWarnings("deprecation")
	private void clearHighLight(){
		if(selectedDayBg==null){
			//NOthing to Clear
		}else{
			selectedDay.setBackgroundDrawable(selectedDayBg);
		}
	}

	@Override
	public void onClick(View arg0) {
		highlightSelectedDay(arg0);
		monitorEvents(arg0);
	}


	

}

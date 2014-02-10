package pg.eti.biomed.kalendarzinr.Sql;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;



public class SQLiteAdapter {    
    private static final int DB_VERSION = 11; //wersja bd - jesli nastapi zmiana struktury BD
    private static final String DB_FILE_NAME = "database.db"; //nazwa pliku /data/data/apka/databases/"".db
    private static final String DB_TABLE_NAME = "Event"; //nazwa tabeli
    
    private SQLiteDatabase db;
    private Context context;
    private DatabaseHelper dbHelper;
    
    public SQLiteAdapter(Context c){
    	this.context=c;
    }
    
    public SQLiteAdapter open(){
    	dbHelper = new DatabaseHelper(context, DB_FILE_NAME, null, DB_VERSION);
    	try{
    		db = dbHelper.getWritableDatabase();
    	}catch(SQLException e){
    		db = dbHelper.getReadableDatabase();
    	}
    	return this;
    }
    
    public void close(){
    	dbHelper.close();
    }
    
    public void addEvent(String date, int type, String result){
    	String query= "INSERT INTO "+DB_TABLE_NAME+"(date, type, result)"
    			+ " VALUES ('"+date+"',"+type+",'"+result+"');";
    	db.execSQL(query);
    }
    
    public ArrayList<String> getDayEvents(String date){
    	ArrayList<String> dayEvents = new ArrayList<String>();
    	String query = "SELECT type, result FROM "+DB_TABLE_NAME+" WHERE date BETWEEN ? AND ?";
    	Cursor c =db.rawQuery(query, new String[] {date+" 00:00:00", date+" 23:59:59"});
    	String typeOfEvent="";
    	String eventResult="";
    	String record="";
    	if (c.moveToFirst()){
    		   do{
    		      typeOfEvent = c.getString(0);
    		      eventResult = c.getString(1);
    		      record=typeOfEvent+"/"+eventResult;
    		      dayEvents.add(record);
    		   }while(c.moveToNext());
    		}
    		c.close();
   
    	return dayEvents;
    }
    
    public ArrayList<String> getLastINRResult(){
    	ArrayList<String> record = new ArrayList<String>();
    	String query = "SELECT date, result FROM "+DB_TABLE_NAME+" WHERE type = 1 ORDER BY date DESC;";
    	Cursor c =db.rawQuery(query, null);
    	if(c.moveToFirst()){
    		String date = c.getString(0);
    		String result = c.getString(1);
    		record.add(date);
    		record.add(result);
    	}
    	c.close();
    	return record;
    }
    
    //"2014-02-05"
    //month received range is 0-11
    public ArrayList<String> getMonthEvents(int month, int monthDaysCount, int year){
    	month++;
    	String smonth="";
    	if(month<10){
    		smonth+="0";
    	}
    	smonth+=month;
    	//Log.d("Query = ", "SELECT type, result FROM "+DB_TABLE_NAME+" WHERE date BETWEEN "+year+"-"+smonth+"-01 00:00:00 AND "+year+"-"+smonth+"-"+monthDaysCount+" 23:59:59");
    	
    	ArrayList<String> monthEvents = new ArrayList<String>();
    	String query = "SELECT type, result FROM "+DB_TABLE_NAME+" WHERE date BETWEEN ? AND ?";
    	Cursor c =db.rawQuery(query, new String[] {year+"-"+smonth+"-01 00:00:00", year+"-"+smonth+"-"+monthDaysCount+" 23:59:59"});
    	String typeOfEvent="";
    	String eventResult="";
    	String record="";
    	if (c.moveToFirst()){
    		   do{
    		      typeOfEvent = c.getString(0);
    		      eventResult = c.getString(1);
    		      record=typeOfEvent+"/"+eventResult;
    		      monthEvents.add(record);
    		   }while(c.moveToNext());
    		}
    		c.close();
    	
    	return monthEvents;
    }
    
    
}

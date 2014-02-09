package pg.eti.biomed.kalendarzinr.Sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{


    private static final String DB_TABLE_NAME = "Event"; //nazwa tabeli
    
    private static final String DATABASE_CREATION_QUERY = "CREATE TABLE IF NOT EXISTS "+DB_TABLE_NAME
    		+"(id INTEGER PRIMARY KEY NOT NULL ," 
    		+"date TEXT NON NULL,"
    		+"type INTEGER NOT NULL,"	
    		+"result TEXT NOT NULL);";
    private static final String DROP_DATABASE_QUERY = "DROP TABLE IF EXISTS "+ DB_TABLE_NAME+";";

	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATION_QUERY);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//W produkcji nalezy przepisywac dane zamiast je usuwac!
		db.execSQL(DROP_DATABASE_QUERY);
		onCreate(db);
	}
	
	
}

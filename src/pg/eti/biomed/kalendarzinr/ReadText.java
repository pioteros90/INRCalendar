package pg.eti.biomed.kalendarzinr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;

public class ReadText {
	
	public static String readTextFile(Context ctx, int resId)
    {
        InputStream inputStream = ctx.getResources().openRawResource(resId);

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader bufferedreader = new BufferedReader(inputreader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try 
        {
            while (( line = bufferedreader.readLine()) != null) 
            {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
        } 
        catch (IOException e) 
        {
            return null;
        }
        return stringBuilder.toString();
    }

}

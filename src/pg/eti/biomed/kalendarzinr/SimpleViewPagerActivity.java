package pg.eti.biomed.kalendarzinr;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleViewPagerActivity extends Activity {
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.main);

                MyPagerAdapter adapter = new MyPagerAdapter();
                ViewPager myPager = (ViewPager) findViewById(R.id.myfivepanelpager);
                myPager.setAdapter(adapter);
                myPager.setCurrentItem(0);    
                
        }
        
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
        
       

        private class MyPagerAdapter extends PagerAdapter {

                public int getCount() {
                        return 8;
                }

                public Object instantiateItem(View collection, int position) {

                        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                        int resId = 0;
                   
                        
                        
                        switch (position) {
                        case 0:
                        	resId = R.layout.ch1;
                                break;
                        case 1:
                        	resId = R.layout.ch2;
                                break;
                        case 2:
                        	resId = R.layout.ch3;

                                break;
                        case 3:
                        	resId = R.layout.ch4;  
                                break;
                        case 4:
                        	resId = R.layout.ch5;
                                break;
                        case 5:
                        	resId = R.layout.ch6;
                                break;
                        case 6:
                        	resId = R.layout.ch7;
                                break;
                        case 7:
                        	resId = R.layout.ch8;
                                break;
                        }

                        View view = inflater.inflate(resId, null);

                        ((ViewPager) collection).addView(view, 0);
                        
                       
                       
                        
                         
                        
                        
                        
                        
                        
                        
                        
                      
                        
                        
                        
                        if (position == 0){  
	                    	//  TextView textView1 = (TextView)findViewById(R.id.textChapter1);
	                  //  	   String data1 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter1);
	                   //   textView1.setText(data1);
                        	
                            
                        	String myTable1 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter1);
	                    	  WebView myWebView1 = (WebView)findViewById(R.id.webView1a);
	                    	  myWebView1.getSettings().setJavaScriptEnabled(true);   
	                        //  myWebView1.getSettings().setSupportZoom(true);       //Zoom Control on web (You don't need this 
	                                                                 //if ROM supports Multi-Touch      
	                          myWebView1.getSettings().setBuiltInZoomControls(true); //Enabl
	                    	  myWebView1.loadDataWithBaseURL(null, myTable1, "text/html", "utf-8", null);
	                      }
                        
                        
                        
                          
	                      
	                      if (position == 1){  
	                 //   	  TextView textView2 = (TextView)findViewById(R.id.textChapter2);
	                //    	   String data2 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter2);
	                //    textView2.setText(data2);
	                    	  	
	                    	  String myTable2 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter2);
	                    	  WebView myWebView2 = (WebView)findViewById(R.id.webView2);
	                    	  myWebView2.getSettings().setJavaScriptEnabled(true);   
	                    	  myWebView2.getSettings().setBuiltInZoomControls(true);
	                    	  myWebView2.loadDataWithBaseURL(null, myTable2, "text/html", "utf-8", null);
	                    	  
	                      }
	                   
	                      if (position == 2){  
	                 //   	  TextView textView3 = (TextView)findViewById(R.id.textChapter3);
	                //          String data3 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter3);
	                //          textView3.setText(data3);
	                    	  
	                    	  String myTable3 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter3);
	                    	  WebView myWebView3 = (WebView)findViewById(R.id.webView3);
	                    	  myWebView3.getSettings().setJavaScriptEnabled(true);   
	                    	  myWebView3.getSettings().setBuiltInZoomControls(true);
	                    	  myWebView3.loadDataWithBaseURL(null, myTable3, "text/html", "utf-8", null);
	                          }
	                  
	                      
	                      if (position == 3){  
	                    	//  TextView textView4 = (TextView)findViewById(R.id.textChapter4);
	                     //     String data4 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter4);
	                     //     textView4.setText(data4);
	                    	
	                    	  String myTable4 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter4);
	                    	  WebView myWebView4 = (WebView)findViewById(R.id.webView4a);
	                    	  myWebView4.getSettings().setJavaScriptEnabled(true);   
	                    	  myWebView4.getSettings().setBuiltInZoomControls(true);
	                    	  myWebView4.loadDataWithBaseURL(null, myTable4, "text/html", "utf-8", null);
	                          }
	                      if (position == 4){  
	                    	//  TextView textView5 = (TextView)findViewById(R.id.textChapter5);
	                       //   String data5 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter5);
	                      //    textView5.setText(data5);
	                    
	                    	  String myTable5 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter5);
	                    	  WebView myWebView5 = (WebView)findViewById(R.id.webView5);
	                    	  myWebView5.getSettings().setJavaScriptEnabled(true);   
	                    	  myWebView5.getSettings().setBuiltInZoomControls(true);
	                    	  myWebView5.loadDataWithBaseURL(null, myTable5, "text/html", "utf-8", null);
	                          }
	                      if (position == 5){  
	                    	//  TextView textView6 = (TextView)findViewById(R.id.textChapter6);
	                       //   String data6 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter6); 
	                       //   textView6.setText(data6);
	                    	
	                    	  String myTable6 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter6);
	                    	  WebView myWebView6 = (WebView)findViewById(R.id.webView6);
	                    	  myWebView6.getSettings().setJavaScriptEnabled(true);   
	                    	  myWebView6.getSettings().setBuiltInZoomControls(true);
	                    	  myWebView6.loadDataWithBaseURL(null, myTable6, "text/html", "utf-8", null);
	                          }
	                      if (position == 6){  
	                    	//  TextView textView7 = (TextView)findViewById(R.id.textChapter7);
	                       //   String data7 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter7);
	                       //   textView7.setText(data7);
	                    	 
	                    	  String myTable7 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter7);
	                    	  WebView myWebView7 = (WebView)findViewById(R.id.webView7);
	                    	  myWebView7.getSettings().setJavaScriptEnabled(true);   
	                    	  myWebView7.getSettings().setBuiltInZoomControls(true);
	                    	  myWebView7.loadDataWithBaseURL(null, myTable7, "text/html", "utf-8", null);
	                          }
	                     if (position == 7){  
	                    	//  TextView textView8 = (TextView)findViewById(R.id.textChapter8);
	                       //   String data8 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter8);
	                      //    textView8.setText(data8);
	                    
	                    	 String myTable8 = ReadText.readTextFile(SimpleViewPagerActivity.this, R.raw.chapter8);
	                    	  WebView myWebView8 = (WebView)findViewById(R.id.webView8);
	                    	  myWebView8.getSettings().setJavaScriptEnabled(true);   
	                    	  myWebView8.getSettings().setBuiltInZoomControls(true);
	                    	  myWebView8.loadDataWithBaseURL(null, myTable8, "text/html", "utf-8", null);
	                          }
	                        return view;
                       
                }

                @Override
                public void destroyItem(View arg0, int arg1, Object arg2) {
                        ((ViewPager) arg0).removeView((View) arg2);

                }

                @Override
                public void finishUpdate(View arg0) {
                        // TODO Auto-generated method stub

                }

                @Override
                public boolean isViewFromObject(View arg0, Object arg1) {
                        return arg0 == ((View) arg1);

                }

                @Override
                public void restoreState(Parcelable arg0, ClassLoader arg1) {
                        // TODO Auto-generated method stub

                }

                @Override
                public Parcelable saveState() {
                        // TODO Auto-generated method stub
                        return null;
                }

                @Override
                public void startUpdate(View arg0) {
                        // TODO Auto-generated method stub

                }

        }

}

package com.panchonet.hubcvplay;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AutoCompleteTextView;
import android.view.View.OnClickListener;
import android.net.Uri;


public class Main_CvPlay_Activity extends ActionBarActivity {

    static private final String TAG = "Main_CvPlay_Activity";
    //moviecity://[nombre_MSO].moviecity.com?content_id=XX&token=YY&referer=parent://XXXXX
    static private final String DEEPLINK_URI = "moviecity://cablevision.moviecity.com?content_id=";
    private String assetid = "159752";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cv_play);
    
        //AutoCompleteTextView mAssetId = (AutoCompleteTextView) findViewById(R.id.assetId);
        
        Button mDeepLink = (Button) findViewById(R.id.deeplink);
        
        
        mDeepLink.setOnClickListener(new OnClickListener() {
            
			// Call startImplicitActivation() when pressed
			@Override
			public void onClick(View v) {
                
				startDeepLinkActivation();
                
			}
		});
	
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main__cv_play_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    private void startDeepLinkActivation(){
    	
    	String uri = DEEPLINK_URI + assetid;
    	Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(uri));
    	startActivity(intent);
    	
    	
    }
    
}

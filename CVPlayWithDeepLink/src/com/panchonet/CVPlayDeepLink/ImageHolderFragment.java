package com.panchonet.CVPlayDeepLink;

//import course.examples.UI.ViewPager.R;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

// Each instance holds one image to be displayed in the ViewPager
public class ImageHolderFragment extends Fragment {

	//moviecity://[nombre_MSO].moviecity.com?content_id=XX&token=YY&referer=parent://XXXXX
    static private final String DEEPLINK_URI = "moviecity://cablevision.moviecity.com?content_id=";
    
    // AssetIds from Movicity Page
    private Integer[] mAssestIds = {159312,159752,160159,161371,172066,176876,159554};
    
	public static final String RES_ID = "res_id";
	public static final String POS = "position";

	private String mPos;
	private int mID;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final Bundle args = getArguments();
		mPos = args.getString(POS);
		mID = args.getInt(RES_ID);

		ImageView imageView = (ImageView) inflater.inflate(R.layout.page, container, false);
		
		// Set the Image for the ImageView
		imageView.setImageResource(mID);

		// Set an setOnItemClickListener on the Gallery
		imageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Display a Toast message indicate the selected item
				Toast.makeText(getActivity(), mPos, Toast.LENGTH_SHORT).show();
				Integer index = Integer.parseInt(mPos);
				String uri = DEEPLINK_URI + mAssestIds[index];
		    	Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(uri));
		    	startActivity(intent);
				
			}
		});

		return imageView;
	}
}
package com.jakeesveld.android_fragments_basics;


import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.mbms.DownloadRequest;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppItemFragment extends Fragment {

    TextView textAppName, textAppVersion, textAppDomain, textAppContact;
    ImageView imageApp;


    public AppItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        final AppListing listing = (AppListing) getArguments().getSerializable(MainActivity.APP_KEY);
        imageApp = view.findViewById(R.id.image_app);
        textAppName = view.findViewById(R.id.text_app_name);
        textAppContact = view.findViewById(R.id.text_app_contact);
        textAppDomain = view.findViewById(R.id.text_app_domain);
        textAppVersion = view.findViewById(R.id.text_app_version);

        new Thread(new Runnable() {
            @Override
            public void run() {
                DownloadImageRequest downloadImageRequest = new DownloadImageRequest();
                downloadImageRequest.execute(listing.getImageURL());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textAppContact.setText("Contact: " + listing.getContactEmail());
                        textAppDomain.setText("Website: " + listing.getDomainName());
                        textAppName.setText(listing.getAppName());
                        textAppVersion.setText("v ." + listing.getAppVersion());
                    }
                });

            }
        }).start();
    }


    private class DownloadImageRequest extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap imageBitmap = NetworkAdapter.imageFromUrlRequest(strings[0]);
            return imageBitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageApp.setImageBitmap(bitmap);
        }
    }
}

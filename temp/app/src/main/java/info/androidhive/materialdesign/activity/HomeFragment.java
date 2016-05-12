package info.androidhive.materialdesign.activity;

/**
 * Created by Ravi on 29/07/15.
 */
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import info.androidhive.materialdesign.R;


public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    ImageButton b1,b2,b3;
    TextToSpeech t1;
    Button b4;
    MediaPlayer media;
    private final int SPEECH_RECOGNITION_CODE = 1234;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        String folder_main = "Awaaz";

        //Toast.makeText(getActivity(),"ekhane ashchi", Toast.LENGTH_SHORT).show();

        File f = new File(Environment.getExternalStorageDirectory(), folder_main);
        if (!f.exists()) {
            f.mkdirs();
        }
        t1=new TextToSpeech(getActivity(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    //t1.getDefaultEngine();
                    t1.setLanguage(Locale.US);
                }
            }
        });

        b4 = (Button) rootView.findViewById(R.id.buttonhear);

        /*b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                        "Speak something...");
                //t1.speak("Speak something Selected", TextToSpeech.QUEUE_FLUSH, null);
                try {
                    startActivityForResult(intent, SPEECH_RECOGNITION_CODE);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getActivity(),
                            "Sorry! Speech recognition is not supported in this device.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        final Vibrator vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE) ;
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(100);
            }
        });



        b1 = (ImageButton) rootView.findViewById(R.id.imageButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                String title;
                fragment = new SpeakFragment();
                title ="English Text To Speech!!";
                //t1.speak("English Text To Speech Selected", TextToSpeech.QUEUE_FLUSH, null);
                if (fragment != null) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    /*Bundle args = new Bundle();
                    args.putString("Selected",title);
                    fragment.setArguments(args);*/
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.commit();

                }
            }
        });


        b2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                String title;
                fragment = new ExplorerFragment();
                title ="Explorer";
                //t1.speak("Explorer Selected", TextToSpeech.QUEUE_FLUSH, null);
                if (fragment != null) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    /*Bundle args = new Bundle();
                    args.putString("Selected",title);
                    fragment.setArguments(args);*/
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.commit();

                }
            }
        });


        b3 = (ImageButton) rootView.findViewById(R.id.imageButton4);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                String title;
                fragment = new CheckFragment();
                title ="বাংলা টেক্সট টু স্পিচচ";
                //t1.speak("Bengali Text To Speech Selected", TextToSpeech.QUEUE_FLUSH, null);
                if (fragment != null) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    /*Bundle args = new Bundle();
                    args.putString("Selected",title);
                    fragment.setArguments(args);*/
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.commit();

                }
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*Fragment fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id);
        fragment.onActivityResult(requestCode, resultCode, data);*/
        switch (requestCode) {
            case SPEECH_RECOGNITION_CODE: {
                if (null != data) {
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String text = result.get(0);
                    /*txtOutput.setText(text);*/

                    Toast.makeText(getActivity(),text ,
                            Toast.LENGTH_SHORT).show();


                    if(text.contains("speak"))
                    {
                        Fragment fragment = null;
                        String title;
                        fragment = new SpeakFragment();
                        title ="Speak Something!!";

                        if (fragment != null) {
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    /*Bundle args = new Bundle();
                    args.putString("Selected",title);
                    fragment.setArguments(args);*/
                            fragmentTransaction.replace(R.id.container_body, fragment);
                            fragmentTransaction.commit();

                        }
                    }
                    else if(text.contains("check"))
                    {
                        Fragment fragment = null;
                        String title;
                        fragment = new CheckFragment();
                        title ="Check Pronunciation";

                        if (fragment != null) {
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    /*Bundle args = new Bundle();
                    args.putString("Selected",title);
                    fragment.setArguments(args);*/
                            fragmentTransaction.replace(R.id.container_body, fragment);
                            fragmentTransaction.commit();

                        }
                    }
                    else if(text.contains("explorer"))
                    {
                        Fragment fragment = null;
                        String title;
                        fragment = new ExplorerFragment();
                        title ="Explorer";

                        if (fragment != null) {
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    /*Bundle args = new Bundle();
                    args.putString("Selected",title);
                    fragment.setArguments(args);*/
                            fragmentTransaction.replace(R.id.container_body, fragment);
                            fragmentTransaction.commit();

                        }
                    }

                }
                break;
            }
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

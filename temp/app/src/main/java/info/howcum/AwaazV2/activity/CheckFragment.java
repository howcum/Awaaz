package info.howcum.AwaazV2.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.Locale;

import info.howcum.AwaazV2.R;

/**
 * Created by Ravi on 29/07/15.
 */
public class CheckFragment extends Fragment {

    public CheckFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    TextToSpeech t1;
    EditText ed1;
    MediaPlayer media;
    Hashkorerakha hmap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_check, container, false);

        t1=new TextToSpeech(getActivity(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    //t1.getDefaultEngine();
                    t1.setLanguage(Locale.US);

                }
            }
            });
        Button button = (Button) rootView.findViewById(R.id.taxi_button);
        ed1=(EditText)rootView.findViewById(R.id.edittext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    //updateDetail("fake");
                    Toast.makeText(getActivity(), "Speaking!", Toast.LENGTH_SHORT).show();


                    //start
                //String bangla= "আমি ভাত খাই";
                String bangla = ed1.getText().toString();
                String[] arr = bangla.split(" ");

                hmap= new Hashkorerakha();


                for ( String ss : arr) {

                    String str;
                    /*try
                    {
                        str = hmap.get(ss);
                    }
                    catch (NullPointerException e)
                    {
                        e.printStackTrace(str);
                        continue;
                    }*/
                    if(hmap.get(ss)!=null)
                    {
                        str=hmap.get(ss);
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Sorry word not found", Toast.LENGTH_LONG).show();
                        //t1.speak("Bengali Text To Speech Selected", TextToSpeech.QUEUE_FLUSH, null);
                        continue;
                    }
                    Log.w("tag", str);


                    Field[] fields = R.raw.class.getFields();
                    int flg=0;
                    for(int count=0;count<fields.length;count++)
                    {
                        String filename= fields[count].getName();
                        if(filename.matches(str))
                        {
                            int rid= 0;
                            try {
                                rid = fields[count].getInt(fields[count]);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            media= MediaPlayer.create(getActivity(), rid);
                            flg=1;
                            media.start();
                            while(media.isPlaying())
                            {

                            }
                            media.stop();
                        }

                        if(flg==1)
                            break;
                    }
                    if(flg==0)
                    {
                        Toast.makeText(getActivity(),"word not found",Toast.LENGTH_SHORT).show();
                    }

                }
                    //ends

//                    String tospeak = ed1.getText().toString();
//                    t1.speak(tospeak, TextToSpeech.QUEUE_FLUSH, null);
                }

            });

        /*Button b2= (Button) rootView.findViewById(R.id.taxi_button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "saving!", Toast.LENGTH_SHORT).show();



                //Toast.makeText(getActivity(), "saved successfully!", Toast.LENGTH_SHORT).show();

                try {
                    String etName = ed1.getText().toString();
                    if (!etName.trim().equals("")) {
                        File path= Environment.getExternalStorageDirectory();
                        // File file = new File("data/data/info.androidhive.materialdesign/test1.txt");
                        File file = new File(path + "/" + "Awaaz",ed1.getText().toString()+".doc");
                        //if file doesnt exists, then create it
                        if (!file.exists()) {
                            Toast.makeText(getActivity(), "new file!", Toast.LENGTH_SHORT).show();
                            file.createNewFile();
                            Toast.makeText(getActivity(), file.getPath().toString(), Toast.LENGTH_SHORT).show();

                        }

                        *//*FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                        bufferWritter.write(etName);
                        bufferWritter.close();*//*
                        FileOutputStream stream = new FileOutputStream(file);
                        try {
                            OutputStreamWriter fileout = new OutputStreamWriter(stream);
                            fileout.write(ed1.getText().toString());
                            fileout.close();
                            //stream.write(ed1.getText().toString().getBytes());
                        } finally {
                            //stream.close();
                        }
                        Toast.makeText(getActivity(), file.getPath().toString(), Toast.LENGTH_SHORT).show();

                        Toast.makeText(getActivity(), "saved successfully!", Toast.LENGTH_SHORT).show();


                    }
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }


        });*/
        // Inflate the layout for this fragment
        return rootView;
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

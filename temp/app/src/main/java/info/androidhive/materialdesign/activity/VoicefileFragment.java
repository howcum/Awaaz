package info.androidhive.materialdesign.activity;

/**
 * Created by Ravi on 29/07/15.
 */
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import info.androidhive.materialdesign.R;


public class VoicefileFragment extends Fragment {

    public VoicefileFragment() {
        // Required empty public constructor



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    TextToSpeech t1;
    Button b1,b2;
    TextView tt;
    String str;
    File[] filelist;
    MediaPlayer mMediaPlayer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_voicefile, container, false);

         str = getArguments().getString("Selected");
        tt= (TextView) rootView.findViewById(R.id.textViewSelect);
        tt.setText(str);

        t1=new TextToSpeech(getActivity(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    //t1.getDefaultEngine();
                    t1.setLanguage(Locale.US);
                }
            }
        });

        b1 = (Button) rootView.findViewById(R.id.button51);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String ret="";

                /*File another;
                Log.d("Files", "Path : " + path);
                filelist = file.listFiles();
                for(int i=0;i<filelist.length;i++)
                {
                    if(filelist[i].getName()==str)
                    {
                        another = new File(path,str);
                    }
                }*/
                try {
                    /*File path= Environment.get+ "/Awaaz";
                    // File file = new File("data/data/info.androidhive.materialdesign/test1.txt");
                    File file = new File(path ,str);*/


                    File path= Environment.getExternalStorageDirectory();
                    File file = new File(path,"/Awaaz/" + str);
                    //Toast.makeText(getActivity(), file.getName(), Toast.LENGTH_SHORT).show();

                    //InputStream inputStream = getActivity().openFileInput("data/data/info.androidhive.materialdesign/test.txt");
                    //InputStream inputStream = getActivity().openFileInput(file);


                        /*InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String receiveString = "";
                        StringBuilder stringBuilder = new StringBuilder();

                        while ( (receiveString = bufferedReader.readLine()) != null ) {
                            //stringBuilder.append("\n");
                            stringBuilder.append(receiveString);
                        }

                        inputStream.close();
                        ret = stringBuilder.toString();*/
                        //tt.setText(ret);
                        /*int length = (int) file.length();

                        byte[] bb = new byte[length];
                        int i = 0;
                        //FileInputStream in = new FileInputStream(file);
                        try {
                            i = inputStream.read(bb);
                        } finally {
                            inputStream.close();
                        }*/
                    FileInputStream inputStream = new FileInputStream(file);
                    InputStreamReader InputRead = new InputStreamReader(inputStream);
                        char[] inputBuffer= new char[100];
                        String s="";
                        int charRead;

                        while ((charRead=InputRead.read(inputBuffer))>0) {
                            // char to string conversion
                            //Toast.makeText(getActivity(), "dhukchi", Toast.LENGTH_SHORT).show();

                            String readstring=String.copyValueOf(inputBuffer,0,charRead);
                            s +=readstring;
                        }
                        InputRead.close();
                        //Toast.makeText(getBaseContext(), s,Toast.LENGTH_SHORT).show();
                        String ret = s;
                        //ret = new String(bb);
                        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                        t1.speak(ret, TextToSpeech.QUEUE_FLUSH, null);

                }
                catch (FileNotFoundException e) {
                    Log.e("login activity", "File not found: " + e.toString());
                    Toast.makeText(getActivity(), "not found", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    Toast.makeText(getActivity(), "can not read!", Toast.LENGTH_SHORT).show();

                    Log.e("login activity", "Can not read file: " + e.toString());
                }
            }
        });

        /*b2 = (Button) rootView.findViewById(R.id.button52);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    *//*File path= Environment.get+ "/Awaaz";
                    // File file = new File("data/data/info.androidhive.materialdesign/test1.txt");
                    File file = new File(path ,str);*//*


                    File path= Environment.getExternalStorageDirectory();
                    File file = new File(path,"/Awaaz/" + str);
                    File file1 = new File(path,"/Awaaz/"+"output.wav");
                    //File file = new File(path + "/" + "Awaaz","nowspeaking.txt");
                    //if file doesnt exists, then create it
                    if (!file1.exists()) {
                        Toast.makeText(getActivity(), "new file!", Toast.LENGTH_SHORT).show();
                        file1.createNewFile();
                        //Toast.makeText(getActivity(), file.getPath().toString(), Toast.LENGTH_SHORT).show();

                    }
                    Toast.makeText(getActivity(), file1.getName(), Toast.LENGTH_SHORT).show();

                    //InputStream inputStream = getActivity().openFileInput("data/data/info.androidhive.materialdesign/test.txt");
                    //InputStream inputStream = getActivity().openFileInput(file);


                        *//*InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String receiveString = "";
                        StringBuilder stringBuilder = new StringBuilder();

                        while ( (receiveString = bufferedReader.readLine()) != null ) {
                            //stringBuilder.append("\n");
                            stringBuilder.append(receiveString);
                        }

                        inputStream.close();
                        ret = stringBuilder.toString();*//*
                    //tt.setText(ret);
                        *//*int length = (int) file.length();

                        byte[] bb = new byte[length];
                        int i = 0;
                        //FileInputStream in = new FileInputStream(file);
                        try {
                            i = inputStream.read(bb);
                        } finally {
                            inputStream.close();
                        }*//*
                    FileInputStream inputStream = new FileInputStream(file);
                    InputStreamReader InputRead = new InputStreamReader(inputStream);
                    char[] inputBuffer= new char[100];
                    String s="";
                    int charRead;

                    while ((charRead=InputRead.read(inputBuffer))>0) {
                        // char to string conversion
                        //Toast.makeText(getActivity(), "dhukchi", Toast.LENGTH_SHORT).show();

                        String readstring=String.copyValueOf(inputBuffer,0,charRead);
                        s +=readstring;
                    }
                    InputRead.close();
                    //Toast.makeText(getBaseContext(), s,Toast.LENGTH_SHORT).show();
                    String ret = s;
                    //ret = new String(bb);

                    HashMap<String, String> myHashRender = new HashMap<String, String>();
                    myHashRender.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, ret);
                    //String fileName = "/Android/data/com.android.voicelanglearning.vll/ttsfile1.wav";
                    String fileName = path.getName() + "/Awaaz/output.wav";
                    final int i = t1.synthesizeToFile(ret, myHashRender, fileName);

                    mMediaPlayer = new MediaPlayer();
                    //mMediaPlayer = MediaPlayer.create(this,R.raw.button);
                    mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mMediaPlayer.start();

                    Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                    t1.speak(ret, TextToSpeech.QUEUE_FLUSH, null);

                }
                catch (FileNotFoundException e) {
                    Log.e("login activity", "File not found: " + e.toString());
                    Toast.makeText(getActivity(), "not found", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    Toast.makeText(getActivity(), "can not read!", Toast.LENGTH_SHORT).show();

                    Log.e("login activity", "Can not read file: " + e.toString());
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

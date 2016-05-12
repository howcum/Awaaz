package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;

import info.androidhive.materialdesign.R;

/**
 * Created by Ravi on 29/07/15.
 */
public class SpeakFragment extends Fragment {

    public SpeakFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    TextToSpeech t1;
    EditText ed1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_speak, container, false);

        t1=new TextToSpeech(getActivity(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    //t1.getDefaultEngine();
                    t1.setLanguage(Locale.US);
                }
            }
        });
        Button button = (Button) rootView.findViewById(R.id.nowbutton);
        Button button1 = (Button) rootView.findViewById(R.id.savebutton);
        ed1=(EditText)rootView.findViewById(R.id.edittext2);
        ed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //updateDetail("fake");
                Toast.makeText(getActivity(), "Speaking!", Toast.LENGTH_SHORT).show();


                String tospeak = ed1.getText().toString();
                t1.speak(tospeak, TextToSpeech.QUEUE_FLUSH, null);
            }

        });

        button1.setOnClickListener(new View.OnClickListener() {
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

                        /*FileWriter fileWritter = new FileWriter(file.getName(),true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                        bufferWritter.write(etName);
                        bufferWritter.close();*/
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


        });

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

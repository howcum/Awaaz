package info.howcum.AwaazV2.activity;

/**
 * Created by Ravi on 29/07/15.
 */
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

import info.howcum.AwaazV2.R;


public class ExplorerFragment extends Fragment {

    public ExplorerFragment() {
        // Required empty public constructor


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    TextToSpeech t1;
    EditText tt;
    Button [] bb;
    File[] filelist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_explorer, container, false);
        String path= Environment.getExternalStorageDirectory().toString()+"/Awaaz";
        File file = new File(path);
        Log.d("Files", "Path : " + path);
        filelist = file.listFiles();
        Button [] bb= new Button[8];
        Log.d("files", "size" + filelist.length );

        bb[0] = (Button) rootView.findViewById(R.id.button1);
        bb[1] = (Button) rootView.findViewById(R.id.button2);
        bb[2] = (Button) rootView.findViewById(R.id.button3);
        bb[3] = (Button) rootView.findViewById(R.id.button4);
        bb[4] = (Button) rootView.findViewById(R.id.button5);
        bb[5] = (Button) rootView.findViewById(R.id.button6);

        //Toast.makeText(getActivity(), filelist[0].getName().toString(), Toast.LENGTH_SHORT).show();

        String[] theNamesOfFiles = new String[filelist.length];
        for (int i = 0; i < theNamesOfFiles.length; i++) {
            Log.d("files", "filename "+filelist[i].getName());
            //theNamesOfFiles[i] = filelist[i].getName();
            bb[i].setText(filelist[i].getName());
        }
        
        for(int i=0;i<theNamesOfFiles.length;i++)
        {
            final int finalI = i;
            bb[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment = null;
                    String title; 
                    //= getString(R.string.app_name);

                    fragment = new VoicefileFragment();
                    title =filelist[finalI].getName();

                    if (fragment != null) {
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        Bundle args = new Bundle();
                        args.putString("Selected",title);
                        fragment.setArguments(args);
                        fragmentTransaction.replace(R.id.container_body, fragment);
                        fragmentTransaction.commit();

                        // set the toolbar title
                        //getActivity().getSupportActionBar().setTitle(title);
                    }
                }


            });
        }

        //rootView.setListAdapter(new ArrayAdapter<String>(getActivity(), rootView.findViewById(R.layout.listView), theNamesOfFiles));





        /*Button b = (Button) rootView.findViewById(R.id.bolo);
        t1=new TextToSpeech(getActivity(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    //t1.getDefaultEngine();
                    t1.setLanguage(Locale.US);
                }
            }
        });
        tt = (EditText) rootView.findViewById(R.id.edittext3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret="";
                try {
                    //InputStream inputStream = getActivity().openFileInput("data/data/info.androidhive.materialdesign/test.txt");
                    InputStream inputStream = getActivity().getResources().openRawResource(R.raw.books);

                    if ( inputStream != null ) {
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String receiveString = "";
                        StringBuilder stringBuilder = new StringBuilder();

                        while ( (receiveString = bufferedReader.readLine()) != null ) {
                            stringBuilder.append("\n");
                            stringBuilder.append(receiveString);
                        }

                        inputStream.close();
                        ret = stringBuilder.toString();
                        tt.setText(ret);
                        t1.speak(ret, TextToSpeech.QUEUE_FLUSH, null);
                    }
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

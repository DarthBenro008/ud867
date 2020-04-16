package com.benrostudios.jokedisplayer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class JokeDisplayFragment extends Fragment {
    private static final String FRAG_ARG = "JOKE_Args";
    private String jokeText;
    public JokeDisplayFragment() {
        // Required empty public constructor
    }


    public static JokeDisplayFragment newInstance(String jokes) {
        JokeDisplayFragment fragment = new JokeDisplayFragment();
        Bundle args = new Bundle();
        args.putString(FRAG_ARG, jokes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jokeText = getArguments().getString(FRAG_ARG);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView jokeTextView = getView().findViewById(R.id.joke);
        jokeTextView.setText(jokeText);
        Log.d("hello","done");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_joke_displayer, container, false);
    }
}

package com.example.activefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyFragment extends Fragment {
    FragmentManager manager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        manager=getFragmentManager();
        View view=inflater.inflate(R.layout.fragment_layout,container,false);
        Button button=view.findViewById(R.id.button2);
        manager=getFragmentManager();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.remove(MyFragment.this);
                transaction.commit();
            }
        });

        return view;
    }
}

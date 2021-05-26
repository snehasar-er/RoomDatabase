package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
public static FragmentManager fragmentManager;
public static MyDataBaseApp myDataBaseApp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fragmentManager =getSupportFragmentManager();
		myDataBaseApp= Room.databaseBuilder(getApplicationContext(),MyDataBaseApp.class,"userdb").allowMainThreadQueries().build();
		if(findViewById(R.id.fragment_container)!= null)
		{
			if(savedInstanceState != null)
			{
				return ;
			}

		}
		fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
	}
}
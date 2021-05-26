package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class ViewUsersFragment extends Fragment {
	private TextView textinfo ;
	public ViewUsersFragment()
	{

	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_view , container , false);
		textinfo = view.findViewById(R.id.readUserFragment_textView);
		List<User> users= MainActivity.myDataBaseApp.myDao().getusers();
		String info =" ";
		for(User user :users)
		{
			int id =user.getId();
			String name = user.getName();
			String email = user.getEmail();
			info = info +"\n\n"+"Id :"+id+"\n\n"+"Name :"+name+"\n\n"+"Email :"+ email;
		}
		textinfo.setText(info);
		return view;
	}
}

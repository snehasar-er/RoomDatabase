package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class  AddUserFragment extends Fragment implements View.OnClickListener {
	private Button btn_insert ;
	private EditText userid,userName , userEmail ;
	public void AddUserFragment()
	{

	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_adduser,container,false);
        userid =view.findViewById(R.id.addUserFragment_user_id);
        userName= view.findViewById(R.id.addUserFragment_name);
        userEmail= view.findViewById(R.id.addUserFragment_email);
        btn_insert=view.findViewById(R.id.addUserFragment_saveButton);
        btn_insert.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		int id = Integer.parseInt(userid.getText().toString());
		String name = userName.getText().toString();
		String email = userEmail.getText().toString();

		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setId(id);

		MainActivity.myDataBaseApp.myDao().addUser(user);
		Toast.makeText(getContext(),"User added successfully",Toast.LENGTH_LONG).show();

		userid.setText("");
		userName.setText("");
		userEmail.setText("");

	}
}

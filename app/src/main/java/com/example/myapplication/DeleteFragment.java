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

public class DeleteFragment  extends Fragment  {

	private Button btn_delete;
	private EditText user_id;

	public DeleteFragment() {

	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_delete, container, false);
		btn_delete = view.findViewById(R.id.deleteUserButton);
		user_id = view.findViewById(R.id.deleteUserEditText);
		btn_delete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int userId;
				userId = Integer.parseInt(user_id.getText().toString());
				User user = new User();
				user.setId(userId);
				MainActivity.myDataBaseApp.myDao().deleteUser(user);
				Toast.makeText(getContext(), "User added successfully", Toast.LENGTH_LONG).show();

				user_id.setText("");
			}
		});
		return view;
	}


}

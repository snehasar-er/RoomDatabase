package com.example.myapplication;

import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class UpdateFragment extends Fragment {
	private EditText userId, userName ,userEmail;
	private Button btn_update;
	public UpdateFragment()
	{

	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_update , container , false );
		userId = view.findViewById(R.id.updateuserId);
		userName = view.findViewById(R.id.updateuserName);
		userEmail = view.findViewById(R.id.updateuserEmail);
		btn_update= view .findViewById(R.id.updateBtn);
		btn_update.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int user_Id = Integer.parseInt(userId.getText().toString());
				String name =userName.getText().toString();
				String email = userEmail.getText().toString();
				User user = new User();
				user.setId(user_Id);
				user.setName(name);
				user.setEmail(email);
				List<User> users=MainActivity.myDataBaseApp.myDao().getusers();
				for(User us: users)
				{
					if(us.getId()==user_Id)
					{
						MainActivity.myDataBaseApp.myDao().updateUser(user);
						Toast.makeText(getContext(),"User added successfully",Toast.LENGTH_LONG).show();
						userId.setText("");
						userName.setText("");
						userEmail.setText("");
					}
					else {
						Toast.makeText(getContext(), "Invalid user id present ", Toast.LENGTH_LONG).show();
						userId.setText("");
						userName.setText("");
						userEmail.setText("");
					}
				}

			}
		});

		return view;
	}
}

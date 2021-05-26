package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener {

	private Button btn_insert , btn_users , btn_delete , btn_update;
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view =inflater.inflate(R.layout.activity_home,container,false);
		btn_insert= view.findViewById(R.id.addUserHomeFragment);
		btn_users = view.findViewById(R.id.viewUserHomeFragment);
		btn_delete = view.findViewById(R.id.deleteUserHomeFragment);
		btn_update= view.findViewById(R.id.updateUserHomeFragment);
		btn_insert.setOnClickListener(this);
		btn_users.setOnClickListener(this);
		btn_delete.setOnClickListener(this);
		btn_update.setOnClickListener(this);
		return view ;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
			case R.id.addUserHomeFragment :
             MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddUserFragment()).addToBackStack(null).commit();
             break;

			case R.id.viewUserHomeFragment:
				MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ViewUsersFragment()).addToBackStack(null).commit();
				break ;

			case R.id.deleteUserHomeFragment:
				MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteFragment()).addToBackStack(null).commit();
				break;

			case R.id.updateUserHomeFragment:
				MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateFragment()).addToBackStack(null).commit();
				break;

		}
	}
}

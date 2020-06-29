package com.opus_bd.stockmanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.opus_bd.stockmanagement.Model.LoginResponce;
import com.opus_bd.stockmanagement.Model.UserModel;
import com.opus_bd.stockmanagement.R;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitClientInstance;
import com.opus_bd.stockmanagement.RetrofitService.RetrofitService;
import com.opus_bd.stockmanagement.Utilts.SharedPrefManager;
import com.opus_bd.stockmanagement.Utilts.Utilities;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.rootLayout)
    LinearLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnSignIn)
    public void login() {
        if (!validatedForm())
            return;
        submitToServer(); }


    private void submitToServer() {
        Utilities.showProgress(this);
        SharedPrefManager.getInstance(LoginActivity.this).clearToken();
        final UserModel userModel = new UserModel(etUserName.getText().toString(), etPassword.getText().toString());

        //SharedPrefManager.getInstance(this).saveUserName(etUserName.getText().toString());
        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<LoginResponce> registrationRequest = retrofitService.login(userModel);
        registrationRequest.enqueue(new Callback<LoginResponce>() {
            @Override
            public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
                Utilities.hideProgress(LoginActivity.this);
                try {
                    if (response.body() != null) {
                        SharedPrefManager.getInstance(LoginActivity.this).saveToken(response.body().getAuthToken());
                        Toast.makeText(LoginActivity.this, "Successfully Logged in!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, "Something went Wrong! Please try again later", Toast.LENGTH_SHORT).show();
                }
                showProgressBar(false);
            }

            @Override
            public void onFailure(Call<LoginResponce> call, Throwable t) {
                Utilities.hideProgress(LoginActivity.this);
                Toast.makeText(LoginActivity.this, "Fail to connect " + t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private boolean validatedForm() {
        if (TextUtils.isEmpty(etUserName.getText().toString())) {
            etUserName.setError(getResources().getString(R.string.field_null_error));
            Toast.makeText(this, "Contact field can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError(getResources().getString(R.string.field_null_error));
            Toast.makeText(this, "Password field can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void showProgressBar(boolean visible) {
       /* if (visible) {
            progressbar.setVisibility(View.VISIBLE);
            rootLayout.setAlpha(Constants.PROGRESSBAR_ALPHA);
            setLayoutStatus(false);

        } else {
            progressbar.setVisibility(View.GONE);
            rootLayout.setAlpha(Constants.PROGRESSBAR_AFTER_FINISH_ALPHA);
            setLayoutStatus(true);
        }*/
    }

    private void setLayoutStatus(boolean status) {
        for (int i = 0; i < rootLayout.getChildCount(); i++) {
            View view = rootLayout.getChildAt(i);
            view.setEnabled(status);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

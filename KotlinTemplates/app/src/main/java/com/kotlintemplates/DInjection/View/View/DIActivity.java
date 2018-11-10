package com.kotlintemplates.DInjection.View.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kotlintemplates.DInjection.View.CustomApplication;
import com.kotlintemplates.DInjection.View.Repository.APIService;
import com.kotlintemplates.R;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DIActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di);

        ((CustomApplication)getApplication()).getNetworkComponent().inject(DIActivity.this);
        APIService mService = retrofit.create(APIService.class);
        Call<String> mInfo = mService.makeRequest();
        mInfo.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("DIActivity","Response::::"+response.toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("DIActivity","Error Response::::"+t.toString());
            }
        });
       /* mSong.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<List<Songs>> call, Response<List<Songs>> response) {
                Log.d(TAG, "Result " + response.body().size());
              *//*  SongAdapter mAdapter = new SongAdapter(MainActivity.this, response.body());
                gridRecycler.setAdapter(mAdapter);*//*
            }
            @Override
            public void onFailure(Call<List<Songs>> call, Throwable t) {
                Log.d(TAG, "Display error code " + t.toString());
            }
        });*/
    }
}

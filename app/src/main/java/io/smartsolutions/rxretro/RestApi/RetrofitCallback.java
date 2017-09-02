package io.smartsolutions.rxretro.RestApi;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.WindowManager;


import java.io.IOException;

import io.smartsolutions.rxretro.R;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by omar on 30/07/2017.
 */

public class RetrofitCallback implements Callback<ResponseBody> {

    public Context context;
    public WebServiceInterFace webServiceInterFace;

    ProgressDialog progressDialog;

    public RetrofitCallback(Context context, WebServiceInterFace webServiceInterFace) {
        this.context = context;
        this.webServiceInterFace = webServiceInterFace;
        createProgressDialog(this.context);
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

        dismissProgressDialog();

        try {
         if(response.isSuccessful() ){
                String reponseDisplay = response.body().string();
                Log.e(getClass().getSimpleName() + " onResponse", reponseDisplay);

                Log.e(getClass().getSimpleName() + " methodtype", response.raw().request().method());
                Log.e(getClass().getSimpleName() + " url", response.raw().request().url().toString());

                webServiceInterFace.parseString(call.toString(), reponseDisplay);

                webServiceInterFace.parseString(call.toString(), reponseDisplay, response.raw().request().url().toString(),
                        response.raw().request().method());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

        dismissProgressDialog();
        webServiceInterFace.failResponse(t);

    }


    public interface WebServiceInterFace {

        public void parseString(String call, String response);

        public void parseString(String call, String response, String url, String methodType);

        public void failResponse(Throwable t);

    }


    public ProgressDialog createProgressDialog(Context mContext) {
        progressDialog = new ProgressDialog(mContext);
        try {
            progressDialog.show();
            progressDialog.setCancelable(true);
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            progressDialog.setContentView(R.layout.progressdialog);
            //progressDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        } catch (WindowManager.BadTokenException e) {

        }

        return progressDialog;
    }


    private void dismissProgressDialog() {

        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

}

package com.prakruthi.ui.ui.productPage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.prakruthi.R;
import com.prakruthi.ui.Utility.AvenuesParams;
//import com.prakruthi.ui.Utility.Constants;
import com.prakruthi.ui.Utility.LoadingDialog;
import com.prakruthi.ui.Utility.RSAUtility;
import com.prakruthi.ui.Utility.ServiceUtility;
import com.prakruthi.ui.utils.Constants;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class WebViewActivity extends AppCompatActivity {

    Intent mainIntent;
    String encVal;
    String vResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mainIntent = getIntent();

        //get rsa key method
        get_RSA_key(mainIntent.getStringExtra(AvenuesParams.ACCESS_CODE), mainIntent.getStringExtra(AvenuesParams.ORDER_ID));

    }


    private class RenderView extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            LoadingDialog.showLoadingDialog(WebViewActivity.this, "Loading...");



        }

        @Override
        protected Void doInBackground(Void... arg0) {

//            ServiceHandler sh = new ServiceHandler();

            if (!ServiceUtility.chkNull(vResponse).equals("")
                    && ServiceUtility.chkNull(vResponse).toString().indexOf("ERROR") == -1) {
                StringBuffer vEncVal = new StringBuffer("");
                vEncVal.append(ServiceUtility.addToPostParams(AvenuesParams.AMOUNT,
                        mainIntent.getStringExtra(AvenuesParams.AMOUNT)));
                vEncVal.append(ServiceUtility.addToPostParams(AvenuesParams.CURRENCY,
                        mainIntent.getStringExtra(AvenuesParams.CURRENCY)));
                encVal = RSAUtility.encrypt(vEncVal.substring(0, vEncVal.length() - 1), vResponse);  //encrypt amount and currency
            }

            return null;
        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            LoadingDialog.cancelLoading();

            @SuppressWarnings("unused")
            class MyJavaScriptInterface {
                @JavascriptInterface
                public void processHTML(String html) {
                    // process the html source code to get final status of transaction
                    String status = null;
                    if (html.indexOf("Failure") != -1) {
                        status = "Transaction Declined!";
                    } else if (html.indexOf("Success") != -1) {
                        status = "Transaction Successful!";
                    } else if (html.indexOf("Aborted") != -1) {
                        status = "Transaction Cancelled!";
                    } else {
                        status = "Status Not Known!";
                    }
                    Toast.makeText(getApplicationContext(), status, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), StatusActivity.class);
                    intent.putExtra("transStatus", status);
                    startActivity(intent);
                }
            }

            final WebView webview = (WebView) findViewById(R.id.webview);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.addJavascriptInterface(new MyJavaScriptInterface(), "HTMLOUT");

            webview.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(webview, url);

                    LoadingDialog.cancelLoading();

                    if (url.indexOf("/ccavResponseHandler.jsp") != -1) {
                        webview.loadUrl("javascript:window.HTMLOUT.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
                    }
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    LoadingDialog.showLoadingDialog(WebViewActivity.this, "Loading...");
                }
            });

            //-------------------------------------------------------------------------

//            try {
//                String postData = AvenuesParams.ACCESS_CODE + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.ACCESS_CODE), "UTF-8") + "&" + AvenuesParams.MERCHANT_ID + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.MERCHANT_ID), "UTF-8") + "&" + AvenuesParams.ORDER_ID + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.ORDER_ID), "UTF-8") + "&" + AvenuesParams.REDIRECT_URL + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.REDIRECT_URL), "UTF-8") + "&" + AvenuesParams.CANCEL_URL + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CANCEL_URL), "UTF-8") + "&" + AvenuesParams.ENC_VAL + "=" + URLEncoder.encode(encVal, "UTF-8");
//                webview.postUrl(Constants.TRANS_URL, postData.getBytes());
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }

            //------------------------------------------------------------------------------



            try {
                String postData = AvenuesParams.ACCESS_CODE + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.ACCESS_CODE), "UTF-8")
                        + "&" + AvenuesParams.MERCHANT_ID + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.MERCHANT_ID), "UTF-8")
                        + "&" + AvenuesParams.ORDER_ID + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.ORDER_ID), "UTF-8")
                        + "&" + AvenuesParams.REDIRECT_URL + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.REDIRECT_URL), "UTF-8")
                        + "&" + AvenuesParams.CANCEL_URL + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CANCEL_URL), "UTF-8")

//                        + "&" + AvenuesParams.CCAVENUE_BILLING_NAME  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_BILLING_NAME ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_BILLING_ADDRESS  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_BILLING_ADDRESS ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_BILLING_CITY  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_BILLING_CITY ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_BILLING_STATE  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_BILLING_STATE ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_BILLING_ZIP  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_BILLING_ZIP ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_BILLING_COUNTRY  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_BILLING_COUNTRY ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_BILLING_TEL  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_BILLING_TEL ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_BILLING_EMAIL  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_BILLING_EMAIL ), "UTF-8")
//
//                        + "&" + AvenuesParams.CCAVENUE_DELIVERY_NAME  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_DELIVERY_NAME ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_DELIVERY_ADDRESS  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_DELIVERY_ADDRESS ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_DELIVERY_CITY  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_DELIVERY_CITY ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_DELIVERY_STATE  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_DELIVERY_STATE ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_DELIVERY_COUNTRY  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_DELIVERY_COUNTRY ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_DELIVERY_ZIP  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_DELIVERY_ZIP ), "UTF-8")
//                        + "&" + AvenuesParams.CCAVENUE_DELIVERY_TEL  + "=" + URLEncoder.encode(mainIntent.getStringExtra(AvenuesParams.CCAVENUE_DELIVERY_TEL ), "UTF-8")

                        + "&" + AvenuesParams.ENC_VAL + "=" + URLEncoder.encode(encVal, "UTF-8");

//                CCAVENUE_PRODUCTION_TRANSACTION_URL

                webview.postUrl(Constants.TRANS_URL, postData.getBytes());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
    }

    public void get_RSA_key(final String ac, final String od) {
        LoadingDialog.showLoadingDialog(WebViewActivity.this, "Loading...");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, mainIntent.getStringExtra(AvenuesParams.RSA_KEY_URL),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(WebViewActivity.this,response,Toast.LENGTH_LONG).show();
                        LoadingDialog.cancelLoading();

                        if (response != null && !response.equals("")) {
                            vResponse = response;     ///save retrived rsa key
                            if (vResponse.contains("!ERROR!")) {
                                show_alert(vResponse);
                            } else {
                                new RenderView().execute();   // Calling async task to get display content
                            }


                        }
                        else
                        {
                            show_alert("No response");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        LoadingDialog.cancelLoading();
                        //Toast.makeText(WebViewActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(AvenuesParams.ACCESS_CODE, ac);
                params.put(AvenuesParams.ORDER_ID, od);
                return params;
            }

        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void show_alert(String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(
                WebViewActivity.this).create();

        alertDialog.setTitle("Error!!!");
        if (msg.contains("\n"))
            msg = msg.replaceAll("\\\n", "");

        alertDialog.setMessage(msg);



        alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });


        alertDialog.show();
    }


}
     /*
        Name:- Sahithi visvanathan
        ID:-912549149
        Discription:- Main activity file where the Json objects Get_Token, and Get_Message are called to get a JsonResonse from
        an external API created on SFSU server.

     */
        package com.example.sahithi.project2;
        import com.example.sahithi.project2.R;
        import com.example.sahithi.project2.AppController;
        import org.json.JSONException;
        import org.json.JSONObject;

        import android.app.ProgressDialog;
        import android.os.Bundle;

        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.text.method.ScrollingMovementMethod;
        import android.util.Log;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.android.volley.Request.Method;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.VolleyLog;

        import com.android.volley.toolbox.JsonObjectRequest;

public class MainActivity extends AppCompatActivity {
    private String urlJsonObj = "http://sfsuswe.com/413/get_token/?username=sahithiv&password=912549149";
    private String urlJsonObj1="http://sfsuswe.com/413/get_message/?token=";



    private int LineCount=1;
    private static String TAG = MainActivity.class.getSimpleName();
    private Button btnMakeObjectRequest,btnMakeObjectRequest1;
    ProgressDialog pDialog;
    private TextView txtResponse, txtResponse1;
    private String jsonResponse;
    private String TokenR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnMakeObjectRequest = (Button) findViewById(R.id.GetToken);
        btnMakeObjectRequest1=(Button) findViewById (R.id.GetMessage);



        txtResponse = (TextView) findViewById(R.id.txtResponse);

        txtResponse.setMovementMethod(new ScrollingMovementMethod());

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        btnMakeObjectRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Get_Token();
            }
        });
        btnMakeObjectRequest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Get_Message();
            }
        });
    }

    /**
     * Method to make Get_Token object request where json response starts wtih {
     * */
    private void Get_Token() {
        showpDialog();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
                urlJsonObj, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                try {
                    // Parsing json object response
                    // response will be a json object
                    TokenR = response.getString("token");
                    jsonResponse = "";
                    jsonResponse += "token:" + TokenR + "\n\n\n\n"+txtResponse.getText();
                    txtResponse.setText(jsonResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                hidepDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                hidepDialog();
            }
    });

        AppController.getInstance().addToRequestQueue(jsonObjReq);// add the object to request queue request queue
    }
    private void Get_Message() {
        showpDialog();
        String  newUrl= urlJsonObj1+TokenR;
        JsonObjectRequest jsonObjReq1 = new JsonObjectRequest(Method.GET,
                newUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                try {
                    // Parsing json object response
                    // response will be a json object
                    String message = response.getString("message");
                    jsonResponse = "";
                    jsonResponse += "message:" + message + "\n"+txtResponse.getText();
                    txtResponse.setText(jsonResponse);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                hidepDialog();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjReq1);
    }



    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }




}


package com.example.htpp;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
 
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
 
public class MainActivity extends ActionBarActivity {
       
                public EditText titulo, descripcion;
                public Button enviar, probar;
                private String tit, des;
 
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
               
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
               
                titulo = (EditText) findViewById(R.id.editText1);
                descripcion = (EditText) findViewById(R.id.editText2);
                enviar = (Button) findViewById(R.id.button1);
               
                tit = titulo.getText().toString();
                des = descripcion.getText().toString();
                               
                enviar.setOnClickListener(new View.OnClickListener() {
                                       
                                        @Override
                                        public void onClick(View v) {
                                                // TODO Auto-generated method stub
                                                postData( titulo.getText().toString() , descripcion.getText().toString());
                                        }
                                });                          
        }
 
 
                public void postData(String titl, String desc) {
            // Create a new HttpClient and Post Header
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://design4u.uphero.com/add.php");
 
                try {
                    // Add your data
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                    nameValuePairs.add(new BasicNameValuePair("titulo", titl));
                    nameValuePairs.add(new BasicNameValuePair("img", "https://fbcdn-profile-a.akamaihd.net/hprofile-ak-frc3/t1.0-1/p100x100/10255214_10203942324537307_3503753291429194020_a.jpg"));
                    nameValuePairs.add(new BasicNameValuePair("desc", desc));
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
       
                    // Execute HTTP Post Request
                    HttpResponse response = httpclient.execute(httppost);
       
                } catch (ClientProtocolException e) {
                    // TODO Auto-generated catch block
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                }
        }
}

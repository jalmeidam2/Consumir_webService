package com.example.consumir_webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.consumir_webservice.WebService.Asynchtask;
import com.example.consumir_webservice.WebService.WebService;

import org.json.JSONException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void btEnviar(View view) {
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://omgvamp-hearthstone-v1.p.rapidapi.com/info",
                datos, this, (Asynchtask) this);
        ws.execute("GET","x-rapidapi-key", "c69a5b933amshaf36f7394bf16e5p1f1389jsn34bcd6d712ce","x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com");
    }
    @Override
    public void processFinish(String result) throws JSONException {
        TextView txtBancos = (TextView)findViewById(R.id.IdResul);
        //String lstBancos="";
        //JSONArray JSONlista =  new JSONArray(result);
        //for(int i=0; i< JSONlista.length();i++){
          //  JSONObject banco=  JSONlista.getJSONObject(i);
           // lstBancos = lstBancos + "\n" + banco.getString("name").toString();
        //}
        txtBancos.setText("Respuesta WS : " +  result);
    }
}
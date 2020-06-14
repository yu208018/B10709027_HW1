
package com.example.android.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> mDataset = new ArrayList<>();
    private String[] country={"TV-Tuvalu", "TR-Türkiye", "DE-Germany", "TW-Taiwan", "CN-CoronaVirus", "DK-Danmark", "EC-Ecuador", "ER-Ertra", "PG-Papua New Guinea", "BR-Brasil", "BB-Barbados", "PY-Paraguay", "BS-Bahamas", "PA-Panamá", "PS-Palestinian Territory", "JP-Japan", "BE-België", "JM-Jamaica", "CA-Canada", "GA-Gabon", "MP-Northern Mariana Islands", "CU-Cuba", "SZ-Swaziland", "NE-Niger", "NI-Nicaragua", "BV-Bouvet Island", "BF-Burkina Faso", "GT-Guatemala", "GP-Guadeloupe", "GM-Gambia", "PN-Pitcairn", "LT-Lietuva", "IS-Ísland", "LN-Liechtenstein", "HU-Magyarország", "ID-Indonesia", "IN-India", "DJ-Djibouti", "KI-Kiribati", "DO-Dominican Republic", "DM-Dominica", "TG-Togo", "AG-Antigua and Barbuda", "AO-Angola", "AD-Andorra", "AI-Anguilla", "TK-Tokelau", "BM-Bermuda", "GB-United Kingdom", "IO-British Indian Ocean Territory", "VG-Virgin Islands, British", "GH-Ghana", "HK-Hong Kong", "CO-Colombia", "CR-Costa Rica", "NO-Norge", "GG-Guernsey", "GL-Greenland", "GD-Grenada", "HT-Haïti", "UG-Uganda", "UY-Uruguay", "PE-Perú", "SO-Soomaaliya", "NZ-New Zealand", "NU-Niue", "NA-Namibia", "MQ-Martinique", "ML-Mali", "MY-Malaysia", "MW-Malawi", "YT-Mayotte", "AT-Österreich", "AX-Aland Islands", "EE-Eesti", "IE-Ireland", "SG-Singapura", "SE-Sverige", "CH-Schweiz", "IT-Italia", "KR-South Korea", "KW-Kuwait", "LV-Latvia", "PT-Portugal", "BI-Uburundi", "GY-Guyana", "MU-Mauritius", "MX-México", "MO-Macao", "AU-Australia", "RW-Rwanda", "NF-Norfolk Island", "NR-Naoero", "LS-Lesotho", "SV-El Salvador", "SO-Samoa", "RO-România", "GU-Guam", "SR-Suriname", "ZW-Zimbabwe"};
    MyAdapter mAdaper;
    RecyclerView mCountryList;
    boolean[] back=new boolean[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 100; i++) {
            Item items = new Item();
            items.setCheck(false);
            items.setText(country[i]);
            back[i]=false;
            mDataset.add(items);
        }


        //Back & Delete
        Intent intent3 = this.getIntent();
        try {
            //RecyclerView
            mCountryList = (RecyclerView) findViewById(R.id.list_view);
            LinearLayoutManager LayoutManger = new LinearLayoutManager(this);
            mCountryList.setLayoutManager(LayoutManger);
            mCountryList.setHasFixedSize(true);
            mAdaper = new MyAdapter(mDataset);
            mCountryList.setAdapter(mAdaper);
        }catch(Exception e){
            e.printStackTrace();
            Log.e("tag","error");
        }
    }

    public void ClickConfirm(View view){
        int c=mAdaper.getSelectedCount();
        boolean[] b=mAdaper.getSelected();
        Intent intent1=new Intent();
        intent1.setClass(MainActivity.this,ChildActivity.class);
        intent1.putExtra("selectCount",c);
        intent1.putExtra("selected",b);
        startActivity(intent1);
    }

}

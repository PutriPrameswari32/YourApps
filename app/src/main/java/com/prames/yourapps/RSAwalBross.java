package com.prames.yourapps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBross extends ListActivity {
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        String[] listAct = new String[] {"Call Center","SMS Center",
                "Driving Direction","Website","Info di Google","Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAct));
    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);

    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center"))
            {
                String telp = "tel:0761-21000";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(telp));

            }else if(pilihan.equals("SMS Center"))
            {
                String smsText = "Hai...Putri Prameswari";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081234783333"));
                a.putExtra("sms_body",smsText);

            }else if(pilihan.equals("Driving Direction"))
        {
            String lokasi ="google.navigation:q=0.463823.101.390353";
//            String lokasi = "https://www.google.com/maps/place//" +
//                    "@0.5215391,101.4432246,19.25z/data=!4m14!1m13!4m12!1m4!2m2!1d101.4465139!2d0.5467494!4e1!1m6!1m2!" +
//                    "1s0x31d5ac0492383fe5:0x95c59ff5d9dca508!2sRS+Awal+Bros+A.+Yani,+Jl.+Jend.+Ahmad+Yani+No.73,+Tanah+Datar," +
//                    "+Kec.+Pekanbaru+Kota,+Kota+Pekanbaru,+Riau+28156!2m2!1d101.4434587!2d0.5209271";
            a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasi));

        }else if(pilihan.equals("Website"))
            {
                String website = "http://awalbros.com/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
            }else if(pilihan.equals("Info di Google"))
            {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Awal Bros");
            }

            startActivity(a);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

package com.example.lc.broadcast;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_1;

/**
 * 这是读取联系人的
 */
public class View_List extends AppCompatActivity {
    List<String> contain = new  ArrayList<>();
    ArrayAdapter<String> adapter= null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        ListView listView = findViewById(R.id.list_View);
        adapter= new ArrayAdapter<>(this, simple_list_item_1,contain);
        listView.setAdapter(adapter);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.READ_CONTACTS},1);
        }else{
            readContact();
        }

    }

    private void readContact() {
        Cursor cursor =  null ;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
            if(cursor!=null)
            while (cursor.moveToNext()){
                String displayName = cursor.getString(cursor.getColumnIndex
                        (ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex
                        (ContactsContract.CommonDataKinds.Phone.NUMBER));
                contain.add(displayName + "\n" + number);
            }
            adapter.notifyDataSetChanged();
        }catch (Exception e )
        {
            e.printStackTrace();
        }
        finally {
            if(cursor!=null)
            {
                cursor.close();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.
                        PERMISSION_GRANTED) {
                    readContact();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}

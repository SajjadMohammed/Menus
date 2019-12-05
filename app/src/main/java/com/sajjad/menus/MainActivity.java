package com.sajjad.menus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Toolbar mainToolbar;
    Button contextMenuButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainToolbar=findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);

        contextMenuButton=findViewById(R.id.contextMenuButton);

        registerForContextMenu(contextMenuButton);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.sendItem:
                Toast.makeText(this,"I am Send Item",Toast.LENGTH_LONG).show();
                return  true;
            case R.id.mainItem:
                Toast.makeText(this,"I am Mail Item",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        MenuItem sendItem=menu.findItem(R.id.sendItem);
        sendItem.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.sendItem:
                Toast.makeText(this,"I am Send Item",Toast.LENGTH_LONG).show();
                return  true;
            case R.id.mainItem:
                Toast.makeText(this,"I am Mail Item",Toast.LENGTH_LONG).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    public void showPopUpMenu(View view) {

        PopupMenu popupMenu=new PopupMenu(this,view);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.sendItem:
                        Toast.makeText(MainActivity.this,"I am Send Item",Toast.LENGTH_LONG).show();
                        return  true;
                    case R.id.mainItem:
                        Toast.makeText(MainActivity.this,"I am Mail Item",Toast.LENGTH_LONG).show();
                        return true;
                        default:
                            return false;
                }
            }
        });

        popupMenu.inflate(R.menu.pop_up_menu);
        popupMenu.show();
    }


    public void showSettingsActivity(View view) {
        startActivity(new Intent(this,SettingsActivity.class));
    }
}

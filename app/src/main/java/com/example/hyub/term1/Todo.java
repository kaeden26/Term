package com.example.hyub.term1;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hyub on 2016-12-06.
 */

public class Todo extends Activity{
    static final private int MENU_ADD = Menu.FIRST;
    static final private int MENU_REMOVE = Menu.FIRST + 1;

    private boolean inputNow = false;
    private TextView TaskTextView = null;
    private EditText TaskEditText = null;
    private ListView TaskListView = null;
    ArrayList<String> arrTaskItems = null;
    ArrayAdapter<String> arrayAdapter = null;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        TaskTextView = (TextView)findViewById(R.id.NoItemText);
        TaskEditText = (EditText)findViewById(R.id.TaskEditText);
        TaskListView = (ListView)findViewById(R.id.TaskListView);
        arrTaskItems = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_todo, arrTaskItems);

        TaskListView.setAdapter(arrayAdapter);
        registerForContextMenu(TaskListView);

        TaskEditText.setOnKeyListener(new OnKeyListener(){
            public boolean
            onKey(View v, int code, KeyEvent event){
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    if ((code == KeyEvent.KEYCODE_DPAD_CENTER)||
                            (code == KeyEvent.KEYCODE_ENTER)){
                        if(TaskEditText.getText().length() > 0){
                            arrTaskItems.add(0,TaskEditText.getText().toString());
                            arrayAdapter.notifyDataSetChanged();
                            TaskEditText.setText("");
                            cancelInput();
                            return true;
                        }
                    }
                }
                return true;
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        MenuItem itemAdd = menu.add(0,MENU_ADD, Menu.NONE, R.string.menu_add);
        MenuItem itemRemove = menu.add(0,MENU_REMOVE, Menu.NONE, R.string.menu_remove);

        itemAdd.setIcon(android.R.drawable.ic_menu_add);
        itemRemove.setIcon(android.R.drawable.ic_menu_delete);

        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        super.onPrepareOptionsMenu(menu);

        MenuItem itemAdd = menu.findItem(MENU_ADD);
        MenuItem itemRemove = menu.findItem(MENU_REMOVE);

        itemAdd.setVisible((inputNow ==false));
        itemRemove.setTitle(inputNow ? android.R.string.cancel : R.string.menu_remove);
        itemRemove.setVisible(inputNow || (TaskListView.getSelectedItemPosition() >=0));

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case(MENU_ADD):
                addTask();
                return true;
            case(MENU_REMOVE):
                if (inputNow){
                    cancelInput();
                }
                else{
                    removeTask(TaskListView.getSelectedItemPosition());
                }
                return true;
        }
        return false;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu, v, info);

        menu.setHeaderTitle(R.string.contextmenu_header);
        menu.add(0, MENU_REMOVE, Menu.NONE, R.string.menu_remove);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        super.onContextItemSelected(item);

        if(item.getItemId() == MENU_REMOVE){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

            removeTask(info.position);
            return true;
        }
        return false;
    }
    public void addTask(){
        inputNow = true;

        TaskTextView.setVisibility(View.GONE);
        TaskListView.setVisibility(View.VISIBLE);
        TaskEditText.setVisibility(View.VISIBLE);
        TaskEditText.requestFocus();
    }

    public void cancelInput(){
        inputNow = false;

        TaskEditText.setText(R.string.task_default);
        TaskEditText.setVisibility(View.GONE);

        if (arrTaskItems.size()>0){
            TaskTextView.setVisibility(View.GONE);
            TaskListView.setVisibility((View.VISIBLE));
        }
        else{
            TaskTextView.setVisibility(View.VISIBLE);
            TaskListView.setVisibility(View.GONE);
        }
    }

    public void removeTask(int index){
        if (index >=0){
            arrTaskItems.remove(index);
            arrayAdapter.notifyDataSetChanged();

        }
        TaskEditText.setText(R.string.task_default);
        TaskEditText.setVisibility(View.VISIBLE);

        if (arrTaskItems.size() >0){
            TaskTextView.setVisibility(View.GONE);
            TaskListView.setVisibility(View.VISIBLE);
        }
        else{
            TaskTextView.setVisibility(View.VISIBLE);
            TaskListView.setVisibility(View.GONE);
        }
    }
}

package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.contactsRecyclerView);

        ArrayList<Contact> contacts=new ArrayList<>();
        contacts.add(new Contact("SuperMan","emailxxx","https://images4.alphacoders.com/933/thumb-1920-933158.jpg"));
        contacts.add(new Contact("line","emailxxx","https://wallpapercave.com/wp/wp4984994.jpg"));
        contacts.add(new Contact("Sine","emailxxx","https://static0.gamerantimages.com/wordpress/wp-content/uploads/2022/02/Estarossa-faces-Escanor.jpg"));

        ContactsRecyclerviewAdapter adapter=new ContactsRecyclerviewAdapter();
        adapter.setContacts(contacts);
        adapter.setContext(getApplicationContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
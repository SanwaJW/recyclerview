package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ContactsRecyclerviewAdapter extends RecyclerView.Adapter<ContactsRecyclerviewAdapter.ViewHolder>{

    private ArrayList<Contact> contacts=new ArrayList<>();

    Context context;

    public Context setContext(Context context){
        return this.context=context;
    }

    public ContactsRecyclerviewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item,parent,false);
       ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(contacts.get(position).getName());
        holder.textEmail.setText(contacts.get(position).getEmail());

        Glide.with(context)
                .asBitmap()
                .load(contacts.get(position).getImageUrl())
                .into(holder.image);

    }
    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName,textEmail;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textEmail=itemView.findViewById(R.id.textEmail);
            txtName=itemView.findViewById(R.id.textName);
            image=itemView.findViewById(R.id.image);
        }
    }
}

package com.show.moto.motoshow;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.show.moto.motoshow.Firebase.Base;
import com.show.moto.motoshow.Modelos.Produto;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
    private static final Gerenciador ourInstance = new Gerenciador();

    private Context context;
    private ListView listView;

    public static Gerenciador getInstance() {
        return ourInstance;
    }

    private Gerenciador() {
    }


    public void setListView(ListView listView2) {
        this.listView = listView2;
    }

    public void setContext(Context pCtx) {
        context = pCtx;
    }

    public Context getContext() {
        return context;
    }


    public void atualizarListaProduto() {
        Query consulta = Base.getQuery("produto","nome","");

        consulta.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ArrayList<String> listNomeProdutos = new ArrayList<>();

                if (dataSnapshot.exists()) {

                    List<Produto> listProdutos = new ArrayList<>();

                    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                        listProdutos.add(postSnapshot.getValue(Produto.class));
                    }

                    for (int i = 0; i < listProdutos.size(); i++) {
                        listNomeProdutos.add(listProdutos.get(i).getNome());
                    }


                }

                //Criação do list adapter em tela
                ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                        android.R.layout.simple_list_item_1, listNomeProdutos);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

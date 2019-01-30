package com.show.moto.motoshow;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.show.moto.motoshow.Firebase.Base;
import com.show.moto.motoshow.Modelos.Servico;

public final class Funcoes {
    public static String tabelaServico = "servico";


    public static void addItemFirebase(String nomeTabela, final Servico object) {
        DatabaseReference dados = Base.getTableReference(nomeTabela,false);
        dados.push().setValue(object);
    }
}

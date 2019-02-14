package com.show.moto.motoshow;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.show.moto.motoshow.Firebase.Base;
import com.show.moto.motoshow.Modelos.Pedido;
import com.show.moto.motoshow.Modelos.Produto;

public final class Funcoes {
    public static String tabelaServico = "servico";
    public static String tabelaProduto = "produto";
    public static String tabelaPedido = "pedido";

    public static void addItemFirebase(String nomeTabela, final Pedido object) {
        DatabaseReference dados = Base.getTableReference(nomeTabela,false);
        dados.push().setValue(object);
    }

    public static void addItemFirebaseProd(String nomeTabela, final Produto object) {
        DatabaseReference dados = Base.getTableReference(nomeTabela,false);
        dados.push().setValue(object);
    }

    public static Query getItensFirebase(String nomeTabela, String nomeFiltro, String valorFiltro) {
        DatabaseReference dados = Base.getTableReference(nomeTabela,false);
        return valorFiltro.equals("") ? dados.orderByChild(nomeFiltro) : dados.orderByChild(nomeFiltro).equalTo(valorFiltro);
    }
}

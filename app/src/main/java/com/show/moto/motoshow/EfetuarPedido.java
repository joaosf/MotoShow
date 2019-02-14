package com.show.moto.motoshow;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.show.moto.motoshow.Modelos.Pedido;
import com.show.moto.motoshow.Modelos.PedidoItem;
import com.show.moto.motoshow.Modelos.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EfetuarPedido extends AppCompatActivity {

    EditText txtCadPedidoCliente;
    EditText txtCadPedidoVendedor;
    EditText txtCadPedidoPlaca;
    Spinner spnProdutos;
    EditText txtCadPedidoItemQuantidade;
    EditText txtCadPedidoItemValor;
    EditText txtCadPedidoItemTotal;
    Button btnSalvarPedidoItem;
    Button btnSalvarPedido;
    ListView lstItens;

    Pedido pedidoModel;
    List<Produto> produtosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_efetuar_pedido);

        txtCadPedidoCliente = findViewById(R.id.txtCadPedidoCliente);
        txtCadPedidoPlaca = findViewById(R.id.txtCadPedidoPlaca);
        txtCadPedidoVendedor = findViewById(R.id.txtCadPedidoVendedor);
        txtCadPedidoItemQuantidade = findViewById(R.id.txtCadPedidoItemQuantidade);
        txtCadPedidoItemValor = findViewById(R.id.txtCadPedidoItemValor);
        txtCadPedidoItemTotal = findViewById(R.id.txtCadPedidoItemTotal);
        btnSalvarPedidoItem = findViewById(R.id.btnSalvarPedidoItem);
        btnSalvarPedido = findViewById(R.id.btnSalvarPedido);
        spnProdutos = findViewById(R.id.spnProdutos);
        lstItens = findViewById(R.id.lstItens);

        txtCadPedidoItemTotal.setEnabled(false);

        pedidoModel = new Pedido();
        produtosList = new ArrayList<>();

        Funcoes.getItensFirebase(Funcoes.tabelaProduto,"nome","")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        Produto produtoModel = dataSnapshot.getValue(Produto.class);
                        produtosList.add(produtoModel);
                        atualizarSpinner();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        btnSalvarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarPedido();
            }
        });
        btnSalvarPedidoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarItemPedido();
            }
        });
    }

    private void salvarItemPedido() {
        PedidoItem item = new PedidoItem();
        item.setProduto(produtosList.get(spnProdutos.getSelectedItemPosition()));
        try {
            item.setQuantidade(Double.parseDouble(txtCadPedidoItemQuantidade.getText().toString()));
        } catch (Exception ex) {
            txtCadPedidoItemQuantidade.setError("Quantidade inválida!");
            return;
        }

        item.setValor(Double.parseDouble(txtCadPedidoItemValor.getText().toString()));
        pedidoModel.addItem(item);
        atualizarListItens();
    }

    private void salvarPedido() {
        atualizarObjetoPedido();
        Funcoes.addItemFirebase(Funcoes.tabelaPedido,pedidoModel);
    }

    private void atualizarObjetoPedido() {
        pedidoModel.setNomeCliente(txtCadPedidoCliente.getText().toString());
        pedidoModel.setExecutado(false);
        pedidoModel.setNomeVendedor(txtCadPedidoVendedor.getText().toString());
        pedidoModel.setPlaca(txtCadPedidoPlaca.getText().toString());
    }

    private void atualizarSpinner() {
        String[] strings = new String[produtosList.size()];
        for (int i =0; i < produtosList.size(); i++) {
            strings[i] = produtosList.get(i).getNome() + " - " + produtosList.get(i).getFornecedor();
        }
        setSpinnerItens(strings);
    }

    private void setSpinnerItens(final String[] stringArray) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, stringArray);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spnProdutos.setAdapter(adapter);
    }

    private void atualizarListItens() {
        String[] strings = new String[pedidoModel.getItems().size()];
        PedidoItem item;
        for (int i =0; i < pedidoModel.getItems().size(); i++) {
            item = pedidoModel.getItems().get(i);
            strings[i] = item.getProduto().getNome() + " | Q.: "+item.getQuantidade() + " | V.: "+item.getValor();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, strings);
        lstItens.setAdapter(adapter);
    }

}

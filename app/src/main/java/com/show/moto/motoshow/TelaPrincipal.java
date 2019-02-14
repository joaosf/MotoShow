package com.show.moto.motoshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {

    Button btnEfetuarPedido;
    Button btnConsultarPedido;
    Button btnCadProduto;
    Button btnCadServico;
    Button btnConProduto;
    Button btnConServico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        btnEfetuarPedido = findViewById(R.id.efetuarPedido);
        btnConsultarPedido = findViewById(R.id.consultarPedido);

        btnCadProduto = findViewById(R.id.cadProduto);

        btnConProduto = findViewById(R.id.conProduto);

        btnConProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirConProduto();            }
        });

        btnCadProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadProduto();
            }
        });

        btnEfetuarPedido.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View view) {
             abrirCadPedido();
         }
       });

    }

    private void abrirCadPedido() {
        Intent tela = new Intent(this, EfetuarPedido.class);
        startActivity(tela);
    }


    private void abrirCadProduto() {
        Intent tela = new Intent(this, CadProduto.class);
        startActivity(tela);
    }

    private void abrirConProduto() {
        Intent tela = new Intent(this, CadProduto.class);
        startActivity(tela);
    }
}

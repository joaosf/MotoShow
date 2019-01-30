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
        btnCadProduto = findViewById(R.id.cadProduto);
        btnCadServico = findViewById(R.id.cadServico);
        btnConProduto = findViewById(R.id.conProduto);
        btnConServico = findViewById(R.id.conServico);
        btnConsultarPedido = findViewById(R.id.consultarPedido);

        btnCadServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadServico();
            }
        });
    }

    private void abrirCadServico() {
        Intent tela = new Intent(this, CadServico.class);
        startActivity(tela);
    }
}

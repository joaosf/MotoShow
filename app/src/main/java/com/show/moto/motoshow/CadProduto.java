package com.show.moto.motoshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.show.moto.motoshow.Modelos.Produto;


public class CadProduto extends AppCompatActivity {

    Button btnSalvarCadProduto;
    EditText txtCadProdutoNome;
    EditText txtCadProdutoValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_servico);
        btnSalvarCadProduto = findViewById(R.id.btnSalvarCadProduto);
        txtCadProdutoNome = findViewById(R.id.txtCadProdutoNome);
        txtCadProdutoValor = findViewById(R.id.txtCadProdutoValor);
        btnSalvarCadProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarDados();
            }
        });
    }

    private void salvarDados() {
        Produto produtoModel = new Produto();
        produtoModel.setNome(txtCadProdutoNome.getText().toString());
        produtoModel.setValor((double) 12);

         ///produtoModel.setValor(Double.valueOf(produtoModel.getText().toString()));
        Funcoes.addItemFirebaseProd(Funcoes.tabelaProduto,produtoModel);
    }
}

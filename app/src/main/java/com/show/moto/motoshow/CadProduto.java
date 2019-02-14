package com.show.moto.motoshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.show.moto.motoshow.Modelos.Produto;


public class CadProduto extends AppCompatActivity {

    ListView listView;
    Button btnSalvarCadProduto;
    EditText txtCadProdutoNome;
    EditText txtCadProdutoFornecedor;
    EditText txtCadProdutoValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produto);
        btnSalvarCadProduto = findViewById(R.id.btnSalvarCadProduto);
        txtCadProdutoFornecedor = findViewById(R.id.txtCadProdutoFornecedor);
        txtCadProdutoNome = findViewById(R.id.txtCadProdutoNome);
        txtCadProdutoValor = findViewById(R.id.txtCadProdutoValor);
        listView = findViewById(R.id.listProduto);

        Gerenciador.getInstance().setContext(this);
        Gerenciador.getInstance().setListView(listView);


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
        produtoModel.setValor(Double.parseDouble(txtCadProdutoValor.getText().toString()));
        produtoModel.setFornecedor(txtCadProdutoFornecedor.getText().toString());
        
        Funcoes.addItemFirebaseProd(Funcoes.tabelaProduto,produtoModel);
        Gerenciador.getInstance().atualizarListaProduto();
    }

    @Override
    protected void onResume() {
        super.onResume();
       Gerenciador.getInstance().atualizarListaProduto();
    }
    }

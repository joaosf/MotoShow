package com.show.moto.motoshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.show.moto.motoshow.Modelos.Servico;

public class CadServico extends AppCompatActivity {

    Button btnSalvarCadServico;
    EditText txtCadServicoDescricao;
    EditText txtCadServicoValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_servico);
        btnSalvarCadServico = findViewById(R.id.btnSalvarCadServico);
        txtCadServicoDescricao = findViewById(R.id.txtCadServicoDescricao);
        txtCadServicoValor = findViewById(R.id.txtCadServicoValor);
        btnSalvarCadServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarDados();
            }
        });
    }

    private void salvarDados() {
        Servico servicoModel = new Servico();
        servicoModel.setDescricao(txtCadServicoDescricao.getText().toString());
        servicoModel.setValor(Double.valueOf(txtCadServicoValor.getText().toString()));
        Funcoes.addItemFirebase(Funcoes.tabelaServico,servicoModel);
    }
}

package br.com.festa;

import lombok.Data;

@Data
public class FestaImp implements Festa{
    private int idadeMinima;
    private boolean aberta;
    private String nome;
    //mudar pra Date dps
    private String data;
    private int lotacaoAtual;
    private int lotacaoMaxima;



}

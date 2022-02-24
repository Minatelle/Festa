package br.com.festa;

import lombok.Data;

@Data
public class ConviteImp implements Convite {
    private Pessoa pessoa;
    private Festa festa;
    private String nomeFesta;
    private String dataFesta;

    public ConviteImp(Pessoa pessoa, Festa festa) {
        this.pessoa = pessoa;
        this.festa = festa;
    }
}

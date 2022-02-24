package br.com.festa;

public interface Festa {
    public void setIdadeMinima(int i);

    void setAberta(boolean b);

    void setNome(String festa_de_peao);

    void setData(String s);

    void setLotacaoMaxima(int i);

    void setLotacaoAtual(int i);

    String getNome();

    int getIdadeMinima();

    boolean isAberta();

    String getData();

    int getLotacaoAtual();

    int getLotacaoMaxima();
}

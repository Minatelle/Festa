package br.com.festa;


public class RecepcionistaImp implements Recepcionista {

    final String MENSAGEM_ERRO_IDADE_MINIMA_INVALIDA = "Idade minima invalida";
    final String MENSAGEM_ERRO_ENTRADA_NAO_LIBERADA = "Entrada não liberada";
    final String MENSAGEM_ERRO_FESTA_INVALIDA = "Festa inválida";
    final String MENSAGEM_ERRO_DATA_FESTA_INVALIDA = "Data da festa inválida";
    final String MENSAGEM_ERRO_SEM_VAGAS = "Não há vagas na festa";

    public boolean isAgeValid(Convite convite) throws RuntimeException {

        if (convite.getPessoa().getIdade() >= convite.getFesta().getIdadeMinima())
        {
            return true;
        }else {
            throw new RuntimeException(MENSAGEM_ERRO_IDADE_MINIMA_INVALIDA);
        }
    }

    public boolean isPartyOpen(Convite convite) throws RuntimeException {

        if (convite.getFesta().isAberta())
        {
            return true;
        }else {
            throw new RuntimeException(MENSAGEM_ERRO_ENTRADA_NAO_LIBERADA);
        }
    }

    public boolean isPartyValid(Convite convite) throws RuntimeException {

        if (convite.getFesta().getNome().equals(convite.getNomeFesta())) {
            return true;
        } else {
            throw new RuntimeException(MENSAGEM_ERRO_FESTA_INVALIDA);
        }
    }

    public boolean isPartyDateValid(Convite convite) throws RuntimeException {

        if (convite.getFesta().getData().equals(convite.getDataFesta())) {
            return true;
        } else {
            throw new RuntimeException(MENSAGEM_ERRO_DATA_FESTA_INVALIDA);
        }
    }

    public boolean isPartyFull(Convite convite) throws RuntimeException {

        if (convite.getFesta().getLotacaoAtual() < convite.getFesta().getLotacaoMaxima()) {
            return true;
        } else {
            throw new RuntimeException(MENSAGEM_ERRO_SEM_VAGAS);
        }
    }
}

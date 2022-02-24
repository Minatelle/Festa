package br.com.festa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class RecepcionistaTeste {

    @Test
    public void deveTerIdadeMinimaDezoitoParaFestaDePeao() {
        Recepcionista recepcionista = new RecepcionistaImp();

        //Festa festa = getFesta(18);
        //Pessoa pessoa = getPessoa(21);

        Convite convite = new ConviteImp(getPessoa(21), getFesta(18));

        Assert.isTrue(recepcionista.isAgeValid(convite), "Idade minima para a festa");
    }

    private Pessoa getPessoa(int idade) {
        Pessoa pessoa = new PessoaImp();
        pessoa.setIdade(idade);
        return pessoa;
    }

    private Festa getFesta(int idadeMinima) {
        Festa festa = new FestaImp();
        festa.setIdadeMinima(idadeMinima);
        return festa;
    }

    @Test
    public void naoDeveTerIdadeMinimaDezoitoParaFestaDePeao() {
        Recepcionista recepcionista = new RecepcionistaImp();
        Festa festa = new FestaImp();
        Pessoa pessoa = new PessoaImp();
        Convite convite = new ConviteImp(pessoa, festa);

        festa.setIdadeMinima(18);
        pessoa.setIdade(16);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                    recepcionista.isAgeValid(convite);
                },
                "Idade minima para a festa");

        Assertions.assertEquals(exception.getMessage(), "Idade minima invalida");
    }

    @Test
    public void festaDePeaoAbertaParaEntrada() {
        RecepcionistaImp recepcionista = new RecepcionistaImp();
        Festa festa = new FestaImp();
        Pessoa pessoa = new PessoaImp();
        Convite convite = new ConviteImp(pessoa, festa);

        festa.setAberta(true);
        Assert.isTrue(recepcionista.isPartyOpen(convite), "Entrada liberada");
    }

    @Test
    public void festaDePeaoFechadaParaEntrada() {
        Recepcionista recepcionista = new RecepcionistaImp();
        Festa festa = new FestaImp();
        Pessoa pessoa = new PessoaImp();
        Convite convite = new ConviteImp(pessoa, festa);

        festa.setAberta(false);
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                    recepcionista.isPartyOpen(convite);
                },
                "Entrada não liberada");

        Assertions.assertEquals(exception.getMessage(), "Entrada não liberada");
    }

    @Test
    public void conviteDeveSerParaFestaDePeao() {
        Recepcionista recepcionista = new RecepcionistaImp();
        Festa festa = new FestaImp();
        Pessoa pessoa = new PessoaImp();
        Convite convite = new ConviteImp(pessoa, festa);

        festa.setNome("Festa de Peao");
        convite.setNomeFesta("Festa de Peao");
        Assert.isTrue(recepcionista.isPartyValid(convite), "Festa válida");
    }

    @Test
    public void conviteNaoDeveSerParaFestaDePeao() {
        Recepcionista recepcionista = new RecepcionistaImp();
        Festa festa = new FestaImp();
        Pessoa pessoa = new PessoaImp();
        Convite convite = new ConviteImp(pessoa, festa);

        festa.setNome("Festa de Peao");
        convite.setNomeFesta("Rave do Peao");
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                    recepcionista.isPartyValid(convite);
                },
                "Festa inválida");

        Assertions.assertEquals(exception.getMessage(), "Festa inválida");
    }

    @Test
    public void conviteComDataCorretaParaFestaDePeaoHoje() {
        Recepcionista recepcionista = new RecepcionistaImp();
        Festa festa = new FestaImp();
        Pessoa pessoa = new PessoaImp();
        Convite convite = new ConviteImp(pessoa, festa);
        festa.setData("24/02/2022");
        convite.setDataFesta("24/02/2022");
        Assert.isTrue(recepcionista.isPartyDateValid(convite), "Data da festa válida");
    }

    @Test
    public void conviteSemDataCorretaParaFestaDePeaoHoje() {
        Recepcionista recepcionista = new RecepcionistaImp();
        Festa festa = new FestaImp();
        Pessoa pessoa = new PessoaImp();
        Convite convite = new ConviteImp(pessoa, festa);
        festa.setData("24/02/2022");
        convite.setDataFesta("01/03/2022");
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                    recepcionista.isPartyDateValid(convite);
                },
                "Data da festa inválida");

        Assertions.assertEquals(exception.getMessage(), "Data da festa inválida");
    }

    @Test
    public void deveTerVagasNaFestaDePeao() {
        Recepcionista recepcionista = new RecepcionistaImp();
        Festa festa = new FestaImp();
        Pessoa pessoa = new PessoaImp();
        Convite convite = new ConviteImp(pessoa, festa);
        festa.setLotacaoMaxima(5000);
        festa.setLotacaoAtual(3000);
        Assert.isTrue(recepcionista.isPartyFull(convite), "Há vagas na festa");
    }

    @Test
    public void naoDeveTerVagasNaFestaDePeao() {
        Recepcionista recepcionista = new RecepcionistaImp();
        Festa festa = new FestaImp();
        Pessoa pessoa = new PessoaImp();
        Convite convite = new ConviteImp(pessoa, festa);
        festa.setLotacaoMaxima(5000);
        festa.setLotacaoAtual(5000);
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                    recepcionista.isPartyFull(convite);
                },
                "Não há vagas na festa");

        Assertions.assertEquals(exception.getMessage(), "Não há vagas na festa");
    }


}

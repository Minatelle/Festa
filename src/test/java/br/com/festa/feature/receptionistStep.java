package br.com.festa.feature;
import br.com.festa.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class receptionistStep {

    int idade;
    String dataHoje;
    String dataFesta;
    Boolean conviteValido;

    @Given("um cliente de {int} anos de idade")
    public void idade(int idade) {
        this.idade = idade;
    }

    @And("hoje é {String}")
    public void dataHoje(String dataHoje) {
        this.dataHoje = dataHoje;
    }

    @And("está com um convite válido para uma festa que inicia no dia {String}")
    public void dataFesta(String dataFesta) {
        this.dataFesta = dataFesta;
    }

    @When("o recepcionista receber o convite e validá-lo")
    public void validarCovite() {
        Recepcionista recepcionista = new RecepcionistaImp();
        Festa festa = new FestaImp();
        festa.setData(dataFesta);

        Pessoa pessoa = new PessoaImp();
        pessoa.setIdade(idade);

        Convite convite = new ConviteImp(pessoa, festa);
        convite.setDataFesta(dataHoje);

        conviteValido = recepcionista.isPartyDateValid(convite);
    }

    @Then("a seguinte mensagem deve ser exibida: \"A festa ainda não foi iniciada\"")
    public void mensagemResposta() {
        if(conviteValido == false)
            System.out.println("A festa ainda não foi iniciada");
        else
            throw new RuntimeException("Teste falhou");
    }
}

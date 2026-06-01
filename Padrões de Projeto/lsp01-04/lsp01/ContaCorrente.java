package lsp01;

public class ContaCorrente implements  SaqueSemTaxa, Deposito {
    private ContaBancaria contaBancaria;

    ContaCorrente() {
        this.contaBancaria = new ContaBancaria();
    }

    public void sacar(double valor) {
        sacarSemTaxa(valor);
    }

    @Override
    public void sacarSemTaxa(double valor) {
        contaBancaria.sacar(valor);
    }

    @Override
    public void depositar(double valor) {
        contaBancaria.depositar(valor);
    }

    public double getSaldo(){
        return contaBancaria.getSaldo();
    }
}

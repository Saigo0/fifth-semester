package ex02;

public interface IFolhaPagamento {
    double calcularSalarioBruto(int funcionarioId);

    double calcularDescontos(int funcionarioId);

    void gerarContracheque(int funcionarioId, int mes, int ano);

    void pagarSalario(int funcionarioId, double salario);
}

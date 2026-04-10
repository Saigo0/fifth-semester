package abstractfactory2.fiat;

import abstractfactory2.abstractFactory.CarroSedan;

public class PalioSedan implements CarroSedan {
    @Override
    public void exibirInfoSedan() {
        System.out.println("Modelo: Fiesta\nFábrica:Ford\nCategoria:Sedan");
    }

    private int bagageiro;
    private int rack;

    @Override
    public void colocarBagagem(int kg) throws Exception {

        if (kg+bagageiro <= 300) {
            bagageiro+=kg;
        } else if(kg+bagageiro+rack <= 400 && kg+rack <=100) {
            rack+=kg;
        } else{
            throw new Exception("Excesso de peso");
        }
    }

    @Override
    public int getKgBagageiro() {
        return bagageiro;
    }
}

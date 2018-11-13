package Perceptron;

import java.util.ArrayList;

public class Neuronio {
	private int qtd;
	ArrayList<Double> entradas;
	ArrayList<Double> pesos;
	private int saida;
	private int saidaEsperada;
	private double erro;
	private static final double taxaAprendizado = 0.3;
	private static final int limiar = 0;
	
	public Neuronio(int Qtd){
		this.qtd = Qtd;
		
		//recebendo as entradas como parametro
		entradas = new ArrayList<>(qtd);
		
		//inicializando o array de pesos
		pesos = new ArrayList<>(qtd);
		
		for (int i = 0; i < qtd; i++) {
			pesos.add(i, 0.0);
		}
	}
	
	public ArrayList<Double> getEntradas() {
		return entradas;
	}
	public void setEntradas(ArrayList<Double> entradas) {
		this.entradas = entradas;
	}
	public ArrayList<Double> getPesos() {
		return pesos;
	}
	public void setPesos(ArrayList<Double> pesos) {
		this.pesos = pesos;
	}
	public int getSaida() {
		return saida;
	}
	public void setSaida(int saida) {
		this.saida = saida;
	}
	public int getSaidaEsperada() {
		return saidaEsperada;
	}
	public void setSaidaEsperada(int saidaEsperada) {
		this.saidaEsperada = saidaEsperada;
	}
	public double getErro() {
		return erro;
	}
	
	
	
	
	public void ativador(){
		double somatorio = 0;
		for (int i = 0; i < qtd; i++) {
			somatorio += (entradas.get(i) * pesos.get(i));
		}
		
		//teste com limiar 0 no lugar de 2
		
		if(somatorio > limiar)
			saida = 1;
		else 
			saida = 0;
	}
	
	public void recalculaPesos(){
		double novop = 0;
		for (int i = 0; i < qtd; i++) {
			novop = pesos.get(i) + taxaAprendizado * erro * entradas.get(i);
			pesos.set(i,novop);
		}
	}
	
	public void calculaErro(){
		erro = saidaEsperada - saida;
		if(erro != 0){
			recalculaPesos();
		}
	}
	
}

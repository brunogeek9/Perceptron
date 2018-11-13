package Perceptron;

import java.util.ArrayList;
import java.util.Scanner;

public class Perceptron {
	private int tamanhoBase;
	private int qtdAtributos;
	private Neuronio mcp;
	private int interacao;
	private ArrayList<ArrayList<Double>> base;
	private ArrayList<Integer> saidaDesejada;
	private Scanner ent;
	
	public Perceptron(){
		base = new ArrayList<ArrayList<Double>>(tamanhoBase);
		saidaDesejada = new ArrayList<>(tamanhoBase);
		ent = new Scanner(System.in);
	}
	
	public void iniciar() {
		System.out.println("Informe a quantidade de atributos");
		qtdAtributos = ent.nextInt();
		
		System.out.println("Informe o tamanho da base");
		tamanhoBase = ent.nextInt();
		
		mcp = new Neuronio(qtdAtributos);
	}
	
	public void iniciaBase(){
		ArrayList<Double> entrada;
		
		//setando os atributos da base
		for (int i = 0; i < tamanhoBase; i++) {
			entrada = new ArrayList<>(qtdAtributos);
			System.out.println("Instancia "+i);
			for (int j = 0; j < qtdAtributos; j++) {
				System.out.println("Informe o atributo "+j);
				entrada.add(j,ent.nextDouble());
			}
			base.add(entrada);
		}
		
		//setando as saidas esperadas
		for (int i = 0; i < tamanhoBase; i++) {
			System.out.println("Saida esperada "+i);
			saidaDesejada.add(i,ent.nextInt());
		}
	}
	
	public void mostraBase(){
		int cont = 0;
		for (ArrayList<Double> arrayList : base) {
			System.out.println("instancia "+(cont++));
			for (Double d : arrayList) {
				System.out.println("Elemento "+d);
			}
		}
	}
	
	public void treinar() {
		System.out.println("treinando a rede");
		double erroTotal = 0;
		interacao = 0;
		do {
			interacao++;
			erroTotal = 0;
			for (int i = 0; i < tamanhoBase; i++) {
				mcp.setEntradas(base.get(i));
				mcp.setSaidaEsperada(saidaDesejada.get(i));
				mcp.ativador();
				mcp.calculaErro();
				erroTotal = erroTotal + Math.abs(mcp.getErro());
			}
			System.out.println("Interacao "+interacao);
			System.out.println("Erro total "+erroTotal);
			System.out.println("Saida atual "+mcp.getSaida());
		} while (erroTotal != 0);
	}
	
	public void executar(){
		System.out.println("------Adicionando uma nova instancia ao neuronio-----");
		ArrayList<Double> novo = new ArrayList<>(qtdAtributos);
		
		for (int i = 0; i < qtdAtributos; i++) {
			System.out.println("Informe o atributo "+i);
			novo.add(i,ent.nextDouble());
			mcp.setEntradas(novo);
		}
		
		mcp.ativador();
		System.out.println("A saida foi "+mcp.getSaida());
	}
}

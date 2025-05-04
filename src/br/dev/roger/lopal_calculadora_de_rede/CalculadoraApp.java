package br.dev.roger.lopal_calculadora_de_rede;

import br.dev.roger.lopal_calculadora_de_rede.model.ClassificarIP;
import br.dev.roger.lopal_calculadora_de_rede.model.EnderecoIP;

public class CalculadoraApp {
	public static void main(String[] args) {
		EnderecoIP endereco = new EnderecoIP();
		endereco.setEnderecoIP("192.168.0.5/24");

		ClassificarIP calc = new ClassificarIP();
		calc.setEnderecoIP(endereco.getEnderecoIP());

		System.out.println("IP: " + endereco.getIP());
		System.out.println("CIDR: /" + endereco.getCIDR());
		System.out.println("Classe: " + calc.ClassificarRede());
		System.out.println("Máscara: " + calc.calcularMascaraDecimal());
		System.out.println("Máscara (binária): " + calc.converterDecimalParaBinario());
		System.out.println("Nº de hosts: " + calc.CalcularHosts());
	}
}

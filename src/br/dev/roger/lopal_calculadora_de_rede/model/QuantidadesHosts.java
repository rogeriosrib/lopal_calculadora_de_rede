package br.dev.roger.lopal_calculadora_de_rede.model;

public class QuantidadesHosts {

	private String EnderecoIP;

	public QuantidadesHosts(String ipDigitado) {
		EnderecoIP = ipDigitado;

	}

	public String redeInicial() {

		String[] inicial = EnderecoIP.split("/");
		if (inicial.length > 0) {
			return inicial[0];
		} else {
			return "invalido";
		}

	}

	public String primeiroHost() {

		String[] partes = redeInicial().split("\\.");
		int ultimoOcteto = Integer.parseInt(partes[3]);
		int primeiroHost = ultimoOcteto + 1;
		return partes[0] + "." + partes[1] + "." + partes[2] + "." + primeiroHost;

	}

	public String ultimoHost(int hostCalculado) {

		String[] partes = redeInicial().split("\\.");
		int ultimoOcteto = Integer.parseInt(partes[3]);
		int ultimoHost = ultimoOcteto + hostCalculado;
		return partes[0] + "." + partes[1] + "." + partes[2] + "." + ultimoHost;

	}
	
	public String broadcast(int hostCalculado) {
		String[] partes = redeInicial().split("\\.");
		int ultimoOcteto = Integer.parseInt(partes[3]);
		int broadcast = ultimoOcteto + hostCalculado + 1;
		return partes[0] + "." + partes[1] + "." + partes[2] + "." + broadcast;
	}
	

}

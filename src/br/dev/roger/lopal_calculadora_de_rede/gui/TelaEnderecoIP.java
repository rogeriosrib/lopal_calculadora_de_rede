package br.dev.roger.lopal_calculadora_de_rede.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.roger.lopal_calculadora_de_rede.model.ClassificarIP;
import br.dev.roger.lopal_calculadora_de_rede.model.QuantidadesHosts;

public class TelaEnderecoIP {

	private JTextField caixa;
	private JLabel informacao;
	private JButton confirmar;
	private JButton limpar;
	private JLabel classificar;
	private JLabel mascaraDecimal;
	private JLabel mascaraBinaria;
	private JLabel redeInicial;
	private JLabel tamanhoEscopo;
	private JLabel escopoIP;
	private JLabel broadcast;

	public void criarTelaEnderecoIP() {

		JFrame tela = new JFrame();
		Dimension tamanho = new Dimension();
		tamanho.setSize(460, 350);
		tela.setSize(tamanho);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Enderacamento de IP");
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);

		caixa = new JTextField();
		caixa.setBounds(30, 50, 390, 30);

		informacao = new JLabel();
		informacao.setText("Informe o IP desejado com CIDR");
		informacao.setBounds(30, 20, 390, 30);

		confirmar = new JButton();
		confirmar.setText("Confirmar");
		confirmar.setBounds(30, 85, 180, 30);

		limpar = new JButton();
		limpar.setText("limpar");
		limpar.setBounds(240, 85, 180, 30);

		classificar = new JLabel();
		classificar.setText("Classificação : ");
		classificar.setBounds(30, 125, 390, 30);

		mascaraDecimal = new JLabel();
		mascaraDecimal.setText("Mascara Decimal : ");
		mascaraDecimal.setBounds(30, 145, 390, 30);

		mascaraBinaria = new JLabel();
		mascaraBinaria.setText("Mascara Binaria : ");
		mascaraBinaria.setBounds(30, 165, 390, 30);

		redeInicial = new JLabel();
		redeInicial.setText("IP Inicial da rede : ");
		redeInicial.setBounds(30, 185, 390, 30);

		tamanhoEscopo = new JLabel();
		tamanhoEscopo.setText("Quantidade de hosts : ");
		tamanhoEscopo.setBounds(30, 205, 390, 30);
		
		escopoIP = new JLabel();
		escopoIP.setText("escopo de IP's : ");
		escopoIP.setBounds(30, 225, 390, 30);

		broadcast = new JLabel();
		broadcast.setText("Broadcast : ");
		broadcast.setBounds(30, 245, 390, 30);

		confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ipDigitado = caixa.getText();
				ClassificarIP classificador = new ClassificarIP();
				classificador.setEnderecoIP(ipDigitado);
				QuantidadesHosts quantidade = new QuantidadesHosts(ipDigitado);
				
				String Decimal = classificador.calcularMascaraDecimal();
				String decimalParaBinario = classificador.converterDecimalParaBinario();
				int hostCalculado = classificador.CalcularHosts();
				

				classificar.setText("Classificacao : " + classificador.ClassificarRede());
				mascaraDecimal.setText("Mascara Decimal : " + Decimal);
				mascaraBinaria.setText("Mascara Binaria : " + decimalParaBinario);
				redeInicial.setText("IP Inicial da rede : " + quantidade.redeInicial());
				tamanhoEscopo.setText("Quantidade de hosts : " + classificador.CalcularHosts());
				escopoIP.setText("escopo de IP's : " + quantidade.primeiroHost() + " ate o " + quantidade.ultimoHost(hostCalculado));
				broadcast.setText("Broadcast : " + quantidade.broadcast(hostCalculado));
			}
		});
		
		limpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				caixa.setText(null);
				classificar.setText("Classificação : ");
				mascaraDecimal.setText("Máscara Decimal : ");
				mascaraBinaria.setText("Máscara Binária : ");
				redeInicial.setText("IP Inicial da rede : ");
				tamanhoEscopo.setText("Quantidade de hosts : ");
				escopoIP.setText("escopo de IP's : ");
				broadcast.setText("Broadcast : ");
				
				
			}
		});

		tela.getContentPane().add(caixa);
		tela.getContentPane().add(informacao);
		tela.getContentPane().add(confirmar);
		tela.getContentPane().add(limpar);
		tela.getContentPane().add(classificar);
		tela.getContentPane().add(mascaraDecimal);
		tela.getContentPane().add(mascaraBinaria);
		tela.getContentPane().add(redeInicial);
		tela.getContentPane().add(tamanhoEscopo);
		tela.getContentPane().add(escopoIP);
		tela.getContentPane().add(broadcast);

		tela.setVisible(true);
	}

}
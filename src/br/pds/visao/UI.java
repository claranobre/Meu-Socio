package br.pds.visao;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI {
	private JFrame janela;
	private JFrame sjanela;
	private Container painelPrincipal;

	/**
	 * Main e MontaTela
	 */

	private void preparaJanela() {
		janela = new JFrame("Meu Socio");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sjanela = new JFrame("Feed");
		sjanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void mostraJanela() {
		janela.pack();
		janela.setSize(540, 540);
		janela.setVisible(true);

		sjanela.pack();
		sjanela.setSize(540, 540);
	}

	public static void main(String[] args) {
		new UI().montaTela();
	}

	private void montaTela(){
		preparaJanela();
		preparaPainelPrincipal();
		preparaBotao();
		mostraJanela();
	}
	
	private void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);
	}

	private void preparaBotao() {
		JButton botaoEntrar = new JButton("Entrar");
		botaoEntrar.setBounds(130,100,270,400);
		
		botaoEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sjanela.setVisible(true);
			}
		});
		painelPrincipal.add(botaoEntrar);
	}
}
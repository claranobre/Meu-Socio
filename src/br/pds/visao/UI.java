package br.pds.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI extends JFrame implements ActionListener {
	private JFrame janela;
	private JFrame jfeed;
	
	public UI() {
		
		super("Meu Sócio");
		
		janela = new JFrame("Feed");
		janela.pack();
		janela.setSize(540, 540);
		
		Container c = getContentPane();
		//c.setLayout(new BorderLayout(15,5));
		
		JButton botaoEntrar = new JButton("Entrar");
		getContentPane().add(botaoEntrar);
		botaoEntrar.setBackground(Color.WHITE);
		c.add(BorderLayout.SOUTH, botaoEntrar);
		botaoEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(true);
			}
		});
		
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(4,1));
		c2.add(new JButton("Menu"));
		//c.add(BorderLayout.CENTER, new JButton("centro"));
		//c.add(BorderLayout.EAST, c2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 400);
		setVisible(true);

	}
	
	/**
	 * Main
	 */
	public static void main(String[] argvs) {
		new UI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

/**
 * JLabel simples = new JLabel("Label Teste");
 * simples.setToolTipText("Meu Label");
 */

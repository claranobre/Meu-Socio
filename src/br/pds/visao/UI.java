<<<<<<< HEAD
package br.pds.visao;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class UI extends JFrame implements ActionListener {
	private JFrame janela;
	private JDesktopPane desktop;
	private Button bOk;
	private TextField cp1, cp2;
	private Label tx1, tx2;
	private Panel p1 = new Panel();
	private Panel p2 = new Panel();

	/*
	 * protected void initialize() { this.image =
	 * this.getImage("/images/torcedor1.jpg"); this.setLayout(new BorderLayout()); }
	 * 
	 * public Image getImage(String path) { URL imageURL =
	 * getClass().getResource(path); if (imageURL == null) return null; return new
	 * ImageIcon(imageURL).getImage(); }
	 * 
	 * public void paintComponent(Graphics g) { super.paintComponents(g); Dimension
	 * dDesktop = this.getSize(); double width = dDesktop.getWidth(); double height
	 * = dDesktop.getHeight(); Image background = new
	 * ImageIcon(this.image.getScaledInstance( (int) width, (int) height,
	 * 1)).getImage(); g.drawImage(background, 0, 0, this); }
	 */

	public UI() {
		super("Meu S�cio");

		desktop = new JDesktopPane() {
			Image image = (new ImageIcon("images/torcedor1.jpg")).getImage();

			public void paintComponent(Graphics g) {
				g.drawImage(image, 0, 0, this);
			}
		};

		janela = new JFrame("Feed");
		janela.pack();
		janela.setSize(540, 540);

		Container c = getContentPane();

		JButton botaoEntrar = new JButton("Entrar");
		getContentPane().add(botaoEntrar);
		botaoEntrar.setBackground(Color.WHITE);
		c.add(BorderLayout.SOUTH, botaoEntrar);
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(true);
			}
		});

		tx1 = new Label("Nome:");
		cp1 = new TextField(15);
		tx2 = new Label("Email");
		cp2 = new TextField(15);
		bOk = new Button("Ok");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 400);
		setVisible(true);

		JMenuBar barra = new JMenuBar();
		JMenu menu = new JMenu("Menu");

		JMenuItem usuario = new JMenuItem("Usuario");
		JMenuItem cadastro = new JMenuItem("Cadastro");

		menu.add(usuario);
		menu.add(cadastro);
		cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela = new JFrame("Cadastro");
				// janela.setLayout(new GridLayout(2,1));
				janela.setLayout(new FlowLayout(FlowLayout.LEFT));
				janela.setSize(300, 300);
				janela.setVisible(true);

				p1.setLayout(new GridLayout(2, 2));
				p2.setLayout(new FlowLayout(FlowLayout.LEFT));

				p1.add(tx1);
				p1.add(cp1);

				p2.add(tx2);
				p2.add(cp2);
				p2.add(bOk);

				janela.add(p1);
				janela.add(p2);
			}
		});
		barra.add(menu);

		janela.setJMenuBar(barra);

	}

	/**
	 * Main
	 */
	public static void main(String[] argvs) {
		new UI();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

/**
 * JLabel simples = new JLabel("Label Teste"); simples.setToolTipText("Meu
 * Label");
 */
=======
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
		
		super("Meu S�cio");
		
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
>>>>>>> branch 'master' of https://github.com/claranobre/Meu-Socio.git

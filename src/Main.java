package com.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Main {
	private static final JPanel panel = new JPanel();
	static Font font;
	
	static int mss = 10, sss = 10; 
	static int msss = 100;
	
	static Timer timr = new Timer(); 
	static Tir tir = new Tir();
	static JLabel m = new JLabel("10:");
	static JLabel s = new JLabel("10");
	static JLabel ms = new JLabel(".000");
	static JTextField ans = new JTextField();
	static JButton submit = new JButton("Submit");
	static String sc;
	static JTextArea code = new JTextArea();
	public static void main(String[] args) {
		// 48 -> 57 : Number
		// 65 -> 90 : Uppercase
		// 97 -> 122: Lowercase
		
		timr.scheduleAtFixedRate(tir, 0, 1);
		Random rd = new Random();
		List<Character> c = new ArrayList<Character>();
		for (int i = 0; i<=3; i++) {
			if (i == 1) {
				for (int j1 = 48; j1<=57; j1++) {
					c.add(new Character((char) j1));
				}
			} else if (i == 2) {
				for (int j1 = 65; j1<=90; j1++) {
					c.add(new Character((char) j1));
				}
			} else if (i ==3) {
				for (int j1 = 97; j1<=122; j1++) {
					c.add(new Character((char) j1));
				}
			}
		}
		char ascii[] = new char[c.size()];
		for (int i = 0; i < c.size(); i++) {
			ascii[i] = c.get(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<=45; i++) {
			sb.append(ascii[rd.nextInt(ascii.length)]);
		}
		
		sc = sb.toString();
		sb.delete(0, sc.length());
		int[] cti = new int[sc.length()];
		for (int i = 0; i<sc.length(); i++) {
			cti[i] = (int) sc.charAt(i);
			sb.append(Integer.toString(cti[i], 16));
		}
		BigInteger bi = new BigInteger(sb.toString(), 16);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("Font\\OCRAEXT.ttf"));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Listener l = new Listener();

		JFrame f = new JFrame();
		f.setTitle("Decode Challenge");
		f.setResizable(false);
		f.setAlwaysOnTop(true);
		f.setSize(416, 183);
		f.setLocation(500, 300);
		f.setDefaultCloseOperation(3);
		f.getContentPane().setLayout(null);
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 410, 154);
		f.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Time: ");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(new Color(0, 255, 127));
		lblNewLabel.setBounds(0, 0, 110, 32);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(font.deriveFont(25f));
		m.setForeground(new Color(0, 255, 0));


		m.setVerticalAlignment(SwingConstants.TOP);
		m.setBounds(82, 0, 69, 32);
		m.setFont(font.deriveFont(25f));
		panel.add(m);
		s.setForeground(new Color(0, 255, 0));


		s.setVerticalAlignment(SwingConstants.TOP);
		s.setBounds(127, 0, 69, 32);
		s.setFont(font.deriveFont(25f));

		panel.add(s);
		ms.setForeground(new Color(0, 255, 0));
		ms.setVerticalAlignment(SwingConstants.TOP);
		ms.setBounds(161, 3, 130, 42);
		ms.setFont(font.deriveFont(20f));
		panel.add(ms);
		ans.setBackground(new Color(0, 0, 0));
		ans.setForeground(new Color(0, 255, 0));
		ans.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		
		ans.setBorder(new LineBorder(new Color(0, 255, 0)));
		ans.setBounds(10, 112, 293, 20);
		panel.add(ans);
		ans.setColumns(10);
		submit.setForeground(new Color(0, 255, 0));
		submit.setBackground(new Color(0, 0, 0));
		submit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		submit.addActionListener(l);
		submit.setBounds(313, 112, 77, 20);
		panel.add(submit);
		
		
		code.setBackground(new Color(0, 0, 0));
		code.setForeground(new Color(0, 255, 0));
		code.setFont(new Font("Consolas", Font.BOLD, 15));
		code.setEditable(false);
		code.setLineWrap(true);
		code.setBounds(10, 43, 380, 61);
		code.setText(bi.toString());
		panel.add(code);

		f.setVisible(true);
	}
}

class Tir extends TimerTask {
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
			Main.msss-=1;
			Main.ms.setText("."+String.format("%03d", Main.msss));
			
			if (Main.msss < 0) {
				
				Main.sss--;
				Main.s.setText(String.format("%02d", Main.sss));
				Main.msss=999;
			}
			if (Main.sss<=0) {
				
				Main.mss--;
				if (Main.mss <= 0) {
					Main.timr.cancel();
					Main.code.setFont(Main.font.deriveFont(50f));
					
					Main.code.setText("You Lose!");
					Main.ans.disable();
					Main.submit.disable();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0);
				}
				Main.m.setText(String.format("%02d", Main.mss)+":");
				Main.sss=59;
			}
		
	}
}

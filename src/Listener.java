package com.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {
	static String result = Main.sc;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(Main.submit)) {
			if (Main.ans.getText().equals(result)) {
				Main.timr.cancel();
				Main.code.setFont(Main.font.deriveFont(50f));
				
				
				try {
					Thread.sleep(1);
					Main.code.setText("You Win!");
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
				
				
			}
		}
		
	}
	

}

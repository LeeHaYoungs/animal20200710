package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JLabel;

public class bookiingComplete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frame f = new Frame("");
		f.setBounds(100, 100, 400, 500);
		//f.setBackground(Color.orange);

		Font font = new Font("�������", Font.BOLD, 20);

		// ���ʴ�
		Panel pNorth = new Panel();
		Label bookingComplete = new Label("���Ό��Ϸ�");
		pNorth.add(bookingComplete);
		pNorth.setFont(font);

		// �߾�
		Panel pCenter = new Panel();
//		JLabel date = new JLabel("<html>��¥, �ð� : <br>");
//		JLabel animalName = new JLabel("������ : ");
//		JLabel personName = new JLabel("��ȣ�ڸ� : ");
//		JLabel personPhone = new JLabel("��ȣ�ڿ���ó : ");
		JLabel arr = new JLabel();
		String data = "<html><br><br> ��¥, �ð� :"+
		"<br><br>������ : "+"<br><br>��ȣ�ڸ� : "+"<br><br>��ȣ�ڿ���ó : ";
		
		arr.setText(data);
		arr.setFont(font);
		
//		pCenter.add(date);
//		pCenter.add(animalName);
//		pCenter.add(personName);
//		pCenter.add(personPhone);

		pCenter.add(arr);
		// ���ʴ�
		Panel pSouth = new Panel();
		//pSouth.setFont(font);
		Button menu = new Button("����ȭ������");
		//menu.setBounds(400, 400, 400, 600);
		menu.setFont(new Font("�������", Font.BOLD, 30));

		pSouth.add(menu);

		f.add(pNorth, BorderLayout.NORTH);
		f.add(pCenter, BorderLayout.CENTER);
		f.add(pSouth, BorderLayout.SOUTH);
		f.setVisible(true);
		f.setResizable(false);
	}

}

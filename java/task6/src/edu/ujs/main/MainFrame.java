package edu.ujs.main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.GroupLayout;
import javax.swing.JFrame;

import edu.ujs.listener.*;


/**
 * 
 * @author luca
 *
 */
public class MainFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("学生信息管理系统");
		Dimension d=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int width=400;
		int height=300;
		frame.setBounds((d.width-width)/2, (d.height-height)/2, width, height);
		
		//目录
		MenuBar menuBar = new MenuBar();
		Menu fileMenu=new Menu("File");
		MenuItem openMenuItem=new MenuItem("open");
		MenuItem saveMenuItem=new MenuItem("save");
		MenuItem closeMenuItem=new MenuItem("close");
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(closeMenuItem);
		
		Menu versionMenu=new Menu("Version");
		versionMenu.add("the version is 1.0");
		versionMenu.add("Author:lurk");
		
		menuBar.add(fileMenu);
		menuBar.add(versionMenu);
		frame.setMenuBar(menuBar);
		
		/*主体内容*/
		
		frame.setLayout(new GridLayout(10,1));
		//空行
		/*
		frame.add(new Panel());
		frame.add(new Panel());
		frame.add(new Panel());
		*/
		TextArea imfoTextArea=new TextArea(50,25);
		//imfoTextArea.setBounds(10, 10, 20, 50);
		imfoTextArea.setSize(20, 5);
		
		imfoTextArea.setEnabled(false);
		imfoTextArea.setEditable(false);
		//imfoTextArea.ov
		
		Panel imfoPanel=new Panel();
		//imfoPanel.setSize(50, 30);
		imfoPanel.add(imfoTextArea);
		frame.add(imfoPanel);
		
		
		frame.add(new Panel());
		
		Label idLabel=new Label("   ID   ",Label.CENTER);
		TextField idField = new TextField(20);
		Panel idPanel=new Panel();
		idPanel.add(idLabel);
		idPanel.add(idField);
		frame.add(idPanel);
		
		Label nameLabel=new Label("Name",Label.CENTER);
		TextField nameField = new TextField(20);
		Panel namePanel=new Panel();
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		frame.add(namePanel);
		
		Label scoreLabel=new Label("Score",Label.CENTER);
		TextField scoreField = new TextField(20);
		Panel scorePanel=new Panel();
		scorePanel.add(scoreLabel);
		scorePanel.add(scoreField);
		frame.add(scorePanel);
		
		Label teleLabel=new Label(" Tele ",Label.CENTER);
		TextField teleField = new TextField(20);
		Panel telePanel=new Panel();
		telePanel.add(teleLabel);
		telePanel.add(teleField);
		frame.add(telePanel);
		
		
		//按钮
		Panel buttonPanel=new Panel();
		Button preButton=new Button("  pre  ");
		Button nextButton=new Button("  next  ");
		Button insertButton=new Button("  insert  ");
		Button deleteButton=new Button("  delete  ");
		buttonPanel.add(preButton);
		buttonPanel.add(nextButton);
		buttonPanel.add(insertButton);
		buttonPanel.add(deleteButton);
		
		frame.add(buttonPanel);
		
		Button queryButton=new Button("query");
		TextField queryField=new TextField(20);
		Panel queryPanel=new Panel();
		queryPanel.add(queryButton);
		queryPanel.add(queryField);
		frame.add(queryPanel);
		
		queryButton.addActionListener(new QueryListener(idField, nameField, scoreField, teleField, imfoTextArea,queryField));
		openMenuItem.addActionListener(new OpenListener(idField, nameField, scoreField, teleField, imfoTextArea));
		saveMenuItem.addActionListener(new SaveListener(idField,nameField,scoreField,teleField,imfoTextArea));
		
		
		insertButton.addActionListener(new InsertListener(idField,nameField,scoreField,teleField,imfoTextArea));
		preButton.addActionListener(new PreListener(idField,nameField,scoreField,teleField,imfoTextArea));
		nextButton.addActionListener(new NextListener(idField,nameField,scoreField,teleField,imfoTextArea));
		deleteButton.addActionListener(new DeleteListener(idField,nameField,scoreField,teleField,imfoTextArea));
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}

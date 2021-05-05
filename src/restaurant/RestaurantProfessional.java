package restaurant;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class RestaurantProfessional extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final JScrollPane scrollPane = new JScrollPane();
	private static final JScrollPane scrollPaneMessages = new JScrollPane();
	private static JLabel resaLabel, countResa, name, messageLabel;
	private static JTable message;
	private static Vector<String> columnMessages;
	private static DefaultTableModel modelMessages;
	
	public RestaurantProfessional() {
		setBounds(10,0,1480, 790);
		setLayout(null);

		Font font16 = new Font("Comic Sans MS", Font.BOLD, 16);
		resaLabel = new JLabel("Reservations : ");
		resaLabel.setBounds(50, 150, 150,20);
		resaLabel.setFont(font16);
    	add(resaLabel);
		scrollPane.setBounds(10,200,1450,180);
		scrollPane.setPreferredSize(new Dimension(1480,180));
		add(scrollPane);
		scrollPaneMessages.setBounds(10,460,1450,180);
		scrollPaneMessages.setPreferredSize(new Dimension(1480,180));
		add(scrollPaneMessages);
		countResa = new JLabel();
    	countResa.setBounds(170, 151, 150,20);
    	countResa.setFont(font16);
    	add(countResa);
    	messageLabel = new JLabel("Messages : ");
    	messageLabel.setBounds(50, 410, 150,30);
    	messageLabel.setFont(font16);
    	add(messageLabel);
    	name= new JLabel();
    	name.setBounds(50,50,400,40);
    	name.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
    	add(name);
    	
	}
	
	public static void update(Restaurant restaurant) {
		name.setText(restaurant.getName()+" : ");
		scrollPaneMessages.getViewport().setView(getMessagesTable(Message.getAllMessages(restaurant.getName())));

	}
	
	public static JTable getMessagesTable(ArrayList<Message> messages) {
		
		message = new JTable();
		
		columnMessages = new Vector<String>();
		columnMessages.addElement("Nom");
		columnMessages.addElement("Prénom");
		columnMessages.addElement("Sujet");
		columnMessages.addElement("Commentaire");
		columnMessages.addElement("Téléphone");
		columnMessages.addElement("Email");
		columnMessages.addElement("Date");
	    
		modelMessages = new DefaultTableModel(getRowDataMessages(messages),columnMessages);
		message.setModel(modelMessages);
		setTableStyleMessages();
     
		JTableHeader header = message.getTableHeader();
		DefaultTableCellRenderer renderer;
		header.setFont(new Font("Comic Sans MS",Font.BOLD, 16));
		renderer = (DefaultTableCellRenderer)message.getTableHeader().getDefaultRenderer();
	    renderer.setHorizontalAlignment(JLabel.CENTER);
		
		return message;	
	}
	
	private static Vector<Vector<String>> getRowDataMessages(ArrayList<Message> messages) {
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		for(Message message : messages) {
			Vector<String> rows = new Vector<String>();
			rows.addElement(message.getName());
			rows.addElement(message.getLastName());
			rows.addElement(message.getSubject());
			rows.addElement(message.getComment());
			rows.addElement(message.getPhone());
			rows.addElement(message.getEmail());
			rows.addElement(String.valueOf(message.getDate()));
			
		    rowData.add(rows);
		}
		return rowData;
		
	}
	
	private static void setTableStyleMessages() {
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	
	    message.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
	    message.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
	    message.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
	    message.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
	    message.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
	    message.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
	    message.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
	    message.setRowHeight(25);
	    message.setGridColor(Color.BLACK);
	    message.setRowSelectionAllowed(false);//disable the online blue 
	    message.setEnabled(false);//can't edit table
	    message.setFont(new Font("Comic Sans MS",Font.PLAIN, 15));
	}
	

}
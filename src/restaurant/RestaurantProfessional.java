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
	private static JTable resa, message;
	private static Vector<String> columnNames, columnMessages;
	private static DefaultTableModel model, modelMessages;
	private static JLabel nbrResa, countResa, name, messageLabel, nbrMessage;
	
	public RestaurantProfessional() {
		setBounds(10,0,1480, 790);
		setLayout(null);

		Font font16 = new Font("Comic Sans MS", Font.BOLD, 16);
		nbrResa = new JLabel("Réservations : ");
    	nbrResa.setBounds(50, 150, 150,20);
    	nbrResa.setFont(font16);
    	add(nbrResa);
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
    	nbrMessage = new JLabel();
    	nbrMessage.setBounds(150, 415, 150,20);
    	nbrMessage.setFont(font16);
    	add(nbrMessage);
    	name= new JLabel();
    	name.setBounds(50,50,400,40);
    	name.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
    	add(name);
    	
	}
	
	public static void update(Restaurant restaurant) {
		name.setText(restaurant.getName()+" : ");
		nbrMessage.setText(String.valueOf(Message.count(restaurant.getName())));
		scrollPane.getViewport().setView(getReservationTable(Reservation.getAllReservationsFroARestaurant(restaurant.getName())));
		scrollPaneMessages.getViewport().setView(getMessagesTable(Message.getAllMessages(restaurant.getName())));
		countResa.setText(String.valueOf(Reservation.count(restaurant.getName())));
	}
	
	public static JTable getReservationTable(ArrayList<Reservation> reservations) {
			
			resa = new JTable();
			
			columnNames = new Vector<String>();
		    columnNames.addElement("Nom");
		    columnNames.addElement("Prénom");
		    columnNames.addElement("Nombre");
		    columnNames.addElement("Date");
		    columnNames.addElement("Heure");
		    columnNames.addElement("Téléphone");
		    columnNames.addElement("Email");
		    
			model = new DefaultTableModel(getRowData(reservations),columnNames);
			resa.setModel(model);
			setTableStyle();
	     
			JTableHeader header = resa.getTableHeader();
			DefaultTableCellRenderer renderer;
			header.setFont(new Font("Comic Sans MS",Font.BOLD, 16));
			renderer = (DefaultTableCellRenderer)resa.getTableHeader().getDefaultRenderer();
		    renderer.setHorizontalAlignment(JLabel.CENTER);
			
			return resa;	
	}
	
	private static Vector<Vector<String>> getRowData(ArrayList<Reservation> reservations) {
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		for(Reservation reservation : reservations) {
			Vector<String> rows = new Vector<String>();
			rows.addElement(reservation.getName());
			rows.addElement(reservation.getLastName());
			rows.addElement(String.valueOf(reservation.getNbrReservation()));
			rows.addElement(String.valueOf(reservation.getDate()));
			rows.addElement(String.valueOf(reservation.getHour()));
			rows.addElement(reservation.getPhone());
			rows.addElement(reservation.getEmail());
			
		    rowData.add(rows);
		}
		return rowData;
		
	}
	
	private static void setTableStyle() {
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		resa.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		resa.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		resa.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		resa.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		resa.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		resa.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		resa.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		resa.setRowHeight(25);
		resa.setGridColor(Color.BLACK);
		resa.setRowSelectionAllowed(false);//disable the online blue 
		resa.setEnabled(false);//can't edit table
		resa.setFont(new Font("Comic Sans MS",Font.PLAIN, 15));
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

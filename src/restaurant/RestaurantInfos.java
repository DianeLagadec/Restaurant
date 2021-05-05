package restaurant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class RestaurantInfos extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static JLabel name, contact,phone ,mail, phoneLabel, mailLabel, localization, city, cityLable, adress, adressLabel;
	private static JLabel products, doggy, label, labelInfo, zipCode, infos, doggyBag, localProducts, noteLabel, noteValue;
	private static JLabel platNameLabel , platName;
	private static final JScrollPane scrollPaneNote = new JScrollPane();
	private static final JScrollPane scrollPanePlat = new JScrollPane();
    private static DefaultTableModel modelNote, modelPlat;
    private static Vector<String> columnNameNote, columnNamePlat;
    private static JTable note, plat;
    private static JButton sendMessage, reservation, notation;
    private static Restaurant restaurantFinal;
    
    public RestaurantInfos() {
		Font font14 = new Font("Comic Sans MS", Font.PLAIN, 14);
		Font font16 = new Font("Comic Sans MS", Font.BOLD, 16);
		setBounds(10,0,1480, 790);
		setLayout(null);
		
		noteValue = new JLabel();
		name = new JLabel();
		platName= new JLabel();
		adressLabel = new JLabel();
		cityLable = new JLabel();
		zipCode = new JLabel();
		noteLabel = new JLabel("Notes : ");
		platNameLabel = new JLabel("Plat : ");
		platNameLabel.setBounds(50,430,100,20);
		platNameLabel.setFont(font16);
		zipCode.setBounds(520, 162, 150, 20);
		cityLable.setBounds(580, 162, 150, 20);
		contact = new JLabel("Contact : ");
		phone = new JLabel("Téléhone : ");
		mail = new JLabel("Email : ");
		localization = new JLabel("Localisation : "); 
		city = new JLabel("Ville :" );
		adress =  new JLabel("Adresse : ");
		adress.setBounds(480, 130, 150, 20);
		adressLabel.setBounds(550, 132, 250, 20);
		adress.setFont(font14);
		city.setFont(font14);
		city.setBounds(480, 160, 150, 20);
		phoneLabel = new JLabel();
		mailLabel = new JLabel();
		name.setBounds(50,50,400,40);
		name.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		contact.setBounds(50,100,100,20);
		localization.setBounds(480,100,150,20);
		localization.setFont(font16);
		contact.setFont(font16);
    	phone.setBounds(50,130,100,20);
    	phone.setFont(font14);
    	mail.setBounds(50,160,100,20);
    	mail.setFont(font14);
    	mailLabel.setBounds(110, 162, 300, 20);
    	phoneLabel.setBounds(130, 132, 100, 20);
    	infos = new JLabel("Information : ");
    	infos.setBounds(800,100,150,20);
    	infos.setFont(font16);
    	doggyBag = new JLabel("Doggy Bag : ");
    	doggyBag.setBounds(800,130,150,20);
    	doggyBag.setFont(font14);
    	localProducts = new JLabel("Produits Locaux : ");
    	localProducts.setBounds(800,160,150,20);
    	localProducts.setFont(font14);
    	products = new JLabel();
    	products.setBounds(930,160,150,20);
    	doggy = new JLabel();
    	doggy.setBounds(930,130,150,20);
    	label = new JLabel("Label : ");
    	label.setBounds(1050,130,150,20);
    	platName.setBounds(100,430,100,20);
    	platName.setFont(font16);
    	label.setFont(font14);
    	labelInfo = new JLabel();
    	labelInfo.setBounds(1100,130,150,20);
    	scrollPaneNote.setBounds(10,260,1450,160);
    	scrollPaneNote.setPreferredSize(new Dimension(1480,140));
    	scrollPanePlat.setBounds(10,470,1450,160);
    	scrollPanePlat.setPreferredSize(new Dimension(1480,140));
    	noteLabel.setBounds(50,220,100,20);
    	noteLabel.setFont(font16);
    	noteValue.setBounds(120,220,100,20);
    	noteValue.setFont(font16);
    	sendMessage = new JButton("Envoyer un message");
    	sendMessage.setBounds(200,670,200,30);
    	add(sendMessage);
		reservation = new JButton("Reservation");
		reservation.setBounds(620,670,200,30);
		add(reservation);
		notation = new JButton("Notation");
		notation.setBounds(1080,670,200,30);
		add(notation);
		
		add(noteValue);
    	add(noteLabel);
    	add(scrollPaneNote);
    	add(scrollPanePlat);
    	add(labelInfo);
    	add(label);
    	add(doggy);
    	add(products);
    	add(name);
    	add(contact);
    	add(phone);
    	add(mail);
    	add(phoneLabel);
    	add(mailLabel);
    	add(localization);
    	add(city);
    	add(adress);
    	add(adressLabel);
    	add(cityLable);
    	add(zipCode);
    	add(infos);
    	add(doggyBag);
    	add(localProducts);
    	add(platNameLabel);
    	add(platName);
    	
    	notation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Notation");
	    	}	
		});
    	
    	sendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.sendMessageForm(restaurantFinal);
				App.setVisibilityToSendMessage();
	    	}	
		});
    	
	
		
    }  
    	
    	
    public static void update(Restaurant restaurant) {
		restaurantFinal = restaurant;
		name.setText(restaurant.getName()+ " : ");
		phoneLabel.setText(restaurant.getPhone());
		mailLabel.setText(restaurant.getMail());
		cityLable.setText(restaurant.getCity());
		zipCode.setText(restaurant.getZipCode() +", ");
		adressLabel.setText(restaurant.getAdress());
		doggy.setText(restaurant.getDoggyBag() == false ? "No" : "Yes");
		products.setText(restaurant.getLocalProducts() == false ? "No" : "Yes");
		labelInfo.setText(restaurant.getLabel());
		noteValue.setText(String.valueOf(Note.getAverage(restaurant.getName())+" / 5"));
		platName.setText(Plat.getPlatNameForARestaurant(restaurant.getName()));
		scrollPaneNote.getViewport().setView(getNoteTable(Note.getNoteByRestaurantName(restaurant.getName())));
		scrollPanePlat.getViewport().setView(getPlatTable(Plat.getAllPlatForARestaurant(restaurant.getName())));
		
		
		
	}
	
	private static Vector<Vector<String>> getRowDataNotes(ArrayList<Note> notes) {
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		for(Note note : notes) {
			Vector<String> rows = new Vector<String>();
			rows.addElement(note.getName());
			rows.addElement(String.valueOf(note.getNote()));
			rows.addElement(String.valueOf(note.getComment()));
			rows.addElement(String.valueOf(note.getDate()));
			
		    rowData.add(rows);
		}
		return rowData;
		
	}
	
	private static void setTableNoteStyle() {
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		note.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		note.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		note.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		note.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		note.setRowHeight(25);
		note.setGridColor(Color.BLACK);
		note.setRowSelectionAllowed(false);//disable the online blue 
		note.setEnabled(false);//can't edit table
		note.setFont(new Font("Comic Sans MS",Font.PLAIN, 15));
	}
	
	public static JTable getNoteTable(ArrayList<Note> notes) {
		
		note = new JTable();
		
		columnNameNote = new Vector<String>();
		columnNameNote.addElement("Nom");
		columnNameNote.addElement("Note");
		columnNameNote.addElement("Commantaire");
		columnNameNote.addElement("Date");
	    
		modelNote = new DefaultTableModel(getRowDataNotes(notes),columnNameNote);
		note.setModel(modelNote);
		setTableNoteStyle();
     
		JTableHeader header = note.getTableHeader();
		DefaultTableCellRenderer renderer;
		header.setFont(new Font("Comic Sans MS",Font.BOLD, 16));
		renderer = (DefaultTableCellRenderer)note.getTableHeader().getDefaultRenderer();
	    renderer.setHorizontalAlignment(JLabel.CENTER);
		
		return note;	
	}
	
	private static Vector<Vector<String>> getRowDataPlats(ArrayList<Plat> plats) {
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		for(Plat plat : plats) {
			Vector<String> rows = new Vector<String>();
			rows.addElement(plat.getName());
			rows.addElement(plat.getSeasonal()== false ? "Non" : "Oui");
			rows.addElement(String.valueOf(plat.getOrigin()));
			rows.addElement(plat.getFamily());
			rows.addElement(plat.getType());
			rows.addElement(plat.getGroup());
			
		    rowData.add(rows);
		}
		return rowData;	
	}
	
	public static JTable getPlatTable(ArrayList<Plat> plats) {
			
			plat = new JTable();
			
			columnNamePlat = new Vector<String>();
			columnNamePlat.addElement("Nom");
			columnNamePlat.addElement("De saison");
			columnNamePlat.addElement("Origine");
			columnNamePlat.addElement("Famille");
			columnNamePlat.addElement("Type");
			columnNamePlat.addElement("Groupe");
			
			
		    
			modelPlat = new DefaultTableModel(getRowDataPlats(plats),columnNamePlat);
			plat.setModel(modelPlat);
			setTablePlatStyle();
	     
			JTableHeader header = plat.getTableHeader();
			DefaultTableCellRenderer renderer;
			header.setFont(new Font("Comic Sans MS",Font.BOLD, 16));
			renderer = (DefaultTableCellRenderer)plat.getTableHeader().getDefaultRenderer();
		    renderer.setHorizontalAlignment(JLabel.CENTER);
			
			return plat;	
		}
	
	private static void setTablePlatStyle() {
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		plat.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		plat.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		plat.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		plat.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		plat.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		plat.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		plat.setRowHeight(25);
		plat.setGridColor(Color.BLACK);
		plat.setRowSelectionAllowed(false);//disable the online blue 
		plat.setEnabled(false);//can't edit table
		plat.setFont(new Font("Comic Sans MS",Font.PLAIN, 15));
	}
}

	



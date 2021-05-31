package restaurant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Home extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static JScrollPane scrollPane;
    private static JTable table;
    private static DefaultTableModel model;
    private static Vector<String> columnNames;
    private static JLabel research, citylabel, regimelabel,labelslabel, locallabel, doggylabel, Title, Slogan ;
	private static DefaultComboBoxModel<String> listCities, listRegimes, listLabels, listLocals, listDoggy;
	private static JComboBox<String> city, regime, label, local, doggy;
	private static Set<String> localSet, doggySet;
	private static final ArrayList<String> regimes = new ArrayList<String>();
	private static final ArrayList<String> labels = new ArrayList<String>();
	private static final ArrayList<String> cities = new ArrayList<String>();
	
	public Home() {
		
    	setBounds(0,0,1480, 790);
    	setLayout(null);
    	init();
    	
    	
    	Font font30 = new Font("Comic Sans MS", Font.BOLD, 30);
    	Font font16 = new Font("Comic Sans MS", Font.BOLD, 16);
		Font font14 = new Font("Comic Sans MS", Font.PLAIN, 14);
		
		Title = new JLabel("BON APPETIT");
		Title.setBounds(600,20,400,30);
		Title.setFont(font30);
		Title.setForeground(Color.GREEN);
    	add(Title);
    	
    	Slogan = new JLabel("Mangez mieux, mangez plus écoresponsables !!!");
		Slogan.setBounds(550,40,400,30);
		Slogan.setFont(font14);
		Slogan.setForeground(Color.PINK);
    	add(Slogan);
		
		research = new JLabel("Recherchez votre restaurant :");
		research.setBounds(10,60,400,30);
		research.setFont(font16);
    	add(research);
    	
    	citylabel = new JLabel("Ville : ");
    	citylabel.setBounds(10, 110, 150,30);
    	citylabel.setFont(font14);
    	add(citylabel);
    	
    	cities.addAll(Restaurant.getAllCities());
    	cities.add(0,"-");
    	city = new JComboBox<String>();
    	city.setBounds(60,110,150,30);
		listCities = new DefaultComboBoxModel<String>(); 
		listCities.addAll(cities);
		city.setModel(listCities);
		city.setSelectedIndex(0);
		add(city);
		
		regimelabel = new JLabel("Régime alimentaire : ");
    	regimelabel.setBounds(220, 110, 150,30);
    	regimelabel.setFont(font14);
    	add(regimelabel);
		
    	regimes.addAll(Restaurant.getAllRegimes());
    	regimes.add(0,"-");
    	regime = new JComboBox<String>();
    	regime.setBounds(360,110,150,30);
    	listRegimes = new DefaultComboBoxModel<String>(); 
    	listRegimes.addAll(regimes);
		regime.setModel(listRegimes);
		regime.setSelectedIndex(0);
		add(regime);
		
		labelslabel = new JLabel("Label : ");
    	labelslabel.setBounds(520, 110, 150,30);
    	labelslabel.setFont(font14);
    	add(labelslabel);
    	
    	labels.addAll(Restaurant.getAllLabels());
    	labels.add(0,"-");
    	label = new JComboBox<String>();
    	label.setBounds(570,110,150,30);
    	listLabels = new DefaultComboBoxModel<String>(); 
    	listLabels.addAll(labels);
    	label.setModel(listLabels);
    	label.setSelectedIndex(0);
		add(label);
		
		locallabel = new JLabel("Nourriture locale : ");
    	locallabel.setBounds(730, 110, 150,30);
    	locallabel.setFont(font14);
    	add(locallabel);
		
    	local = new JComboBox<String>();
    	local.setBounds(860,110,150,30);
		localSet = new TreeSet<String>();
    	listLocals = new DefaultComboBoxModel<String>(); 
    	localSet.add("No");
    	localSet.add("Yes");
    	localSet.add("-");
    	listLocals.addAll(localSet);
    	local.setModel(listLocals);
    	local.setSelectedIndex(0);
		add(local);
		
		doggylabel = new JLabel("Doggy Bag : ");
    	doggylabel.setBounds(1020, 110, 150,30);
    	doggylabel.setFont(font14);
    	add(doggylabel);
		
		doggy = new JComboBox<String>();
		doggy.setBounds(1100,110,150,30);
		doggySet = new TreeSet<String>();
		listDoggy = new DefaultComboBoxModel<String>(); 
		doggySet.add("Yes");
		doggySet.add("No");
		doggySet.add("-");
    	listDoggy.addAll(doggySet);
    	doggy.setModel(listDoggy);
    	doggy.setSelectedIndex(0);
		add(doggy);
		
		JButton goButton = new JButton("Rechercher");
		goButton.setBounds(1260,110,200,30);
			
		add(goButton);
    	
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String city1 = (String)city.getSelectedItem();
				String diet1 = (String)regime.getSelectedItem();
				String label1 = (String)label.getSelectedItem();
				String local1 = (String)local.getSelectedItem();
				String doggy1 = (String)doggy.getSelectedItem();
								
				model.setDataVector(getRowData(Restaurant.getRestaurantsWithArgs(city1,diet1,label1,local1,doggy1)), columnNames);
				setTableStyle();
		
	    	}	
		});
	}
	
	public static void refreshHomePage() {
		model.setDataVector(getRowData(Restaurant.getAllRestaurants()), columnNames);
		listCities.removeAllElements();
		ArrayList<String> cityList = new ArrayList<String>();
		cityList.add(0,"-");
		listCities.addAll(cityList);
		listCities.addAll(Restaurant.getAllCities());
		city.setSelectedIndex(0);
		
		listRegimes.removeAllElements();
		ArrayList<String> regimesList = new ArrayList<String>();
		regimesList.add(0,"-");
		listRegimes.addAll(regimesList);
		listRegimes.addAll(Restaurant.getAllRegimes());
		regime.setSelectedIndex(0);
		
		listLabels.removeAllElements();
		ArrayList<String> labelList = new ArrayList<String>();
		labelList.add(0,"-");
		listLabels.addAll(labelList);
		listLabels.addAll(Restaurant.getAllLabels());
		label.setSelectedIndex(0);
		setTableStyle();
		
		
	}
    	
	public void init() {
    	ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    	restaurants = Restaurant.getAllRestaurants();
		scrollPane = new JScrollPane(getRestaurantTable(restaurants));
		scrollPane.setPreferredSize(new Dimension(1480,440));
		scrollPane.setBounds(10,200,1400,480);
		add(scrollPane);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col == 0) {
		        	RestaurantInfos.update(Restaurant.getRestaurantByName(String.valueOf(table.getValueAt(row, col))));
		        	App.setVisibilityRestaurantInfo();		        	
		        }
		    }
		});
		
		        
	}
    
    public JTable getRestaurantTable(ArrayList<Restaurant> restaurants) {
    	
		table = new JTable();
		
		columnNames = new Vector<String>();
	    columnNames.addElement("Nom");
	    columnNames.addElement("Adresse");
	    columnNames.addElement("Ville");
	    columnNames.addElement("Régime");
	    columnNames.addElement("Label");
	    columnNames.addElement("Produits Locaux");
	    columnNames.addElement("Doggy Bag");
	    
		model = new DefaultTableModel(getRowData(restaurants),columnNames);
		table.setModel(model);
		setTableStyle();
     
		
		JTableHeader header = table.getTableHeader();
		DefaultTableCellRenderer renderer;
		header.setFont(new Font("Comic Sans MS",Font.BOLD, 16));
		renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
	    renderer.setHorizontalAlignment(JLabel.CENTER);
		
		return table;	
	}
    
	private static  Vector<Vector<String>> getRowData(ArrayList<Restaurant> restaurants) {
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		for(Restaurant restaurant : restaurants) {
			Vector<String> rows = new Vector<String>();
			rows.addElement(restaurant.getName());
			rows.addElement(restaurant.getAdress());
			rows.addElement(restaurant.getCity());
			rows.addElement(restaurant.getDiet());
			rows.addElement(restaurant.getLabel());
			rows.addElement(restaurant.getLocalProducts() == false ? "No" : "Yes");
			rows.addElement(restaurant.getDoggyBag() == false ? "No" : "Yes");
			
		    rowData.add(rows);
		}
		return rowData;
		
	}
	
	private static void setTableStyle() {
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		table.setRowHeight(35);
		table.setGridColor(Color.BLACK);
		table.setRowSelectionAllowed(false);//disable the online blue 
		table.setEnabled(false);//can't edit table
		table.setFont(new Font("Comic Sans MS",Font.PLAIN, 15));
	}

}

package restaurant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
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
    private static JLabel research;
	private static DefaultComboBoxModel<String> listCities, listRegimes, listLabels, listLocals, listDoggy;
	private static JComboBox<String> city, regime, label, local, doggy;
	private static Set<String> localSet, doggySet;
	private static JButton goButton;

	
	public Home() {
		
    	setBounds(10,0,1480, 790);
    	setLayout(null);
    	init();
    	
    	Font font16 = new Font("Comic Sans MS", Font.BOLD, 16);
		Font font14 = new Font("Comic Sans MS", Font.PLAIN, 14);
		
		research = new JLabel("Recherchez votre restaurant :");
		research.setBounds(10,20,400,30);
		research.setFont(font16);
    	add(research);
    	
    	ArrayList<String> cities = Restaurant.getAllCities();
    	city = new JComboBox<String>();
    	city.setBounds(10,50,150,30);
		listCities = new DefaultComboBoxModel<String>(); 
		listCities.addAll(cities);
		city.setModel(listCities);
		city.setSelectedIndex(0);
		add(city);
		
    	ArrayList<String> regimes = Restaurant.getAllRegimes();
    	regime = new JComboBox<String>();
    	regime.setBounds(170,50,150,30);
    	listRegimes = new DefaultComboBoxModel<String>(); 
    	listRegimes.addAll(regimes);
		regime.setModel(listRegimes);
		regime.setSelectedIndex(0);
		add(regime);
		
    	ArrayList<String> labels = Restaurant.getAllLabels();
    	label = new JComboBox<String>();
    	label.setBounds(330,50,150,30);
    	listLabels = new DefaultComboBoxModel<String>(); 
    	listLabels.addAll(labels);
    	label.setModel(listLabels);
    	label.setSelectedIndex(0);
		add(label);
		
    	local = new JComboBox<String>();
    	local.setBounds(490,50,150,30);
		localSet = new TreeSet<String>();
    	listLocals = new DefaultComboBoxModel<String>(); 
    	localSet.add("No");
    	localSet.add("Yes");
    	listLocals.addAll(localSet);
    	local.setModel(listLocals);
    	local.setSelectedIndex(0);
		add(local);
		
		doggy = new JComboBox<String>();
		doggy.setBounds(650,50,150,30);
		doggySet = new TreeSet<String>();
		listDoggy = new DefaultComboBoxModel<String>(); 
		doggySet.add("No");
		doggySet.add("Yes");
    	listDoggy.addAll(doggySet);
    	doggy.setModel(listDoggy);
    	doggy.setSelectedIndex(0);
		add(doggy);
		
		JButton goButton = new JButton("Rechercher");
		goButton.setBounds(1100,50,200,30);
			
		add(goButton);
    	
	}
    	
	public void init() {
    	ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    	restaurants = Restaurant.getAllRestaurants();
		scrollPane = new JScrollPane(getRestaurantTable(restaurants));
		scrollPane.setPreferredSize(new Dimension(1480,440));
		scrollPane.setBounds(10,140,1450,480);
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
    
	private  Vector<Vector<String>> getRowData(ArrayList<Restaurant> restaurants) {
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
	
	private void setTableStyle() {
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		table.setRowHeight(25);
		table.setGridColor(Color.BLACK);
		table.setRowSelectionAllowed(false);//disable the online blue 
		table.setEnabled(false);//can't edit table
		table.setFont(new Font("Comic Sans MS",Font.PLAIN, 15));
	}

}

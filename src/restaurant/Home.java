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

public class Home extends JPanel {
	private static final long serialVersionUID = 1L;
	private static JScrollPane scrollPane;
    private static JTable table;
    private static DefaultTableModel model;
    private static Vector<String> columnNames;
	
	public Home() {
		
    	setBounds(10,0,1480, 790);
    	setLayout(null);
    	init();
    	
	}
    	
    public void init() {
    	ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    	restaurants = Restaurant.getAllRestaurants();
		scrollPane = new JScrollPane(getRestaurantTable(restaurants));
		scrollPane.setPreferredSize(new Dimension(1480,440));
		scrollPane.setBounds(10,140,1450,480);
		add(scrollPane);
		
		    };
    
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

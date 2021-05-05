package restaurant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class RestaurantPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static DefaultComboBoxModel<String> listModel;
	private static JComboBox<String> jComboBox1;
	
	public RestaurantPanel(){
		setBounds(10,0,1480, 790);
		setLayout(null);
		init();
		
	}
	
	public void init() {
		ArrayList<String> names = Restaurant.getAllNames();
		jComboBox1 = new JComboBox<String>();
		jComboBox1.setBounds(240,50,200,30);
		listModel = new DefaultComboBoxModel<String>(); 
		listModel.addAll(names);
		jComboBox1.setModel(listModel);
		jComboBox1.setSelectedIndex(0);
		add(jComboBox1);
		JButton goButton = new JButton("Rechercher");
		goButton.setBounds(1100,50,200,30);
				
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestaurantProfessional.update(Restaurant.getRestaurantByName(String.valueOf(jComboBox1.getSelectedItem())));
				App.setVisibilityRestaurantProfessional();
				
	    	}	
		});
			
		add(goButton);
	}
}


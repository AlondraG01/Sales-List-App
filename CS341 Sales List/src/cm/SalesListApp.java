package cm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SalesListApp {

	private JFrame frame;
	private JTextField textFieldItem;
	private JTextField textFieldCost;
	private JTextField textFieldQty;
	private JTextField outputTotalSales;
	private JTextArea outputList;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesListApp window = new SalesListApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SalesListApp() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		lblNewLabel.setBounds(151, 11, 135, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(46, 50, 52, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cost: $");
		lblNewLabel_2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(46, 83, 52, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity:");
		lblNewLabel_3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(46, 121, 57, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		textFieldItem = new JTextField();
		textFieldItem.setBounds(118, 51, 190, 20);
		frame.getContentPane().add(textFieldItem);
		textFieldItem.setColumns(10);
		
		textFieldCost = new JTextField();
		textFieldCost.setBounds(118, 86, 104, 20);
		frame.getContentPane().add(textFieldCost);
		textFieldCost.setColumns(10);
		
		textFieldQty = new JTextField();
		textFieldQty.setBounds(118, 122, 104, 20);
		frame.getContentPane().add(textFieldQty);
		textFieldQty.setColumns(10);
		
		btn = new JButton("Add Item to sales list");
		btn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		btn.setBounds(106, 147, 225, 23);
		frame.getContentPane().add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 176, 332, 54);
		frame.getContentPane().add(scrollPane);
		
		outputList = new JTextArea();
		scrollPane.setViewportView(outputList);
		
		JLabel lblNewLabel_4 = new JLabel("Total Sales:");
		lblNewLabel_4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(46, 241, 99, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		outputTotalSales = new JTextField();
		outputTotalSales.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		outputTotalSales.setBounds(118, 237, 104, 20);
		frame.getContentPane().add(outputTotalSales);
		outputTotalSales.setColumns(10);
	}
	
	private void createEvents() {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutput();
			}
		});
	}

	private void buildOutput() {
		//instantiate to SalesSlip class
		SalesSlip groceryList = new SalesSlip();
		
		String item = textFieldItem.getText();
		Double price = Double.parseDouble(textFieldCost.getText());
		Integer qty = Integer.parseInt(textFieldQty.getText());
		
		groceryList.addNewItem(new SalesItem("Choco Waffles", 10.45, 4));
		groceryList.addNewItem(new SalesItem("Caramel Soda", 2.20, 1));
		groceryList.addNewItem(new SalesItem("Wheat Tortilla", 3.50, 1));
		groceryList.addNewItem(new SalesItem(item, price, qty));
		
		outputList.setText(groceryList.toString());
		outputTotalSales.setText(groceryList.addTotal());
	}
	
}

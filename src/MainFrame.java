import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.CardLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;





@SuppressWarnings("serial")
public class MainFrame extends JFrame implements Serializable {
	JDateChooser dateChooser1Report;
	JDateChooser dateChooser2Report;
	@SuppressWarnings("rawtypes")
	JList listReport3;
	JButton btnEditInvoProce;
	boolean editableInvoice=false;
	static ArrayList<String>itemsComboConditions;
	//******************PANELS**************************//
	private JPanel contentPane;
	private JPanel mainPanelOnFrame;
	private JPanel panelCardForm;
	private JPanel cardFormPanel;
	private JPanel addPatientForm;
	private JPanel addHistoryForm;
	private JPanel addProceduresInvoicesForm;
	private JPanel panel_infoCardLayout;
	private JPanel panelHistoryInfo;
	private JPanel panelInvoiceProcedures;
	private JPanel panelPatientInformation ;
	private JPanel panelInvoicesInfo; 
	private JPanel panelProceduresInfo;
	//******************PANELS**************************//


	//*******COMPONENTS ON THE addPatientForm**********//
	private JLabel lbPatientIdNum;
	private JLabel lPatientName;
	private JLabel lPatientAddress;
	private JLabel lPatientPhone;

	private JTextField tPatientIdNum;
	private JTextField tPatientName;
	private JTextField tPatientAddress;
	private JTextField tPatientPhone;

	private JButton btnSubmitPatient;
	private JButton btnEditPatientForm;
	private JButton btnDelatePatientInfo;
	//*******COMPONENTS ON THE addPatientForm**********//

	//*******COMPONENTS ON THE addHistoryForm**********//
	private JLabel lHistoryPatientName;
	private JLabel lblPatientIdNo;
	private JLabel lblCondition;
	private JLabel lblDateOccured;
	private JLabel lblMedication ;

	private JTextField tHistoryPatientName;
	private JTextField tHistoryPatientIdNo;
	private JDateChooser tHistorydateChooser;
	private JTextField tHistoryMedication;

	private JButton btnSubmitHistory;
	private JButton btnEditHistory;
	private JButton btnDelateHistory;

	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxCondition;
	private SortedComboBoxModel modelComboBoxCondition;

	//*******COMPONENTS ON THE addHistoryForm**********//

	//*******COMPONENTS ON THE addProceduresInvoicesForm*********//
	private JLabel lblName;
	private JLabel lblIdNo;
	private JLabel lblDate;
	private JLabel lblPaidYn;
	private JLabel lblTotal;

	private JTextField tInvoicesPatientName;
	private JTextField tInvoicesPatientIdNo;
	private JTextField tInvoiceTotal;

	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxInvoicePaidYN;
	private JDateChooser dateChooserInvoices;
	private JScrollPane scrollPane_4;
	@SuppressWarnings("rawtypes")
	private JList listInvProcedureLeft;
	private JScrollPane scrollPane_5;
	@SuppressWarnings("rawtypes")
	private JList listInvProcedureRight;

	private JButton btSubmitInvoices;
	private JButton btnMove;
	private JButton btnDelateInvoice;
	//*******COMPONENTS ON THE addProceduresInvoicesForm**********//	

	private static final long serialVersionUID = 1L;


	public static int checkStatus=0;
	private boolean editable= false;
	private boolean editableHistory; 
	private JMenuItem mainteanceDelateProc;


	static LinkedList<String> listOfProcedures= new LinkedList<String>();

	private static ArrayList<Patient>xx= new ArrayList<Patient>();
	private Patient patient= new Patient();
	private static PatientList patientList= new PatientList();

	private SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");


	


	//****TABLE MODELS****//
	@SuppressWarnings("rawtypes")
	private DefaultListModel listModelLeft;
	private DefaultTableModel tm4Invoice;
	private DefaultTableModel tm3Invoices;
	private DefaultTableModel tm2History;
	private  DefaultTableModel tm1=new DefaultTableModel();
	//****TABLE MODELS****//



	//****Inner Classes***//
	TheHandler2 handlerChangeForms= new TheHandler2();
	TheHandler handler= new TheHandler();
	//****Inner Classes***//

	private JCalendar calendarPatient;
	private JButton btnPatient; 
	private JButton btnHistory;
	private JButton btnInvoicesprocedures;

	private JTable table1PatientInfo;
	private JTable tableHistoryInfo;
	private JTable tableInvoicesInfo;
	private JTable table_2;


	private JMenuBar menuBar;
	private JMenu mnFile;
	private JCheckBoxMenuItem chckbxmntmSerializable;
	private JCheckBoxMenuItem chckbxmntmNonserializable;
	private JCheckBoxMenuItem chckbxmntmDatabase;
	private JMenu mnMainteance;
	private JMenuItem mainteanceAddProc;


	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {


					MainFrame frame = new MainFrame();

					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
					int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
					int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
					frame.setLocation(x, y);

					frame.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}


		});

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			public void run() {
				// Do what you want when the application is stopping
				if(checkStatus==1){
					System.out.println("jest to jest");

					save();

				}	
			}
		}));

	}






	public MainFrame()  {

		setTitle("Dental Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/pictures/dentist.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 760);




		mainFrameWindow();

		System.out.println(listOfProcedures);



	}

	public void components(){

	}
	public void addPatientForm(){

		addPatientForm = new JPanel();
		addPatientForm.setBorder(new TitledBorder(null, "Patient", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cardFormPanel.add(addPatientForm, "name_1362673790524429000");
		addPatientForm.setLayout(null);

		lbPatientIdNum = new JLabel("Id No.");
		lbPatientIdNum.setBounds(30, 58, 61, 16);
		addPatientForm.add(lbPatientIdNum);

		lPatientName = new JLabel("Name");
		lPatientName.setBounds(30, 98, 61, 16);
		addPatientForm.add(lPatientName);

		lPatientAddress = new JLabel("Address");
		lPatientAddress.setBounds(30, 140, 61, 16);
		addPatientForm.add(lPatientAddress);

		lPatientPhone = new JLabel("Phone");
		lPatientPhone.setBounds(30, 174, 61, 16);
		addPatientForm.add(lPatientPhone);

		tPatientIdNum = new JTextField();
		tPatientIdNum.setEditable(false);
		tPatientIdNum.setBounds(130, 52, 210, 28);
		addPatientForm.add(tPatientIdNum);
		tPatientIdNum.setColumns(10);

		tPatientName = new JTextField();
		tPatientName.setBounds(130, 92, 210, 28);
		addPatientForm.add(tPatientName);
		tPatientName.setColumns(10);

		tPatientAddress = new JTextField();
		tPatientAddress.setBounds(130, 128, 210, 28);
		addPatientForm.add(tPatientAddress);
		tPatientAddress.setColumns(10);

		tPatientPhone = new JTextField();
		tPatientPhone.setBounds(130, 168, 210, 28);
		addPatientForm.add(tPatientPhone);
		tPatientPhone.setColumns(10);

		//************ACTION EVENT LISTENER********************

		btnSubmitPatient = new JButton("Submit");
		btnSubmitPatient.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/submit.png")));
		btnSubmitPatient.addActionListener(handler );

		btnSubmitHistory = new JButton("Submitt");
		btnSubmitHistory.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/submit.png")));
		btnSubmitHistory.addActionListener(handler);


		//************ACTION EVENT LISTENER**********************

		btnSubmitPatient.setBounds(130, 208, 117, 44);
		addPatientForm.add(btnSubmitPatient);

		btnEditPatientForm = new JButton("Edit");
		btnEditPatientForm.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/edituser-12007.png")));
		btnEditPatientForm.addActionListener(handler);
		btnEditPatientForm.setBounds(284, 208, 117, 44);
		addPatientForm.add(btnEditPatientForm);

		btnDelatePatientInfo = new JButton("Delate");
		btnDelatePatientInfo.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/3.png")));
		btnDelatePatientInfo.addActionListener(handler);
		btnDelatePatientInfo.setBounds(440, 208, 117, 44);
		addPatientForm.add(btnDelatePatientInfo);


	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addHistoryForm(){

		addHistoryForm = new JPanel();
		addHistoryForm.setBorder(new TitledBorder(null, "History", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cardFormPanel.add(addHistoryForm, "name_1362673849663415000");
		addHistoryForm.setLayout(null);

		lHistoryPatientName = new JLabel("Patient Name\n");
		lHistoryPatientName.setBounds(30, 61, 100, 16);
		addHistoryForm.add(lHistoryPatientName);

		lblPatientIdNo = new JLabel("Patient Id No.");
		lblPatientIdNo.setBounds(30, 101, 100, 16);
		addHistoryForm.add(lblPatientIdNo);

		lblCondition = new JLabel("Condition");
		lblCondition.setBounds(30, 141, 100, 16);
		addHistoryForm.add(lblCondition);

		lblDateOccured = new JLabel("Date Occured");
		lblDateOccured.setBounds(30, 181, 100, 16);
		addHistoryForm.add(lblDateOccured);

		lblMedication = new JLabel("Medication");
		lblMedication.setBounds(30, 222, 100, 16);
		addHistoryForm.add(lblMedication);

		tHistoryPatientName = new JTextField();
		tHistoryPatientName.setBounds(130, 55, 210, 28);
		addHistoryForm.add(tHistoryPatientName);
		tHistoryPatientName.setColumns(10);

		tHistoryPatientIdNo = new JTextField();
		tHistoryPatientIdNo.setBounds(130, 95, 210, 28);
		addHistoryForm.add(tHistoryPatientIdNo);
		tHistoryPatientIdNo.setColumns(10);

		tHistorydateChooser = new JDateChooser();
		tHistorydateChooser.setDateFormatString("dd-MM-YYYY");
		tHistorydateChooser.setBounds(130, 169, 210, 28);
		addHistoryForm.add(tHistorydateChooser);

		tHistoryMedication = new JTextField();
		tHistoryMedication.setBounds(130, 210, 210, 28);
		addHistoryForm.add(tHistoryMedication);
		tHistoryMedication.setColumns(10);


		btnSubmitHistory.setBounds(130, 250, 117, 44);
		addHistoryForm.add(btnSubmitHistory);

		btnEditHistory = new JButton("Edit");
		btnEditHistory.addActionListener( handler);
		btnEditHistory.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/edituser-12007.png")));
		btnEditHistory.setBounds(281, 250, 117, 44);
		addHistoryForm.add(btnEditHistory);

		btnDelateHistory = new JButton("Delete");
		btnDelateHistory.addActionListener(handler);
		btnDelateHistory.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/3.png")));
		btnDelateHistory.setBounds(437, 250, 117, 44);
		addHistoryForm.add(btnDelateHistory);

		//comboBoxCondition = new JComboBox();
		//comboBoxCondition.setModel(new DefaultComboBoxModel(new String[] {"cos nic cos"}));



		itemsComboConditions= new ArrayList<String>();
		//{" ","Rheumatic heart disease ","Hypertension","Heart Failure","Kidney Disease","Asthma","Hepatitis","Anemia","Latex allergies"};
		itemsComboConditions.add(" ");
		itemsComboConditions.add("Rheumatic heart disease ");
		itemsComboConditions.add("Hypertension");
		itemsComboConditions.add("Heart Failure");
		itemsComboConditions.add("Kidney Disease");
		itemsComboConditions.add("Asthma");
		itemsComboConditions.add("Hepatitis");
		itemsComboConditions.add("Anemia");
		itemsComboConditions.add("Latex allergies");







		modelComboBoxCondition=   new SortedComboBoxModel(itemsComboConditions.toArray());
		comboBoxCondition= new JComboBox(modelComboBoxCondition);
		comboBoxCondition.setBounds(130, 137, 210, 27);
		addHistoryForm.add(comboBoxCondition);




	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addProceduresInvoicesForm(){


		addProceduresInvoicesForm = new JPanel();
		addProceduresInvoicesForm.setBorder(new TitledBorder(null, "Procedures/Invoices", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cardFormPanel.add(addProceduresInvoicesForm, "name_1362673909171152000");
		addProceduresInvoicesForm.setLayout(null);

		lblName = new JLabel("Name");
		lblName.setBounds(30, 28, 61, 16);
		addProceduresInvoicesForm.add(lblName);

		lblIdNo = new JLabel("Id No.");
		lblIdNo.setBounds(306, 22, 38, 16);
		addProceduresInvoicesForm.add(lblIdNo);

		lblDate = new JLabel("Date");
		lblDate.setBounds(30, 73, 61, 16);
		addProceduresInvoicesForm.add(lblDate);

		lblPaidYn = new JLabel("Paid Y/N");
		lblPaidYn.setBounds(30, 107, 61, 16);
		addProceduresInvoicesForm.add(lblPaidYn);

		lblTotal = new JLabel("Total");
		lblTotal.setBounds(236, 213, 61, 16);
		addProceduresInvoicesForm.add(lblTotal);

		tInvoicesPatientName = new JTextField();
		tInvoicesPatientName.setBounds(120, 22, 174, 28);
		addProceduresInvoicesForm.add(tInvoicesPatientName);
		tInvoicesPatientName.setColumns(10);

		tInvoicesPatientIdNo = new JTextField();
		tInvoicesPatientIdNo.setBounds(356, 16, 83, 28);
		addProceduresInvoicesForm.add(tInvoicesPatientIdNo);
		tInvoicesPatientIdNo.setColumns(10);

		tInvoiceTotal = new JTextField();
		tInvoiceTotal.setText("0.00");
		tInvoiceTotal.setBounds(290, 207, 134, 28);
		addProceduresInvoicesForm.add(tInvoiceTotal);
		tInvoiceTotal.setColumns(10);

		comboBoxInvoicePaidYN = new JComboBox();
		comboBoxInvoicePaidYN.setEditable(true);
		comboBoxInvoicePaidYN.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		comboBoxInvoicePaidYN.setBounds(120, 103, 83, 27);
		addProceduresInvoicesForm.add(comboBoxInvoicePaidYN);




		/*items.add("Check-up Cleaning 50");
	items.add("Simple Extraction 60");
	items.add("Bleeding Gums  100");
	items.add("Root Canal Treatment 200");
	items.add("Feeling  30");
	items.add("Crown 350");*/






		//{"Check-up Cleaning 50$", "Simple Extraction 60$", "Difficult Extracion 80$", "Bleeding Gums  100$", "Root Canal Treatment 200$", "Feeling  30$", "Crown 350$"};





		btSubmitInvoices = new JButton("Submit");
		btSubmitInvoices.addActionListener(handler);
		btSubmitInvoices.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/submit.png")));
		btSubmitInvoices.setBounds(236, 245, 117, 44);
		addProceduresInvoicesForm.add(btSubmitInvoices);

		dateChooserInvoices = new JDateChooser();
		dateChooserInvoices.setBounds(120, 67, 174, 28);
		addProceduresInvoicesForm.add(dateChooserInvoices);







		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(30, 142, 224, 53);
		addProceduresInvoicesForm.add(scrollPane_4);


		listModelLeft= new DefaultListModel();


		for(int i=0;i<listOfProcedures.size();i++){
			listModelLeft.addElement(listOfProcedures.get(i));
		}

		listInvProcedureLeft = new JList(listModelLeft);
		listInvProcedureLeft.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent ev) {
				String nameOfProcedure=null;
				String amoutToPaid=null;
				double tot=0.0;
				double num = 0;


				@SuppressWarnings("deprecation")
				Object[] item = listInvProcedureLeft.getSelectedValues();


				for (  int i=0; i < item.length ; i++ ) {
					nameOfProcedure= item[i].toString();
					amoutToPaid=extractDigits(nameOfProcedure);
					num+=Double.parseDouble(amoutToPaid);
					tot=num;
				}


				String total=""+tot;
				tInvoiceTotal.setText(total);

			}
		});

		/*listInvProcedureLeft.setModel(new AbstractListModel() {
		String[] values = new String[] {"Check-up Cleaning 50$", "Simple Extraction    60$", "Difficult Extracion   80$", "Bleeding Gums       100$"};


		public int getSize() {
			return values.length;
		}
		public Object getElementAt(int index) {
			return values[index];
		}
	});*/
		scrollPane_4.setViewportView(listInvProcedureLeft);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(397, 142, 216, 53);
		addProceduresInvoicesForm.add(scrollPane_5);

		listInvProcedureRight = new JList();
		scrollPane_5.setViewportView(listInvProcedureRight);

		btnMove = new JButton("Move--->");
		btnMove.addActionListener( new ActionListener() {


			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ev) {
				//bild righList
				listInvProcedureRight.setListData(listInvProcedureLeft.getSelectedValues());

			}
		});
		btnMove.setBounds(264, 153, 117, 29);
		addProceduresInvoicesForm.add(btnMove);

		btnDelateInvoice = new JButton("Delate");
		btnDelateInvoice.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/3.png")));
		btnDelateInvoice.addActionListener(handler);
		btnDelateInvoice.setBounds(389, 247, 117, 44);
		addProceduresInvoicesForm.add(btnDelateInvoice);

		btnEditInvoProce = new JButton("Edit ");
		btnEditInvoProce.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/edituser-12007.png")));
		btnEditInvoProce.addActionListener(handler);
		btnEditInvoProce.setBounds(537, 245, 83, 44);
		addProceduresInvoicesForm.add(btnEditInvoProce);

	}

	private void addListOfProcedures(){
		listOfProcedures.add("Check-up Cleaning 50$");
		listOfProcedures.add("Simple Extraction 60$");
		listOfProcedures.add("Difficult Extracion 80$");
		listOfProcedures.add("Bleeding Gums  100$");
		listOfProcedures.add("Root Canal Treatment 200$");


	}






	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void mainFrameWindow()  {



		addListOfProcedures();


		if(checkStatus==1){
			System.out.println("bbbb");	
		}


		menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		mnFile.setBackground(SystemColor.inactiveCaption);
		menuBar.add(mnFile);

		chckbxmntmSerializable = new JCheckBoxMenuItem("Serializable");
		chckbxmntmSerializable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				save();
			}
		});
		chckbxmntmSerializable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( chckbxmntmSerializable.getState()==true){
					checkStatus=1;
					setCheckStatus(checkStatus);

					System.out.println(checkStatus);



				}

			}




		});

		chckbxmntmNonserializable = new JCheckBoxMenuItem("Non-Serializable");
		mnFile.add(chckbxmntmNonserializable);

		mnFile.add(chckbxmntmSerializable);

		chckbxmntmLoadFromFile = new JCheckBoxMenuItem("Load From File");
		chckbxmntmLoadFromFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				load();

				for(int ii=0;ii<patientList.getPatientList().size();ii++){
					xx=patientList.getPatientList();
					patient= new Patient();
					patient=xx.get(ii);

					patient.getPatientId();
					patient.getPatientName();
					patient.getPatientAddress();
					patient.getPatientPhone();
					tm1= (DefaultTableModel)table1PatientInfo.getModel();
					tm1.addRow(new Object[]{patient.getPatientId(),patient.getPatientName(),patient.getPatientAddress(),patient.getPatientPhone()});
					table1PatientInfo.setModel(tm1);	
				}

				patientList.printPatientList();



				for(int ii=0;ii<listOfProcedures.size();ii++){
					listModelLeft.removeAllElements();
				}
				for(int ii=0;ii<listOfProcedures.size();ii++){
					listModelLeft.addElement(listOfProcedures.get(ii));	
				}



				for(int ii=0;ii<itemsComboConditions.size();ii++){
					modelComboBoxCondition.removeAllElements();
				}
				for(int ii=0;ii<itemsComboConditions.size();ii++){
					modelComboBoxCondition.addElement(itemsComboConditions.get(ii));	
				}


			}
		});
		mnFile.add(chckbxmntmLoadFromFile);

		chckbxmntmDatabase = new JCheckBoxMenuItem("DataBase");
		mnFile.add(chckbxmntmDatabase);

		chckbxmntmLoadFromDatabase = new JCheckBoxMenuItem("Load From DataBase");
		mnFile.add(chckbxmntmLoadFromDatabase);

		mnMainteance = new JMenu("Mainteance");

		mnMainteance.setBackground(SystemColor.inactiveCaptionText);
		menuBar.add(mnMainteance);
		//********************MAINTEANCE SECTION UPDATE PROCEDURES
		mainteanceAddProc = new JMenuItem("Add New Procedure");
		mainteanceAddProc.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {

				//LinkedList<String> listProcSet= new LinkedList<String>();


				String i=JOptionPane.showInputDialog("Enter new procedure and price" +" eg.: Simple Extraction 100$");
				listOfProcedures.add(i);
				System.out.println(listOfProcedures);

				listModelLeft.removeAllElements();
				for(int ii=0;ii<listOfProcedures.size();ii++){
					listModelLeft.addElement(listOfProcedures.get(ii));	
					//listProcSet.add(listOfProcedures.get(ii));
				}

				//listOfProcedures=listProcSet;

				//returnListOFProcedrues(listOfProcedures);




				try {
					ObjectOutputStream os= new ObjectOutputStream(new FileOutputStream(fileName));

					os.writeObject(listOfProcedures);
					//os.writeObject(itemsComboConditions);
					os.close();
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
				System.out.println("saved");




			}
		});
		mnMainteance.add(mainteanceAddProc);

		mainteanceDelateProc = new JMenuItem("Remove Procedure");
		mainteanceDelateProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i=JOptionPane.showInputDialog("Enter name of procedure you want to delate");

				for(int k=0;k<listOfProcedures.size();k++){
					String findMe=listOfProcedures.get(k);
					System.out.println(findMe);
					if(i.equals(findMe)){

						listModelLeft.removeElement(listOfProcedures.get(k));	
						listOfProcedures.remove(k);
						System.out.println(listOfProcedures);
					}


				}


			}
		});
		mnMainteance.add(mainteanceDelateProc);

		mntmAddNewCondition = new JMenuItem("Add New Condition");
		mntmAddNewCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				String i=JOptionPane.showInputDialog("Enter new condition"+" eg.: Anemia");
				itemsComboConditions.add(i);
				System.out.println(itemsComboConditions);



				modelComboBoxCondition.removeAllElements();

				for(int ii=0;ii<itemsComboConditions.size();ii++){
					modelComboBoxCondition.addElement(itemsComboConditions.get(ii));	


					//listProcSet.add(itemsComboConditions.get(ii));
				}








			}
		});
		mnMainteance.add(mntmAddNewCondition);

		mntmRemoveCondition = new JMenuItem("Remove Condition");
		mntmRemoveCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				String i=JOptionPane.showInputDialog("Enter name of condition you want to delate");

				for(int k=0;k<itemsComboConditions.size();k++){
					String findMe=itemsComboConditions.get(k);
					System.out.println(findMe);
					if(i.equals(findMe)){

						modelComboBoxCondition.removeElement(itemsComboConditions.get(k));	
						itemsComboConditions.remove(k);
						System.out.println(itemsComboConditions);
					}


				}


			}
		});
		mnMainteance.add(mntmRemoveCondition);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		mainPanelOnFrame = new JPanel();
		mainPanelOnFrame.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(mainPanelOnFrame, BorderLayout.CENTER);
		mainPanelOnFrame.setLayout(null);

		panelReports = new JPanel();
		panelReports.setBorder(new TitledBorder(null, "Reports", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelReports.setBounds(16, 68, 638, 612);
		panelReports.setVisible(false);
		mainPanelOnFrame.add(panelReports);
		panelReports.setLayout(null);

		JButton btnShowPatietnOwning = new JButton("Unpaid Invoices");
		btnShowPatietnOwning.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/Search.png")));



		//*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		btnShowPatietnOwning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tabbedPane.setSelectedIndex(0);
				DefaultListModel model222 = new DefaultListModel();  
				String name=null;
				int money=0;

				boolean valid = true;

				ArrayList<Patient>patietnList= new ArrayList<Patient>();




				System.out.println("this is invices report");

				patietnList=patientList.getPatientList();
				System.out.println(patietnList);
				model222.addElement("List of patients who have no outstanding invoices");
				for(int i=0;i<patietnList.size();i++){
					int amount22=0;


					for(int j=0;j<patietnList.get(i).getP_invoice().size();j++){
						valid=true;
						int amount=0;


						if (!(patietnList.get(i).getP_invoice().get(j).getIsInvoicePaid()))           
						{ 
							boolean t=patietnList.get(i).getP_invoice().get(j).getIsInvoicePaid();
							valid =false;
							System.out.println(t);
							name=patietnList.get(i).getPatientName();

							System.out.println("\nPatient\n " +name);
							amount+=patietnList.get(i).getP_invoice().get(j).getInvoiceAmt();

						}   
						amount22+=amount;
						money += amount;
						System.out.println(amount);
						System.out.println(money);

						if(valid==false){

							model222.addElement("Name: "+ name+"\nAmount to be paid: "+amount22+"\n$");

							listReport1.setModel(model222);
						}

					}




				}
				model222.addElement("           ");
				model222.addElement("Total-Invoices outstanding for all patients: \n"+money+"$\n");
			}

		});

		//*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		btnShowPatietnOwning.setBounds(435, 87, 160, 37);
		panelReports.add(btnShowPatietnOwning);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 256, 615, 352);
		panelReports.add(tabbedPane);

		JScrollPane scrollPane_6 = new JScrollPane();
		tabbedPane.addTab("Patient own Money", null, scrollPane_6, null);

		listReport1 = new JList();
		listReport1.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_6.setViewportView(listReport1);

		scrollPane_7 = new JScrollPane();


		listReport2 = new JList();
		listReport2.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_7.setViewportView(listReport2);

		btnNewButton = new JButton("Paid Invoices      ");
		btnNewButton.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/Search.png")));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);

				DefaultListModel model3 = new DefaultListModel();  
				String name=null;
				int money=0;

				boolean valid = true;

				ArrayList<Patient>patietnList= new ArrayList<Patient>();




				System.out.println("this is invices report");

				patietnList=patientList.getPatientList();
				System.out.println(patietnList);
				model3.addElement("List of patients who have no outstanding invoices");
				for(int i=0;i<patietnList.size();i++){
					int amount22=0;


					for(int j=0;j<patietnList.get(i).getP_invoice().size();j++){
						valid=false;
						int amount=0;
						boolean t=patietnList.get(i).getP_invoice().get(j).getIsInvoicePaid();

						if (t==true)           
						{ 
							valid =true;

							name=patietnList.get(i).getPatientName();

							System.out.println("\nPatient\n " +name);
							amount+=patietnList.get(i).getP_invoice().get(j).getInvoiceAmt();

						}   
						amount22+=amount;
						money += amount;
						System.out.println(amount);
						System.out.println(money);


					}
					if(valid==true){

						model3.addElement("Name: "+ name+"\t"+"\nAmount  paid: "+amount22+"\n$");
						listReport2.setModel(model3);


					}



				}



			}
		});


		tabbedPane.addTab("Patient paid", null, scrollPane_7, null);

		scrollPane_8 = new JScrollPane();
		tabbedPane.addTab("List of Patients treatment", null, scrollPane_8, null);

		listReport3 = new JList();
		scrollPane_8.setViewportView(listReport3);


		btnNewButton.setBounds(435, 133, 160, 37);
		panelReports.add(btnNewButton);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Patients who received treatments and specific procedures", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(22, 31, 374, 184);
		panelReports.add(panel);
		panel.setLayout(null);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(88, 47, 61, 16);
		panel.add(lblFrom);

		dateChooser1Report = new JDateChooser();
		dateChooser1Report.setBounds(128, 35, 141, 28);
		panel.add(dateChooser1Report);

		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(88, 84, 61, 16);
		panel.add(lblTo);

		dateChooser2Report = new JDateChooser();
		dateChooser2Report.setBounds(128, 75, 141, 28);
		panel.add(dateChooser2Report);

		JButton btnShowPatinets = new JButton("Show Patinets");
		btnShowPatinets.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/Search.png")));
		btnShowPatinets.setBounds(128, 125, 141, 37);
		panel.add(btnShowPatinets);
		btnShowPatinets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(2);
				ArrayList<Patient>patietnList= new ArrayList<Patient>();
				patietnList=patientList.getPatientList();
				ArrayList<Patient>patientList4 = new ArrayList<Patient>();
				Date from= dateChooser1Report.getDate();
				Date to= dateChooser2Report.getDate();


				DefaultListModel model3 = new DefaultListModel();
				listReport3.setModel(model3);

				boolean valid;
				LinkedList<Procedure>proc2= new LinkedList<Procedure>();

				Procedure pp;

				if(dateChooser1Report.getDate()==null || dateChooser2Report.getDate()==null){
					JOptionPane.showMessageDialog(null, "Enter Date From To","Error!!!", JOptionPane.ERROR_MESSAGE, null);
				}
				else
				{

					if (dateChooser1Report!=null && dateChooser2Report !=null )  
						for (int i=0;i<patietnList.size();i++)
						{       valid=false;
						LinkedList<Procedure>proc3= new LinkedList<Procedure>();
						for (int j=0;j<patietnList.get(i).getP_invoice().size();j++ )
						{

							String  datebefore=patietnList.get(i).getP_invoice().get(j).getInvoiceDate();

							proc2=patietnList.get(i).getP_invoice().get(j).getInvoiceProcList();
							for(int hh=0;hh<proc2.size();hh++){
								pp= new Procedure();
								pp =proc2.get(hh);
								//addProcedure to arrayList
								proc3.add(pp);


							}


							Date date= new Date();
							try {
								date=	dateFormat.parse(datebefore);
							} catch (ParseException e) {

								e.printStackTrace();
							}

							if( from.before(date)  &&   (date.before(to))  )                      
								valid=true;
						}   


						if (valid ==true){
							model3.addElement("Name: "+patietnList.get(i).getPatientName()); 

							for(int h=0;h<proc3.size();h++){

								pp=proc3.get(h);

								model3.addElement("Proc No. :"+pp.getProcNum()+"      Proc Name: "+pp.getProcName());  

							}
							model3.addElement("                     ");  


						}
						Patient pat= new Patient();
						pat= patietnList.get(i);

						System.out.println(pat);



						patientList4.add(pat);
						System.out.println(valid);

						dateChooser1Report.setCalendar(null);
						dateChooser2Report.setCalendar(null);






						}}
			}

		});

		panelCardForm = new JPanel();
		panelCardForm.setBackground(UIManager.getColor("Button.background"));
		panelCardForm.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelCardForm.setBounds(16, 68, 647, 617);
		mainPanelOnFrame.add(panelCardForm);
		panelCardForm.setLayout(null);

		cardFormPanel = new JPanel();
		cardFormPanel.setBounds(6, 0, 637, 306);
		panelCardForm.add(cardFormPanel);
		cardFormPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		cardFormPanel.setLayout(new CardLayout(0, 0));




		addPatientForm();
		addHistoryForm();
		addProceduresInvoicesForm();













		panel_infoCardLayout = new JPanel();
		panel_infoCardLayout.setBounds(6, 318, 637, 293);

		panelCardForm.add(panel_infoCardLayout);
		panel_infoCardLayout.setLayout(new CardLayout(0, 0));

		calendarPatient = new JCalendar();
		calendarPatient.getDayChooser().setBackground(new Color(175, 238, 238));
		calendarPatient.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_infoCardLayout.add(calendarPatient, "name_1363118568950867000");

		panelHistoryInfo = new JPanel();
		panel_infoCardLayout.add(panelHistoryInfo, "name_1363113834305408000");
		panelHistoryInfo.setVisible(false);

		panelHistoryInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "History", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelHistoryInfo.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panelHistoryInfo.add(scrollPane_1, BorderLayout.CENTER);

		tableHistoryInfo = new JTable();
		tableHistoryInfo.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Condition", "Date", "Medication"
				}
				));



		tableHistoryInfo.getColumnModel().getColumn(0).setPreferredWidth(47);
		tableHistoryInfo.getColumnModel().getColumn(2).setPreferredWidth(66);
		scrollPane_1.setViewportView(tableHistoryInfo);

		panelInvoiceProcedures = new JPanel();
		panelInvoiceProcedures.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_infoCardLayout.add(panelInvoiceProcedures, "name_1363114067446566000");
		panelInvoiceProcedures.setLayout(null);

		panelInvoicesInfo = new JPanel();
		panelInvoicesInfo.setBounds(6, 6, 310, 281);
		panelInvoiceProcedures.add(panelInvoicesInfo);
		panelInvoicesInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Invoices", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInvoicesInfo.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		panelInvoicesInfo.add(scrollPane_3, BorderLayout.CENTER);

		tableInvoicesInfo = new JTable();
		tableInvoicesInfo.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Amount", "Paid", "Date"
				}
				));
		//tableInvoicesInfo.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane_3.setViewportView(tableInvoicesInfo);

		panelProceduresInfo = new JPanel();
		panelProceduresInfo.setBounds(321, 6, 310, 281);
		panelInvoiceProcedures.add(panelProceduresInfo);
		panelProceduresInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Procedures", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelProceduresInfo.setLayout(new CardLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panelProceduresInfo.add(scrollPane_2, "name_1363114579071692000");

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID ", "Name", "Cost"
				}
				));
		scrollPane_2.setViewportView(table_2);



		//TABEL PANEL EAST***************************
		panelPatientInformation = new JPanel();
		panelPatientInformation.setBorder(new TitledBorder(null, "Patient Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPatientInformation.setBounds(675, 68, 311, 612);
		mainPanelOnFrame.add(panelPatientInformation);
		panelPatientInformation.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelPatientInformation.add(scrollPane, BorderLayout.CENTER);

		table1PatientInfo = new JTable();
		table1PatientInfo.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID No.", "Name", "Address", "Phone"
				}
				));





		tableInvoicesInfo.addMouseListener(new MouseAdapter(){
			Invoice inv= new Invoice();
			public void mouseClicked(MouseEvent e){
				LinkedList<Invoice>invlist= new LinkedList<Invoice>();
				invlist=patient.getP_invoice();
				int row= tableInvoicesInfo.getSelectedRow();
				int invoiceId= Integer.parseInt(tableInvoicesInfo.getValueAt(row, 0).toString());


				LinkedList<Procedure> procedureList= new LinkedList<Procedure>();
				inv=searchInvoice(invoiceId,invlist);
				procedureList=inv.getInvoiceProcList();
				Procedure proc= new Procedure();

				tm4Invoice= new DefaultTableModel();
				tm4Invoice= (DefaultTableModel)table_2.getModel();
				tableInvoicesInfo.repaint();
				table_2.setModel(tm4Invoice);
				deleteAllRows(tm4Invoice);
				for(int j=0;j<procedureList.size();j++){


					proc=procedureList.get(j);

					String hId= ""+proc.getProcNum();
					String hCondN=proc.getProcName();
					String hDatOcc= ""+proc.getProcCost();

					tm4Invoice.addRow(new Object[]{new String(hId),new String(hCondN),new String(hDatOcc)});	
					tm4Invoice.fireTableDataChanged();

				}	

			}

		});

		//?????????????????????????????????????????????????????????????????????
		table1PatientInfo.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e){


				//you have to get patient info fomr the jpaitentinfo tavble
				int row= table1PatientInfo.getSelectedRow();
				tPatientIdNum.setText( tm1.getValueAt(row, 0).toString());
				tPatientName.setText(tm1.getValueAt(row, 1).toString());

				tHistoryPatientIdNo.setText(  tm1.getValueAt(row, 0).toString());
				tHistoryPatientName.setText(   tm1.getValueAt(row, 1).toString());

				tInvoicesPatientIdNo.setText(  tm1.getValueAt(row, 0).toString());
				tInvoicesPatientName.setText(   tm1.getValueAt(row, 1).toString());



				//clean invoices date paid and total 
				tInvoiceTotal.setText("0.00");
				dateChooserInvoices.setDate(null);


				int patientIdNum= Integer.parseInt(table1PatientInfo.getValueAt(row, 0).toString());


				patient=findPatient(patientIdNum);

				if(patientIdNum==patient.getPatientId())
				{

					LinkedList<History>historyList= new LinkedList<History>();

					historyList=patient.getPatientHistory();
					History his=new History();

					tm2History= new DefaultTableModel();

					tm2History=(DefaultTableModel)tableHistoryInfo.getModel();

					table1PatientInfo.repaint();

					tableHistoryInfo.setModel(tm2History);
					deleteAllRows(tm2History);

					for(int j=0;j<historyList.size();j++){


						his=historyList.get(j);

						String hId= ""+his.getHistId();
						String hCondN=his.getConditionName();
						String hDatOcc= his.getDateOccured();
						String hMedi= his.getMedication();
						tm2History.addRow(new Object[]{new String(hId),new String(hCondN),new String(hDatOcc),new String(hMedi)});	
						tm2History.fireTableDataChanged();

					}	

					//#####$343$#$########43434343$#4
					LinkedList<Invoice>invoiceList= new LinkedList<Invoice>();
					invoiceList= patient.getP_invoice();
					Invoice inv= new Invoice();
					tm3Invoices= new DefaultTableModel();

					tm3Invoices=(DefaultTableModel)tableInvoicesInfo.getModel();
					tableInvoicesInfo.repaint();
					tableInvoicesInfo.setModel(tm3Invoices);

					deleteAllRows(tm3Invoices);
					for(int k=0;k< invoiceList.size();k++){

						inv= invoiceList.get(k);
						String invId= ""+inv.getInvoiceNum();
						double invAmount= inv.getInvoiceAmt();
						String invDate=inv.getInvoiceDate();
						boolean invPaindNY= inv.getIsInvoicePaid();
						tm3Invoices.addRow(new Object[]{new String(invId),new Double(invAmount),new Boolean(invPaindNY),new String(invDate)});
						tm3Invoices.fireTableDataChanged();
					}





				}


				//tInvoicesPatientName.setText(  tm1.getValueAt(row, 1).toString());
				//tInvoicesPatientIdNo.setText(   tm1.getValueAt(row, 0).toString());



			}

		});

		scrollPane.setViewportView(table1PatientInfo);

		btnPatient = new JButton("Patient");
		btnPatient.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnPatient.setForeground(SystemColor.windowText);
		btnPatient.setBackground(UIManager.getColor("CheckBox.background"));
		btnPatient.setBounds(26, 7, 190, 49);
		mainPanelOnFrame.add(btnPatient);
		btnPatient.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/dentist.png")));

		btnHistory = new JButton("History");
		btnHistory.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnHistory.setBounds(238, 7, 190, 49);
		mainPanelOnFrame.add(btnHistory);
		btnHistory.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/dentist.png")));

		btnInvoicesprocedures = new JButton("Invoices/Procedures");
		btnInvoicesprocedures.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnInvoicesprocedures.setBounds(453, 7, 190, 49);
		mainPanelOnFrame.add(btnInvoicesprocedures);
		btnInvoicesprocedures.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/dentist.png")));

		JButton btnReports = new JButton("View Reports");
		btnReports.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/Search.png")));
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelReports.setVisible(true);
				panelCardForm.setVisible(false);


				//dfdfdf
			}
		});
		btnReports.setBounds(675, 7, 311, 49);
		mainPanelOnFrame.add(btnReports);
		btnInvoicesprocedures.addActionListener(handlerChangeForms);
		btnHistory.addActionListener(handlerChangeForms);
		btnPatient.addActionListener(handlerChangeForms);
		panelHistoryInfo.setVisible(false);
		calendarPatient.setVisible(false);
	}































	//*******Inner Event class handler for 3 North buttons*******//
	private class TheHandler2 implements ActionListener{


		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnPatient){
				addPatientForm.setVisible(true);
				addHistoryForm.setVisible(false);
				addProceduresInvoicesForm.setVisible(false);
				panel_infoCardLayout.setVisible(true);
				calendarPatient.setVisible(true);


				panelReports.setVisible(false);
				panelCardForm.setVisible(true);
			}
			else if(e.getSource()==btnHistory){
				addPatientForm.setVisible(false);
				addHistoryForm.setVisible(true);
				addProceduresInvoicesForm.setVisible(false);
				panel_infoCardLayout.setVisible(true);
				panelHistoryInfo.setVisible(true);
				panelInvoiceProcedures.setVisible(false);
				calendarPatient.setVisible(false);


				panelReports.setVisible(false);
				panelCardForm.setVisible(true);
			}
			else if(e.getSource()==btnInvoicesprocedures){
				addPatientForm.setVisible(false);
				addHistoryForm.setVisible(false);
				addProceduresInvoicesForm.setVisible(true);
				panel_infoCardLayout.setVisible(true);
				panelHistoryInfo.setVisible(false);
				panelInvoiceProcedures.setVisible(true);
				calendarPatient.setVisible(false);


				panelReports.setVisible(false);
				panelCardForm.setVisible(true);
			}	
		}
	}



	private class TheHandler implements ActionListener{
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent ev) {

			tm1= (DefaultTableModel)table1PatientInfo.getModel();

			if(ev.getSource()==btnSubmitPatient){

				if(tPatientName.getText().isEmpty() || tPatientPhone.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "One of the required field is empty","Error!!!", JOptionPane.ERROR_MESSAGE, null);

				}
				else 
				{
					if(editable==true){
						int rowSelected=table1PatientInfo.getSelectedRow();
						String pId= tPatientIdNum.getText();
						String pNam= tPatientName.getText();
						String pAdd= tPatientAddress.getText();
						String pPho= tPatientPhone.getText();

						tm1.setValueAt(new String(pId), rowSelected, 0);
						tm1.setValueAt(new String(pNam), rowSelected, 1);
						tm1.setValueAt(new String(pAdd), rowSelected, 2);
						tm1.setValueAt(new String(pPho), rowSelected, 3);

						//works patient info updated
						Patient p= new Patient();
						p=findPatient(Integer.parseInt(tPatientIdNum.getText()));
						p.setPatientName(pNam);
						p.setPatientAddress(pAdd);
						p.setPatientPhone(pPho);
						patientList.printPatientList();//print test check if edit updated
						editable= false;
						emptyTextFiledsPatientForm();
					}
					else {
						try{
							int patientIdNumber;
							patientIdNumber=patientList.getPatientListPatientId();
							System.out.println("nnnnnnnnnnnnnnnn00000000 "+patientIdNumber);
							int id = 0;
							id=1+patientIdNumber;
							patientList.setPatientListPatientId(id);
							patientIdNumber=patientList.getPatientListPatientId();
							//patientIdNumber++;
							System.out.println("nnnnnnnnnnnnnnnn111111111 "+patientIdNumber);


							patientList.setPatientListPatientId(patientIdNumber);

							System.out.println("nnnnnnnnnnnnnnnn222222222222 "+patientIdNumber);

							patient= new Patient( patientIdNumber,tPatientName.getText(),tPatientAddress.getText(),tPatientPhone.getText());

							patientList.addPatient(patient);
							tPatientIdNum.setText(""+patient.getPatientId());

							patientList.printPatientList();//test
							//patient.printPatientAndHistory();
							//personTableModel.fireTableDataChanged();


							//****************JTABLE  PATIENT**********************
							tm1= (DefaultTableModel)table1PatientInfo.getModel();
							tm1.fireTableDataChanged();
							String pId= tPatientIdNum.getText();
							String pNam= tPatientName.getText();
							String pAdd= tPatientAddress.getText();
							String pPho= tPatientPhone.getText();
							tm1.addRow(new Object[]{new String(pId),new String(pNam),new String(pAdd),new String(pPho)});
							tm1.fireTableDataChanged();
							table1PatientInfo.setModel(tm1);

							emptyTextFiledsPatientForm();

						}catch(Exception ex){
						}
					}
				}
			}

			else if(ev.getSource()==btnEditPatientForm){		
				try{
					editable=true;
					tm1= (DefaultTableModel)table1PatientInfo.getModel();
					if(editable==true)
					{
						int rowselected=table1PatientInfo.getSelectedRow();
						tPatientIdNum.setText(  tm1.getValueAt(rowselected, 0).toString());
						tPatientName.setText(   tm1.getValueAt(rowselected, 1).toString());
						tPatientAddress.setText(tm1.getValueAt(rowselected, 2).toString());
						tPatientPhone.setText(  tm1.getValueAt(rowselected, 3).toString());
					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "SELECT PATIENT TO EDIT DETAILS");
					editable=false;
				}
			}

			else if(ev.getSource()==btnDelatePatientInfo){
				try{
					DefaultTableModel tm= (DefaultTableModel)table1PatientInfo.getModel();
					int rowSelected= table1PatientInfo.getSelectedRow();
					Patient p= new Patient();
					p=findPatient(Integer.parseInt((String) tm1.getValueAt(rowSelected, 0)));

					tm.removeRow(table1PatientInfo.getSelectedRow());
					table1PatientInfo.setModel(tm);

					//***********remove patient********
					patientList.removiePatient(p);

					patientList.printPatientList();//print test check if edit updated
					emptyTextFiledsPatientForm();
				}
				catch(Exception ex){

				}
			}

			else if(ev.getSource()==btnSubmitHistory){
				Date d= tHistorydateChooser.getDate();
				int indexComboCondition;
				int b= comboBoxCondition.getSelectedIndex();
				String conditionName;
				String cond;
				try
				{
					if(tHistoryPatientName.getText().isEmpty() || tHistoryPatientIdNo.getText().isEmpty() || d==null || b==0)
					{
						JOptionPane.showMessageDialog(null, "One of the required field is empty","Error!!!", JOptionPane.ERROR_MESSAGE, null);
						if(tHistoryPatientIdNo.getText().isEmpty()){tHistoryPatientIdNo.setBackground(new Color(229,2,34));}
						if(tHistoryPatientName.getText().isEmpty()){tHistoryPatientName.setBackground(new Color(229,2,34));}
						if(comboBoxCondition.getSelectedIndex()==0){comboBoxCondition.setPopupVisible(true);comboBoxCondition.setToolTipText("Choose Condition");}
						if(d==null){tHistorydateChooser.setBackground(new Color(229,2,34));}
					}

					else{
						tHistoryPatientIdNo.setBackground(new Color(255,255,255));
						tHistoryPatientName.setBackground(new Color(255,255,255));
						tHistorydateChooser.setBackground(new Color(255,255,255));
						comboBoxCondition.setBackground(new Color(255,255,255));
						History h= new History();
						if(editableHistory==true){


							int rowSelected=tableHistoryInfo.getSelectedRow();

							indexComboCondition= comboBoxCondition.getSelectedIndex();
							cond=  (String)comboBoxCondition.getItemAt(indexComboCondition);

							//String cond= tHistoryCondition.getText();
							String date=  dateFormat.format(tHistorydateChooser.getDate());
							String med= tHistoryMedication.getText();

							tm2History.setValueAt(new String(cond), rowSelected, 1);
							tm2History.setValueAt(new String(date), rowSelected, 2);
							tm2History.setValueAt(new String(med), rowSelected, 3);

							Patient p= new Patient();
							int historyId=Integer.parseInt(tHistoryPatientIdNo.getText());
							p=findPatient(historyId);
							LinkedList<History>hist= new LinkedList<History>();
							hist=p.getPatientHistory();

							int histIdFromtable=Integer.parseInt((String) tm2History.getValueAt(rowSelected, 0));
							h=findHistory(hist,histIdFromtable);

							h.setConditionName(cond);
							h.setDateOccured(date);
							h.setMedication(med);
							emptyTextFildsHistory();

							editableHistory=false;



						}


						else{
							try{

								indexComboCondition= comboBoxCondition.getSelectedIndex();
								conditionName=  (String)comboBoxCondition.getItemAt(indexComboCondition);

								String patientName=tHistoryPatientName.getText();
								int patientIdNum= Integer.parseInt(tHistoryPatientIdNo.getText());

								patient=searchPatient(patientName,patientIdNum);

								int patientHistoryId=patient.getHistoryIdPatient();
								patientHistoryId++;
								patientHistoryId=patient.setHistoryIdPatient(patientHistoryId);
								String data= dateFormat.format(tHistorydateChooser.getDate());

								h=new History(patientHistoryId,conditionName,data,tHistoryMedication.getText());
								LinkedList<History>historyList= new LinkedList<History>();

								historyList=patient.getPatientHistory();
								historyList.add(h);
								patient.setP_history(historyList);

								//test if history added
								patientList.printPatientList();

								String hId= ""+h.getHistId();
								String hCondN=h.getConditionName();
								String hDatOcc= h.getDateOccured();
								String hMedi= h.getMedication();
								tm2History.addRow(new Object[]{new String(hId),new String(hCondN),new String(hDatOcc),new String(hMedi)});	
								//tm2History.fireTableDataChanged();
								emptyTextFildsHistoryForm();
							}catch(NullPointerException e){
								JOptionPane.showMessageDialog(null, "Choose condition","Error",JOptionPane.ERROR_MESSAGE,null);
								//editableHistory = false; //???????????????delate it test only
							}
							
							
							catch(Exception e){


								JOptionPane.showMessageDialog(null, "Enter date>>","Error",JOptionPane.ERROR_MESSAGE,null);

							}
						}
					}
				}
				catch(NumberFormatException ee){
					System.out.println("?????");
				}
			}


			else if(ev.getSource()==btnEditHistory){

				if(tHistoryPatientName.getText().isEmpty() || tHistoryPatientIdNo.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "One of the required field is empty","Error!!!", JOptionPane.ERROR_MESSAGE, null);
					tHistoryPatientIdNo.setText("Fill up");
					tHistoryPatientName.setText("Fill up");
				}
				
				else{

					try{
						editableHistory = true;
						tm2History=(DefaultTableModel)tableHistoryInfo.getModel();
						int rowSelectedHistoryInfo=tableHistoryInfo.getSelectedRow();
						//comboBoxCondition.setText(tm2History.getValueAt(rowSelectedHistoryInfo, 1).toString());
						//comboBoxCondition.setName(tm2History.getValueAt(rowSelectedHistoryInfo, 1).toString());
						comboBoxCondition.setSelectedItem( tm2History.getValueAt(rowSelectedHistoryInfo, 1));
						tHistoryMedication.setText(tm2History.getValueAt(rowSelectedHistoryInfo, 3).toString());
						String d=(String) tm2History.getValueAt(rowSelectedHistoryInfo, 2);
						Date date= new SimpleDateFormat("dd-MM-yyyy").parse(d);
						tHistorydateChooser.setDate(date);  //?>?????


					}
					
					
					catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Select Patient to edit Details","Error",JOptionPane.ERROR_MESSAGE,null);
						//editableHistory = false; //???????????????delate it test only
					}
				}
			}


			else if(ev.getSource()==btnDelateHistory){

				try{
					DefaultTableModel tm2= (DefaultTableModel)tableHistoryInfo.getModel();
					int rowSelected = tableHistoryInfo.getSelectedRow();
					Patient p= new Patient();
					int histPatientId=Integer.parseInt(tHistoryPatientIdNo.getText());
					p=findPatient(histPatientId);
					History hist= new History();
					int historyId= Integer.parseInt((String) tm2.getValueAt(rowSelected, 0));
					LinkedList<History>histList= new LinkedList<History>();
					histList=p.getPatientHistory();
					tm2.removeRow(tableHistoryInfo.getSelectedRow());
					tableHistoryInfo.setModel(tm2);


					hist=findHistory(histList,historyId);
					patient.getPatientHistory().remove(hist);

					emptyTextFildsHistoryForm();

				}catch(Exception ex){

				}
			}
			else if(ev.getSource()==btSubmitInvoices){

				Date d=dateChooserInvoices.getDate();

				if((d==null )|| (tInvoicesPatientName.getText().isEmpty())|| (tInvoicesPatientIdNo.getText().isEmpty())){
					JOptionPane.showMessageDialog(null, "One of the required field is empty","Error!!!", JOptionPane.ERROR_MESSAGE, null);
					if(tInvoicesPatientName.getText().isEmpty()){tInvoicesPatientName.setBackground(new Color(229,2,34));}
					if(tInvoicesPatientIdNo.getText().isEmpty()){tInvoicesPatientIdNo.setBackground(new Color(229,2,34));}
					if(d==null){dateChooserInvoices.setBackground(new Color(229,2,34));}

				}
				else if(editableInvoice==true){
					int rowSelectedInvoice = 0;
					int idNUmPat=Integer.parseInt(tInvoicesPatientIdNo.getText());
					int invoiceId=Integer.parseInt(((tm3Invoices.getValueAt(rowSelectedInvoice, 0).toString())));
					Patient p= new Patient();
					p=findPatient(idNUmPat);
					LinkedList<Invoice>inv= new LinkedList<Invoice>();
					Invoice invoice1= new Invoice();
					inv=p.getP_invoice();
					for(int o=0;o<inv.size();o++){
						invoice1=inv.get(invoiceId-1);
					}
					String invoiceDate= dateFormat.format(dateChooserInvoices.getDate());
					String chekPaid=comboBoxInvoicePaidYN.getSelectedItem().toString();

					boolean paidYN=checkPay(chekPaid);
					invoice1.setInvoicePaid(paidYN);
					invoice1.setInvoiceDate(invoiceDate);


					boolean invPaid= invoice1.getIsInvoicePaid();
					String invDate= invoice1.getInvoiceDate();
					tm3Invoices.setValueAt(invPaid, rowSelectedInvoice, 2);
					tm3Invoices.setValueAt(invDate, rowSelectedInvoice, 3);




					System.out.println(invoice1);


				}

				else{
					tInvoicesPatientName.setBackground(new Color(255,255,255));
					tInvoicesPatientIdNo.setBackground(new Color(255,255,255));
					dateChooserInvoices.setBackground(new Color(255,255,255));
					Patient patient= new Patient();
					Procedure newProcedure= new Procedure();
					Invoice invoice= new Invoice();

					String patientName=tInvoicesPatientName.getText();
					int patientIdNum= Integer.parseInt(tInvoicesPatientIdNo.getText());
					int invoiceNum;

					tInvoiceTotal.setText("0.00");				
					try{
						String nameOfProcedure=null;
						String amoutToPaid=null;
						double tot=0.0;
						double num = 0;

						for (int ie = 0; ie < listInvProcedureRight.getModel().getSize(); ie++) {
							Object item = listInvProcedureRight.getModel().getElementAt(ie);
							nameOfProcedure= item.toString();
							amoutToPaid=extractDigits(nameOfProcedure);
							num+=Double.parseDouble(amoutToPaid);
							tot=num;		            
						}
						String total=""+tot;
						tInvoiceTotal.setText(total);

						patient=searchPatient(patientName,patientIdNum);
						invoiceNum=patient.getInvoiceIdPatient();
						invoiceNum++;



						invoiceNum=patient.setInvoiceIdPatient(invoiceNum);
						String invoiceDate= dateFormat.format(dateChooserInvoices.getDate());
						String chekPaid=comboBoxInvoicePaidYN.getSelectedItem().toString();

						boolean paidYN=checkPay(chekPaid);

						invoice= new Invoice(invoiceNum,tot,invoiceDate, paidYN);
						LinkedList<Invoice> invoiceList= new LinkedList<Invoice>();
						invoiceList=patient.getP_invoice();
						invoiceList.add(invoice);
						patient.setP_invoice(invoiceList);

						//test
						//patientList.printPatientList();
						patient.printKurwaInvoice();

						String invNum= ""+invoice.getInvoiceNum();
						double invAmount=invoice.getInvoiceAmt();
						boolean invPaid= invoice.getIsInvoicePaid();
						String invDate= invoice.getInvoiceDate();
						tm3Invoices.addRow(new Object[]{new String(invNum),new Double(invAmount),new Boolean(invPaid),new String(invDate)});	

						emptyTextFildsInvoices();

						invoice=searchInvoice(invoiceNum,invoiceList);

						// add procedure*********

						for (int ie = 0; ie < listInvProcedureRight.getModel().getSize(); ie++) {
							Object item = listInvProcedureRight.getModel().getElementAt(ie);

							nameOfProcedure= item.toString();

							amoutToPaid=extractDigits(nameOfProcedure);
							num=Double.parseDouble(amoutToPaid);

							int porcedureNum= invoice.getProcedureNum();
							porcedureNum++;
							porcedureNum=invoice.setProcedureNum(porcedureNum);

							newProcedure= new Procedure(porcedureNum,nameOfProcedure,num);

							invoice.addProcedure(newProcedure);

							tm4Invoice= new DefaultTableModel();
							tm4Invoice= (DefaultTableModel)table_2.getModel();
							tableInvoicesInfo.repaint();
							table_2.setModel(tm4Invoice);

							tm4Invoice.addRow(new Object[]{new Integer(invoice.getProcedureNum()), new String (nameOfProcedure),new Double(num)});

							System.out.println(newProcedure.getProc());
						}
						String []empty={""};
						listInvProcedureRight.setListData(empty);

					}catch(Exception ex){

					}
				}	
			}
			else if(ev.getSource()==btnDelateInvoice){

				tm4Invoice= (DefaultTableModel)table_2.getModel();
				tableInvoicesInfo.repaint();
				table_2.setModel(tm4Invoice);

				deleteAllRows(tm4Invoice);
				DefaultTableModel tm3=(DefaultTableModel)tableInvoicesInfo.getModel();
				int rowSelected= tableInvoicesInfo.getSelectedRow();
				Patient p= new Patient();
				int invoicePatienId= Integer.parseInt(tInvoicesPatientIdNo.getText());
				p=findPatient(invoicePatienId);
				Invoice inv= new Invoice();
				int invoiceId= Integer.parseInt((String) tm3.getValueAt(rowSelected, 0));
				LinkedList<Invoice>invoicelist= new LinkedList<Invoice>();
				invoicelist=p.getP_invoice();
				tm3.removeRow(tableInvoicesInfo.getSelectedRow());
				tableInvoicesInfo.setModel(tm3);


				inv= searchInvoice(invoiceId,invoicelist);
				p.getP_invoice().remove(inv);	
			}	

			else if(ev.getSource()==btnEditInvoProce){

				if(tInvoicesPatientName.getText().isEmpty() || tInvoicesPatientIdNo.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "One of the required field is empty","Error!!!", JOptionPane.ERROR_MESSAGE, null);
					tInvoicesPatientIdNo.setText("Fill up");
					tInvoicesPatientName.setText("Fill up");
				}
				else{

					try{
						tm3Invoices= (DefaultTableModel)tableInvoicesInfo.getModel();
						int rowSelectedInvoice= tableInvoicesInfo.getSelectedRow();
						tInvoiceTotal.setText(tm3Invoices.getValueAt(rowSelectedInvoice, 1).toString());


						String xx=null;
						xx=tm3Invoices.getValueAt(rowSelectedInvoice, 2).toString();
						if(xx.equals("true")){
							xx="Yes";
						}
						else{
							xx="No";
						}
						comboBoxInvoicePaidYN.setSelectedItem(xx);

						editableInvoice= true;



						String d=(String) tm3Invoices.getValueAt(rowSelectedInvoice, 3);
						Date date = null;
						try {
							date = new SimpleDateFormat("dd-MM-yyyy").parse(d);
						} catch (ParseException e) {

							e.printStackTrace();
						}
						dateChooserInvoices.setDate(date);

					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Select Invoice to edit Details","Error",JOptionPane.ERROR_MESSAGE,null);
						//editableHistory = false; //???????????????delate it test only
					}

				}//else

			}
		}
	}


	public Invoice searchInvoice(int invoiceNum,LinkedList<Invoice> invoiceP) 
	{
		Invoice invoice= new Invoice();
		invoiceP=patient.getP_invoice();
		for(int i=0;i<invoiceP.size();i++){
			invoice=invoiceP.get(i);
			if((invoice.getInvoiceNum()==invoiceNum)){
				return invoice;
			}
		}
		return null;
	}

	private History findHistory(LinkedList<History> hist, int historyId) 
	{
		History history= new History();
		for(int i=0;i<hist.size();i++){
			history=hist.get(i);
			if(history.getHistId()==historyId){
				return history;
			}
		}
		return null;
	}


	public void reset() {
		tm2History.setRowCount(0);
	}

	public boolean checkPay(String chekPaid) 
	{
		if(chekPaid.equals("No"))
		{
			return false;
		}

		else if(chekPaid.equals("Yes"))
		{
			return true;
		}
		return false;
	}


	private void deleteAllRows(DefaultTableModel model){
		for(int m=model.getRowCount()-1;m>=0;m--){
			model.removeRow(m);
		}
	}
	private Patient searchPatient(String historyName,int historyPatientId){
		Patient patient= new Patient();
		ArrayList<Patient> pL= new ArrayList<Patient>();
		pL=patientList.getPatientList();
		for(int i=0;i<pL.size();i++){
			patient=pL.get(i);
			if(patient.getPatientName().equals(historyName)&&(patient.getPatientId()==historyPatientId)){
				return patient;
			}
		}
		return null;
	}
	private Patient findPatient(int historyPatientId){
		Patient patient= new Patient();
		ArrayList<Patient> pL= new ArrayList<Patient>();
		pL=patientList.getPatientList();
		for(int i=0;i<pL.size();i++){
			patient=pL.get(i);
			if((patient.getPatientId()==historyPatientId)){
				return patient;
			}
		}
		return null;
	}

	public Object GetData(JTable table, int row_index, int col_index){
		return table1PatientInfo.getModel().getValueAt(row_index, col_index);
	}
	private void emptyTextFildsHistoryForm(){
		tHistoryPatientName.setText("");
		tHistoryPatientIdNo.setText("");
		//tHistoryCondition.setText("");
		tHistorydateChooser.setCalendar(null);
		tHistoryPatientIdNo.setText("");
		tHistoryMedication.setText("");
		//tHistoryMedication.requestFocus();
	}
	private void emptyTextFiledsPatientForm() {
		tPatientIdNum.setText(""+patient.getPatientId());
		tPatientName.setText("");
		tPatientAddress.setText("");
		tPatientPhone.setText("");
		tPatientIdNum.requestFocus();
	}

	private void emptyTextFildsHistory() {
		//tHistoryCondition.setText("");
		tHistorydateChooser.setDate(null);
		tHistoryMedication.setText("");

	}

	private void emptyTextFildsInvoices() {
		dateChooserInvoices.setDate(null);
	}



	public Color getBtnPatientBackground() {
		return btnPatient.getBackground();
	}
	public void setBtnPatientBackground(Color background) {
		btnPatient.setBackground(background);
	}

	public void displayLastHistory(Patient p,LinkedList<History>historyList,DefaultTableModel tm2History,History his)
	{
		historyList=patient.getPatientHistory();
		tableHistoryInfo.setModel(tm2History);
		his=historyList.getLast();
		String hId= ""+his.getHistId();
		String hCondN=his.getConditionName();
		String hDatOcc= his.getDateOccured();
		String hMedi= his.getMedication();
		tm2History.addRow(new Object[]{new String(hId),new String(hCondN),new String(hDatOcc),new String(hMedi)});	
		tm2History.fireTableDataChanged();
	}





	@SuppressWarnings("rawtypes")
	private class SortedComboBoxModel extends DefaultComboBoxModel  {


		private static final long serialVersionUID = 1L;



		@SuppressWarnings("unchecked")
		public SortedComboBoxModel(Object[] items) {
			Arrays.sort(items);
			int size = items.length;
			for (int i = 0; i < size; i++) {
				super.addElement(items[i]);
			}
			setSelectedItem(items[0]);
		}



		@Override
		public void addElement(Object element) {
			insertElementAt(element, 0);
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public void insertElementAt(Object element, int index) {
			int size = getSize();
			//  Determine where to insert element to keep model in sorted order            
			for (index = 0; index < size; index++) {
				Comparable c = (Comparable) getElementAt(index);
				if (c.compareTo(element) > 0) {
					break;
				}
			}
			super.insertElementAt(element, index);
		}



	}
	
	
	
	
	

	
	

	public String extractDigits(String src) 
	{
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < src.length(); i++) {
			char c = src.charAt(i);
			if (Character.isDigit(c)) {
				builder.append(c);
			}
		}
		return builder.toString();
	}



	private void setCheckStatus(int checkStatus) {
		MainFrame.checkStatus=checkStatus;

	}

	static String 	fileName="data.bin";
	private JCheckBoxMenuItem chckbxmntmLoadFromFile;
	private JCheckBoxMenuItem chckbxmntmLoadFromDatabase;
	private JPanel panelReports;
	@SuppressWarnings("rawtypes")
	private JList listReport1;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane_7;
	@SuppressWarnings("rawtypes")
	private JList listReport2;
	private JButton btnNewButton;
	private JScrollPane scrollPane_8;
	private JPanel panel;
	private JMenuItem mntmAddNewCondition;
	private JMenuItem mntmRemoveCondition;
	public static void save(){	
		try {
			ObjectOutputStream os= new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(patientList);
			os.writeObject(listOfProcedures);
			os.writeObject(itemsComboConditions);
			os.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("saved");
	}

	@SuppressWarnings("unchecked")
	public static void load(){


		try {
			ObjectInputStream is= new ObjectInputStream(new FileInputStream(fileName));
			patientList= (PatientList) is.readObject();

			listOfProcedures=(LinkedList<String>) is.readObject();
			itemsComboConditions=(ArrayList<String>) is.readObject();

			System.out.println(listOfProcedures+" kkkkkkkkk");
			System.out.println(itemsComboConditions+" cccccccccccccccc");
			System.out.println(patientList.getPatientList());
			is.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}



	}
}

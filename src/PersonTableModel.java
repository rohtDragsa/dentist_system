/*
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


public class PersonTableModel extends AbstractTableModel {

	private ArrayList<Patient> patientList;
	
	

	
	private String colNames[]={"ID","Name","Address","Phone"};
	
	
	public void setData(ArrayList<Patient> patientList2){
		 this.patientList=patientList2;
	}
	
	
	public PersonTableModel(){}
	
	public String getColumnName(int i){
		return colNames[i];
	}
	
	
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return patientList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Patient patient= patientList.get(row);
		
		switch(col){
		
		case 0:
			return patient.getPatientId();
		case 1:
			return patient.getPatientName();
		case 2:
			return patient.getPatientAddress();
		case 3:
			return patient.getPatientPhone();
		case 4:
			return patient.getPatientHistory();
		
		}
		return null;
	}

}
*/
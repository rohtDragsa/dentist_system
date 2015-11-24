import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;


public class PatientList implements Serializable {
	
	private ArrayList<Patient> patient_List= new ArrayList<Patient>();
	private Vector<String> items = new Vector<String>();
	
	private int patientListPatientId=0;
	
	
	public int getPatientListPatientId() {
		return patientListPatientId;
	}


	public void setPatientListPatientId(int patientListPatientId) {
		this.patientListPatientId = patientListPatientId;
	}


	public PatientList(){
		
	}


	public void addPatient(Patient patient){
		patient_List.add(patient);
	}
	public void removiePatient(Patient p) {
		patient_List.remove(p);
	}

	
	public ArrayList<Patient> getPatientList(){
		return patient_List;
	}


	public void setPatient_List(ArrayList<Patient> patient_List) {
		this.patient_List = patient_List;
	}


	//********PRINT PATIENT LIST**********//
	public void printPatientList()
	{
		Patient p= new Patient();
		System.out.println("I am in the patientList class printing all patients I have and history");
		for(int i=0;i<patient_List.size();i++){
			p=patient_List.get(i);
			p.printPatientAndHistory();
			p.printKurwaInvoice();
		}
	}


	
	
	
	public Vector<String> getItems() {
		return items;
	}


	public void setItems(Vector<String> items) {
		this.items = items;
	}

}
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;


public class Patient implements Serializable {

	


	private int patientId;
	private String patientName;
	private String patientAddress;
	private String patientPhone;

	//********HisotryId*********//
	private int historyIdPatient=0;
	private int invoiceIdPatient=0;


	//****************************************************//

	public int getInvoiceIdPatient() {
		return invoiceIdPatient;
	}
	public int setInvoiceIdPatient(int invoiceIdPatient) {
		return this.invoiceIdPatient = invoiceIdPatient;
	}


	private LinkedList<History> p_history=new LinkedList<History>(); 
	private LinkedList<Invoice>p_invoice= new LinkedList<Invoice>();


	//create invoice
	Iterator<History> iterator;
	public LinkedList<Invoice> getP_invoice() {
		return p_invoice;
	}

	public Patient() {
	}
	public Patient(int patietntId,String patientName,String patientAddress,String patientPhone){
		setPatientName(patientName);
		setPatientAddress(patientAddress);
		setPatientPhone(patientPhone);
		setPatientId(patietntId);
		
	}


	public void setP_history(LinkedList<History> p_history) {
		this.p_history = p_history;
	}
	public void setP_invoice(LinkedList<Invoice> p_invoice) {
		this.p_invoice = p_invoice;
	}



	public int getHistoryIdPatient() {
		return historyIdPatient;
	}
	public int setHistoryIdPatient(int historyIdPatient) {
		return this.historyIdPatient = historyIdPatient;
	}



	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}







	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientName() {
		return patientName;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getPatientPhone() {
		return patientPhone;
	}



	public LinkedList<History> getPatientHistory(){
		return p_history;
	}



	




	/*public void addHistoryToPatient( int histId,String conditionName, String dateOccured, String medication){
		p_history.add(new History( histId,conditionName,dateOccured,medication));
	}*/

	public String returnPateintAndHistoryList(){
		String p;	

		p= "Patient Id:  "+getPatientId()+"\nName: "+getPatientName()+"\nAddress: "+getPatientAddress()+"\nPhone Number: "+ getPatientPhone()+"\n"+"\n";

		for( int i=0;i<p_history.size();i++){
			p+=p_history.get(i).getHistory();

		}





		return p;
	}
	public String returnInvoices(){
		String f;
		f= "Patient Idfff:  "+getPatientId()+"\nName: "+getPatientName()+"\nAddress: "+getPatientAddress()+"\nPhone Number: "+ getPatientPhone()+"\n"+"\n";



		for( int i=0;i<p_invoice.size();i++){
			f+=p_invoice.get(i).getInvoice();

		}
		return f;
	}


	public void printPatientAndHistory(){

		System.out.println(returnPateintAndHistoryList());

	}
	public void printKurwaInvoice(){
		System.out.println(returnInvoices());
	}


	/*public String toString(){
	iterator= p_history.iterator();

	String p= "Patient Id:  "+getPatientId()+"\nName: "+getPatientName()+"\nAddress: "+getPatientAddress()+"\nPhone Number: "+ getPatientPhone()+"\n";

	if(p_history!=null)
	{
		while(iterator.hasNext()){
		p+=iterator.next().getHistory();
	}
	}
	return p;
}*/


}

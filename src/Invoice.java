import java.io.Serializable;
import java.util.LinkedList;


public class Invoice implements Serializable {
	private int procedureNum=0;
	private double total=0;
	
	public int getProcedureNum() {
		return procedureNum;
	}
	public int setProcedureNum(int procedureNum) {
		return this.procedureNum = procedureNum;
	}
	private int invoiceNum;
	private double invoiceAmt;
	private String invoiceDate;
	private boolean invoicePaid;
	private LinkedList<Procedure> invoiceProcList= new LinkedList<Procedure>();
	

	public Invoice(){}
	public Invoice(int invoiceNum, double invoiceAmt, String invoiceDate,boolean invoicePaid){

		setInvoiceNum(invoiceNum);
		setInvoiceAmt(invoiceAmt);
		setInvoiceDate(invoiceDate);
		setInvoicePaid(invoicePaid);
		
	}
	public int getInvoiceNum() {
		return invoiceNum;
	}
	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	public double getInvoiceAmt() {
		return invoiceAmt;
	}
	public double setInvoiceAmt(double invoiceAmt) {
		return this.invoiceAmt = invoiceAmt;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public boolean getIsInvoicePaid() {
		return invoicePaid;
	}
	public void setInvoicePaid(boolean invoicePaid) {
		this.invoicePaid = invoicePaid;
	}
	
	public LinkedList<Procedure> getInvoiceProcList() {
		return invoiceProcList;
	}
	public void setInvoiceProcList(LinkedList<Procedure> invoiceProcList) {
		this.invoiceProcList = invoiceProcList;
	}
	public void addProcedure(Procedure addingProcedure)
	{
		invoiceProcList.add(addingProcedure);
	}

	


	public String getInvoice(){
		String f;
		f = "\nInvoice Number: " + getInvoiceNum()+ "\nInvoice Amount: Û" + getInvoiceAmt()+"\nInvoice Date : " + getInvoiceDate()+"\nInvoice Paid: " + checkPay();
		
		for(int i =0; i<invoiceProcList.size();i++){
			f += invoiceProcList.get(i).getProc();
		}
		return f;

	}
	public String checkPay()
	{
		if(invoicePaid == true)
			return "Yes";
		else
			return "No";
	}
	public double setProcCost(double num) {
		return this.total=(int) num;
		
	}
	public double getProcCost() {
		return total;
		
	}
}

import java.io.Serializable;


public class History implements Serializable {
	
	private int histId;
	private String conditionName;
	private String dateOccured;
	private String medication;
	
	public History() {}
	public History(int histId,String conditionName,String dateOccured,String medication){
		setHistId(histId);
		setConditionName(conditionName);
		setDateOccured(dateOccured);
		setMedication(medication);
	}

	public int getHistId() {
		return histId;
	}
	public void setHistId(int histId) {
		this.histId = histId;
	}
	public int getHistoryId(){
		return histId;
	}
	public String getConditionName() {
		return conditionName;
	}
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	public String getDateOccured() {
		return dateOccured;
	}
	public void setDateOccured(String dateOccured) {
		this.dateOccured = dateOccured;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	
	
	public String getHistory() {
		String h= "History Id: "+getHistoryId()+"\nCondition Name: "+ getConditionName()+ "\nDate Occured: "+ getDateOccured()+"\nMedication: "+getMedication()+"\n";
		return h;
	}
	public void printHistory(){
		System.out.println(getHistory());
	}
}

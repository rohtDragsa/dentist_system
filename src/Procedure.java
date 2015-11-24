import java.io.Serializable;


public class Procedure implements Serializable {
	private int procNum;
	private String procName;
	private double procCost;
public Procedure(){}
	public Procedure(int procNum, String procName, double procCost){
		this.procNum = procNum;
		this.procName = procName;
		this.procCost = procCost;
	}

	public int getProcNum() {
		return procNum;
	}

	public void setProcNum(int procNum) {
		this.procNum = procNum;
	}

	public String getProcName() {
		return procName;
	}

	public void setProcName(String procName) {
		this.procName = procName;
	}

	public double getProcCost() {
		return procCost;
	}

	public void setProcCost(double procCost) {
		this.procCost = procCost;
	}

	public String getProc()
	{
		String myString = ("\nProcedure Num:"+getProcNum() + "\nProcedure Name "+ getProcName() + "\nCost "+getProcCost());
		
		return myString;
	}

}

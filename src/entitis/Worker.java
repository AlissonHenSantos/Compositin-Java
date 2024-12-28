package entitis;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entitis.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private double baseSalary;
	
	private Departament department;
	private List<HourContract> contracts = new ArrayList<>();;
	
	
	public Worker() {
		
	}


	public Worker(String name, WorkerLevel level, double baseSalary, Departament department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public WorkerLevel getLevel() {
		return level;
	}


	public void setLevel(WorkerLevel level) {
		this.level = level;
	}


	public double getBaseSalary() {
		return baseSalary;
	}


	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}


	public Departament getDepartment() {
		return department;
	}


	public void setDepartment(Departament department) {
		this.department = department;
	}


	public List<HourContract> getContracts() {
		return contracts;
	}

	
	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}
	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if(c_year == year && c_month == month){
				sum += c.totalValue();
			}
		
		}
		return sum;
	}


	@Override
	public String toString() {
		return "Worker [name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + ", department=" + department
				+ "]";
	}
	
	
}

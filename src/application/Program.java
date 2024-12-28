package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entitis.Departament;
import entitis.HourContract;
import entitis.Worker;
import entitis.enums.WorkerLevel;



public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.print("Enter department's name: ");
		String dp = sc.nextLine();
		System.out.print("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(dp));
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.printf("Enter number contract %d data:", i);
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Value per hour");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours)");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
			
		}
		
		System.out.print("Enter month and year to calculate income(MM/YYYY)");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("income for : " + monthAndYear +  String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}

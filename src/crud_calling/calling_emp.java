package crud_calling;

import java.util.Scanner;

import employee_bo.EmployeeBo;
import employee_doa.EmployeeDoa;

public class calling_emp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice;
		do{
		System.out.println("1:DataInsertion");
		System.out.println("2:DataDeletion");
		System.out.println("3:DataUpdate");
		System.out.println("4:DataFetch");
		System.out.println("5:exit");
		System.out.println("enter your choice");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("enter name");
			String name=sc.next();
			System.out.println("enter email");
			String email=sc.next();
			
			EmployeeBo eb1=new EmployeeBo();
			eb1.setName(name);
			eb1.setEmail(email);
			
			int status=EmployeeDoa.empDataInsert(eb1);
			if(status>0) {
				System.out.println("data inserted successfully");
			}
			else {
				System.out.println("something went wrong");
			}
			break;
		case 2:
			System.out.println("enter id to delete");
			int id1=sc.nextInt();
			int statuss=EmployeeDoa.empDataDeletion(id1);
			
			if(statuss>0) {
				System.out.println("data deleted successfully");
			}
			else {
				System.out.println("something went wrong");
			}
			break;
		case 3:
			System.out.println("enter id to update");
			int a=sc.nextInt();
			System.out.println("enter name");
			String namee=sc.next();
			System.out.println("enter email");
			String emaill=sc.next();
			EmployeeBo eb3=new EmployeeBo();
			eb3.setId(a);
			eb3.setName(namee);
			eb3.setEmail(emaill);
			int s=EmployeeDoa.empDataUpdate(eb3);
			if(s>0) {
				System.out.println("data updated successfully");
			}
			else {
				System.out.println("something went wrong");
			}
			break;
		case 4:
			EmployeeBo eb4=new EmployeeBo();
			int z=EmployeeDoa.empDataFetch(eb4);
			break;
			
		case 5:
			System.exit(0);
			break;
			}		
		
		}while(choice!=5);
	}

}
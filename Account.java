package Atmmachine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
public class Login extends Account {
	double balance=0;
	int ref=0;
	String phn="";
	
	Scanner sc=new Scanner(System.in);
	HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
	HashMap<Integer,String> h2=new HashMap<Integer,String>();
	public void getLogin() throws IOException{
		int x=1;
			try {
				h.put(12400110,7181);
				h.put(12400111,6171);
				h.put(12400112,5161);
				h.put(12400113,4151);
				System.out.println("\n\t\t\t\t\t\t     WELCOME TO LAKSHMI VILAS ATM!");
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.print("\nEnter Account Number :");
				setAccno(sc.nextInt());
				System.out.print("Enter PIN Number :");
				setPin(sc.nextInt());
				
				
			}catch(Exception e) {
				ref=1;
				System.out.println("\n*TRANSACTION FAILED*\n  Invalid Characters!\n");
				
				
			}
			for(Entry<Integer,Integer> en:h.entrySet()) {
				
				if(en.getKey()==getAccno() && en.getValue()==getPin()) {
					ref=2;
					System.out.print("\nWelcome Mr."+getName());
					enterAccount();
					break;
					}
				
		          }
			if(ref==0) {
			System.out.println("\nWrong PIN or Account Number!");
			}
			
			
			
}
	public void enterAccount() {
		System.out.println("\n\t\t\t\t\t\t\t  SELECT YOUR PROCESS");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\nEnter:1- To Check Balance");
		System.out.println("Enter:2- To Credit Amount");
		System.out.println("Enter:3- To Withdraw Amount");
		System.out.println("Enter:4- To Reset PIN");
		System.out.println("Enter:5- To see Previous Transactions");
		System.out.println("Enter:6- To Change Phone Number");
		System.out.println("Enter:7- Account Enquiry");
		System.out.println("Enter:8- Exit");
		System.out.print("Enter :");
		int enter=sc.nextInt();
		switch(enter) {
		case 1:
			System.out.println();
			System.out.println(getBalance());
		    loop();
			break;
		case 2:
			System.out.println(Credit());
			loop();
			break;
		case 3:
			Debit();
			loop();
			break;
		case 4:
			pinReset();
			break;
		case 5:
			previousTranscation();
			loop();
			break;
		case 6:
			changeNum();
			break;
		case 7:
			accEntquiry();
			loop();
			break;
			
		case 8:
			System.out.println("\n*THANK YOU\nYOU EXIT FROM THE PROCESS*");
			break;
		default:
			System.out.println("Invalid Choice\nRestart your process!");
			enterAccount();


			}
}
	public void loop() {
		System.out.println("\nDo you want to continue the process?\nEnter :1-> YES\nEnter :2-> NO");
		int s=sc.nextInt();
		
		switch(s) {
		case 1:
			enterAccount();
			break;
		case 2:
			System.out.println("\nThank you!\nYou Exit from the Process!");
			
			break;
		default:
			System.out.println("\nInvalid Choice !");
			loop();
			}
	}
	public void pinReset(){
		int pref=0;
		h2.put(12400110,"9994670550");
		h2.put(12400111,"7708334415");
		h2.put(12400112,"9488293930");
		h2.put(12400113,"9488293930");
	
		System.out.print("\nEnter the Phone Number Associate with your Account :");
		String phn=sc.next();
		for(Entry<Integer,String> en:h2.entrySet()) {
			
			if(en.getKey()==getAccno() && en.getValue().equals(phn)) {
				pref=1;
			
				
				double a=(Math.random()*((70000-20000)+1)+20000);
				int c=(int)a;
				System.out.println("\nYour OTP :"+c);
				System.out.print("Enter the OTP sent to you :");
				int s=sc.nextInt();
				
				if(c==s) {
					pref=2;
					System.out.print("\nEnter the 4-digit new PIN :");		
					int x=sc.nextInt();
					System.out.print("Confirm new PIN :");
					int y=sc.nextInt();
					String con=Integer.toString(x);
					String con2=Integer.toString(y);
					if(con.length()==4 && con2.length()==4) {
						
					if(x==y) {
						pref=3;
						h.replace(getAccno(),x);
				        System.out.println("\n*YOUR PIN HAS SUCCESSFULLY CHANGED*");
				        System.out.println();
				        loop();		
				}
				}
				}
				}	
}
		if(pref==0) {
			System.out.println("\nEntered phone number is not link with your account !\nRestart your process !");
		pinReset();
		}
		if(pref==1) {
			System.out.println("\nOTP does not match !\nRestart your process !");
			pinReset();	
		}
		if(pref==2) {
			System.out.println("\nPIN does not match !\nRestart your process !");
			pinReset();
		}
			
	}
	public void changeNum(){
		h2.put(12400110,"9994670550");
		h2.put(12400111,"7708334415");
		h2.put(12400112,"9488293930");
		h2.put(12400113,"9488293930");
		int pref1=0;
	     System.out.print("\nEnter the Phone Number Associate with your Account :");
		String phn1=sc.next();
		for(Entry<Integer,String> en:h2.entrySet()) {
			if(en.getKey()==getAccno() && en.getValue().equals(phn1)) {
				pref1=1;
				double a=(Math.random()*((70000-20000)+1)+20000);
				int c=(int)a;
				System.out.println("\nYout OTP :"+c);
				System.out.print("Enter the OTP sent to you :");
				int s=sc.nextInt();
				if(c==s) {
					pref1=2;
					System.out.print("\nEnter the new 10-digit Phone Number :");		
					String x=sc.next();
					System.out.print("Confirm new Phone Number :");
					String y=sc.next();
						if(x.length()==10 && y.length()==10) {
						if(x.equals(y)) {
						pref1=3;
						  System.out.println("\n*YOUR PHONE NUMBER HAS UPDATED*");
				        System.out.println();
				        loop();		
				}
					}
				}
				}	
}
		if(pref1==0) {
			System.out.println("\nEntered phone number is not link with your account !\nRestart your process !");
		changeNum();
	}
		if(pref1==1) {
			System.out.println("\nOTP does not match !\nRestart your process !");
			changeNum();
		}
		if(pref1==2) {
			System.out.println("\nEnter 10 digit numbers !\nRestart your process !");
			changeNum();
		}

	
}
}

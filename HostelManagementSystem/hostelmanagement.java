import java.util.*;
import java.util.ArrayList;
class student
{
	
	//member variables of student class	
	public int registerNo ;
	public String name;
	public int year;
	public String address;
	public String phone;
	


	//Default constructor
	student() 
	{
		this(0, "", 0, "", "");
	}
	
	
	//Parameterised constructor	
	 student(int regNo, String sname, int yr, String add, String no)
	{
		registerNo = regNo;
		name = sname;
		year = yr;
		address = add;
		phone = no;
		
	}
}

	

 class hostel extends student
{
	public String roomType;
	public int roomNo;
	public String messNeeded;
	public String laundryNeeded;
	
	
	
	public int laundryFee;
	public int messFee;
	public String laundryPay;
	public String messPay;
	
	
	
	hostel()
	{
		this(0, "", 0, "", "", "", 0, "no", "no");
	}

	
	hostel(int regNo, String sname, int yr, String add, String no, String type, int roomno, String mess, String laundry)
	{
		super(regNo, sname, yr, add, no);
		roomType = type;
		roomNo = roomno;
		messNeeded = mess;
		laundryNeeded = laundry;
		laundryFee =0;
		messFee = 0;
		laundryPay = "no";
		messPay  = "no";
	}
		
	
	public void calcMessLaundry()
	{
		if(laundryNeeded == "yes")
		{
			if(roomType == "single")
			{
				laundryFee = 1*500;
			}
			else if(roomType == "double")
			{
				laundryFee = 2*500; 
			}
			else if(roomType == "triple")
			{
				laundryFee = 3*500;
			}
			
		}
		if(messNeeded == "yes")
		{
			messFee = 2000;
			
		}
		System.out.println("Laundry Fee: "+laundryFee);
		System.out.println("Mess Fee: "+messFee);
		//totalFee = laundryFee + messFee;
	}
	
	
	public String toString()
    {
        //System.out.println("REG NO.\tNAME\tYEAR\tADDRESS\tPHONE\tROOM TYPE\tROOM NO.\tMESS NEEDED\tLAUNDRY NEEDED");
		return("\nREG NO: " +registerNo+ "  NAME: " +name + "  YEAR: " +year + "  ADDRESS: " + address + "  PHONE: " + phone + "  ROOM TYPE: " + roomType +"  ROOM NO: " + roomNo +"  MESS? " + messNeeded +"  LAUNDRY? " + laundryNeeded);
    }
	
}
	
	
	
	/*Register no Name: " +name + ",Year: " +year + "Address: " + address + "Phone: " + phone + "Room Type: " + roomType +"Room no: " + roomNo +"Mess needed? : " + messNeeded +"Laundry needed? :" + laundryNeeded+ "Mess fees: " + messFee +"\nLaundry fees:" + laundryFee+ "\nTotal amount to be paid:"+ totalFee );*/
																										

public class hostelmanagement
{	
	public static void main(String[] args) 
    {
		ArrayList<hostel> al = new ArrayList<hostel>();
		Scanner obj = new Scanner(System.in);

		int choice1=4;
		do
		{
			System.out.println("\n\t\t\t|||| HOSTEL MANAGEMENT SYSTEM ||||");
			try
			{
			System.out.println("\n\n\n\n\t\t1. Warden login \n\t\t2. Student mess & laundry\n\t\t3. Exit\n\t\t\tEnter option:");
			choice1 = obj.nextInt();

			}
			catch (NumberFormatException e) 
			{
               continue;
			}
			switch(choice1)
			{
				case 1:
				{
					System.out.println("\nEnter admin password:");
					String password = obj.next();
					
					if(password.equals("hw"))
					{
						
						int choice2;
						do
						{
							System.out.println("\n\t\t\t|||| WARDEN MENU ||||");
							System.out.println("\n\n\n\t\t1. View students  \n\t\t2. Search student\n\t\t3. View student fee details\n\t\t4. Delete Student\n\t\t5. Add student\n\t\t6. Exit\n\t\t\tEnter option:");
							choice2 = obj.nextInt();
							switch(choice2)
							{
								case 1:
									for (hostel i : al)              
									{
										System.out.println(i);
									}
									break;
									
									
								case 2:
									
									System.out.println("\n\t\t1. Search by name  \n\t\t2. Search register number\n\t\t\tEnter option:");
									int choice3 = obj.nextInt();
									if(choice3 == 1)
									{
										System.out.println("Enter name to search: ");
										String sname  = obj.next();
										for (hostel i : al)              
										{
											if(sname.equals(i.name))
											{
												System.out.println("\n\n\t\t\t**** Details of "+i.name+" ****");
												System.out.println(i);
											}
										}
									}
									else
									{
										System.out.println("Enter register no to search: ");
										int reg = obj.nextInt();
										for (hostel i : al)              
										{
											if(reg == i.registerNo)
											{
												System.out.println("\n\n\t\t\t**** Details of "+i.name+" ****");
												System.out.println(i);
												break;
											}
										}
									}
									break;
									
									
								case 3:
									
									System.out.println("\n\t\t1. View students who have not paid laundry fees\n\t\t2. View students who have not paid mess fees");
									int choice5 = obj.nextInt();
									
									if(choice5 == 1)
									{
										System.out.println("\n\n\nTHE FOLLOWING STUDENTS HAVE NOT PAID LAUNDRY FEES:");
										for (hostel i : al)              
										{
											if((i.laundryNeeded.equals("yes")) && (i.laundryPay.equals("no")))
											{
												System.out.println(i);
											}
										}
									}
									else
									{
										System.out.println("\n\n\nTHE FOLLOWING STUDENTS HAVE NOT PAID MESS FEES:");
										for (hostel i : al)              
										{
											if((i.messNeeded.equals("yes")) && (i.messPay.equals("no")))
											{
												System.out.println(i);
											}
										}
									}
									break;
									
								case 4:
									System.out.println("Enter name to delete: ");
									String name = obj.next();
									System.out.println("Enter register no to delete: ");
									int no = obj.nextInt();
									for (hostel i : al)              
									{
										if(no == i.registerNo && name.equals(i.name))
										{
											al.remove(i);
											break;
											
										}
									}
									System.out.println("\n\n\nDELETION SUCCESSFUL!");
									break;
									
								case 5:
								
									System.out.println("\n\t\t\t|||| Enter student details to add ||||\n\n\n");
					
									System.out.println("Enter register no: ");
									int registerNo = obj.nextInt();
					
									System.out.println("Enter name: ");
									String tname = obj.next();
				
									System.out.println("Enter year: ");
									int year = obj.nextInt();
			
									System.out.println("Enter address: ");
									String address = obj.next();
			
									System.out.println("Enter phone no: ");
									String phone = obj.next();
					
									System.out.println("Enter room type(single/double/triple): ");
									String roomType = obj.next();
			
									System.out.println("Enter room number: ");
									int roomNo = obj.nextInt();
						
									System.out.println("Mess required?(yes/no)  ");
									String messFeePaid = obj.next();
			
									System.out.println("Laundry required?(yes/no)  ");
									String laundryNeeded = obj.next();
			
									hostel hob = new hostel(registerNo, tname, year, address, phone, roomType, roomNo,messFeePaid, laundryNeeded);

									al.add(hob);
					
									break;
									
							}
						}while(choice2!=6);
					}
					else 
					{
						System.out.println("Incorrect Password!");
					}
					break;
				}
	
				
				case 2:
				{
					System.out.println("\n\t\t\t|||| MESS & LAUNDRY MENU ||||");
					System.out.println("\n\n\n\t\t1. View Fee Details  \n\t\t2. Update Paid Fees\n\t\t\tEnter option:");
					int choice4 = obj.nextInt();
					
					
					if(choice4 == 1)
					{
						System.out.println("Enter your name: ");
						String fname = obj.next();
						System.out.println("Enter your register no: ");
						int fno = obj.nextInt();
					
						for (hostel i : al)              
						{
							if(fno == i.registerNo && fname.equals(i.name))
							{
								if((i.laundryNeeded).equals("yes"))
								{
									i.laundryFee = 1000;
									System.out.println("Your laundry fees is Rs."+i.laundryFee);
								}
							
								if((i.messNeeded).equals("yes"))
								{
									i.messFee = 5000;
									System.out.println("Your mess fees is Rs."+i.messFee);
								}
							
								System.out.println("\n\n\t\t\tPay your fees on time and update it on Update Paid Fees menu!");
							}
						}
					}
					else
					{
						System.out.println("Enter your name: ");
						String fname = obj.next();
						System.out.println("Enter your register no: ");
						int fno = obj.nextInt();
						
						for (hostel i : al)              
						{
							if(fno == i.registerNo && fname.equals(i.name))
							{
								if((i.laundryNeeded).equals("yes"))
								{
									System.out.println("Have you paid your laundry fees? (yes/no)");
									String lf = obj.next();
									if(lf.equals("yes"));
									{
										i.laundryPay = "yes";
									}
								}
								
								if((i.messNeeded).equals("yes"))
								{
									System.out.println("Have you paid your mess fees? (yes/no)");
									String mf = obj.next();
									if(mf.equals("yes"));
									{
										i.messPay = "yes";
									}
								}
							}
						}
						System.out.println("\n\n\t\t\tUPDATION SUCCESSFUL!!");
					}
						
						
				}	
					
			}
		
		}while(choice1 != 3);
	}
}











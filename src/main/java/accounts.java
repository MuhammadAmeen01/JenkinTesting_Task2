import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
class accounts extends customer
{
	int saving_account_no;
	int saving_balance;
	int checking_account_no;
	int checking_balance;
	boolean save_account;
	boolean checking_account;
	int count;
	int free_count=0;
    DateTimeFormatter datf;
    LocalDateTime currentTime;;;;
    int i=0;
	customer c=new customer();
	//private int saving_account_no;
	accounts()
	{

	}
	accounts(customer c1,int saving_no,int save_balance,int check_no,int check_balance,boolean save_account1,boolean checking_account1)
	{
		count=0;
		c=c1;
		saving_account_no=saving_no;
		saving_balance=save_balance;
		checking_account_no=check_no;
		checking_balance=check_balance;
		save_account=save_account1;
		checking_account=checking_account1;
		save_account=save_account1;
		checking_account=checking_account1;
		System.out.print(c1.name +"saving accountno "+saving_account_no+"\n");
		System.out.print(c1.name +"checking accountno "+checking_account_no+"\n");
		currentTime= LocalDateTime.now();
		datf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		//this.add_node();
		
	}
	



	int enterdetails_1(accounts newNode,String account_type,int amount)
	{
       int i=0;
	if(newNode.save_account==true && newNode.checking_account==true)	
	{
		System.out.print( "You have reached your account limit\n");
		return i;
	}
	else {
			if (newNode.count == 0)
				{
		
					newNode.count++;
		
		
				}
			else if(newNode.count>0)
			{
					
					if(newNode.save_account==true && account_type.equals("saving")) 
					{
						System.out.print("Saving account already exist: \n");
						
					}
					else if(newNode.checking_account==false && account_type.equals("checking"))
					{
						System.out.print("yaaaayyy");
						Random rnd = new Random();
						int n = 100000 + rnd.nextInt(900000);
						newNode.checking_account_no=n;
						System.out.print("Your account number: "+newNode.checking_account_no+"\n");
						newNode.checking_balance=amount;
						newNode.checking_account=true;
						i++;
					}
					else if(newNode.checking_account==true && account_type.equals("checking"))
					{
						System.out.print("Checking account already exist: \n");
						
					}
					else if(newNode.save_account==false && account_type.equals("saving"))
					{
						Random rnd = new Random();
						int n = 100000 + rnd.nextInt(900000);
						newNode.saving_account_no=n;
						System.out.print("Your account number: "+newNode.saving_account_no+"\n");
						newNode.saving_balance=amount;
						newNode.save_account=true;
						i++;
					}
		
		
		
			}
	 }
	return i;
	}
	
	
	
	
	
	static accounts login(LinkedList<accounts> linked_list, accounts newNode)
	{
		int i = 0;
				System.out.print("Welcome "+ newNode.c.name+"\n");
				if(newNode.save_account==true && newNode.checking_account==true)
				{
					System.out.print("your saving acount number is:  "+ newNode.saving_account_no+"\n");
					System.out.print("Your Balance is: "+ newNode.saving_balance);
					System.out.print("your checking acount number is:  "+ newNode.checking_account_no+"\n");
					System.out.print("Your Balance is: "+ newNode.checking_balance+"\n");
					
				}
				else if(newNode.save_account==true && newNode.checking_account==false)
				{
					System.out.print("your saving acount number is:  "+ newNode.saving_account_no+"\n");
					System.out.print("Your Balance is: "+ newNode.saving_balance+"\n");
				}
				else if(newNode.save_account==false && newNode.checking_account==true)
				{
					System.out.print("your checking acount number is:  "+ newNode.checking_account_no+"\n");
					System.out.print("Your Balance is: "+ newNode.checking_balance+"\n");
				}
				
			
			return newNode;
				//newNode= newNode.next;    
		 }
	
		//return newNode;
	
	 
	 static int add_another_account1(accounts newNode,String account_type,int amount)
		{
			
		return newNode.enterdetails_1(newNode, account_type, amount);
		}
	/*static int add_another_account(int id)
	{
		 accounts newNode = new accounts(); 
		 newNode=head;
		 int i=0;
		while(newNode!=null)
		{
			if(newNode.saving_account_no==id || newNode.checking_account_no==id)
			{
				//enterdetails(newNode);
				//customer c=new customer("A","street1","saving",0223);
				//accounts a=new accounts(c,);
				i=1;
				break;
			}
				newNode= newNode.next;    
		}
	return i;
	}*/
	 static int makeDeposit(accounts newNode,String account_type1,accounts newNode1,String account_type2,int amount)
	{
		//	int amount=0;
			int tax=0;
	      //  String s="";
	        Scanner sc= new Scanner(System.in); 
            int i=0;
            if(amount == -1)
            {
            	//i=0;
            	return 0;
            }
            if(newNode.free_count>2)
            {
            	tax=10;
            }
            
            if(account_type1.equals("saving") && newNode.save_account==true)
            {
                if(account_type2.equals("saving") || newNode1.save_account==true)
                {
                	newNode.saving_balance=newNode.saving_balance-amount-tax;
                	//newNode1.saving_balance=newNode1.saving_balance+amount;
                	  i++;
                }
                else {
                	newNode.saving_balance=newNode.saving_balance-amount-tax;
                	//newNode1.checking_balance=newNode1.checking_balance+amount;
                	  i++;             
                 }
            }
            else
            {
                if(account_type2.equals("saving") || newNode1.save_account==true)
                {
                	newNode.checking_balance=newNode.checking_balance-amount-tax;
                 	//newNode1.saving_balance=newNode1.saving_balance+amount;
                 	  i++;
                }
                else {
                	newNode.checking_balance=newNode.checking_balance-amount-tax;
                   // newNode1.checking_balance=newNode1.checking_balance+amount;
                    i++;
                }
            }
         
	
		
		return i;

		
		

	}
	 
	 
	 static int makewithdrawal1(accounts newNode,int amount)
	 {
			int tax=0;
		      //  String s="";
		        Scanner sc= new Scanner(System.in); 
	            int i=0;
	            if(amount == -1)
	            {
	            	//i=0;
	            	return 0;
	            }
		        if(newNode.checking_account==false || newNode.save_account==true)
		        {
		        	
		            if(newNode.free_count>2)
		            {
		            	tax=10;
		            }
		           
		    		newNode.saving_balance=newNode.saving_balance-amount-tax;
		    		// System.out.print("Remaining amount " + newNode.saving_balance+ "\n");
		    		 newNode.free_count++;
		    		// newNode.trans.add_date("deposit");
		    		 i++;
		    		
		        }
		        else if(newNode.checking_account==true || newNode.save_account==false )
		        {
		            if(newNode.free_count>2)
		            {
		            	tax=10;
		            }
		    		newNode.checking_balance=newNode.checking_balance-amount-tax;
		    	//	System.out.print("Remaining amount " + newNode.checking_balance+"\n");
		    		newNode.free_count++;
		    		//.trans.add_date("deposit");
		    		i++;
		        }
		
			
			return i;

	 }
/*	void makeWithdrawal(int id)
	{
		 accounts newNode = new accounts(); 
		 newNode=head;
			int amount=0;
			int tax=0;
	        String s="";
	        Scanner sc= new Scanner(System.in); 
	        System.out.print("Enter your account type? ");
	        s=sc.next();
		while(newNode!=null)
		{

	        if(s.equals("saving") && newNode.save_account==true && newNode.saving_account_no==id)
	        {
	            if(newNode.free_count>2)
	            {
	            	tax=10;
	            }
	        	System.out.print("How much amount you want to withdraw? ");
	    		amount=sc.nextInt();
	    		newNode.saving_balance=newNode.saving_balance-amount-tax;
	    	    System.out.print("Remaining amount " + newNode.saving_balance+ "\n");
	    	    newNode.free_count++;
	    	    newNode.trans.add_date("withdrawl");
	    		 break;
	    		 
	        }
	        if(s.equals("checking") && checking_account==true  && newNode.checking_account_no==id)
	        {
	            if(newNode.free_count>2)
	            {
	            	tax=10;
	            }
	            System.out.print("How much amount you want to deposit?: ");
	    		amount=sc.nextInt();
	    		newNode.checking_balance=newNode.checking_balance-amount-tax;
	    		System.out.print("Remaining amount " + newNode.checking_balance+"\n");
	    		newNode.free_count++;
	    		newNode.trans.add_date("withdrawl");
	    		break;
	        }
				newNode= newNode.next;    
		} 
		
	}*/
		static boolean checkBalance(accounts newNode,String account_type)
		{
			
			boolean a=false;	
			 if(newNode.save_account==true && account_type.equals("saving"))
				{
					    System.out.print("User's Name" + newNode.c.name+ "\n");
				        	System.out.print("Remaining Saving account's amount" + newNode.saving_balance+"\n");
				        	a=true;
				        
				}
				if(newNode.checking_account==true && account_type.equals("checking"))
				{
					        System.out.print("User's Name" + newNode.c.name+ "\n");
				    		System.out.print("Remaining Checking account's amount" + newNode.checking_balance+"\n");
				            a=true;
					
				
				}
			return a;


		}
	/*void checkBalance(int id)
	{
		
		 accounts newNode = new accounts(); 
		 newNode=head;
		 while(newNode!=null)
		 {
			if(newNode.saving_account_no==id || newNode.checking_account_no==id)
			{
				    System.out.print("User's Name" + newNode.c.name+ "\n");
			        if(newNode.save_account==true)
			        {
			        	System.out.print("Remaining Saving account's amount" + newNode.saving_balance+"\n");
			        }
			        if(newNode.checking_account==true)
			        {
			    		System.out.print("Remaining Checking account's amount" + newNode.checking_balance+"\n");
			        }
				
				break;
			}

				newNode= newNode.next;    
		 }
		


	}*/
	static void printStatement(LinkedList<accounts>linked_list,accounts newNode)
	{
           System.out.println(linked_list);
		   if(linked_list.contains(newNode)==true)
            {
			   

					System.out.print("User's name: "+ newNode.c.name+"\n");
					System.out.print("Date  account was creates: "+ newNode.datf.format(newNode.currentTime));
					//.id..trans.newnode=new transaction();
					//while(newNode.trans.newnode!=null)
					//{
						//System.out.print(newNode.trans.newnode.transaction_type+"\n");
						//System.out.print(newNode.trans.newnode.date+"\n");
						//newNode.trans.newnode=newNode.trans.newnode.next;
					//}
					
				
            }

				//newNode= newNode.next;    
		 
	}
	
	 static int transfer1(accounts newNode,String account_type1,accounts newNode1,String account_type2,int amount)
	{
		//	int amount=0;
			int tax=0;
			boolean a=false;
	      //  String s="";
	        Scanner sc= new Scanner(System.in); 
           int i=0;
           if(amount == -1)
           {
           	//i=0;
           	return 0;
           }
           if(newNode.free_count>2)
           {
           	tax=10;
           }
           
           if(account_type1.equals("saving") && newNode.save_account==true)
           {
               if(account_type2.equals("saving") || newNode1.save_account==true)
               {
               	newNode.saving_balance=newNode.saving_balance-amount-tax;
               	newNode1.saving_balance=newNode1.saving_balance+amount;
                return newNode.saving_balance;
               	
               }
               else {
               	newNode.saving_balance=newNode.saving_balance-amount-tax;
               	newNode1.checking_balance=newNode1.checking_balance+amount;
                return newNode.saving_balance;
                         
                }
           }
           else
           {
               if(account_type2.equals("saving") || newNode1.save_account==true)
               {
               	newNode.checking_balance=newNode.checking_balance-amount-tax;
                newNode1.saving_balance=newNode1.saving_balance+amount;
                return newNode.checking_balance;
                
               }
               else {
               	newNode.checking_balance=newNode.checking_balance-amount-tax;
                 newNode1.checking_balance=newNode1.checking_balance+amount;
                 return newNode.checking_balance;
               }
           }

		
		

	}
	
	
	/*void transferAmount(int id)
	{
		
		 accounts newNode = new accounts(); 
		 newNode=head;
		 Scanner sc= new Scanner(System.in); 
         int amount=0;
         int id1=0;
		 while(newNode!=null)
		 {
			if(newNode.saving_account_no==id) 
			{
				System.out.print("Enter the account number: ");
				id1=sc.nextInt();
				accounts newNode1 = new accounts(); 
				newNode1=head;
				 while(newNode1!=null)
				 {
					if(newNode1.saving_account_no==id1) 
					{
						System.out.print("Enter Amount to transfer from your saving account: ");
						amount=sc.nextInt();
						newNode1.saving_balance=newNode1.saving_balance+amount;
						break;
					}
					else if(newNode1.checking_account_no==id1)
					{
						System.out.print("Enter Amount to transfer from your saving account: ");
						amount=sc.nextInt();
						newNode1.checking_balance=newNode1.checking_balance+amount;
						break;
					}

						newNode1= newNode1.next;    
				 }
				newNode.saving_balance=newNode.saving_balance-amount;
				
			
			}
			else if(newNode.checking_account_no==id)
			{
				System.out.print("Enter the account number: ");
				id1=sc.nextInt();
				accounts newNode1 = new accounts(); 
				newNode1=head;
				 while(newNode1!=null)
				 {
					if(newNode1.saving_account_no==id1) 
					{
						System.out.print("Enter Amount to transfer from your saving account: ");
						amount=sc.nextInt();
						newNode1.saving_balance=newNode1.saving_balance+amount;
						break;
					}
					else if(newNode1.checking_account_no==id1)
					{
						System.out.print("Enter Amount to transfer from your saving account: ");
						amount=sc.nextInt();
						newNode1.checking_balance=newNode1.checking_balance+amount;
						break;
					}

						newNode1= newNode1.next;    
				 }
				newNode.checking_balance=newNode.checking_balance-amount;
				
			}

				newNode= newNode.next;    
		 }
		
		 newNode.trans.add_date("Tranfer");
	}*/
	 
	 
	public static int calculateZakat1(LinkedList<accounts>linked_list,accounts newNode)
	{
		
		 float zaqat=1;
         if(linked_list.contains(newNode))
         {
			if(newNode.save_account==true)
			{
				zaqat=(float)(newNode.saving_balance*2.5/100);
				System.out.print("You have Zaqat Amount: " + zaqat+"\n");
				
				
			}

  
		}
         else {
        	 return 1;
         }
		if(zaqat==1)
		{
			System.out.print("You account isn't eligible for the Zaqat\n");
		}
		return (int)zaqat;
	}
	/*float calculateZakat(int id)
	{
		 accounts newNode = new accounts(); 
		 newNode=head;
		 float zaqat=1;
		while(newNode!=null)
		{
			if(newNode.saving_account_no==id)
			{
				zaqat=(float) (newNode.saving_balance*2.5/100);
				System.out.print("You have Zaqat Amount: " + zaqat+"\n");
				
				break;
			}

		 newNode= newNode.next;    
		}
		if(zaqat==1)
		{
			System.out.print("You account isn't eligible for the Zaqat\n");
		}
		return zaqat;
	}*/
	public static int displayAllDeductions(LinkedList<accounts>linked_list,accounts newNode)
	{
		 System.out.print("You had total "+ newNode.free_count+" transaction"+"\n");
		 System.out.print("total amount of tax deduction is: "+ newNode.free_count*10+"\n");
		 
     float zaqat=calculateZakat1(linked_list,newNode);
     System.out.print("You zaqat deduction: "+ zaqat+"\n");
     return (int)zaqat+ newNode.free_count*10;
     
	}
	static int  calculatelnterest(accounts newNode)
	{
		if(newNode.save_account==true)
		{
            int intrest=(int) (newNode.saving_balance*0.05);
            return 1;
		}
		else
		{
			return 0;
		}
     
	}
	public static boolean show_details(accounts newNode)
	{


				System.out.print( newNode.c.name + "\n");
				System.out.print( newNode.c.address + "\n");
				System.out.print( newNode.c.phone_no + "\n");
				if( newNode.save_account==true)
				{
					System.out.print( newNode.saving_account_no + "\n");
					System.out.print( "Saving" + "\n");
					System.out.print( newNode.saving_balance + "\n");
					 return true;
				}
				if(newNode.checking_account==true)
				{
					System.out.print( newNode.checking_account_no + "\n");
					System.out.print( "Checking" + "\n");
					System.out.print( newNode.checking_balance + "\n");
				    return true;
				}
				else {
				return false;
				}
				  
		}

	

}

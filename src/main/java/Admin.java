
import java.util.LinkedList;

public class Admin extends accounts {
      public String name;
      public int admin_no;
      public int password;
      Admin(String n,int a,int p)
      {
    	  name=n;
    	  admin_no=a;
    	  password=p;
      }
    static int delete_account(LinkedList<accounts> linked_list,accounts newNode)
    {
        //temp is used to freeing the memory
       
       if( linked_list.remove(newNode)==true)
       {
    	   return 1;
       }
       else {
    	   return 0;
       }
       
    	
    }
    boolean login1(int an,int ap)
    {
    	if(admin_no==an && password==ap)
    	{
    		return true;
    	}
    	else 
    	{
    		return false;
    	}
    }
	
}

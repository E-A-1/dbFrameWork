package com.ntt.driver;
 

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ntt.dao.CountryDAO;
import com.ntt.dao.CountryDAOException;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.domain.Country;

public class Driver
{
	public static void main(String arg[])throws DBConnectionException
	{
		List clist=null;
		int ch=0;
		int status=0;
		
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("--MENU--");
			System.out.println("1.Insert");
			System.out.println("2.Select");
			System.out.println("3. ..");
			System.out.println("Enter ur ch");
			ch=sc.nextInt(); //2
			
			switch(ch)
			{
			case 1:
				//inserting
				int result=0;
				System.out.println("enter cid"); // null
				int id=sc.nextInt();
				System.out.println("Enter cname"); // ""
				String name=sc.next();
				
				
							Country c=new Country(id,name);
							
							result=CountryDAO.insertCountry(c); // press F3 on your keyboard ..!
							// domain validations
							
							if(result!=0)
							{
								System.out.println("Country inserted successfully");
							}
							else
							{
								System.out.println("Failed to insert");
							}
				 
				break;
				
			case 2:
				try {
					
					clist=CountryDAO.getCountries(); //countries...  // F3  
					System.out.println("Details of countries are");
					
					
					System.out.println("-------------------------");
					for(Iterator it=clist.iterator();it.hasNext();)
					{
						Country c1=(Country) it.next();
						System.out.println(c1);
					}
					
					 
					
					//Geting the country details by passing the countryid
					List list1=null;
					 sc=new Scanner(System.in);
					System.out.println("\nEnter the country id\n");
					int cid=sc.nextInt();
					System.out.println("Enter the country name");
					String cname=sc.next();
					System.out.println("");
					// SID, PASSWD
					list1=CountryDAO.getCountry(cid,cname); // 200    INDIA 
					if(!(list1.isEmpty()))
					{
						// MENU FOR 
						
					System.out.println("\n\n VALID COUNTRY DETAILS \n\n");
					System.out.println("\n\n**** DETAILS OF COUNTRY *** \n\n");
					System.out.println("------------------------------------");
					for(Iterator it=list1.iterator();it.hasNext();)
						System.out.println(it.next());
					}
					else
					{
						System.out.println("Inalid country details");
					}
					
					
					
					
					
				} catch (DBFWException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CountryDAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				break;
				
			case 3:
			{
				
				
				System.out.println("calling 3 rd option .. ");
				 
				
				List list1=null;
				 sc=new Scanner(System.in);
				System.out.println("\nEnter the country id\n");
				int cid=sc.nextInt();
				System.out.println("Enter the country name");
				String cname=sc.next();
				System.out.println("");
				// SID, PASSWD
				list1=CountryDAO.getCountryName(cid, cname) ; // Name 
				
				if(!(list1.isEmpty()))
				{
					// MENU FOR 
					
				System.out.println("\n\n VALID COUNTRY DETAILS \n\n");
				System.out.println("\n\n**** DETAILS OF COUNTRY / Name *** \n\n");
				System.out.println("------------------------------------");
				for(Iterator it=list1.iterator();it.hasNext();)
				{
				    Country c1 = (Country)it.next();
				    
				    String fd = c1.getCname();
				    
				}
				
				
				
				
				}
				else
				{
					System.out.println("Inalid country details");
				}
				 
				
				
				
				
				
				
				break;
			}
				
				
				
				
				
				
				
				
				
				
				
				
				

			
			}//switch
			System.out.println("Do you wish to continue(press any number not zero)");
			status=sc.nextInt();
			 
			
		}
		while(!(status==0)); // 0   
		System.out.println("\n\n Thank You \n\n");
			
	}
}

// Book , insert new book 
/// delete book, 
//update book details
// select book details.. 







//  bookReqtable
// 

// 
// Bookmaster :   
// bookid, book name, avail(no)


// select * bookmaster where avail=yes



// BookReq/ transaction
// bookid, stid, date,       return_status
// 100      5000 11/11/22    yes                 // cancel booking 
// and update in bookmaster to "no" 


















// Availability 
// 100   

// 15

// 85

// return 
// 15

// 100









 





















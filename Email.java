/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapplication;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Email {
   private String firstName;
   private String lastName;
   private String password;
   private String department;
   private String email;
   private int mailboxCapacity=500;
   private String alternateEmail;
   private int defaultPasswordLength=10;
   private String companySuffix = "aeycompany.com";
   //constructor to recieve first and last name
   public Email(String firstName, String lastName)
   {
       this.firstName=firstName;
       this.lastName=lastName;
     //  System.out.println("Email created:" +this.firstName+" "+this.lastName);
       
       //call a method asking for department--return the department
       this.department= setDepartment();
     //  System.out.println("Department: "+this.department);
       
       //call the method that returns random password
       this.password=randomPassword(8);
       System.out.println("Your Password is : "+this.password);
       
       //combine elements to generate email
       email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
      // System.out.println("Your email is : " +this.email);
   }
   //ask for the department
   private String setDepartment()
   {
       System.out.print("New Worker: "+firstName+". Enter the Department Code \n1 for sales\n2 for devlopment\n3 for counting\n0 for none\n Enter department code: ");
       Scanner in = new Scanner(System.in);
       int depChoice = in.nextInt();
       if(depChoice == 1)
       {
           return "sales";
       }
       else if(depChoice == 2)
       {
           return "devlopment";
       }
       else if(depChoice == 3)
       {
           return "counting";
       }
       else
           return "";
   }
   
   //Generate the random password
   private String randomPassword(int length)
   {
      String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
      char[] password = new char[length];
      for(int i=0; i<length;i++)
      {
         int rand = (int)(Math.random()*passwordSet.length());
         password[i]=passwordSet.charAt(rand);
      }
      return new String(password);
      
   }
   
   //set the mailbox capacity
   public void setMailboxCapacity(int capacity)
   {
       this.mailboxCapacity=capacity;
   }
   
   //set the alternative email
   public void setAlternateEmail(String altemail)
   {
       this.alternateEmail=altemail;
   }
   
   //change the password
   public void changePassword(String password)
   {
       this.password=password;
   }
   
   //get the mailbox capacity
   public int getmailboxcapacity(){return mailboxCapacity;}
   //get the alternative email
   public String getlternateemail(){return alternateEmail;}
   //change the password
   public String getPassword(){return password;}
   
   //show method
   public String showInfo()
   {
       return "Display name : "+firstName+" "+lastName+" "+
               "\nCompany email : "+email+" "+
               "\nMailbox capacity : "+mailboxCapacity+"mb";
       
   }
}

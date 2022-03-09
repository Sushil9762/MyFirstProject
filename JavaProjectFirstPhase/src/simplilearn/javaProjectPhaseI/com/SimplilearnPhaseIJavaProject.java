package simplilearn.javaProjectPhaseI.com;
//importing the necessary libraries
import java.util.Arrays;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;

//Creating class to perform different user Actions
class Contents{
	void returnContents()
	throws IOException
	{
//		Taking user inputs to perform various tasks
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nWelCome to LockedMe.com ");
		System.out.println("\nDeveloper Details:\nSushil Kumar Yadav");
		System.out.println("\nEnter the path of Directory: ");
		String dirPath=br.readLine();
		System.out.println("\nEnter the Folder name: ");
		String folderName =br.readLine();
		
		
		File f=new File(dirPath,folderName);
		
		if(f.exists()) {
//			Asking user to perform various actions
			System.out.println("Enter the choices: 1 or 2 or 3 or 4 or 5 or 6 depending on your requirements:\n");
			System.out.println("1.List the Files in Folder   2.Create the File in Existing Folder\n");
			System.out.println("3.Write to the Existing File   4.Delete the Existing File\n");
			System.out.println("5.Search the existing File\n ");
			int num=sc.nextInt();
			switch(num) {
			case 1:
//				Shows the contents in sorted order
				String arr[]=f.list();
				Arrays.sort(arr);
				
				int n=arr.length;
				for(int i=0;i<n;i++) {
					System.out.println(arr[i]);
					
				}
				break;
				
			case 2:
//				Creates the file
				System.out.println("Enter the Filename You want to create: ");
				String f1=br.readLine();
				File newFile=new File(dirPath+"/"+folderName+"/"+f1);
				boolean value1=newFile.createNewFile();
				if(value1)
					System.out.println("File is created");
				else
					System.out.println("File Error");
				break;
				
			case 3:
//				Write the contents into the existing File, if file is not present it will create file too
				System.out.println("Select the File Name in which you want to write contents: ");
				String f2=br.readLine();
				System.out.println("Enter the contents");
				String text=br.readLine();
				FileWriter fWriter=new FileWriter(dirPath+"/"+folderName+"/"+f2);
				fWriter.write(text);
				System.out.println("Contents is written to the file ");
				fWriter.close();
				break;
				
			case 4:
//				Delete the existing File
				System.out.println("Enter the File name you want to delete: ");
				String deleteFileName=br.readLine();
				File f3=new File(dirPath+"/"+folderName+"/"+deleteFileName);
				
				if(f3.exists()) {
					f3.delete();
					System.out.println("File deleted successfully");
				}else {
					System.out.println("The file doesnot exist ");
				}
				break;
				
			case 5:
//				Search the Existing File
				System.out.println("Enter the File Name You Want Search For: ");
				String searchFileName =br.readLine();
				File f4=new File(dirPath+"/"+folderName+"/"+searchFileName);
				if(f4.exists()) {
					System.out.println("File is Present");
				}
				else {
					System.out.println("FNF");
				}
				break;
				
			default:
				System.out.println("Please Enter the Correct Choice ");
				
				
			}
			
		}
		else {
			System.out.println("Directory or Folder doesn't Exist. Please Enter the Correct Path and Folder Name");
		}
		
	}
	
	
}

public class SimplilearnPhaseIJavaProject {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		Contents ob=new Contents();
		while(true) {
			try {
				ob.returnContents();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			System.out.println("\nEnter 6 For More Options:");
			int n=s.nextInt();
			if(n==6) {
				System.out.println("\nEnter Yes to Close The App: ");
				System.out.println("\nEnter No to Return to The Main Menu: ");
				String in=s.next();
				
				if(in.equalsIgnoreCase("Yes")) {
					break;
					
				
				}
				else if(in.equalsIgnoreCase("No")){
					continue;
				}
			}
		}
		

	}

}

package fileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String rootDirectory = System.getProperty("user.dir") + "\\testFiles\\"; // 
		//System.out.println(rootDirectory);
		int choice;
		String fileName;
		do
			
		{
			System.out.println("***************************************************");
			System.out.println("*                                                 *");
			System.out.println("*           File Handling Application             *");
			System.out.println("*                                                 *");
			System.out.println("*               Nicholas Rabalao                  *");
			System.out.println("*           Java Full Stack Developer             *");
			System.out.println("*                                                 *");
			System.out.println("***************************************************");
			
			System.out.println("Operations:");
			System.out.println("  1. File creation");
			System.out.println("  2. Write in the file ");
			System.out.println("  3. Reading a file ");
			System.out.println("  4. Delete the file ");
			System.out.println("  5. Search the file");
			System.out.println("  6. List of Files ");
			System.out.println("  7. Exit");
			
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				
				System.out.print("Enter the file name to create: ");
				
				fileName = scanner.next();
				
				File newFile = new File(rootDirectory + fileName + ".txt");
				
				
				if(newFile.createNewFile())
				{
					System.out.println("File created successfully !!");
				}
				else
				{
					if(newFile.exists())
					{
						System.out.println("File already exist");
					}
					else
					{
						System.out.println("Error in creating the file !!");
					}
				}
				break;
			case  2:
				
				System.out.print("Enter the file name where you wanna write: ");
				fileName = scanner.next();
				
				Scanner sc1= new Scanner(System.in);
				
				System.out.print("Enter the content you wanna write in a file: ");
				String content = sc1.nextLine();
				
				FileWriter fw = new FileWriter(rootDirectory + fileName + ".txt");
				fw.write(content);
				
				System.out.println("Data Written in the file successfully !!");
				
				fw.close();
				break;
			case 3:
				
				System.out.print("Enter the file name whose data you wanna read: ");
				fileName=scanner.next();
				
				File f2= new File(rootDirectory + fileName + ".txt");
				Scanner sc2 = new Scanner(f2);
				
				while(sc2.hasNextLine())
				{
					String line=sc2.nextLine();
					System.out.println(line);
				}
				
				sc2.close();
				
				
				
				break;
			case 4:
				
				System.out.print("Enter file name which you wanna delete: ");
				fileName = scanner.next();
				
				File f3 = new File(rootDirectory + fileName + ".txt");
				
				f3.delete();
				
				
				if(!f3.exists())
				{
					System.out.println("File deleted successfully !!");
				}
				else
				{
					System.out.println("Error found in deleting the file !!");
				}
				
				break;
			case 5:
				
				System.out.print("Enter the file name to be searched (include file extension): ");
				fileName=scanner.next();
				
				File f5 = new File(rootDirectory);
				
				String[] list = f5.list();
				int fl=0;
				if(list==null)
				{
					System.out.println("There is no file present in the directory !");
				}
				else
				{
					for(int i=0;i<list.length;i++)
					{
						String sfile= list[i];
						if(sfile.equalsIgnoreCase(fileName))
						{
							System.out.println("File found in the directory successfully!!");
						
							fl=1;
						}
					}
					
					if(fl==0)
					{
						System.out.println("File not found !");
					}
				}
				
				
				
				break;
			case 6:
				
				System.out.println("List of Files and Folders are :");
				
				File f6 = new File(rootDirectory);
				
				File[] l1 = f6.listFiles();
				
				for(File fi: l1)
				{
					if(fi.isDirectory())
					{
						System.out.println(fi.getName());
					}
					else if(fi.isFile())
					{
						System.out.println(fi.getName());
					}
				}
				break;
			case 7:
				System.out.println("Thank you for using the Application");
				System.out.println("    ** Application closed **");
				System.exit(choice);
				break;
			default:
				System.out.println("Please enter a valid operation choice! ");
			}
		}
		while(true);
		


	}

}

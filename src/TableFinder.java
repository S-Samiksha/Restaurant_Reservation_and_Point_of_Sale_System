// package src;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.BufferedWriter;
// import java.io.FileWriter;
// import java.io.File;
// import java.io.IOException;

// public class TableFinder {

// 	public static int findTable(Reservation reservation){
		
// 		System.out.println("Loading table Data......"); 
//     	try {
//     		String filePath = new File("").getAbsolutePath();
//         	FileReader fr = new FileReader(filePath+"/src/data/table.txt"); 
// 			BufferedReader br = new BufferedReader(fr); 
// 			String line;
// 			String[] tableObject; 
// 			line = br.readLine();
// 			int numOfLine = 0;
			
//         	while(line!= null) { 
//             	tableObject = line.split("[|]"); 
// 				mainapp.TableList.add(new Table(Integer.parseInt(tableObject[0]), Integer.parseInt(tableObject[1]), Boolean.parseBoolean(tableObject[2])));
// 				/*Giving you more functions if the objects require 
// 				Integer.parseInt --> convert string to int like that of contact number
// 				Double.parseDouble --> convert string to double 
// 				Float.parseFloat --> convert float to double 
// 				string to date time --> https://www.javatpoint.com/java-string-to-date 
// 				*/
// 				line = br.readLine();
// 				numOfLine++;
//         	}
        	
// 			br.close();
			
// 			int tableNum = -1;
// 			for (int i=0 ; i<numOfLine ; i++) {
// 				Table table = mainapp.TableList.get(i);
// 				if (table.isAvailable() && reservation.getNumPeople() <= table.gettableCapacity()) {
// 					table.setisAvailable(false);
// 					tableNum = i;
// 					break;
// 				}					

// 			}	
			
// 			if (tableNum != -1) {
// 				FileWriter fw = new FileWriter(filePath+"/src/data/table.txt");
// 				BufferedWriter bw = new BufferedWriter(fw);
// 				for (int j = 0; j < numOfLine ; j++) {
// 					Table table1 = mainapp.TableList.get(j);
// 					String strTable = String.valueOf(table1.gettableNum()) + "|" + String.valueOf(table1.gettableCapacity()) + "|" + String.valueOf(table1.isAvailable()) ;
// 					bw.write(strTable);
// 					bw.newLine();
// 				}
// 				System.out.println("Write table Data successful....");
// 				bw.close();
// 			}
			
// 			return tableNum;
// 		} catch (IOException e) {
// 			e.printStackTrace();
// 			return -1;
// 		}
// 	}
// }

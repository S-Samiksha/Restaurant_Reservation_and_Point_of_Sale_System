package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
java.io.IOException;

//for conversion of flat file into objects 
public class DataAdapter<IOException, PrintWriter> {
    public DataAdapter(){

    }


        ArrayList data = new ArrayList();
		try {
			BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\shrey\\Downloads\\cz2002table.csv"));
			String line;
			while((line = file.readLine()) != null) {
				String[] splitstring = line.split(",");
				int table_num = Integer.parseInt(splitstring[0]);
				int capacity = Integer.parseInt(splitstring[1]);
				boolean available = Boolean.parseBoolean(splitstring[2]);
				ArrayList row = new ArrayList();
				row.add(table_num);
				row.add(capacity);
				row.add(available);
			    data.add(row);
			}
			file.close();

				// If you want to convert to a String[]
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(data);
		ArrayList target_row = (ArrayList) data.get(0);
		target_row.set(2,false);
		data.set(0, target_row);
		System.out.println(data);
		
		try
		{
		    PrintWriter pr = new PrintWriter("C:\\Users\\shrey\\Downloads\\cz2002table.csv");    

		    for (int i=0; i<data.size() ; i++)
		    {
		        pr.println(data.get(i));
		    }
		    pr.close();
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		    System.out.println("No such file exists.");
		}


    
}


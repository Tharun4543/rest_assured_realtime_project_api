package api.utilities;

import org.testng.annotations.DataProvider;

public class PetstorePostDataProvider {
	
	@DataProvider(name="PostBodyData")
	public String[][] setPostData()
	{
		String excel_file_path = System.getProperty("user.dir") + "//testdata//excel_data.xlsx";
		ExcelUtility exl = new ExcelUtility(excel_file_path);
		int row_count = exl.getRowCount();
		
		int col_count = exl.getColumnCount(0);
		
		String pet_store_data[][] = new String[row_count][col_count];
		System.out.println(row_count);
		System.out.println(col_count);
		
		for(int row=1;row<=row_count;row++)
		{

			for(int col=0;col<col_count;col++)
			{
				pet_store_data[row-1][col] = exl.readData(row, col);
				if (pet_store_data[row-1][col].endsWith(".0")) {
					pet_store_data[row-1][col] = pet_store_data[row-1][col].substring(0, pet_store_data[row-1][col].length() - 2); // Remove the ".0" suffix
		            
		        }
				else if(pet_store_data[row-1][col].contains(".") && pet_store_data[row-1][col].contains("E") )
				{
					double number = Double.parseDouble(pet_store_data[row-1][col]);
			        long result = (long) number; // Convert to long to remove decimal places
			        pet_store_data[row-1][col] = Long.toString(result);

				}
				else
				{
					pet_store_data[row-1][col] = exl.readData(row, col);
				}
			}
				
				//System.out.println(exl.readCellValue(row, col));
		}
		return pet_store_data;
	}
		
		
	
	
	@DataProvider(name="userNamesData")
	public String[] getUsernamesData()
	{
		String excel_file_path = System.getProperty("user.dir") + "//testdata//student_data.xlsx";
		ExcelUtility exl = new ExcelUtility(excel_file_path);
		int row_count = exl.getRowCount();
		
		
		String pet_store_usernames_data[] = new String[row_count];
		
		for(int row=1;row<=row_count;row++)
		{
			
			pet_store_usernames_data[row-1] = exl.readData(row, 0);
			
		}
		return pet_store_usernames_data;
		
		

	}
}

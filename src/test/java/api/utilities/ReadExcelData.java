package api.utilities;

public class ReadExcelData {
	
	public void readData()
	{
		String excel_path_location = ".//testdata//excel_data.xlsx";
		ExcelUtility eul = new ExcelUtility(excel_path_location);
		int row_count = eul.getRowCount();
		int col_count = eul.getColumnCount(0);
		System.out.println(row_count);
		System.out.println(col_count);
		for(int i=1;i<=row_count;i++)
		{
			for(int j=0;j<col_count;j++)
			{
				String data = eul.readData(i, j);
				if (data.endsWith(".0")) {
		            data = data.substring(0, data.length() - 2); // Remove the ".0" suffix
		            System.out.println(data);
		        }
				else if(data.contains(".") && data.contains("E") )
				{
					double number = Double.parseDouble(data);
			        long result = (long) number; // Convert to long to remove decimal places
			        System.out.println(result);

				}
				else
				{
					System.out.println(data);
				}
			}
		}
	}
	public static void main(String args[])
	{
		ReadExcelData rd = new ReadExcelData();
		rd.readData();
		
	}

}

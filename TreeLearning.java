import java.io.*;

public class TreeLearning
{
	public static void main(String[] args)
	{
		new TreeLearning();
	}

	/**
	 * Kick off the tree learning program when created
	 */
	public TreeLearning()
	{
		loadOrLearnTree();

		boolean exit = false;

		while ( ! exit)
		{
			switch (promptMenu())
			{
				// Learn from a new tree
				case 1:

					break;

				// Test decision tree accuracy
				case 2:

					break;

				// Apply


			}
		}
	}



	public void loadOrLearnTree()
	{
		while (true)
		{
			System.out.println("Would you like to learn from a .arff file or load an existing model?");
			System.out.println(" 1. Learn from a .arff file");
			System.out.println(" 2. Load an existing model file (tree)");
			System.out.println(" 3. Exit");
			System.out.println("");

			Console console = System.console();
			String selected = console.readLine("Select Option: ");
			System.out.println("");

			String filename;

			try
			{
				switch (Integer.parseInt(selected))
				{
				// Handle loading the arff file
				case 1:
					filename = console.readLine("Enter .arff file path: ");
					FileReader arff = new FileReader(filename);
					return;

				// Handle loading the existing model
				case 2:
					filename  = console.readLine("Enter model file path: ");
					FileReader model = new FileReader(filename);
					return;

				// Exit option
				case 3: System.exit(0);

				// Invalid option
				default:
					System.out.print("Invalid option, try again\n\n");
					continue;
				}
			}
			catch (FileNotFoundException e)
			{
				System.out.print("File could not be loaded, please try again\n\n");
			}
		}
	}

	public int promptMenu()
	{
		return 1;
	}
}

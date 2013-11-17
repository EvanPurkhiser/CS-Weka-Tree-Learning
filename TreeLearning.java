import java.io.*;

public class TreeLearning
{
	public static void main(String[] args)
	{
		new TreeLearning();
	}

	public TreeLearning()
	{
		loadOrLearnTree();

		while (true)
		{
			executePrimaryActions();
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

	public void executePrimaryActions()
	{
		while (true)
		{
			System.out.println("");
			System.out.println("Selcet a option");
			System.out.println(" 1. Load a new .arff file to learn from, or load a existing tree");
			System.out.println(" 2. Test the accuracy of the decision tree");
			System.out.println(" 3. Apply the decision tree to new cases");
			System.out.println(" 4. Exit");
			System.out.println("");

			Console console = System.console();
			String selected = console.readLine("Select Option: ");

			switch (Integer.parseInt(selected))
			{
			// Reload the tree
			case 1:
				loadOrLearnTree();
				break;

			// Test the accuracy of the decision tree
			case 2:
				// LOAD IN ANOTHER ARFF FILE AND PRINT THE CONFUSION MATRIX
				break;

			// Apply the decision tree against read in cases
			case 3:
				// ASK FOR A FILE AND LOAD THE DATA AND
				break;

			case 4: System.exit(0);

			// Invalid option
			default:
				System.out.print("Invalid option, try again\n\n");
				continue;
			}
		}
	}

}

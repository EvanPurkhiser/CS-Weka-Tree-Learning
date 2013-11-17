import weka.core.converters.ConverterUtils.DataSource;
import weka.core.SerializationHelper;
import weka.core.Instances;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import java.io.*;
import java.util.*;

public class TreeLearning
{
	public static void main(String[] args)
	{
		new TreeLearning();
	}

	J48 learntModel;

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
			learntModel = new J48();

			try
			{
				switch (Integer.parseInt(selected))
				{
				// Handle loading the arff file
				case 1:
					filename = console.readLine("Enter .arff file path: ");

					// Load the data source and learn the model
					DataSource source = new DataSource(filename);
					Instances train = source.getDataSet();

					// Learn the tree
					train.setClassIndex(train.numAttributes() - 1);
					learntModel.buildClassifier(train);
					break;

				// Handle loading the existing model
				case 2:
					// Deserialize the object
					filename  = console.readLine("Enter model file path: ");
					learntModel = (J48) SerializationHelper.read(filename);
					break;

				case 3: System.exit(0);

				// Invalid option
				default:
					System.out.print("Invalid option, try again\n\n");
					continue;
				}

				// Print out the loaded tree
				System.out.println("");
				System.out.println(learntModel.toString());

				return;
			}
			catch (Exception e)
			{
				System.out.println("");
				System.out.println(e.toString());
				System.out.println("File could not be loaded, please try again");
				System.out.println("");
			}
		}
	}

	public void executePrimaryActions()
	{
		while (true)
		{
			System.out.println("Selcet a option");
			System.out.println(" 1. Load a new .arff file to learn from, or load a existing tree");
			System.out.println(" 2. Save loaded tree as .model file");
			System.out.println(" 3. Test the accuracy of the decision tree");
			System.out.println(" 4. Apply the decision tree to new cases");
			System.out.println(" 5. Exit");
			System.out.println("");

			Console console = System.console();
			String selected = console.readLine("Select Option: ");

			switch (Integer.parseInt(selected))
			{
			// Reload the tree
			case 1:
				loadOrLearnTree();
				break;

			// Serialize and save the loaded tree
			case 2:
				try
				{
					String savePath = console.readLine("Filename to save (excluding .model): ");
					SerializationHelper.write(savePath + ".model", learntModel);

					System.out.println("Model saved as " + savePath + ".model");
				}
				catch (Exception e)
				{
					System.out.println("");
					System.out.println(e.toString());
					System.out.println("Unable to save tree model");
					System.out.println("");
				}
				break;

			// Test the accuracy of the decision tree
			case 3:
				String dataFile = console.readLine("Data file to test against: ");

				try
				{
					// Load in the new data
					DataSource source = new DataSource(dataFile);
					Instances testData = source.getDataSet();
					testData.setClassIndex(testData.numAttributes() - 1);

					// Cross validate learnt model against the test data
					Evaluation eval = new Evaluation(testData);
					eval.crossValidateModel(learntModel, testData, 10, new Random(1));

					// Print confusion matrix
					System.out.println(eval.toSummaryString("\nResults\n======\n", false));
					System.out.println(eval.toMatrixString());
				}
				catch (Exception e)
				{
					System.out.println("");
					System.out.println(e.toString());
					System.out.println("Unable to cross validate new data and generate confusion matrix");
					System.out.println("");
				}
				break;

			// Apply the decision tree against read in cases
			case 4:
				// ASK FOR A FILE AND LOAD THE DATA AND
				break;

			case 5: System.exit(0);

			// Invalid option
			default:
				System.out.print("Invalid option, try again\n\n");
				continue;
			}
		}
	}

}

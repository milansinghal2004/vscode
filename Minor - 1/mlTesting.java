import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class mlTesting {

    static class DataPoint {
        double[] features;                                                              // Static inner class
        String label;

        DataPoint(double[] features, String label) {
            this.features = features;
            this.label = label;
        }
    }

    // Map - used coz help to store the corresponding key-value pairs.
    public static Map<String, Integer> labelEncoding(Set<String> labels) {              // String -> label encoder
        Map<String, Integer> labelMap = new HashMap<>();                                // I/P: String & O/P: Integer
        int index = 0;
        for (String label : labels) {
            labelMap.put(label, index++);
        }
        return labelMap;
    }

    // Load dataset from CSV with text features
    public static List<DataPoint> loadData(String filePath) throws IOException {
        List<DataPoint> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        // Read the CSV file header
        String header = br.readLine();
        String[] columns = header.split(",");

        Map<String, Integer> problemTypeEncoding = new HashMap<>();                 // Collect unique string labels.
        Map<String, Integer> dataStructureEncoding = new HashMap<>();               // and assign them an integer encoding.
        Map<String, Integer> algorithmEncoding = new HashMap<>();                   // Map - used coz help to store the corresponding key-value pairs.

        Set<String> problemTypes = new HashSet<>();
        Set<String> dataStructures = new HashSet<>();                               // Eliminates the duplicate values from the csv file to be stored.
        Set<String> algorithms = new HashSet<>();                                   // Seta here are used as they ensure no use of the duplicate values.

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");                                // Split the line by comma
            problemTypes.add(values[2]);                                            // Add the problem type, DS and algo. respectively                     
            dataStructures.add(values[3]);
            algorithms.add(values[4]);
        }

        // Perform label encoding
        problemTypeEncoding = labelEncoding(problemTypes);                          // Encoding the labels collected above.
        dataStructureEncoding = labelEncoding(dataStructures);
        algorithmEncoding = labelEncoding(algorithms);

        // Re-read the file to process data points
        br = new BufferedReader(new FileReader(filePath));
        br.readLine();  // Skip the header again
        

        // Parse the file line by line
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");                                // Split the line by comma
            double[] features = new double[3];                                      // encoding string -> numeric values
            features[0] = problemTypeEncoding.get(values[2]);
            features[1] = dataStructureEncoding.get(values[3]);
            features[2] = algorithmEncoding.get(values[4]);

            String label = values[3];                                               // Use Data Structure as the label
            data.add(new DataPoint(features, label));
        }
        br.close();
        return data;
    }

    // Split the dataset into training and test sets
    public static void splitData(List<DataPoint> data, double trainRatio, List<DataPoint> trainSet, List<DataPoint> testSet) {
        Collections.shuffle(data);
        int trainSize = (int) (data.size() * trainRatio);                           // 80% of the data will be used for training
        for (int i = 0; i < trainSize; i++) {
            trainSet.add(data.get(i));
        }
        for (int i = trainSize; i < data.size(); i++) {                             // 20% of the data will be used for testing
            testSet.add(data.get(i));
        }
    }

    // Simple k-NN implementation
    public static class kNN {                                                       // initlaizing the kNN class
        int k;
        List<DataPoint> trainData;

        kNN(int k) {
            this.k = k;
        }

        public void train(List<DataPoint> trainData) {                      
            this.trainData = trainData;                                             // Store the training data in the class
        }

        public String predict(double[] features) {
            List<DataPoint> neighbors = findNearestNeighbors(features);             // Find the k nearest neighbors
            return majorityLabel(neighbors);                                        // Return the majority label for the k nearest neighbors
        }

        private List<DataPoint> findNearestNeighbors(double[] features) {
            return trainData.stream()
                    .sorted(Comparator.comparingDouble(p -> euclideanDistance(p.features, features)))
                    .limit(k)                                                       // Sort k nearest neighbors based on their Euclidean distance   
                    .collect(Collectors.toList());                                  
        }

        private double euclideanDistance(double[] features1, double[] features2) {
            double sum = 0;
            // Ensure both feature arrays are of the same length to avoid ArrayIndexOutOfBoundsException
            int length = Math.min(features1.length, features2.length);
            for (int i = 0; i < length; i++) {
                sum += Math.pow(features1[i] - features2[i], 2);
            }
            return Math.sqrt(sum);                                                   // Calculating Euclidean distance
        }

        private String majorityLabel(List<DataPoint> neighbors) {
            Map<String, Integer> labelCount = new HashMap<>();
            for (DataPoint neighbor : neighbors) {
                labelCount.put(neighbor.label, labelCount.getOrDefault(neighbor.label, 0) + 1);
            }
            return Collections.max(labelCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        }                                                                           // Return the label with the highest count
    }

    // Evaluate model accuracy
    public static void evaluateModel(List<DataPoint> testSet, kNN model) {
        int correctPredictions = 0;                                                  // Counting the number of correct predictions
        for (DataPoint point : testSet) {
            String predictedLabel = model.predict(point.features);
            if (predictedLabel.equals(point.label)) {
                correctPredictions++;
            }
        }
        double accuracy = (double) correctPredictions / testSet.size();
        System.out.println("Accuracy: " + (accuracy * 100) + "%");
    }

    // Feature extraction from problem description using basic keyword matching
    public static double[] extractFeaturesFromProblemStatement(String problemStatement, Map<String, Integer> problemTypeEncoding) {
        double[] features = new double[1];                                          // Adjust based on the number of features you want to extract

        if (problemStatement.toLowerCase().contains("array")) {
            features[0] = problemTypeEncoding.getOrDefault("Array", -1);
        } else if (problemStatement.toLowerCase().contains("graph")) {
            features[0] = problemTypeEncoding.getOrDefault("Graph", -1);        // Add more features as needed
        } else if (problemStatement.toLowerCase().contains("tree")) {             // If feature is present, set it to 1 else -1
            features[0] = problemTypeEncoding.getOrDefault("Tree", -1);
        } else if (problemStatement.toLowerCase().contains("dynamic")) {
            features[0] = problemTypeEncoding.getOrDefault("Dynamic Programming", -1);
        } else {
            features[0] = problemTypeEncoding.getOrDefault("Unknown", -1);  // Default case
        }

        return features;
    }

    // User Input Method
    public static void askUserForProblemStatementAndPredict(kNN model, Map<String, Integer> problemTypeEncoding) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your problem statement:");
        String problemStatement = scanner.nextLine();

        // Convert problem statement to features
        double[] features = extractFeaturesFromProblemStatement(problemStatement, problemTypeEncoding);

        // Predict the data structure
        String predictedLabel = model.predict(features);
        System.out.println("Predicted data structure: " + predictedLabel);
    }

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\singh\\Documents\\.vscode\\Minor - 1\\MP22.csv"; // Path to your dataset
        List<DataPoint> data = loadData(filePath);

        List<DataPoint> trainSet = new ArrayList<>();
        List<DataPoint> testSet = new ArrayList<>();
        splitData(data, 0.8, trainSet, testSet);

        // Train the k-NN model with k = 3
        kNN knnModel = new kNN(3);
        knnModel.train(trainSet);

        // Evaluate model accuracy
        evaluateModel(testSet, knnModel);

        // Ask the user for problem statement input and predict the data structure
        askUserForProblemStatementAndPredict(knnModel, labelEncoding(Set.of("Array", "Graph", "Tree", "Dynamic Programming", "Unknown")));
    }
} 
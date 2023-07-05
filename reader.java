import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class reader {
    public String[][] readDataset(String filePath) {
        List<String[]> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Only split on the seperator comma's (no adjoining spaces) and not the field commas
                lines.add(line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines.toArray(new String[0][0]);
    }
}

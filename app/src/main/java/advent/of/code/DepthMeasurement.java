package advent.of.code;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DepthMeasurement {

    private final List<Integer> measurements;

    public DepthMeasurement(String filename) throws Exception {
        measurements = readMeasurementsFrom(filename);
    }

    public int howManyIncreases() {
        int counter = 0;
        for (int i = 1; i < measurements.size(); i++) {
            if (measurements.get(i) > measurements.get(i - 1))
                counter++;
        }
        return counter;
    }

    public int howManyThreeSlidingWindowIncreases() {
        int counter = 0;
        for (int i = 1; i < measurements.size() - 2; i++) {
            int next = next(measurements, i);
            int previous = previous(measurements, i);
            if (next > previous)
                counter++;
        }
        return counter;

    }

    private int previous(List<Integer> measurements, int i) {
        return measurements.get(i - 1) + measurements.get(i) + measurements.get(i + 1);
    }

    private int next(List<Integer> measurements, int i) {
        return measurements.get(i) + measurements.get(i + 1) + measurements.get(i + 2);
    }

    private List<Integer> readMeasurementsFrom(String filename) throws Exception {
        String filePath = pathFromResources(filename);
        return Files.lines(Paths.get(filePath))
                .map(Integer::parseInt)
                .collect(toList());
    }

    private String pathFromResources(String filename) throws URISyntaxException {
        return this.getClass().getResource(filename).toURI().getPath();
    }

}

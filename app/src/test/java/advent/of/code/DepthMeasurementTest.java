package advent.of.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepthMeasurementTest {

    @Test void count_how_many_increases_in_the_measurements() throws IOException {

        int increases = new DepthMeasurement("/tmp/measurements.txt").howManyIncreases();

        assertEquals(1564, increases);
    }

    @Test void count_how_many_three_measurement_sliding_window_increases_in_the_measurements() throws IOException {

        int increases = new DepthMeasurement("/tmp/measurements.txt").howManyThreeSlidingWindowIncreases();

        assertEquals(1611, increases);
    }
}

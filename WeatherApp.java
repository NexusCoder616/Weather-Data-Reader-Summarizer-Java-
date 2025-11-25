import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;

public class WeatherApp {

    // A record to represent weather data
    record WeatherReading(String date, double temperature, double humidity) {}

    public static void main(String[] args) throws IOException {
        Path path = Path.of("data.csv");

        // Read and parse CSV into WeatherReading objects using Streams
        List<WeatherReading> readings = Files.lines(path)
                .skip(1) // Skip header
                .map(line -> line.split(","))
                .map(parts -> new WeatherReading(
                        parts[0],
                        Double.parseDouble(parts[1]),
                        Double.parseDouble(parts[2])
                ))
                .toList();

        // Calculate summary using Streams
        double avgTemp = readings.stream()
                .mapToDouble(WeatherReading::temperature)
                .average()
                .orElse(0);

        double maxTemp = readings.stream()
                .mapToDouble(WeatherReading::temperature)
                .max()
                .orElse(0);

        double minTemp = readings.stream()
                .mapToDouble(WeatherReading::temperature)
                .min()
                .orElse(0);

        long humidDays = readings.stream()
                .filter(r -> r.humidity() > 70)
                .count();

        // Print summary
        System.out.println("=== Weather Summary ===");
        System.out.println("Total days: " + readings.size());
        System.out.println("Average temperature: " + avgTemp);
        System.out.println("Max temperature: " + maxTemp);
        System.out.println("Min temperature: " + minTemp);
        System.out.println("Days with humidity > 70%: " + humidDays);
    }
}

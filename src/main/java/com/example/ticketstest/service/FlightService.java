package com.example.ticketstest.service;

import com.example.ticketstest.entity.Flight;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

@Service
public class FlightService {


   //private static final String FILE_PATH = "C:\\Users\\User\\IdeaProjects\\ticketsTest\\src\\main\\resources\\Tickets.json";


    public List<Flight> getAllFlights() {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Tickets.json")))) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            JsonArray flightsArray = jsonObject.getAsJsonArray("flights");
            return Arrays.asList(gson.fromJson(flightsArray, Flight[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Map<String, Integer> calculateMinFlightTime(List<Flight> flights) {
        Map<String, Integer> minFlightTimes = new HashMap<>();
        for (Flight flight : flights) {
            if (flight.getDeparture().equals("Владивосток") && flight.getArrival().equals("Тель-Авив")) {
                minFlightTimes.put(flight.getCarrier(), minFlightTimes.getOrDefault(flight.getCarrier(), Integer.MAX_VALUE));
            }
        }
        return minFlightTimes;
    }

    // Other methods for calculating average price, median, etc.
}

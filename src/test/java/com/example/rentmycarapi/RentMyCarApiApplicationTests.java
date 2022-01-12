package com.example.rentmycarapi;

import com.example.rentmycarapi.controllers.CarController;
import com.example.rentmycarapi.entities.User;
import com.example.rentmycarapi.entities.car.Car;
import com.example.rentmycarapi.entities.car.ElectricVehicle;
import com.example.rentmycarapi.repositories.CarRepository;
import com.example.rentmycarapi.repositories.UserRepository;
import com.example.rentmycarapi.services.CarService;
import com.example.rentmycarapi.services.CarServiceImpl;
import com.example.rentmycarapi.services.UserService;
import com.example.rentmycarapi.services.UserServiceImpl;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RentMyCarApiApplicationTests {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    /**
     * Tests if the repositories are correctly loaded
     */
    @Test
    public void contextLoads() {
        assertThat(userRepository).isNotNull();
        assertThat(carRepository).isNotNull();
    }

    /**
     * Tests if a user can be created with the UserService
     */
    @Test
    @DisplayName("Store a user in userRepository")
    void makeUserTest() {
        // Arrange
        User user1 = new User("person1");
        UserService userService = new UserServiceImpl(userRepository);

        // Act
        User newUser = userService.createUser(user1);

        // Assert
        assertNotNull(newUser.getId());
        assertEquals(newUser.getUsername(), "person1");
    }

    /**
     * Tests if an ElectricVehicle can be created with the CarService
     */
    @Test
    @DisplayName("Store an ElectricVehicle in CarRepository")
    void makeElectricVehicleTest() {
        // Arrange
        User user2 = new User("person2");
        UserService userService = new UserServiceImpl(userRepository);
        User newUser = userService.createUser(user2);
        ElectricVehicle ev1 = new ElectricVehicle(newUser, "Volkswagen Golf", "https://upload.wikimedia.org/wikipedia/commons/8/8c/Cow_%28Fleckvieh_breed%29_Oeschinensee_Slaunger_2009-07-07.jpg");
        CarService carService = new CarServiceImpl(carRepository);

        // Act
        ElectricVehicle newEv = (ElectricVehicle) carService.createEV(ev1);

        // Assert
        assertNotNull(newEv.getId());
        assertEquals(newEv.getModel(), "Volkswagen Golf");
        assertEquals(newEv.getOwner(), user2);
    }

    /**
     * Tests if a Car can be deleted with CarService
     */
    @Test
    @DisplayName("Delete an electric vehicle from carRepository")
    void deleteElectricVehicleTest() {
        // Arrange
        User user3 = new User("person3");
        UserService userService = new UserServiceImpl(userRepository);
        User newUser = userService.createUser(user3);
        ElectricVehicle ev1 = new ElectricVehicle(newUser, "Opel Astra", "https://upload.wikimedia.org/wikipedia/commons/8/8c/Cow_%28Fleckvieh_breed%29_Oeschinensee_Slaunger_2009-07-07.jpg");
        CarService carService = new CarServiceImpl(carRepository);
        ElectricVehicle newEv = (ElectricVehicle) carService.createEV(ev1);

        // Act
        ResponseEntity<HttpStatus> response = carService.deleteById(newEv.getId());

        // Assert
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    /**
     * API Test for cars
     * - Considered successful if a json is returned
     * @throws IOException
     */
    @Test
    @DisplayName("Http get request for cars returns a json")
    public void getCarsAPITest() throws IOException {
        // Arrange
        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet( "http://localhost:8080/v1/cars" );

        // Act
        HttpResponse response = HttpClientBuilder.create().build().execute( request );

        // Assert
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals( jsonMimeType, mimeType );
    }

    /**
     * API Test for Listings
     * - Considered successful if a json is returned
     * @throws IOException
     */
    @Test
    @DisplayName("Http get request for listings returns a json")
    public void getListingsAPITest() throws IOException {
        // Arrange
        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet( "http://localhost:8080/v1/listings" );

        // Act
        HttpResponse response = HttpClientBuilder.create().build().execute( request );

        // Assert
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals( jsonMimeType, mimeType );
    }

    /**
     * API Test for Reservations
     * - Considered successful if a json is returned
     * @throws IOException
     */
    @Test
    @DisplayName("Http get request for reservations returns a json")
    public void getReservationsAPITest() throws IOException {
        // Arrange
        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet( "http://localhost:8080/v1/reservations" );

        // Act
        HttpResponse response = HttpClientBuilder.create().build().execute( request );

        // Assert
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals( jsonMimeType, mimeType );
    }


}

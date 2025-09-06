package steps;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import pages.LoginPage;
import pages.SearchHotelPage;
import pages.BookHotelPage;
import static org.junit.Assert.assertEquals;

import java.util.Map;

public class HotelBookingSteps {

    LoginPage loginPage = new LoginPage();
    SearchHotelPage searchHotelPage = new SearchHotelPage();
    BookHotelPage bookHotelPage = new BookHotelPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Navigating to login page");
        loginPage.open();
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        System.out.println("Logging in with username: " + username);
        loginPage.login(username, password);
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        assert loginPage.isUserLoggedIn();
    }

    @Then("the hotel search results should display the correct hotel")
    public void the_hotel_search_results_should_display_the_correct_hotel() {
        String selectedHotel = searchHotelPage.getSelectedHotelName();
        assertEquals("Hotel Sunshine", selectedHotel);
    }

    @When("the user searches for a hotel with:")
    public void the_user_searches_for_a_hotel_with(DataTable dataTable) {
        System.out.println("Searching for hotel");
        Map<String, String> params = dataTable.asMap(String.class, String.class);
        searchHotelPage.searchHotel(params);
    }

    @And("the user selects the first hotel")
    public void the_user_selects_first_hotel() {
        searchHotelPage.selectFirstHotel();
    }

    @When("the user books the hotel with:")
    public void the_user_books_the_hotel_with(DataTable dataTable) {
        System.out.println("Booking hotel");
        Map<String, String> details = dataTable.asMap(String.class, String.class);
        bookHotelPage.bookHotel(details);
    }

    @Then("the booking should be successful")
    public void the_booking_should_be_successful() {
        System.out.println("Verifying booking success");
        bookHotelPage.verifyBookingSuccess();
    }
}

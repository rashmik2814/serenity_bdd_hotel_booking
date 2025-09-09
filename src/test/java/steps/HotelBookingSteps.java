package steps;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SearchHotelPage;
import pages.BookHotelPage;
import pages.BookingConfirmationPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

public class HotelBookingSteps {

    LoginPage loginPage = new LoginPage();
    SearchHotelPage searchHotelPage = new SearchHotelPage();
    BookHotelPage bookHotelPage = new BookHotelPage();
    LogoutPage logoutPage = new LogoutPage();
    BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
    private int additionResult;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Navigating to login page");
        loginPage.open();
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        System.out.println("Logging in with username: " + username);
        loginPage.doLogin(username, password);
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        assertTrue(bookHotelPage.isLoginConfirmed());
    }

    @Then("the hotel search results should display {string}")
    public void the_hotel_search_results_should_display(String expectedHotelName) {
        String selectedHotel = searchHotelPage.getSelectedHotelName();
        assertEquals(expectedHotelName, selectedHotel);
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

    @Then("the booking confirmation page should display the order ID")
    public void the_booking_confirmation_page_should_display_the_order_id() {
        assertTrue(bookingConfirmationPage.isOrderIdDisplayed());
        String orderId = bookingConfirmationPage.getOrderId();
        System.out.println("Order ID: " + orderId);
    }

    @Then("the user should click on logout button and verify the logout message")
    public void the_user_should_click_on_logout_button_and_verify_the_logout_message() {
        System.out.println("Clicking logout button");
        searchHotelPage.logout();
        assertTrue(logoutPage.isUserLoggedOut());
    }

    @When("I pass integer {int} and integer {int}")
    public void I_pass(int a, int b){
        additionResult = loginPage.doAddition(a, b);
        System.out.println("Result from step: " + additionResult);
    }

    @Then("I should get the addition as {int}")
    public void I_should_get_the_addition_as(int expectedResult){
        assertEquals(expectedResult, additionResult);
    }

}

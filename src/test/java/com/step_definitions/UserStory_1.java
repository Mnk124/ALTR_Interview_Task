package com.step_definitions;

import com.Utilities.DataBaseUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class UserStory_1 {
    List<String> actualIDs;
    List<String> actualColumns;

    @Given("Establish database connection")
    public void establish_database_connection() {
        System.out.println("Database connection was done inside the Hook Class");
    }

    @When("Execute query to get all IDs from Employees")
    public void execute_query_to_get_all_i_ds_from_employees() {
        String query="SELECT ID FROM Employee";
        DataBaseUtilities.runQuery(query);
        actualIDs=DataBaseUtilities.getColumnNames(query);
    }
    @Then("Verify all employees has unique ID.")
    public void verify_all_employees_has_unique_id() {
        String query="SELECT DISTINCT ID FROM Employee";
        DataBaseUtilities.runQuery(query);
        List<String>expectedIDs=DataBaseUtilities.getColumnNames(query);
        Assert.assertEquals(expectedIDs,actualIDs);
    }

    @When("execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        String query="SELECT * FROM Employees";
        DataBaseUtilities.runQuery(query);
        actualColumns= DataBaseUtilities.getColumnNames(query);
    }
    @Then("verify the below columns are listed")
    public void verify_the_below_columns_are_listed(List<String> expectedColumns) {
    Assert.assertEquals(expectedColumns,actualColumns);
    }


}

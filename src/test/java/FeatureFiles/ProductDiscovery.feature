
@MyTask
Feature: Aliexpress.com Website Interaction

  Scenario: Product Discovery and Process

  Scenario: Interact with E-commerce Website
    Given Go to the website
    When Verify you are on the homepage
    And Set country and currency settings to Turkey
    And Click on the Computers & Office category
    And Select seller country as China
    Then Print the name and price of the cheapest product on the page
    And Print the name and price of the most expensive product on the page
    And Choose a random sponsored product by scrolling to the end of the page
    Then Print the product's name
    And Print the product's star, review and sales count
    And Slowly scroll through all the product images
    And Add product to car
    And Remove it from car
    Then Verify that you have successfully logged out



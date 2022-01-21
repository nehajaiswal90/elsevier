Feature: This feature will make sure that dresses can be added to cart and checked out successfully

  Scenario: Verify user is able to add dress to cart and proceed to checkout successfully
      Given User open "chrome" browser
      And Launch the Website "http://automationpractice.com/index.php"
      When User go to summer dress category
      And User adds the Summer dress to cart
      Then Verify user is able to checkout the product
      And Close the browser
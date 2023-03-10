# The Shoe Store

This project  consist of five screens. 

1. Login screen: Email and password fields and labels plus create and login buttons
2. Welcome onboarding screen
3. Instructions onboarding screen
4. Shoe Listing screen
5. Shoe Detail screen for adding a new shoe




Create a new Login destination.

   * Include email and password labels 

   - Include email and password fields
   - Create buttons for creating a new login and logging in with an existing account
   - Clicking either button should navigate to the Welcome Screen.

Create a new Welcome screen destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the instructions screen

Create a new Instruction destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the shoe list screen

Create a class that extends ViewModel

   * Use a LiveData field that returns the list of shoes

Create a new Shoe List destination that includes:

   * A new layout
   * A ScrollView
   * A LinearLayout for Shoe Items
   * A FloatingActionButton with an action to navigate to the shoe detail screen

In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

Create a new Shoe Detail destination that includes:

    * A new layout
    * A TextView label and EditView for the
      * Shoe Name
      * Company
      * Shoe Size
      * Description
    * A Cancel button with an action to navigate back to the shoe list screen
    * A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model

Make sure not to go back to onboarding screens

In the Shoe List screen:

    * Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
    * Observe the shoes variable from the ViewModel
    * Use DataBindingUtil to inflate the shoe_list layout
    * Add a new layout item into the scrollview for each shoe.
# Stock Portfolio Management System

This is the repository for OOP Final Project

Julian Singer, Rafed Abbassi, Rohit Subramaniam

# Instructions for common issues we found when exporting the project
* if seeing an error of unable to find main function, make a new project in eclipse and copy-paste in all the files.
* users.txt and stocks.txt need to be in the root directory, if when importing the zip file it doesnt seem to be able to find them, then drag them manually into the root directory. This issue occurs if the project is extracted from the zip file and the project root directory is no longer finalProject
* we have run the code successfully and fully without errors. The only ones we encounter have come from exporting to a different machine and needing to set it up properly
* [This is how the structure should look](structureExample.png)

# Usage
* register your account
    * click the admin radio button to make an admin account
* login using your username and password
* if you are a Customer
    * you may click any of the buttons, but to get started we recommend viewing stocks
    * when viewing stocks, click on a stock and fill in a desired quantity in the quantity text field, then hit buy and you will purchase the stocks if the total value doesnt exceed your balance
    * you may then view your transactions to see a list of all your past purchases and sales
    * head in to view portfolio to see the stocks you currently own, your current balance, and your profit/loss (balance + total value of stocks - initial balance of 5000)
        * the protfoilio will reflect the current state of stocks,. with prices taken from the databasse and removed stocks being taken out of your portfolio
    * you may deposit or withdraw funds to change your balance, use it for testing purposes
    * in view stocks, you may add stocks to your watchlist by selecting them and hitting add to watchlist
        * this will take you to your watchlist, where you will see stocks you marked and the price they were at at that time
* if you are an admin
    * when you log in, you may generate a user report by filling in the name of that user and hitting generate report
        * this will take you to a GUI where you will see all of that user's transactions since the date they made their first one
    * you may edit stocks by clicking edit stocks
        * on this GUI, if you fill in the fields at the bottom, you may add a stock to the database
        * if you fill in the price and select a stock, or type in that stocks symbol, you may update the price of that stock
        * if you select a stock, you may then hit the delete stock button to remove that stock from the database

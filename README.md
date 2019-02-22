# Steps to play the game

Description: In this game, we have two player.When a player starts, a random whole number is generated and sent to the other player, which indicates the start of the game. The receiving player must now add one of { --1, 0, 1 } to get a number that is divisible by 3 and then divide it. The resulting number is then sent back to the original sender.
The same rules apply until one of the players reaches the number 1 after division, which ends the game.


# Implementation -- communicating with each other using an interface (SPRING BOOT,REST API via HTTP)

1) Both player are independent process as they are running on different port number.
   You can also configure the port number as per your feasibilty using application.yml file.
   
    

#How to play

Step1: Start the player A. 
1.1) Run the program as java application as its a spring boot application.
1.2) Once its started successfully, go to swagger page.
1.3) Run the GET endpoint, it will generate a random number.
1.4) You will get the message "Other play is not available"

Step 2) Start the player B
2.1) Run the program as java application as its a spring boot application.

Step 3) Go to swagger page
3.1) Run the GET endpoint, it will generate a random number.
3.2) As per the random number, you will see who wins.
3.3) You will get the 1 in response.


**************************************Enjoy game **************************************************
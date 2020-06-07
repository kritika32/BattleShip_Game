# BattleShip_Game
A simple Java Game to strengthen OOP and DS concepts
## Description
---

__This repo is about a battle game between Human and Machine__.

---

## Introduction

The code is written in Java, hence use of classes must be conveyed with their properties in order to best understand this code.

-----------------------------------------------------------------------------------------------------------------------------

- Skeleton of Class. <br> 
- About the Methods. <br> 
- How to run this code. <br> 
- Screenshots of running code.<br> </pre>

-----------------------------------------------------------------------------------------------------------------------------

## 1. Skeleton of class
### Data Variables 
-----------------------------------------------------------------------------------------------------------------------------
__a. OceanMap (private 2D Array)__ | This is a 2D Array of Characters which will store the positions of ships and hence will act as an ocean.

__b. isManual (private boolean variable)__ | This is a boolean variable which will store whether the input of User is manual or computerized.

__c. ships (private Integer variable)__ | This is an integer variable which will store the number of ships of both the opponents to be stored in the ocean.

__d. size (private Integer variable)__ | This is an integer variable which will store dimension of ocean to be created.

__e. Indent (Private static class)__ | This is a private static class which will store the functionalities of Indentation and beautification of output.

-----------------------------------------------------------------------------------------------------------------------------

 ## 2. Methods
 Various methods were used in this program in order to make things generic and feasible to code. Stated below are the methods with their functionalities that were used in this program.
 
 -----------------------------------------------------------------------------------------------------------------------------
 PrintOcean - method will print the ocean which later on print the current status of ocean as where user ships are placed and so on.
 
 __a. void fill (ocean, generic_value)__ | This method is created in order to fill the ocean with a generic value.
 
 __b. void Menu (void)__ | This method is created to display Menu as well as respond according to the input provided by the user. 
 
 __c. int[] getXY (isUser, isManual)__ | This method is created to either guess the values randomly or to take input from the user, so basically isUser define whether the input is for User or Computer and isManual defines whether the user want to input values randomly or to input manually.
 
 __d. void deploy (isUser, Set)__ | This method is created to deploy the ships in the ocean for user and computer, So isUser defines whether deployment is for user or computer and Set is a set of locations which makes sure deployment is always on a new location.
 
 __e. int KillShips (isUser, Set)__ | This method is created to kill ships either by firing from user's side of computer's side. 
 
 __f. void Start (void)__ | This method is created as a hub between deploy ships and killships and decides the winner and print the ocean at the end of the program.
 
 -----------------------------------------------------------------------------------------------------------------------------
 
 ## 3. How to Run
 __Step 1__ |  First clone the project in any directory.<br>
 __Step 2__ | Open terminal in that same directory.<br>
 __Step 3__ | Run command ``` javac BattleShip.java``` to compile the java code.<br>
 __Step 4__ | Run command ``` javac BattleShipClient.java``` to compile java code.<br>
 __Step 5__ | Run command ```java BattleShipClient``` to run the code.<br>
 __Step 6__ | Enjoy the game budd......;)<br>
 
 ## 4. Screenshots (Picture abhi baki hai mere dost !!!!).
 
 .
 .
 .
 .
 .
 .
 . __To be Continued__ 

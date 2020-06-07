# BattleShip_Game
A simple Java Game to strengthen OOP and DS concepts
## Description

__This repo is about a battle game between Human and Machine__.

## Skeleton of class
 A private class Indent
 
 Methods
 
 ## Indent class
 This class contains methods which used for indentation
 
 __Methods used for indentation__
 
 - createDelay - method create delay for about 60 or more milliseconds for a string
 
 - separator - method separates the content by printing 100 dashes
 
 - alignSlow - method print some tabs , lines and create delay for a string
 
 - align - method will only print tabs and lines for a string
 
 - leftpadding - method will print tabs on left side of a string
 
 - instructions - method will print instructions by calling align method in it
 
 - printlegends - method will print legends by calling align method in it
 
 ## Constructor
 __Default Constructor__
 
 used to initialize size of ocean and ships
 
 __Paramiterized constructor__
 
 ocean size and ships initialized and a 2-D sized ocean is declared
 
 ## Methods for battleShip class
 PrintOcean - method will print the ocean which later on print the current status of ocean as where user ships are placed and so on.
 
 - fill - method will fill the ocean with the given character
 
 - Menu - method will display the options for game - how to play or start game 
 
 - getXY - method will return values either randomly created or user input
 
 - deploy - method will place ships on ocean for either user or computer
 
 - KillShips - method will attack ship placed on location given by user or computer
 
 - Start - method will start the game by calling methods and later on print the result

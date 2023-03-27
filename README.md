# Arkanoid <br>
## Overview <br>
In this project we create the Arkanoid game base on GUI interface of the Bar-Ilan university.
This is assignment in the oop-course of Bar-Ilan University. <br>

## User Guide <br>
The goal is to eliminate all the blocks on the screen.
Every time ball hit block, the block disappeared.
The control in the balls achieved by moving the paddle in the bootom of the screen by the keyboards left and right arrows.
To pause the game use p. To continue, use SPACE. <br>

Levels
There are 4 levels:
Level 1:
Level 1
Level 2:
Level 2
Level 3:
Level 3
Level 4:
Level 4
<br>
## run <br>
First, clone the repo. Than use the following commands inside the project folder:<br>
To run this game from level 1 to 4 use the command `ant run`. <br>
To run in any other levels order use the command `ant run -Dargs="levels order"`. For example, to start the game in level 2 and after win it move to level 4 write `ant run -Dargs="2 4"`.<br>
To clean all the compilation files use `ant clean`.<br>
To compile the game without run it use `ant compile`.<br>

## Requirements <br>
 - Java<br>
 - Ant

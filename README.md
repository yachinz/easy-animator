# easy-animator
This is tool to generate the animation with textual input.

The jar file is in the resource folder.  

Run this java program with
The command-line arguments will be of the form  
-in "name-of-animation-file" -view "type-of-view" -out "where-output-show-go" -speed "integer-ticks-per-second"  
  
Here are some examples of valid command-line arguments and what they mean:

-in smalldemo.txt -view text -speed 2: use smalldemo.txt for the animation file, and create a text view with its output going to System.out, and a speed of 2 ticks per second.

-in smalldemo.txt -view text: use smalldemo.txt for the animation file, and create a text view with its output going to System.out.

-in smalldemo.txt -speed 50 -view visual: use smalldemo.txt for the animation file, and create a visual view to show the animation at a speed of 50 ticks per second.

If you want to run the program in any IDEA, please put all the textual file in the root folder.
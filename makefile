#Makefile for program to work all at once :)
run: 
	javac *.java
	java main
	rm *.class
#open -a Terminal "/Users/lmao/Desktop/Coding Projects/Budget Tracking/budget_tracking" 

cleanup:
	rm *.class

cleanupfiles:
	cd files
	rm *.txt
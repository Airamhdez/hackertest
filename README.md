# Hacker detection system

System that detects attempts to hack the system and compromise accounts. 
The HackerDetector interface defines a single method 'parseLine'. The method take one line of a log file at a time
and return the IP address if any suspicious activity is identified or null if the activity appears to
be normal.
A suspicious activity is identified when a single IP address has attempted a failed login 5 or more times within a 5 minute period.

The line parameter of the 'parseLine' method receives lines in the following format:
ip,date,action,username

IP look like 80.238.9.179.
Date is in the epoch format like 1336129471
Action is one of the following: SIGNIN_SUCCESS or SIGNIN_FAILURE
Username is a String like Will.Smith.

Example: 80.238.9.179,133612947,SIGNIN_SUCCESS,Will.Smith

#Use Case: Create Conference Link
##Preconditions:
- The user selects the conference link menu.
  Invariants:
- The terminal is not closed
##Postconditions:
- A new conference link is created.
##Steps:
1. The user enters CONFERENCELINKS.
2. The user enters CREATE
3. The user enters an event id
4. The software creates and displays a conference link

#Use Case: Return A Conference Link That Was Already Created
##Preconditions:
- The user selects conference link menu.
- A conference link was previously created.
##Postconditions:
- The software returns the conference link that was previously created.
##Steps:
- The user enters CONFERENCELINKS. 
- The user enters RETURN. 
- The user enters the event id for the conference link they want to retrieve. 
- The software displays the conference link that was previously created.

#Use Case: Delete A Conference Link That Was Already Created
##Preconditions:
- The user selects conference link menu. 
- A conference link was previously created.
##Postconditions:
- The conference link is deleted from the system.
##Steps:
- The user enters CONFERENCELINKS. 
- The user enters DELETE. 
- The user enters the event id for the conference link they want to delete. 
- The software deletes the conference link from the system.

#Use Case: Create A Conference Link for a Non-Existent Event
##Preconditions:
- The user selects the conference link menu. 
- The event for which the conference link is to be created does not exist in the system.
##Postconditions:
- The software displays an error message indicating that the event does not exist.
##Steps:
- The user enters CONFERENCELINKS. 
- The user enters CREATE. 
- The user enters the event id for the non-existent event. 
- The software displays an error message indicating that the event does not exist.

#Use Case: Get A Conference Link for a Non-Existent Event
##Preconditions:
- The user selects the conference link menu. 
- The user is trying to retrieve a conference link for a non-existent event.
##Postconditions:
- The software displays an error message indicating that the event does not exist.
##Steps:
- The user enters CONFERENCELINKS. 
- The user enters RETURN. 
- The user enters the event id for the non-existent event. 
- The software displays an error message indicating that the event does not exist.

#Use Case: Join A Conference Link for a Non-Existent Event
##Preconditions:
- The user has a conference link for a non-existent event.
##Postconditions:
- The software displays an error message indicating that the event does not exist.
##Steps:
- The user clicks on the conference link. 
- The software displays an error message indicating that the event does not exist.

#Use Case: Get A Conference Link for a Non-Existent Conference Link
##Preconditions:
- The user selects the conference link menu. 
- The user is trying to retrieve a non-existent conference link.
##Postconditions:
- The software displays an error message indicating that the conference link does not exist.
##Steps:
- The user enters CONFERENCELINKS. 
- The user enters RETURN. 
- The user enters the event id for the non-existent conference link. 
- The software displays an error message indicating that the conference link does not exist.

#Use Case: Join A Conference Link for a Non-Existent Conference Link
##Preconditions:
- The user has a non-existent conference link.
##Postconditions:
- The software displays an error message indicating that the conference link does not exist.
##Steps:
- The user clicks on the non-existent conference link.
- The software displays an error message indicating that the conference link does not exist.

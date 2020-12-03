### Architecture
The program 

![architecture!](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/architecture.jpg?raw=true)

## UI

The UI consists of three views:

-The parent view contains a list of all reviews. 
-The Review-view displays the base view for a review
-The Advanced-view contains additional advanced options for a review

The UI consists of a FXML-architecture, meaning each view has a FXML-file to define the visible UI and a controller to set their initial data and handle user inputs. 
The Review-view and Advanced-view are childred of the main scene. The list view is always visible and interactable. The Review-view and Advanced-view only handle one Review- 
or Advanced-object at a time and only communicate with the MainController and their respective Object Class. Maincontroller sets each childview and communicates with BeerRatingService class to retrieve or save permanent data.

## Application Logic

The applications logical data structure consists of two Classes: Review and Advanced. A Review Object contains the basic information of a review. An Advanced Object can only be created once a Review has been created and is always attached to a Review.

BeerRatingService is a middle layer that handles both-ways communication between the MainSceneController and the DAO classes. 
The review Objects are passed between MainSceneController-BeerRatingService-ReviewDAO as an ArrayList<Review>-object where as similar interaction with 
Advanced Object is done with a single Advanced Object.

## Files
The application uses two .txt-files at the root of the application to permanently save data and retrieve it. Writing to and reading from these files is handled by the Data Acces Object classes ReviewDao and AdvancedDao.

reviews.txt contains the list of all reviews
advanced.txt contains the advanced information for each review to which one has been created and saved

## Main functionality
Initializing the application:
![init_sequence!](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/init_sequence.jpg?raw=true)

Creating a new review:

Saving a review:

Opening a review from list view:

Creating an advanced object:

Saving an advanced object:




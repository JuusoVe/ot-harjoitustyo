### Testing

Unit testing covers all application logic classes in the ![beerratingapp.domain package](https://github.com/JuusoVe/ot-harjoitustyo/tree/master/src/main/java/beerratingapp/domain) and DAO-classes in the ![beerratingapp.dao package](https://github.com/JuusoVe/ot-harjoitustyo/tree/master/src/main/java/beerratingapp/domain) . The classes building UI and initializing the application have been left out of the scope of the automated testing.

## Application logic

Application logic classes use fake in-memory implementations of DAO-classes in the implementation.

Integration testing is done  under the BeerRatingService classes tests since the only role of this class is the handle the communication between classes. Integration tests use real implementations of DAO-classes and but temporary files created during testing.

## DAO-classes

DAO-class tests create an temporary folder and file to write into and to read from.

## Test coverage

![test coverage](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/tests.png)

## System testing

System-level testing has been done manually.

## Installation and configuration

The application has been downloaded and tested in Windows 10 and Linux environments. Both environments have been tested with pre-existing data files as well as without.

## Functionalities

All functionalities in the ![specifications](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/specifications.md) document and the ![user instructions](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/user_instructions.md) have been tested.










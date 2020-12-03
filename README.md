# Ohjelmistotekniikka, harjoitustyö: BeerRating

The application guides the user through the process of reviewing a beer.

It is being built as a course assignment for Helsinki University's course Ohjelmistotekniikka.

## Documentation
[user_instructions.md](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/user_instructions.md) <br>
[initial_requirements.md](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/initial_requirements.md) <br>
[architecture.md](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/architecture.md) <br>
[worktracker.md](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/tuntikirjanpito.md) 

### Testing

Tests are ran with

```
mvn test
```

Test coverage report is created with

```
mvn jacoco:report
```
Test coverage report is found in _target/site/jacoco/index.html_


### Checkstyle
Style checks specified in [checkstyle.xml](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/checkstyle.xml) are ran with

```
mvn jxr:jxr checkstyle:checkstyle
```

Error report is found in _target/site/checkstyle.html_


### Releases

[Week 5 release](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/tuntikirjanpito.md) 
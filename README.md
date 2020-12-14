# Ohjelmistotekniikka, harjoitustyö: BeerRating

The application guides the user through the process of reviewing a beer.

It is being built as a course assignment for Helsinki University's course Ohjelmistotekniikka.

## Documentation
[user_instructions.md](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/user_instructions.md) <br>
[specifications.md](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/specifications.md) <br>
[architecture.md](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/architecture.md) <br>
[testing.md](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/testing.md) <br>
[worktracker.md](https://github.com/JuusoVe/ot-harjoitustyo/blob/master/documentation/tuntikirjanpito.md) 

### Testing

Tests are ran with

```
mvn test
```

Test coverage report is generated with

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

### Javadoc

JavaDoc is generated with

```
mvn javadoc:javadoc
```


### Releases

[Week 5 release](https://github.com/JuusoVe/ot-harjoitustyo/releases/tag/week5) <br>
[Week 6 release](https://github.com/JuusoVe/ot-harjoitustyo/releases/tag/week6)

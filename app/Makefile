build-dist:
	./gradlew clean
	./gradlew installDist
lint:
	./gradlew checkstyleMain
    ./gradlew checkstyleTest
test:
	./gradlew test
build: build-dist lint test

.PHONY: build

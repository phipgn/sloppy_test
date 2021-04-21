# Sloppy Test
This is a take-home assignment from NAB. I made up an automation test project and named it "Sloppy Test". This is a projected based on Java/Selenium/TestNG/Cucumber/Maven.

*I wrote 2 UI tests* (match with **U001** and **U002** test cases from documents\TestCases.xlsx).

At first, I developed the project to run the test using TestNG. Then I added the Cucumber feature into it. That's why we have 2 packs (TestNG pack and Cucumber pack) here.

# To-do checklist:
**Part 1: Test Design and Bug Challenge**
- [x] ~~Create a test approach~~
- [x] ~~Design test cases~~
- [x] ~~Find bugs and create a Defects Report~~

**Part 2: UI Automation**

Acceptance criteria:
- [x] ~~Using valid verfication/assertion point~~
- [x] ~~Provide test reporting solution~~
  - [x] ~~TestNG report~~
  - [x] ~~Cucumber report~~
- [x] ~~Locators~~
- [x] ~~POM~~

Optional items:
- [x] ~~Proven practical knowledge in writing automation test:~~
  - [x] ~~BDD approach~~
  - [x] ~~Data driven~~
- [x] ~~Support multiple browsers~~
  - [x] ~~Chrome~~
  - [x] ~~Firefox~~
- [x] ~~Capture a screenshot if test fails~~
- [x] ~~Provide CI/CD integration solution (can explain this)~~
- [x] ~~Abibility to run test in parallel~~
  - [x] ~~via TestNG~~
  - [x] ~~via Cucumber~~
- [ ] Cloud integration solution
- [ ] Distribution execution

# How to run the test from Eclipse IDE?

#### Software requirements:
* OS: Windows 10.
* IDE: Eclipse version 2018-09 (4.9.0).
    * TestNG plugin installed (Make sure to untick `TestNG M2E (Maven) Integration (Optional)` option when installing).
    * Cucubmer plugin installed.
* JDK 8 (1.8.0_261) installed.

***Please import the sloppy_test as a Maven project into Eclipse IDE***

<img src="https://user-images.githubusercontent.com/22786385/115309099-fce50a80-a195-11eb-9151-fa86df069b6e.png" width="500">
<img src="https://user-images.githubusercontent.com/22786385/115309163-1ab26f80-a196-11eb-8576-988c1074c791.png" width="500">

Make sure to have only JDK bin added to your `Path` system variables. Please remove the Oracle Java path (if any).

<img src="https://user-images.githubusercontent.com/22786385/115308146-7a0f8000-a194-11eb-9c11-f02559d569c4.png" width="500">

In Eclipse, under Windows > Preferences > Java > Installed JREs: Make sure you selected JDK directory as your JRE.

<img src="https://user-images.githubusercontent.com/22786385/115308535-1043a600-a195-11eb-962a-6ecb0ec63431.png" width="500">
<img src="https://user-images.githubusercontent.com/22786385/115308701-5436ab00-a195-11eb-93ce-3a19d8cf00dd.png" width="500">

Make sure your `JRE System Library` is 1.8 at least.

<img src="https://user-images.githubusercontent.com/22786385/115308654-41bc7180-a195-11eb-9a8f-cca95c0219c3.png" width="500">

You can configure to run the tests with chrome or firefox as well

<img src="https://user-images.githubusercontent.com/22786385/115310887-d4124480-a198-11eb-80d8-b1f48b359a95.png" width="500">

#### The TestNG pack:

Right click on `SearchTest.java > Run As > TestNG Test`. (`SearchTestParallel.java` is there just to demo the ability of running tests parallely via TestNG).

<img src="https://user-images.githubusercontent.com/22786385/115555789-2018d280-a2da-11eb-84b2-9901858f6b64.png" width="500">

Or Right click on `testng.xml > Run As > TestNG Suite` (by default settings, tests would be running parallelly by 2 threads)

<img src="https://user-images.githubusercontent.com/22786385/115555905-4179be80-a2da-11eb-9838-f72703632b00.png" width="500">

Test data for TestNG data driven could be found under `test_data/` directory. Data will be mapped with test methods automatically based on class names and method names.

![image](https://user-images.githubusercontent.com/22786385/115557178-abdf2e80-a2db-11eb-9add-66ada46c7c98.png)

#### The Cucumber pack:

Right click on `TestRunner > Run As > TestNG Test`

<img src="https://user-images.githubusercontent.com/22786385/115556031-65d59b00-a2da-11eb-8004-2b0c561a944f.png" width="500">
<img src="https://user-images.githubusercontent.com/22786385/115556218-a33a2880-a2da-11eb-848c-8449e9b7ab5a.png" width="500">

# How to run the test from console?
Download Maven from: https://maven.apache.org/download.cgi `apache-maven-3.8.1-bin.zip` and extract the zip file to `C:/maven`

Make sure to add Maven bin folder and JDK bin foler to environment path like this:

<img src="https://user-images.githubusercontent.com/22786385/115259995-8f68b800-a15c-11eb-96f6-1f8d859cb2ab.png" width=500">

#### Compile code:
At `sloppy_test` root directory, run this command first to compile Java source files into class files:

```mvn clean compile```

<img src="https://user-images.githubusercontent.com/22786385/115310284-bee8e600-a197-11eb-991b-dcd4ec6c368e.png" width="500">

#### The TestNG pack:
Then run this command to execute the TestNG pack from cmd:

```java -cp "target\classes;lib\*" org.testng.TestNG testng.xml```

Run this command to execute the TestNG pack parallelly from cmd:

```java -cp "target\classes;lib\*" org.testng.TestNG testng.xml -parallel classes -threadcount 2```

<img src="https://user-images.githubusercontent.com/22786385/115480065-f4fb9800-a273-11eb-8292-c6a4fce7af66.png" width="850">

#### The Cucumber pack:
Run this command to execute the Cucumber pack from cmd:

```java -cp target\classes;lib\* cucumber.api.cli.Main --glue phipgn.sloppy_test.bdd.steps src/test/java/phipgn/sloppy_test/bdd/features --tags @searchCity --monochrome --plugin pretty --plugin json:target/cucumber-reports/Cucumber.json --plugin html:target/cucumber-reports --plugin junit:target/cucumber-reports/Cucumber.xml```

Run this command to execute the Cucumber pack parallelly from cmd:

```java -cp target\classes;lib\* cucumber.api.cli.Main --glue phipgn.sloppy_test.bdd.steps src/test/java/phipgn/sloppy_test/bdd/features --tags @searchCity --monochrome --plugin pretty --plugin json:target/cucumber-reports/Cucumber.json --plugin html:target/cucumber-reports --plugin junit:target/cucumber-reports/Cucumber.xml --threads 2```

<img src="https://user-images.githubusercontent.com/22786385/115479553-cdf09680-a272-11eb-80f7-120b46a82c5a.png">
<img src="https://user-images.githubusercontent.com/22786385/115479751-48211b00-a273-11eb-8892-a663bbf21b2b.png" width="850">
<img src="https://user-images.githubusercontent.com/22786385/115557965-6ff89900-a2dc-11eb-8af7-86dc0fd4875e.png" width="850">


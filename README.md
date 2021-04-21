# Sloppy Test
This is a take-home assignment from NAB. I made up an automation test project and named it "Sloppy Test". This is a projected based on Java/Selenium/TestNG/Cucumber/Maven.

*I wrote 2 UI tests* (match with **U001** and **U002** test cases from documents\TestCases.xlsx).

At first, I developed the project to run the test using TestNG. Then I added the Cucumber feature into it. That's why we have 2 packs (TestNG pack and Cucumber pack) here.

# To-do checklist:
**Part 1: Test Design and Bug Challenge**
- [x] Create a test approach
- [x] Design test cases
- [x] Find bugs and create a Defects Report

**Part 2: UI Automation**
Acceptance criteria:
- [x] Using valid verfication/assertion point
- [x] Provide test reporting solution
  - [x] TestNG report
  - [x] Cucumber report
- [x] Locators
- [x] POM
- [x] Browser Factory

Optional items:
- [x] Proven practical knowledge in writing automation test:
  - [x] BDD approach
  - [x] Data driven
- [x] Support multiple browsers
  - [x] Chrome
  - [x] Firefox
- [x] Capture a screenshot if test fails
- [x] Provide CI/CD integration solution (can explain this)
- [ ] Cloud integration solution
- [ ] Abibility to run test in parallel (cannot make it work yet due to some technical issues and tight work schedule)
- [ ] Distribution execution

# How to run the test from Eclipse IDE?

---
#### Software requirements:
* OS: Windows 10.
* IDE: Eclipse version 2018-09 (4.9.0).
    * TestNG plugin installed (Make sure to untick `TestNG M2E (Maven) Integration (Optional)` option).
    * Cucubmer plugin installed.
* JDK 8 (1.8.0_261) installed.

***Please import the sloppy_test as a Maven project into Eclipse IDE***

<img src="https://user-images.githubusercontent.com/22786385/115309099-fce50a80-a195-11eb-9151-fa86df069b6e.png" width="500">
<img src="https://user-images.githubusercontent.com/22786385/115309163-1ab26f80-a196-11eb-8576-988c1074c791.png" width="500">

Make sure to have only JDK bin added to your `Path` system variables. Please remove the Oracle Java path (if any).

<img src="https://user-images.githubusercontent.com/22786385/115308146-7a0f8000-a194-11eb-9c11-f02559d569c4.png" width="500">

In Eclipse, under Windows > Preferences > Java > Installed JREs: Make sure you selected jdk directory.

<img src="https://user-images.githubusercontent.com/22786385/115308535-1043a600-a195-11eb-962a-6ecb0ec63431.png" width="500">

<img src="https://user-images.githubusercontent.com/22786385/115308701-5436ab00-a195-11eb-93ce-3a19d8cf00dd.png" width="500">
<img src="https://user-images.githubusercontent.com/22786385/115308654-41bc7180-a195-11eb-9a8f-cca95c0219c3.png" width="500">

You can configure to run the tests with chrome or firefox as well

<img src="https://user-images.githubusercontent.com/22786385/115310887-d4124480-a198-11eb-80d8-b1f48b359a95.png" width="500">

---
#### The TestNG pack:

Right click on Search Test > Run as > TestNG

<img src="https://user-images.githubusercontent.com/22786385/115260500-01410180-a15d-11eb-8df9-719e81109068.png" width="500">

---
#### The Cucumber pack:

Right click on TestRunner > Run as > Junit test

<img src="https://user-images.githubusercontent.com/22786385/115260666-2b92bf00-a15d-11eb-812c-78832c7533bf.png" width="500">
<img src="https://user-images.githubusercontent.com/22786385/115146698-c74efd00-a081-11eb-9dbc-f6697d05d96a.png" width="500">


# How to run the test from console?
Download Maven from: https://maven.apache.org/download.cgi `apache-maven-3.8.1-bin.zip` and extract the zip file to `C:/maven`

Make sure to add Maven bin folder and JDK bin foler to environment path like this:

<img src="https://user-images.githubusercontent.com/22786385/115259995-8f68b800-a15c-11eb-96f6-1f8d859cb2ab.png" width=500">

---
#### Compile code:
At `sloppy_test` root directory, run this command first to compile Java source files into class files:

```
mvn clean compile
```

![image](https://user-images.githubusercontent.com/22786385/115310284-bee8e600-a197-11eb-991b-dcd4ec6c368e.png)

---
#### The TestNG pack:
Then run this command to execute the TestNG pack from cmd:
```java -cp "target\classes;lib\*" org.testng.TestNG testng.xml```
<img src="https://user-images.githubusercontent.com/22786385/115480065-f4fb9800-a273-11eb-8292-c6a4fce7af66.png" width="850">

---
#### The Cucumber pack:
Run this command to execute the Cucumber pack from cmd:
```java -cp target\classes;lib\* cucumber.api.cli.Main --glue phipgn.sloppy_test.bdd.steps src/test/java/phipgn/sloppy_test/bdd/features --tags @searchCity --monochrome --plugin pretty --plugin json:target/cucumber-reports/Cucumber.json --plugin html:target/cucumber-reports --plugin junit:target/cucumber-reports/Cucumber.xml```
<img src="https://user-images.githubusercontent.com/22786385/115479553-cdf09680-a272-11eb-80f7-120b46a82c5a.png">
<img src="https://user-images.githubusercontent.com/22786385/115479751-48211b00-a273-11eb-8892-a663bbf21b2b.png" width="850">

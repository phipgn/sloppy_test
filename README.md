# Sloppy Test
This is a take-home assignment from NAB. I made up an automation test project and named it "Sloppy Test".

## To-do checklist:
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
- [ ] Capture a screenshot if test fails
- [ ] Provide CI/CD integration solution
- [ ] Abibility to run test in parallel
- [ ] Cloud integration solution
- [ ] Distribution execution

## How to run the test?
**Software Requirements**
* OS: Windows 10.
* IDE: Eclipse version 2018-09 (4.9.0).
    * TestNG plugin installed **(Make sure to untick `TestNG M2E (Maven) Integration (Optional)`)**.
    * Cucubmer plugin installed.
* JDK 8 (1.8.0_261).

### From Eclipse IDE

#### The TestNG pack:

Right click on Search Test > Run as > TestNG
![image](https://user-images.githubusercontent.com/22786385/115260500-01410180-a15d-11eb-8df9-719e81109068.png)

#### The Cucumber pack:

Right click on TestRunner > Run as > Junit test
![image](https://user-images.githubusercontent.com/22786385/115260666-2b92bf00-a15d-11eb-812c-78832c7533bf.png)


### From console

#### The TestNG pack:

Download Maven from: https://maven.apache.org/download.cgi `apache-maven-3.8.1-bin.zip` and extract the zip file to `C:/maven`

Make sure to add Maven bin folder and JDK bin foler to environment path like this:
![image](https://user-images.githubusercontent.com/22786385/115259995-8f68b800-a15c-11eb-96f6-1f8d859cb2ab.png)

Then run this command line to execute the TestNG pack from cmd:
```
mvn clean test -DsuiteXmlFile=testng.xml -Dmaven.test.failure.ignore=true
```

![image](https://user-images.githubusercontent.com/22786385/115259680-4a448600-a15c-11eb-8629-40fdbfe1fbad.png)

#### The Cucumber pack:

![image](https://user-images.githubusercontent.com/22786385/115146698-c74efd00-a081-11eb-9dbc-f6697d05d96a.png)

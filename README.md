# Sloppy Test
This is a take-home assignment from NAB. I made up an automation test project and named it "Sloppy Test".

*I wrote 2 UI tests* (match with **U001** and **U002** test cases from documents\TestCases.xlsx).

At first, I developed the project to run the test using TestNG. Then I added the Cucumber feature into it. That's why we have 2 packs (TestNG pack and Cucumber pack) here.

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
- [x] Capture a screenshot if test fails
- [x] Provide CI/CD integration solution (can explain this)
- [ ] Cloud integration solution
- [ ] Abibility to run test in parallel (cannot make it work yet due to some technical issues)
- [ ] Distribution execution

## How to run the test?

### From Eclipse IDE
#### Software requirements:
* OS: Windows 10.
* IDE: Eclipse version 2018-09 (4.9.0).
    * TestNG plugin installed **(Make sure to untick `TestNG M2E (Maven) Integration (Optional)`)**.
    * Cucubmer plugin installed.
* JDK 8 (1.8.0_261) installed.

![image](https://user-images.githubusercontent.com/22786385/115309099-fce50a80-a195-11eb-9151-fa86df069b6e.png)
![image](https://user-images.githubusercontent.com/22786385/115309163-1ab26f80-a196-11eb-8576-988c1074c791.png)

Make sure to have only JDK bin added to your `Path` system variables. Please remove the Oracle Java path (if any).
![image](https://user-images.githubusercontent.com/22786385/115308146-7a0f8000-a194-11eb-9c11-f02559d569c4.png)

In Eclipse, under Windows > Preferences > Java > Installed JREs: Make sure you selected jdk directory.
![image](https://user-images.githubusercontent.com/22786385/115308535-1043a600-a195-11eb-962a-6ecb0ec63431.png)

![image](https://user-images.githubusercontent.com/22786385/115308701-5436ab00-a195-11eb-93ce-3a19d8cf00dd.png)
![image](https://user-images.githubusercontent.com/22786385/115308654-41bc7180-a195-11eb-9a8f-cca95c0219c3.png)

You can configure to run the tests with chrome or firefox as well:
![image](https://user-images.githubusercontent.com/22786385/115310887-d4124480-a198-11eb-80d8-b1f48b359a95.png)

#### The TestNG pack:

Right click on Search Test > Run as > TestNG
![image](https://user-images.githubusercontent.com/22786385/115260500-01410180-a15d-11eb-8df9-719e81109068.png)

#### The Cucumber pack:

Right click on TestRunner > Run as > Junit test
![image](https://user-images.githubusercontent.com/22786385/115260666-2b92bf00-a15d-11eb-812c-78832c7533bf.png)
![image](https://user-images.githubusercontent.com/22786385/115146698-c74efd00-a081-11eb-9dbc-f6697d05d96a.png)

### From console
Download Maven from: https://maven.apache.org/download.cgi `apache-maven-3.8.1-bin.zip` and extract the zip file to `C:/maven`

Make sure to add Maven bin folder and JDK bin foler to environment path like this:
![image](https://user-images.githubusercontent.com/22786385/115259995-8f68b800-a15c-11eb-96f6-1f8d859cb2ab.png)

#### Compile code:
At `sloppy_test` root directory, run this command first to compile Java source files into class files:

```
mvn clean compile
```

![image](https://user-images.githubusercontent.com/22786385/115310284-bee8e600-a197-11eb-991b-dcd4ec6c368e.png)

#### The TestNG pack:
Then run this command to execute the TestNG pack from cmd:
```
java -cp "target\classes;lib\*" org.testng.TestNG testng.xml
```

![image](https://user-images.githubusercontent.com/22786385/115259680-4a448600-a15c-11eb-8629-40fdbfe1fbad.png)

#### The Cucumber pack:
Run this command to execute the Cucumber pack from cmd:
```
java -cp target\classes;lib\* cucumber.api.cli.Main --glue phipgn.sloppy_test.bdd.steps src/test/java/phipgn/sloppy_test/bdd/features --plugin pretty
```

![image](https://user-images.githubusercontent.com/22786385/115310243-b1336080-a197-11eb-8eaf-880d18e92001.png)

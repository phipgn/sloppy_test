# Sloppy Test
This is a take-home assignment from NAB. I made up an automation test project and named it "Sloppy Test". This is a projected based on Java/Selenium/TestNG/Cucumber/Maven.

*I wrote 2 UI tests* (match with **U001** and **U002** test cases from documents\TestCases.xlsx).

I deleloped this framework under 2 aprroachs: TestNG only and Cucumber layer on top of TestNG. That's why there are 2 ways to execute the test (via TestNG and via Cucumber).

# Framework structure

![image](https://user-images.githubusercontent.com/22786385/115995462-7bfa9880-a605-11eb-9d43-b21931536348.png)

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
- [x] ~~Abibility to run test in parallel~~
  - [x] ~~via TestNG~~
  - [x] ~~via Cucumber~~
- [x] ~~Provide CI/CD integration solution~~
  - [x] ~~CI/CD integration solution~~
  - [ ] Cloud integration solution
  - [ ] Distribution execution

---

# How to run the test from Eclipse IDE?

#### Software requirements:
* OS: Windows 10.
* IDE: [Eclipse JavaEE version 2018-09 (4.9.0)](https://www.eclipse.org/downloads/packages/release/2018-09/r).
    * TestNG plugin installed (Make sure to untick `TestNG M2E (Maven) Integration (Optional)` option when installing).
    * Cucubmer plugin installed.
    * _These 2 above plugins could be found and installed under Help > Eclipse Marketplace_
* [JDK 8 (1.8.0_261)](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) installed.

Optional items:
* [Freemind (for reading .mm mindmap files)](http://freemind.sourceforge.net/wiki/index.php/Download)
* [Dia (for reading diagram files)](https://sourceforge.net/projects/dia-installer/files/dia-win32-installer/0.97.2/dia-setup-0.97.2-2-unsigned.exe/download)

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

# Note:

If you find some errors about missing libraries or something then it might be resolved just by `Right clicking on the project > Maven > Update project...`

![image](https://user-images.githubusercontent.com/22786385/115995736-a39e3080-a606-11eb-9b47-9b697acb14d4.png)

---

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

# CI/CD Pipeline

For the last 2 items of the to-do checklists, I cannot say that I have hands-on working experience (like how to set up and stuff) with them. But I have experience interacting with them. Based on those experience, I can understand and be able to create the diagrams that depict my ideas and understanding on these 2 items. Below is the diagram I made for the CI/CD integration solution. In this big picture, cloud could play an important role, we could utilize the power of cloud services to make less the effort (but with more money I guess). For example, Jenkins agents could be on cloud, the same for Jenkins master... basically, most things in this picture could be on cloud depends on which one we want it to be.

![CICDPipeline](https://user-images.githubusercontent.com/22786385/115988399-c2d79680-a5e3-11eb-85cf-19354fa058ba.jpeg)

For the CI scheduler, I set up a local Jenkins myself with both master and agent on my local machine. I have experience working with TeamCity but not setting up a full pipeline, just a part of the pipeline specific for automation test. Never setting up a Jenkins master before so yeah, this assignment is a good chance for me to do that. Not a big deal but it's always been a good feeling to do such things.

<img src="https://user-images.githubusercontent.com/22786385/115793704-c78b2780-a3f6-11eb-9ef3-8e8334a9d4f3.png" width="850">
<img src="https://user-images.githubusercontent.com/22786385/115793711-cd810880-a3f6-11eb-85df-5f7142cfea1e.png" width="850">

 # Distribution Execution

I have very limited ideas of this, but anyway, I drew this diagram out of my understanding for this concept.

![DistributedTestExecutionScheme](https://user-images.githubusercontent.com/22786385/115989169-3af38b80-a5e7-11eb-80d0-85dcc924d74d.jpeg)


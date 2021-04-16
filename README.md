# gatling-example-neev
Gatling Demo with Maven

###  System Setup

#### 1. Install homebrew

`/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`

#### 2. Install Java and
Now that you have homebrew,you can get JDK using Homebrew cask.

`brew cask install java`

#### 3. Get Maven

`brew install maven`


### 4. Get IntelliJ or any IDE of your choice
https://www.jetbrains.com/idea/
Install Scala Plugin for Intellij refer `http://allaboutscala.com/tutorials/chapter-1-getting-familiar-intellij-ide/scala-environment-setup-install-scala-plugin-intellij/`

### 5. Finally clone or download this repo & import it on IntelliJ as a maven project
to clone: 
`git clone https://github.com/neha-thoughtworks/gatling-example-neev.git`
Wait for intellij to install all the maven dependencies

### 6. Add scala sdk library to intellij.
Open Engine or one of the scala classes in Intellij, A prompt to add scala SDK will come up, Add the latest version of scala SDK
Or
Right click on gatling-example-neev folder select Project Structure dialog. Find scala-sdk in Libraries or Global Libraries tab and select Add to modules in the context menu


### 7. To run a simulation:
Example to run MyFirstTest
`mvn gatling:test -Dgatling.simulationClass=testScripts.MyFirstTest`
Or 
right click on Engine & choose `Run`
You should see gatling tests run and a result file will appear at the end.

### 8. TroubleShoot
To Trouble Shoot Scala Sdk module or scala plugin errors 
Right click on gatling-example-neev folder and click on Build module 'gatlingexampleNeev'

Step by step instructions are also available on Shwetha's blog
https://medium.com/@hegdeshweta/load-performance-testing-using-gatling-1-9123c755dd87








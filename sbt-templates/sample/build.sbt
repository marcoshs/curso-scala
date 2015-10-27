//Build.sbt sample for a simple application with some library dependencies.
//Author: marcoshs
 
organization := "la.aquare" //change it for you domain
name := "sample"
version := "1.0.0"
scalaVersion := "2.11.7"

//some dependencies:

	//Unit Test:
	libraryDependencies += "junit" % "junit" % "4.12" % "test"							
	//												    ^ 
	//												  This last argument assures that this library
	//												  won't be added to production package 	
	
	//For SBT command line Junit test execution
	libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"		
	
	//Uncomment those lines to add them or use it as template for new libraries 
	//libraryDependencies += "org.json4s" % "json4s-native_2.11" % "3.2.10"  	
	//libraryDependencies += "org.json4s" % "json4s-jackson_2.11" % "3.2.10" 	

// end of dependencies

//settings for SBT command line Junit test execution
	testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")


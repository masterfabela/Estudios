This is the NeoDatis ODB 1.9 package for Java

Have a look at www.neodatis.org 
or join the NeoDatis ODB Forum at : http://sourceforge.net/forum/?group_id=179124 if you have any question or problem

Please let us know what you think about NeoDatis giving us feedback.

To execute NeoDatis, you will need a Java Virtual Machine 1.5 or later.

Thank you
NeoDatis Team



Index 

1 - Content of the package
2 - How to execute the Tutorial
3 - How to compile the Tutorial
4 - How to execute the ODB Explorer to consult/update data

--------------------------------------------------------------------------------------

1 - Content of the package

	-- neodatis-odb-xxx.jar : The ODB java runtime
	-- odb-explorer.bat : A batch to execute the ODB Explorer
	-+ doc: documentation directory
	 |--- NeoDatisObjectDatabse.pdf : the NeoDatis full documentation
	 |--- odb-javadoc.jar  : The ODB javadoc
	 |--- tutorial.jar     : The compiled Tutorial classes
	 |--- build.xml        : An ant script file to compile the Tutorial java source
	 |--- run-tutorial.bat : A Bat to execute the Tutorial
	 |--+ src : The Tutorial source code



2 - How to execute the Tutorial

The tutorial can be executed by executing the run-tutorial.bat or by executing the following command:

	$ cd $ODB-package$/doc
	$ java -cp tutorial.jar;../neodatis-odb-xxx.jar com.neodatis.odb.tutorial.Tutorial1



3 - How to compile the Tutorial

	This step requires the Ant package version 1.6 or later(http://ant.apache.org/)
	
	$ cd $ODB-package$/doc
	$ ant
	
	This compilation will re-create the tutorial.jar file.



4 - How to execute the NeoDatis Object Explorer to consult/update data

	To execute the NeoDatis Object Explorer execute the odb-explorer.bat batch file or execute the following command:
	
	$ cd $ODB-package$/
	$ java -jar neodatis-odb-xxx.jar
	
	
	
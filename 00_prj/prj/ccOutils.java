package prj;

import org.capcaval.ccoutils.lafabrique.AbstractProject;

public class ccOutils extends AbstractProject{
	

	@Override
	public void defineProject(){
		name("ccOutils");
		version("0.0.1");
		author("CapCaval.org");
		copyright("CapCaval.org");
		licence("MIT");
		url("http://ccoutils.capcaval.org");

		projectDir("00_prj");
		source("01_src");
		packageName("org.capcaval.ccoutils");
		libDir("02_lib");
		
		lib("junit-4.8.2.jar");
		
		jdkVersion("jdk1.7.0_09");
		
		librairiePath("04_lib");
		librairiesForCompiling("ccTools");
		prodDirPath("20_prod");

		jar.name("ccOutils.jar");
		jar.excludeDirectoryName("_test");
		
		// tout compiler dans bin
		// copier la compil sans les rep _test dans temp/jar
		// rapport de compil
		// faire le manifest
		// faire le jar à partir fr temp/jar
		// passer les tests avec le jar
		// rapport de test
		
		// java -jar c3.jar GUI
		// java -jar c3.jar newProject d:/workspace/
		// java -jar c3.jar build
		// java _jar C3.jar performTest
	}





}

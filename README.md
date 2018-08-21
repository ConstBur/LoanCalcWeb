# LoanCalcWeb
Loan Calculator Web Application with Maven, Subversion, Jenkins and Tomcat

How-To:

  Prerequisites (remote machine):
    1) Subversion Repository
    2) Jenkins
    3) Tomcat 8
    Local Machine: Netbeans/Eclipse or any IDE supporting Java, Maven and remote Subversion Repos

  Deployment chain:
    1) Maven Project code is created/modified/deleted in the IDE.
    2) The changes are committed to Subversion Repo.
    3) Subversion shell script triggers Jenkins Maven build.
    4) Maven builds the WAR project file.
    5) Jenkins Tomcat Plugin deploys the WAR file on Tomcat.

  Important Points:
    I) Maven Project:
      1) pom.xml must contain <packaging>war</packaging> to make Maven build a WAR file.
      2) Indicating version in pom.xml has no effect.
    II) Subversion:
      1) svnadmin utility is required to create the repo
      2) The hook script (post-commit) should be inside the config/hooks folder inside the repo.
    III) Jenkins:
      1) Choose "Trigger builds remotely from scripts" and put a long string of random chars (token, used in hook script in Subversion repo).
      2) Use Token Macro Plugin to change the build number in the pre-build.
      3) Use -D"macro" to change the version of the WAR built by Maven (set in Maven goals).
      4) "clean install" runs the tests and builds the WAR.
      5) Use of "Deploy EAR/WAR to Tomcat" plugin didn't change version numbers when deployed on Tomcat.
    IV) Tomcat 8:
      1) Set it on a port different from 8080 (used by Jenkins).
      2) Be sure to create a user with role "manager-script" to allow remote deploying from command line in tomcat-users.xml.
      

Team Wombat - Instructions to run DDL Application:

Pre-Requisites:

  - Please make sure you are running the application in a Windows environment as these instructions will have windows-specific commands
  - Please make sure java is installed on your machine
  - Please download and unzip the project folder onto an easily accessible place on your machine

Instructions: 

  1. Click the windows start menu and type "cmd". The command prompt application should show as a result of the search.
  2. Open the Command Prompt application by clicking on it.
  3. Navigate to the root project directory by using "cd" commands in command prompt.
	- You can find the directory using the regular file explorer and drag + dropping it into command prompt. This will copy the path to command promt.
	- For more information on how to use "cd" commands, visit: https://www.digitalcitizen.life/command-prompt-how-use-basic-commands
  4. Once you are in root directory, you will need to navigate to the jar file. This file will actually run the application. Copy the command below into command promt and press "Enter":
	- cd out/artifacts/FinalProject_422_jar
  5. Now you will run the jar file using the following command:
	- "java -jar FinalProject_422.jar" (do not include the quotes, they were meant to distinguish from the '-' at the beginning).
  6. Press "Enter". The application window should pop up on your screen.
  7. Now, load an input file into the application, there is one provided. You can add it by following these steps:
	- In the menu bar at the top of the application menu, select "File"
	- Select "Open Edge File"
	- Navigate to the root project directory again 
	- Once in the root directory double click on the "inputFiles" folder and then double click the "Courses.edg" file.
  8. There should now be some information loaded into your application.
  9. Select an output path by doing the following: 
	- Select "Options" from the top menu
	- Select "Set Output File Definition Location"
	- Navigate to the root project directory
	- Then click on the folders: out -> production -> FinalProject_422 -> com -> example -> finalproject422.
	- Click "open" in the file explorer menu.
  10. Click "OK" on the dialog that pops up.
  11. You can now export a MySQL file by clicking the "Create DDL" button in the bottom right of the application window.
  12. You will need to select the type (only one available now)
  13. You will need to select the location to save the output file
	- there is an "outputFiles" directory under the root directory you could use, but you could save it anywhere you'd like.

# Inzenjering znanja PC
 
#Technologies
 -Frontend: Angular
 -Backend: Spring

#Installation
 1. Clone the repository https://github.com/vladakac/Inzenjering-znanja-PC.git
 2. Positioning to the develop branch using command git checkout develop and pull code using git pull command
 3. Run fuseki server, with dataset labeled "iz" and import files "classes_xml" and "instances_xml"
	- "pc_purpose_fcl" file describes fuzzy logic
	- "malfunctions.net" file describes bayes logic
 4. Backend - open Java project, refresh maven dependencies if is necessary and run 
 5. Frontend - open terminal in project directory and run:
 	- npm update
 	- npm install
 	- ng serve
  
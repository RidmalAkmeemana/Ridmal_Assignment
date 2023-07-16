@echo off
set "prohjectPath=D:\IdeaProjects\Ridmal_Assignment"
cd /d %prohjectPath%
mvn clean install > con 2>&1
pause
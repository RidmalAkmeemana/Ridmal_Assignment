@echo off
set "prohjectPath=D:\IdeaProjects\Ridmal_Assignment"
set "logPath=C:\Users\Ridmal\Downloads\TestLogs.log"
cd /d %prohjectPath%
echo START TEST %prohjectPath%
mvn clean install > %logPath% 2>&1
echo TEST COMPLTED & LOGS SAVED IN %logPath%
pause
@echo off
echo starting ...
setlocal

set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_45
set CLASSPATH=.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar
set PATH=%JAVA_HOME%\bin;%PATH%

echo processing ...
call mvn clean install -Dmaven.test.skip=true

endlocal
echo ending ...

pause
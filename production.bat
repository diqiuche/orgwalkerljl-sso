@echo off
echo starting ...
setlocal

set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_45
set CLASSPATH=.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar
set PATH=%JAVA_HOME%\bin;%PATH%

echo processing ...
call mvn clean -U package -Pproduction -Dmaven.test.skip=true

copy orgwalkerljl-sso-web\target\*.war F:\export\App\sso.walkerljl.com\*.war
endlocal
echo ending ...

pause
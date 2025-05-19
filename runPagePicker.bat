@echo off
REM Set paths
set SRC_DIR=src
set BIN_DIR=bin
set PACKAGE=pagePicker
set CLASS=PagePicker

REM Compile the code
javac -d %BIN_DIR% %SRC_DIR%\%PACKAGE%\%CLASS%.java

REM Run the code
java -cp %BIN_DIR% %PACKAGE%.%CLASS%

pause
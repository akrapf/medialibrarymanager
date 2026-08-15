@echo off

echo Building MLM...
echo.

cd /d "%~dp0.."

if not exist bin mkdir bin

javac -d bin -sourcepath src src\mlm\app\Main.java

if %errorlevel% neq 0 (
    echo.
    echo Build failed.
    pause
    exit /b 1
)

echo.
echo Build successful.
pause
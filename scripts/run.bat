@echo off

cd /d "%~dp0.."

java -cp bin mlm.app.Main

if %errorlevel% neq 0 (
    echo.
    echo MLM failed to start or exited with an error.
    echo.
    pause
    exit /b 1
)
@echo off

echo Cleaning MLM...
echo.

if exist bin (
	rmdir /s /q bin
	echo Build files removed.
) else (
	echo Nothing to clean.
)

echo.
pause
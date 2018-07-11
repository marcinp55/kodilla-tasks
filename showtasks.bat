call runcrud
if "%ERRORLEVEL%" == "0" goto startbrowser
echo.
echo RUNCRUD encountered errors - breaking work
goto fail

:startbrowser
start "" http://localhost:8080/crud/v1/task/getTasks
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.
@echo off
setlocal
set srcDir=src
set binDir=bin
if not exist %binDir% mkdir %binDir%
for /r %srcDir% %%f in (*.java) do (
    javac -d %binDir% "%%f"
)
endlocal
@echo on
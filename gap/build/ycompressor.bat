for /f %%i in ('dir /b /s "*.js"') do (
	java -jar ycompressor.jar --type js %%i -o %%i --charset utf-8
)
for /f %%i in ('dir /b /s "*.css"') do (
	java -jar ycompressor.jar --type css %%i -o %%i --charset utf-8
)
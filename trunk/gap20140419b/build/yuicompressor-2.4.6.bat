for /f %%i in ('dir /b /s "*.js"') do (
	java -jar yuicompressor-2.4.6.jar --type js %%i -o %%i --charset utf-8
)
for /f %%i in ('dir /b /s "*.css"') do (
	java -jar yuicompressor-2.4.6.jar --type css %%i -o %%i --charset utf-8
)
for /f %%i in ('dir /b /s "*.js"') do (
	java -jar yuicompressor-2.4.6.jar --type js %%i -o %%i --charset utf-8
)
for /f %%i in ('dir /b /s "*.css"') do (
	java -jar yuicompressor-2.4.6.jar --type css %%i -o %%i --charset utf-8
)
for /f %%i in ('dir /b /s "*.js"') do (
	gzip -f9 -S .gzjs %%i
)
for /f %%i in ('dir /b /s "*.gzjs"') do (
	ren %%i %%~ni
)
for /f %%i in ('dir /b /s "*.css"') do (
	gzip -f9 -S .gzcss %%i
)
for /f %%i in ('dir /b /s "*.gzcss"') do (
	ren %%i %%~ni
)
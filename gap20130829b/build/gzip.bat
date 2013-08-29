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
If Not Exist %2\build\B4Alibs\ ( mkdir %2\build\B4Alibs\ )
%1\bin\javadoc.exe -doclet BADoclet -docletpath C:\B4X\B4A\Doclet -sourcepath %2\src\main\java %3 -classpath %4 -b4atarget %5
@echo off
echo 删除数据表字段本地配置缓存：../cmcc-dataaccess/src/main/cas-cmcc-prefs.properties
cd ../cmcc-dataaccess/src/main
del /q cas-cmcc-prefs.properties

pause
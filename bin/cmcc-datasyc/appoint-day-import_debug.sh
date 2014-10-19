#$1:时间
#$2:类型(ftp或mro)
nohup java -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8787,server=y,suspend=y -jar cmcc-datasyc-0.0.1-SNAPSHOT.jar -d $1 $2 $3 $4
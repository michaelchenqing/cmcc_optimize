#将本地目录下的所有文件同步到cmcc1,2，及本地文件，用于hdfs文件通用备份
cp -r * ~/opt/datasyc/hdfs_backup/
scp -r * cmcc@cmcc1:~/opt/datasyc/hdfs_backup/
scp -r * cmcc@cmcc3:~/opt/datasyc/hdfs_backup/
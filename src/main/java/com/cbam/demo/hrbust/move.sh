#!/usr/bin/env bash


IP_ARRAY=(l-payserver6.pay.beta.cn0, l-payserver104.pay.beta.cn0, l-payserver120.pay.beta.cn0,l-payserver136.pay.beta.cn0, l-payserver152.pay.beta.cn0, l-payserver249.pay.beta.cn0, l-payserver264.pay.beta.cn0)

USER=`who i am |   awk '{print $1}'`
#文件目录
DIR=/home/q/home/${USER}
#FTP目录
DESDIR=/home/${USER}
#######上传脱机文件##################################
#获取文件
cd ${DIR}

for item in ${IP_ARRAY[@]};
do
   echo ${item}
   #发送文件
    sftp yan.zheng@l-payserver6.pay.beta.cn0
    cd ${DESDIR}/
    put 'US_export_policy.jar'
    put 'local_policy.jar'
    bye
    ssh ${IP}
    sudo mv local_policy.jar /home/q/java/jdk1.7.0_45/jre/lib/security
    sudo mv US_export_policy.jar /home/q/java/jdk1.7.0_45/jre/lib/security
    exit
done
EOF
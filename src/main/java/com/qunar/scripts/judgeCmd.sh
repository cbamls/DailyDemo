#!/usr/bin/env bash
in_path() {
    cmd=$1  ourpath=$2 result=1
    oldIFS=$IFS  IFS=":"
    for directory in "$ourpath"
    do
        if()
}
#!/bin/bash
echo "[compiling java component...]"
echo "    javac -cp target -d target net/pledin30/$1.java"
javac -cp target -d target net/pledin30/$1.java
echo "[executing java component...]"
echo "    java -cp target net.pledin30.$1"
java -cp target net.pledin30.$1
echo "[finishing...]"

#!/bin/bash
echo "[build.sh examples:]"
echo "  $ ./build.sh net/w3resource/lists/LstBundle01.java"
echo "[compiling java component...]"
echo "    javac -cp target -d target $1"
javac -cp target -d target $1
echo "[executing java component...]"
echo "    java -cp target $1"
java -cp target $1
echo "[finishing...]"

#!/bin/bash

PROJECT_ROOT=$(dirname "$0")

SRC_DIR="$PROJECT_ROOT/src"

BIN_DIR="$PROJECT_ROOT/bin"

LIB_DIR="$PROJECT_ROOT/lib"
LIB_JAR="hsqldb.jar"

CLASSPATH="$BIN_DIR:$LIB_DIR/$LIB_JAR"

mkdir -p "$BIN_DIR"

find "$SRC_DIR" -name "*.java" > sources.txt
javac -d "$BIN_DIR" -classpath "$CLASSPATH" @sources.txt
rm sources.txt

MAIN_CLASS="app.cui.CUI"
java -classpath "$CLASSPATH" "$MAIN_CLASS"

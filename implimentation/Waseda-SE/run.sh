#!/bin/bash

# プロジェクトのルートディレクトリ
PROJECT_ROOT=$(dirname "$0")

# ソースファイルのディレクトリ
SRC_DIR="$PROJECT_ROOT/src"

# 出力クラスファイルのディレクトリ
BIN_DIR="$PROJECT_ROOT/bin"

# ライブラリのディレクトリ
LIB_DIR="$PROJECT_ROOT/lib"
LIB_JAR="hsqldb.jar"

# クラスパスの設定
CLASSPATH="$BIN_DIR:$LIB_DIR/$LIB_JAR"

# binディレクトリを作成（存在しない場合）
mkdir -p "$BIN_DIR"

# ソースファイルをコンパイル
find "$SRC_DIR" -name "*.java" > sources.txt
javac -d "$BIN_DIR" -classpath "$CLASSPATH" @sources.txt
rm sources.txt

# メインクラスの実行（例としてMainクラスを使用）
MAIN_CLASS="app.cui.CUI"
java -classpath "$CLASSPATH" "$MAIN_CLASS"

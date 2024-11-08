# 1. ベースイメージとしてJava 17を使用
FROM openjdk:17-jdk-slim

# 2. 作業ディレクトリを設定
WORKDIR /app

# 3. Mavenビルドの成果物をコンテナにコピー
# 注意: ./target で相対パスを指定しています。
COPY ./target/bmr-0.0.1-SNAPSHOT.jar app.jar

# 4. コンテナ起動時のコマンドを指定
CMD ["java", "-jar", "app.jar"]

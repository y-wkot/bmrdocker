# 1. ベースイメージとしてJava 17を使用
FROM openjdk:17-jdk-slim

# 2. Mavenをインストールする
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# 3. 作業ディレクトリを設定
WORKDIR /app

# 4. ソースコードをコンテナにコピー
COPY . .

# 5. プロジェクトをビルド
RUN mvn clean package -DskipTests

# 6. コンテナ起動時のコマンドを指定
CMD ["java", "-jar", "target/bmr-0.0.1-SNAPSHOT.jar"]
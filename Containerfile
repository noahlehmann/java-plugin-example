FROM maven:3.9.6-eclipse-temurin-21-jammy AS builder

WORKDIR /app

COPY . .

RUN mvn -q clean package -DskipTests

RUN rm -rf dist &&  \
    mkdir -p dist/plugins && \
    cp plugins/*/target/*-all.jar dist/plugins/ && \
    cp plugins/enabled.txt dist/plugins/ && \
    cp plugins/disabled.txt dist/plugins/ && \
    cd dist  \
    && jar xf ../text-transform/target/*.zip

FROM eclipse-temurin:21-jre-jammy AS run

WORKDIR /app

COPY --from=builder /app/dist /app

CMD ["sh", "-c", "java -jar /app/*.jar"]
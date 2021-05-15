# R2DBC Demo Project (Todo)

## プロジェクト作成
https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.4.5.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.orangeman.example&artifactId=todo&name=todo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.orangeman.example.todo&dependencies=webflux,data-r2dbc,devtools,mariadb

## API確認

### GET
```
curl -XGET http://localhost:8080/api/tasks
```

### PUT
```
curl -XPUT 'http://localhost:8080/api/tasks' \
--header 'Content-Type: application/json' \
-d '{
    "id": 1,
    "completed": true
}'
```
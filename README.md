# redis

Get Rank: 
curl -H "Accept: application/json" -H "Content-type: application/json" -X GET http://localhost:8080/v1/v0.1/student/{student_id}

Upsert Rank: 
curl -H "Accept: application/json" -H "Content-type: application/json" -X PUT -d '{"studentId":"121", "score": 101}' http://localhost:8080/v1/v0.1/marks

Get LeaderBoard: 
curl -H "Accept: application/json" -H "Content-type: application/json" -X GET http://localhost:8080/v1/v0.1/student/leaderboard\?offset\=5\&limit\=10

[[lv.3] #43105 정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java)
---

- Dynamic Programming
```
    dp[row][col] = triangle[row][col] 
                    + Math.max(dp[row-1][col], dp[row-1][col-1])
```
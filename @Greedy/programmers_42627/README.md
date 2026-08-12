[[lv.3] #42627 디스크 컨트롤러](https://school.programmers.co.kr/learn/courses/30/lessons/42627)
---

- Greedy
- PriorityQueue

- 이차원 배열 정렬
    `Arrays.sort(arr, (a,b)->a[0]-b[0])`

- idle time 건너뛰기
    ```
    if(pq.isEmpty()){
        currentTime = jobs[idx][0];
        continue;
    }
    ```
[[lv.4] #43236 징검다리](https://school.programmers.co.kr/learn/courses/30/lessons/43236)
---

- 이분탐색
    - mid : 최소 간격 기준
    - removed : mid 간격 조건을 충족하기 위해 무조건 없애야 하는 바위 개수
    ```
    for(int i=0; i<rocks.length; i++){
        if(rocks[i]-prev < mid){
            removed++;
        }else{
            prev = rocks[i];
        }
    }
    if(distance-prev < mid){ removed++;} // <마지막 바위-도착 지점> 사이 간격도 고려
    ```
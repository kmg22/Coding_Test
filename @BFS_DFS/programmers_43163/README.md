[[lv.3] #43163 단어변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java)
---

- try1
    - 이웃 단어 간 edge(neighbors) 묶기
    - words[i] <-> target 최단 거리 계산 | calc(), dijkstra
    - begin과 이웃 단어 확인
    - dist[i]+1 중 최솟값
    -> 시간복잡도 : O(N² × L)
    -> 공간복잡도 : O(N²)

- try2
    - bfs 매 단계 이웃 words 탐색
    - begin -> target 도달 시 bfs 종료
    -> 시간복잡도 : O(N² × L)
    -> 공간복잡도 : O(N)


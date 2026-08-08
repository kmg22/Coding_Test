[[lv.2] #42746 가장 큰 수](https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=java)
---

- 정렬(문자열 조합 내림차순)
    `Arrays.sort(arr, (a,b)->(b+a).compareTo(a+b))`
    - ex. `3`+`30` -> `330`,`303`

- int -> String
    `String.valueOf(1)`

- String[] -> String
    `String.join("", arr)`
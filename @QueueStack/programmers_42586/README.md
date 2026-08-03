[[lv.2] #42586 기능개발](https://school.programmers.co.kr/learn/courses/30/lessons/42586)
---

- Queue
- List to int Array
```
List<Integer> list = new ArrayList<>();
list.add(1);
int[] array = list.stream().mapToInt(Integer::intValue).toArray();
```


---

### 입력
[1, 2, 3, 2, 3]

---
### 출력
[4, 3, 1, 1, 0]
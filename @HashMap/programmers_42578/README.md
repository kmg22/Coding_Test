[[lv.2] #42578 의상](https://school.programmers.co.kr/learn/courses/30/lessons/42578)
---

- HashMap 순환
```
for(String key : hm.getKey()){ 
    int value = hm.get(key);
}
```
```
for(int value : hm.values()){ ... }
```


import java.util.*;

class Solution {
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    private int bfs(int[][] maps){
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];
        
        // 시작 위치
        q.offer(new int[] {0,0});
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            if(currX==N-1 && currY==M-1){
                return dist[currX][currY];
            }
            
            for(int i=0; i<4; i++){
                int nextX = currX+dx[i];
                int nextY = currY+dy[i];
                
                if(nextX<0 || nextX>=N || nextY<0 || nextY>=M){ continue; }
                if(maps[nextX][nextY]==0 || visited[nextX][nextY]){ continue; }
                
                q.offer(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
                dist[nextX][nextY] = dist[currX][currY]+1;
            }
        }
        
        return -1;
    }
}
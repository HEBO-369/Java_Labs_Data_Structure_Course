import java.awt.Point;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IPlayersFinder {
    /**
     * Search for players locations at the given photo
     * @param photo
     *     Two dimension array of photo contents
     *     Will contain between 1 and 50 elements, inclusive
     * @param team
     *     Identifier of the team
     * @param threshold
     *     Minimum area for an element
     *     Will be between 1 and 10000, inclusive
     * @return
     *     Array of players locations of the given team
     */
    java.awt.Point[] findPlayers(String[] photo, int team, int threshold);
}

public class PlayersFinder implements IPlayersFinder {
    private static class BoundingBox {
        int minX, minY, maxX, maxY, area;
        
        public BoundingBox() {
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            maxX = Integer.MIN_VALUE;
            maxY = Integer.MIN_VALUE;
            area = 0;
        }
        
        public Point getCenter() {
            int centerX = (minX + maxX + 1) / 2;
            int centerY = (minY + maxY + 1) / 2;
            return new Point(centerX, centerY);
        }
    }
    
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};
    
    @Override
    public Point[] findPlayers(String[] photo, int team, int threshold) {
        if (photo == null || photo.length == 0 || photo[0].length() == 0) {
            return new Point[0];
        }
        
        char teamChar = Character.forDigit(team, 10);
        
        int height = photo.length;
        int width = photo[0].length();
        
 
        boolean[][] visited = new boolean[height][width];
        
        List<Point> players = new ArrayList<>();
        
 
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (visited[y][x] || photo[y].charAt(x) != teamChar) {
                    continue;
                }
                
                BoundingBox box = new BoundingBox();
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{x, y});
                visited[y][x] = true;
                
                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    int cx = cell[0];
                    int cy = cell[1];
                    
                    box.minX = Math.min(box.minX, cx * 2);
                    box.minY = Math.min(box.minY, cy * 2);
                    box.maxX = Math.max(box.maxX, cx * 2 + 1);
                    box.maxY = Math.max(box.maxY, cy * 2 + 1);
                    
                    box.area += 4;
                    
                    for (int i = 0; i < 4; i++) {
                        int nx = cx + dx[i];
                        int ny = cy + dy[i];
                        
                        if (nx >= 0 && nx < width && ny >= 0 && ny < height && 
                            !visited[ny][nx] && photo[ny].charAt(nx) == teamChar) {
                            queue.add(new int[]{nx, ny});
                            visited[ny][nx] = true;
                        }
                    }
                }
                
                if (box.area >= threshold) {
                    players.add(box.getCenter());
                }
            }
        }
        
        players.sort((p1, p2) -> {
            if (p1.x != p2.x) {
                return Integer.compare(p1.x, p2.x);
            }
            return Integer.compare(p1.y, p2.y);
        });
       
        return players.toArray(new Point[0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
           
            String firstLine = scanner.nextLine().trim();
            String[] dimensions = firstLine.split(",\\s*");
            int rows = Integer.parseInt(dimensions[0].trim());
            int cols = Integer.parseInt(dimensions[1].trim());
            
            String[] photo = new String[rows];
            for (int i = 0; i < rows; i++) {
                if (scanner.hasNextLine()) {
                    photo[i] = scanner.nextLine().trim();
                }
            }
            
            int team = Integer.parseInt(scanner.nextLine().trim());
            int threshold = Integer.parseInt(scanner.nextLine().trim());
            
            PlayersFinder finder = new PlayersFinder();
            Point[] players = finder.findPlayers(photo, team, threshold);
            
    
            System.out.print("[");
            for (int i = 0; i < players.length; i++) {
                System.out.print("(" + players[i].x + ", " + players[i].y + ")");
                if (i < players.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } catch (Exception e) {
            System.err.println("Error");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Maze extends JFrame {

    int[][] maze =
            {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };

    public List<Integer> path = new ArrayList<>();

    Maze()
    {
        setTitle("Maze Solver");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze, 1, 1, path);
    }

    @Override
    public void paint(Graphics g) {
        g.translate(50,50);
        super.paint(g);
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++)
            {
                Color color;
                switch(maze[i][j])
                {
                    case 1: color = Color.BLACK;
                        // when 1 occurs then it fills black colour
                        break;

                    case 9: color = Color.RED;
                        // when 9 occurs then it fills red colour
                        break;

                    default: color = Color.WHITE;
                        // when 0 occurs then it fills white colour
                        break;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.RED);
                g.drawRect(30*j,30*i,30,30);
            }
        }

        for(int i=path.size()-1; i>=0; i-=2)
        {
            int pathx = path.get(i-1);
            int pathy = path.get(i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            g.setColor(Color.GREEN);
            g.fillRect(30*pathx, 30*pathy,30,30);
        }

    }

    public static void main(String[] args) {
        Maze view = new Maze();
        view.setVisible(true);
    }
}
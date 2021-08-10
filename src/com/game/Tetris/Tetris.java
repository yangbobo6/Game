package com.game.Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tetris extends JFrame implements KeyListener {

    //游戏的行数
    private static final int game_x = 26;
    private static final int game_y = 12;

    //存放文本域的数组
    JTextArea[][] text;
    //每个格子的数组   0代表没有，1代表有
    int[][] data;
    //显示游戏状态标签
    JLabel label;
    //显示游戏分数标签
    JLabel label1;
    //是否启动
    Boolean isRunning;

    public void initWindow(){
        //初始化窗口大小
        this.setSize(600,850);
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置释放窗体  能够关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置标题
        this.setTitle("俄罗斯方块");
        //设置窗口大小不可变
        this.setResizable(false);

    }

    //游戏的主页面  初始化游戏页面
    public void initGamePanel(){
        JPanel game_main = new JPanel();
        //游戏行数列数  水平间距和竖直间距
        game_main.setLayout(new GridLayout(game_x,game_y,1,1));
        //初始化游戏界面
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text[i].length; j++) {
                //设置文本域的行列数 ??????????
                text[i][j] = new JTextArea(game_x,game_y);
                //设置文本域的背景颜色
                text[i][j].setBackground(Color.white);
                //添加键盘监听事件
                text[i][j].addKeyListener(this);
                //初始化游戏边界
                if(j==0 || j==text[i].length-1 || i==text.length-1){
                    text[i][j].setBackground(Color.MAGENTA);
                    data[i][j]=1;
                }
                //设置文本不可编辑
                text[i][j].setEditable(false);
                game_main.add(text[i][j]);
            }
        }
        //添加到窗口中
        this.setLayout(new BorderLayout());
        this.add(game_main,BorderLayout.CENTER);

    }

    public void initExplainPanel(){
        //创建左右说明面板
        Panel game_explain_left = new Panel();
        Panel game_explain_right = new Panel();
        //添加网格
        game_explain_left.setLayout(new GridLayout(4,1));
        game_explain_right.setLayout(new GridLayout(2,1));
        //左边添加文字
        game_explain_left.add(new JLabel("按空格键，方向变形"));
        game_explain_left.add(new JLabel("按左方向键，左移"));
        game_explain_left.add(new JLabel("按右方向键，右移"));
        game_explain_left.add(new JLabel("按下，降落"));
        //设置标签的内容为红色字体
        label.setForeground(Color.red);
        //将游戏的状态标签，分数标签添加到右说明面板 ??????????????? 局部变量和全局变量的问题
        game_explain_right.add(label);
        game_explain_right.add(label1);
        //将设置好的面板添加到左右两侧
        this.add(game_explain_left,BorderLayout.WEST);
        this.add(game_explain_right,BorderLayout.EAST);

    }
    //开始游戏
    public void startGame(){
        while (true){
            //判断游戏是否结束
            if(!isRunning){  //如果false
                break;
            }
            //进行游戏
            game_running();
            //游戏结束
            label.setText("游戏结束");
        }
    }
    //游戏进行的方法
    private void game_running() {

    }

    //无参构造
    public Tetris(){
        text = new JTextArea[game_x][game_y];  //初始化
        data = new int[game_x][game_y];
        label = new JLabel("游戏状态：正在在游戏中");
        label1 = new JLabel("游戏的分为：0");
        initGamePanel();
        initExplainPanel();
        initWindow();  //????????为什么在无参构造添加方法
        isRunning = true;

    }


    //启动项目
    public static void main(String[] args) {
        Tetris tetris = new Tetris();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

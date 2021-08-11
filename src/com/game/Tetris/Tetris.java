package com.game.Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

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
    //用于存储当前方块的数组
    int[] allRect;
    //用于存储方块的变量
    int rect;
    //方块的坐标,起始下落的位置
    int x,y;
    //线程休眠的时间，每下落到底层停顿以下
    int time = 1000;
    //游戏得分
    int score = 0;



    //初始化窗口
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
    //初始化左右两侧的解释界面
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
    public void startGame() throws InterruptedException {
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
    public void game_running() throws InterruptedException {
        //调用方法方块生成
        randomRect();
        //设置初始坐标
        x = 0;
        y = 5;
        for (int i = 0; i < game_x; i++) {
            Thread.sleep(time);
            //判断方块是否可以下落
            if(!canFall(x,y)){    //不能下落

                //data置为1，表示方块占用
                changeData(x,y);
                //循环遍历4层，看看能够消除的行数
                for (int j = x; j < x+4; j++) {
                    //如果列数为满列，则消除
                    int sum = 0;
                    //统计每一行是否为满行  ，统计1的个数
                    for (int k = 0; k <= (game_y-2); k++) {
                        if(data[j][k]==1){
                            sum++;
                        }
                    }
                    //如果为满行，则删除
                    if(sum==(game_y-2)){
                        removeRow(j);
                    }
                }
                //判断游戏是否失败  只需要查看第四行是否有方块  ？？？？？？？？？？ 不封顶就结束
                for (int j = 0; j < (game_y-2); j++) {
                    if(data[3][j]==1){
                        isRunning=false;
                        System.out.println(1);
                        break;
                    }
                }
                break;
            }else {
                //层数加一
                x++;
                //方块下落一格
                fall(x,y);
            }
        }
    }
    //删除行,然后上一行的掉落下来
    public void removeRow(int row) {
        int temp_score = 100;
        //仍然使用此方法  移位的方式进行比对
        for (int i = row; i >1 ; i--) {
            for (int j = 1; j < (game_y-2); j++) {
                data[i+1][j] = data[i][j];
            }
        }
        //刷新游戏区域
        refresh(row);
        //方块加速
        if(time > temp_score){
            time = time - temp_score;
        }
        //得分
        score += temp_score;
        //显示得分
        label1.setText("游戏得分："+score);
    }
    //刷新移除某一行后   的方法
    public void refresh(int row) {
        //遍历row以上的游戏区域   抵消行的上面会发生变化
        for (int i = row; i >1 ; i--) {
            for (int j = 0; j < (game_y-2); j++) {
                if(data[i][j]==1){
                    text[i][j].setBackground(Color.BLUE);
                }else {
                    text[i][j].setBackground(Color.white);
                }
            }
        }
    }
    //判断方块是否能够下落   **难理解  认证看**
    public boolean canFall(int m,int n){
        //定义变量
        int temp = 0x8000;
        //遍历整个4*4的表格
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //用0x8000的不断右移动一位与rect的图形相比较，如果有方块就去判断下一行的data值是否为1 ？？？？？？？？？？？？？
                //判断图形的具体形状，都为1才是1
                if((temp&rect)!=0){
                    //判断该位置的下一行是否有方块  保证每个都能判断到
                    if(data[m+1][n]==1){
                        return false;
                    }
                }
                n++;   //下一行全部判断
                temp >>= 1;  //右移
            }
            m++;
            n = n-4;  // 这两行：列归位，下一行检测
        }
        //可以下落
        return true;
    }

    //改变不可下降的方块的区域和值的方法
    public void changeData(int m, int n) {
        int temp = 0x8000;
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j < 4; j++) {
                if((temp & rect) !=0){
                    data[m][n] = 1;
                }
                n++;
                temp >>= 1;
            }
            m++;
            n = n-4;
        }
    }

    //游戏下落一行
    public void fall(int m,int n){
        if(m>0){
            clear(m-1,n);
        }
        //重新绘制下一个图形
        draw(m,n);
    }

    //清除上一层的方块
    public void clear(int m,int n){
        int temp = 0x8000;
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j < 4; j++) {
                if((temp & rect) !=0){
                    text[m][n].setBackground(Color.white);
                }
                n++;
                temp >>= 1;
            }
            m++;
            n = n-4;
        }
    }
    //重新绘制出现的方块
    public void draw(int m,int n){
        int temp = 0x8000;
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j < 4; j++) {
                if((temp & rect) !=0){
                    text[m][n].setBackground(Color.BLUE);
                }
                n++;
                temp >>= 1;
            }
            m++;
            n = n-4;
        }
    }
    //生成游戏随机下落的方块
    public void randomRect(){
        Random random = new Random();
        rect = allRect[random.nextInt(22)];
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
        allRect = new int[]{0x00cc,0x8888,0x000f,0x888f,0xf888,0xf111,0x111f,0xffff,0x0008,
                0x0888,0x000e,0x0088,0x000c,0x08c8,0x00e4,0x04c4,0x004e,0x08c4,
                0x006c,0x04c8,0x00c6};  //设置图形所有的形状
        


    }


    //启动项目
    public static void main(String[] args) throws InterruptedException {
        Tetris tetris = new Tetris();
        tetris.game_running();
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

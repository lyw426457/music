import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Musicdao {
    public List<Music> findMusic(String username) throws SQLException, ClassNotFoundException {
        List<Music> musics = new ArrayList<>();
        Connection connection = Dbutil.getConnection();
        String sql = "select * from musicinfo where muser = '"+username+"'";
        /*PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,username);*/
        //上面的代码带有sql注入问题
        Statement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Music music = new Music();
            music.setId(resultSet.getInt(1));
            music.setName(resultSet.getString(2));
            music.setSinger(resultSet.getString(3));
            music.setMtype(resultSet.getString(4));
            musics.add(music);
        }
        Dbutil.Closeall(resultSet,statement,connection);
        return musics;
    }


//新增
    public void songinsert (String name,String author,String mtype, String username) throws SQLException, ClassNotFoundException {
        Connection connection = Dbutil.getConnection();
        String sql = "insert into musicinfo (mname,msinger,mtype,muser) values (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setString(2,author);
        statement.setString(3,mtype);
        statement.setString(4,username);
        statement.executeUpdate();
        Dbutil.Closeall(null,statement,connection);
    }
    /*public void idinsert (String id, String name,String author) throws SQLException, ClassNotFoundException {
        Connection connection = Dbutil.getConnection();
        String sql = "insert into musicinfo (mid,mname,msinger) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,id);
        statement.setString(2,name);
        statement.setString(3,author);
        statement.executeUpdate();
        Dbutil.Closeall(null,statement,connection);
    }*/


//删除
    public void songdelete(String song) throws SQLException, ClassNotFoundException {
        Connection connection = Dbutil.getConnection();
        String sql = "delete from musicinfo where mname = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,song);
        statement.executeUpdate();
        Dbutil.Closeall(null,statement,connection);
    }
    public void iddelete(int id) throws SQLException, ClassNotFoundException {
        Connection connection = Dbutil.getConnection();
        String sql = "delete from musicinfo where mname = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.executeUpdate();
        Dbutil.Closeall(null,statement,connection);
    }


//修改
    public void songupdate(int id,String name,String songer,String type ) throws SQLException, ClassNotFoundException {
        Connection connection = Dbutil.getConnection();
        String sql = "update musicinfo set mname = ?,msinger = ?,mtype = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setString(2,songer);
        statement.setString(3,type);
        statement.setInt(4,id);
        statement.executeUpdate();
        Dbutil.Closeall(null,statement,connection);
    }
    public void songexport(String music) throws IOException {
        System.out.println("1.输入导出文件名和导出路径 2.使用默认导出名和路径");
        Scanner input = new Scanner(System.in);
        int temp = input.nextInt();
        switch (temp){
            case 1:
                System.out.println("请输入文件名：");
                Scanner input3 = new Scanner(System.in);
                String filename = input3.nextLine();
                System.out.println("请输入到处路径");
                Scanner input4 = new Scanner(System.in);
                String path1 = input4.nextLine();
                path1 += "\\"+filename +".txt";
                System.out.println(path1);
                File file = new File(path1);
                if(!file.exists()){
                    file.getParentFile().mkdir();
                }
                file.createNewFile();
                OutputStreamWriter fw1 = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
                BufferedWriter bw1 = new BufferedWriter(fw1);
                bw1.write(music);
                bw1.flush();
                bw1.close();
                fw1.close();
                break;
            case 2:
                /*System.out.println("请输入文件名：");
                Scanner input6 = new Scanner(System.in);
                String filenam = input6.nextLine();*/
                Date day = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
                String  filenam = df.format(day);
                // 生成的文件路径
                String path = "D:\\JAVAproject\\project02\\import\\" + filenam + ".txt";
                File file2 = new File(path);
                if (!file2.exists()) {
                    file2.getParentFile().mkdirs();
                }
                file2.createNewFile();
                // write 解决中文乱码问题
                // FileWriter fw = new FileWriter(file, true);
                OutputStreamWriter fw2 = new OutputStreamWriter(new FileOutputStream(file2), "UTF-8");
                BufferedWriter bw2 = new BufferedWriter(fw2);
                bw2.write(music);
                bw2.flush();
                bw2.close();
                fw2.close();
        }
    }
}

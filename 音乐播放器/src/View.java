import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        boolean flag = true;
        while(flag){
            //输入用户名
            System.out.println("----音乐播放管理软件----");
            System.out.println("1.登录 2.注册 3.关闭");
            Scanner input = new Scanner(System.in);
            int tempt = input.nextInt();
            switch (tempt){
                case 1:
                    System.out.println("请输入你的用户名：");
                    Scanner input1 = new Scanner(System.in);
                    String username =input1.nextLine();
                    //输入密码
                    System.out.println("请输入你的密码：");
                    Scanner input2 = new Scanner(System.in);
                    String userpwd = input2.nextLine();
                    //查询数据库中是否存在该用户
                    Userdao userdao = new Userdao();
                    User user = userdao.Findpwd(username);
                    //不存在则注册
                    if (user == null){
                        System.out.println("----该用户还未注册，请先注册----");
                        System.out.println("请输入注册id：");
                        String uid = input1.nextLine();
                        System.out.println("请输入注册名：");
                        String uname = input1.nextLine();
                        System.out.println("请输入注册密码：");
                        String upwd = input1.nextLine();
                        System.out.println("请输入注册昵称：");
                        String unickname = input1.nextLine();
                        System.out.println("请输入注册生日：");
                        String udate = input1.nextLine();
                        System.out.println("请输入注册签名：");
                        String usign = input1.nextLine();
                        userdao.zhuce(uid,uname,upwd,unickname,udate,usign);
                        System.out.println("----注册成功----");
                    }
                    else if(user.getUserpwd().equals(userpwd)){
                        System.out.println("----欢迎来到音乐播放管理软件----");
                        flag = false;
                        musicSystem(user);
                    }
                    else{
                        System.out.println("登陆失败");
                    }
                    break;
                case 2:
                    Userdao userdao1 = new Userdao();
                    System.out.println("请输入注册id:");
                    Scanner input12 = new Scanner(System.in);
                    String zhuceid = input12.nextLine();
                    System.out.println("请输入注册名：");
                    Scanner input13 = new Scanner(System.in);
                    String zhucename = input13.nextLine();
                    System.out.println("请输入注册密码:");
                    Scanner input14 = new Scanner(System.in);
                    String zhucepwd = input14.nextLine();
                    System.out.println("请输入注册昵称：");
                    Scanner input15 = new Scanner(System.in);
                    String zhucenk = input15.nextLine();
                    System.out.println("请输入注册生日：");
                    Scanner input16 = new Scanner(System.in);
                    String zhucebirth = input16.nextLine();
                    System.out.println("请输入注册签名：");
                    Scanner input17 = new Scanner(System.in);
                    String zhucesign = input17.nextLine();
                    userdao1.zhuce(zhuceid,zhucename,zhucepwd,zhucenk,zhucebirth,zhucesign);
                    System.out.println("----注册成功----");
                    break;
                case 3:
                    System.out.println("----退出成功----");
                    break;
            }
            break;
        }
    }

    private static void musicSystem(User user) throws SQLException, ClassNotFoundException, IOException {
        System.out.println("1.音乐查询 2.音乐添加 3.音乐删除 4.音乐更改 5.音乐导出 6.导入音乐 7.用户信息修改 8.播放音乐 9.关闭");
        Scanner input = new Scanner(System.in);
        int temp = input.nextInt();
        Musicdao musicdao = new Musicdao();
        Userdao userdao = new Userdao();
        switch (temp){
            case 1:
                //音乐查询
                List<Music> musics = musicdao.findMusic(user.getUsername());
                System.out.println(musics.toString().replace("["," ").replace("]","").replace(",",""));
                System.out.println("----查询完毕----");
                break;
            case 2:
                //音乐添加
                /*if(user.getSignature() != null){
                    System.out.println("无法操作");
                    break;
                }
                else {*/
                    System.out.println("请输入要添加的音乐信息:");
                    System.out.println("音乐名:");
                    Scanner input3 = new Scanner(System.in);
                    String mname = input3.nextLine();
                    System.out.println("歌手名:");
                    Scanner input4 = new Scanner(System.in);
                    String msinger = input4.nextLine();
                    System.out.println("音乐类型:");
                    Scanner input11 = new Scanner(System.in);
                    String mtype = input11.nextLine();
                    musicdao.songinsert(mname,msinger,mtype,user.getUsername());
                    System.out.println("----添加完成----");
                    break;
               // }
            case 3:
                //音乐删除
                if(user.getSignature() != null){
                    System.out.println("无法操作");
                    break;
                }
                System.out.println("输入要删除的音乐编号:");
                Scanner input5 = new Scanner(System.in);
                int id = input5.nextInt();
                musicdao.iddelete(id);
                System.out.println("----删除完毕----");
                break;
            case 4:
                //音乐修改
                if(user.getSignature() != null){
                    System.out.println("无法操作");
                    break;
                }
                System.out.println("输入要修改歌曲的id:");
                Scanner input6 = new Scanner(System.in);
                int ID = input6.nextInt();
                System.out.println("请输入新的音乐名:");
                Scanner input7 = new Scanner(System.in);
                String NAME = input7.nextLine();
                System.out.println("请输入新的歌手:");
                Scanner input8 = new Scanner(System.in);
                String SINGER = input8.nextLine();
                System.out.println("请输入新的音乐类型:");
                Scanner input9 = new Scanner(System.in);
                String TYPE = input9.nextLine();
                musicdao.songupdate(ID,NAME,SINGER,TYPE);
                System.out.println("----修改完毕----");
                break;
            case 5:
                List<Music> musicss = musicdao.findMusic(user.getUsername());
                String a =musicss.toString().replace("["," ").replace("]","").replace(",","");
                musicdao.songexport(a);
                System.out.println("----导出完成----");
                break;
            case 6:
                System.out.println("请输入要导入的文件路径：");
                Scanner inputf = new Scanner(System.in);
                String path2 = inputf.nextLine();
                File file = new File(path2);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String pre = null;
                while((pre = br.readLine()) != null){
                    String[] arr = pre.split("--|:");
                    musicdao.songinsert(arr[0],arr[1],arr[2], user.getUsername());
                }
                System.out.println("----导入成功----");
                break;
            case 7:
                System.out.println("请输入要修改的用户名：");
                Scanner inputa = new Scanner(System.in);
                String username = inputa.nextLine();
                System.out.println("请输入要修改的用户密码：");
                Scanner inputb = new Scanner(System.in);
                String userpwd = inputb.nextLine();
                System.out.println("请输入要修改的用户昵称：");
                Scanner inputd = new Scanner(System.in);
                String nickname = inputd.nextLine();
                System.out.println("请输入要修改的用户生日：");
                Scanner inpute = new Scanner(System.in);
                String birth = inpute.nextLine();
                System.out.println("请输入要修改的用户签名：");
                Scanner inputg = new Scanner(System.in);
                String signature = inputg.nextLine();
                userdao.update(username,userpwd,nickname,birth,signature);
                System.out.println("----修改完成----");
                break;
            case 8:
                System.out.println("请输入要播放的歌曲名：");
                Scanner inputz = new Scanner(System.in);
                String songname = inputz.nextLine();
                List<Music> temp2 = musicdao.findMusic(songname);
                if(temp2!=null){
                    System.out.println("正在播放"+songname);
                }
                else{
                    System.out.println("歌单中不存在该歌曲");
                }
                break;
            case 9:
                System.out.println("----退出成功----");
                break;

        }
    }
}

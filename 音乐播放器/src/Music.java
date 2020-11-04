public class Music {
    private int id;
    private String name;
    private String singer;
    private String mtype;
    private String muser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getMuser() {
        return muser;
    }

    public void setMuser(String muser) {
        this.muser = muser;
    }

    public Music(int id, String name, String singer, String mtype, String muser) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.mtype = mtype;
        this.muser = muser;
    }

    public Music() {

    }


    public String toString(){
        return "Music:"+"名称:"+name+"--"+"歌手:"+singer+"--"+"歌曲类别:"+mtype+'\n';
    }


}

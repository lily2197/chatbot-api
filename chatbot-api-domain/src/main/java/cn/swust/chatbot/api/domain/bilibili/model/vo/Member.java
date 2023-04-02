package cn.swust.chatbot.api.domain.bilibili.model.vo;
public class Member
{
    private String mid;

    private String uname;

    private String sex;

    private String sign;

    private String avatar;

    private String rank;

    private int face_nft_new;

    private int is_senior_member;
    private String fans_detail;

    private boolean is_contractor;

    private String contract_desc;

    private String nft_interaction;

    public void setMid(String mid){
        this.mid = mid;
    }
    public String getMid(){
        return this.mid;
    }
    public void setUname(String uname){
        this.uname = uname;
    }
    public String getUname(){
        return this.uname;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return this.sex;
    }
    public void setSign(String sign){
        this.sign = sign;
    }
    public String getSign(){
        return this.sign;
    }
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }
    public String getAvatar(){
        return this.avatar;
    }
    public void setRank(String rank){
        this.rank = rank;
    }
    public String getRank(){
        return this.rank;
    }
    public void setFace_nft_new(int face_nft_new){
        this.face_nft_new = face_nft_new;
    }
    public int getFace_nft_new(){
        return this.face_nft_new;
    }
    public void setIs_senior_member(int is_senior_member){
        this.is_senior_member = is_senior_member;
    }
    public int getIs_senior_member(){
        return this.is_senior_member;
    }
    public void setFans_detail(String fans_detail){
        this.fans_detail = fans_detail;
    }
    public String getFans_detail(){
        return this.fans_detail;
    }
    public void setIs_contractor(boolean is_contractor){
        this.is_contractor = is_contractor;
    }
    public boolean getIs_contractor(){
        return this.is_contractor;
    }
    public void setContract_desc(String contract_desc){
        this.contract_desc = contract_desc;
    }
    public String getContract_desc(){
        return this.contract_desc;
    }
    public void setNft_interaction(String nft_interaction){
        this.nft_interaction = nft_interaction;
    }
    public String getNft_interaction(){
        return this.nft_interaction;
    }
}

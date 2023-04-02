package cn.swust.chatbot.api.domain.bilibili.model.vo;

public class Replies
{
    private String rpid;

    private String oid;

    private int type;

    private String mid;

    private String root;

    private String parent;

    private int dialog;

    private int count;

    private int rcount;

    private int state;

    private int fansgrade;

    private int attr;

    private String ctime;

    private String rpid_str;

    private String root_str;

    private String parent_str;

    private int like;

    private int action;

    private Member member;

    private Content content;

    private String replies;

    private int assist;

    private boolean invisible;


    private String dynamic_id_str;

    public void setType(int type){
        this.type = type;
    }
    public int getType(){
        return this.type;
    }
    public void setDialog(int dialog){
        this.dialog = dialog;
    }
    public int getDialog(){
        return this.dialog;
    }
    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setRcount(int rcount){
        this.rcount = rcount;
    }
    public int getRcount(){
        return this.rcount;
    }
    public void setState(int state){
        this.state = state;
    }
    public int getState(){
        return this.state;
    }
    public void setFansgrade(int fansgrade){
        this.fansgrade = fansgrade;
    }
    public int getFansgrade(){
        return this.fansgrade;
    }
    public void setAttr(int attr){
        this.attr = attr;
    }
    public int getAttr(){
        return this.attr;
    }
    public void setRpid_str(String rpid_str){
        this.rpid_str = rpid_str;
    }
    public String getRpid_str(){
        return this.rpid_str;
    }
    public void setRoot_str(String root_str){
        this.root_str = root_str;
    }
    public String getRoot_str(){
        return this.root_str;
    }
    public void setParent_str(String parent_str){
        this.parent_str = parent_str;
    }
    public String getParent_str(){
        return this.parent_str;
    }
    public void setLike(int like){
        this.like = like;
    }
    public int getLike(){
        return this.like;
    }
    public void setAction(int action){
        this.action = action;
    }
    public int getAction(){
        return this.action;
    }
    public void setMember(Member member){
        this.member = member;
    }
    public Member getMember(){
        return this.member;
    }
    public void setContent(Content content){
        this.content = content;
    }
    public Content getContent(){
        return this.content;
    }
    public void setReplies(String replies){
        this.replies = replies;
    }
    public String getReplies(){
        return this.replies;
    }
    public void setAssist(int assist){
        this.assist = assist;
    }
    public int getAssist(){
        return this.assist;
    }

    public void setInvisible(boolean invisible){
        this.invisible = invisible;
    }
    public boolean getInvisible(){
        return this.invisible;
    }
    public void setDynamic_id_str(String dynamic_id_str){
        this.dynamic_id_str = dynamic_id_str;
    }
    public String getDynamic_id_str(){
        return this.dynamic_id_str;
    }

    public String getRpid() {
        return rpid;
    }

    public void setRpid(String rpid) {
        this.rpid = rpid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public boolean isInvisible() {
        return invisible;
    }
}

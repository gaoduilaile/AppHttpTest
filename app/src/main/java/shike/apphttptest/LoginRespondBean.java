package shike.apphttptest;

/**
 * Created by Administrator on 2017/7/26.
 */

public class LoginRespondBean {

    /**
     * data : {"account":"13783539375","createtime":2107331264,"id":17,"isRecommend":0,"password":"MTIz","token":"MTM3ODM1MzkzNzUxNTAxMDUwOTE3NTY4"}
     * status : 200
     */

    private DataBean data;
    private int status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * account : 13783539375
         * createtime : 2107331264
         * id : 17
         * isRecommend : 0
         * password : MTIz
         * token : MTM3ODM1MzkzNzUxNTAxMDUwOTE3NTY4
         */

        private String account;
        private int createtime;
        private int id;
        private int isRecommend;
        private String password;
        private String token;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public int getCreatetime() {
            return createtime;
        }

        public void setCreatetime(int createtime) {
            this.createtime = createtime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(int isRecommend) {
            this.isRecommend = isRecommend;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}

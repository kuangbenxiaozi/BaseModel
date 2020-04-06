package com.pioneer.base.model;

import com.pioneer.base.network.model.BaseModel;

import java.util.List;

public class HomeModel extends BaseModel {
    private int total;
    private List<PictureItem> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PictureItem> getList() {
        return list;
    }

    public void setList(List<PictureItem> list) {
        this.list = list;
    }

    public static class PictureItem {
        private String id;
        private String img;
        private String title;
        private String link;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}

package com.dogukandemirel.workshopapp;

    public class Post {

         String postId;
         String userId;
         String text;
        String timestamp;
        int photoResource;

        public Post() {

        }

        public Post(String postId, String userId, String text, String timestamp) {
            this.postId = postId;
            this.userId = userId;
            this.text = text;
            this.timestamp = timestamp;
        }

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public int getPhotoResource() {
            return photoResource;
        }

        public void setPhotoResource(int photoResource) {
            this.photoResource = photoResource;
        }
    }


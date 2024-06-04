package com.example.donate.Model;

    public class User {
        private String name;
        private String email;
        private String items;
        private String date;

        public User() {
        }

        public User(String name, String email, String items, String date) {
            this.name = name;
            this.email = email;
            this.items = items;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getItems() {
            return items;
        }

        public void setItems(String items) {
            this.items = items;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }


